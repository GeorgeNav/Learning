package protectedMembers;

public interface MyInterface {
	default String yippyYo() {
		return "Yippy Yo from interface";
	}
	default String wowzer() {
		return "Wowzer from interface";
	}
	public String damn();
	public String ugh();
}
