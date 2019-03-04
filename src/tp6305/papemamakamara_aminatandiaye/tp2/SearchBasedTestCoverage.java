package tp6305.papemamakamara_aminatandiaye.tp2;

import tp6305.CoverageTest;

import java.util.List;
import java.util.Random;

public class SearchBasedTestCoverage extends CoverageTest {

    


    public SearchBasedTestCoverage(){

       
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
