package myday05;

public class Student {
	int num;
	String name;
	public Student() {
		// TODO Auto-generated constructor stub
	}
	public Student(int num, String name) {
		super();
		this.num = num;
		this.name = name;
	}
	
	
	
	@Override
	public boolean equals(Object obj) {
		if(obj instanceof Student) {
			Student std = (Student) obj;
			if(std.num== this.num) {
				return true;
			}
		}
		return false;
	}
	
	@Override
	public int hashCode() {
		return this.num;
	}
	
	
//	@Override
//	public int hashCode() {
//		final int prime = 31;
//		int result = 1;
//		result = prime * result + ((name == null) ? 0 : name.hashCode());
//		result = prime * result + num;
//		return result;
//	}
//	@Override
//	public boolean equals(Object obj) {
//		if (this == obj)
//			return true;
//		if (obj == null)
//			return false;
//		if (getClass() != obj.getClass())
//			return false;
//		Student other = (Student) obj;
//		if (name == null) {
//			if (other.name != null)
//				return false;
//		} else if (!name.equals(other.name))
//			return false;
//		if (num != other.num)
//			return false;
//		return true;
//	}
	
}
