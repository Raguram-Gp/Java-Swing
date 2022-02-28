package online_recruitment.models;

public class User {
	public int id;
	public String name, email, pass;
	public Boolean isSuper;
	public User(int id, String name, String email,Boolean isSuper,String pass) {
		this.name = name;
		this.pass = pass;
		this.email = email;
		this.id = id;
		this.isSuper = isSuper;
	}

	@Override
	public String toString() {
		return "User{" +
				"id=" + id +
				", name='" + name + '\'' +
				", pass='" + pass + '\'' +
				", email='" + email + '\'' +

				'}';
	}
}
