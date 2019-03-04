package tp6305.papemamakamara_aminatandiaye.tp2;

import java.util.List;
import java.util.Random;

import com.sun.org.apache.xalan.internal.xsltc.runtime.Operators;

/**
 * class that represent our CFG
 */
public class ControlFlowGraph {

    private List<Path> paths;
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
    
    public void initilizeCFG(){

        //Path1 : 33->34->76        
        //Conditions
    	Condition cond1 = new Condition();
    	cond1.setOperande_1 = initialTestData.length;
    	cond1.setOperator = Operator.DIFFERENT;
    	cond1.setOperande_2 = 3;
    	    	
        //Nodes    	
    	Node node1 = new Node();
    	node1.setConditions(cond1);
    	
        //Paths    	
    	Path path1 = new Path();
    	path1.setNodes(node1);
    	path1.setPathID(1);
    	
    	//Path2 : 33, 36, 37, 76
    	//Conditions
    	Condition cond2 = new Condition();
    	cond2.setOperande_1 = side1;
    	cond2.setOperator = Operators.INFERIEUR;
    	cond2.setOperande_2 = 0;
    	
    	Condition cond3 = new Condition();
    	cond3.setOperande_1 = side2;
    	cond3.setOperator = Operators.INFERIEUR;
    	cond3.setOperande_2 = 0;
    	
    	Condition cond4 = new Condition();
    	cond4.setOperande_1 = side3;
    	cond4.setOperator = Operators.INFERIEUR;
    	cond4.setOperande_2 = 0;
    	    	
        //Nodes    	
    	Node node2 = new Node();
    	node2.setConditions(cond2,cond3,cond4);
    	node2.setLogicOperator(true);
    	
        //Paths    	
    	Path path2 = new Path();
    	path2.setNodes(node2);
    	path2.setPathID(2);

        //Path3 : 33, 36, 39, 40, 41, 43, 44, 46, 47, 49, 56, 57, 76
    	//Conditions
    	Condition cond5 = new Condition();
    	cond5.setOperande_1 = side1;
    	cond5.setOperator = Operators.EGALE;
    	cond5.setOperande_2 = side2;
    	
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
    	path3.setNodes(node3,node4,node5);
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
    	path4.setNodes(node3,node6);
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
    	path5.setNodes(node4,node7);
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
    	path6.setNodes(node5,node8);
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
    	node9.setConditions(cond11,cond12,cond13);
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

    public List<Path> getPaths() {
        return paths;
    }

    public void setPaths(List<Path> paths) {
        this.paths = paths;
    }
}
