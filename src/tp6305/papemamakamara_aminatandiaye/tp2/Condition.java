package tp6305.papemamakamara_aminatandiaye.tp2;

public class Condition {
    private String operande_1;
    private String operande_2;
    private Operators operator;

    public Condition(String operande_1, String operande_2, Operators operator) {
        this.operande_1 = operande_1;
        this.operande_2 = operande_2;
        this.operator = operator;
    }

    public String getOperande_1() {
        return operande_1;
    }

    public void setOperande_1(String operande_1) {
        this.operande_1 = operande_1;
    }

    public String getOperande_2() {
        return operande_2;
    }

    public void setOperande_2(String operande_2) {
        this.operande_2 = operande_2;
    }

    public Operators getOperator() {
        return operator;
    }

    public void setOperator(Operators operator) {
        this.operator = operator;
    }
}