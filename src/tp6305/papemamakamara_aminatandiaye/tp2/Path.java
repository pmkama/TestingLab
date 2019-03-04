package tp6305.papemamakamara_aminatandiaye.tp2;

import java.util.List;

public class Path {

    private int pathID;
    private List<Node> nodes;

    public Path(int pathID, List<Node> nodes) {
        this.pathID = pathID;
        this.nodes = nodes;
    }


    public int getPathID() {
        return pathID;
    }

    public void setPathID(int pathID) {
        this.pathID = pathID;
    }

    public List<Node> getNodes() {
        return nodes;
    }

    public void setNodes(List<Node> nodes) {
        this.nodes = nodes;
    }
}
