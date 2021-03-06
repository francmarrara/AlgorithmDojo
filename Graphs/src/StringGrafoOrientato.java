
import org.jgrapht.EdgeFactory;
import org.jgrapht.graph.DefaultDirectedGraph;
import org.jgrapht.graph.DefaultEdge;

public class StringGrafoOrientato extends DefaultDirectedGraph<String,DefaultEdge> {

	
	@Override
	public DefaultEdge addEdge(String sourceVertex, String targetVertex) {
		// TODO Auto-generated method stub
		super.addVertex(sourceVertex);
		super.addVertex(targetVertex);
		return super.addEdge(sourceVertex, targetVertex);
	}

	private static final long serialVersionUID = 1L;

	public StringGrafoOrientato(EdgeFactory<String, DefaultEdge> ef) {
		super(ef);
		// TODO Auto-generated constructor stub
	}

	public StringGrafoOrientato(Class<DefaultEdge> class1) {
		// TODO Auto-generated constructor stub
		super(class1);
	}

	@Override
	public int degreeOf(String vertex) {
		// TODO Auto-generated method stub
		return super.degreeOf(vertex);
	}

}
