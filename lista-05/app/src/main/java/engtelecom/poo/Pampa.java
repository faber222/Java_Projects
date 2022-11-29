package engtelecom.poo;

import java.util.ArrayList;

public class Pampa extends Veiculo implements TracaoIntegral {

    private ArrayList<String> eventos;
    private boolean cacambaAberta;
    private boolean tracaoAtivada;

    /**
     * @param nome
     * @param maxVelocidade
     * @param stopped
     * @param velocidadeAtual
     */
    public Pampa(String nome, int maxVelocidade, int velocidadeAtual) {
        super(nome, velocidadeAtual, velocidadeAtual);
        this.cacambaAberta = false;
        this.tracaoAtivada = false;
    }

    /**
     * @return
     */
    public boolean abrirCacamba() {
        if (isCacambaAberta() && !isMooving()) {
            this.eventos.add("abrindo cacamba");
            this.cacambaAberta = true;
            return true;
        }
        return false;
    }

    @Override
    public void frear(int i) {
        if (i < 140 && i > 0) {
            super.velocidadeAtual -= i;
            this.eventos.add("freiando");
            if (getVelocidadeAtual() < 0) {
                super.velocidadeAtual = 0;
                setStopped(true);
            }
        }
    }

    @Override
    public void acelerar(int i) {
        if (i < 140 && i > 0) {
            super.velocidadeAtual += i;
            this.eventos.add("acelerando");
            setStopped(false);
            if (getVelocidadeAtual() > 140) {
                super.velocidadeAtual = 140;
            }
        }
    }

    @Override
    public boolean ativarDesativarTracao() {
        if (!isMooving()) {
            this.eventos.add("ativando tracao");
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

    @Override
    public String getNome() {
        return super.nome;
    }

    @Override
    public int getVelocidadeAtual() {
        return super.velocidadeAtual;
    }

    public boolean isCacambaAberta() {
        return this.cacambaAberta;
    }

    @Override
    public void setStopped(boolean stopped) {
        super.stopped = stopped;
    }

}