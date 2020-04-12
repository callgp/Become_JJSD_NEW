
public class Lab2 {

	public static void main(String[] args){
		
		Student stu1=new Student("jane","1234555");
		Student stu2=new Student("abe","1234592");
		Student stu3=new Student("bava","1234533");
		
	    stu1.enroll("math151");
		stu1.enroll("eng55s");
		stu1.enroll("hist55s");
		//stu1.showCourses();
		stu1.payTuition(800);
		//stu1.checkBalance();
		System.out.println(stu1.toString());
		
	}
}
	
	class Student{
		//properties
		private static int iD=1000;
		private	String name;
		private String ssn;
		private String email;
		private String userId;
		private String courses="";
		private static final int costOfCourse=800;
		private int balance=0;
		private String city;
		private String phone;
		private String zip;
		
		
		
		
		public Student(String name, String ssn){
			iD++;
			this.name=name;
			this.ssn=ssn;
			setUserID();
			setEmail();
		}


		private void setUserID() {
			// TODO Auto-generated method stub
			int max=9000;
			int min=1000;
			int randNum=(int) (Math.random()*(max-min));
			randNum=randNum+min;
			System.out.println("randumnum"+randNum);
			userId= iD+""+randNum+""+ssn.substring(6);
			System.out.println("userid"+userId);
			
			
		}


		private void setEmail() {
			// TODO Auto-generated method stub
			email=name.toUpperCase()+"."+iD+"@abccorp.com";
			System.out.println("email is:"+email);
			
		}
		
	/*	private void setUserId(){
			int randNum=(int) (Math.random()*10000);
			System.out.println("randNum is  "+randNum);
		}*/
		
		
		public void enroll(String course){
			this.courses=this.courses+" "+course;
			//System.out.println("courses===>"+courses);
			System.out.println(courses);
			balance=balance+costOfCourse;
			System.out.println(balance);
			
		}
		
		public void checkBalance(){
			System.out.println("balance is"+balance);
		}

		public void enroll(){
			
		}
		
		
		
		public void showCourses(){
			System.out.println(courses);
		}
		
		public void payTuition(int amount){
			System.out.println("payment  "+amount);
			balance=balance-amount;
			
		}
		
		public String toString(){
			return "name is "+name+ " "+courses+"  "+balance;
		}
		
		
		public String getEmail(){
			return email;
		}
		
		public String getPhone(){
		return phone;
		}
		public String getZip(){
			return zip;
		}
		public String getCity(){
		return city;
		}
		
	}

