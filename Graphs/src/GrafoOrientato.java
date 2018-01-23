import java.util.Collection;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import org.jgrapht.graph.DefaultDirectedGraph;
import org.jgrapht.graph.DefaultEdge;

public class GrafoOrientato extends DefaultDirectedGraph<Integer, DefaultEdge> {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public GrafoOrientato(Class<? extends DefaultEdge> edgeClass) {
		super(edgeClass);
	}

	@Override // restituisce tutti gli archi che collegano partenza e
				// destinazione
	public Set<DefaultEdge> getAllEdges(Integer sourceVertex, Integer targetVertex) {
		return super.getAllEdges(sourceVertex, targetVertex);
	}

	@Override // restituisce l'arco che collega il vertex di partemza con quello
				// di destinazione, restituisce null se non esiste
	public DefaultEdge getEdge(Integer sourceVertex, Integer targetVertex) {
		return super.getEdge(sourceVertex, targetVertex);
	}

	@Override // aggiunge un arco con i nodi
	public DefaultEdge addEdge(Integer sourceVertex, Integer targetVertex) {
		addVertex(sourceVertex);
		addVertex(targetVertex);
		return super.addEdge(sourceVertex, targetVertex);
	}

	@Override // aggiunge un vertice
	public boolean addVertex(Integer v) {
		return super.addVertex(v);
	}

	@Override // restituisce il vertice sorgente
	public Integer getEdgeSource(DefaultEdge e) {
		return super.getEdgeSource(e);
	}

	@Override // restituisce il vertice destinazione
	public Integer getEdgeTarget(DefaultEdge e) {
		return super.getEdgeTarget(e);
	}

	@Override // restituisce true se il grafo contiene quell arco
	public boolean containsEdge(DefaultEdge e) {
		return super.containsEdge(e);
	}

	@Override // restituisce true se il grafo contiene quel vertice
	public boolean containsVertex(Integer v) {
		return super.containsVertex(v);
	}

	@Override // restituisce il grado di un determinato vertice ( i loop contano
				// 2 volte)
	public int degreeOf(Integer vertex) {
		return super.degreeOf(vertex);
	}

	@Override // restituisce l'insieme di archi contenuto in questo grafo
	public Set<DefaultEdge> edgeSet() {
		return super.edgeSet();
	}

	@Override // restituisce l'insieme di archi che toccano il nodo passato in
				// input
	public Set<DefaultEdge> edgesOf(Integer vertex) {
		return super.edgesOf(vertex);
	}

	@Override // restituisce il numero degli archi entranti in un determinato
				// vertice
	public int inDegreeOf(Integer vertex) {
		return super.inDegreeOf(vertex);
	}

	@Override // restituisce il numero degli archi uscenti in un determinato
				// vertice
	public int outDegreeOf(Integer vertex) {
		return super.outDegreeOf(vertex);
	}

	@Override // restituisce la lista degli archi entranti in un determinato
				// vertice
	public Set<DefaultEdge> incomingEdgesOf(Integer vertex) {
		return super.incomingEdgesOf(vertex);
	}

	@Override // restituisce la lista degli archi entranti in un determinato
				// vertice
	public Set<DefaultEdge> outgoingEdgesOf(Integer vertex) {
		return super.outgoingEdgesOf(vertex);
	}

	@Override // rimuove un determinato arco
	public DefaultEdge removeEdge(Integer sourceVertex, Integer targetVertex) {
		return super.removeEdge(sourceVertex, targetVertex);
	}

	@Override // rimuove un determinato vertice e tutti gli archi che lo toccano
	public boolean removeVertex(Integer v) {
		return super.removeVertex(v);
	}

	@Override // restituisce l'insieme dei vertici contenuti nel determinato
				// grafo
	public Set<Integer> vertexSet() {
		return super.vertexSet();
	}

	@Override//restituisce il peso di un determinato nodo
	public double getEdgeWeight(DefaultEdge e) {
		return super.getEdgeWeight(e);
	}

	@Override//setta il peso di un determinato nodo
	public void setEdgeWeight(DefaultEdge e, double weight) {
		super.setEdgeWeight(e, weight);
	}

	@Override // restituisce true se il grafo contiene un determinato arco, false altrimenti
	public boolean containsEdge(Integer sourceVertex, Integer targetVertex) {
		return super.containsEdge(sourceVertex, targetVertex);
	}

	@Override//rimuove dal grafo tutti gli archi contenuti nella collezione
	public boolean removeAllEdges(Collection<? extends DefaultEdge> edges) {
		return super.removeAllEdges(edges);
	}

	@Override//rimuove dal grafo e restituisce tutti gli archi che vanno dalla sorgente alla destinazione
	public Set<DefaultEdge> removeAllEdges(Integer sourceVertex, Integer targetVertex) {
		return super.removeAllEdges(sourceVertex, targetVertex);
	}

	@Override//rimuove dal grafo tutti vertici contenuti nella collezione passata alla funzione
	public boolean removeAllVertices(Collection<? extends Integer> vertices) {
		return super.removeAllVertices(vertices);
	}

	@Override//tostring
	public String toString() {
		return super.toString();
	}

	@Override//assert che determina se un vertice esiste nel grafo, altrimenti rilascia un'eccezione
	protected boolean assertVertexExist(Integer v) {
		return super.assertVertexExist(v);
	}

	@Override // rimuove dal grafo tutti gli archi contenuti nell'array passato alla funzione
	protected boolean removeAllEdges(DefaultEdge[] edges) {
		return super.removeAllEdges(edges);
	}

	@Override//
	protected String toStringFromSets(Collection<? extends Integer> vertexSet,
			Collection<? extends DefaultEdge> edgeSet, boolean directed) {
		return super.toStringFromSets(vertexSet, edgeSet, directed);
	}

	@Override
	public int hashCode() {
		return super.hashCode();
	}

	@Override
	public boolean equals(Object obj) {
		return super.equals(obj);
	}

	
	
	
	
	
	
	public Set<Integer> NodiColl(int Vertex){
    Set<DefaultEdge> IncomingEdges = this.incomingEdgesOf(Vertex);
    Set<DefaultEdge> OutGoingEdges = this.outgoingEdgesOf(Vertex);
    Set<Integer> nodiColl = new HashSet<Integer>();
    for(DefaultEdge de : IncomingEdges){
    	nodiColl.add(this.getEdgeSource(de));
    }
    for(DefaultEdge de : OutGoingEdges){
    	nodiColl.add(this.getEdgeTarget(de));
    	
    }
		return nodiColl;
		
	}
	
	
	
	
	
	public DefaultEdge rimuoviArco(List<Integer> lista) {
			if (lista.size() == 1) {
				return this.removeEdge(lista.get(0), lista.get(0));
			}
			else if(this.containsEdge(lista.get(0), lista.get(1))){
					     return this.removeEdge(lista.get(0), lista.get(1));

		}
			return removeEdge(lista.get(1), lista.get(0));
}
	}
