public class Robo {
    private int x; // Posição x no terreno
    private int y; // Posição y no terreno
    public double helioProspec; // Quantidade de Hélio-3 prospectado
    private String nome; // Nome do robô
    private String direcao; // Direção do robô

    public Robo(String nome, int x, int y, String direcao) {
        this.nome = nome;
        this.x = x;
        this.y = y;
        this.direcao = direcao;
        this.helioProspec = 0.0;
    }

    public int getX() {
        return x;
    }

    public int getY() {
        return y;
    }

    public double getHelioProspec() {
        return helioProspec;
    }

    public String getNome() {
        return nome;
    }

    public String getDirecao() {
        return direcao;
    }

    public void mover() {
        int novoX = x;
        int novoY = y;

        // Atualize as coordenadas de acordo com a direção
        switch (direcao) {
            case NORTE:
                novoY++;
                break;
            case LESTE:
                novoX++;
                break;
            case SUL:
                novoY--;
                break;
            case OESTE:
                novoX--;
                break;
        }

        // Verifique se o novo movimento está dentro dos limites do terreno
        if (ePosicaoValida(novoX, novoY)) {
            x = novoX;
            y = novoY;
        } else {
            // Trate o caso em que o movimento não é válido (por exemplo, colisão com parede)
        }
    }

    public void virarEsquerda() {
        switch (direcao) {
            case NORTE:
                direcao = Direcao.OESTE;
                break;
            case LESTE:
                direcao = Direcao.NORTE;
                break;
            case SUL:
                direcao = Direcao.LESTE;
                break;
            case OESTE:
                direcao = Direcao.SUL;
                break;
        }
    }

    public void virarDireita() {
        switch (direcao) {
            case NORTE:
                direcao = Direcao.LESTE;
                break;
            case LESTE:
                direcao = Direcao.SUL;
                break;
            case SUL:
                direcao = Direcao.OESTE;
                break;
            case OESTE:
                direcao = Direcao.NORTE;
                break;
        }
    }

    private boolean ePosicaoValida(int novoX, int novoY) {
        // Verifique se as novas coordenadas estão dentro dos limites do terreno
        boolean dentroDosLimites = novoX >= 0 && novoX < Terreno.getLargura() && novoY >= 0 && novoY < terreno.getAltura();

        if (dentroDosLimites) {
            // Verifique se a célula no novo local é acessível (por exemplo, não é uma parede)
            CelulaTerreno novaCelula = Terreno.getCelula(novoX, novoY);
            boolean acessoPermitido = novaCelula != null && novaCelula.getAcessoPermitido();

            return acessoPermitido;
        } else {
            return false; // Fora dos limites do terreno
        }
    }