package testes.views.controllers.funcionario;

import org.junit.jupiter.api.*;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import static org.junit.jupiter.api.Assertions.*;

import java.time.LocalDate;

import dao.FuncionarioDAO;
import entitys.Funcionario;

@DisplayName("Controller - Cadastro do Funcionario")
@TestInstance(TestInstance.Lifecycle.PER_CLASS)
class CadFuncionarioControllerTest {

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
	void init() {
		func = new Funcionario();
		funcDAO = new FuncionarioDAO();
	}

	@Test
	@DisplayName("Buscar Funcionario por ID")
	// @RepeatedTest(10)
	void testBuscarID() {
		error = "Erro ao tentar buscar fazer a busca do funcionario por ID(int)";
		try {

			funcDAO.buscarId(setFuncionario().getCod());
			assertEquals(1, setFuncionario().getCod(), error);

			int funcionarioID = 2;
			funcDAO.buscarId(funcionarioID);
			assertNotEquals(funcionarioID, setFuncionario().getCod(), error);
			assertEquals(2, funcionarioID, error);

		} catch (Exception e) {
			fail(error);
		}

	}

	@Test
	@DisplayName("Verificar Documento")
	void testVerificaRG() {

		String rg = "123123123";
		String cpf = "12312312312";

		funcDAO.verificaRG(rg);
		assertEquals("123123123", rg);

		funcDAO.verificaRG(cpf);
		assertEquals("12312312312", cpf);

		funcDAO.verificaRG(setFuncionario().getDocumento());
		assertEquals("123455789", setFuncionario().getDocumento());

	}

	@ParameterizedTest
	@ValueSource(strings = { "1999-03-01", "2005-11-30", "2020-05-01" })
	@DisplayName("Teste Recebimento de Data")
	void testConvertData(LocalDate data) {
		error = "Erro ao tentar converter uma Date para LocalDate";
		try {
			func.setData_contratacao(data);
			func.setData_demissao(data);

			assertAll(() -> assertTrue(data != null, error),
					() -> assertTrue(func.getData_contratacao() != null, error),
					() -> assertTrue(func.getData_demissao() != null, error));

		} catch (Exception e) {
			fail(error);
		}
	}

	@Test
	@DisplayName("Gravacao do Funcionario")
	// @RepeatedTest(2) //a primeira deve passar, a segunda deve gerar duplicidade
	// de documento no e ser abortada.
	void testGravar() {
		error = "Erro ao tentar executar comando de gravação do funcionario";
		try {

			funcDAO.inserir(setFuncionario());

			assertAll(() -> assertEquals(1, setFuncionario().getCod(), error),
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
	@DisplayName("Edicao do Funcionario")
	void testEditar() {
		error = "Erro ao tentar executar comando de edição do funcionario";
		try {

			funcDAO.editar(setFuncionario());

			assertAll(() -> assertEquals(1, setFuncionario().getCod(), error),
					() -> assertEquals("Nome", setFuncionario().getNome(), error),
					() -> assertEquals("a@a.com", setFuncionario().getEmail(), error),
					() -> assertEquals("12312312", setFuncionario().getTelefone(), error),
					() -> assertEquals("123455789", setFuncionario().getDocumento(), error),
					() -> assertEquals("rua Ruaruarua", setFuncionario().getEndereco(), error),
					() -> assertEquals(9999.99, setFuncionario().getSalario(), error),
					() -> assertEquals(LocalDate.of(2020, 10, 10), setFuncionario().getData_contratacao(), error),
					() -> assertEquals(null, setFuncionario().getData_demissao(), error),
					() -> assertEquals(1, setFuncionario().getCod_acesso(), error),
					() -> assertEquals("1", setFuncionario().getSenha_funcionario(), error));

		} catch (Exception e) {
			fail(error);
		}
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

	@Nested
	@DisplayName("Teste")
	class Teste {

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
