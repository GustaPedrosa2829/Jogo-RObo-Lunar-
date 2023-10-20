public class CelulaTerreno {
    private double concentracaoHelio;
    private double coeficienteErroMin;
    private double coeficienteErroMax;
    private double rugosidade;

    public CelulaTerreno(double concentracaoHelio, double coeficienteErroMin, double coeficienteErroMax, double rugosidade) {
        this.concentracaoHelio = concentracaoHelio;
        this.coeficienteErroMin = coeficienteErroMin;
        this.coeficienteErroMax = coeficienteErroMax;
        this.rugosidade = rugosidade;
    }

    public double getConcentracaoHelio() {
        return concentracaoHelio;
    }

    public double getCoeficienteErroMin() {
        return coeficienteErroMin;
    }

    public double getCoeficienteErroMax() {
        return coeficienteErroMax;
    }

    public double getRugosidade() {
        return rugosidade;
    }



    @Override
    public String toString() {
        return "CelulaTerreno{" +
                "concentracaoHelio=" + concentracaoHelio +
                ", coeficienteErroMin=" + coeficienteErroMin +
                ", coeficienteErroMax=" + coeficienteErroMax +
                ", rugosidade=" + rugosidade +
                '}';
    }
}