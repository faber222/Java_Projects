package engtelecom.poo;

public interface VeiculoAnfibio extends VeiculoTerrestre {

    /**
     * @return
     */
    public abstract boolean recolherRodas();

    /**
     * @return
     */
    public abstract boolean abrirRodas();

    /**
     * @return
     */
    public abstract void esvaziarLastro();

}