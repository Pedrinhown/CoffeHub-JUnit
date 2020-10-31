package testes.views.controllers.funcionario;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

class CadFuncionarioControllerTest {

	String entidadeController = ">Funcionario.CadFuncionarioController";
	String teste;
	String error;
	
	@Test
	void CadFuncionarioTest() {
		
	}
	
	@Test
	void testGetCadFuncionario() {
		teste = "GetCadFuncionario.status";
		error = "ERROR: erro ao tentar executar a tela CadFuncionario";
		try {
			
			//CÓDIOGO DO TESTE VEM AQUI.
			 
			System.out.println(entidadeController + "." + teste + ":\n" + "OK");
		} catch (Exception e) {
			System.out.println(entidadeController + "." + teste + ":\n" + error);
			fail(error);
		}
	}
		
	@Test
	void testInitializeURLResourceBundle() {
		teste = "initializeURLResourceBundle.status";
		error = "ERROR: erro ao tentar distinguir entre tela inicializar tela cadastro ou tela edicao, verificar retorno de id";
		try {
			
			//CÓDIOGO DO TESTE VEM AQUI.
			 
			System.out.println(entidadeController + "." + teste + ":\n" + "OK");
		} catch (Exception e) {
			System.out.println(entidadeController + "." + teste + ":\n" + error);
			fail(error);
		}
	}

	@Test
	void testInitialize() {
		teste = "initialize.status";
		error = "ERROR: erro ao tentar inicializar testes primarios de objetos incorporados do JavaFX.SceneBuilder";
		try {
			
			//CÓDIOGO DO TESTE VEM AQUI.
			 
			System.out.println(entidadeController + "." + teste + ":\n" + "OK");
		} catch (Exception e) {
			System.out.println(entidadeController + "." + teste + ":\n" + error);
			fail(error);
		}
	}

	
	

}
