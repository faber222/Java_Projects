package engtelecom.poo;

// import java.time.LocalTime;

import edu.princeton.cs.algs4.Draw;

public class App {

    private Draw desenho;

    public App() {
        this.desenho = new Draw();
        // definindo a área de desenho --
        // https://introcs.cs.princeton.edu/java/stdlib/javadoc/Draw.html
        this.desenho.setCanvasSize(600, 600);
        // definindo a escala da área de desenho -- leia mais na documentação da classe
        this.desenho.setXscale(0, 600);
        this.desenho.setYscale(0, 600);
    }

    public void desenhaRelogio(Relogio primeiroRelogio) {
        primeiroRelogio.desenho(this.desenho,10, 20, 30);
    }

    public static void main(String[] args) {
        Relogio primeiroRelogio = new Relogio(100, 100, -3, "Brasilia");
        App painel = new App();
        painel.desenhaRelogio(primeiroRelogio);
    
    }

}
