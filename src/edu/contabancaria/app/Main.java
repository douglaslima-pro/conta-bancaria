package edu.contabancaria.app;

import java.util.Scanner;
import java.util.Locale;
import edu.contabancaria.model.ContaBancaria;

/**
 * <h2>Objetivo</h2>
 * <p>
 * Crie uma classe {@code Main} com um método <strong>main</strong> para testar
 * sua classe {@code ContaBancaria}.
 * </p>
 * <p>
 * No método main, crie uma instância da {@code ContaBancaria} e realize
 * operações de <strong>depósito</strong> e <strong>saque</strong>.
 * </p>
 * 
 * @author Douglas Souza de Lima
 * @since 13/05/2024
 * @version 01/06/2024
 */
public class Main {

	public static void main(String[] args) {
		Locale.setDefault(Locale.forLanguageTag("pt-BR"));
		Scanner scanner = new Scanner(System.in);
		System.out.println("SISTEMA DE CONTA BANCÁRIA");
		System.out.println();
		System.out.print("Digite o nome do titular: ");
		String titular = scanner.nextLine();
		System.out.print("Digite o saldo da conta: R$ ");
		double saldo = scanner.nextDouble();
		scanner.nextLine(); // Limpa o buffer de entrada
		ContaBancaria conta = new ContaBancaria(titular, saldo);
		int opcao;
		do {
			System.out.println();
			System.out.println("\t1. Realizar depósito");
			System.out.println("\t2. Realizar saque");
			System.out.println("\t3. Visualizar informações da conta");
			System.out.println("\t4. Sair");
			System.out.print("Digite o número da sua opção: ");
			opcao = scanner.nextInt();
			scanner.nextLine(); // Limpa o buffer de entrada
			System.out.println();
			switch (opcao) {
			case 1:
				System.out.print("Digite o valor do depósito: R$ ");
				double valorDeposito = scanner.nextDouble();
				scanner.nextLine(); // Limpa o buffer de entrada
				conta.depositar(valorDeposito);
				break;
			case 2:
				System.out.print("Digite o valor do saque: R$ ");
				double valorSaque = scanner.nextDouble();
				scanner.nextLine(); // Limpa o buffer de entrada
				conta.sacar(valorSaque);
				break;
			case 3:
				System.out.printf("%30s %30s%n", "TITULAR", "SALDO (R$)");
				System.out.printf("%30s %,30.2f%n", conta.getTitular(), conta.getSaldo());
				break;
			case 4:
				System.out.println("Encerrando o programa...");
				break;
			default:
				System.out.println("Opção inválida!");
			}
			System.out.println();
			System.out.println("Aperte ENTER para continuar...");
			scanner.nextLine();
		} while (opcao != 4);
		scanner.close();
		System.out.println();
		System.out.println("Programa encerrado.");
	}

}
