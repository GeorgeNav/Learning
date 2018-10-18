package protectedMembers;

public class ClassC extends ClassB {	
	public ClassC() {
		super();
		this.test = 6;
	}
	
	public int getSuperClassVal() {
		System.out.println("Subclass C: " + this.test);
		return this.test;
	}
}
