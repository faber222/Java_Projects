package engtelecom.poo;

public class Ferrari extends Veiculo implements Conversivel {
    private boolean farolLigado;
    private boolean capotaAberta;

    public Ferrari(String nome) {
        super(nome, 200, 0);
        this.farolLigado = false;
        this.capotaAberta = false;
    }

    public boolean ligarFarolNeblina() {
        if (!isFarolLigado()) {
            setFarolLigado(true);
            return true;
        }
        return false;
    }

    @Override
    public void frear(int i) {
        if (i < 200 && i > 0) {
            super.velocidadeAtual -= i;
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
            setStopped(false);
            if (getVelocidadeAtual() > 200) {
                super.velocidadeAtual = 200;
            }
        }
    }

    @Override
    public boolean abrirCapota() {
        if (getVelocidadeAtual() <= 20 && !isCapotaAberta()) {
            setCapotaAberta(true);
            return true;
        }
        return false;
    }

    @Override
    public boolean fecharCapota() {
        if (getVelocidadeAtual() <= 20 && isCapotaAberta()) {
            setCapotaAberta(false);
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

    @Override
    public void setStopped(boolean stopped) {
        super.stopped = stopped;
    }

    private boolean isFarolLigado() {
        return this.farolLigado;
    }

    private void setFarolLigado(boolean farolLigado) {
        this.farolLigado = farolLigado;
    }

    private boolean isCapotaAberta() {
        return this.capotaAberta;
    }

    private void setCapotaAberta(boolean capotaAberta) {
        this.capotaAberta = capotaAberta;
    }

}