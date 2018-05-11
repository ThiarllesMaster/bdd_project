package cenarios;

import org.jbehave.core.annotations.Given;
import org.jbehave.core.annotations.Then;
import org.jbehave.core.annotations.When;
import org.junit.Assert;

import operacoes.OperacoesBancarias;
import entidade.Conta;

public class CenariosOperacoesBancariasDeposito {
	
	// Fazer referência ao objeto Conta
	Conta conta;

	// Fazer referência ao objeto de negócio
	OperacoesBancarias operacoesBancarias;
	
	//Fazer referência a mensagem de validação
	public String mensagemValidacao;
	
	@Given("Dado que eu possuo minha conta (sem número informado)")
	public void inicializarContaPrimeiroCenario() {
		conta = new Conta("");
		operacoesBancarias = new OperacoesBancarias();
	}
	@When("realizar um depósito bancário no valor de $reais")
	public void realizarDepositoPrimeiroCenario(double reais) {
		mensagemValidacao = operacoesBancarias.realizarDepositoBancario(conta, reais);
	}
	@Then("sistema deverá exibir a mensagem: $mensagemValidacao")
	public void validarNumeroInformado(String mensagemValidacao){
		Assert.assertEquals(mensagemValidacao, this.mensagemValidacao);
		
	}
	//Segundo cenário
	@Given("Dado que eu possuo minha conta $numeroConta o valor de $reais")
	public void inicializarContaSegundoCenario(String numeroConta, double reais) {
		conta = new Conta(numeroConta);
		conta.setSaldo(reais);
		operacoesBancarias = new OperacoesBancarias();
	}
	@When("realizar um depósito bancário de $reais")
	public void realizarDepositoSegundoCenario(double reais) {
		mensagemValidacao = operacoesBancarias.realizarDepositoBancario(conta, reais);
	}
	@Then("sistema exibe: Você possui na conta: $numeroConta o valor de $valor")
	public void validarValorSegundoCenario(String numeroConta, double valor){
		String mensagem = "Você possui na conta: " + numeroConta + " o valor de " + valor;
		Assert.assertEquals(mensagem, this.mensagemValidacao);
		
	}
	
	

}
