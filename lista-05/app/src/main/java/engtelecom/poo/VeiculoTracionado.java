package engtelecom.poo;

public abstract class VeiculoTracionado extends Veiculo {
    protected boolean tracaoAtiva;

    public VeiculoTracionado(String nome, int maxVelocidade, int velocidadeAtual, boolean tracao) {
        super(nome, maxVelocidade, velocidadeAtual);
        this.tracaoAtiva = tracao;
    }

 
}
