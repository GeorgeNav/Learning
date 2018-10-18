package protectedMembers;

public class ClassB extends ClassA {	
	public ClassB() {
		super();
		this.test = 3;
	}
	
	public int getSuperClassVal() {
		System.out.println("Subclass B: " + this.test);
		return this.test;
	}
}
