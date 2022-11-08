package engtelecom.poo;

import java.util.ArrayList;

public class Rack {
    private static final int MAX = 5;

    private ArrayList<RealMachine> maquinas;

    public Rack() {
        this.maquinas = new ArrayList<>();
    }

    public boolean addRealMachine(String n, int m, int s) {
        if (verificaTamanhoVetor()) {
            RealMachine pc = new RealMachine(n, m, s);
            this.maquinas.add(pc);
            return true;
        }
        return false;
    }

    public boolean removeRealMachine(int number) {
        if (!this.maquinas.isEmpty()) {
            if (this.maquinas.size() > number) {
                this.maquinas.remove(number);
                return true;
            }

        }
        return false;
    }

    private boolean verificaTamanhoVetor() {
        return this.maquinas.size() < MAX;
    }

    public static void main(String[] args) {
        Rack rack = new Rack();
        rack.addRealMachine("PC faber", 1000, 128000);

        for (RealMachine pc : rack.maquinas) {
            pc.createVm("VM faber1", 100, 5000);
            pc.createVm("VM faber2", 100, 5000);

            pc.turnOnVm(0);
            pc.turnOffVm(1);

            pc.removeVm(1);

            pc.turnOffVm(0);
        }
    }

}