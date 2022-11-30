package engtelecom.poo;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

import org.junit.jupiter.api.Test;

public class FerrariTest {
    @Test
    void testAbrirCapota() {
        Ferrari ferrari = new Ferrari("Ferrari Spider");

        ferrari.acelerar(20);
        // testa se é possivel abrir a capota com 20km/h
        assertTrue(ferrari.abrirCapota());

        // fecha a capota para testar novamente
        ferrari.fecharCapota();

        // acelera mais 10km/h,
        ferrari.acelerar(10);

        // deve retornar falso devido a estar atualmente em 30km/h
        assertFalse(ferrari.abrirCapota());

        ferrari.frear(15);
        // depois de freiar para 15km/h, deve ser possivel abrir a capota
        assertTrue(ferrari.abrirCapota());
    }

    @Test
    void testAcelerar() {
        Ferrari ferrari = new Ferrari("Ferrari Spider");

        // é valido acelear entre 1 até 200, caso tenha que acelear mais, fica estagnado
        // em 200km/h
        assertTrue(ferrari.acelerar(200));
        assertTrue(ferrari.acelerar(1));

        // não é valido acelerar cima de 200 e nem abaixo de 1
        assertFalse(ferrari.acelerar(0));
        assertFalse(ferrari.acelerar(250));
    }

    @Test
    void testFecharCapota() {
        Ferrari ferrari = new Ferrari("Ferrari Spider");

        ferrari.abrirCapota();

        ferrari.acelerar(20);
        // testa se é possivel abrir a capota com 20km/h
        assertTrue(ferrari.fecharCapota());

        // fecha a capota para testar novamente
        ferrari.abrirCapota();

        // acelera mais 10km/h,
        ferrari.acelerar(10);

        // deve retornar falso devido a estar atualmente em 30km/h
        assertFalse(ferrari.fecharCapota());

        ferrari.frear(15);
        // depois de freiar para 15km/h, deve ser possivel fechar a capota
        assertTrue(ferrari.fecharCapota());

        // não deve ser possivel fechar a capota, pois ja esta fechada
        assertFalse(ferrari.fecharCapota());
    }

    @Test
    void testFrear() {
        Ferrari ferrari = new Ferrari("Ferrari Spider");
        // frear com valor de 1 -- 200 é valido
        assertTrue(ferrari.frear(200));
        assertTrue(ferrari.frear(1));

        // frear com valor acima de 200 ou menor igual a zero nao é valido
        assertFalse(ferrari.frear(240));
        assertFalse(ferrari.frear(0));
        assertFalse(ferrari.frear(-190));
    }

    @Test
    void testLigarFarolNeblina() {
        Ferrari ferrari = new Ferrari("Ferrari Spider");

        // deve ser possivel ligar, pois esta desligado
        assertTrue(ferrari.ligarFarolNeblina());

        // farol ja esta ligado, não deve ser possivel ligar
        assertFalse(ferrari.ligarFarolNeblina());

    }
}
