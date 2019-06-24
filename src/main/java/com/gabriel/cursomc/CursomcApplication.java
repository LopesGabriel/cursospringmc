package com.gabriel.cursomc;

import java.util.Arrays;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.gabriel.cursomc.domain.Categoria;
import com.gabriel.cursomc.domain.Cidade;
import com.gabriel.cursomc.domain.Estado;
import com.gabriel.cursomc.domain.Produto;
import com.gabriel.cursomc.repositories.CategoriaRepository;
import com.gabriel.cursomc.repositories.CidadeRepository;
import com.gabriel.cursomc.repositories.EstadoRepository;
import com.gabriel.cursomc.repositories.ProdutoRepository;

@SpringBootApplication
public class CursomcApplication implements CommandLineRunner{
	
	@Autowired
	private CategoriaRepository categoriaRepository;
	@Autowired
	private ProdutoRepository produtoRepository;
	
	@Autowired
	private CidadeRepository cidadeRepository;
	@Autowired
	private EstadoRepository estadoRepository;

	public static void main(String[] args) {
		SpringApplication.run(CursomcApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		
		Categoria c1 = new Categoria(null, "Informática");
		Categoria c2 = new Categoria(null, "Escritório");
		Categoria c3 = new Categoria(null, "Doces");
		Categoria c4 = new Categoria(null, "Salgados");
		
		Produto p1 = new Produto(null, "Computador", 4000.00);
		Produto p2 = new Produto(null, "Impressora", 800.00);
		Produto p3 = new Produto(null, "Mouse", 130.50);
		Produto p4 = new Produto(null, "Cupcake", 5.00);
		Produto p5 = new Produto(null, "Bolo", 25.00);
		Produto p6 = new Produto(null, "Brigadeiro", 1.00);
		Produto p7 = new Produto(null, "Webcam", 50.00);
		Produto p8 = new Produto(null, "Marmita", 12.00);
		Produto p9 = new Produto(null, "Telefone", 45.90);
		Produto p10 = new Produto(null, "Placa de vídeo", 969.90);
		Produto p11 = new Produto(null, "Cadeira de escritório", 300.00);
		
		Estado est1 = new Estado(null, "Minas Gerais");
		Estado est2 = new Estado(null, "São Paulo");
		
		Cidade cid1 = new Cidade(null, "Uberlândia", est1);
		Cidade cid2 = new Cidade(null, "São Paulo", est2);
		Cidade cid3 = new Cidade(null, "Campinas", est2);
		
		
		c1.getProdutos().addAll(Arrays.asList(p1, p2, p3, p7, p10));
		c2.getProdutos().addAll(Arrays.asList(p2, p9, p11));
		c3.getProdutos().addAll(Arrays.asList(p4, p5, p6));
		c4.getProdutos().addAll(Arrays.asList(p8));
		
		p1.getCategorias().addAll(Arrays.asList(c1));
		p2.getCategorias().addAll(Arrays.asList(c1, c2));
		p3.getCategorias().addAll(Arrays.asList(c1));
		p4.getCategorias().addAll(Arrays.asList(c3));
		p5.getCategorias().addAll(Arrays.asList(c3));
		p6.getCategorias().addAll(Arrays.asList(c3));
		p7.getCategorias().addAll(Arrays.asList(c1));
		p8.getCategorias().addAll(Arrays.asList(c4));
		p9.getCategorias().addAll(Arrays.asList(c2));
		p10.getCategorias().addAll(Arrays.asList(c1));
		p11.getCategorias().addAll(Arrays.asList(c2));
		
		est1.getCidades().addAll(Arrays.asList(cid1));
		est2.getCidades().addAll(Arrays.asList(cid2, cid3));
		
		categoriaRepository.saveAll(Arrays.asList(c1, c2, c3, c4));
		produtoRepository.saveAll(Arrays.asList(p1,p2,p3,p4,p5,p6,p7,p8,p9,p10,p11));
		estadoRepository.saveAll(Arrays.asList(est1, est2));
		cidadeRepository.saveAll(Arrays.asList(cid1, cid2, cid3));
		
	}

}
