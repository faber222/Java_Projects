package engtelecom.poo;

import java.util.ArrayList;

public class RealMachine {
    private static final int MAX = 5;

    private String nome;
    private int sizeMem;
    private int sizeStorage;
    private ArrayList<VirtualMachine> vms;

    public RealMachine(String n, int m, int s) {
        this.nome = n;
        this.sizeMem = m;
        this.sizeStorage = s;
        this.vms = new ArrayList<>();
    }

    public boolean createVm(String n, int m, int s) {
        if (verificaTamanhoVetor()) {
            if (verificaRam(m) && verificaStorage(s)) {
                VirtualMachine vm = new VirtualMachine(n, m, s);
                this.sizeMem -= m;
                this.sizeStorage -= s;
                this.vms.add(vm);
                return true;
            }
        }
        return false;
    }

    public boolean removeVm(int number) {
        if (!this.vms.isEmpty()) {
            VirtualMachine vm = iterador(number);
            if (vm != null) {
                this.sizeMem += vm.getSizeMem();
                this.sizeStorage += vm.getSizeStorage();
                this.vms.remove(number);
                return true;
            }
        }
        return false;
    }

    public boolean turnOnVm(int number) {
        return setOnOff(true, number);
    }

    public boolean turnOffVm(int number) {
        return setOnOff(false, number);
    }

    private boolean setOnOff(boolean ligar, int number) {
        if (!this.vms.isEmpty()) {
            VirtualMachine vm = iterador(number);
            if (vm != null) {
                if (ligar) {
                    vm.setPowerOn();
                    System.out.println("Máquina " + vm.getNome() + " ligada!");
                } else {
                    vm.setPowerOff();
                    System.out.println("Máquina " + vm.getNome() + " desligada!");
                }
                this.vms.set(number, vm);
                return true;
            }
        }

        return false;
    }

    private VirtualMachine iterador(int number) {
        int x = 0;
        for (VirtualMachine vm : this.vms) {
            if (x == number) {
                return vm;
            }
            x++;
        }
        return null;
    }

    private boolean verificaRam(int m) {
        return this.sizeMem > m;
    }

    private boolean verificaStorage(int s) {
        return this.sizeStorage > s;
    }

    private boolean verificaTamanhoVetor() {
        return this.vms.size() < MAX;
    }

    public String getNome() {
        return nome;
    }

    public int getSizeMem() {
        return sizeMem;
    }

    public int getSizeStorage() {
        return sizeStorage;
    }

}