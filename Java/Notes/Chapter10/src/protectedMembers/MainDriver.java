package protectedMembers;

public class MainDriver {
	public static void main (String[] args) {
		ClassA cb = new ClassB(); //ClassB is a ClassA
		ClassA cc = new ClassC(); //ClassC is a ClassA
		UsesInterface ui = new UsesInterface();
		
		//Making an Anonymous Inner Class from MyInterface
		MyInterface i = new MyInterface() {
			String damnString;
			String ughString;
			
			@Override
			public String damn() {
				// TODO Auto-generated method stub
				this.damnString = "Damn this inner class has no name"; 
				return damnString;
			}

			@Override
			public String ugh() {
				// TODO Auto-generated method stub
				this.ughString = "Ugh this inner class has no name";
				return ughString;
			}
		};
		
		//?
		FunctionalInterface woah1 = (x,y) -> (1+2);

		FunctionalInterface woah2 = (x,y) -> {
			x = 2*1;
			y = 2*2;			
			return (double)(x*y);
		};
		
		System.out.println("From driver: " + cb.getSuperClassValue());
		System.out.println("From driver: " + cc.getSuperClassValue());
		System.out.println(ui.damn());
		System.out.println(ui.ugh());
		System.out.println(ui.yippyYo());
		System.out.println(i.damn());
		System.out.println(i.ugh());
		System.out.println("Outputs double value from fuctional interface via lambda expression" + woah1);
		System.out.println("Outputs double value from fuctional interface via lambda expression" + woah2);
	}
}
