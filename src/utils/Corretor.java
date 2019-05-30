package utils;

import java.util.Arrays;

import exc.Exercicios;

public abstract class Corretor {
	private static int[] pontuacao = new int[3];
	private static Gabarito[] gabaritos = geraGabaritos();
	private static final int NUMERO_DE_QUESTOES = 3;
	private static final int NUMERO_DE_TESTES = 5;
	
	private static Gabarito[] geraGabaritos() {
		int[][] listas = new int[5][];
		int[][] respostas = new int[5][];
		Gabarito[] gabaritos = new Gabarito[3 * 5];

		// maior inteiro
		listas[0] = new int[] {3, 7, 4, 1, 5, 9};
		listas[1] = new int[] {10};
		listas[2] = new int[] {3, 3, 3, 3, 3, 3};
		listas[3] = new int[] {9, 5};
		listas[4] = new int[] {2000, 299, 345, 56, 23, 1, 25, 58, 34534, 89, 32, 12, 132};
		respostas[0] = new int[] {9};
		respostas[1] = new int[] {10};
		respostas[2] = new int[] {3};
		respostas[3] = new int[] {9};
		respostas[4] = new int[] {34534};
		gabaritos[0] = new Gabarito(listas, respostas);
		
		// inversão de listas
		listas = new int[5][];
		respostas = new int[5][];
		listas[0] = new int[] {3, 7, 4, 1, 5, 9};
		listas[1] = new int[] {1, 1, 1, 3, 1};
		listas[2] = new int[] {1, 2, 1, 2, 1, 2};
		listas[3] = new int[] {9, 5};
		listas[4] = new int[] {9, 8, 7, 6, 5, 4, 3, 2, 1};
		respostas[0] = new int[] {9, 5, 1, 4, 7, 3};
		respostas[1] = new int[] {1, 3, 1, 1, 1};
		respostas[2] = new int[] {2, 1, 2, 1, 2};
		respostas[3] = new int[] {5, 9};
		respostas[4] = new int[] {1, 2, 3, 4, 5, 6, 7, 8, 9};
		gabaritos[1] = new Gabarito(listas, respostas);
		
		// soma dos elementos
		listas = new int[5][];
		respostas = new int[5][];
		listas[0] = new int[] {3, 7, 4, 1, 5, 9};
		listas[1] = new int[] {1};
		listas[2] = new int[] {3, 3, 3, 3, 3, 3};
		listas[3] = new int[] {9, 5};
		listas[4] = new int[] {9, 8, 7, 6, 5, 4, 3, 2, 1};
		respostas[0] = new int[] {29};
		respostas[1] = new int[] {1};
		respostas[2] = new int[] {18};
		respostas[3] = new int[] {14};
		respostas[4] = new int[] {45};
		gabaritos[2] = new Gabarito(listas, respostas);
		
		for (int i = 0; i < 3; i++)
			pontuacao[i] = 0;
		
		return gabaritos;
	}
	
	private static void espera(int millis) {
		try {
			Thread.sleep(millis);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}
	
	public static void corrigir() {
		corrige1();
		corrige2();
		corrige3();
		
		int media = 0;
		for (int i = 0; i < pontuacao.length; i++)
			media += pontuacao[i];
		System.out.printf(">> Média Final: %.1f", new Float(media) / (pontuacao.length * NUMERO_DE_TESTES) * 10);
	}
	
	private static void corrige1() {
		System.out.println("=== Correção do Exercício 1 ===");
		try {
			for (int i = 0; i < NUMERO_DE_TESTES; i++) {
				int max = Exercicios.maxIntLista(gabaritos[0].listas[i]);
				if (max == gabaritos[0].respostas[i][0])
					pontuacao[0]++;
				System.out.printf("Entrada: %60s | Resultado: %5d | Resposta: %5d\n", Arrays.toString(gabaritos[0].listas[i]), max, gabaritos[0].respostas[i][0]);
			}
		} catch (Exception e) {
			System.out.println("*** Erro na implementação do Exercício 1:");
			e.printStackTrace();
			espera(50);
		}
		System.out.printf(">> Pontuação no Exercício 1: %.1f\n\n", new Float(pontuacao[0]) / new Float(NUMERO_DE_TESTES) * 10);
	}
	
	private static void corrige2() {
		boolean correto = true;
		int[] resposta = null;
		System.out.println("=== Correção do Exercício 2 ===");
		try {
			for (int i = 0; i < NUMERO_DE_TESTES; i++) {
				resposta = Exercicios.inverteLista(gabaritos[1].listas[i]);
				for (int j = 0; j < gabaritos[1].respostas[i].length; j++) {
					if (resposta[j] != gabaritos[1].respostas[i][j])
						correto = false;
				}
				if (correto)
					pontuacao[1]++;
				correto = true;
				System.out.printf("Entrada: %30s | Resultado: %30s | Resposta: %s\n", Arrays.toString(gabaritos[1].listas[i]), Arrays.toString(resposta), gabaritos[0].respostas[i][0]);
			}
		} catch (Exception e) {
			System.out.println("*** Erro na implementação do Exercício 2:");
			e.printStackTrace();
			espera(50);
		}
		System.out.printf(">> Pontuação no Exercício 2: %.1f\n\n", new Float(pontuacao[1]) / new Float(NUMERO_DE_TESTES) * 10);
	}
	
	private static void corrige3() {
		System.out.println("=== Correção do Exercício 3 ===");
		try {
			for (int i = 0; i < NUMERO_DE_TESTES; i++) {
				int soma = Exercicios.somaElementos(gabaritos[2].listas[i]);
				Exercicios.somaElementos(gabaritos[2].listas[i]);
				if (soma == gabaritos[2].respostas[i][0])
					pontuacao[2]++;
				System.out.printf("Entrada: %30s | Resultado: %3d | Resposta: %3d\n", Arrays.toString(gabaritos[2].listas[i]), soma, gabaritos[0].respostas[i][0]);
			}
		} catch (Exception e) {
			System.out.println("*** Erro na implementação do Exercício 3:");
			e.printStackTrace();
			espera(50);
		}
		System.out.printf(">> Pontuação no Exercício 3: %.1f\n\n", new Float(pontuacao[2]) / new Float(NUMERO_DE_TESTES) * 10);
	}
	
}
