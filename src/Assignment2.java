	import  javax.swing.*;
	import java.awt.*;
	import java.awt.event.ActionEvent;
	import java.awt.event.ActionListener;
	import java.util.ArrayList;

	public class Assignment2 implements ActionListener {
		JLabel nameLabel, emailLabel, ageLabel, mobileLabel, skillsLabel, qualificationLabel, titleLabel, addressLabel, genderLabel;
		JTextField nameText, emailText, ageText, mobileText;
		JTextArea addressText;
		JComboBox<String> qualificationCombo;
		JCheckBox webCheck, mobileCheck, backendCheck, uiCheck;
		JRadioButton maleRadio, femaleRadio;
		ButtonGroup genderGroup;

		JButton submitButton;
		String[] qualifications = {"BE", "BSC", "MSC", "ME"};
		Color lightBlue = new Color(193, 241, 247);


		public Assignment2(){
			JPanel panel = new JPanel();
			JFrame frame = new JFrame();
			frame.add(panel);
			frame.setSize(800, 900);

			frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

			panel.setLayout(null);
			titleLabel = new JLabel("Online Recruitment Form");
			titleLabel.setBounds(250, 20, 400, 50);
			titleLabel.setFont(new Font("", Font.BOLD, 30));
			panel.add(titleLabel);
			panel.setBackground(lightBlue);

			nameLabel = new JLabel("Name :");
			nameLabel.setBounds(150, 100, 80, 25);
			nameText = new JTextField(20);
			nameText.setBounds(300, 100, 300, 25);
			panel.add(nameLabel);
			panel.add(nameText);

			emailLabel = new JLabel("Email :");
			emailLabel.setBounds(150, 160, 80, 25);
			emailText = new JTextField(30);
			emailText.setBounds(300, 160, 300, 25);
			panel.add(emailLabel);
			panel.add(emailText);

			ageLabel = new JLabel("Age :");
			ageLabel.setBounds(150, 220, 80, 25);
			ageText = new JTextField(3);
			ageText.setBounds(300, 220, 300, 25);
			panel.add(ageLabel);
			panel.add(ageText);

			mobileLabel = new JLabel("Mobile :");
			mobileLabel.setBounds(150, 280, 80, 25);
			mobileText = new JTextField(10);
			mobileText.setBounds(300, 280, 300, 25);
			panel.add(mobileLabel);
			panel.add(mobileText);

			qualificationLabel = new JLabel("Qualification :");
			qualificationLabel.setBounds(150, 340, 80, 25);
			qualificationCombo = new JComboBox<>(qualifications);
			qualificationCombo.setBounds(300, 340, 300, 25);
			qualificationCombo.setBackground(Color.white);
			panel.add(qualificationLabel);
			panel.add(qualificationCombo);

			skillsLabel = new JLabel("Skills :");
			skillsLabel.setBounds(150, 400, 100, 25);
			webCheck = new JCheckBox("WEB Development");
			webCheck.setBackground(lightBlue);
			webCheck.setBounds(300, 400, 300, 25);
			mobileCheck = new JCheckBox("Mobile Development");
			mobileCheck.setBounds(300, 430, 300, 25);
			mobileCheck.setBackground(lightBlue);
			backendCheck = new JCheckBox("Backend Development");
			backendCheck.setBounds(300, 460, 300, 25);
			backendCheck.setBackground(lightBlue);
			uiCheck = new JCheckBox("UI Development");
			uiCheck.setBounds(300, 490, 300, 25);
			uiCheck.setBackground(lightBlue);
			panel.add(skillsLabel);
			panel.add(webCheck);
			panel.add(mobileCheck);
			panel.add(backendCheck);
			panel.add(uiCheck);

			genderLabel = new JLabel("Gender");
			genderLabel.setBounds(150, 550, 80, 25);
			maleRadio = new JRadioButton("Male");
			femaleRadio = new JRadioButton("Female");
			genderGroup = new ButtonGroup();
			genderGroup.add(maleRadio);
			genderGroup.add(femaleRadio);
			maleRadio.setBounds(300, 550, 80, 25);
			femaleRadio.setBounds(380, 550, 80, 25);
			maleRadio.setBackground(lightBlue);
			femaleRadio.setBackground(lightBlue);
			panel.add(genderLabel);
			panel.add(maleRadio);
			panel.add(femaleRadio);


			addressLabel = new JLabel("Address :");
			addressLabel.setBounds(150, 610, 80, 25);
			addressText = new JTextArea();
			addressText.setBounds(300, 610, 300, 75);
			panel.add(addressLabel);
			panel.add(addressText);


			submitButton = new JButton("Submit");
			submitButton.setBounds(350, 750, 100, 25);
			submitButton.addActionListener(this);
			panel.add(submitButton);


			frame.setVisible(true);
		}

		public static void main(String[] args) {
//			new Assignment2();
			new LoginPage();
		}


		@Override
		public void actionPerformed(ActionEvent e) {
			String name, email, age, mobile, qualification, gender, address;
			ArrayList<String> skills = new ArrayList<String>();
	//		System.out.println(e.getID());
			if(e.getID() == 1001){
				name = nameText.getText();
				email = emailText.getText();
				age = ageText.getText();
				mobile = mobileText.getText();
				qualification = qualificationCombo.getSelectedItem().toString();
				gender = maleRadio.isSelected()? "Male" : "Female";
				address = addressText.getText();
				System.out.println(String.format("Name : %s\nEmail : %s\nMobile : %s\nAge : %s\nQualification : %s\nGender : %s\nAddress : %s", name, email, mobile, age, qualification, gender, address));
				if(webCheck.isSelected()) skills.add(webCheck.getText());
				if(mobileCheck.isSelected()) skills.add(mobileCheck.getText());
				if(backendCheck.isSelected()) skills.add(backendCheck.getText());
				if(uiCheck.isSelected()) skills.add(uiCheck.getText());
				System.out.println("Skills : " + skills.toString());

			}
		}
	}


	class LoginPage implements ActionListener {
		static final String NAME = "Hello", PASS = "Hello";
		JLabel nameLabel, passwordLabel, titleLabel;
		JTextField nameText, passwordText;
		JFrame frame;
		JPanel panel;

		JButton submitButton;
		Color lightBlue = new Color(193, 241, 247);

		public LoginPage(){
			panel = new JPanel();
			frame = new JFrame();
			frame.add(panel);
			frame.setSize(800, 400);

			frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);


			panel.setLayout(null);
			titleLabel = new JLabel("Login");
			titleLabel.setBounds(350, 20, 400, 50);
			titleLabel.setFont(new Font("", 1, 30));
			panel.add(titleLabel);
			panel.setBackground(lightBlue);

			nameLabel = new JLabel("User Name :");
			nameLabel.setBounds(150, 100, 80, 25);
			nameText = new JTextField(20);
			nameText.setBounds(300, 100, 300, 25);
			panel.add(nameLabel);
			panel.add(nameText);

			passwordLabel = new JLabel("Password :");
			passwordLabel.setBounds(150, 160, 80, 25);
			passwordText = new JPasswordField(30);
			passwordText.setBounds(300, 160, 300, 25);
			panel.add(passwordLabel);
			panel.add(passwordText);

			submitButton = new JButton("Login");
			submitButton.setBounds(350, 250, 100, 25);
			submitButton.addActionListener(this);
			panel.add(submitButton);


			frame.setVisible(true);
		}

		@Override
		public void actionPerformed(ActionEvent e) {
	//		System.out.println("Login clicked");
			String name, password;
			name = nameText.getText();
			password = passwordText.getText();
			if(name.equals(NAME) && password.equals(PASS)){
				System.out.println("Entered credentials are correct");
				frame.dispose();
				new Assignment2();
			}else{
				System.out.println("Enter the correct credentials");
			}
		}
	}
