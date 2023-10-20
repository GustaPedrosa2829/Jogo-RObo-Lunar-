public class Controlador {
    private Robo robo; // O robô que o controlador está controlando

    public Controlador(Robo robo) {
        this.robo = robo;
    }

    public void sentirPosicao() {
        int posicaoX = robo.getX();
        int posicaoY = robo.getY();
        System.out.println("Posição atual do robô: x=" + posicaoX + ", y=" + posicaoY);
    }
    public void sentirConcentracaoHelio() {
        int posicaoX = robo.getX();
        int posicaoY = robo.getY();

        // Obtenha a célula do terreno na posição atual do robô
        CelulaTerreno celulaAtual = Terreno.getCelula(posicaoX, posicaoY);

        if (celulaAtual != null) {
            double concentracaoHelio = celulaAtual.getConcentracaoHelio();
            System.out.println("Concentração de Hélio-3 na posição atual: " + concentracaoHelio);
        } else {
            System.out.println("Não foi possível obter a concentração de Hélio-3 na posição atual. A célula não foi encontrada.");
        }
    }

    public void sentirRugosidade() {
        int posicaoX = robo.getX();
        int posicaoY = robo.getY();

        // Obtenha a célula do terreno na posição atual do robô

        CelulaTerreno celulaAtual = Terreno.getCelula(posicaoX, posicaoY);

        if (celulaAtual != null) {
            double rugosidade = celulaAtual.getRugosidade();
            System.out.println(
                    System.out
                    "Rugosidade do terreno na posição atual: " + rugosidade);
        } else {
            System.out.println("Não foi possível obter a rugosidade do terreno na posição atual. A célula não foi encontrada.");
        }
    }

    public void prospectar() {
        int posicaoX = robo.getX();
        int posicaoY = robo.getY();

        // Obtenha a célula do terreno na posição atual do robô
        CelulaTerreno celulaAtual = Terreno.getCelula(posicaoX, posicaoY);

        if (celulaAtual != null) {
            double concentracaoHelio = celulaAtual.getConcentracaoHelio();
            double quantidadeProspectada = concentracaoHelio; // A quantidade prospectada é diretamente proporcional à concentração

            // Atualize a quantidade de Hélio-3 prospectado pelo robô
            robo.setHelioProspec(robo.getHelioProspec() + quantidadeProspectada);
            System.out.println("Prospecção concluída. Quantidade de Hélio-3 prospectado: " + quantidadeProspectada);
        } else {
            System.out.println("Não foi possível iniciar a prospecção. A célula não foi encontrada.");
        }
    }