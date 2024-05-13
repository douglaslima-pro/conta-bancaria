package edu.contabancaria.model;

/**
 * <h2>Objetivo</h2>
 * <p>
 * Implementar uma classe {@code ContaBancaria} em Java que simule operações
 * bancárias básicas com encapsulamento dos dados.
 * </p>
 * 
 * @author Douglas Souza de Lima
 * @since 13/05/2024
 */
public class ContaBancaria {

	/**
	 * <p>
	 * Nome do titular da conta
	 * </p>
	 */
	private String titular;
	/**
	 * <p>
	 * Saldo da conta
	 * </p>
	 */
	private double saldo;

	/**
	 * <p>
	 * Cria um objeto do tipo {@code ContaBancaria}.
	 * </p>
	 * 
	 * @param titular Nome do titular da conta
	 * @param saldo   Valor do saldo da conta
	 */
	public ContaBancaria(String titular, double saldo) {
		this.titular = titular;
		this.saldo = saldo;
	}

	/**
	 * <p>
	 * Realiza o <strong>depósito</strong> de um valor na conta bancária.
	 * </p>
	 * <p>
	 * <strong>Obs.:</strong> O valor de depósito precisa ser positivo e maior que
	 * zero.
	 * </p>
	 * 
	 * @param valor Valor do depósito
	 * @return True se o depósito for realizado com sucesso, falso o contrário
	 */
	public boolean depositar(double valor) {
		if (valor > 0) {
			this.saldo += valor;
			System.out.println("Depósito realizado com sucesso!");
			System.out.printf("R$ %.2f foram depositados na conta.%n", valor);
			return true;
		} else {
			System.out.println("Falha ao realizar o depósito!");
			System.out.println("Valor de depósito deve ser positivo e maior que zero!");
			return false;
		}
	}

	/**
	 * <p>
	 * Realiza o <strong>saque</strong> de um valor da conta bancária.
	 * </p>
	 * <p>
	 * <strong>Obs.:</strong> O valor de saque não pode ser maior que o saldo da
	 * conta.
	 * </p>
	 * 
	 * @param valor Valor do saque
	 * @return True se o saque for realizado com sucesso, falso o contrário
	 */
	public boolean sacar(double valor) {
		if (valor <= this.saldo) {
			this.saldo -= valor;
			System.out.println("Saque realizado com sucesso!");
			System.out.printf("R$ %.2f foram sacados da conta.%n", valor);
			return true;
		} else {
			System.out.println("Falha ao realizar o saque!");
			System.out.println("Valor de saque não pode ser maior que o saldo da conta!");
			return false;
		}
	}

	/**
	 * <p>
	 * Define o valor do atributo titular.
	 * </p>
	 * 
	 * @param titular Nome do titular da conta
	 */
	public void setTitular(String titular) {
		this.titular = titular;
	}

	/**
	 * <p>
	 * Retorna um valor do tipo {@code String} com o nome do titular da conta.
	 * </p>
	 * 
	 * @return Nome do titular da conta
	 */
	public String getTitular() {
		return this.titular;
	}

	/**
	 * <p>
	 * Retorna um valor do tipo {@code double} com o saldo da conta.
	 * </p>
	 * 
	 * @return Saldo da conta
	 */
	public double getSaldo() {
		return this.saldo;
	}

}
