package testes;

import static org.junit.Assert.fail;

import java.time.Duration;
import java.time.Instant;

import org.junit.Assert;
import org.junit.Test;

import control.produto.ControlCategoria;
import control.produto.ControlProduto;
import entitys.Categoria;
import entitys.Produto;


public class TestSuitProdutoGravar {
	// Testar Gravar geral Válido
	
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
	public void TesteGravarMultiplos() {
		Instant inicio = Instant.now();
		
		for (int i = 0; i < 185; i++) {
			this.GravarProdutoValidoComCategoria();
		}
		
		Instant fim = Instant.now();
		 
		Duration duracao = Duration.between(inicio, fim);
		long duracaoSegundos = (duracao.toMillis() / 1000) % 60;
		
		Assert.assertTrue(duracaoSegundos > 20 ? false:true);

	}
	

	@Test
	public void TestarGravarProdutoComCat() throws Exception
	{
		Assert.assertEquals(new ControlProduto().BuscarUltimo(), this.GravarProdutoValidoComCategoria().getCod());
	}
	
	

	@Test
	public void TestaDescricaoProdutoInvalidoGravar() {
		Produto produto = new Produto();
		produto.setDescricao("");
		try 
		{
			Assert.assertEquals(1, new ControlProduto().Inserir(produto));
			fail();
		}
		catch (Exception e)
		{
			Assert.assertEquals("Informe uma descrição para o produto.", e.getMessage());
		}
	}	
	

	@Test
	public void TestaQtdProdutoInvalidoGravar() {
		Produto produto = new Produto();
		produto.setDescricao("Teste JUnit");
		produto.setQtd_atual(-1);
		try 
		{
			Assert.assertEquals(1, new ControlProduto().Inserir(produto));
			fail();
		}
		catch (Exception e)
		{
			Assert.assertEquals("A quantidade não pode ser menor ou igual a zero.", e.getMessage());
		}
	}
	

	@Test
	public void TestaValorProdutoInvalidoGravar() {
		Produto produto = new Produto();
		produto.setDescricao("Teste JUnit");
		produto.setQtd_atual(1);
		produto.setValor_un(-1);
		try 
		{
			Assert.assertEquals(1, new ControlProduto().Inserir(produto));
			fail();
		}
		catch (Exception e)
		{
			Assert.assertEquals("O valor unitário não pode ser menor ou igual a zero.", e.getMessage());
		}
	}
	
	

	@Test
	public void TestaUnProdutoInvalidoGravar() {
		Produto produto = new Produto();
		produto.setDescricao("Teste JUnit");
		produto.setQtd_atual(1);
		produto.setValor_un(100);
		produto.setUnidadeMedida("CCCCCC");
		try 
		{
			Assert.assertEquals(1, new ControlProduto().Inserir(produto));
			fail();
		}
		catch (Exception e)
		{
			Assert.assertEquals("A unidade de medida deve ser de 2 caracteres", e.getMessage());
		}
	}	
}
