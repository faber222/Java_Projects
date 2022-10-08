package engtelecom.poo;

// import java.time.LocalTime;

import edu.princeton.cs.algs4.Draw;

public class App {
    // tamanho dos vetores
    private static final int MAX = 3;

    // atributo desenho como vetor
    // usado para desenhar mais de um relogio
    // sem o uso do vetor desenho, ele vai sobreescrever o quadro
    private Draw[] desenho = new Draw[MAX];

    // vetor relogio que armazena os relogios a serem instanciados
    private Relogio[] vetorRelogio = new Relogio[MAX];

    public App() {
        for (int i = 0; i < MAX; i++) {
            // a chamada de new Draw cria um quadro em branco
            this.desenho[i] = new Draw();
            // a chamada do setCanvasSize, acaba por definir um novo tamanho pro quadro
            // branco, mas acaba, se executado muito rapido, por bugar e criar dois
            // se fizer debug, o processo ocorre com calma e não ocorre bug
            // verificado que isso é da função, e não um erro do código
            // devido ao bug, adicionei uma pausa de 1s para cada rodada
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            } // 1 segundo
            
            this.desenho[i].setCanvasSize(600, 600);
            this.desenho[i].setXscale(0, 600);
            this.desenho[i].setYscale(0, 600);
        }
    }

    public boolean adicionarRelogio(Relogio consulta) {
        for (int j = 0; j < MAX; j++) {
            if (this.vetorRelogio[j] == null) {
                this.vetorRelogio[j] = consulta;
                return true;
            }
        }
        // caso não seja possivel adicionar mais relogios, retorna falso
        return false;
    }

    public void desenhaRelogio() {
        for (int j = 0; j < MAX; j++) {
            this.vetorRelogio[j].desenha(desenho[j], 10, 20, 30);
        }
    }

    public static void main(String[] args){
        Relogio primeiroRelogio = new Relogio(100, 100, -3, "Brasilia");
        Relogio segundoRelogio = new Relogio(200, 200, -3, "Brasilia");
        Relogio terceiroRelogio = new Relogio(300, 300, -3, "Brasilia");
        Relogio quartoRelogio = new Relogio(300, 300, -3, "Brasilia");
        App painel = new App();

        painel.adicionarRelogio(primeiroRelogio);
        painel.adicionarRelogio(segundoRelogio);
        painel.adicionarRelogio(terceiroRelogio);
        painel.adicionarRelogio(quartoRelogio);
        painel.desenhaRelogio();

    }

}
