package tp6305.papemamakamara_aminatandiaye.tp2;

public class Condition {
    private int operande_1;
    private int operande_2;
    private Operators operator;

    public Condition(int operande_1, int operande_2, Operators operator) {
        this.operande_1 = operande_1;
        this.operande_2 = operande_2;
        this.operator = operator;
    }

    public int getOperande_1() {
        return operande_1;
    }

    public void setOperande_1(int operande_1) {
        this.operande_1 = operande_1;
    }

    public int getOperande_2() {
        return operande_2;
    }

    public void setOperande_2(int operande_2) {
        this.operande_2 = operande_2;
    }

    public Operators getOperator() {
        return operator;
    }

    public void setOperator(Operators operator) {
        this.operator = operator;
    }

    @Override
    public String toString() {
        return "Condition{" +
                "operande_1=" + operande_1 +
                ", operande_2=" + operande_2 +
                ", operator=" + operator +
                '}';
    }
}
