package online_recruitment.screens.signup;

import online_recruitment.database.MySqlCon;
import online_recruitment.models.User;
import online_recruitment.screens.login.LoginPage;
import online_recruitment.screens.normal_user.NormalUserPage;
import online_recruitment.screens.super_user.SuperUserPage;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class SignUpPage implements ActionListener {
	MySqlCon mySqlCon;
	JLabel nameLabel, passwordLabel, titleLabel, errorLabel, emailLabel, confirmPasswordLabel ;
	JTextField nameText, passwordText, emailText, confirmPasswordText;
	JFrame frame;
	JPanel panel;

	JButton submitButton, registerButton;
	Color lightBlue = new Color(193, 241, 247);

	public SignUpPage(MySqlCon mySqlCon){
		this.mySqlCon = mySqlCon;
		panel = new JPanel();
		frame = new JFrame();
		frame.setTitle("Sign up");
		frame.setSize(900, 500);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.add(panel);
		panel.setLayout(null);
		titleLabel = new JLabel("Sign Up", JLabel.CENTER);
		titleLabel.setBounds(0, 20, 900, 50);
		titleLabel.setFont(new Font("Verdana", Font.BOLD, 30));
		panel.add(titleLabel);
		panel.setBackground(lightBlue);

		nameLabel = new JLabel("User Name :");
		nameLabel.setBounds(150, 100, 80, 25);
		nameText = new JTextField(20);
		nameText.setBounds(300, 100, 300, 25);
		panel.add(nameLabel);
		panel.add(nameText);

		emailLabel = new JLabel("Email : ");
		emailLabel.setBounds(150, 160, 80, 25);
		emailText = new JTextField();
		emailText.setBounds(300, 160, 300, 25);
		panel.add(emailLabel);
		panel.add(emailText);

		passwordLabel = new JLabel("Password :");
		passwordLabel.setBounds(150, 220, 80, 25);
		passwordText = new JPasswordField(30);
		passwordText.setBounds(300, 220, 300, 25);
		panel.add(passwordLabel);
		panel.add(passwordText);

		confirmPasswordLabel = new JLabel("Password :");
		confirmPasswordLabel.setBounds(150, 280, 80, 25);
		confirmPasswordText = new JPasswordField(30);
		confirmPasswordText.setBounds(300, 280, 300, 25);
		panel.add(confirmPasswordLabel);
		panel.add(confirmPasswordText);

		errorLabel = new JLabel("");
		errorLabel.setForeground(Color.RED);
		errorLabel.setBounds(300, 320, 300, 25);
		panel.add(errorLabel);

		submitButton = new JButton("Sign up");
		submitButton.setBounds(250, 360, 100, 25);
		submitButton.addActionListener(this);
		panel.add(submitButton);

		registerButton = new JButton("Sign in");
		registerButton.setBounds(450, 360, 100, 25);
		registerButton.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				frame.dispose();
				new LoginPage(mySqlCon);
			}
		});
		panel.add(registerButton);


		frame.setVisible(true);
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		String name, pass, email, confirmPass;

		name = nameText.getText();
		email = emailText.getText();
		pass = passwordText.getText();
		confirmPass = confirmPasswordText.getText();

		if(name.equals("") || email.equals("") || pass.equals("") || confirmPass.equals("")){
			errorLabel.setText("Please Fill all the details");
			return;
		}

		if(!pass.equals(confirmPass)){
			errorLabel.setText("Password doesn't match!");
			return;
		}
		User user = new User(0, name,email,false, pass);
		user = mySqlCon.postUser(user);
		if(user != null){
			frame.dispose();
			if(user.isSuper){
				new SuperUserPage(user, mySqlCon);
			}else{
				new NormalUserPage(user, mySqlCon);
			}
		}else{
			errorLabel.setText("Something went wrong.Try again later!!");
		}
	}
}
