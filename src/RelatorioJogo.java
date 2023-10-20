import java.util.HashMap;
import java.util.Map;

public class RelatorioJogo {
    private Map<Equipe, Double> equipeHelioProspec; // Mapeia equipes para a quantidade de Hélio-3 prospectado
    private Map<Robo, Double> roboHelioProspec; // Mapeia robôs para a quantidade de Hélio-3 prospectado

    public RelatorioJogo() {
        equipeHelioProspec = new HashMap<>();
        roboHelioProspec = new HashMap<>();
    }

    public void adicionarHelioProspec(Equipe equipe, double quantidade) {
        equipeHelioProspec.put(equipe, equipeHelioProspec.getOrDefault(equipe, 0.0) + quantidade);
    }

    public void adicionarHelioProspec(Robo robo, double quantidade) {
        roboHelioProspec.put(robo, roboHelioProspec.getOrDefault(robo, 0.0) + quantidade);
    }

    public Map<Equipe, Double> getEquipeHelioProspec() {
        return equipeHelioProspec;
    }

    public Map<Robo, Double> getRoboHelioProspec() {
        return roboHelioProspec;
    }
}