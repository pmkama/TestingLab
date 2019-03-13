package tp6305.papemamakamara_aminatandiaye.tp2;

import java.util.List;

public class Node {
    private List<Condition> conditions;
    private boolean isVisited = false;

    public Node(List<Condition> conditions) {
        this.conditions = conditions;
    }

    public List<Condition> getConditions() {
        return conditions;
    }

    public void setConditions(List<Condition> conditions) {
        this.conditions = conditions;
    }

    public boolean isVisited() {
        return isVisited;
    }

    public void setVisited(boolean visited) {
        isVisited = visited;
    }
}
