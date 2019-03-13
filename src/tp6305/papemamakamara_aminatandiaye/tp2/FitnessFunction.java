package tp6305.papemamakamara_aminatandiaye.tp2;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class FitnessFunction {

    public static final int K_VALUE = 1;
    private static final int UNIQUE_CONDITION = 0;
    private static int fitnessValue;
    private static int count = 0;

    public FitnessFunction() {}

    /**
     * Calcul le fitness pour les conditions données en entrée
     * Les conditions sont celles des noeuds de chaque chemins
     * @param conditions
     * @return fitnessValue
     */

    public static int getFitness(List<Condition> conditions) {

        int fitness;

        System.out.println("Classe FitnessFunction : Conditions du noeud courant : " + conditions);

        if (conditions.size() == 1) { //Noeud avec une seule condition
            fitness = computeUniqueFitness(conditions.get(UNIQUE_CONDITION));
        } else { //Noeud avec plusieurs conditions
            fitness = getMinFitnessValue(conditions);
        }

        if (fitness == 0) {
        	return fitness;
        }else {
            count++;
            System.out.println("Classe FitnessFunction : Nb reajustements des données : #" + count);
            fitness = getFitness(readjustTestData(conditions, fitness));
        }

        return fitness;
    }

    /**
     * Calcule le fitness des differentes conditions et retourne le min car on a que des OR (||) dans le code.
     * @param conditions
     * @return computedFitnesses
     */
    private static int getMinFitnessValue(List<Condition> conditions) {

        List<Integer> fitnessValues = new ArrayList<>();
        for (Condition condition : conditions) {
            //Chaque condition est passee a computeUniqueFitness()
            //Chaque condition a donc sa propre valeur de fitness
            // et choisit alors le minimum des fitness
            fitnessValues.add(FitnessFunction.computeUniqueFitness(condition));
        }
        Collections.sort(fitnessValues,  (o1, o2) -> o1 - o2); // Tri les valeurs par ordre croissant
        return Collections.min(fitnessValues); // return le min
    }

    /**
     * Calcul le fitness de la condition donnée en argument selon le tableau du cours
     * @param condition
     * @return computedFitness
     */

    public static int computeUniqueFitness(Condition condition) {

        int op1 = condition.getOperande_1();
        int op2 = condition.getOperande_2();

        switch (condition.getOperator()) {
            case EGALE: // F = |a-b|
                if (op1 == op2)
                    fitnessValue = 0;
                else
                    fitnessValue = Math.abs(op1 - op2);

                return fitnessValue;

            case DIFFERENT: // F = K
                if (op1 != op2)
                    fitnessValue = 0;
                else
                    fitnessValue = K_VALUE;

                return fitnessValue;

            case SUPERIEUR: // F = (b-a) + K
                if (op1 > op2)
                    fitnessValue = 0;
                else
                    fitnessValue = (op2 - op1) + K_VALUE;

                return fitnessValue;

            case INFERIEUR: // F = (a-b) + K
                if (op1 < op2)
                    fitnessValue = 0;
                else
                    fitnessValue = (op1 - op2) + K_VALUE;

                return fitnessValue;

            default:
                break;
        }
        return fitnessValue;
    }


    /**
     * Reajuste les valeurs de la condition ie celles d'une des opérandes.
     * Ici nous choisissons d'ajouter la valeur du fitness a l'operande 1.
     * @param conditions
     * @param fitness
     * @return readjustedCondition
     */
    public static List<Condition> readjustTestData(List<Condition> conditions, int fitness) {

        List<Condition> newData = new ArrayList<>();

        if (conditions.size() == 1) {
            newData.add(readjustUniqueCondition(conditions.get(UNIQUE_CONDITION), fitness));
        } else {
            newData = readjustMultipleConditions(conditions, fitness);
        }
        return newData;
    }

    /**
     * Reajustement dans le cas de plusieurs conditions
     * @param conditions
     * @param fitness
     * @return nouvelleListeDeConditions
     */
    private static List<Condition> readjustMultipleConditions(List<Condition> conditions, int fitness) {

        List<Condition> newConditions = new ArrayList<>();

        for (Condition condition : conditions) {
            newConditions.add(readjustUniqueCondition(condition, fitness));
        }

        return newConditions;
    }

    /**
     * Reajustement pour une condition unique
     * @param condition
     * @param fitness
     * @return nouvelleCondition
     */
    private static Condition readjustUniqueCondition(Condition condition, int fitness) {

        Condition newCondition = condition;
        newCondition.setOperande_1(condition.getOperande_1() + fitness); // ajoute la valeur du fitness a l'operande 1

        return newCondition;
    }
}

