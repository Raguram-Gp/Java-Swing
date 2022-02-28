package online_recruitment.database;

import jdk.nashorn.internal.scripts.JO;
import online_recruitment.Utils;
import online_recruitment.models.Application;
import online_recruitment.models.Job;
import online_recruitment.models.User;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Properties;

public class MySqlCon{
	private Connection connection;
	private Statement stmt;
	public MySqlCon(){
		try {
			InputStream input = new FileInputStream("src/online_recruitment/database/database.properties");
			Class.forName("com.mysql.cj.jdbc.Driver");
			Properties info = new Properties();
			info.load(input);
			connection = DriverManager.getConnection(info.getProperty("url"),
					info.getProperty("user"), info.getProperty("pass"));
			stmt = connection.createStatement();

		} catch (IOException | SQLException | ClassNotFoundException exception ) {
			exception.printStackTrace();
		}
	}

	public User getUser(String name, String pass){
		try{
			PreparedStatement st = connection
					.prepareStatement(String.format("Select * from users where name='%s' AND pass='%s'", name, pass));
			ResultSet rs = st.executeQuery();
			if (rs.next()) {
				return new User(rs.getInt("id"), rs.getString("name"), rs.getString("email"), rs.getBoolean("superuser"), rs.getString("pass"));
			}else{
				return null;
			}
		}catch (SQLException exception){
			exception.printStackTrace();
		}
		return null;
	}

	public User postUser(User user){
		try{
			String query = String.format("insert into users (name, email, superuser, pass) values ('%s', '%s', %d, '%s');", user.name, user.email, 0, user.pass);
			stmt.executeUpdate(query);
			PreparedStatement st = connection
					.prepareStatement(String.format("Select * from users where name='%s' AND pass='%s'", user.name, user.pass));
			ResultSet rs = st.executeQuery();
			if (rs.next()) {
				return new User(rs.getInt("id"), rs.getString("name"), rs.getString("email"), rs.getBoolean("superuser"), rs.getString("pass"));
			}else{
				return null;
			}
		}catch (SQLException exception){
			exception.printStackTrace();
		}
		return null;
	}

	public List<Job> getJobs(){
		List<Job> jobs = new ArrayList<Job>();
		try{
			PreparedStatement st = connection
					.prepareStatement("Select * from jobs");
			ResultSet rs = st.executeQuery();
			while (rs.next()) {
				jobs.add(new Job(rs.getInt("id"), rs.getInt("salary"), rs.getString("name"), rs.getString("company"), rs.getString("address"), rs.getString("description"), Utils.stringToList(rs.getString("skills"))));
			}
		}catch (SQLException exception){
			exception.printStackTrace();
		}
		return jobs;
	}

	public Job getJob(int jobid){
		try{
			PreparedStatement st = connection
					.prepareStatement(String.format("Select * from jobs where id=%d",jobid));
			ResultSet rs = st.executeQuery();
			if (rs.next()) {
				return new Job(rs.getInt("id"), rs.getInt("salary"), rs.getString("name"), rs.getString("company"), rs.getString("address"), rs.getString("description"), Utils.stringToList(rs.getString("skills")));
			}
		}catch (SQLException exception){
			exception.printStackTrace();
		}
		return null;
	}

	public User getUser(int userid){
		try{
			PreparedStatement st = connection
					.prepareStatement(String.format("Select * from users where id=%d",userid));
			ResultSet rs = st.executeQuery();
			if (rs.next()) {
				return new User(rs.getInt("id"), rs.getString("name"), rs.getString("email"), rs.getBoolean("superuser"), rs.getString("pass"));
			}
		}catch (SQLException exception){
			exception.printStackTrace();
		}
		return null;
	}

	public List<Application> getAppliedJobs(User user){
		List<Application> applications = new ArrayList<>();
		try{
			PreparedStatement st = connection
					.prepareStatement(String.format("Select * from applications where userid=%d", user.id));
			ResultSet rs = st.executeQuery();
			while (rs.next()) {
				applications.add(new Application(rs.getInt("id"),user, getJob(rs.getInt("jobid")), rs.getString("name"), rs.getString("email"), rs.getInt("age"), rs.getString("mobile"), rs.getString("qualification"), rs.getString("specification"), rs.getString("skills"), rs.getString("gender"), rs.getString("address")));
			}
		}catch (SQLException exception){
			exception.printStackTrace();
		}
		return applications;
	}

	public List<Application> getApplications(){
		List<Application> applications = new ArrayList<>();
		try{
			PreparedStatement st = connection
					.prepareStatement("Select * from applications");
			ResultSet rs = st.executeQuery();
			while (rs.next()) {
				applications.add(new Application(rs.getInt("id"),getUser(rs.getInt("userid")), getJob(rs.getInt("jobid")), rs.getString("name"), rs.getString("email"), rs.getInt("age"), rs.getString("mobile"), rs.getString("qualification"), rs.getString("specification"), rs.getString("skills"), rs.getString("gender"), rs.getString("address")));
			}
		}catch (SQLException exception){
			exception.printStackTrace();
		}
		return applications;
	}

	public void postJob(Job job){
		try{
			System.out.println(job);
			String query = String.format("insert into jobs (name, company, address, salary, description, skills) values ( '%s','%s', '%s', %.2f, '%s', '%s')", job.name, job.company, job.address, job.salary, job.description, Utils.listToString(job.skills));
			stmt.executeUpdate(query);
		}catch (SQLException exception){
			exception.printStackTrace();
		}
	}

	public void postApplication(Application application){
		try{
			System.out.println(application);
			String query = String.format("insert into applications (userid, jobid, name, email, age, mobile, qualification, specification, skills, gender, address) values ( '%d','%d', '%s', '%s', %d, '%s', '%s', '%s', '%s', '%s', '%s')", application.user.id, application.job.id, application.name, application.email, application.age, application.mobile, application.qualification, application.specification, application.skills, application.gender, application.address);
			stmt.executeUpdate(query);
		}catch (SQLException exception){
			exception.printStackTrace();
		}
	}
}