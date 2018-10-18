
public class RoomCarpet {
		private RoomDimension size;
		private double carpetCost;
		
		public void RoomCarpet(RoomDimension size, double carpetCost) {
			this.size = size;
			this.carpetCost= carpetCost;
		}
		public double getTotalCost() {
			return (this.size.getArea() * this.carpetCost);
		}
		public String toString() {
			return ("The cost: " + getTotalCost() + "0 $ per sq/yd");
		}
}