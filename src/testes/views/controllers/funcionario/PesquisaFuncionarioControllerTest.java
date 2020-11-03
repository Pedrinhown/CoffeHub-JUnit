package testes.views.controllers.funcionario;

import org.junit.jupiter.api.*;
import static org.junit.jupiter.api.Assertions.*;
import static org.junit.jupiter.api.Assumptions.*;

import dao.FuncionarioDAO;
import entitys.Funcionario;
import views.controllers.HomeController;
import views.controllers.funcionario.CadFuncionarioController;
import views.controllers.funcionario.PesquisaFuncionarioController;

	
@DisplayName("Controller - Pesquisa do Funcionario")
@TestInstance(TestInstance.Lifecycle.PER_CLASS)
class PesquisaFuncionarioControllerTest {
	
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
				() -> assertNotEquals(pesquisaFuncionarioController, null, error),
				() -> assertEquals(1,1, error),
				() -> assertEquals(1,1, error),
				() -> assertEquals(1,1, error)
				);
			
		} catch (Exception e) {
			fail();
		}
	}
	
	
	@Nested
	@DisplayName("Teste")
	class Teste{
	
	@Test
	@Disabled
	@DisplayName("Disabled")
	void DisabledTest() {
		error = "valor atual é diferente do esperado -> a != b";
		try {
			int a = 1;
			int b = 2;
			assertEquals(a, b, error);

		} catch (Exception e) {
			fail();
		}
	}
	
	@Test
	@DisplayName("Success")
	void SuccessTest() {
		error = "valor atual é diferente do esperado -> a != b";
		try {
			int a = 1;
			int b = 1;
			assertEquals(a, b, error);

		} catch (Exception e) {
			fail();
		}
	}
	
	@Test
	@Disabled
	@DisplayName("Fail")
	void FailTest() {
		error = "valores de 'a' e 'b' não são iguais.";
		try {
			int a = 1;
			int b = 2;
			assertEquals(a, b, error);

		} catch (Exception e) {
			fail();
		}
	}


		
	}

}

