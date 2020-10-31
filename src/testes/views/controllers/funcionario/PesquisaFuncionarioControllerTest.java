package testes.views.controllers.funcionario;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

class PesquisaFuncionarioControllerTest {
	
	String entidadeController = ">Funcionario.PesquisaFuncionarioController";
	String teste;
	String error;

	@Test
	void PesquisaFuncionarioTest() {
	}
	
	
	@Test
	void testGetPesquisaFuncionario() {
		teste = "getPesquisaFuncionario.status";
		error = "ERROR: erro ao tentar executar a tela PesquisaFuncionario";
		try {
			
			//CÓDIOGO DO TESTE VEM AQUI.
			 
			System.out.println(entidadeController + "." + teste + ":\n" + "OK");
		} catch (Exception e) {
			System.out.println(entidadeController + "." + teste + ":\n" + error);
			fail(error);
		}
	}

}
