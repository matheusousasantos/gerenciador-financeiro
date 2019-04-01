package teste;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

import connection.SingleConnection;

class TesteGerenciadorFinanceiro {

	@Test
	void test() {
		fail("Not yet implemented");
	}
	
	
	@Test
	public void validarConn() {
		
		System.out.println("Olá, mundo!!");
		SingleConnection.getConnection();
		
		
	}
}
