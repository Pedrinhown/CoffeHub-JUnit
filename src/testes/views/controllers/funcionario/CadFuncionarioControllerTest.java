package testes.views.controllers.funcionario;

import org.junit.jupiter.api.*;

import static org.junit.jupiter.api.Assertions.*;

import java.time.LocalDate;

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
			
			func.setCod(1);
			
			funcDAO.deletar(func.getCod());

			assertAll(
					() -> assertEquals(1, func.getCod(), error)
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
			
			funcDAO.editar(func);
			
			assertAll(
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
			fail(error);
		}
	}
	
	@Test 
	@DisplayName("Gravacao do Funcionario")
	//@RepeatedTest(2)
	void testGravar() {
		error = "Erro ao tentar executar comando de gravação do funcionario";
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
			
			assertAll(
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
			fail(error);
		}
	}
	
	
	@Nested
	@DisplayName("Teste")
	class Teste{
		
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
