package testes;
import static org.junit.jupiter.api.Assertions.*;

import java.util.Arrays;
import java.util.NoSuchElementException;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import documin.DocumentoController;
public class DocumentoControllerTeste {
    private DocumentoController documentoController;

    @BeforeEach
    void setUp() {
        documentoController = new DocumentoController();
    }

    @Test
    void testCadastraDocumentoComSucessoIlimitado() {
        assertTrue(documentoController.criarDocumento("Doc"));
        assertFalse(documentoController.criarDocumento("Doc"));
    }

    @Test
    void testCadastraDocumentoComSucessoLimitado() {
        assertTrue(documentoController.criarDocumento("Doc", 2));
        assertFalse(documentoController.criarDocumento("Doc", 2));
    }

    @Test
    void testCriaTituloDocumentoInexistente() {
        assertThrows(NoSuchElementException.class, () -> {
            documentoController.criarTitulo("receitas", "Machado de Assis", 5, 99, false);
        });
    }

    @Test
    void testCriaTextoDocumentoInexistente() {
        assertThrows(NoSuchElementException.class, () -> {
            documentoController.criarTexto("Desenhos", "Kung Fu Panda", 4);
        });
    }

    @Test
    void testCriaTermosDocumentoInexistente() {
        assertThrows(NoSuchElementException.class, () -> {
            documentoController.criarTermos("Leis", "Termos de compromisso | Termos de prioridade", 4 , "|", "NENHUM");
        });
    }

    @Test
    void testCriaListaDocumentoInexistente() {
        assertThrows(NoSuchElementException.class, () -> {
            documentoController.criarLista("Leis", "Termos de compromisso | Termos de prioridade", 4 , "|", "-");
        });
    }

    @Test
    void testCriaTituloDocumentoInexistenteComTituloDocVazia() {
        assertThrows(IllegalArgumentException.class, () -> {
            documentoController.criarTitulo("", "Machado de Assis", 5, 99, false);
        });
    }

    @Test
    void testCriaTextoDocumentoInexistenteComTituloDocVazia() {
        assertThrows(IllegalArgumentException.class, () -> {
            documentoController.criarTexto("", "Kung Fu Panda", 4);
        });
    }

    @Test
    void testCriaTermosDocumentoInexistenteComTituloDocVazia() {
        assertThrows(IllegalArgumentException.class, () -> {
            documentoController.criarTermos("", "Termos de compromisso | Termos de prioridade", 4, "|", "NENHUM");
        });
    }

    @Test
    void testCriaListaDocumentoInexistenteComTituloDocVazia() {
        assertThrows(IllegalArgumentException.class, () -> {
            documentoController.criarLista("", "Termos de compromisso | Termos de prioridade", 4, "|", "-");
        });
    }

    @Test
    void testCriaListaDocumentoInexistenteComTituloDocComEspaco() {
        assertThrows(IllegalArgumentException.class, () -> {
            documentoController.criarLista(" ", "Termos de compromisso | Termos de prioridade", 4, "|", "-");
        });
    }

    @Test
    void testCriaListaDocumentoComTituloComEspaco() {
        assertThrows(IllegalArgumentException.class, () -> {
            documentoController.criarDocumento(" ", 2);
        });
    }

    @Test
    void testRemoveDocumentoNaoCadastrado() {
        assertThrows(NoSuchElementException.class, () -> {
            documentoController.removerDocumento("Doc");
        });
    }

    @Test
    void testRemoveTituloDocumentoNaoCadastrado() {
        assertThrows(NoSuchElementException.class, () -> {
            documentoController.removerDocumento("Doc");
        });
    }

    @Test
    void testRemoveTituloDocumentoCadastrado() {
        assertTrue(documentoController.criarDocumento("Doc", 2));
        documentoController.removerDocumento("Doc");
    }

    @Test
    void testCriaAtalhoComTituloVazio() {
        assertThrows(IllegalArgumentException.class, () -> {
            documentoController.criarAtalho("", "Doc");
        });
    }

    @Test
    void testCriaAtalhoComDocumentoInexistente() {
        assertThrows(NoSuchElementException.class, () -> {
            documentoController.criarAtalho("Doc", "OutroDoc");
        });
    }

    @Test
    void testCriaRepresentacaoCompletaTituloInexistente() {
        assertThrows(NoSuchElementException.class, () -> {
            documentoController.pegarRepresentacaoCompleta("", 0);
        });
    }

    void testCriaRepresentacaoResumidaTituloInexistente() {
        assertThrows(NoSuchElementException.class, () -> {
            documentoController.pegarRepresentacaoResumida("", 0);
        });
    }

    @Test
    void testApagaElementoTituloDocInexistente() {
        assertThrows(NoSuchElementException.class, () -> {
            documentoController.apagarElemento("", 0);
        });
    }

    @Test
    void testMoverElementoParaCimaComTituloDocNaoCadastrado() {
        assertThrows(NoSuchElementException.class, () -> {
            documentoController.moverParaCima("", 1);
        });
    }

    @Test
    void testMoverElementoParaBaixoComTituloDocNaoCadastrado() {
        assertThrows(NoSuchElementException.class, () -> {
            documentoController.moverParaBaixo("", 1);
        });
    }

    @Test
    void testExibirDocumentoInexistente() {
        assertThrows(NoSuchElementException.class, () -> {
            documentoController.exibirDocumento("");
        });
    }

    @Test
    void tesContaElementoEmDocumentoInexistente() {
        assertThrows(NoSuchElementException.class, () -> {
            documentoController.contarElementos("");
        });
    }

    @Test
    void testExibirVisaoCompletaDocumentoInexistente() {
        assertThrows(NoSuchElementException.class, () -> {
            documentoController.criarVisaoCompleta("");
        });
    }

    @Test
    void testExibirVisaoResumidaDocumentoInexistente() {
        assertThrows(NoSuchElementException.class, () -> {
            documentoController.criarVisaoResumida("");
        });
    }

    @Test
    void testExibirVisaoTituloResumidaDocumentoInexistente() {
        assertThrows(NoSuchElementException.class, () -> {
            documentoController.criarVisaoTitulo("");
        });
    }

    @Test
    void testExibirVisaoPrioritariaDocumentoInexistente() {
        assertThrows(NoSuchElementException.class, () -> {
            documentoController.criarVisaoPrioritaria("", 0);
        });
    }

    @Test
    void testCriarAtalho() {
        assertTrue(documentoController.criarDocumento("Doc", 2));
        assertTrue(documentoController.criarDocumento("Doc2", 2));
        assertEquals(1, documentoController.criarLista("Doc", "Termos de compromisso | Termos de prioridade", 4, "|", "-"));
        assertEquals(2, documentoController.criarLista("Doc", "Termos de compromissos | Termos de prioridade", 4, "|", "-"));
        documentoController.criarAtalho("Doc", "Doc2");
    }
}
