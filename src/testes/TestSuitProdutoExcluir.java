package testes;

import static org.junit.Assert.fail;

import org.junit.Assert;
import org.junit.Test;

import control.produto.ControlCategoria;
import control.produto.ControlProduto;
import entitys.Categoria;
import entitys.Produto;

public class TestSuitProdutoExcluir {
	//testar excluir produto
	
	private Produto ProdutoValidoGravar() {
		Produto produto = new Produto();
		produto.setDescricao("Produto JUnit");
		produto.setQtd_atual(3);
		produto.setUnidadeMedida("CX");
		produto.setValor_un(1.55);
		return produto;
	}
	
	private Categoria CategoriaValidaGravar() {
		Categoria categoria = new Categoria();
		categoria.setNome("Categoria JUnit");
		return categoria;
	}
	
	private Produto GravarProdutoValidoComCategoria() {
		Produto retorno = null;
		
		try {
			
			ControlCategoria ctCategoria = new ControlCategoria();
			ControlProduto ctProduto = new ControlProduto();
			Categoria cat = this.CategoriaValidaGravar();
			retorno = this.ProdutoValidoGravar();
			
			 cat = ctCategoria.Carregar(ctCategoria.Inserir(cat));
			 retorno.setCategoria(cat);

			 retorno = ctProduto.Carregar(ctProduto.Inserir(retorno));
		}
		catch(Exception ex) {
			ex.printStackTrace();
			System.out.println(ex.getMessage());
			retorno = null;
		}
		
		return retorno;
	}
	

	@Test
	public void TestaExcluirProdutoInvalido() {
		Produto produto = new Produto();
		produto.setCod(-1);
		try 
		{
			new ControlProduto().Deletar(produto.getCod());
			fail();
		}
		catch (Exception e)
		{
			Assert.assertEquals("Informe uma ID válida para a exclusão do produto.", e.getMessage());
		}		
	}	
	
	@Test
	public void TestaExcluirProdutoInesxitente() {
		Produto produto = new Produto();
		produto.setCod(5000);
		try 
		{
			new ControlProduto().Deletar(produto.getCod());
		}
		catch (Exception e)
		{
			e.printStackTrace();
			fail();
		}		
	}	

	@Test
	public void TestaExcluirProdutoValido()
	{
		Produto porduto = this.GravarProdutoValidoComCategoria();		
		try
		{
			Assert.assertEquals(1, new ControlProduto().Deletar(porduto.getCod()));
		} 
		catch (Exception e) {
			e.printStackTrace();
			fail();
		} 		
	}	
}
