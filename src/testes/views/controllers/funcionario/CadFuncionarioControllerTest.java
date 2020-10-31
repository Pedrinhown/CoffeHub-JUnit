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
	void testBtnDemitir_Action() {
		teste = "btnDemitir_Action.status";
		error = "ERROR: erro na demissao ao tentar pressionar o botao demitir";
		try {
			
			//CÓDIOGO DO TESTE VEM AQUI.
			 
			System.out.println(entidadeController + "." + teste + ":\n" + "OK");
		} catch (Exception e) {
			System.out.println(entidadeController + "." + teste + ":\n" + error);
			fail(error);
		}
	}

	@Test
	void testBtnEditar_Action() {
		teste = "btnEditar_Action.status";
		error = "ERROR: erro na edicao ao tentar pressionar o botao editar";
		try {
			
			//CÓDIOGO DO TESTE VEM AQUI.
			 
			System.out.println(entidadeController + "." + teste + ":\n" + "OK");
		} catch (Exception e) {
			System.out.println(entidadeController + "." + teste + ":\n" + error);
			fail(error);
		}
	}

	@Test
	void testBtnExcluir_Action() {
		teste = "btnExcluir_Action.status";
		error = "ERROR: erro no excluir ao tentar pressionar o botao excluir";
		try {
			
			//CÓDIOGO DO TESTE VEM AQUI.
			 
			System.out.println(entidadeController + "." + teste + ":\n" + "OK");
		} catch (Exception e) {
			System.out.println(entidadeController + "." + teste + ":\n" + error);
			fail(error);
		}
	}

	@Test
	void testBtnGravar_Action() {
		teste = "btnGravar_Action.status";
		error = "ERROR: erro no editar ao tentar pressionar o botao editar";
		try {
			
			//CÓDIOGO DO TESTE VEM AQUI.
			 
			System.out.println(entidadeController + "." + teste + ":\n" + "OK");
		} catch (Exception e) {
			System.out.println(entidadeController + "." + teste + ":\n" + error);
			fail(error);
		}
	}

	@Test
	void testBtnLimpar_Action() {
		teste = "btnLimpar_Action.status";
		error = "ERROR: erro ao tentar limpar campos, quando pressiona o botao limpar";
		try {
			
			//CÓDIOGO DO TESTE VEM AQUI.
			 
			System.out.println(entidadeController + "." + teste + ":\n" + "OK");
		} catch (Exception e) {
			System.out.println(entidadeController + "." + teste + ":\n" + error);
			fail(error);
		}
	}

	@Test
	void testBtnVoltar_Action() {
		teste = "btnVoltar_Action.status";
		error = "ERROR: erro ao tentar voltar para pagina anterior ao clicar no botao voltar";
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
		error = "ERROR: erro ao tentar distinguir entre inicializ tela cadastro ou tela edicao, verificar retorno de id";
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
