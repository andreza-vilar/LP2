package testes;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

import documin.Termo;
public class TermosTeste {
    Termo termo = new Termo("Teste / termos / Aleatórios", 1, "/", "ALFABÉTICA");
    Termo termo2 = new Termo("Teste / termos / Aleatórios", 1, "/", "NENHUM");
    Termo termo3 = new Termo("Teste / termos / Aleatórios", 1, "/", "ALFABÉTICA");

    @Test
    void testeCadastraTermoComSucessoEGeraRepresentacaoCompleta1() {
        assertEquals("Total termos: 3\n- Aleatórios, Teste, termos", termo.gerarRepresentacaoCompleta());
    }

    @Test
    void testeCadastraTermoComSucessoEGeraRepresentacaoResumida1() {
        assertEquals("Aleatórios / Teste / termos", termo.gerarRepresentacaoResumida());
    }

    @Test
    void testeCadastraTermoComSucessoEGeraRepresentacaoCompleta2() {
        assertEquals("Total termos: 3\n- Teste, termos, Aleatórios", termo2.gerarRepresentacaoCompleta());
    }

    @Test
    void testeCadastraTermoComSucessoEGeraRepresentacaoResumida2() {
        assertEquals("Teste / termos / Aleatórios", termo2.gerarRepresentacaoResumida());
    }

    @Test
    void testeCadastraTermoComSucessoEGeraRepresentacaoCompleta3() {
        assertEquals("Total termos: 3\n- Aleatórios, Teste, termos", termo3.gerarRepresentacaoCompleta());
    }

    @Test
    void testeCadastraTermoComSucessoEGeraRepresentacaoResumida3() {
        assertEquals("Aleatórios / Teste / termos", termo3.gerarRepresentacaoResumida());
    }

    @Test
    void testeVerificarPrioridadeDoTermo() {
        assertEquals(1, termo.getPrioridade());
    }
}
