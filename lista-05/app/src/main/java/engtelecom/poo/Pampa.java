package engtelecom.poo;

public class Pampa extends VeiculoTracionado implements TracaoIntegral {

    private boolean cacambaAberta;

    public Pampa(String nome) {
        super(nome, 140, 0, false);
        this.cacambaAberta = false;
    }

    public boolean abrirCacamba() {
        if (!isCacambaAberta() && !isMooving()) {
            setCacambaAberta(true);
            return true;
        }
        return false;
    }

    @Override
    public void frear(int i) {
        if (i < 140 && i > 0) {
            super.velocidadeAtual -= i;
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
            setStopped(false);
            if (getVelocidadeAtual() > 140) {
                super.velocidadeAtual = 140;
            }
        }
    }

    @Override
    public boolean ativarDesativarTracao() {
        if (!isMooving()) {
            if (isTracaoAtiva()) {
                setTracaoAtiva(false);
            } else {
                setTracaoAtiva(true);
            }
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

    @Override
    public String getNome() {
        return super.nome;
    }

    @Override
    public int getVelocidadeAtual() {
        return super.velocidadeAtual;
    }

    private boolean isCacambaAberta() {
        return this.cacambaAberta;
    }

    @Override
    public void setStopped(boolean stopped) {
        super.stopped = stopped;
    }

    @Override
    public boolean isTracaoAtiva() {
        return super.tracaoAtiva;
    }

    @Override
    public void setTracaoAtiva(boolean tracaoAtiva) {
        super.tracaoAtiva = tracaoAtiva;
    }

    private void setCacambaAberta(boolean cacambaAberta) {
        this.cacambaAberta = cacambaAberta;
    }

}