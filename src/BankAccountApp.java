
public class BankAccountApp {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		BankAccount acc1=new BankAccount("773411",1000);
		BankAccount acc2=new BankAccount("773422",2000);
		BankAccount acc3=new BankAccount("773433",2500);
		acc1.setName("jim");
		System.out.println("getting name "+acc1.getName());
		acc1.makeDeposit(201);
		acc1.makeDeposit(100);
		acc1.payBill(50);
		acc1.accrue();
		System.out.println(acc1.toString());

	}
}
	
	class BankAccount implements IInterest{
		
		private static int iD=1000;
		private static final String routingNumber="123456";
		private String accountNumber;//id+random nbr 2 digit+first 2 of ssn
		//private String routingNumber;
		private String name;
		private String SSN;
		private double balance;
		
		//contructor
		public BankAccount(String SSN, double initDeposit){
			System.out.println("account created");
			balance=initDeposit;
			iD++;
			System.out.println("iD "+iD);
			this.SSN=SSN;
			setAccountNumber();
		}

		private void setAccountNumber() {
			// TODO Auto-generated method stub
			int random=(int) (Math.random()*100);
			System.out.println("random "+random);
			accountNumber=iD+""+SSN.substring(0, 1);
			System.out.println("acct nbr "+accountNumber);
			
		}
		
		public void setName(String name){
			this.name=name;
		}
		
		public String getName(){
			return name;
		}
		
		public void payBill(double amount){
			balance=balance-amount;
			System.out.println("paying bill");
			showBalance();
		}
		
		
		public void makeDeposit(double amount){
		balance=balance-amount;
		System.out.println("making depoisits");
		showBalance();
	}
		
		public void showBalance(){
			System.out.println("balance "+balance);
		}
		
		public void accrue(){
			balance =balance*(1+rate/100);
			showBalance();
		}
		
		@Override
		public String toString(){
			return "[name "+name+"]\n{account number"+accountNumber+"]\n[routing numb er "+routingNumber+"]\n[balance "+balance+"]";
		}
	}

