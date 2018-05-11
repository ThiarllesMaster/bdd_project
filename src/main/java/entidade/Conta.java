/**
 * Classe conta (entidade de negócio)
 * @author thiarlles.gomes
 */

package entidade;

public class Conta {
	
	private double saldo;
	private String nroConta;

	public Conta(double saldo) {
		this.saldo = saldo;
	}

	public Conta(String nroConta) {
		this.nroConta = nroConta;
	}

	public void setSaldo(double saldo) {
		this.saldo = saldo;
	}

	public double getSaldo() {
		return saldo;
	}

	public void setNroConta(String nroConta) {
		this.nroConta = nroConta;
	}

	public String getNroConta() {
		return nroConta;
	}

}
