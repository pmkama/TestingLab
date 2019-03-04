package tp6305.papemamakamara_aminatandiaye.tp2;

public class FitnessFunction {

    private float fitnessValue;
    private ControlFlowGraph cfg = new ControlFlowGraph();

    public static float computeFitness(Condition condition) {

        float fitness = 0;
        int K_value = 1;
        switch (condition.getOperator()) {
            case EGALE:
                fitness = Math.abs(condition.getOperande_1() - condition.getOperande_2());
                return fitness;
            case DIFFERENT:
                fitness = K_value;
                return fitness;
            case SUPERIEUR:
                fitness = (condition.getOperande_2() - condition.getOperande_1()) + K_value;
            case INFERIEUR:
                fitness = (condition.getOperande_1() - condition.getOperande_2()) + K_value;
                return fitness;
            default:
                break;
        }
        return fitness;
    }

    public float getFitnessValue() {
        return fitnessValue;
    }

    public ControlFlowGraph getCfg() {
        return cfg;
    }
}
