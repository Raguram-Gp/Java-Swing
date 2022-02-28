package online_recruitment.screens.normal_user;

import online_recruitment.Styles;
import online_recruitment.Utils;
import online_recruitment.database.MySqlCon;
import online_recruitment.models.Application;
import online_recruitment.models.Job;
import online_recruitment.models.User;
import online_recruitment.screens.login.LoginPage;
import online_recruitment.screens.register.RegisterPage;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.util.ArrayList;
import java.util.List;

public class NormalUserPage{
	private JPanel jJobsPane, jProfilePane, jAppliedPane;
	private JTabbedPane jTabbedPane;
	private JFrame frame;
	private MySqlCon mySqlCon;
	private User user;
	Color lightBlue = new Color(193, 241, 247);


	public NormalUserPage(User user, MySqlCon mySqlCon){
		this.user = user;
		this.mySqlCon = mySqlCon;
		frame = new JFrame();
		frame.setTitle("User Page");
		jJobsPane = new JPanel();
		jAppliedPane = new JPanel();
		jProfilePane = new JPanel();
		jJobsPane.setBackground(Color.white);
		jProfilePane.setBackground(Color.white);
		getProfileCard(jProfilePane);
		jTabbedPane = new JTabbedPane();
		jTabbedPane.setBackground(Color.white);
		jJobsPane.setLayout(new GridLayout(10,1, 10, 10));
		List<JPanel> jobListPane = getJobPanels();
		for (JPanel jPanel : jobListPane) {
			jJobsPane.add(jPanel);
		}
		jAppliedPane.setLayout(new GridLayout(10,1,10, 10));
		List<JPanel> appliedJobsPane = getAppliedPane();
		for(JPanel jPanel: appliedJobsPane){
			jAppliedPane.add(jPanel);
		}
		JScrollPane jobScrollPane = new JScrollPane(jJobsPane);
		jobScrollPane.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_ALWAYS);
		jobScrollPane.setBackground(Color.white);
		JScrollPane appliedScrollPane = new JScrollPane(jAppliedPane);
		appliedScrollPane.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_ALWAYS);
		appliedScrollPane.setBackground(Color.white);
		jTabbedPane.add("Jobs", jobScrollPane);
		jTabbedPane.add("Applied Jobs", appliedScrollPane);
		jTabbedPane.add("Profile", jProfilePane);
		frame.add(jTabbedPane);
		frame.setSize(900, 800);
		frame.setVisible(true);
	}

	private static ImageIcon createImageIcon(String path,
	                                         String description) {
		java.net.URL imgURL = NormalUserPage.class.getResource(path);

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
			JLabel salaryLabel = new JLabel("Salary : Rs." + String.valueOf(job.salary));
			salaryLabel.setForeground(Color.black);
			salaryLabel.setFont(Styles.Salary_FONT);
			JLabel skillsLabel = new JLabel("Skills : " + Utils.listToString(job.skills));
			skillsLabel.setFont(Styles.SKILLS_FONT);
			skillsLabel.setForeground(Color.black);
			panel.add(nameLabel);
			panel.add(companyLabel);
			panel.add(salaryLabel);
			panel.add(skillsLabel);
			panel.addMouseListener(new MouseListener() {
				@Override
				public void mouseClicked(MouseEvent e) {
					new RegisterPage(user, job, mySqlCon, frame);
				}

				@Override
				public void mousePressed(MouseEvent e) {

				}

				@Override
				public void mouseReleased(MouseEvent e) {

				}

				@Override
				public void mouseEntered(MouseEvent e) {

				}

				@Override
				public void mouseExited(MouseEvent e) {

				}
			});
			panels.add(panel);
		}
		return panels;
	}


	private List<JPanel> getAppliedPane(){
		List<JPanel> panels = new ArrayList<>();
		List<Application> applications = mySqlCon.getAppliedJobs(user);
		for(Application application: applications){
			JPanel panel = new JPanel();
			panel.setBackground(lightBlue);
			panel.setLayout(new BoxLayout(panel, BoxLayout.Y_AXIS));
			panel.setBorder( BorderFactory.createLineBorder(Color.black));
			JLabel nameLabel = new JLabel(String.format("%d. %s", application.id, application.job.name));
			nameLabel.setFont(Styles.TITLE_FONT);
			nameLabel.setForeground(Color.BLACK);
			JLabel companyLabel = new JLabel(application.job.company);
			companyLabel.setFont(Styles.SUBTITLE_FONT);
			companyLabel.setForeground(Color.black);
			JLabel salaryLabel = new JLabel("Salary : Rs." + String.valueOf(application.job.salary));
			salaryLabel.setForeground(Color.black);
			salaryLabel.setFont(Styles.Salary_FONT);
			JLabel skillsLabel = new JLabel("Skills : " + Utils.listToString(application.job.skills));
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


}
