import java.util.Comparator;

public class Sorting {

	static Integer[] numeros = { 18, 16, 12, 2, 8, 7, 17, 1, 19, 3, 10 };
	static String[] nomes= { "Ivonei", "Rafael", "Lucia" };
	//static Integer[] numeros = { 1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11 };
	//static Integer[] numeros = { 11, 10, 9, 8, 7, 6, 5, 4, 3, 2, 1 };
	static Integer contadorTroca = 0;
	static Integer contadorTeste = 0;

	private static <T> void troca(T[] a, int i, int j) {
		System.err.println(i + "  - " + j);
		T aux = a[j];
		a[j] = a[i];
		a[i] = aux;		
		contadorTroca++;
	}
	
	public static <T> void bubbleSort(T[] a, Comparator<T> comp) {
					
		for (int i = 0; i < a.length - 1; i++) {
			boolean fezTroca = false;
			for (int j = 0; j < a.length - i - 1; j++) {
				if (comp.compare(a[j], a[j+1]) > 0) {
					troca(a, j, j+1);
					fezTroca = true;
				}
				contadorTeste++;				
			}			
			
			if(!fezTroca){
				return ;
			}
		}
	}

	public static <T> void selectionSort(T[] a, Comparator<T> comp) {
		for (int i = 0; i < a.length -1; i++){
			T min = a[i];
			int n = i;
			
			for(int j = i; j < a.length; j++){
				if(comp.compare(a[j], min) < 0){
					min = a[j];
					n = j;						
				}
			}
			if (n != i){
				troca(a,i,n);
			}
		}
			
	}
	
	public static <T> void insertionSort(T[] a, Comparator<T> comp) {
		
		for(int i = 1; i < a.length; i++){
			contadorTeste++;				
			for(int j = i-1;
					j >= 0;
					j--)
			{
				contadorTeste++;
				if (comp.compare(a[j], a[j+1]) <= 0)
					break;
				troca(a,j,j+1);
			}
		}
		
	}

	public static void main(String[] args) {
		
		insertionSort(numeros, (i,j)-> j-i);
		
		insertionSort(nomes, (i,j)-> i.compareTo(j));
		
		for (Integer n : numeros) {
			System.out.println(n);
		}
		for (String n : nomes) {
			System.out.println(n);
		}
		
		System.out.println("Trocas: " + contadorTroca);
		System.out.println("Testes: " + contadorTeste);
	}
}