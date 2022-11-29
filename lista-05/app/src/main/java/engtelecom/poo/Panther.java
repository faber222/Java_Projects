package engtelecom.poo;

import java.util.ArrayList;

public class Panther extends Veiculo implements VeiculoAnfibio, TracaoIntegral, Conversivel {

    private ArrayList<String> eventos;
    private int temperatura;
    private boolean rodasRecolhidas;

    public Panther(String nome, int maxVelocidade, int velocidadeAtual) {
        super(nome, maxVelocidade, velocidadeAtual);
        this.temperatura = 25;
        this.rodasRecolhidas = false;
    }

    public void setTempRefri(int t) {
        setTempRefri(t);
    }

    public void setTemperatura(int temperatura) {
        this.temperatura = temperatura;
    }

    public int getTemperatura() {
        return this.temperatura;
    }

    @Override
    public void frear(int i) {
        if (i <= 140 && i > 0 && isMooving()) {
            super.velocidadeAtual -= i;
            this.eventos.add("freiando");
            if (getVelocidadeAtual() < 0) {
                super.velocidadeAtual = 0;
            }
        }
    }

    @Override
    public void acelerar(int i) {
        if (i <= 140 && i > 0) {

            super.velocidadeAtual += i;
            this.eventos.add("acelerando");
            if (getVelocidadeAtual() > 140) {
                super.velocidadeAtual = 140;
            }
        }
    }

    @Override
    public boolean recolherRodas() {
        if (!isRodasRecolhidas() && !isMooving()) {
            esvaziarLastro();
            this.eventos.add("recolhendo rodas");
            setRodasRecolhidas(true);
            return true;
        }
        return false;
    }

    @Override
    public boolean abrirRodas() {
        if (isRodasRecolhidas() && !isMooving()) {
            this.eventos.add("abrindo rodas");
            setRodasRecolhidas(false);
            return true;
        }
        return false;
    }

    @Override
    public void esvaziarLastro() {
        this.eventos.add("esvaziando lastro");
    }

    @Override
    public boolean ativarDesativarTracao() {
        return false;
    }

    @Override
    public boolean abrirCapota() {
        if (!isMooving()) {
            this.eventos.add("abrindo capota");
            return false;
        }
        return false;
    }

    @Override
    public boolean fecharCapota() {
        if (!isMooving()) {
            this.eventos.add("fechando capota");
            return true;
        }
        return false;
    }

    public void setRodasRecolhidas(boolean rodasRecolhidas) {
        this.rodasRecolhidas = rodasRecolhidas;
    }

    public boolean isRodasRecolhidas() {
        return this.rodasRecolhidas;
    }

    @Override
    public boolean isMooving() {
        return super.stopped;
    }

    @Override
    public void setVelocidadeAtual(int velocidadeAtual) {
        super.velocidadeAtual = velocidadeAtual;
    }

    @Override
    public String getNome() {
        return super.nome;
    }

    @Override
    public int getVelocidadeAtual() {
        return super.velocidadeAtual;
    }

    @Override
    public void setStopped(boolean stopped) {
        super.stopped = stopped;
    }

}