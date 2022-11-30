package engtelecom.poo;

public abstract class Veiculo {

    public String nome;
    protected int maxVelocidade;
    protected boolean stopped;
    protected int velocidadeAtual;

    public Veiculo(String nome, int maxVelocidade, int velocidadeAtual) {
        this.nome = nome;
        this.maxVelocidade = maxVelocidade;
        this.stopped = false;
        this.velocidadeAtual = velocidadeAtual;
    }


}