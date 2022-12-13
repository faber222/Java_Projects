public class PrimeiraQuestão {
    public static void main(String[] args) {
        if (args.length > 0 && args.length == 7) {
            double[] notas = new double[7];
            double mediaPonderada = 0;
            double mediaGeometrica = 0;
            double conceitoFinal = 0;
            int[] wi = new int[2];
            wi[0] = 2;
            wi[1] = 4;
            for (int i = 0; i < 7; i++) {
                notas[i] = Double.parseDouble(args[i]);
            }
            for (int i = 0; i < wi.length; i++) {
                mediaPonderada += (notas[i] * wi[i]);
            }
            mediaPonderada = (mediaPonderada / (wi[0] + wi[1])) * 0.9;

            mediaGeometrica = Math.exp((Math.log(notas[2] * notas[3] * notas[4] * notas[5] * notas[6])) / 5) * 0.1;

            conceitoFinal = mediaGeometrica + mediaPonderada;

            conceitoFinal *= 10;
            int mediaArredondada = (int) conceitoFinal / 10;

            int x = (int) (conceitoFinal % 10);
            if (x >= 5) {
                mediaArredondada++;
            }

            if (mediaArredondada >= 6) {
                System.out.println(mediaArredondada + " :APROVADO");
            } else {
                System.out.println(mediaArredondada + " :REPROVADO");
            }
        } else {
            System.err.println("Necessário passar as notas: P1 P2 A1 A2 A3 A4 A5");
        }
    }
}
