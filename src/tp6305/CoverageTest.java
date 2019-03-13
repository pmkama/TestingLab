package tp6305;

import triangle.Triangle;

import java.util.*;

public abstract class CoverageTest {

	//public static final int TOTAL_BRANCH_NUM = 19;
	protected Set<String> branchesTested = new HashSet<String>();
	protected int iterationNum;
	public double branchCoverage;
	public Triangle testedTriangle = new Triangle();
	public float fitnessValue;


	public double getBranchCoverage() {
		return branchCoverage;
	}

	public int getIterationNum() {
		return iterationNum;
	}

	public void testBranchCoverage(double coverageThreshold) {

		this.reset();
		StringBuilder builder = new StringBuilder();

		while (true) {
			runTest(builder);
			//branchCoverage = this.computeBranchCoverage(
					//instrumentedTriangle.getOutputs(), builder.toString());



			if (fitnessValue == 0 ) {
				break;
			}
		}
	}

	protected void reset() {

		this.iterationNum = 0;

	}

	private void outputCoveredCode(Set<String> coveredCode) {
		List<String> branchList = new ArrayList<String>();
		branchList.addAll(coveredCode);
		Collections.sort(branchList);
		for (String branch : branchList) {
			System.out.println(branch);
		}
	}

	private void runTest(StringBuilder builder) {

		iterationNum++;

		float[] testData = new float[3];

		builder.setLength(0);

		generateTestData(builder, testData);

		testedTriangle.getType(testData);
	}

	protected abstract void generateTestData(StringBuilder builder,
			float[] testData);


	protected abstract double computeBranchCoverage(List<String> outputs,
			String testData);
}
