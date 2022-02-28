package online_recruitment.screens.register;

import online_recruitment.Styles;
import online_recruitment.Utils;
import online_recruitment.database.MySqlCon;
import online_recruitment.models.Application;
import online_recruitment.models.Job;
import online_recruitment.models.User;
import online_recruitment.screens.normal_user.NormalUserPage;
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class RegisterPage implements ActionListener {
	JLabel nameLabel, emailLabel, ageLabel, mobileLabel, skillsLabel, qualificationLabel, titleLabel, addressLabel, genderLabel, companyLabel, companyAddressLabel, jobDescriptionLabel, salaryLabel, specificationLabel;
	JTextField nameText, emailText, ageText, mobileText;
	JTextArea addressText;
	JComboBox<String> qualificationCombo, specificationCombo;
	JRadioButton maleRadio, femaleRadio;
	ButtonGroup genderGroup;

	JButton submitButton;
	String[] qualifications = {"BE", "BSC", "MSC", "ME"};
	String[] specifications = {"Computer Science", "Electrical and Electronics", "Mechanical", "Civil"};
	Color lightBlue = new Color(193, 241, 247);
	Job job;
	User user;
	JFrame frame, normalUserFrame;
	MySqlCon mySqlCon;
	JPanel panel, infoPanel;
	List<String> skills = new ArrayList<>();

	public RegisterPage(User user, Job job, MySqlCon mysqlCon, JFrame normalUserFrame){
		this.normalUserFrame = normalUserFrame;
		this.user = user;
		this.job = job;
		this.mySqlCon = mysqlCon;
		panel = new JPanel();
		infoPanel = new JPanel();
		frame = new JFrame();
		frame.setTitle("Registration Form");
		frame.add(panel);
		frame.setSize(900, 800);

		frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);

		panel.setLayout(null);
		panel.setBackground(lightBlue);

		infoPanel.setLayout(null);
		titleLabel = new JLabel(job.name, JLabel.CENTER);
		titleLabel.setBounds(0, 20, 900, 50);
		titleLabel.setFont(new Font("Verdana", Font.BOLD, 30));
		infoPanel.add(titleLabel);
		infoPanel.setBounds(0, 0, 900, 220);
		infoPanel.setBackground(Color.white);
		JSeparator s = new JSeparator();
		s.setOrientation(JSeparator.HORIZONTAL);
		s.setBounds(0, 80, 900, 5);
		infoPanel.add(s);
		companyLabel = new JLabel("Company : "+ job.company, JLabel.CENTER);
		companyLabel.setFont(Styles.SUBTITLE_FONT);
		companyLabel.setBounds(10,100, 440, 50);
		infoPanel.add(companyLabel);
		salaryLabel = new JLabel("Salary : Rs." + job.salary, JLabel.CENTER);
		salaryLabel.setFont(Styles.SUBTITLE_FONT);
		salaryLabel.setBounds(450, 100, 440, 50);
		infoPanel.add(salaryLabel);
		companyAddressLabel = new JLabel("Address : " + job.address, JLabel.CENTER);
		companyAddressLabel.setFont(Styles.SUBTITLE_FONT);
		companyAddressLabel.setBounds(10, 160, 440, 50);
		infoPanel.add(companyAddressLabel);
		jobDescriptionLabel = new JLabel("Description : "+job.description, JLabel.CENTER);
		jobDescriptionLabel.setFont(Styles.SUBTITLE_FONT);
		jobDescriptionLabel.setBounds(450, 160, 440, 50);
		infoPanel.add(jobDescriptionLabel);

		panel.add(infoPanel);




		nameLabel = new JLabel("Name :");
		nameLabel.setBounds(150, 250, 80, 25);
		nameText = new JTextField(20);
		nameText.setBounds(300, 250, 300, 25);
		panel.add(nameLabel);
		panel.add(nameText);

		emailLabel = new JLabel("Email :");
		emailLabel.setBounds(150, 290, 80, 25);
		emailText = new JTextField(30);
		emailText.setBounds(300, 290, 300, 25);
		panel.add(emailLabel);
		panel.add(emailText);

		ageLabel = new JLabel("Age :");
		ageLabel.setBounds(150, 330, 80, 25);
		ageText = new JTextField(3);
		ageText.setBounds(300, 330, 300, 25);
		panel.add(ageLabel);
		panel.add(ageText);

		mobileLabel = new JLabel("Mobile :");
		mobileLabel.setBounds(150, 370, 80, 25);
		mobileText = new JTextField(10);
		mobileText.setBounds(300, 370, 300, 25);
		panel.add(mobileLabel);
		panel.add(mobileText);

		qualificationLabel = new JLabel("Qualification :");
		qualificationLabel.setBounds(150, 410, 80, 25);
		qualificationCombo = new JComboBox<>(qualifications);
		qualificationCombo.setBounds(300, 410, 300, 25);
		qualificationCombo.setBackground(Color.white);
		panel.add(qualificationLabel);
		panel.add(qualificationCombo);

		specificationLabel = new JLabel("Specification : ");
		specificationLabel.setBounds(150, 450, 100, 25);
		specificationCombo = new JComboBox<>(specifications);
		specificationCombo.setBounds(300, 450, 300, 25);
		specificationCombo.setBackground(Color.white);
		panel.add(specificationLabel);
		panel.add(specificationCombo);


		skillsLabel = new JLabel("Skills :");
		skillsLabel.setBounds(150, 490, 100, 25);
		panel.add(skillsLabel);
		for(int i = 0; i<job.skills.size(); i++){
			JCheckBox cb = new JCheckBox(job.skills.get(i));
			cb.setBackground(lightBlue);
			cb.setBounds(300, 490 + (i*30) , 300, 25);
			cb.addActionListener(new ActionListener() {
				@Override
				public void actionPerformed(ActionEvent e) {
					if(cb.isSelected()){
						skills.add(cb.getText());
					}else {
						skills.remove(cb.getText());
					}
					System.out.println(skills.toString());
				}
			});
			panel.add(cb);
		}
		genderLabel = new JLabel("Gender");
		genderLabel.setBounds(150, 620, 80, 25);
		maleRadio = new JRadioButton("Male");
		femaleRadio = new JRadioButton("Female");
		genderGroup = new ButtonGroup();
		genderGroup.add(maleRadio);
		genderGroup.add(femaleRadio);
		maleRadio.setBounds(300, 620, 80, 25);
		femaleRadio.setBounds(380, 620, 80, 25);
		maleRadio.setBackground(lightBlue);
		femaleRadio.setBackground(lightBlue);
		panel.add(genderLabel);
		panel.add(maleRadio);
		panel.add(femaleRadio);


		addressLabel = new JLabel("Address :");
		addressLabel.setBounds(150, 660, 80, 25);
		addressText = new JTextArea();
		addressText.setBounds(300, 660, 300, 75);
		panel.add(addressLabel);
		panel.add(addressText);


		submitButton = new JButton("Submit");
		submitButton.setBounds( 650, 672, 100, 50);
		submitButton.addActionListener(this);
		panel.add(submitButton);


		frame.setVisible(true);
	}


	@Override
	public void actionPerformed(ActionEvent e) {
		String name, email, qualification, gender, address, specification, mobile;
		int age;
		//		System.out.println(e.getID());
		if(e.getID() == 1001){
			name = nameText.getText();
			email = emailText.getText();
			qualification = Objects.requireNonNull(qualificationCombo.getSelectedItem()).toString();
			specification = Objects.requireNonNull(specificationCombo.getSelectedItem()).toString();
			address = addressText.getText();
			if(name.equals("") || email.equals("") || qualification.equals("") || specification.equals("") || address.equals("")){
				showErrorMessage("Please fill all the fields!!");
				return;
			}

			try {
				age = Integer.parseInt(ageText.getText());
				Double.parseDouble(mobileText.getText());
				if(!(age >=18 && age <=60)){
					showErrorMessage("Age should be between 18 to 60");
					return;
				}
				if(mobileText.getText().length() != 10){
					showErrorMessage("Enter a valid mobile number");
					return;
				}
				mobile = mobileText.getText();
			}catch (Exception ex){
				showErrorMessage("Enter correct value for age or mobile number");
				return;
			}



			if(maleRadio.isSelected() || femaleRadio.isSelected()){
				gender = maleRadio.isSelected()? "Male" : "Female";
			}else{
				showErrorMessage("Please select your gender");
				return;
			}
			if(skills.size() == 0){
				showErrorMessage("Please select atleast one skill");
				return;
			}
			System.out.println(String.format("Name : %s\nEmail : %s\nMobile : %s\nAge : %s\nQualification : %s\nGender : %s\nAddress : %s", name, email, mobile, age, qualification, gender, address));
			System.out.println("Skills : " + skills.toString());
			Application application = new Application(0,user, job, name, email, age, mobile, qualification, specification, Utils.listToString(skills), gender, address);
			mySqlCon.postApplication(application);
			showSuccessMessage("Your response has been recorded\nWe will get back to you soon!!");
		}
	}
	private void showErrorMessage(String message){
		JOptionPane.showMessageDialog(frame, message,
				"Error", JOptionPane.ERROR_MESSAGE);
	}

	private void showSuccessMessage(String message){
		int option = JOptionPane.showOptionDialog(frame, message, "Success", JOptionPane.OK_CANCEL_OPTION, JOptionPane.INFORMATION_MESSAGE, null, new String[]{"Ok"}, "OK");
		if(option == JOptionPane.OK_OPTION){
			frame.dispose();
			normalUserFrame.dispose();
			new NormalUserPage(user,mySqlCon);
		}

	}
}
