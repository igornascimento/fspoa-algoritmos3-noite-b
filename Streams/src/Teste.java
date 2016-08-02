import java.io.FileNotFoundException;
import java.io.FileReader;
import java.util.Scanner;

public class Teste {

	
	public static void main(String[] args) {
		
		
		try {
			Scanner scanner = new Scanner(new FileReader("data/routes.txt"));
			String linha = scanner.nextLine();
			
			while (scanner.hasNext()){
				linha = scanner.nextLine();
				String [] lista = linha.split(",");
//				System.out.println(lista[0]);
				Route route = new Route();
				route.setId(lista[0]);
				route.setAgencyId(lista[1]);
				System.out.println("Agencia:" + route.getAgencyId());				
			}
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
	}
}
