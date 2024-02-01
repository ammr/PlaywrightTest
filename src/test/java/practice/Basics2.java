package practice;



sealed class A extends Thread implements Cloneable permits B,C{
	
}

non-sealed class B extends A{
	
	
}

final class C extends A{
	
}

 class D extends B{
	
}
 
 
record Alien(int age, String name) {}

 
public class Basics2 {

	public static void main(String[] args) {

		var i=11;
		int j=12;
		System.out.println(i+j);
		
		var nums= new int[2];
		
		Alien a1 = new Alien(1, "Mur");
		Alien a2 = new Alien(2, "Spe");
		System.out.println(a1.name());
		System.out.println(a1.equals(a2));
		
		
	}

}
