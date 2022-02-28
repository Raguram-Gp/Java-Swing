package online_recruitment.screens.super_user;

import online_recruitment.Styles;
import online_recruitment.Utils;
import online_recruitment.database.MySqlCon;
import online_recruitment.models.Application;
import online_recruitment.models.Job;
import online_recruitment.models.User;
import online_recruitment.screens.login.LoginPage;
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.List;

public class SuperUserPage{
	private JPanel jJobsPane, jProfilePane, jPostJobPane, jApplicationPane;
	private JTabbedPane jTabbedPane;
	private JFrame frame;
	private MySqlCon mySqlCon;
	private User user;
	Color lightBlue = new Color(193, 241, 247);


	public SuperUserPage(User user, MySqlCon mySqlCon){
		this.user = user;
		this.mySqlCon = mySqlCon;
		frame = new JFrame();
		frame.setTitle("Super user page");
		jJobsPane = new JPanel();
		jJobsPane.setBackground(Color.white);
		jProfilePane = new JPanel();
		jProfilePane.setBackground(Color.white);
		jPostJobPane = new JPanel();
		jApplicationPane = new JPanel();
		jApplicationPane.setBackground(Color.white);
		getProfileCard(jProfilePane);
		getPostJobPanel(jPostJobPane);
		jTabbedPane = new JTabbedPane();
		jJobsPane.setLayout(new GridLayout(10,1, 10, 10));
		List<JPanel> jobList = getJobPanels();
		for (JPanel jPanel : jobList) {
			jJobsPane.add(jPanel);
		}
		jApplicationPane.setLayout(new GridLayout(10,1,10,10));
		List<JPanel> applicationPane = getApplicationPane();
		for(JPanel jPanel : applicationPane){
			jApplicationPane.add(jPanel);
		}
		JScrollPane jobsScrollPane = new JScrollPane(jJobsPane);
		jobsScrollPane.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_AS_NEEDED);
		jobsScrollPane.setBackground(Color.white);
		JScrollPane applicationsScrollPane = new JScrollPane(jApplicationPane);
		applicationsScrollPane.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_AS_NEEDED);
		applicationsScrollPane.setBackground(Color.white);
		JScrollPane postJobScrollPane = new JScrollPane(jPostJobPane);
		postJobScrollPane.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_ALWAYS);
		postJobScrollPane.setBackground(Color.white);
		postJobScrollPane.setSize(900, 800);
		jTabbedPane.add("Jobs", jobsScrollPane);
		jTabbedPane.add("Post Job", postJobScrollPane);
		jTabbedPane.add("Applications", applicationsScrollPane);
		jTabbedPane.add("Profile", jProfilePane);
		frame.add(jTabbedPane);
		frame.setSize(900, 800);
		frame.setVisible(true);
	}

	private static ImageIcon createImageIcon(String path,
	                                         String description) {
		java.net.URL imgURL = SuperUserPage.class.getResource(path);

		if (imgURL != null) {
			return new ImageIcon(imgURL, description);
		} else {
			System.err.println("Couldn't find file: " + path);
			return null;
		}
	}

	private void getProfileCard(JPanel panel){
		JLabel profileLabel, nameLabel, emailLabel, idLabel;
		JButton editButton, signOutButton;


		panel.setLayout(null);
		ImageIcon profileIcon = createImageIcon("/online_recruitment/man.jpg", "Profile");
		profileLabel = new JLabel("", profileIcon,JLabel.CENTER);
		profileLabel.setBounds(386,50, 128, 128);
		panel.add(profileLabel);
		idLabel = new JLabel("Id : "+ this.user.id, JLabel.CENTER);
		idLabel.setFont(Styles.SUBTITLE_FONT);
		idLabel.setBounds(0, 200, 900, 25);
		panel.add(idLabel);
		nameLabel = new JLabel("Name : " + this.user.name, JLabel.CENTER);
		nameLabel.setFont(Styles.SUBTITLE_FONT);
		nameLabel.setBounds(0, 225, 900, 25);
		panel.add(nameLabel);
		emailLabel = new JLabel("Email : " + this.user.email, JLabel.CENTER);
		emailLabel.setFont(Styles.SUBTITLE_FONT);
		emailLabel.setBounds(0, 250, 900, 25);
		panel.add(emailLabel);

//		editButton = new JButton("Edit Profile");
//		editButton.setBounds(400, 350, 100, 50);
//		panel.add(editButton);
		signOutButton = new JButton("Sign out");
		signOutButton.setBounds(400, 410, 100, 50);
		panel.add(signOutButton);

//		editButton.addActionListener(new ActionListener() {
//			@Override
//			public void actionPerformed(ActionEvent e) {
//				System.out.println("Edit clicked");
//			}
//		});

		signOutButton.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				frame.dispose();
				new LoginPage(mySqlCon);
			}
		});
	}


	private void getPostJobPanel(JPanel panel){
		JLabel titleLabel,nameLabel, skillsLabel, companyLabel, addressLabel, salaryLabel, descriptionLabel;
		JTextField nameText, companyText, salaryText;
		JTextArea addressText, descriptionText;
		JCheckBox pythonCheck, javaCheck, cCheck, nodeCheck, angularCheck, reactCheck, swingCheck, djangoCheck, mySqlCheck, kotlinCheck, flutterCheck;
		JButton submitButton;

		panel.setLayout(null);
		titleLabel = new JLabel("Post Job", JLabel.CENTER);
		titleLabel.setBounds(0, 0, 900, 50);
		titleLabel.setFont(Styles.TITLE_FONT);
		panel.add(titleLabel);


		nameLabel = new JLabel("Job Name :");
		nameLabel.setBounds(150, 60, 80, 25);
		nameText = new JTextField(20);
		nameText.setBounds(300, 60, 300, 25);
		panel.add(nameLabel);
		panel.add(nameText);

		companyLabel = new JLabel("Company :");
		companyLabel.setBounds(150, 90, 80, 25);
		companyText = new JTextField(30);
		companyText.setBounds(300, 90, 300, 25);
		panel.add(companyLabel);
		panel.add(companyText);

		salaryLabel = new JLabel("Salary :");
		salaryLabel.setBounds(150, 120, 80, 25);
		salaryText = new JTextField();
		salaryText.setBounds(300, 120, 300, 25);
		panel.add(salaryLabel);
		panel.add(salaryText);


		skillsLabel = new JLabel("Skills :");
		skillsLabel.setBounds(150, 150, 100, 25);
		swingCheck = new JCheckBox("Java Swing");
		swingCheck.setBounds(300, 150, 300, 25);
		pythonCheck = new JCheckBox("Python");
		pythonCheck.setBounds(300, 180, 300, 25);
		javaCheck = new JCheckBox("Java");
		javaCheck.setBounds(300, 210, 300, 25);
		kotlinCheck = new JCheckBox("Kotlin");
		kotlinCheck.setBounds(300, 240, 300, 25);
		flutterCheck = new JCheckBox("Flutter");
		flutterCheck.setBounds(300, 270, 300, 25);
		cCheck = new JCheckBox("C");
		cCheck.setBounds(300, 300, 300, 25);
		nodeCheck = new JCheckBox("Node JS");
		nodeCheck.setBounds(300, 330, 300, 25);
		angularCheck = new JCheckBox("Angular JS");
		angularCheck.setBounds(300, 360, 300, 25);
		reactCheck = new JCheckBox("React JS");
		reactCheck.setBounds(300, 390, 300, 25);
		djangoCheck = new JCheckBox("Django");
		djangoCheck.setBounds(300, 420, 300, 25);
		mySqlCheck = new JCheckBox("MySql");
		mySqlCheck.setBounds(300, 450, 300, 25);
		panel.add(skillsLabel);
		panel.add(swingCheck);
		panel.add(pythonCheck);
		panel.add(javaCheck);
		panel.add(kotlinCheck);
		panel.add(flutterCheck);
		panel.add(cCheck);
		panel.add(nodeCheck);
		panel.add(angularCheck);
		panel.add(reactCheck);
		panel.add(djangoCheck);
		panel.add(mySqlCheck);


		addressLabel = new JLabel("Address :");
		addressLabel.setBounds(150, 480, 80, 25);
		addressText = new JTextArea();
		addressText.setBounds(300, 480, 300, 75);
		panel.add(addressLabel);
		panel.add(addressText);

		descriptionLabel = new JLabel("Description :");
		descriptionLabel.setBounds(150, 560, 80, 25);
		descriptionText = new JTextArea();
		descriptionText.setBounds(300, 560, 300, 75);
		panel.add(descriptionLabel);
		panel.add(descriptionText);


		submitButton = new JButton("Submit");
		submitButton.setBounds(350, 670, 100, 25);
		submitButton.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				String title, company, address, description;
				float salary;
				List<String> skills = new ArrayList<>();
				title = nameText.getText();
				company = companyText.getText();
				address = addressText.getText();
				description = descriptionText.getText();
				if(title.equals("") || company.equals("") || address.equals("") || description.equals("")){
					showErrorMessage("Please fill all the fields!!");
					return;
				}
				try {
					salary = Float.parseFloat(salaryText.getText());
				}catch (Exception ex){
					showErrorMessage("Please give proper value for salary");
					return;
				}
				if (pythonCheck.isSelected()) skills.add(pythonCheck.getText());
				if (javaCheck.isSelected()) skills.add(javaCheck.getText());
				if(cCheck.isSelected()) skills.add(cCheck.getText());
				if(nodeCheck.isSelected()) skills.add(nodeCheck.getText());
				if(angularCheck.isSelected()) skills.add(angularCheck.getText());
				if(reactCheck.isSelected()) skills.add(reactCheck.getText());
				if(swingCheck.isSelected()) skills.add(swingCheck.getText());
				if(djangoCheck.isSelected()) skills.add(djangoCheck.getText());
				if(mySqlCheck.isSelected()) skills.add(mySqlCheck.getText());
				if (flutterCheck.isSelected()) skills.add(flutterCheck.getText());
				if (kotlinCheck.isSelected()) skills.add(kotlinCheck.getText());

				if(skills.size() ==0){
					showErrorMessage("Please select atleast one skill!!");
					return;
				}

				if(skills.size() >=5){
					showErrorMessage("You can select no more than 4 skills!!");
					return;
				}
				mySqlCon.postJob(new Job(salary, title, company, address, description, skills));
				showSuccessMessage("Job created successfully");
			}
		});
		panel.add(submitButton);
	}

	private void showErrorMessage(String message){
		JOptionPane.showMessageDialog(frame, message,
				"Error", JOptionPane.ERROR_MESSAGE);
	}

	private void showSuccessMessage(String message){
		int option = JOptionPane.showOptionDialog(frame, message, "Success", JOptionPane.OK_CANCEL_OPTION, JOptionPane.INFORMATION_MESSAGE, null, new String[]{"Ok"}, "OK");
		if(option == JOptionPane.OK_OPTION){
			frame.dispose();
			new SuperUserPage(user, mySqlCon);
		}
	}


	private List<JPanel> getJobPanels(){
		List<JPanel> panels = new ArrayList<>();
		List<Job> jobs = mySqlCon.getJobs();
		for(Job job: jobs){
			JPanel panel = new JPanel();
			panel.setBackground(lightBlue);
			panel.setLayout(new BoxLayout(panel, BoxLayout.Y_AXIS));
			panel.setBorder( BorderFactory.createLineBorder(Color.black));
			JLabel nameLabel = new JLabel(String.format("%d. %s", job.id, job.name));
			nameLabel.setFont(Styles.TITLE_FONT);
			nameLabel.setForeground(Color.BLACK);
			JLabel companyLabel = new JLabel(job.company);
			companyLabel.setFont(Styles.SUBTITLE_FONT);
			companyLabel.setForeground(Color.black);
			JLabel salaryLabel = new JLabel("Salary : Rs." + job.salary);
			salaryLabel.setForeground(Color.black);
			salaryLabel.setFont(Styles.Salary_FONT);
			JLabel skillsLabel = new JLabel("Skills : " + Utils.listToString(job.skills));
			skillsLabel.setFont(Styles.SKILLS_FONT);
			skillsLabel.setForeground(Color.black);
			panel.add(nameLabel);
			panel.add(companyLabel);
			panel.add(salaryLabel);
			panel.add(skillsLabel);
			panels.add(panel);
		}
		return panels;
	}

	private List<JPanel> getApplicationPane(){
		List<JPanel> panels = new ArrayList<>();
		List<Application> applications = mySqlCon.getApplications();
		for(Application application: applications){
			JPanel panel = new JPanel();
			panel.setBackground(lightBlue);
			panel.setLayout(new BoxLayout(panel, BoxLayout.Y_AXIS));
			panel.setBorder( BorderFactory.createLineBorder(Color.black));
			JLabel userNameLabel = new JLabel(String.format("%d. %s", application.user.id, application.user.name));
			userNameLabel.setFont(Styles.TITLE_FONT);
			userNameLabel.setForeground(Color.black);
			JLabel jobNameLabel = new JLabel(String.format("%d. %s", application.job.id, application.job.name));
			jobNameLabel.setFont(Styles.TITLE_FONT);
			jobNameLabel.setForeground(Color.BLACK);
			JLabel companyLabel = new JLabel(application.job.company);
			companyLabel.setFont(Styles.SUBTITLE_FONT);
			companyLabel.setForeground(Color.black);
			JLabel salaryLabel = new JLabel("Salary : Rs." + application.job.salary);
			salaryLabel.setForeground(Color.black);
			salaryLabel.setFont(Styles.Salary_FONT);
			JLabel skillsLabel = new JLabel("Skills : " + Utils.listToString(application.job.skills));
			skillsLabel.setFont(Styles.SKILLS_FONT);
			skillsLabel.setForeground(Color.black);
			panel.add(userNameLabel);
			panel.add(jobNameLabel);
			panel.add(companyLabel);
			panel.add(salaryLabel);
			panel.add(skillsLabel);
			panels.add(panel);
		}
		return panels;
	}



}
