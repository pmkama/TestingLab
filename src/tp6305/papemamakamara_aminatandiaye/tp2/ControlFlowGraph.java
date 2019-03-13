package tp6305.papemamakamara_aminatandiaye.tp2;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Random;

/**
 * class that represent our CFG
 */
public class ControlFlowGraph {

    private List<Path> paths;
    public Path path1,path2, path3, path4, path5, path6, path7, path8, path9, path10;
    public List<Node> node1, node2, node3, node4, node5, node6, node7, node8, node9, node10;
    public List<Condition> cond1, cond2, cond3_1, cond3_2, cond3_3, cond4, cond5, cond6, cond7;
    final int MAX_SIDES_NUMBER= 3;
    int [] initialTestData;
    private int side1;
    private int side2;
    private int side3;


    public ControlFlowGraph() {
        this.paths = new ArrayList<>();
        this.initialTestData = this.randomlyInitializeTestData(new StringBuilder(), new int[MAX_SIDES_NUMBER] );
        this.initilizeCFG();
    }

    public void initilizeCFG() {

        side1 = initialTestData[0];
        side2 = initialTestData[1];
        side3 = initialTestData[2];

        System.out.println("Initial Data : " + side1 + " : " +  side2 + " : " + side3);
        //Path1 : 33->34->76
        cond1= new ArrayList<>();
        node1 = new ArrayList<>();
        cond1.add(new Condition(initialTestData.length, 3, Operators.DIFFERENT));
        node1.add(new Node(cond1));
        path1 = new Path(1, node1);

        //Path2 : 33, 36, 76
        //Conditions
        cond2 = new ArrayList<>();
        Condition cond2_1 = new Condition(side1,0,  Operators.INFERIEUR);
        Condition cond2_2 = new Condition(side2, 0, Operators.INFERIEUR);
        Condition cond2_3 = new Condition(side3,0, Operators.INFERIEUR);
        Collections.addAll(cond2, cond2_1, cond2_2, cond2_3);
        node2 = new ArrayList<>();
        node2.add(new Node(cond2));
        path2 = new Path(2, node2);

        //Path3 : 33, 36, 39, 40, 43, 46, 49, 56, 76
        //Conditions
        cond3_1 = new ArrayList<>();
        cond3_2 = new ArrayList<>();
        cond3_3 = new ArrayList<>();
        node3 = new ArrayList<>();
        cond3_1.add(new Condition(side1, side2, Operators.EGALE));
        cond3_2.add(new Condition(side2, side3, Operators.EGALE));
        cond3_3.add(new Condition(side1, side3, Operators.EGALE));
        Collections.addAll(node3 ,new Node(cond3_1), new Node(cond3_2), new Node(cond3_3));
        path3 = new Path(3, node3);


        //Path4 : 33, 36, 39, 40, 41, 43, 46, 49, 56, 59, 60, 76
        //Conditions
        cond4 = new ArrayList<>();
        node4 = new ArrayList<>();
        cond4.add(new Condition((side1 + side2), side3, Operators.SUPERIEUR));
        Collections.addAll(node4,new Node(cond3_1), new Node(cond4));
        path4 = new Path(4, node4);

        cond5 = new ArrayList<>();
        node5 = new ArrayList<>();
        cond5.add(new Condition((side2 + side3), side1, Operators.SUPERIEUR));
        Collections.addAll(node5,new Node(cond3_2), new Node(cond5));
        path5 = new Path(5, node5);

        cond6 = new ArrayList<>();
        node6 = new ArrayList<>();
        cond6.add(new Condition((side1 + side3), side1, Operators.SUPERIEUR));
        Collections.addAll(node6,new Node(cond3_3), new Node(cond6));
        path6 = new Path(6, node5);

        node7 = new ArrayList<>();
        cond7 = new ArrayList<>();
        Condition cond7_1 = new Condition((side1+side2), side3, Operators.INFERIEUR);
        Condition cond7_2 = new Condition((side2+side3), side1, Operators.INFERIEUR);
        Condition cond7_3 = new Condition((side1+side3), side2,  Operators.INFERIEUR);
        Collections.addAll(cond7, cond7_1, cond7_2, cond7_3);
        node7.add(new Node(cond7));
        path7 = new Path(7, node7);

        //cond8 = new ArrayList<>();
        node8 = new ArrayList<>();
        node8.add(new Node(cond3_1));
        path8 = new Path(8, node8);

        node9 = new ArrayList<>();
        node9.add(new Node(cond3_2));
        path9 = new Path(9, node9);

        node10 = new ArrayList<>();
        node10.add(new Node(cond3_3));
        path10 = new Path(9, node10);

        Collections.addAll(paths, path1, path2, path3, path4, path5, path6, path7, path8, path9, path10);

    }


    /**
     * Initialize the triangle's sides
     *
     * @param builder
     * @param initialTestData
     */
    public int[] randomlyInitializeTestData(StringBuilder builder, int[] initialTestData) {

        final int MIN_VALUE = -10;
        final int MAX_VALUE = 10;
        Random random = new Random();
        for (int i = 0; i < initialTestData.length; i++) {
            initialTestData[i] = MIN_VALUE + random.nextInt(MAX_VALUE - MIN_VALUE);
            builder.append(initialTestData[i]).append(", ");
        }
        return initialTestData;
    }

    public List<Path> getPaths() {
        return paths;
    }

    public void setPaths(List<Path> paths) {
        this.paths = paths;
    }
}
