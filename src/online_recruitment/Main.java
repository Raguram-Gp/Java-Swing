package online_recruitment;

import online_recruitment.database.MySqlCon;
import online_recruitment.models.User;
import online_recruitment.screens.login.LoginPage;
import online_recruitment.screens.normal_user.NormalUserPage;
import online_recruitment.screens.signup.SignUpPage;
import online_recruitment.screens.super_user.SuperUserPage;

import java.io.IOException;

class Main {
	private Main() throws IOException {
		MySqlCon mySqlCon = new MySqlCon();
//		new LoginPage(mySqlCon);
//		new SignUpPage(mySqlCon);
//		new NormalUserPage(new User(1, "Raveen", "raveen@email.com", true, "pass"),mySqlCon);
		new SuperUserPage(new User(33,"Sanjeev", "sanjeev@gmail.com", true, "pass"), mySqlCon);
	}

	public static void main(String[] args) throws IOException {
		new Main();
	}
}
