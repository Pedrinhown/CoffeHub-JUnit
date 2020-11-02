package testes.views.controllers.funcionario;

import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.*;

import dao.FuncionarioDAO;
import entitys.Funcionario;
import junit.framework.TestCase;
import views.controllers.HomeController;
import views.controllers.funcionario.CadFuncionarioController;
import views.controllers.funcionario.PesquisaFuncionarioController;

@TestInstance(TestInstance.Lifecycle.PER_CLASS)
class PesquisaFuncionarioControllerTest extends TestCase {
	
	//Declare:
	HomeController homeController; 
	PesquisaFuncionarioController pesquisaFuncionarioController;
	CadFuncionarioController cadFuncionarioController;
	Funcionario func;
	FuncionarioDAO funcDAO;	
	
	String error = "mensagem que s� aparece se o m�todo n�o tem declara��o para vari�vel -String error, isso � poss�vel por causa do -TestInstance.Lifecycle.PER_CLASS";

	@BeforeEach
	@DisplayName("Init Pesquisa Funcionario")
	void init() {
		homeController = new HomeController();
		pesquisaFuncionarioController = new PesquisaFuncionarioController();
		cadFuncionarioController = new CadFuncionarioController();
		func = new Funcionario();
		funcDAO = new FuncionarioDAO();		
	}
	
	
	@Test
	@DisplayName("Teste Inicializacao da Tela Pesquisa Funcionario")
	void testGetPesquisaFuncionario() {
		error = "ERROR: erro ao tentar executar a tela PesquisaFuncionario";
		try {
			
			//assertEquals(expected, actual);			
			
		} catch (Exception e) {
			fail(error);
		}
	}

}
