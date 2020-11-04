package testes.views.controllers.funcionario;

import org.junit.jupiter.api.*;

import static org.junit.jupiter.api.Assertions.*;
import static org.junit.jupiter.api.Assumptions.*;

import java.time.LocalDate;

import dao.FuncionarioDAO;
import entitys.Funcionario;
import views.controllers.HomeController;
import views.controllers.funcionario.CadFuncionarioController;
import views.controllers.funcionario.PesquisaFuncionarioController;

	
@DisplayName("Controller - Pesquisa do Funcionario")
@TestInstance(TestInstance.Lifecycle.PER_CLASS)
class PesquisaFuncionarioControllerTest {
	
	//Declare:
	public HomeController homeController; 
	public PesquisaFuncionarioController pesquisaFuncionarioController;
	public CadFuncionarioController cadFuncionarioController;
	public Funcionario func;
	public FuncionarioDAO funcDAO;	
	public String error;	

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
			func.setCod(1);
			func.setNome("Nome");	
			func.setEmail("a@a.com");
			func.setTelefone("12312312");
			func.setDocumento("123456789");
			func.setEndereco("rua Ruaruarua");
			func.setSalario(9999.99);
			func.setData_contratacao(LocalDate.of(2020, 10, 10));
			func.setData_demissao(null);
			func.setCod_acesso(1);
			func.setSenha_funcionario("1");
			
			funcDAO.inserir(func);
			funcDAO.listar();
								
		assertAll(
				() -> assertNotEquals(null, funcDAO.listar(), error),
				() -> assertEquals(1, func.getCod(), error),
				() -> assertEquals("Nome", func.getNome(), error),
				() -> assertEquals("a@a.com", func.getEmail(), error),
				() -> assertEquals("12312312", func.getTelefone(), error),
				() -> assertEquals("123456789", func.getDocumento(), error),
				() -> assertEquals("rua Ruaruarua", func.getEndereco(), error),
				() -> assertEquals(9999.99, func.getSalario(), error),
				() -> assertEquals(LocalDate.of(2020, 10, 10), func.getData_contratacao(), error),
				() -> assertEquals(null, func.getData_demissao(), error),
				() -> assertEquals(1, func.getCod_acesso(), error),
				() -> assertEquals("1", func.getSenha_funcionario(), error)
				
				);
			
		} catch (Exception e) {
			fail();
		}
	}
	
	
	@Nested
	@DisplayName("Teste")
	class Teste{
		
	@Test
	@DisplayName("Success")
	void SuccessTest() {
		error = "valor atual � diferente do esperado -> a != b";
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
		error = "valores de 'a' e 'b' n�o s�o iguais.";
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

