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

        //Pour chaque Path
        for (Path path : this.cfg.getPaths()) {
            System.out.println("Path #" + path.getPathID());
            List<Condition> conditions;
            Node[] nodes = new Node [path.getNodes().size()];
            nodes = path.getNodes().toArray(nodes); //Recupére les noeuds

            for (int i = 0; i < nodes.length; i++) { //fitness pour les conditions de chque noeuds
                Node node = nodes[i];
                conditions = node.getConditions();

                if (evaluateFitnessValue(conditions) == 0) { // Si les testData passe la condition donnée -> fitness == 0
                    int count = 0;
                    for (int j = 0; j < i; j++) { //Test des noeud précedents j<i
                        float fit;
                        while (evaluateFitnessValue(nodes[j].getConditions()) != 0){
                            continue;
                        }
                        fitnessValue = 0; //condition d'arret de runTest() dans CoveredTest
                        System.out.println("backward test successfuly done!");
                    }
                }
            }

        }


        /*this.cfg.getPaths().stream()
                .forEach(path -> {
                System.out.println("Path #"+path.getPathID());
                    path.getNodes().stream().forEach(node -> {
                        List<Condition> conditions = node.getConditions();
                       fitnessValue =  evaluateFitnessValue(conditions);
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
