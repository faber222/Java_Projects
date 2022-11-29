package engtelecom.poo;

public abstract class Veiculo {

    protected String nome;
    protected int maxVelocidade;
    protected boolean stopped;
    protected int velocidadeAtual;

    /**
     * @param nome
     * @param maxVelocidade
     * @param stopped
     * @param velocidadeAtual
     */
    public Veiculo(String nome, int maxVelocidade, int velocidadeAtual) {
        this.nome = nome;
        this.maxVelocidade = maxVelocidade;
        this.stopped = false;
        this.velocidadeAtual = velocidadeAtual;
    }

    /**
     * @return the nome
     */
    public abstract String getNome();

    /**
     * @return the velocidadeAtual
     */
    public abstract int getVelocidadeAtual();

    /**
     * @param velocidadeAtual the velocidadeAtual to set
     */
    public abstract void setVelocidadeAtual(int velocidadeAtual);

    /**
     * @return
     */
    public abstract boolean isMooving();

    /**
     * @param stopped the stopped to set
     */
    public abstract void setStopped(boolean stopped);

}