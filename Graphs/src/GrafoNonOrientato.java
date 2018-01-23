import java.util.Collection;
import java.util.Set;

import org.jgrapht.graph.DefaultEdge;
import org.jgrapht.graph.SimpleGraph;

public class GrafoNonOrientato extends SimpleGraph<Integer, DefaultEdge>{

	/**
	 * 
	 */
	private static final long serialVersionUID = -6780750409203339518L;

	public GrafoNonOrientato(Class<? extends DefaultEdge> edgeClass) {
		super(edgeClass);
		// TODO Auto-generated constructor stub
	}

	@Override // controllo se il mio grafo contiene un determinato arco
	public boolean containsEdge(Integer sourceVertex, Integer targetVertex) {
		return super.containsEdge(sourceVertex, targetVertex);
	}

	@Override //elimina tutti gli archi contenuti nella lista passata alla funzione
	public boolean removeAllEdges(Collection<? extends DefaultEdge> edges) {
		return super.removeAllEdges(edges);
	}

	@Override ///rimuove tutti gli archi che vanno dal vertex di partenza a quello di arrivo, restituisce gli archi rimossi
	public Set<DefaultEdge> removeAllEdges(Integer sourceVertex, Integer targetVertex) {
		return super.removeAllEdges(sourceVertex, targetVertex);
	}

	@Override //rimuove tutti i vertici contenuti nella lista passata alla funzione
	public boolean removeAllVertices(Collection<? extends Integer> vertices) {
		return super.removeAllVertices(vertices);
	}

	@Override //stampa il grafo
	public String toString() {
		return super.toString();
	}

	@Override //controlla se un determinato vertice esiste nel grafo, altrimenti notifica un' exception
	protected boolean assertVertexExist(Integer v) {
		return super.assertVertexExist(v);
	}

	@Override //elimina tutti gli archi contenuti nella lista passata alla funzione
	protected boolean removeAllEdges(DefaultEdge[] edges) {
		// TODO Auto-generated method stub
		return super.removeAllEdges(edges);
	}

	@Override
	protected String toStringFromSets(Collection<? extends Integer> vertexSet,
			Collection<? extends DefaultEdge> edgeSet, boolean directed) {
		// TODO Auto-generated method stub
		return super.toStringFromSets(vertexSet, edgeSet, directed);
	}

	@Override //restituisce la codifica hash di tutto il grafo
	public int hashCode() {
		// TODO Auto-generated method stub
		return super.hashCode();
	}

	@Override //equals tra grafi
	public boolean equals(Object obj) {
		// TODO Auto-generated method stub
		return super.equals(obj);
	}

	@Override //aggiungo un nodo
	public DefaultEdge addEdge(Integer sourceVertex, Integer targetVertex) {
		// TODO Auto-generated method stub
		addVertex(sourceVertex);
		addVertex(targetVertex);
		return super.addEdge(sourceVertex, targetVertex);
	}

	@Override //setto il peso di un nodo
	public void setEdgeWeight(DefaultEdge e, double weight) {
		// TODO Auto-generated method stub
		super.setEdgeWeight(e, weight);
	}

	@Override //aggiungo un vertice
	public boolean addVertex(Integer v) {
		// TODO Auto-generated method stub
		return super.addVertex(v);
	}

	@Override //resti
	public Integer getEdgeSource(DefaultEdge e) {
		// TODO Auto-generated method stub
		return super.getEdgeSource(e);
	}

	@Override
	public Integer getEdgeTarget(DefaultEdge e) {
		// TODO Auto-generated method stub
		return super.getEdgeTarget(e);
	}

	@Override
	public boolean containsVertex(Integer v) {
		// TODO Auto-generated method stub
		return super.containsVertex(v);
	}

	@Override
	public DefaultEdge removeEdge(Integer sourceVertex, Integer targetVertex) {
		// TODO Auto-generated method stub
		return super.removeEdge(sourceVertex, targetVertex);
	}

	@Override
	public boolean removeEdge(DefaultEdge e) {
		// TODO Auto-generated method stub
		return super.removeEdge(e);
	}

	@Override
	public boolean removeVertex(Integer v) {
		// TODO Auto-generated method stub
		return super.removeVertex(v);
	}

	@Override
	public double getEdgeWeight(DefaultEdge e) {
		// TODO Auto-generated method stub
		return super.getEdgeWeight(e);
	}
	
}