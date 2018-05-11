package cenarios;

import operacoes.OperacoesBancarias;

import org.jbehave.core.annotations.Given;
import org.jbehave.core.annotations.Then;
import org.jbehave.core.annotations.When;
import org.junit.Assert;

import entidade.Conta;

public class CenariosOperacoesBancariasSaque {
	
	//Fazer referência ao objeto Conta
	Conta conta;
	
	//Fazer referência ao objeto de negócio
	OperacoesBancarias operacoesBancarias;
	
	String mensagemOperacaoRealizada = "";
	
	@Given("que uma conta possua um saldo de $reais")
	public void inicializarConta(double reais) {
		conta = new Conta(reais);
	}
	@When("realizar um saque de $reais")
	public void realizarPrimeiroSaque(double reais) {
		operacoesBancarias = new OperacoesBancarias();
		mensagemOperacaoRealizada = operacoesBancarias.realizarSaque(conta, reais);
		
	}
	@Then("sistema deverá realizar o saque exibindo a mensagem: $mensagem")
	public void validarSaidaSaque(String mensagem) {
		Assert.assertEquals(mensagem, mensagemOperacaoRealizada);
		
	}	
	//Segundo cenário de testes (saque conta negativo)
	@When("é realizado mais um saque $reais")
	public void realizarSegundoSaque(double reais) {
		operacoesBancarias = new OperacoesBancarias();
		mensagemOperacaoRealizada = operacoesBancarias.realizarSaque(conta, reais);
		
	}
	@Then("sistema exibe a mensagem $mensagem")
	public void validarSegundoSaque(String mensagem) {
		Assert.assertEquals(mensagem, mensagemOperacaoRealizada);
		
	}
	
     
}
