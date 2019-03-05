package tp6305.papemamakamara_aminatandiaye.tp2;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * class that represent our CFG
 */
public class ControlFlowGraph {

    private List<Path> paths;
    public Path path1,path2,path3,path4,path5,path6,path7,path8,path9,path10;
    public Node node1, node2, node3,node4,node5,node6,node7,node8,node9;
    public List<Condition> cond1, cond2, cond3, cond4, cond5, cond6, cond7, cond8, cond9, cond10, cond11, cond12, cond13;
    float [] initialTestData;
    private float side1;
    private float side2;
    private float side3;


    private ControlFlowGraph() {
        initialTestData = this.randomlyInitializeTestData(new StringBuilder(), new float[3]);
        side1 = initialTestData[0];
        side2 = initialTestData[1];
        side3 = initialTestData[2];
    }

    public void initilizeCFG() {

        //Path1 : 33->34->76
        List<Condition> conditions = new ArrayList<>();
        List<Node> nodes1 = new ArrayList<>();

        conditions.add(new Condition(initialTestData.length, 3, Operators.DIFFERENT));
        nodes1.add(new Node(conditions));
        Path path1 = new Path(1, nodes1);

       // ##################################################

        //Path2 : 33, 36, 37, 76
        //Conditions
        List<Condition> conditions2 = new ArrayList<>();
        Condition cond2_1 = new Condition(side1,0,  Operators.INFERIEUR);
        Condition cond2_2 = new Condition(side2, 0, Operators.INFERIEUR);
        Condition cond2_3 = new Condition(side3,0, Operators.INFERIEUR);

        Collections.addAll(conditions2, cond2_1, cond2_2, cond2_3);

        List<Node> nodes2 = new ArrayList<>();
        nodes2.add(new Node(conditions2));

        Path path2 = new Path(2, nodes2);

        //Path3 : 33, 36, 39, 40, 41, 43, 44, 46, 47, 49, 56, 57, 76
        //Conditions
        cond3.add(new Condition(side1, side2, Operators.EGALE));
        node3 = new Node(cond3);
        path3 = new Path(3, node3);



        Condition cond6 = new Condition();
        cond6.setOperande_1 = side2;
        cond6.setOperator = Operators.EGALE;
        cond6.setOperande_2 = side3;

        Condition cond7 = new Condition();
        cond7.setOperande_1 = side1;
        cond7.setOperator = Operators.EGALE;
        cond7.setOperande_2 = side3;


        //Nodes
        Node node3 = new Node();
        node3.setConditions(cond5);

        Node node4 = new Node();
        node4.setConditions(cond6);

        Node node5 = new Node();
        node5.setConditions(cond7);

        //Paths
        Path path3 = new Path();
        path3.setNodes(node3, node4, node5);
        path3.setPathID(3);

        //Path4 : 33, 36, 39, 40, 41, 43, 46, 49, 56, 59, 60, 76
        //Conditions
        Condition cond8 = new Condition();
        cond8.setOperande_1 = side1 + side2;
        cond8.setOperator = Operators.SUPERIEUR;
        cond8.setOperande_2 = side3;

        //Nodes
        Node node6 = new Node();
        node6.setConditions(cond8);

        //Paths
        Path path4 = new Path();
        path4.setNodes(node3, node6);
        path4.setPathID(4);

        //Path5 : 33, 36, 39, 40, 43, 44, 46, 49, 56, 59, 62, 63, 76
        //Conditions
        Condition cond9 = new Condition();
        cond9.setOperande_1 = side2 + side3;
        cond9.setOperator = Operators.SUPERIEUR;
        cond9.setOperande_2 = side1;

        //Nodes
        Node node7 = new Node();
        node7.setConditions(cond9);

        //Paths
        Path path5 = new Path();
        path5.setNodes(node4, node7);
        path5.setPathID(5);

        //Path6 : 33, 36, 39, 40, 43, 46, 47, 49, 56, 59, 62, 65, 66, 76
        //Conditions
        Condition cond10 = new Condition();
        cond10.setOperande_1 = side1 + side3;
        cond10.setOperator = Operators.SUPERIEUR;
        cond10.setOperande_2 = side2;

        //Nodes
        Node node8 = new Node();
        node8.setConditions(cond10);

        //Paths
        Path path6 = new Path();
        path6.setNodes(node5, node8);
        path6.setPathID(6);

        //Path7 : 33, 36,39, 40, 43, 46, 49, 50, 51, 76
        //Conditions
        Condition cond11 = new Condition();
        cond11.setOperande_1 = side1 + side2;
        cond11.setOperator = Operators.INFERIEUR;
        cond11.setOperande_2 = side3;

        Condition cond12 = new Condition();
        cond12.setOperande_1 = side2 + side3;
        cond12.setOperator = Operators.INFERIEUR;
        cond12.setOperande_2 = side1;

        Condition cond13 = new Condition();
        cond13.setOperande_1 = side1 + side3;
        cond13.setOperator = Operators.INFERIEUR;
        cond13.setOperande_2 = side2;

        //Nodes
        Node node9 = new Node();
        node9.setConditions(cond11, cond12, cond13);
        node9.setLogicOperator(true);

        //Paths
        Path path7 = new Path();
        path7.setNodes(node9);
        path7.setPathID(7);

        //Path8 : 33, 36, 39, 40, 41, 43, 46, 49, 56, 59, 62, 65, 68, 76
        Path path8 = new Path();
        path8.setNodes(node3);
        path8.setPathID(8);

        //Path9 : 33, 36, 39, 40, 43, 44, 46, 49, 56, 59, 62, 65, 68, 76
        Path path9 = new Path();
        path9.setNodes(node4);
        path9.setPathID(9);

        //Path10 : 33, 36, 39, 40, 43, 46, 47, 49, 56, 59, 62, 65, 68, 76
        Path path10 = new Path();
        path10.setNodes(node5);
        path10.setPathID(10);

    }


    public Path instanciatePath(List<Condition> conditions, List<Node> nodes) {
        Path path = null;
        int pathID = 0;

        nodes.add(new Node(conditions));
        path = new Path(pathID++, nodes);

        return path;
    }



    public List<Path> getPaths() {
        return paths;
    }

    public void setPaths(List<Path> paths) {
        this.paths = paths;
    }

    public float[] randomlyInitializeTestData(StringBuilder stringBuilder, float[] testData) {

        return testData;
    }
}
