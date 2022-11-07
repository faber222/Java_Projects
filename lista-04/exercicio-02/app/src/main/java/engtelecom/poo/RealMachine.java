package engtelecom.poo;

import java.util.ArrayList;

public class RealMachine {
    private String nome;
    private int sizeMem;
    private int sizeStorage;
    private ArrayList<VirtualMachine> vms;

    public RealMachine() {
    }

    /**
     * @param n
     * @param m
     * @param s
     */
    public void RealMachine(String n, int m, int s) {

    }

    /**
     * @param vm
     * @return
     */
    public boolean createVm(VirtualMachine vm) {
        return false;
    }

    /**
     * @param number
     * @return
     */
    public boolean removeVm(int number) {
        return false;
    }

    /**
     * @param number
     * @return
     */
    public boolean turnOnVm(int number) {
        return false;
    }

    /**
     * @param number
     * @return
     */
    public boolean turnOffVm(int number) {
        return false;
    }

}