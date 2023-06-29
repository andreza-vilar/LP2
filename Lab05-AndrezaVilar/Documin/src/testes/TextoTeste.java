package testes;
import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

import documin.Texto;
public class TextoTeste {

    @Test
    void testeCadastraTextoEGeraRepresentacaoCompleta() {
        Texto texto = new Texto("Exemplo de texto", 1);
        assertEquals(texto.gerarRepresentacaoCompleta(), "Exemplo de texto");
    }

    @Test
    void testeCadastraTextoEGeraRepresentacaoResumida() {
        Texto texto = new Texto("Exemplo de texto", 1);
        assertEquals(texto.gerarRepresentacaoResumida(), "Exemplo de texto");

    }

    @Test
    void verificaPrioridade() {
        Texto texto = new Texto("Exemplo de texto", 1);
        assertEquals(texto.getPrioridade(), 1);
    }
}