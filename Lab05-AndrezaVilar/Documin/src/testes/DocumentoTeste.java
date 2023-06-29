package testes;

import static org.junit.jupiter.api.Assertions.*;

import java.util.Arrays;
import java.util.NoSuchElementException;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import documin.Documento;

class DocumentoTeste{
    Documento sistema;
    Documento sistema2;

    @BeforeEach
    void setup() {
        sistema =  new Documento("Documentario");
        sistema2 = new Documento("Documentario", 1);
    }

    @Test
    void testCadastraTextoComSucessoEVerificaOIndiceDeRetorno() {
        assertEquals(1, sistema.criarTexto("Documento", 1));
    }

    @Test
    void testCadastraDocumentoDeTamanhoIndefinidoComTituloVazio() {
        assertThrows(IllegalArgumentException.class, () -> {
            new Documento("");
        });
    }

    @Test
    void testCadastraDocumentoDeTamanhoIndefinidoComTituloNull() {
        assertThrows(IllegalArgumentException.class, () -> {
            new Documento(null);
        });
    }

    @Test
    void testCadastraDocumentoDeTamanhoIndefinidoComTituloComApenasEspacos() {
        assertThrows(IllegalArgumentException.class, () -> {
            new Documento(" ");
        });
    }

    @Test
    void testCadastraDocumentoDeTamanhoInvalido() {
        assertThrows(IllegalArgumentException.class, () -> {
            new Documento("Documentario", -1);
        });
    }

    @Test
    void testCadastraDocumentoDeTamanhoDefinidoComTituloVazio() {
        assertThrows(IllegalArgumentException.class, () -> {
            new Documento("", 1);
        });
    }

    @Test
    void testCadastraDocumentoDeTamanhoDefinidoComTituloNull() {
        assertThrows(IllegalArgumentException.class, () -> {
            new Documento(null, 1);
        });
    }

    @Test
    void testCadastraDocumentoDeTamanhoDefinidoComTituloComApenasEspacos() {
        assertThrows(IllegalArgumentException.class, () -> {
            new Documento(" ", 1);
        });
    }

    @Test
    void testCadastraDocumentoComUmEspacoEVerificaSeEstaCheioEVerificaTituloDoDocumento() {
        assertEquals("Documentario", sistema2.getTitulo());
        assertEquals(1, sistema2.criarTexto("Documento", 1));
        assertEquals(-1, sistema2.criarTexto("Documento2", 1));
    }

    @Test
    void testCriaTituloLinkavelComSucesso() {
        assertEquals(1, sistema.criarTitulo("Documentos Texto", 1, 1, true));
        assertEquals("1. Documentos Texto -- 1-DOCUMENTOSTEXTO", sistema.pegarRepresentacaoCompleta(1));
        assertEquals("1. Documentos", sistema.pegarRepresentacaoResumida(1));
    }

    @Test
    void testCriaTituloLinkavelComSucessoESemEspaco() {
        assertEquals(1, sistema2.criarTitulo("Documentos Texto", 1, 1, true));
        assertEquals(-1, sistema2.criarTitulo("Documentos Texto", 1, 1, true));
    }
}