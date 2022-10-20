package engtelecom.poo;

public class Robo {
    private static final int MAX = 100;
    private static final int MIN = 0;
    
    private String id; 
    private String orientacao; 
    private int tamanhoArea; 
    private int coordenadaX;
    private int coordenadaY; 
    private int movimentos; 
    private int unidadesPorTurno;

    private String[] plano; 

    public Robo(String id, int tamanhoArea, int coordenadaX, int coordenadaY, String orientacao,
            int movimentos, int unidadesPorTurno) {
        this.id = id;
        this.orientacao = orientacao;
        this.tamanhoArea = tamanhoArea;
        this.coordenadaX = coordenadaX;
        this.coordenadaY = coordenadaY;
        this.movimentos = movimentos;
        this.unidadesPorTurno = unidadesPorTurno;
    }

    public int verificaMovimentos(int movimentos) {
        return -1;
    }

    public int getMovimentos() {
        return movimentos;
    }

    public String[] getPlano() {
        return plano;
    }

    public boolean verificaOrientacao(String orientacao) {
        return true;
    }

    public boolean verificaCoordenada(int coordenadaX, int coordenadaY) {
        return true;
    }

    public boolean verificaTurnos(int unidadesPorTurno) {
        return true;
    }

    @Override
    public String toString() {
        return "coordenadaX=" + coordenadaX + ", coordenadaY=" + coordenadaY + ", " + orientacao + "";
    }

    public String getCoordenadaAnterior() {
        return "";
    }

    public String girarRobo(char comando) {
        return "";
    }

    public boolean moverRobo() {
        return true;
    }

    public boolean carregaPlanos(String planoRobo) {
        return true;
    }

    public boolean executaPlano() {
        return true;
    }

}
