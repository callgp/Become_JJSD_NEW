import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class Lab4 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		List<String[]> transactions = new ArrayList<String[]>();
		String filename = "C:\\gpFolder\\gpJava\\CCStatement.csv";
		String dataRow;
		double balance = 0;
		try {
			BufferedReader br = new BufferedReader(new FileReader(filename));
			// read data as lng as it is not empty

			while ((dataRow = br.readLine()) != null) {
				// parse data by commas
				String[] line = dataRow.split(",");
				// add the data to collection
				transactions.add(line);
			}
			br.close();

		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
		// read data as long not empty
		System.out.println("DATE|TRANSACTION|VENDOR|AMOUNT|BALANCE");

		for (String[] transaction : transactions) {/*
													 * 
													 * for (String
													 * field:transaction){
													 * //System.out.println(
													 * field); System.out.print(
													 * field+" "); }
													 * System.out.println();
													 */

			String date = transaction[0];
			String type = transaction[1];
			String vendor = transaction[2];
			double amount = Double.parseDouble(transaction[3]);
			System.out.print(date + "| " + type + "| " + vendor + "| " + amount);

			if (type.equalsIgnoreCase("credit")) {
				// System.out.println("add to balance");
				balance = balance + amount;
			}

			else if (type.equalsIgnoreCase("debit")) {
				// System.out.println("subtract from balance");
				balance = balance - amount;
			} else {
				// System.out.println("some other trns");
			}
			System.out.print(" |" + balance + "\n");
			// System.out.println("new balance"+balance);
		}
		// System.out.print("********************new balance***"+balance);
		
		if(balance>0){
			System.out.println("you have a balance of"+balance);
			System.out.println("you have a charge of"+0.1*balance);
			System.out.println("new balance is"+1.1*balance);
		}
		
		if(balance<0){
			System.out.println("thank you"+balance);
			System.out.println("you have excess pmt"+balance);
			//System.out.println("new balance is"+1.1*balance);
		}

	}
}
