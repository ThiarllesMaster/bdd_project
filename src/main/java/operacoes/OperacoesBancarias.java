/**
 * Classe responsável por conter as operações bancarias (depositar e sacar)
 */
package operacoes;

import entidade.Conta;

public class OperacoesBancarias {

	/**
	 * Método desenvolvido para operações de saque
	 * @param conta
	 * @param valor
	 * @return
	 */
	public String realizarSaque(Conta conta, double valor) {
		if (conta.getSaldo() < valor) {
			return "Saldo indisponível";

		} else {
			conta.setSaldo(conta.getSaldo() - valor);
			return "Saque realizado com sucesso";

		}
	}
	/**
	 * Método desenvolvido para realizar operações de depósito bancário
	 * @param conta
	 * @param valorDepositado
	 * @return
	 */
	public String realizarDepositoBancario(Conta conta, double valorDepositado) {
		if (conta.getNroConta().isEmpty()) {
			return "Você deve informar o número da conta";
		}
		conta.setSaldo(conta.getSaldo() + valorDepositado);
		return "Você possui na conta: " + conta.getNroConta() + " o valor de " + Double.valueOf(conta.getSaldo());		
	}

}
