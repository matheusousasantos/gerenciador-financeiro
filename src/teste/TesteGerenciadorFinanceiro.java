package teste;

import static org.junit.jupiter.api.Assertions.fail;

import java.util.Date;

import org.junit.jupiter.api.Test;

import bean.Cidade;
import bean.Endereco;
import bean.Estado;
import bean.Receita;
import bean.Usuario;
import connection.SingleConnection;

class TesteGerenciadorFinanceiro {
	
	Usuario usuario = new Usuario();

	@Test
	void test() {
		fail("Not yet implemented");
	}
	
	
	@Test
	public void validarConn() {
		
		System.out.println("Ol�, mundo!!");
		SingleConnection.getConnection();
		
		
	}
	
	
	@Test
	public void inserindoUsuario() {
		
//	PRIMEIRO CADASTRO DE UM USU�RIO {
		
		Usuario usuario = new Usuario();
		
		usuario.setNome("Matheus Sousa");
		usuario.setLogin("sacro");
		usuario.setSenha("mega");
		usuario.setSexo("M");
		
			Endereco endereco = new Endereco();
			endereco.setLogradouro("234");
			endereco.setNumero("432");
			endereco.setBairro("Centro");
			endereco.setComplemento("Rua do cemit�rio");
			endereco.setCep("65110-000");
			
					Estado estado = new Estado();
					estado.setNome("MA");
			
				Cidade cidade = new Cidade();
				cidade.setNome("S�o Luis");
				cidade.setEstado(estado.getId());
			
			endereco.setCidade(cidade.getId());
			
		usuario.setEndereco(endereco.getId());
		
		System.out.println("*** DADOS DO USU�RIO ***");
		System.out.println("Nome: " + usuario.getNome());
		System.out.println("Login: " + usuario.getLogin());
		System.out.println("Senha: " + usuario.getSenha());
		System.out.println("Sexo: " + usuario.getSexo());
		
		System.out.println("DADOS DO ENDERE�O");
		System.out.println("Logradouro: " + endereco.getLogradouro());
		System.out.println("Numero: " + endereco.getNumero());
		System.out.println("Bairro: " + endereco.getBairro());
		System.out.println("Complemento: " + endereco.getComplemento());
		System.out.println("CEP: " + endereco.getCep());
		System.out.println("Cidade:" + endereco.getCidade());
		System.out.println("Estado:" + cidade.getEstado());
//	}
	
	}
	
	@Test
	public void inserindoReceita() {
		
//		INSERINDO UMA RECEIRA PARA UM DETERMINADO USU�RIO, N�O SER� INSERIDO NENHUMA MOVIMENTA��O {
		
		Receita receita = new Receita();
		receita.setDeposito(new Date());
		receita.setValor(1200.0);
		receita.setReferencia("Banco do Brasil");
		receita.setTipo("Conta Sal�rio");
		
			Endereco endereco = new Endereco();
			endereco.setLogradouro("234");
			endereco.setNumero("432");
			endereco.setBairro("Centro");
			endereco.setComplemento("Rua do cemit�rio");
			endereco.setCep("65110-000");
			
		receita.setEndereco(endereco.getId());
			usuario.setNome("Luma Hashilley");
		receita.setUsuario(usuario.getId());
		
		System.out.println("Deposito: " + receita.getDeposito());
		System.out.println("Valor: " + receita.getValor());
		System.out.println("Refer�ncia: " + receita.getReferencia());
		System.out.println("Usuario: " + receita.getUsuario());
		System.out.println("Tipo: " + receita.getTipo());
		
//	}
		
	}
	
}
