package protectedMembers;

public class ClassA {
	protected int test = 2;
	
	public int getSuperClassValue() {
		System.out.println("Superclass A: " + test);
		return test;
	}
}
