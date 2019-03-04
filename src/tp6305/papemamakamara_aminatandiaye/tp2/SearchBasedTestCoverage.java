package tp6305.papemamakamara_aminatandiaye.tp2;

import tp6305.CoverageTest;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.Random;

public class SearchBasedTestCoverage extends CoverageTest {

    public static int SIDE_MAX_NUMBER = 3;
    public static int K_value  = 1;
    float[] initialTestData;
    ControlFlowGraph cfg;


    public SearchBasedTestCoverage() {
        cfg = new ControlFlowGraph();
        this.initialTestData = cfg.randomlyInitializeTestData(new StringBuilder(), new float[SIDE_MAX_NUMBER]);
    }


    @Override
    protected void generateTestData(StringBuilder builder, float[] testData) {

        //TODO : test data generation based on SBST
        //Initialize test data
        new SearchBasedTestCoverage();
        this.cfg.getPaths().stream()
                .forEach(path -> {
                    path.getNodes().stream().forEach(node -> {
                        List<Condition> conditions = node.getConditions();
                        if (conditions.size() == 1) {
                            Condition condition = conditions.get(0);
                            float fitnessValue = evaluateFitnessValue(condition.getOperande_1(),
                                    condition.getOperande_2(),
                                    condition.getOperator());
                        } else {
                            conditions.stream().forEach(condition -> {
                                List<Float> fitnessValues = new ArrayList<>();
                                fitnessValues.add(evaluateFitnessValue(condition.getOperande_1(),
                                        condition.getOperande_2(),
                                        condition.getOperator()));
                                Optional<Float> fitnessValue = fitnessValues.stream()
                                        .min((a,b) -> (int) (a-b));
                            });
                        }
                    });
                });
    }

    private float evaluateFitnessValue(float operande_1, float operande_2, Operators operator) {

        float fitness = 0;

        switch (operator){
            case EGALE:
                fitness = Math.abs(operande_1 - operande_2);
                return fitness;
            case DIFFERENT:
                fitness = K_value;
                return fitness;
            case SUPERIEUR:
                fitness = (operande_2 - operande_1) + K_value;
            case INFERIEUR:
                fitness = (operande_1 - operande_2) + K_value;
                return fitness;
            default:
                break;
        }
        return fitness;
    }

    /**
     * Initialize the triangle's sides
     *
     * @param builder
     * @param initialTestData
     */
    public float[] randomlyInitializeTestData(StringBuilder builder, float[] initialTestData) {
        final int MAX_NUMBER_OF_DATA = 3;
        final int MIN_VALUE = -10;
        final int MAX_VALUE = 20;
        Random random = new Random();
        for (int i = 0; i < MAX_NUMBER_OF_DATA; i++) {
            initialTestData[i] = MIN_VALUE + random.nextInt(MAX_VALUE - MIN_VALUE);
            builder.append(initialTestData[i]).append(", ");
        }
        return initialTestData;
    }


    public StringBuilder readjustTestData(StringBuilder builder) {
        StringBuilder newBuilder = new StringBuilder();

        // TODO: reorganize test data

        return newBuilder;
    }

    @Override
    protected double computeBranchCoverage(List<String> outputs, String testData) {
        return 0;
    }


}
