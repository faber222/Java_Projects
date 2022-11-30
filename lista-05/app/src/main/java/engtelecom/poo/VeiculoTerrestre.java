package engtelecom.poo;

public interface VeiculoTerrestre {

    public abstract void frear(int i);

    public abstract void acelerar(int i);

    public abstract String getNome();

    public abstract int getVelocidadeAtual();

    public abstract void setVelocidadeAtual(int velocidadeAtual);

    public abstract boolean isMooving();

    public abstract void setStopped(boolean stopped);

}