
public class RoomDimension {
	public double length;
	public double width;
	
	public void RoomDimension(double length, double width) {
		this.length = length;
		this.width = width;
	}
	
	//Method 1 = Multiply the area of the floor length times width converted to yards
	public double getArea() {
		return ((this.length * this.width)/9);
	}
	
	public String toString() {
		//Displays area of room with RoomDimension class return value converted to yards
		return ("Area of Room: " + getArea() + "0 sq/yd");
	}
}
