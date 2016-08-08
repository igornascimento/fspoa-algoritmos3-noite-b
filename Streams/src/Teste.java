import java.io.FileNotFoundException;
import java.io.FileReader;
import java.util.Scanner;

public class Teste {

	public static void main(String[] args) {
		
		String filename = "data/routes.txt";
		
		try {		
			CSVFileReader csvArquivo = new CSVFileReader(filename);
			while(csvArquivo.hasNext()){
				csvArquivo.next();
			}
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
