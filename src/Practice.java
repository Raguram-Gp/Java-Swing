import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Practice {
	public static void main(String[] args) {
		String msg = "hello, world, 123";
		List<String> skills = new ArrayList<>();
		String[] skillsArray = msg.split(", ");
		Collections.addAll(skills, skillsArray);
		System.out.println(skills);
		System.out.println(String.format("insert into jobs values ('%s','%s', '%s', %.2f, %d,'%s')","name", "company", "des", 100.89999, 100, "add"));
	}
}
