package engtelecom.poo;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

import org.junit.jupiter.api.Test;

public class PampaTest {
    @Test
    void testAbrirCacamba() {
        Pampa pampa = new Pampa("Pampa S");

        // fazendo teste para verificar se ele abre a cacamba apenas uma vez
        assertTrue(pampa.abrirCacamba());

        // como ja esta aberta, deve retornar false
        assertFalse(pampa.abrirCacamba());
        assertFalse(pampa.abrirCacamba());
    }

    @Test
    void testAcelerar() {
        Pampa pampa = new Pampa("Pampa S");

        // acelerar com valor de 1 -- 140 é valido
        assertTrue(pampa.acelerar(100));
        assertTrue(pampa.acelerar(140));

        // acelerar com valor acima de 140 ou menor igual a zero nao é valido
        assertFalse(pampa.acelerar(150));
        assertFalse(pampa.acelerar(0));
    }

    @Test
    void testAtivarDesativarTracao() {
        Pampa pampa = new Pampa("Pampa S");

        // testa se é possivel ativar ou desativar tracao com o veiculo parado
        assertTrue(pampa.ativarDesativarTracao());

        pampa.acelerar(10);
        // teste para verificar se retorna falso, visando que a pampa esta se movendo
        assertFalse(pampa.ativarDesativarTracao());
        assertFalse(pampa.ativarDesativarTracao());

        pampa.frear(9);
        // testa se com velocidade de 1, retorna false
        assertFalse(pampa.ativarDesativarTracao());

        pampa.frear(1);
        // testa se depois de acelerar e freiar, ainda é possivel ativar ou desativar a
        // tracao
        assertTrue(pampa.ativarDesativarTracao());
    }

    @Test
    void testFrear() {
        Pampa pampa = new Pampa("Pampa S");

        // frear com valor de 1 -- 140 é valido
        assertTrue(pampa.frear(100));
        assertTrue(pampa.frear(100));

        // frear com valor acima de 140 ou menor igual a zero nao é valido
        assertFalse(pampa.frear(150));
        assertFalse(pampa.frear(0));
        assertFalse(pampa.frear(-190));
    }
}
