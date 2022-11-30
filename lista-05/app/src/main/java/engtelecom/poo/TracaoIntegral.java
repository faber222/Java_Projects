package engtelecom.poo;

public interface TracaoIntegral extends VeiculoTerrestre {

    public abstract boolean ativarDesativarTracao();

    public abstract boolean isTracaoAtiva();

    public abstract void setTracaoAtiva(boolean tracaoAtiva);

}