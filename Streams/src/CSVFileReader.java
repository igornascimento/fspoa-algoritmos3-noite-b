import java.io.FileNotFoundException;
import java.io.FileReader;
import java.util.Scanner;

public class CSVFileReader {

	private Scanner scanner;

	public CSVFileReader(String string) throws FileNotFoundException {
		scanner = new Scanner(new FileReader("data/routes.txt"));
		scanner.nextLine();
		
	}

	public boolean hasNext() {
		return scanner.hasNext();
	}

	public String[] next() {
		String linha = scanner.nextLine();
		String [] lista = linha.split(",");
		return lista;
		
	}

}
