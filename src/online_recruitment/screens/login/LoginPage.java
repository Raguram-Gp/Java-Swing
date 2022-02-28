package online_recruitment.screens.login;

import online_recruitment.database.MySqlCon;
import online_recruitment.models.User;
import online_recruitment.screens.normal_user.NormalUserPage;
import online_recruitment.screens.signup.SignUpPage;
import online_recruitment.screens.super_user.SuperUserPage;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class LoginPage implements ActionListener {
	MySqlCon mySqlCon;
	JLabel nameLabel, passwordLabel, titleLabel, errorLabel;
	JTextField nameText, passwordText;
	JFrame frame;
	JPanel panel;

	JButton submitButton, registerButton;
	Color lightBlue = new Color(193, 241, 247);

	public LoginPage(MySqlCon mySqlCon){
		this.mySqlCon = mySqlCon;
		panel = new JPanel();
		frame = new JFrame();
		frame.setTitle("Login");
		frame.setSize(800, 400);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.add(panel);
		panel.setLayout(null);
		titleLabel = new JLabel("Sign in");
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

		errorLabel = new JLabel("");
		errorLabel.setForeground(Color.RED);
		errorLabel.setBounds(300, 200, 300, 25);
		panel.add(errorLabel);

		submitButton = new JButton("Sign in");
		submitButton.setBounds(250, 250, 100, 25);
		submitButton.addActionListener(this);
		panel.add(submitButton);

		registerButton = new JButton("Sign up");
		registerButton.setBounds(450, 250, 100, 25);
		registerButton.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				frame.dispose();
				new SignUpPage(mySqlCon);
			}
		});
		panel.add(registerButton);


		frame.setVisible(true);
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		String name, pass;
		name = nameText.getText();
		pass = passwordText.getText();
		if(name.equals("") || pass.equals("")){
			errorLabel.setText("Please fill all the fields");
			return;
		}
		User user = mySqlCon.getUser(name, pass);
		if(user != null){
			frame.dispose();
			if(user.isSuper){
				new SuperUserPage(user, mySqlCon);
			}else{
				new NormalUserPage(user, mySqlCon);
			}
		}else{
			errorLabel.setText("Incorrect username or password");
		}
	}
}
