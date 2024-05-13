package edu.contabancaria.app;

import java.io.*;
import java.util.Scanner;
import java.util.Locale;
import edu.contabancaria.model.ContaBancaria;

/**
 * <h2>Objetivo</h2>
 * <p>
 * Crie uma classe {@code Main} com um método <em>main</em> para testar sua
 * classe {@code ContaBancaria}.
 * </p>
 * <p>
 * No método main, crie uma instância da ContaBancaria e realize operações de
 * depósito e saque.
 * </p>
 * 
 * @author Douglas Souza de Lima
 * @since 13/05/2024
 */
public class Main {

	public static Scanner sc = new Scanner(System.in);

	public static void main(String[] args) {
		Locale.setDefault(Locale.forLanguageTag("pt-BR"));
		int opcao;
		System.out.println("CONTA BANCÁRIA");
		exibirMenuInicial();
		System.out.print("Digite a sua opção: ");
		opcao = Main.sc.nextInt();
		Main.sc.nextLine(); // Limpa o buffer de entrada
		ContaBancaria conta;
		if (opcao == 1) {
			System.out.println();
			conta = criarConta();
			manterConta(conta);
		}
		Main.sc.close();
		System.out.println();
		System.out.println("Fim da execução.");
	}

	public static void exibirMenuInicial() {
		System.out.println("1. Criar conta");
		System.out.println("2. Sair");
	}

	public static void exibirMenuConta() {
		System.out.println("1. Realizar depósito");
		System.out.println("2. Realizar saque");
		System.out.println("3. Visualizar informações da conta");
		System.out.println("4. Sair");
	}

	public static ContaBancaria criarConta() {
		String titular;
		double saldo;
		System.out.print("Digite o nome do titular: ");
		titular = Main.sc.nextLine();
		System.out.print("Digite o saldo da conta: R$ ");
		saldo = Main.sc.nextDouble();
		ContaBancaria conta = new ContaBancaria(titular, saldo);
		return conta;
	}

	public static void visualizarConta(ContaBancaria conta) {
		System.out.println("Titular: " + conta.getTitular());
		System.out.printf("Saldo: R$ %.2f%n", conta.getSaldo());
	}

	public static ContaBancaria realizarDeposito(ContaBancaria conta, double valor) {
		double saldoInicial = conta.getSaldo();
		double saldoFinal;
		if (conta.depositar(valor)) {
			saldoFinal = conta.getSaldo();
			System.out.println();
			System.out.printf("Saldo inicial: R$ %.2f%n", saldoInicial);
			System.out.printf("Saldo final: R$ %.2f%n", saldoFinal);
		}
		return conta;
	}

	public static ContaBancaria realizarSaque(ContaBancaria conta, double valor) {
		double saldoInicial = conta.getSaldo();
		double saldoFinal;
		if (conta.sacar(valor)) {
			saldoFinal = conta.getSaldo();
			System.out.println();
			System.out.printf("Saldo inicial: R$ %.2f%n", saldoInicial);
			System.out.printf("Saldo final: R$ %.2f%n", saldoFinal);
		}
		return conta;
	}

	public static void manterConta(ContaBancaria conta) {
		int opcao;
		double valor;
		System.out.println();
		exibirMenuConta();
		System.out.print("Digite a sua opção: ");
		opcao = Main.sc.nextInt();
		System.out.println();
		switch (opcao) {
		case 1:
			System.out.print("Digite o valor do depósito: R$ ");
			valor = Main.sc.nextDouble();
			conta = realizarDeposito(conta, valor);
			break;
		case 2:
			System.out.print("Digite o valor do saque: R$ ");
			valor = Main.sc.nextDouble();
			conta = realizarSaque(conta, valor);
			break;
		case 3:
			visualizarConta(conta);
			break;
		case 4:
			return;
		default:
			System.out.println("Opção inválida!");
		}
		manterConta(conta);
	}

}
