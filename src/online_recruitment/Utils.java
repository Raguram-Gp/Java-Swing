package online_recruitment;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Utils {
	public static String listToString(List<String> skills) {
		String msg = skills.toString();
		msg = msg.substring(1, msg.length() -1);
		return msg;
	}

	public static List<String> stringToList(String msg){
		List<String> skills = new ArrayList<String>();
		String[] skillsArray = msg.split(", ");
		Collections.addAll(skills, skillsArray);
		System.out.println(skills);
		return skills;
	}
}
