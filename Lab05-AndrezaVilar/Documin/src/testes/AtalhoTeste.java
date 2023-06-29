package testes;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import documin.Atalho;

class AtalhoTest {

    private Atalho atalho;

    void setUp() {
        atalho = new Atalho("Atalho", 4, "Representacao completa", "Representacao Resumida");
    }

    void testGerarRepresentacaoCompleta() {
        assertEquals("Representacao completa", atalho.gerarRepresentacaoCompleta());
    }

    void testGerarRepresentacaoResumida() {
        assertEquals("Representacao Resumida", atalho.gerarRepresentacaoResumida());
    }


    void testGetPrioridade() {
        assertEquals(4, atalho.getPrioridade());
    }
}
