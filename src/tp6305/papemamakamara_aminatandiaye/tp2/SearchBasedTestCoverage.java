package tp6305.papemamakamara_aminatandiaye.tp2;

import tp6305.CoverageTest;

import java.util.List;
import java.util.Random;

public class SearchBasedTestCoverage extends CoverageTest {

    float [] initialTestData;
    private double side1;
    private double side2;
    private double side3;


    public SearchBasedTestCoverage(){

        this.initialTestData = this.randomlyInitializeTestData(new StringBuilder(), new float[3]);
        this.side1 = initialTestData[0];
        this.side2 = initialTestData[1];
        this.side3 = initialTestData[2];
    }


    @Override
    protected void generateTestData(StringBuilder builder, float[] testData) {

        //TODO : test data generation based on SBST
        //Initialize test data
        new SearchBasedTestCoverage();




    }

    /**
     * Initialize the triangle's sides
     * @param builder
     * @param initialTestData
     */
    public float[] randomlyInitializeTestData(StringBuilder builder, float [] initialTestData){
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


    public StringBuilder readjustTestData(StringBuilder builder){
        StringBuilder newBuilder = new StringBuilder();

        // TODO: reorganize test data

        return newBuilder;
    }

    @Override
    protected double computeBranchCoverage(List<String> outputs, String testData) {
        return 0;
    }




}
