import org.junit.Assert;
import org.junit.Test;

public class PlanoTest {

    @Test
    public void testPlanoPosBig_valorAPagar() {
        Telefonia telefonia = new Telefonia("Joao Campos", "123.345.678-99", "99991010");
        PlanoPosBig plano = new PlanoPosBig(telefonia, 5.0);

        double valorEsperado = 105.0;
        double valorCalculado = plano.valorAPagar(21);

        Assert.assertEquals(valorEsperado, valorCalculado, 0.01);
    }

    @Test
    public void testPlanoPreBig_valorAPagar_DiasExcedentes() {
        Telefonia telefonia = new Telefonia("Joana Costa", "665.787.999.08", "988139898");
        PlanoPreBig plano = new PlanoPreBig(telefonia, 20, 50.0, 10.0);

        double valorEsperado = 10.0;
        double valorCalculado = plano.valorAPagar(21);

        Assert.assertEquals(valorEsperado, valorCalculado, 0.01);
    }

    @Test
    public void testPlanoPreBig_valorAPagar_DiasDentroDaFranquia() {
        Telefonia telefonia = new Telefonia("Maria Silva", "987.654.321-00", "97778888");
        PlanoPreBig plano = new PlanoPreBig(telefonia, 30, 80.0, 15.0);

        double valorEsperado = 0.0;
        double valorCalculado = plano.valorAPagar(25);

        Assert.assertEquals(valorEsperado, valorCalculado, 0.01);
    }

    @Test
    public void testValorAPagarPlanoPreBigSemExcedente() {
        PlanoPreBig plano = new PlanoPreBig("Joao Campos", "123.345.678-99", "99991010", 20, 100.0, 10.0);
        double valorAPagar = plano.valorAPagar(15);
        Assert.assertEquals(0.0, valorAPagar, 0.01);
    }

    @Test
    public void testValorAPagarPlanoPreBigComExcedente() {
        Telefonia telefonia = new Telefonia("Joao Campos", "123.345.678-99", "99991010");
        PlanoPreBig plano = new PlanoPreBig(telefonia, 20, 100.0, 10.0);
        double valorAPagar = plano.valorAPagar(25);
        Assert.assertEquals(50.0, valorAPagar, 0.01);
    }

    @Test
    public void testValorAPagarPlanoPosBig() {
        Telefonia telefonia = new Telefonia("Joana Costa", "665.787.999.08", "988139898");
        PlanoPosBig plano = new PlanoPosBig(telefonia, 5.0);
        double valorAPagar = plano.valorAPagar(21);
        Assert.assertEquals(105.0, valorAPagar, 0.01);
    }


    @Test(expected = IllegalArgumentException.class)
    public void testValorAPagarComNumeroDeDiasNegativo() {
        PlanoPreBig plano = new PlanoPreBig("Joao Campos", "123.345.678-99", "99991010", 20, 100.0, 10.0);
        plano.valorAPagar(-10);
    }

    @Test(expected = IllegalArgumentException.class)
    public void testValorAPagarComPlanoNulo() {
        Plano plano = null;
        try {
            if (plano != null) {
                plano.valorAPagar(10);
                Assert.fail("Uma exceção deveria ter sido lançada");
            } else {
                throw new IllegalArgumentException("O plano não pode ser nulo");
            }
        } catch (IllegalArgumentException e) {
            Assert.assertEquals("O plano não pode ser nulo", e.getMessage());
        }
    }
}