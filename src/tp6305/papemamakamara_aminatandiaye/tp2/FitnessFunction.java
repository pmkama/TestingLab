package tp6305.papemamakamara_aminatandiaye.tp2;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class FitnessFunction {

    public static final int K_VALUE = 1;
    private static final int UNIQUE_CONDITION = 0;
    private static final int DATA_SET_LENGTH = 3;
    private static int fitnessValue = 0;
    private static ControlFlowGraph cfg;
    private float[] testData;

    public FitnessFunction() {
        testData = new float[DATA_SET_LENGTH];
        cfg = new ControlFlowGraph();
    }


    /*public static Map<Integer, Integer> fitnessEvaluationResult() {

        List<Path> paths = FitnessFunction.cfg.getPaths();
        Map<Integer, Integer> results = new HashMap<>();

        for (Path path : paths) {

            int nbNodeVisited = 0;

            for (Node node : path.getNodes()) {

                List<Condition> conditions = node.getConditions();

                if (getFitness(conditions) == 0) { // condition is True
                    break;
                } else {
                    readjustTestData(conditions);
                    getFitness(conditions);
                }

                node.setVisited(true);

            }

            //When we are done evaluating fitness for all nodes of a given path
            //We count the number of visited nodes
            for (Node node : path.getNodes()) {
                if (node.isVisited())
                    nbNodeVisited++;
            }
            results.put(path.getPathID(), nbNodeVisited);
        }

        return results;
    }*/

    public static int getFitness(List<Condition> conditions) {

        int fitness;
        int count = 0;

        if (conditions.size() == 1) {
            fitness = computeUniqueFitness(conditions.get(UNIQUE_CONDITION));
        } else {
            fitness = getMinFitnessValue(conditions);
        }

        if (fitness == 0) {
            return fitness;
        } else {
            count++;
            readjustTestData(conditions, fitness);
            fitness = getFitness(conditions);
            System.out.println("Condition " + conditions + " Fitness : " + fitness + " -   Iteration : " + count);
        }

        System.out.println("Final Iteration : " + count);
        return fitness;
    }


    public static int computeUniqueFitness(Condition condition) {

        int op1 = condition.getOperande_1();
        int op2 = condition.getOperande_2();
        int K_value = 1;

        switch (condition.getOperator()) {
            case EGALE:
                if (op1 == op2) fitnessValue = 0;
                else fitnessValue = Math.abs(condition.getOperande_1() - condition.getOperande_2());
                return fitnessValue;

            case DIFFERENT:
                if (op1 != op2) fitnessValue = 0;
                else fitnessValue = K_value;
                return fitnessValue;

            case SUPERIEUR:
                if (op1 > op2) fitnessValue = 0;
                else fitnessValue = (condition.getOperande_2() - condition.getOperande_1()) + K_value;
                return fitnessValue;

            case INFERIEUR:
                if (op1 < op2) fitnessValue = 0;
                else fitnessValue = (condition.getOperande_1() - condition.getOperande_2()) + K_value;
                return fitnessValue;

            default:
                break;
        }
        return fitnessValue;
    }

    private static int getMinFitnessValue(List<Condition> conditions) {

        List<Integer> fitnessValues = new ArrayList<>();
        for (Condition condition : conditions) {
            fitnessValues.add(FitnessFunction.computeUniqueFitness(condition));
        }
        Collections.sort(fitnessValues,  (o1, o2) -> o1 - o2);
        return Collections.min(fitnessValues);
    }


    public static List<Condition> readjustTestData(List<Condition> conditions, int fitness) {

        List<Condition> newData = new ArrayList<>();

        if (conditions.size() == 1) {
            newData.add(readjustUniqueCondition(conditions.get(UNIQUE_CONDITION), fitness));
        } else {

            newData = readjustMultipleConditions(conditions, fitness);

        }
        return newData;
    }

    private static List<Condition> readjustMultipleConditions(List<Condition> conditions, int fitness) {

        List<Condition> newConditions = new ArrayList<>();

        for (Condition condition : conditions) {
            newConditions.add(readjustUniqueCondition(condition, fitness));
        }

        return newConditions;
    }

    private static Condition readjustUniqueCondition(Condition condition, int fitness) {

        condition.setOperande_1(condition.getOperande_1() + fitness);

        return condition;
    }
}

