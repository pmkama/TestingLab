package tp6305.papemamakamara_aminatandiaye.tp2;

public class FitnessFunction {

    private static float fitnessValue = 0;
    private ControlFlowGraph cfg = new ControlFlowGraph();

    public static float computeFitness(Condition condition) {

        int K_value = 1;
        switch (condition.getOperator()) {
            case EGALE:
                fitnessValue = Math.abs(condition.getOperande_1() - condition.getOperande_2());
                return fitnessValue;
            case DIFFERENT:
                fitnessValue = K_value;
                return fitnessValue;
            case SUPERIEUR:
                fitnessValue = (condition.getOperande_2() - condition.getOperande_1()) + K_value;
                return fitnessValue;
            case INFERIEUR:
                fitnessValue = (condition.getOperande_1() - condition.getOperande_2()) + K_value;
                return fitnessValue;
            default:
                break;
        }
        return fitnessValue;
    }

    public ControlFlowGraph getCfg() {
        return cfg;
    }
}
