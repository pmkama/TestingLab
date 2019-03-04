package tp6305.papemamakamara_aminatandiaye.tp2;

import java.util.List;

/**
 * class that represent our CFG
 */
public class ControlFlowGraph {

    private List<Path> paths;

    public void initilizeCFG(){
        //TODO : create Conditions
    	
    	Condition cond1 = new Condition();
    	cond1.setOperande_1 = sides;
    	cond1.setOperator = Operator.DIFFERENT;
    	cond1.setOperande_2 = "3";
    	
    	
        //TODO : create Nodes
    	
    	Node node1 = new Node();
    	node1.setConditions(cond1);
    	
        //TODO : create Paths
    	
    	Path path1 = new Path();
    	path1.setNodes(node1);
    	path1.setPathID(1);
    }




    public List<Path> getPaths() {
        return paths;
    }

    public void setPaths(List<Path> paths) {
        this.paths = paths;
    }
}
