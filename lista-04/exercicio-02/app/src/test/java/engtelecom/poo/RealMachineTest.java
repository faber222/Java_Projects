package engtelecom.poo;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

import org.junit.jupiter.api.Test;

public class RealMachineTest {
    @Test
    public void createVm() {
        RealMachine pc = new RealMachine("PC faber", 1000, 128000);

        assertTrue(pc.createVm("VM faber", 100, 5000));
        assertTrue(pc.createVm("VM faber", 100, 5000));
        assertTrue(pc.createVm("VM faber", 100, 5000));

        assertFalse(pc.createVm("VM faber", 1000, 5000));

        assertTrue(pc.createVm("VM faber", 100, 5000));
        assertTrue(pc.createVm("VM faber", 100, 5000));

        assertFalse(pc.createVm("VM faber", 100, 5000));

        pc.removeVm(0);
        pc.removeVm(0);
        pc.removeVm(0);

        assertTrue(pc.createVm("VM faber", 700, 5000));
    }

    @Test
    public void removeVm() {
        RealMachine pc = new RealMachine("PC faber", 1000, 128000);
        pc.createVm("VM faber", 100, 5000);
        pc.createVm("VM faber", 100, 5000);
        pc.createVm("VM faber", 100, 5000);

        assertTrue(pc.removeVm(0));
        assertFalse(pc.removeVm(3));
        assertTrue(pc.removeVm(0));
        assertTrue(pc.removeVm(0));
        assertFalse(pc.removeVm(4));
        assertFalse(pc.removeVm(0));
    }
}
