package modelo;

import java.util.ArrayList;
import java.util.List;

public class Vertice {
	
	private int rotulo;
	private double estimativa;
	private List<Aresta> listaArestas;
	private boolean isAberto;
	private Vertice precedente;

	public Vertice(int rotulo) {
		this.rotulo = rotulo;
		this.estimativa = Double.POSITIVE_INFINITY;
		this.isAberto = true;
		this.listaArestas = new ArrayList<Aresta>(100);
		this.precedente = null;
	}

	public void setPrecedente(Vertice v) {
		this.precedente = v;
	}

	public Vertice getPrecedente() {
		return this.precedente;
	}

	/*public void setFechado() {
		this.isAberto = false;
	}*/

	public boolean isAberto() {
		return this.isAberto;
	}

	public double getEstimativa() {
		return estimativa;
	}

	public void setEstimativa(double estimativa) {
		this.estimativa = estimativa;
	}

	public int getRotulo() {
		return rotulo;
	}

	public List<Aresta> getListaArestas() {
		return listaArestas;
	}
}
