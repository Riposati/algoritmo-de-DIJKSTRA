package modelo;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.PriorityQueue;

class Comparador implements Comparator<Vertice> {

	@Override
	public int compare(Vertice o1, Vertice o2) {

		if (o1.getEstimativa() < o2.getEstimativa()) {
			return -1;
		}
		if (o1.getEstimativa() > o2.getEstimativa()) {
			return 1;
		}
		return 0;
	}
}

public class Grafo {

	private List<Vertice> vertices;
	private PriorityQueue<Vertice> filaDeVertices;

	public Grafo() {
		this.vertices = new ArrayList<Vertice>(100);
		this.filaDeVertices = new PriorityQueue<>(100, new Comparador());
	}

	public List<Vertice> getVertices() {
		return vertices;
	}

	public void addVertice(Vertice v) {
		this.vertices.add(v);
	}

	public void mostraGrafo() {

		for (Vertice v : this.vertices) {

			System.out.println("\nVértice = " + v.getRotulo());
			if (v.getPrecedente() != null)
				System.out.println("\n**********Precedente = " + v.getPrecedente().getRotulo() + "****************");
			else
				System.out.println("\n**********Precedente = NULL" + "****************");

			System.out.println("\n**********ESTIMATIVA = " + v.getEstimativa() + "****************");

			/*
			 * if (v.getListaArestas().size() > 0){ System.out.println(
			 * "\nLista de arestas deste vértice:\n"); }
			 */

			/*
			 * for (Aresta a : v.getListaArestas()) { System.out.println(
			 * "Rotulo = " + a.getRotuloVertice() + "\nPeso desta ligaçao = " +
			 * a.getPesoAresta() + "\n--------------------------------\n"); }
			 */
		}
	}

	public void addAresta(int rotuloVerticeParteAresta, int rotuloVerticeRecebeAresta, long pesoAresta) {

		// Aqui temos um dígrafo

		boolean f1 = false;
		int aux1 = 0, i;

		for (i = 0; i < this.vertices.size() && !f1; i++) {

			if (this.vertices.get(i).getRotulo() == rotuloVerticeParteAresta) {
				f1 = true;
				aux1 = i;
			}
		}

		if (f1) {

			Aresta a = new Aresta();
			a.setRotuloVerticeVai(rotuloVerticeRecebeAresta);
			a.setPesoAresta(pesoAresta);

			this.vertices.get(aux1).getListaArestas().add(a);
		}
	}

	private boolean acheiVertice(int rotulo) {

		for (int i = 0; i < this.getVertices().size(); i++) {

			if (this.getVertices().get(i).getRotulo() == rotulo) {
				this.getVertices().get(i).setEstimativa(0); // O começo da busca

				filaDeVertices.add(this.getVertices().get(i));
				
				return true;
			}
		}

		return false;
	}

	private void BFS(Vertice v) {

		for (int i = 0; i < v.getListaArestas().size(); i++) {

			Aresta a = v.getListaArestas().get(i);

			double sum = v.getEstimativa() + a.getPesoAresta();

			for (int x = 0; x < this.getVertices().size(); x++) {

				if (a.getRotuloVerticeVai() == this.getVertices().get(x).getRotulo()) {

					if (sum < this.getVertices().get(x).getEstimativa()) {

						this.getVertices().get(x).setEstimativa(sum);
						this.getVertices().get(x).setPrecedente(v);
						this.filaDeVertices.add(this.getVertices().get(x));
						System.out.println("Peguei o vértice da minha lista de arestas = "
								+ this.getVertices().get(x).getRotulo());
					}
				}
			}
		}
	}

	public void dijkstra(int rotuloVerticeInicial) {

		if (acheiVertice(rotuloVerticeInicial)) {

			while (filaNaoVazia()) {

				BFS(filaDeVertices.poll());
			}
		}
	}
	
	public void dijkstraCaminhoIniEFinal(int rotuloVerticeInicial,int rotuloVerticeFinal) {

		if (acheiVertice(rotuloVerticeInicial)) {

			while (filaNaoVazia() && filaDeVertices.peek().getRotulo()!=rotuloVerticeFinal) {

				BFS(filaDeVertices.poll());
			}
		}
	}

	private boolean filaNaoVazia() {
		return !this.filaDeVertices.isEmpty();
	}
}
