package online_recruitment.models;

import online_recruitment.Utils;
import java.util.List;

public class Job {
	public int id;
	public double salary;
	public String name, company, address, description;
	public List<String> skills;

	public Job(int id, double salary, String name, String company, String address, String description, List<String> skills) {
		this.id = id;
		this.salary = salary;
		this.name = name;
		this.company = company;
		this.address = address;
		this.description = description;
		this.skills = skills;
	}

	public Job(double salary, String name, String company, String address, String description, List<String> skills) {
		this.salary = salary;
		this.name = name;
		this.company = company;
		this.address = address;
		this.description = description;
		this.skills = skills;
	}

	@Override
	public String toString() {
		return "Job{" +
				"jobId=" + id +
				", salary=" + salary +
				", jobName='" + name + '\'' +
				", company='" + company + '\'' +
				", address='" + address + '\'' +
				", description='" + description + '\'' +
				", skills='" + Utils.listToString(skills) + '\'' +
				'}';
	}
}
