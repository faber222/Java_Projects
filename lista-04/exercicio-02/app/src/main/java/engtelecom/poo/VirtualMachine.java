package engtelecom.poo;

public class VirtualMachine {

    private String nome;
    private int sizeMem;
    private int sizeStorage;
    private boolean power;

    public VirtualMachine(String n, int m, int s) {
        this.nome = n;
        this.sizeMem = m;
        this.sizeStorage = s;
        this.power = false;
    }

    public boolean setPowerOn() {
        return setPower(true);
    }

    public boolean setPowerOff() {
        return setPower(false);
    }

    private boolean setPower(boolean power) {
        return this.power = power;
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