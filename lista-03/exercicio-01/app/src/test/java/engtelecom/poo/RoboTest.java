package engtelecom.poo;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;

public class RoboTest {
    @Test
    public void verificaMovimentos() {
        Robo teste1 = new Robo("C3PO", 200, 10, 20, "Norte", 100, 10);
        assertEquals(0, teste1.verificaMovimentos(0));
        assertEquals(100, teste1.verificaMovimentos(200));
        assertEquals(32, teste1.verificaMovimentos(32));
    }

    @Test
    public void verificaOrientacao() {
        Robo teste2 = new Robo("C3PO", 200, 10, 20, "Norte", 100, 10);
        assertEquals(true, teste2.verificaOrientacao("Norte"));
        assertEquals(true, teste2.verificaOrientacao("Leste"));
        assertEquals(true, teste2.verificaOrientacao("Oeste"));
        assertEquals(true, teste2.verificaOrientacao("Sul"));
        assertEquals(false, teste2.verificaOrientacao("Capivari"));
    }

    @Test
    public void verificaCoordenada() {
        Robo teste3 = new Robo("C3PO", 200, 10, 20, "Norte", 100, 10);
        assertEquals(true, teste3.verificaCoordenada(10, 20));
        assertEquals(false, teste3.verificaCoordenada(-10, 0));
        assertEquals(false, teste3.verificaCoordenada(300, 0));
    }

    @Test
    public void verificaTurnos() {
        Robo teste4 = new Robo("C3PO", 200, 10, 20, "Norte", 100, 10);
        assertEquals(true, teste4.verificaTurnos(10));
        assertEquals(true, teste4.verificaTurnos(100));
        assertEquals(true, teste4.verificaTurnos(1));
        assertEquals(false, teste4.verificaTurnos(0));
        assertEquals(false, teste4.verificaTurnos(-10));
        assertEquals(false, teste4.verificaTurnos(200));
    }

    @Test
    public void girarRobo() {
        Robo teste6 = new Robo("C3PO", 200, 10, 10, "Norte", 100, 10);
        assertEquals("Oeste", teste6.girarRobo("E"));
        assertEquals("Sul", teste6.girarRobo("E"));
        assertEquals("Leste", teste6.girarRobo("E"));
        assertEquals("Norte", teste6.girarRobo("E"));
        assertEquals("Leste", teste6.girarRobo("D"));
        assertEquals("Sul", teste6.girarRobo("D"));
        assertEquals("Oeste", teste6.girarRobo("D"));
        assertEquals("Norte", teste6.girarRobo("D"));
    }

    @Test
    public void moverRobo() {
        Robo teste7 = new Robo("C3PO", 200, 10, 10, "Norte", 100, 10);
        assertEquals(true, teste7.moverRobo());
        Robo teste8 = new Robo("C3PO", 19, 10, 10, "Norte", 100, 10);
        assertEquals(false, teste8.moverRobo());
    }

    @Test
    public void carregaPlanos() {
        Robo teste9 = new Robo("C3PO", 200, 10, 10, "Norte", 100, 10);
        assertEquals(true, teste9.carregaPlanos("MEDMEEMDM"));
        assertEquals(false, teste9.carregaPlanos("MEDMAEMDM"));
    }

    @Test
    public void executaPlano() {
        Robo teste10 = new Robo("C3PO", 200, 10, 10, "Norte", 100, 10);
        teste10.carregaPlanos("MED");
        assertEquals(true, teste10.executaPlano());
        assertEquals(true, teste10.executaPlano());
        assertEquals(true, teste10.executaPlano());
        assertEquals(false, teste10.executaPlano());
    }
    
    @Test 
    public void getPlano() {
        Robo teste12 = new Robo("C3PO", 200, 10, 10, "Norte", 100, 10);
        teste12.carregaPlanos("MMDDE");
        teste12.executaPlano();
        teste12.executaPlano();
        assertEquals("DDE", teste12.planoRestante());
    }
}
