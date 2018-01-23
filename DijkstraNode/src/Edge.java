public class Edge {
	private final String id;
	private final Vertex source;
	private final Vertex destination;
	private final int weight;

	public Edge(String id, Vertex source, Vertex destination, int weight) {
		this.id = id;
		this.source = source;
		this.destination = destination;
		this.weight = weight;
	}

	public String toString() {
		return source + " " + destination;
	}

	public String getId() {
		return id;
	}

	public int getWeight() {
		return weight;
	}

	public Vertex getSource() {
		return source;
	}

	public Vertex getDestination() {
		return destination;
	}

}