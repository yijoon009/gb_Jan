package obj;

import java.util.HashSet;
import java.util.Set;

public class School {
	public static void main(String[] args) {
		Student han = new Student(1, "김이준");
		Set<Student> stdSet = new HashSet<>();
		
		stdSet.add(han);
		stdSet.add(new Student(1, "김이준"));
		
		System.out.println(stdSet.size());
		
		System.out.println(han.equals(new Student(1, "김이준")));
		
	}
}
