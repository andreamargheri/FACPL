import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.PrintStream;


public class test {

	/**
	 * @param args
	 * @throws FileNotFoundException 
	 */
	public static void main(String[] args) throws FileNotFoundException {
		String code_gen = "Policy <>";
		FileOutputStream f = new FileOutputStream("./out/policy.fpl");
	    PrintStream p = new PrintStream(f);
	    p.println(code_gen);
	    p.close();
	}

}
