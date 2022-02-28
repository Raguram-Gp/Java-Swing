package online_recruitment.models;

public class Application {
	public int id;
	public User user;
	public Job job;
	public String name, email;
	public int age;
	public String mobile, qualification, specification, skills, gender, address;

	public Application(int id, User user, Job job, String name, String email, int age, String mobile, String qualification, String specification, String skills, String gender, String address) {
		this.id = id;
		this.user = user;
		this.job = job;
		this.name = name;
		this.email = email;
		this.age = age;
		this.mobile = mobile;
		this.qualification = qualification;
		this.specification = specification;
		this.skills = skills;
		this.gender = gender;
		this.address = address;
	}

	@Override
	public String toString() {
		return "Application{" +
				"id=" + id +
				", user=" + user +
				", job=" + job +
				", name='" + name + '\'' +
				", email='" + email + '\'' +
				", age=" + age +
				", mobile='" + mobile + '\'' +
				", qualification='" + qualification + '\'' +
				", specification='" + specification + '\'' +
				", skills='" + skills + '\'' +
				", gender='" + gender + '\'' +
				", address='" + address + '\'' +
				'}';
	}
}
