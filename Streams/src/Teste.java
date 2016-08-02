import java.io.FileNotFoundException;
import java.io.FileReader;
import java.util.Scanner;

public class Teste {

	
	public static void main(String[] args) {
		
		
		try {
		
			CSVFileReader csvArquivo = new CSVFileReader("data/routes.txt");
			
			while(csvArquivo.hasNext()){
				csvArquivo.next();
			}	
			
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
	}
}
