package tp6305.papemamakamara_aminatandiaye.tp2;

import java.util.List;

public class Node {
    private List<Condition> conditions;

    public Node(List<Condition> conditions) {
        this.conditions = conditions;
    }

    public List<Condition> getConditions() {
        return conditions;
    }

    public void setConditions(List<Condition> conditions) {
        this.conditions = conditions;
    }

}
