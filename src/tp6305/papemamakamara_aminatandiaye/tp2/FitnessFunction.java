package tp6305.papemamakamara_aminatandiaye.tp2;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class FitnessFunction {

    public static final int K_VALUE = 1;
    private static final int UNIQUE_CONDITION = 0;
    private static int fitnessValue;

    public FitnessFunction() {}


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
            System.out.println("Condition 1" + conditions + " Fitness 1: " + fitness);
            fitness = getFitness(readjustTestData(conditions, fitness));
            System.out.println("Condition 2" + conditions + " Fitness 2: " + fitness);
        }


        return fitness;
    }


    public static int computeUniqueFitness(Condition condition) {

        int op1 = condition.getOperande_1();
        int op2 = condition.getOperande_2();

        switch (condition.getOperator()) {
            case EGALE:
                if (op1 == op2) fitnessValue = 0;
                else fitnessValue = Math.abs(condition.getOperande_1() - condition.getOperande_2());
                return fitnessValue;

            case DIFFERENT:
                if (op1 != op2) fitnessValue = 0;
                else fitnessValue = K_VALUE;
                return fitnessValue;

            case SUPERIEUR:
                if (op1 > op2) fitnessValue = 0;
                else fitnessValue = (condition.getOperande_2() - condition.getOperande_1()) + K_VALUE;
                return fitnessValue;

            case INFERIEUR:
                if (op1 < op2) fitnessValue = 0;
                else fitnessValue = (condition.getOperande_1() - condition.getOperande_2()) + K_VALUE;
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

        Condition newCondition = condition;
        newCondition.setOperande_1(condition.getOperande_1() + fitness);

        return newCondition;
    }
}

