package app;

import java.util.Scanner;

import datastructures.Pilha;

public class AvaliadorExpressao {

	public static void main(String[] args) {

		String expressao = "2 5 * 4 -";
		Scanner entrada = new Scanner(expressao);
		Pilha<Double> pilha = new Pilha<>();

		while(entrada.hasNext()){
			if(entrada.hasNextDouble()){
				pilha.push(entrada.nextDouble());
			}
			if(entrada.hasNext("[-+/*]")){
				Double rhs = pilha.pop();
				Double lhs = pilha.pop();
				
				switch(entrada.next()){
					case "+":
						pilha.push(lhs + rhs);
						break;
					case "-":
						pilha.push(lhs - rhs);
						break;
					case "/":
						pilha.push(lhs / rhs);
						break;
					case "*":
						pilha.push(lhs * rhs);
						break;
				}
				
			}
					
		}
		System.out.println("Resultado:" + pilha.pop());





	}

}
