package exc;

import utils.Corretor;

public abstract class Exercicios {
	
	// Exercício 1:
	// Implemente uma função que lê uma lista não vazia e retorna o máximo inteiro positivo presente nela
	public static int maxIntLista(int[] lista) {
		// TODO
		int max = lista[0];
		for (int i = 0; i < lista.length; i++)
			if (max < lista[i])
				max = lista[i];
		return max;
	}
	
	// Exercício 2:
	// Implemente uma função que retorne uma lista com a ordem invertida de seus elementos (inteiros positivos)
	// Exemplo: [1, 4, 2, 7, 3] deve retornar como [3, 7, 2, 4, 1]
	public static int[] inverteLista(int[] lista) {
		// TODO
		int[] lista2 = new int[lista.length];
		for(int i = 0; i < lista.length; i++)
			lista2[i] = lista[lista.length - 1 - i];
		return lista2;
	}
	
	// Exercício 3:
	// Implemente uma função que retorne a soma de todos os elementos de uma lista de inteiros positivos
	// Exemplo: [3, 7, 4, 1, 5, 9] -> deverá retornar 3 + 7 + 4 + 1 + 5 + 9 = 29 
	public static int somaElementos(int[] lista) {
		// TODO
		int soma = 0;
		for (int i = 0; i < lista.length; i++)
			soma += lista[i];
		return soma;
	}
	
	public static void main(String[] args) {
		Corretor.corrigir();
	}
}
