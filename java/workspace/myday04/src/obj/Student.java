package obj;

public class Student {
	int num;
	public String name;
	
	public Student() {}
	
	public Student(int num, String name) {
		super();
		this.num = num;
		this.name = name;
	}
	
	@Override
	public boolean equals(Object obj) {
		if(obj instanceof Student) {
			Student std = (Student) obj;
			if(this.num == std.num) {
				return true;
			}
		}
		return false;
	}

	@Override
	public int hashCode() {
		return this.num;
	}
}
