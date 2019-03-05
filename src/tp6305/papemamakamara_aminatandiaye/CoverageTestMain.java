package tp6305.papemamakamara_aminatandiaye;

import tp6305.CoverageTest;
import tp6305.papemamakamara_aminatandiaye.tp2.SearchBasedTestCoverage;

public class CoverageTestMain {

    /**
     * @param args
     */
    public static void main(String[] args) {


        CoverageTest coverageTest = new SearchBasedTestCoverage();


        testBranchCoverage(coverageTest, 1.0);

        //testBranchCoverage(coverageTest, 0.95);



    }

    private static void testBranchCoverage(CoverageTest coverageTest, double coverageThreshold) {
        int total = 0;
        for (int i = 0; i < 3; i++) {

            coverageTest.testBranchCoverage(coverageThreshold);

            System.out.println("BranchCoverage is "
                    + coverageTest.getBranchCoverage());
            System.out.println("Number of iteration is "
                    + coverageTest.getIterationNum());
            total += coverageTest.getIterationNum();
        }

        System.out.println("To reach " + coverageThreshold * 100 + "% branch coverage, the average iteration number is " + total / 3);
    }

}
