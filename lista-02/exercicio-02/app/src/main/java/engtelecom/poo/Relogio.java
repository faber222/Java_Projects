package engtelecom.poo;

import edu.princeton.cs.algs4.Draw;

public class Relogio {
    private int fusoHorario;
    private String nomeFuso;
    private int coordenadaX;
    private int coordenadaY;

    public Relogio(int coordenadaX, int coordenadaY, int fusoHorario, String nomeFuso) {
        if (verificaCoordenada(coordenadaX, coordenadaY)) {
            this.coordenadaX = coordenadaX;
            this.coordenadaY = coordenadaY;
        } else {
            this.coordenadaX = 300;
            this.coordenadaY = 300;
        }
        if (verificaFuso(fusoHorario)) {
            this.fusoHorario = fusoHorario;
        } else {
            this.fusoHorario = 0;
        }
        this.nomeFuso = nomeFuso;
    }

    public int getCoordenadaX() {
        return coordenadaX;
    }

    public int getCoordenadaY() {
        return coordenadaY;
    }

    public String toString() {
        return "" + fusoHorario + ", " + nomeFuso + ", " + coordenadaX
                + ", " + coordenadaY + "";
    }

    public Relogio(int coordenadaX, int coordenadaY) {
        if (verificaCoordenada(coordenadaX, coordenadaY)) {
            this.coordenadaX = coordenadaX;
            this.coordenadaY = coordenadaY;
        } else {
            this.coordenadaX = 300;
            this.coordenadaY = 300;
        }
        this.fusoHorario = 0;
        this.nomeFuso = "UTC";

    }

    public boolean verificaCoordenada(int coordenadaX, int coordenadaY) {
        return (coordenadaX <= 600 && coordenadaY <= 600 && coordenadaX >= 0 && coordenadaY >= 0);
    }

    public boolean verificaFuso(int fusoHorario) {
        return (fusoHorario <= 12 && fusoHorario >= -12);
    }

    public boolean verificaHoraTotal(int hora, int minuto, int segundo) {
        return (checkHora(hora) && checkMinutoSegundo(minuto, segundo));
    }

    public void desenho(Draw desenhaRelogio, int horas, int minutos, int segundos) {
        if (!verificaHoraTotal(horas, minutos, segundos)) {
            horas = 0;
            minutos = 0;
            segundos = 0;
            this.nomeFuso = "UTC";
        }
        horas = aplicaFuso(horas);

        double vetX = 0.5 + this.coordenadaX;
        double vetY = 0.5 + this.coordenadaY;

        desenhaRelogio.clear(Draw.LIGHT_GRAY);

        desenhaRelogio.setPenColor(Draw.WHITE);
        desenhaRelogio.filledCircle(vetX, vetY, 100.5);
        desenhaRelogio.setPenColor(Draw.BLACK);
        double r2 = 40.08;
        double r3 = 40.05;
        double r4 = 100;
        double r5 = 90;
        desenhaRelogio.setPenRadius(0.01);
        for (int i = 0; i < 12; i++) {
            double theta = Math.toRadians(30 * i);
            // https://brasilescola.uol.com.br/matematica/simetria-no-circulo-trigonometrico.htm
            desenhaRelogio.line(vetX + r5 * Math.sin(theta), vetY + r5 * Math.cos(theta), vetX + r4 * Math.sin(theta),
                    vetY + r4 * Math.cos(theta));
        }
        double h = Math.toRadians(30 * horas);
        double m = Math.toRadians(6 * minutos);
        double s = Math.toRadians(6 * segundos);
        // 360 graus / 12 horas = 30 graus
        desenhaRelogio.line(vetX, vetY, vetX + r3 * Math.sin(h), vetY + r3 * Math.cos(h));
        // 360 graus / 60 minutos = 6 graus
        desenhaRelogio.setPenColor(Draw.BLUE);
        desenhaRelogio.line(vetX, vetY, vetX + r3 * 2 * Math.sin(m), vetY + r3 * 2 * Math.cos(m));
        desenhaRelogio.setPenColor(Draw.RED);
        desenhaRelogio.setPenRadius(0.0005);
        desenhaRelogio.line(vetX, vetY, vetX + r2 * 2 * Math.sin(s), vetY + r2 * 2 * Math.cos(s));

        // String horario = String.format("%02d:%02d:%02d", horas, minutos, segundos);
        desenhaRelogio.text(vetX + 10, vetY + 10, this.nomeFuso);
    }

    public boolean checkHora(int hora) {
        return (hora < 24 && hora >= 0);
    }

    // verifica se os minutos são maior/igual a zero e menor/igual 59
    public boolean checkMinutoSegundo(int minuto, int segundo) {
        return (minuto <= 59 && minuto >= 0 && segundo <= 59 && segundo >= 0);
    }

    // valida se o valor do fuso está correto, mas para fuso negativo
    public int aplicaFuso(int horas) {
        int delta = horas + this.fusoHorario;

        if (this.fusoHorario > 0) {
            if (horas == 23) {
                horas = 0 + this.fusoHorario;
            } else if (delta > 23) {
                horas = 0 + delta;
            }
        }
        if (this.fusoHorario < 0) {
            if (horas == 0) {
                horas = 24 + this.fusoHorario;
            } else if (delta < 0) {
                int x = Math.abs(delta);
                horas = 24 - x;
            }
        }
        if (delta >= 0 && delta <= 23) {
            horas = delta;
        }
        return horas;
    }
}
