package testcases;

public class TryCatchExample {

	public static void main(String[] args) {
		TryCatchExample a = new TryCatchExample();
		String val = a.testTryCatch();
		System.out.println(val);
	}
	
	@SuppressWarnings("finally")
	public String testTryCatch() {
		
		String temp="";
		try {
			throw new ArithmeticException();
		}catch (Exception e) {
			System.out.println("in catch");
			temp =  "catch";
			System.out.println("temp value is: "+temp);
			return temp;
		}finally {
			System.out.println("in finally");
			System.out.println("temp value brfore finally is : "+temp);
			temp =  "finally";
			System.out.println("temp value is: "+temp);
			return temp;
		}
	}

}
