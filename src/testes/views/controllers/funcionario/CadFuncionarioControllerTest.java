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
	
	private PesquisaFuncionarioController pesquisaFuncionarioController;
	private CadFuncionarioController cadFuncionarioController;
	private Funcionario func;
	private FuncionarioDAO funcDAO;	
	private String error;	
	
	private Funcionario setFuncionario() {
		func.setCod(1);
		func.setNome("Nome");	
		func.setEmail("a@a.com");
		func.setTelefone("12312312");
		func.setDocumento("123455789");
		func.setEndereco("rua Ruaruarua");
		func.setSalario(9999.99);
		func.setData_contratacao(LocalDate.of(2020, 10, 10));
		func.setData_demissao(null);
		func.setCod_acesso(1);
		func.setSenha_funcionario("1");

		return func;
	}
	
	@BeforeEach
	@DisplayName("Init Cadastro Funcionario")
	void init() {
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
						
			funcDAO.deletar(setFuncionario().getCod());

			assertEquals(1, setFuncionario().getCod(), error);
					
			
		} catch (Exception e) {
			fail(error);
		}
	}
	
	@Test 
	@DisplayName("Edicao do Funcionario")
	void testEditar() {
		error = "Erro ao tentar executar comando de edição do funcionario";
		try {
			
			funcDAO.editar(setFuncionario());
			
			assertAll(
					() -> assertEquals(1, setFuncionario().getCod(), error),
					() -> assertEquals("Nome", setFuncionario().getNome(), error),
					() -> assertEquals("a@a.com", setFuncionario().getEmail(), error),
					() -> assertEquals("12312312", setFuncionario().getTelefone(), error),
					() -> assertEquals("123455789", setFuncionario().getDocumento(), error),
					() -> assertEquals("rua Ruaruarua", setFuncionario().getEndereco(), error),
					() -> assertEquals(9999.99, setFuncionario().getSalario(), error),
					() -> assertEquals(LocalDate.of(2020, 10, 10), setFuncionario().getData_contratacao(), error),
					() -> assertEquals(null, setFuncionario().getData_demissao(), error),
					() -> assertEquals(1, setFuncionario().getCod_acesso(), error),
					() -> assertEquals("1", setFuncionario().getSenha_funcionario(), error)
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
			
			funcDAO.inserir(setFuncionario());
			
			assertAll(
					() -> assertEquals(1, setFuncionario().getCod(), error),
					() -> assertEquals("Nome", setFuncionario().getNome(), error),
					() -> assertEquals("a@a.com", setFuncionario().getEmail(), error),
					() -> assertEquals("12312312", setFuncionario().getTelefone(), error),
					() -> assertEquals("123455789", setFuncionario().getDocumento(), error),
					() -> assertEquals("rua Ruaruarua", setFuncionario().getEndereco(), error),
					() -> assertEquals(9999.99, setFuncionario().getSalario(), error),
					() -> assertEquals(LocalDate.of(2020, 10, 10), setFuncionario().getData_contratacao(), error),
					() -> assertEquals(null, setFuncionario().getData_demissao(), error),
					() -> assertEquals(1, setFuncionario().getCod_acesso(), error),
					() -> assertEquals("1", setFuncionario().getSenha_funcionario(), error)
					
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
	@DisplayName("Fail/Disabled")
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
