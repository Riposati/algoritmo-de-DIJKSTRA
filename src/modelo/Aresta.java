package modelo;

public class Aresta {

	private Vertice verticeAdj;
	private long pesoAresta;

	public long getPesoAresta() {
		return pesoAresta;
	}

	public void setPesoAresta(long pesoAresta) {
		this.pesoAresta = pesoAresta;
	}

	public Vertice getRotuloVerticeVai() {
		return verticeAdj;
	}

	public void setRotuloVerticeVai(Vertice rotuloVerticeVai) {
		this.verticeAdj = rotuloVerticeVai;
	}
}
