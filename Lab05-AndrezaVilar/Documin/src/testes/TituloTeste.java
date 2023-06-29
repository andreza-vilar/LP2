package testes;
import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

import documin.Titulo;
class TituloTeste {

    Titulo elemento = new Titulo("Documentos Texto", 1, 1, false);

    @Test
    void testCriaTituloNaoLinkavelApartirDaInterfaceEElelementoComSucessoEVerificaARepresentacaoCompleta() {
        assertEquals("1. Documentos Texto", elemento.gerarRepresentacaoCompleta());
    }

    @Test
    void testCriaTituloNaoLinkavelApartirDaInterfaceEElelementoComSucessoEVerificaARepresentacaoResumida() {
        assertEquals("1. Documentos Texto", elemento.gerarRepresentacaoResumida());
    }

    @Test
    void testVerificaPropriedades() {
        assertEquals("Documentos Texto\nNível: 1\nLinkável: false\n", elemento.getPropriedades());
    }

    @Test
    void testGerarRepresentacaoCompletaQuandoNaoLinkavel() {
        assertEquals("1. Documentos Texto", elemento.gerarRepresentacaoCompleta());
    }

    @Test
    void testGerarRepresentacaoCompletaQuandoEhLinkavel() {
        Titulo elemento2 = new Titulo("Documentos Texto", 1, 1, true);
        assertEquals("1. Documentos Texto -- 1-DOCUMENTOSTEXTO", elemento2.gerarRepresentacaoCompleta());
    }

    @Test
    void testGerarRepresentacaoResumidaQuandoEhLinkavel() {
        Titulo elemento2 = new Titulo("Documentos Texto", 1, 1, true);
        assertEquals("1. Documentos", elemento2.gerarRepresentacaoResumida());
    }

    @Test
    void testPegaAPrioridade() {
        assertEquals(1, elemento.getPrioridade());
    }
}