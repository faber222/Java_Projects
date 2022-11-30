package engtelecom.poo;

public class Panther extends VeiculoTracionado implements VeiculoAnfibio, TracaoIntegral, Conversivel {
    private int temperatura;
    private boolean rodasRecolhidas;
    private boolean capotaAberta;
    private boolean lastroCheio;

    public Panther(String nome) {
        super(nome, 140, 0, false);
        this.temperatura = 25;
        this.rodasRecolhidas = false;
        this.capotaAberta = false;
        this.lastroCheio = true;
    }

    public void setTempRefri(int t) {
        setTemperatura(t);
    }

    public int getTemperatura() {
        return temperatura;
    }

    @Override
    public boolean frear(int i) {
        if (i <= 140 && i > 0) {
            super.velocidadeAtual -= i;
            if (getVelocidadeAtual() <= 0) {
                super.velocidadeAtual = 0;
                setStopped(true);
            }
            return true;
        }
        return false;
    }

    @Override
    public boolean acelerar(int i) {
        if (i <= 140 && i > 0) {
            super.velocidadeAtual += i;
            setStopped(false);
            if (getVelocidadeAtual() > 140) {
                super.velocidadeAtual = 140;
            }
            return true;
        }
        return false;
    }

    @Override
    public boolean recolherRodas() {
        if (!isRodasRecolhidas() && !isStopped()) {
            esvaziarLastro();
            setRodasRecolhidas(true);
            return true;
        }
        return false;
    }

    @Override
    public boolean abrirRodas() {
        if (isRodasRecolhidas() && !isStopped()) {
            setRodasRecolhidas(false);
            return true;
        }
        return false;
    }

    @Override
    public boolean esvaziarLastro() {
        if (!isStopped() && isLastroCheio()) {
            setLastroCheio(false);
            return true;
        }
        return false;
    }

    @Override
    public boolean ativarDesativarTracao() {
        if (!isStopped()) {
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
    public boolean abrirCapota() {
        if (!isStopped() && !isCapotaAberta()) {
            setCapotaAberta(true);
            return true;
        }
        return false;
    }

    @Override
    public boolean fecharCapota() {
        if (!isStopped() && isCapotaAberta()) {
            setCapotaAberta(false);
            return true;
        }
        return false;
    }

    private void setTemperatura(int temperatura) {
        this.temperatura = temperatura;
    }

    private void setRodasRecolhidas(boolean rodasRecolhidas) {
        this.rodasRecolhidas = rodasRecolhidas;
    }

    private boolean isRodasRecolhidas() {
        return this.rodasRecolhidas;
    }

    private boolean isCapotaAberta() {
        return this.capotaAberta;
    }

    private void setCapotaAberta(boolean capotaAberta) {
        this.capotaAberta = capotaAberta;
    }

    private boolean isLastroCheio() {
        return this.lastroCheio;
    }

    private void setLastroCheio(boolean lastroCheio) {
        this.lastroCheio = lastroCheio;
    }

    @Override
    public boolean isStopped() {
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

    @Override
    public boolean isTracaoAtiva() {
        return super.tracaoAtiva;
    }

    @Override
    public void setTracaoAtiva(boolean tracaoAtiva) {
        super.tracaoAtiva = tracaoAtiva;
    }

}