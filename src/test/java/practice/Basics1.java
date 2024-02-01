package practice;

public class Basics1 {

	public static void main(String[] args) {
		
		var i =10;
		System.out.println(i);

		String day = "Saturday";
		String result, result1="";
		
		result = switch(day) 
		{
		case "Saturday", "Sunday"-> "7am";
		case "Monday" -> "6am";
		default->"8am";
	
		};
		
		result1 = switch(day) 
				{
				case "Saturday", "Sunday": yield  "7am";
				case "Monday" : yield  "6am";
				default : yield "8am";
			
				};
		System.out.println(result1);
		
	}

}
