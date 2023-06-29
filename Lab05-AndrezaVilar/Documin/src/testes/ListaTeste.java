package testes;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

import documin.Lista;
import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;

class ListaTeste {

    @Test
    void testCriarListaComSucessoEVerificarRepresentacaoCompleta() {
        Lista lista = new Lista("Exemplo | de uma lista | de 3 termos", 1, "|", "-");
        assertEquals("- Exemplo\n- de uma lista\n- de 3 termos", lista.gerarRepresentacaoCompleta());
    }

    @Test
    void testCriarListaComSucessoEVerificarRepresentacaoResumida() {
        Lista lista = new Lista("Exemplo | de uma lista | de 3 termos", 1, "|", "-");
        assertEquals("Exemplo, de uma lista, de 3 termos", lista.gerarRepresentacaoResumida());
    }

    @Test
    void testVerificarPrioridade() {
        Lista lista = new Lista("Exemplo | de uma lista | de 3 termos", 1, "|", "-");
        assertEquals(1, lista.getPrioridade());
    }
}

