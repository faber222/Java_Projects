package engtelecom.poo;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

import org.junit.jupiter.api.Test;

public class PantherTest {
    @Test
    void testAbrirCapota() {
        Panther panther = new Panther("Panther anfibio");

        // deve ser possivel abrir a capota, devido ao carros estar parado
        assertTrue(panther.abrirCapota());

        // como a capota ja esta aberta, não deve ser possivel abrir
        assertFalse(panther.abrirCapota());

        panther.fecharCapota();
        panther.acelerar(10);
        // não deve ser possivel abrir a capota, porque o carro esta em movimento
        assertFalse(panther.abrirCapota());

    }

    @Test
    void testFecharCapota() {
        Panther panther = new Panther("Panther anfibio");

        panther.abrirCapota();
        // deve ser possivel fechar a capota, devido ao carros estar parado
        assertTrue(panther.fecharCapota());

        // como a capota ja esta aberta, não deve ser possivel fechar
        assertFalse(panther.fecharCapota());

        panther.abrirCapota();
        panther.acelerar(10);
        // não deve ser possivel fechar a capota, porque o carro esta em movimento
        assertFalse(panther.fecharCapota());
    }

    @Test
    void testAbrirRodas() {
        Panther panther = new Panther("Panther anfibio");

        panther.recolherRodas();

        // é possivel abrir as rodas, devido ao veiculo estar parado e com as rodas
        // recolhidas
        assertTrue(panther.abrirRodas());

        panther.recolherRodas();
        panther.acelerar(10);

        // como o veiculo esta em movimento, não é possivel abrir as rodas
        assertFalse(panther.abrirRodas());

        panther.frear(10);
        panther.abrirRodas();

        // como o veiculo ja esta com as rodas abertas, não é possivel abrir elas
        assertFalse(panther.abrirRodas());
    }

    @Test
    void testAcelerar() {
        Panther panther = new Panther("Panther anfibio");

        // acelerar com valor de 1 -- 140 é valido
        assertTrue(panther.acelerar(100));
        assertTrue(panther.acelerar(140));

        // acelerar com valor acima de 140 ou menor igual a zero nao é valido
        assertFalse(panther.acelerar(150));
        assertFalse(panther.acelerar(0));
    }

    @Test
    void testAtivarDesativarTracao() {
        Panther panther = new Panther("Panther anfibio");

        // testa se é possivel ativar ou desativar tracao com o veiculo parado
        assertTrue(panther.ativarDesativarTracao());

        panther.acelerar(10);
        // teste para verificar se retorna falso, visando que a panther esta se movendo
        assertFalse(panther.ativarDesativarTracao());
        assertFalse(panther.ativarDesativarTracao());

        panther.frear(9);
        // testa se com velocidade de 1, retorna false
        assertFalse(panther.ativarDesativarTracao());

        panther.frear(1);
        // testa se depois de acelerar e freiar, ainda é possivel ativar ou desativar a
        // tracao
        assertTrue(panther.ativarDesativarTracao());

        panther.recolherRodas();
        // não deve ser possivel ativar, devido as rodas estarem recolhidas
        assertFalse(panther.ativarDesativarTracao());
    }

    @Test
    void testEsvaziarLastro() {
        Panther panther = new Panther("Panther anfibio");

        panther.acelerar(10);
        // não deve ser possivel estavaziar, devido ao veiculo estar em movimento
        assertFalse(panther.esvaziarLastro());

        panther.frear(10);

        // deve ser possivel esvaziar, devido ao veiculo estar parado e o lastro cheio
        assertTrue(panther.esvaziarLastro());

        // não deve ser possivel estavaziar, devido ao lastro ja estar vazio
        assertFalse(panther.esvaziarLastro());
    }

    @Test
    void testFrear() {
        Panther panther = new Panther("Panther anfibio");

        // frear com valor de 1 -- 140 é valido
        assertTrue(panther.frear(100));
        assertTrue(panther.frear(100));

        // frear com valor acima de 140 ou menor igual a zero nao é valido
        assertFalse(panther.frear(150));
        assertFalse(panther.frear(0));
        assertFalse(panther.frear(-190));
    }

    @Test
    void testRecolherRodas() {
        Panther panther = new Panther("Panther anfibio");

        panther.abrirRodas();

        // é possivel abrir as rodas, devido ao veiculo estar parado e com as rodas
        // recolhidas
        assertTrue(panther.recolherRodas());

        panther.abrirRodas();
        panther.acelerar(10);

        // como o veiculo esta em movimento, não é possivel abrir as rodas
        assertFalse(panther.recolherRodas());

        panther.frear(10);
        panther.recolherRodas();

        // como o veiculo ja esta com as rodas abertas, não é possivel abrir elas
        assertFalse(panther.recolherRodas());
    }
}
