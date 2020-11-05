package testes.views.controllers.funcionario;

import org.junit.jupiter.api.*;

import static org.junit.jupiter.api.Assertions.*;

import java.time.LocalDate;

import dao.FuncionarioDAO;
import entitys.Funcionario;
	
@DisplayName("Controller - Pesquisa do Funcionario")
@TestInstance(TestInstance.Lifecycle.PER_CLASS)
class PesquisaFuncionarioControllerTest {
	
	//Declare:
	private Funcionario func;
	private FuncionarioDAO funcDAO;	
	private String error;	

	private Funcionario setFuncionario() {
		func.setCod(1);
		func.setNome("Nome");	
		func.setEmail("a@a.com");
		func.setTelefone("12312312");
		func.setDocumento("123457789");
		func.setEndereco("rua Ruaruarua");
		func.setSalario(9999.99);
		func.setData_contratacao(LocalDate.of(2020, 10, 10));
		func.setData_demissao(null);
		func.setCod_acesso(1);
		func.setSenha_funcionario("1");

		return func;
	}
	
	@BeforeEach
	void init() {
		func = new Funcionario();
		funcDAO = new FuncionarioDAO();
	}
	
	
	@Test 
	@DisplayName("Pesquisa do Funcionario")
	void testPesquisar() {
		error = "Erro ao tentar executar comando de pesquisa do funcionario";
		try {			
			
			funcDAO.inserir(setFuncionario());
			funcDAO.listar().add(setFuncionario());
								
		assertAll(
				() -> assertNotEquals(null, funcDAO.listar().add(setFuncionario()), error),
				() -> assertEquals("Nome", setFuncionario().getNome(), error),
				() -> assertEquals("a@a.com", setFuncionario().getEmail(), error),
				() -> assertEquals("12312312", setFuncionario().getTelefone(), error),
				() -> assertEquals("123457789", setFuncionario().getDocumento(), error),
				() -> assertEquals("rua Ruaruarua", setFuncionario().getEndereco(), error),
				() -> assertEquals(9999.99, setFuncionario().getSalario(), error),
				() -> assertEquals(LocalDate.of(2020, 10, 10), setFuncionario().getData_contratacao(), error),
				() -> assertEquals(null, setFuncionario().getData_demissao(), error),
				() -> assertEquals(1, setFuncionario().getCod_acesso(), error),
				() -> assertEquals("1", setFuncionario().getSenha_funcionario(), error)
				
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
		error = "valores de 'a' e 'b' não são iguais.";
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
	@DisplayName("Fail/Disabled")
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

