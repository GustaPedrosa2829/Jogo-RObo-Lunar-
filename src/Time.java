import java.util.ArrayList;
import java.util.List;

public class Equipe {
    private String nome; // Nome da equipe
    private List<Robo> robos; // Lista de robôs pertencentes à equipe

    public Equipe(String nome) {
        this.nome = nome;
        this.robos = new ArrayList<>();
    }

    public String getNome() {
        return nome;
    }

    public List<Robo> getRobos() {
        return robos;
    }

    public void adicionarRobo(Robo robo) {
        robos.add(robo);
    }

    public void removerRobo(Robo robo) {
        robos.remove(robo);
    }


}
