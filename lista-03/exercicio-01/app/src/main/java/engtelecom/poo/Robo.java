package engtelecom.poo;

import java.util.ArrayList;
import java.util.Random;

/**
 * Classe Robo, robô de exploração espacial
 */
public class Robo {
    private static final int MAX = 100; // valor maximo de movimentos
    private static final int MIN = 0; // valor minimo de movimentos
    private static final int MIN_FIXO = 0; // inteiro para representar o zero

    private String id; // hash de identificação do robo
    private String orientacao; // Norte, Sul, Leste, Oeste
    private int tamanhoArea; // tamanho em m² do local
    private int coordenadaX; // coordenada inicial em x
    private int coordenadaY; // coordenada inicial em y
    private int movimentos; // numero de movimentos restantes
    private int unidadesPorTurno; // maximo de movimentos por turno

    private ArrayList<String> plano; // plano de exploração do robo
    private int coordenadaXAnterior; // coordenada anterior em x
    private int coordenadaYAnterior; // coordenada anterior em y

    /**
     * Ao instanciar um objeto dessa classe, deve-se indicar o identificador único
     * do robô (uma cadeia de caracteres), o tamanho da área a ser explorada
     * (obrigatoriamente um quadrado, ou seja m²), a coordenada inicial (x,y) do
     * robô dentro desta área, para onde está apontando sua frente (Norte, Sul,
     * Leste ou Oeste), a quantidade de movimentos que poderá fazer antes de acabar
     * sua bateria e um inteiro para representar quantas unidades irá
     * caminhar quando for solicitado que se movimente.
     * 
     * @param id               String de identificação do robo
     * @param orientacao       String para representar posicao
     * @param tamanhoArea      inteiro para representar o quadrado, deve-se
     *                         pensar em m²
     * @param coordenadaX      Inteiro para representar coordenada inicial x
     * @param coordenadaY      Inteiro para representar coordenada inicial y
     * @param movimentos       Inteiro para representar a quantidade de
     *                         movimentos restantes
     * @param unidadesPorTurno Inteiro para representar a quantidade maxima de
     *                         unidades por turno
     */
    public Robo(String id, int tamanhoArea, int coordenadaX, int coordenadaY, String orientacao,
            int movimentos, int unidadesPorTurno) {
        this.id = id;
        this.movimentos = verificaMovimentos(movimentos);

        if (tamanhoArea >= MIN) {
            this.tamanhoArea = tamanhoArea;
        } else {
            this.tamanhoArea = MAX;
        }

        if (verificaOrientacao(orientacao)) {
            this.orientacao = orientacao;
        } else {
            this.orientacao = "Norte";
        }

        if (verificaCoordenada(coordenadaX, coordenadaY)) {
            this.coordenadaX = coordenadaX;
            this.coordenadaY = coordenadaY;
        } else {
            this.orientacao = "Norte";
            Random r = new Random(this.tamanhoArea++);
            Random r2 = new Random(this.tamanhoArea++);
            this.coordenadaX = r.nextInt();
            this.coordenadaY = r2.nextInt();
        }

        if (verificaTurnos(unidadesPorTurno)) {
            this.unidadesPorTurno = unidadesPorTurno;
        } else {
            this.unidadesPorTurno = MAX;
        }
    }

    /**
     * Retorna o numero de movimentos que o robo pode executar
     * 
     * @param movimentos Integer para representar os movimentos do robo
     * @return retorna MAX caso o numero de movimentos seja maior que 100, retorna
     *         MIN caso seja repassado um numero menor/igual à 0 e caso seja
     *         informado um numero entre MIN e MAX, retorna o numero repassado
     */
    public int verificaMovimentos(int movimentos) {
        if (movimentos > MIN && movimentos <= MAX) {
            return movimentos;
        }
        if (movimentos > MAX) {
            return MAX;
        }
        return MIN;
    }

    /**
     * retorna o numero de movimentos ainda restantes
     * 
     * @return the movimentos
     */
    public int getMovimentos() {
        return movimentos;
    }

    /**
     * Retorna os comandos não processados
     * 
     * @return String contendo todos os dados presentes no plano de exploração
     */
    public String planoRestante() {
        String planosRestantes = "";
        for (String comandos : this.plano) {
            planosRestantes += comandos;
        }
        return planosRestantes;
    }

    /**
     * Função de verificação de strings passadas no construtor da função
     * 
     * @param orientacao String podendo ser "Sul, Norte, Leste, Oeste"
     * @return
     *         True caso a String corresponda a um nome valido,
     *         False caso a String passada seja invalida
     */
    public boolean verificaOrientacao(String orientacao) {
        return (orientacao == "Norte" || orientacao == "Sul" || orientacao == "Leste" || orientacao == "Oeste");
    }

    /**
     * Verifica se os valores repassados para posição (x,y) do robo, estão dentro da
     * área de exploração
     * 
     * @param coordenadaX Integer Valor inicial do robo na coordenada X
     * @param coordenadaY Integer Valor inicial do robo na coordenada Y
     * @return True caso a área de X e Y estejam dentro da area de exploração, ou
     *         seja, entre MIN até o valor maximo da area de exploração, e caso os
     *         valores sejam invalidos, retorna False
     */
    public boolean verificaCoordenada(int coordenadaX, int coordenadaY) {
        if (coordenadaX <= this.tamanhoArea && coordenadaY <= this.tamanhoArea && coordenadaX >= MIN
                && coordenadaY >= MIN) {
            return true;
        }
        return false;
    }

    /**
     * Verifica se as unidades que o robo vai executar, estão dentre os valores MAX
     * e MIN
     * 
     * @param unidadesPorTurno Integer para representar o numero de unidades que o
     *                         robo vai se movimentar por turno
     * @return True caso o inteiro estiver entre MIN e MAX e caso não esteja, vai
     *         retornar False
     */
    public boolean verificaTurnos(int unidadesPorTurno) {
        if (unidadesPorTurno <= MAX && unidadesPorTurno > MIN) {
            return true;
        }
        return false;
    }

    /**
     * Retorna qual as coordenadas do robo e sua orientação no mapa.
     * Podendo ser Norte, Sul, Leste ou Oeste
     * 
     * @return String contendo (x,y,orientacao)
     */
    public String getCoordenadaOrientacao() {
        return "coordenadaX=" + coordenadaX + ", coordenadaY=" + coordenadaY + ", " + orientacao + "";
    }

    /**
     * Retorna qual era a posicação anterior do robo no mapa.
     * Caso ele nao tenha se movimentado, retorna a posição atual
     * 
     * @return String contendo (x,y)
     */
    public String coordenadaAnterior() {
        if (this.coordenadaX != this.coordenadaXAnterior && this.coordenadaY != this.coordenadaYAnterior) {
            return "coordenadaX=" + coordenadaXAnterior + ", coordenadaY=" + coordenadaYAnterior + "";
        } else if (this.coordenadaX != this.coordenadaXAnterior && this.coordenadaY == this.coordenadaYAnterior) {
            return "coordenadaX=" + coordenadaXAnterior + ", coordenadaY=" + this.coordenadaY + "";
        } else if (this.coordenadaX == this.coordenadaXAnterior && this.coordenadaY != this.coordenadaYAnterior) {
            return "coordenadaX=" + coordenadaX + ", coordenadaY=" + this.coordenadaYAnterior + "";
        }
        return "coordenadaX=" + coordenadaX + ", coordenadaY=" + this.coordenadaY + "";
    }

    /**
     * Faz o robo executar um movimento de rotação em seu próprio eixo.
     * Aceitando os parametros D e E.
     * D = Direita.
     * E = Esquerda.
     * Caso o numero de movimentos do robo seja zero, retorna a orientação atual do
     * robo e não altera a posicação do mesmo
     * 
     * @param comando String que representa os comandos, sendo aceito E e D.
     * @return String contendo a nova orientação do robo
     */
    public String girarRobo(String comando) {
        if (this.movimentos == MIN_FIXO) {
            return this.orientacao;
        }
        this.movimentos--;
        switch (comando) {
            case "D":
                switch (this.orientacao) {
                    case "Norte":
                        this.orientacao = "Leste";
                        break;
                    case "Sul":
                        this.orientacao = "Oeste";
                        break;
                    case "Leste":
                        this.orientacao = "Sul";
                        break;
                    case "Oeste":
                        this.orientacao = "Norte";
                        break;
                }
                break;
            case "E":
                switch (this.orientacao) {
                    case "Norte":
                        this.orientacao = "Oeste";
                        break;
                    case "Sul":
                        this.orientacao = "Leste";
                        break;
                    case "Leste":
                        this.orientacao = "Norte";
                        break;
                    case "Oeste":
                        this.orientacao = "Sul";
                        break;
                }
                break;
        }

        return this.orientacao;
    }

    /**
     * Move o robo na direção que o mesmo está apontado, e caso o movimento que ele
     * vá executar, ultrapasse o limite do mapa, não executa o comando.
     * A cada chamada, decrementa um movimento do robo.
     * Caso chegue a zero, retorna falso
     * 
     * @return True caso o movimento do robo esteja dentro do limite permitido,
     *         False caso não seja possivel movimentar o robo
     */
    public boolean moverRobo() {
        if (this.movimentos == MIN_FIXO) {
            return false;
        }
        this.movimentos--;
        this.coordenadaXAnterior = this.coordenadaX;
        this.coordenadaYAnterior = this.coordenadaY;
        switch (this.orientacao) {
            case "Norte":
                if (!(this.coordenadaY + this.unidadesPorTurno > this.tamanhoArea)) {
                    this.coordenadaY += this.unidadesPorTurno;
                } else {
                    return false;
                }
                break;
            case "Sul":
                if (!(this.coordenadaY - this.unidadesPorTurno > MIN)) {
                    this.coordenadaY += this.unidadesPorTurno;
                } else {
                    return false;
                }
                break;
            case "Leste":
                if (!(this.coordenadaX + this.unidadesPorTurno > this.tamanhoArea)) {
                    this.coordenadaX += this.unidadesPorTurno;
                } else {
                    return false;
                }
                break;
            case "Oeste":
                if (!(this.coordenadaX - this.unidadesPorTurno > MIN)) {
                    this.coordenadaX += this.unidadesPorTurno;
                } else {
                    return false;
                }
                break;
        }
        return true;
    }

    /**
     * Carrega o plano de exploração do robo.
     * Apenas aceito os seguintes argumentos.
     * E para o robô girar no próprio eixo para esquerda.
     * D para o robô girar no próprio eixo para direita.
     * M para o robô mover X unidades para onde está apontando sua frente.
     * 
     * @param planoRobo String para plano de exploração
     * @return True caso seja possivel adicionar o plano, False caso contenha algum
     *         comando não permitido
     */
    public boolean carregaPlanos(String planoRobo) {
        String vetorLocal[] = planoRobo.split("");
        ArrayList<String> testeVetor = new ArrayList<>();
        for (String string : vetorLocal) {
            testeVetor.add(string);
        }
        for (String letras : testeVetor) {
            switch (letras) {
                case "M":
                    break;
                case "E":
                    break;
                case "D":
                    break;
                default:
                    return false;
            }
        }
        this.plano = testeVetor;
        return true;
    }

    /**
     * Executa o próximo comando do plano de operações
     * 
     * @return True caso ainda tenha comandos a serem executados ou false para caso
     *         tenha acabado.
     *         Retorna false caso não haja mais movimentos disponiveis
     */
    public boolean executaPlano() {
        if (this.plano.size() == MIN_FIXO) {
            return false;
        }
        String letra = this.plano.get(MIN_FIXO);
        this.plano.remove(MIN_FIXO);

        switch (letra) {
            case "M":
                moverRobo();
                break;
            case "D":
                girarRobo(letra);
                break;
            case "E":
                girarRobo(letra);
                break;
        }
        return true;
    }

}
