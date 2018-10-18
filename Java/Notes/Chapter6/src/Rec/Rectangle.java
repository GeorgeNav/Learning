package Rec;

public class Rectangle {
	//field 1
	//private = the member cannot be accessed by code outside the class; accessed only by methods that are the same class
	//adding methods allow data to be stored within 
	private double length;
	
	//field 2
	private double width;
	
	//field 3
	//public = can be accessed by code inside or outside the class
	public int randVal;

	/*
	The setLength method stores a value in the length field.
	@param len The value to store in length	 
	*/
	//length method
	//void = return type (no data)
	//setLength = name of method
	//(double len) = declaration of a parameter variable of the double data type
	public void setLength(double len) {
		length = len;
	}
	
	/*
	The setLength method stores a value in the width field.
	@param len The value to store in width 
	*/
	public void setWidth(double w) {
		width = w;
	}
	
	/*
	The getLength method returns a value from the length field.
	*/
	public double getLength() {
		return length;
	}
	
	/*
	The getLength method returns a value from the width field.
	*/
	public double getWidth() {
		return width;
	}
	
	/*
	The getLength method stores a value in the length field.
	@param len The value to store in length	 
	*/
	//area = stale value
	//stale = may not be updated if it was it's own field
	public double getArea() {
		return (length * width);
	
	}
	
	
	//Default Constructor = this is a method that is automatically created by java that does not accept (or have) passing arguments
	//This constructor includes all fields listed before methods as instance fields
	/*
	public Rectangle() {
		//Includes all variables (initialized to 0), booleans (initialized to false), or reference variables (initialized to null)
	}
	*/
}
