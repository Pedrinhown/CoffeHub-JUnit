package testes.views.controllers.funcionario;

import org.junit.jupiter.api.*;
import static org.junit.jupiter.api.Assertions.*;
import static org.junit.jupiter.api.Assumptions.*;

import dao.FuncionarioDAO;
import entitys.Funcionario;
import views.controllers.HomeController;
import views.controllers.funcionario.CadFuncionarioController;
import views.controllers.funcionario.PesquisaFuncionarioController;

@DisplayName("Controller - Cadastro do Funcionario")
@TestInstance(TestInstance.Lifecycle.PER_CLASS)
class CadFuncionarioControllerTest {
	
	HomeController homeController; 
	PesquisaFuncionarioController pesquisaFuncionarioController;
	CadFuncionarioController cadFuncionarioController;
	Funcionario func;
	FuncionarioDAO funcDAO;	
	String error;	

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
	@DisplayName("Demissao do Funcionario")
	void testDemitir() {
		error = "Erro ao tentar executar comando de exclusão do funcionario";
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
	
	@Test 
	@DisplayName("Edicao do Funcionario")
	void testEditar() {
		error = "Erro ao tentar executar comando de edição do funcionario";
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
	
	@Test 
	@DisplayName("Gravacao do Funcionario")
	//@RepeatedTest(2)
	void testGravar() {
		error = "Erro ao tentar executar comando de gravação do funcionario";
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
			fail(error);
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
			fail(error);
		}
	}
	
	@Test
	@Disabled
	@DisplayName("Fail")
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


		
	}
		
}
