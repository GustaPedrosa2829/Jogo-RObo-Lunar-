public class Terreno {
    private CelulaTerreno[][] celulas;

    public Terreno(int largura, int altura) {
        celulas = new CelulaTerreno[largura][altura];
    }

    public CelulaTerreno getCelula(int x, int y) {
        if (ePosicaoValida(x, y)) {
            return celulas[x][y];
        } else {
            // Trate erros ou retorne uma célula padrão
            return null;
        }
    }

    public void setCelula(int x, int y, CelulaTerreno celula) {
        if (ePosicaoValida(x, y)) {
            celulas[x][y] = celula;
        } else {
            // Trate erros
        }
    }

    private boolean ePosicaoValida(int x, int y) {
        return x >= 0 && x < celulas.length && y >= 0 && y < celulas[0].length;
    }
}