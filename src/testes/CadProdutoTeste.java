package testes;

import static org.junit.Assert.fail;

import org.junit.Assert;
import org.junit.Test;

import control.produto.ControlProduto;
import entitys.Produto;

public class CadProdutoTeste {
	
	// Testar todos os campos - Editar
	
	@Test
	public void TesteProdutoCodInvalidoEdicao() {
		Produto produto = new Produto();
		produto.setCod(-1);
		try 
		{
			Assert.assertEquals(1, new ControlProduto().Editar(produto));
			fail();
		}
		catch (Exception e)
		{
			Assert.assertEquals("Informe uma ID válida para o produto", e.getMessage());
		}
	}
	@Test
	public void TestaDescricaoProdutoValidoEditar() {
		
	}
	@Test
	public void TestaDescricaoProdutoInvalidoEditar() {
		
	}
	
	
	@Test
	public void TestaValorProdutoValidoEditar() {
		
	}
	@Test
	public void TestaValorProdutoInvalidoEditar() {
		
	}
	
	@Test
	public void TestaQtdProdutoValidoEditar() {
		
	}
	@Test
	public void TestaQtdProdutoInvalidoEditar() {
		
	}
	
	
	@Test
	public void TestaUnProdutoValidoEditar() {
		
	}
	
	@Test
	public void TestaUnProdutoInvalidoEditar() {
		
	}


	// Testar todos os campos - Gravar
	
	@Test
	public void TestaDescricaoProdutoValidoGravar() {
		
	}
	@Test
	public void TestaDescricaoProdutoInvalidoGravar() {
		
	}	
	
	@Test
	public void TestaValorProdutoValidoGravar() {
		
	}
	@Test
	public void TestaValorProdutoInvalidoGravar() {
		
	}
	
	@Test
	public void TestaQtdProdutoValidoGravar() {
		
	}
	@Test
	public void TestaQtdProdutoInvalidoGravar() {
		
	}
	
	
	@Test
	public void TestaUnProdutoValidoGravar() {
		
	}
	
	@Test
	public void TestaUnProdutoInvalidoGravar() {
		
	}	
	
	
	@Test
	public void TestaCategoriaProdutoEditar() {
		// Gravar nova categoria -> carrega ela -> gravar a mesma no produto -> deletar categoria para forçar exception de constraint fk
	}

	
	
	// testar o gravar no geral
	@Test
	public void TestaGravarProdutoInvalido() {
		
	}
	
	@Test
	public void TestaGravarProdutoValido() {
		
	}
	
	
	//testar o editar produto
	@Test
	public void TestaEditarProdutoInvalido() {
		
	}
	
	@Test
	public void TestaEditarProdutoValido() {
		
	}
	
	//testar excluir produto
	@Test
	public void TestaExcluirProdutoInvalido() {
		
	}	
	@Test
	public void TestaExcluirProdutoValido() {
		
	}	
}
