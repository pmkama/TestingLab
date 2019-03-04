package tp6305;

import java.util.*;

public abstract class CoverageTest {

	public static final int TOTAL_BRANCH_NUM = 19;
	protected Set<String> branchesTested = new HashSet<String>();
	protected int iterationNum;
	private double branchCoverage;
	private InstrumentedTriangle instrumentedTriangle = new InstrumentedTriangle();

	public double getBranchCoverage() {
		return branchCoverage;
	}

	public int getIterationNum() {
		return iterationNum;
	}

	public void testBranchCoverage(double coverageThreshold) {

		this.reset();

		fourInputsTestForBranchCoverage();

		StringBuilder builder = new StringBuilder();

		while (true) {
			runTest(builder);
			branchCoverage = this.computeBranchCoverage(
					instrumentedTriangle.getOutputs(), builder.toString());

			if (branchCoverage >= coverageThreshold) {
				outputCoveredCode(this.branchesTested);
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

		instrumentedTriangle.getType(testData);
	}

	protected abstract void generateTestData(StringBuilder builder,
			float[] testData);

	private void fourInputsTestForBranchCoverage() {

		float[] illegalTestData = new float[] { 0, 0, 0, 0 };

		branchesTested.clear();

		instrumentedTriangle.getType(illegalTestData);

		this.computeBranchCoverage(instrumentedTriangle.getOutputs(),
				"0, 0, 0, 0");
		iterationNum++;
	}

	protected abstract double computeBranchCoverage(List<String> outputs,
			String testData);
}
