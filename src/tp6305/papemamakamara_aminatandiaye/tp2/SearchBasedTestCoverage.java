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

            for (int i = 0; i < nodes.length; i++) { //fitness pour les conditions de chaque noeuds
                Node node = nodes[i];
                conditions = node.getConditions();
                System.out.println("Conditions : {" + conditions + " }");
                float fit = evaluateFitnessValue(conditions);
                if ( fit == 0) { // Si les testData passent la condition donnée -> fitness == 0
                    System.out.println("Fitness du noeud courant : #" +fit );
                    int count = 0;
                    float fit2;
                    System.out.println("Test des noeuds antérieurs ...");
                    for (int j = 0; j < i; j++) { //Test des noeud précedents j<i
                        fit2 = evaluateFitnessValue(nodes[j].getConditions());
                        System.out.println("Fitness noeuds antérieurs #"+fit2);
                        while (fit2 != 0){
                            continue;
                        }
                        fitnessValue = 0; //condition d'arret de runTest() dans CoveredTest
                        System.out.println("Test des noeud antérieurs effectué.");
                    }
                }
            }
        }
    }

    private float evaluateFitnessValue(List<Condition> conditions) {

        return FitnessFunction.getFitness(conditions);
    }

    @Override
    protected double computeBranchCoverage(List<String> outputs, String testData) {

        return 0;
    }


}
