import javax.swing.*;
import java.awt.*;

public class Assignment1 {
	JLabel nameLabel, emailLabel, ageLabel, mobileLabel, companyLabel, websiteLabel, titleLabel, addressLabel;
	JTextField nameText, emailText, ageText, mobileText, companyText, websiteText;
	JTextArea addressText;
	JButton addButton, updateButton, deleteButton, closeButton;

	public Assignment1(){
		JPanel panel = new JPanel();
		JFrame frame = new JFrame();
		frame.add(panel);
		frame.setSize(800, 800);

		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

		panel.setLayout(null);
		titleLabel = new JLabel("Company Registration");
		titleLabel.setBounds(250, 20, 400, 50);
		titleLabel.setFont(new Font("", 1, 30));
		panel.add(titleLabel);
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
		companyLabel = new JLabel("Company Name :");
		companyLabel.setBounds(150, 340, 100, 25);
		companyText = new JTextField(100);
		companyText.setBounds(300, 340, 300, 25);
		panel.add(companyLabel);
		panel.add(companyText);
		websiteLabel = new JLabel("Website :");
		websiteLabel.setBounds(150, 400, 80, 25);
		websiteText = new JTextField(20);
		websiteText.setBounds(300, 400, 300, 25);
		panel.add(websiteLabel);
		panel.add(websiteText);
		addressLabel = new JLabel("Address :");
		addressLabel.setBounds(150, 460, 80, 25);
		addressText = new JTextArea();
		addressText.setBounds(300, 460, 300, 75);
		panel.add(addressLabel);
		panel.add(addressText);
		addButton = new JButton("ADD");
		updateButton = new JButton("UPDATE");
		deleteButton = new JButton("DELETE");
		closeButton = new JButton("CLOSE");
		addButton.setBounds(200, 600, 80, 25);
		updateButton.setBounds(300, 600, 80, 25);
		deleteButton.setBounds(400, 600, 80, 25);
		closeButton.setBounds(500, 600, 80, 25);
		panel.add(addButton);
		panel.add(updateButton);
		panel.add(deleteButton);
		panel.add(closeButton);



		frame.setVisible(true);
	}

	public static void main(String[] args) {
		new Assignment1();
	}
}
