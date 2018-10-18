package CourseDemo;

public class Course {
	private String courseName; // Name of the course
	private Instructor instructor; // The instructor
	private TextBook textBook;
	
	// This constructor initializes the courseName instructor,
	// and text fields
	public Course(String name, Instructor instr, TextBook text) {
		// Assign the courseName
		courseName = name;
		
		// Create a new Instructor object, passing
		// instr as an argument to the copy constructor
		instructor = new Instructor(instr);
		
		// Create a new TextBook object, passing
		// instr as an argument to the copy constructor
		textBook = new TextBook(text);
	}
	
	// getInstructor method
	public Instructor getInstructor() {
		// Return a copy of the instructor object
		return new Instructor(instructor);
	}
	
	// getTextBook method
	public TextBook getTextBook() {
		// Return a copy of the textBook object
		return new TextBook(textBook);
	}
	
	// toString method
	public String toString() {
		// Create a string representing the object
		String str = ("Course name: " + courseName + "\n" + "Instructor Information:" + "\n" + instructor + "\n" + "TextBook Information:" + textBook);
		return str;
	}
}
