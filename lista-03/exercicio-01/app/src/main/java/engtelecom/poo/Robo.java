package engtelecom.poo;

import java.util.ArrayList;
import java.util.Random;

public class Robo {
    private static final int MAX = 100; // valor maximo de movimentos
    private static final int MIN = 0; // valor minimo de movimentos
    private static final int MIN_FIXO = 0; //

    private String id; // hash de identificação do robo
    private String orientacao; // Norte, Sul, Leste, Oeste
    private int tamanhoArea; // tamanho em m² do local
    private int coordenadaX; // coordenada inicial em x
    private int coordenadaY; // coordenada inicial em y
    private int movimentos; // numero de movimentos restantes
    private int unidadesPorTurno; // maximo de movimentos por turno

    private ArrayList<String> plano; // plano de exploração do robo
    private int coordenadaXAnterior; // coordenada anterior em x
    private int coordenadaYAnterior; // coordenada anterior em y

   
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

    public String planoRestante() {
        return "";
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

    public String getCoordenadaOrientacao() {
        return "coordenadaX=" + coordenadaX + ", coordenadaY=" + coordenadaY + ", " + orientacao + "";
    }

    public String coordenadaAnterior() {
        return "";
    }

    public String girarRobo(String comando) {
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
