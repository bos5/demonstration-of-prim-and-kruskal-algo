package something_of_Duong.privateforDuong.JavaAppletForDemonstrationPrimAndKruskalAlgo;

public class Edge{
    private int node1, node2, weight;

    public Edge(int node1, int node2, int weight){

        this.node1 = node1;
        this.node2 = node2;
        this.weight = weight;
    }

	public int getNode1() {
		return node1;
	}

	public void setNode1(int node1) {
		this.node1 = node1;
	}

	public int getNode2() {
		return node2;
	}

	public void setNode2(int node2) {
		this.node2 = node2;
	}

	public int getWeight() {
		return weight;
	}

	public void setWeight(int weight) {
		this.weight = weight;
	}

   
}
