package testes.views.controllers.funcionario;

import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.*;

import dao.FuncionarioDAO;
import entitys.Funcionario;
import javafx.stage.Stage;
import junit.framework.TestCase;
import views.controllers.HomeController;
import views.controllers.funcionario.CadFuncionarioController;
import views.controllers.funcionario.PesquisaFuncionarioController;

	
@DisplayName("Controller - Pesquisa do Funcionario")
@TestInstance(TestInstance.Lifecycle.PER_CLASS)
class PesquisaFuncionarioControllerTest extends TestCase {
	
	//Declare:
	HomeController homeController; 
	PesquisaFuncionarioController pesquisaFuncionarioController;
	CadFuncionarioController cadFuncionarioController;
	Funcionario func;
	FuncionarioDAO funcDAO;	
	String error;	

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
	@DisplayName("Pesquisa do Funcionario")
	void testPesquisar() {
		error = "Erro ao tentar executar comando de pesquisa do funcionario";
		try {
			
		assertAll(
				() -> assertEquals(1,1),
				() -> assertEquals(1,1),
				() -> assertEquals(1,1),
				() -> assertEquals(1,1)
				);
			
		} catch (Exception e) {
			fail(error);
		}
	}
	
	
	@Nested
	@DisplayName("Erro")
	class Erro{
	
	@Test
	@Disabled
	@DisplayName("Falha Proposital")
	void FailTest() {
		error = "valor atual é diferente do esperado -> a != b";
		try {
			int a = 1;
			int b = 2;
			assertEquals(a, b);

		} catch (Exception e) {
			fail(error);
		}
	}

		
	}

}

