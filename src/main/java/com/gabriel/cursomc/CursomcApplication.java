package com.gabriel.cursomc;

import java.util.Arrays;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.gabriel.cursomc.domain.Categoria;
import com.gabriel.cursomc.domain.Cidade;
import com.gabriel.cursomc.domain.Cliente;
import com.gabriel.cursomc.domain.Endereco;
import com.gabriel.cursomc.domain.Estado;
import com.gabriel.cursomc.domain.Produto;
import com.gabriel.cursomc.enums.TipoCliente;
import com.gabriel.cursomc.repositories.CategoriaRepository;
import com.gabriel.cursomc.repositories.CidadeRepository;
import com.gabriel.cursomc.repositories.ClienteRepository;
import com.gabriel.cursomc.repositories.EnderecoRepository;
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
	@Autowired
	private ClienteRepository clienteRepository;
	@Autowired
	private EnderecoRepository enderecoRepository;

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
		Estado est3 = new Estado(null, "Distrito Federal");
		
		Cidade cid1 = new Cidade(null, "Uberlândia", est1);
		Cidade cid2 = new Cidade(null, "São Paulo", est2);
		Cidade cid3 = new Cidade(null, "Campinas", est2);
		Cidade cid4 = new Cidade(null, "Brasília", est3);
		
		
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
		estadoRepository.saveAll(Arrays.asList(est1, est2, est3));
		cidadeRepository.saveAll(Arrays.asList(cid1, cid2, cid3, cid4));
		
		Cliente cli1 = new Cliente(null, "Gabriel de Oliveira", "lopesgabriel0199@gmail.com", "059.099.411-51", TipoCliente.PESSOAFISICA);
		Cliente cli2 = new Cliente(null, "Matheus de Oliveira", "matlopes1999@gmail.com", "059.099.451-51", TipoCliente.PESSOAFISICA);
		Cliente cli3 = new Cliente(null, "Dona Neide", "donaneide@gmail.com", "FingeCnpj", TipoCliente.PESSOAJURIDICA);
		
		cli1.getTelefones().addAll(Arrays.asList("(61) 9 8235-2349", "(61) 9 8103-1618"));
		cli2.getTelefones().addAll(Arrays.asList("(61) 9 8151-0636", "(61) 9 8103-1617"));
		cli3.getTelefones().addAll(Arrays.asList("(61) 9 8103-1618", "(61) 9 8103-1617"));
		
		Endereco e1 = new Endereco(null, "SHA conjunto 06 Chácara 25", "22", "Portal das Águas", "Águas Claras", "71996-215", cli1, cid4);
		Endereco e2 = new Endereco(null, "SHA conjunto 06 Chácara 25", "22", "Portal das Águas", "Águas Claras", "71996-215", cli2, cid4);
		Endereco e3 = new Endereco(null, "SHA conjunto 06 Chácara 25", "22", "Portal das Águas", "Águas Claras", "71996-215", cli3, cid4);
		
		cli1.getEnderecos().add(e1);
		cli2.getEnderecos().add(e2);
		cli3.getEnderecos().add(e3);
		
		clienteRepository.saveAll(Arrays.asList(cli1, cli2, cli3));
		enderecoRepository.saveAll(Arrays.asList(e1, e2, e3));
		
	}

}
