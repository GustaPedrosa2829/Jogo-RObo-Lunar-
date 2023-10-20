import java.util.List;

public class Jogo {
    private Terreno terreno; // O terreno lunar
    private List<Equipe> equipes; // Lista de equipes
    private int duracaoJogo; // Tempo de duração do jogo em segundos
    private boolean jogoEmExecucao; // Indica se o jogo está em execução
    private RelatorioJogo relatorioJogo; // Relatório do jogo

    public Jogo(Terreno terreno, List<Equipe> equipes, int duracaoJogo) {
        this.terreno = terreno;
        this.equipes = equipes;
        this.duracaoJogo = duracaoJogo;
        this.jogoEmExecucao = false;
        this.relatorioJogo = new RelatorioJogo();
    }

    public void iniciarJogo() {
        jogoEmExecucao = true;

        // Distribua os robôs no terreno
        distribuirRobosNoTerreno();

        // Inicialize o tempo de jogo
        int tempoJogo = 0;

        // Loop principal do jogo
        while (jogoEmExecucao && tempoJogo < duracaoJogo) {
            // Atualize o estado do jogo a cada ciclo
            atualizarJogo();

            // Incrementar o tempo do jogo
            tempoJogo++;
        }

        // Encerre o jogo ao atingir o tempo limite
        encerrarJogo();
    }

    public void encerrarJogo() {
        jogoEmExecucao = false;

        // Determine o vencedor com base no critério (quantidade de Hélio-3 prospectado)
        Equipe equipeVencedora = determinarEquipeVencedora();

        // Exiba o resultado do jogo
        if (equipeVencedora != null) {
            System.out.println("Equipe vencedora: " + equipeVencedora.getNome());
        } else {
            System.out.println("O jogo terminou em empate.");
        }

        // Gere o relatório final
        gerarRelatorioJogo();
    }

    public void atualizarJogo() {
        // Atualize o tempo de jogo
        tempoJogo++;

        // Para cada equipe, permita que seus controladores enviem comandos para seus robôs
        for (Equipe equipe : equipes) {
            for (Robo robo : equipe.getRobos()) {
                Controlador controlador = robo.getControlador();

                // Verifique se o tempo de jogo não excedeu o limite
                if (tempoJogo < duracaoJogo) {
                    // Execute os comandos do controlador
                    controlador.executarComandos();
                }
            }
        }

        // Atualize o terreno, a concentração de Hélio-3, a rugosidade, etc.
        atualizarTerreno();

        // Verifique se o tempo de jogo atingiu o limite
        if (tempoJogo >= duracaoJogo) {
            encerrarJogo();
        }
    }
    public void executarJogo() {
        iniciarJogo();

        // Implemente um loop que execute o jogo enquanto jogoEmExecucao for verdadeiro
        while (jogoEmExecucao) {
            atualizarJogo();
        }

        encerrarJogo();
        gerarRelatorioJogo();
    }

    private void gerarRelatorioJogo() {
        // Crie uma instância de RelatorioJogo
        RelatorioJogo relatorio = new RelatorioJogo();

        // Colete as informações sobre a quantidade de Hélio-3 prospectado por equipe
        for (Equipe equipe : equipes) {
            double quantidadeHelioEquipe = 0.0;
            for (Robo robo : equipe.getRobos()) {
                quantidadeHelioEquipe += robo.getQuantidadeHelioProspec();
            }
            relatorio.adicionarInformacaoEquipe(equipe, quantidadeHelioEquipe);
        }

        // Colete as informações sobre a quantidade de Hélio-3 prospectado por robô
        for (Equipe equipe : equipes) {
            for (Robo robo : equipe.getRobos()) {
                relatorio.adicionarInformacaoRobo(robo, robo.getQuantidadeHelioProspec());
            }
        }

        // Exiba o relatório final
        System.out.println("Relatório Final do Jogo:");
        System.out.println(relatorio.gerarRelatorioFormatado());
    }