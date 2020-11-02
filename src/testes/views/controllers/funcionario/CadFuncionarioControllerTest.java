package testes.views.controllers.funcionario;

import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.*;

import dao.FuncionarioDAO;
import entitys.Funcionario;
import views.controllers.HomeController;
import views.controllers.funcionario.CadFuncionarioController;
import views.controllers.funcionario.PesquisaFuncionarioController;

@TestInstance(TestInstance.Lifecycle.PER_CLASS)
class CadFuncionarioControllerTest {
	
	HomeController homeController; 
	PesquisaFuncionarioController pesquisaFuncionarioController;
	CadFuncionarioController cadFuncionarioController;
	Funcionario func;
	FuncionarioDAO funcDAO;	
	
	String error = "mensagem que só aparece se o método não tem declaração para variável -String error, isso é possível por causa do -TestInstance.Lifecycle.PER_CLASS";

	@BeforeEach
	@DisplayName("Init Cadastro Funcionario")
	void init() {
		homeController = new HomeController();
		pesquisaFuncionarioController = new PesquisaFuncionarioController();
		cadFuncionarioController = new CadFuncionarioController();
		func = new Funcionario();
		funcDAO = new FuncionarioDAO();		
	}
	
	@Test
	@DisplayName("Falha Proposital")
	void FailTest() {
		error = "valor atual é diferente do esperado -> a != b";
		try {
			int a = 1;
			int b = 2;
			assertEquals(a, b, error);

		} catch (Exception e) {
			fail(error);
		}
	}
	
	
	@Test
	@DisplayName("Teste Inicializacao da Tela Cadastro Funcionario")
	void testGetCadFuncionario() {
		error = "ERROR: erro ao tentar executar a tela CadFuncionario";
		try {
			
			//assertEquals(expected, actual);			
			 
		} catch (Exception e) {
			fail(error);
		}
	}
		
}
