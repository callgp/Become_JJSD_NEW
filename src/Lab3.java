import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

public class Lab3 {

	private static boolean hasInvalidCharacter;

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		String filename = "C:\\gpFolder\\gpJava\\Passwords.txt";
		String[] passwords = new String[3];

		File file = new File(filename);
		try {
			BufferedReader br = new BufferedReader(new FileReader(file));
			for (int i = 0; i < passwords.length; i++) {
				passwords[i] = br.readLine();
			}
		} catch (FileNotFoundException e) {
			System.out.println("error could not open file as not there");
		} catch (IOException e) {
			System.out.println("count not read file");
		}
		// test againest our criteria
		for (String password : passwords) {
			System.out.println("iteration number");
			System.out.println("***\n" + password);
		//	boolean hasInvalidCharacter = false;
			boolean hasLetter = false;
			boolean hasNumber = false;
			boolean hasSpecialChar = false;
			System.out.println("password lenght is------>"+password.length());
			
			
			for (int n = 0; n < password.length(); n++) {
				// cond 1 contain nbr
				if ("0123456789".contains(password.substring(n, n + 1))) {
					hasNumber = true;
					System.out.println("postion " + n + " contains " + password.substring(n, n + 1) + " a nbrs");
				}

				// cond 2 contain letter
				else if ("abcdefghijklmnopqrstuvwxyz".contains(password.substring(n, n + 1))) {
					hasLetter = true;
					System.out.println("postion " + n + " contains " + password.substring(n, n + 1) + " a letter");
				}
				// cond 3 contain spl character
				else if ("!".contains(password.substring(n, n + 1))) {
					hasSpecialChar = true;
					//System.out.println("postion " + n + " contains " + password.substring(n, n + 1) + " a spl letter");
				}

				else {
					// hasInvalidCharacter=true;
					// System.out.println("position "+n+" has invalid char");
					//System.out.println("valid password###########################################great");

					try {
						throw new InvalidCharacterException(password.substring(n, n + 1));
					} catch (InvalidCharacterException e) {
						// TODO Auto-generated catch block
						e.toString();
					//	break;//if comment break special character exc not coming why???
					}
				}

			}
			// test exception handling
			/*
			 * if(hasInvalidCharacter){ //thoru invalid char exc
			 * System.out.println("invalid char"); }
			 */

			/*
			 * else if(!hasNumber|| !hasLetter||!hasSpecialChar){
			 * System.out.println("missing criteria");
			 * 
			 * }
			 */
			try {
				if (!hasNumber) {
					throw new NumberCriteriaException(password);
				} else if (!hasLetter) {
					throw new LetterCriteriaException(password);
				} else if (!hasSpecialChar) {
					throw new SpecialCharacterCriteriaException(password);
				} else {
					System.out.println("valid pwd........great");
				}
			} catch (NumberCriteriaException | LetterCriteriaException | SpecialCharacterCriteriaException e) {
				System.out.println("invaid pwd-------,,,,");
				System.out.println(e.toString());

			}

		}
	}
}

class InvalidCharacterException extends Exception {
	String ch;

	public InvalidCharacterException(String ch) {
		this.ch = ch;

	}

	public String toString() {
		return "InvalidCharacterException****: " + ch;
	}
}

class NumberCriteriaException extends Exception {
	String password;

	public NumberCriteriaException(String password) {
		this.password = password;

	}

	public String toString() {
		return "NumberCriteriaException****: " + password;
	}
}

class LetterCriteriaException extends Exception {
	String ch;

	public LetterCriteriaException(String ch) {
		this.ch = ch;

	}

	public String toString() {
		return "LetterCriteriaException****: " + ch;
	}
}

class SpecialCharacterCriteriaException extends Exception {
	String ch;

	public SpecialCharacterCriteriaException(String ch) {
		this.ch = ch;

	}

	public String toString() {
		return "SpecialCharacterCriteriaException****: " + ch;
	}
}
