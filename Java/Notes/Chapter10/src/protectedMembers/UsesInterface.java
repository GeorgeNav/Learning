package protectedMembers;

public class UsesInterface implements MyInterface {
	@Override
	public String damn() {
		return "Damn method was overriden in subclass";
	}
	
	@Override
	public String ugh() {
		return "Ugh method was overriden in subclass";		
	}
}
