package engtelecom.poo;

import java.util.ArrayList;

public class Ferrari extends Veiculo implements Conversivel {
    private boolean farolLigado;
    private ArrayList<String> eventos;

    public Ferrari(String nome, int maxVelocidade, int velocidadeAtual) {
        super(nome, maxVelocidade, velocidadeAtual);
        this.farolLigado = false;
    }

    public boolean ligarFarolNeblina() {
        if (!isFarol()) {
            this.farolLigado = true;
            eventos.add("Ligando farol");
            return true;
        }
        return false;
    }

    @Override
    public void frear(int i) {
        if (i < 200 && i > 0) {
            super.velocidadeAtual -= i;
            eventos.add("freiando");
            if (getVelocidadeAtual() < 0) {
                super.velocidadeAtual = 0;
                setStopped(true);
            }
        }
    }

    @Override
    public void acelerar(int i) {
        if (i < 200 && i > 0) {
            super.velocidadeAtual += i;
            eventos.add("acelerando");
            setStopped(false);
            if (getVelocidadeAtual() > 200) {
                super.velocidadeAtual = 200;
            }
        }
    }

    @Override
    public boolean abrirCapota() {
        if (getVelocidadeAtual() <= 20) {
            eventos.add("Abrindo capota");
            return true;
        }
        return false;
    }

    @Override
    public boolean fecharCapota() {
        if (getVelocidadeAtual() <= 20) {
            eventos.add("Fechando capota");
            return true;
        }
        return false;
    }

    @Override
    public boolean isMooving() {
        return super.stopped;
    }

    @Override
    public void setVelocidadeAtual(int velocidadeAtual) {
        super.velocidadeAtual = velocidadeAtual;
    }

    public boolean isFarol() {
        return this.farolLigado;
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