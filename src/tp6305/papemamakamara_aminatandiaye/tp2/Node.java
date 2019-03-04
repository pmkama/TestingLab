package tp6305.papemamakamara_aminatandiaye.tp2;

import java.util.List;

public class Node {
    private List<Condition> conditions;
    
    //If logicOperator==false, Operator==&&
    private Boolean logicOperator = false;
    
    public void setLogicOperator(Boolean logicOperator) {
    	this.logicOperator = logicOperator;
    }

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
