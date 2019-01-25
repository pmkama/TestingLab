package tp6305.papemamakamara_aminatandiaye;

import tp6305.CoverageTest;

import java.util.List;
import java.util.Random;

public class RandomCoverageTest extends CoverageTest {

    protected void generateTestData(StringBuilder builder, float[] testData) {

        randomData(builder, testData);
    }

    protected void randomData(StringBuilder builder, float[] testData) {

        //TODO:

        final int MAX_NUMBER_OF_DATA = 3; // number of data to generate for each iteration.
        // [ min : max ] Randoms values domain
        final int MIN_VALUE = -10;
        final int MAX_VALUE = 20;
        //Generate random numbers to each elements in testData,
        //then put them in the StringBuilder as:
        //builder.append(testData[i]).append(", ");
        Random random = new Random();
        for (int i = 0; i < MAX_NUMBER_OF_DATA; i++) {
            testData[i] = MIN_VALUE + random.nextInt(MAX_VALUE - MIN_VALUE);
            builder.append(testData[i]).append(", ");
        }
    }

    protected double computeBranchCoverage(List<String> instrumentingOutputs, String testData) {

        int nbCoveredBranchs = branchesTested.size(); //We initialize a counter to the current number of covered branchs

        //for each Output's line starting with "<trace>" we consider it as visited then we add it to the covered branch list
        for (String line : instrumentingOutputs) {
            if (line.startsWith("<trace>")) {
                branchesTested.add(line);
            }
        }

		/*
			At the end we check if our covered branch list's size has changed (branchTested.size() > nbCoveredBranchs)
			If any change occurs that means testData contribute increasing the coverage so we print them.
		*/
        if (branchesTested.size() > nbCoveredBranchs)
            System.out.println(testData);

        return branchesTested.size() / TOTAL_BRANCH_NUM; //and we return the coverage rate
    }

    @Override
    protected double computeRACC(List<String> outputs, String testData) {

        return 0;
    }

}
