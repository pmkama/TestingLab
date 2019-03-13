package tp6305.papemamakamara_aminatandiaye.tp2;

import tp6305.CoverageTest;

import java.util.List;

public class SearchBasedTestCoverage extends CoverageTest {

    private ControlFlowGraph cfg;


    public SearchBasedTestCoverage() {
        this.cfg = new ControlFlowGraph();
    }

    @Override
    protected void generateTestData(StringBuilder builder, float[] testData) {

        new SearchBasedTestCoverage();

        for (Path path : this.cfg.getPaths()){
            System.out.println("Path #"+path.getPathID());
            for (Node node : path.getNodes()){
                List<Condition> conditions = node.getConditions();
                fitnessValue = evaluateFitnessValue(conditions);
            }
        }

        /*this.cfg.getPaths().stream()
                .forEach(path -> {
                    path.getNodes().stream().forEach(node -> {
                        List<Condition> conditions = node.getConditions();
                        evaluateFitnessValue(conditions);
                    });
                });*/
    }

    private float evaluateFitnessValue(List<Condition> conditions) {

        return FitnessFunction.getFitness(conditions);
    }

    @Override
    protected double computeBranchCoverage(List<String> outputs, String testData) {

        return 0;
    }


}
