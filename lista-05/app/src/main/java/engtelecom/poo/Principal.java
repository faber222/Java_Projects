package engtelecom.poo;

import java.util.ArrayList;

public class Principal {
    public static void main(String[] args) {
        Ferrari ferrari = new Ferrari("Ferrari Spider");
        Pampa pampa = new Pampa("Pampa S");
        Panther panther = new Panther("Panther anfibio");

        if (ferrari.ligarFarolNeblina()) {
            System.out.println("\nLigando farol de neblina da " + ferrari.getNome());
        } else {
            System.out.println("\nFarol de neblina da " + ferrari.getNome() + " ja esta ligado");
        }

        if (pampa.abrirCacamba()) {
            System.out.println("\nAbrindo cacamba da " + pampa.getNome());
        } else {
            System.out.println("\nCacamba da " + pampa.getNome() + " ja esta aberta");
        }

        if (panther.abrirRodas()) {
            System.out.println("\nAbrindo rodas do " + panther.getNome());
        } else {
            System.out.println("\n" + panther.getNome() + " ja esta com as rodas abertas");
        }

        if (panther.recolherRodas()) {
            System.out.println("\nRecolhendo rodas e esvaziando lastro do " + panther.getNome());
        } else {
            System.out.println("\nNão foi possivel recolher as rodas do " + panther.getNome());
        }

        if (panther.esvaziarLastro()) {
            System.out.println("\nEsvaziando lastro do " + panther.getNome());
        } else {
            System.out.println("\nLastro ja esta vazio");
        }

        panther.setTempRefri(10);
        System.out.println("\nColocando temperatura em " + panther.getTemperatura());

        ArrayList<VeiculoTerrestre> carros = new ArrayList<>();
        carros.add(ferrari);
        carros.add(panther);
        carros.add(pampa);

        ArrayList<Conversivel> carros3 = new ArrayList<>();
        carros3.add(panther);
        carros3.add(ferrari);

        ArrayList<TracaoIntegral> carros4 = new ArrayList<>();
        carros4.add(panther);
        carros4.add(pampa);

        // usando polimorfismo para chamar o método acelerar e frear de cada classe
        // sendo Ferrari, Panther e Pampa
        // pois todos os 3 representam um veiculo terrestre que pode acelerar e freiar
        for (VeiculoTerrestre car : carros) {
            car.acelerar(10);
            System.out.println("\nAcelerando o carro: " + car.getNome() + " em " + car.getVelocidadeAtual() + "km/h");
            car.frear(5);
            System.out.println("\nFreando o carro: " + car.getNome() + " em " + car.getVelocidadeAtual() + "km/h");
        }

        // usando polimorfismo para chamar o método abrirCapota e fecharCapota de cada
        // classe
        // sendo Ferrari e Panther
        // pois todos os 2 representam um veiculo conversivel que pode abrir ou fechar a
        // capota
        for (Conversivel car : carros3) {
            if (car.abrirCapota()) {
                System.out.println("\nAbrindo capota " + car.getNome());
            } else {
                System.out.println("\nCapota ja esta aberta " + car.getNome());
            }

            if (car.fecharCapota()) {
                System.out.println("\nFechando capota " + car.getNome());
            } else {
                System.out.println("\nCapota ja esta fechada " + car.getNome());
            }
        }

        // usando polimorfismo para chamar o método ativarDesativarTracao de cada classe
        // sendo Pampa e Panther
        // pois todos os 2 representam um veiculo tracionado que pode ativar ou
        // desativar a
        // tracao
        for (TracaoIntegral car : carros4) {
            if (car.ativarDesativarTracao()) {
                if (car.isTracaoAtiva()) {
                    System.out.println("\nAtivando tracao " + car.getNome());
                } else {
                    System.out.println("\nDesativando tracao " + car.getNome());
                }
            } else {
                System.out.println("\nNão foi possivel ativar ou desativar a tracao " + car.getNome());
            }

            if (car.ativarDesativarTracao()) {
                if (car.isTracaoAtiva()) {
                    System.out.println("\nAtivando tracao " + car.getNome());
                } else {
                    System.out.println("\nDesativando tracao " + car.getNome());
                }
            } else {
                System.out.println("\nNão foi possivel ativar ou desativar a tracao " + car.getNome());
            }

        }
    }
}
