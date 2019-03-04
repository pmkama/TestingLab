package tp6305.papemamakamara_aminatandiaye.tp2;

public class FitnessFunction {

    private static float fitnessValue;
    private ControlFlowGraph cfg = new ControlFlowGraph();

    static float computeFitness(Condition condition){
        switch (condition.getOperator()){
            case OR:
                fitnessValue = ;
                break;
            case AND:
                break;
            case DIFFERENT:
                break;
            case SUPERIEUR:
                break;
            case INFERIEUR:
                break;
            case EGALE:
                break;

        }
    }

    public static float getFitnessValue() {
        return fitnessValue;
    }

    public ControlFlowGraph getCfg() {
        return cfg;
    }
}
