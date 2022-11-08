package engtelecom.poo;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

import org.junit.jupiter.api.Test;

public class RackTest {
    @Test
    public void addRealMachine() {
        Rack rack = new Rack();

        assertTrue(rack.addRealMachine("PC faber", 1000, 128000));
        assertTrue(rack.addRealMachine("PC faber", 1000, 128000));
        assertTrue(rack.addRealMachine("PC faber", 1000, 128000));
        assertTrue(rack.addRealMachine("PC faber", 1000, 128000));
        assertTrue(rack.addRealMachine("PC faber", 1000, 128000));

        assertFalse(rack.addRealMachine("PC faber", 1000, 128000));
    }

    @Test
    public void removeRealMachine() {
        Rack rack = new Rack();
        rack.addRealMachine("PC faber", 1000, 128000);
        rack.addRealMachine("PC faber", 1000, 128000);
        rack.addRealMachine("PC faber", 1000, 128000);

        assertTrue(rack.removeRealMachine(0));
        assertTrue(rack.removeRealMachine(0));
        assertFalse(rack.removeRealMachine(3));
        assertTrue(rack.removeRealMachine(0));

        assertFalse(rack.removeRealMachine(0));
    }

}
