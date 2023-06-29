package LAB03-AndrezaVilar;
import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

import agenda.Contato;

public class TesteContato {
	
	private Contato contatoTeste
	
	@BeforeEach
    void organizaContato() {
        this.contatoBase = new Contato("Andreza", "Vilar", "888-777");
    }
	
	@Test
	void favorito() {
		assertTrue(contatoTeste.getFavorito());
	}
	
	@Test
	void nomeCompleto() {
		assertEquals("Andreza Vilar", this.contatoTeste.nomeCompleto());
	}
	
	@Test
	void ToString() {
		assertEquals("Andreza Vilar\n888-777", this.contatoTeste.toString());
	}
	
	@Test
	void removeFavorito() {
		contatoTeste.favorito();
		contatoTeste.removeFavorito();
		assertFalse(contatoTeste.getFavorito());
		
	}
	
}