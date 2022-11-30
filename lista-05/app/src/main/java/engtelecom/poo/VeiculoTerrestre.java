package engtelecom.poo;

public interface VeiculoTerrestre {

    public abstract boolean frear(int i);

    public abstract boolean acelerar(int i);

    public abstract String getNome();

    public abstract int getVelocidadeAtual();

    public abstract void setVelocidadeAtual(int velocidadeAtual);

    public abstract boolean isStopped();

    public abstract void setStopped(boolean stopped);

}