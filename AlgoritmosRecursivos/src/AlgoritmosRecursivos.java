
interface Algoritmo {
	double execute(double v);
}

public class AlgoritmosRecursivos {

	public static void main(String[] args) {
		int[] numbers = { 5, 10, 15, 20, 30, 35, 40, 45};
		System.out.println("Fatorial");
		for (int n : numbers) {
			System.out.print("Iterativo: ");
			measureTime(n, (v) -> fat_iterativo(v) );
			System.out.print("Recursivo: ");
			measureTime(n, (v) -> fat_recursivo(v) );
		}
		System.out.println("Fibonacci");
		for (int n : numbers) {
			System.out.print("Iterativo: ");
			measureTime(n, (v) -> fibo_iterativo(v) );
			System.out.print("Recursivo: ");
			measureTime(n, (v) -> fibo_recursivo(v) );
		}
	}

	private static void measureTime(double v, Algoritmo alg) {
		System.out.print("Input: " + v  + " Output: ");
		long s = System.currentTimeMillis();
		System.out.println(alg.execute(v));
		long e = System.currentTimeMillis();
		System.out.println("Tempo: " + ((e-s)/1000) + " s");
	}
	

	private static double fat_iterativo(double v) {
		double res = 1;
		for (int i = 2; i <= v; i++)
			res *= i;
		return res;
	}

	private static double fat_recursivo(double v) {
		if (v < 1) return 1;
		return v*fat_recursivo(v-1);
	}

	private static double fibo_recursivo(double v) {
		if (v <= 0) return 0;
		if (v == 1) return 1;
		return fibo_recursivo(v-1) + fibo_recursivo(v-2);
	}
	
	private static double fibo_iterativo(double v) {
		double f1 = 1, f2 = 0, i = 1;
		while (i <= v) {
			double t = f1 + f2;
			f2 = f1;
			f1 = t;
			i++;
		}
		return f2;
	}
}
