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
		}
	}

	public void addAresta(Vertice verticeParteAresta, Vertice verticeRecebeAresta, long pesoAresta) {

		// Aqui temos um dígrafo

		boolean f1 = false;
		int aux1 = 0, i;

		for (i = 0; i < this.vertices.size() && !f1; i++) {

			if (this.vertices.get(i).getRotulo() == verticeParteAresta.getRotulo()) {
				f1 = true;
				aux1 = i;
			}
		}

		if (f1) {

			Aresta a = new Aresta();

			a.setRotuloVerticeVai(verticeRecebeAresta);
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

			if (sum < a.getRotuloVerticeVai().getEstimativa()) {

				a.getRotuloVerticeVai().setEstimativa(sum);
				a.getRotuloVerticeVai().setPrecedente(v);
				this.filaDeVertices.add(a.getRotuloVerticeVai());
				System.out
						.println("Peguei o vértice da minha lista de arestas = " + a.getRotuloVerticeVai().getRotulo());
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

	public void dijkstraCaminhoIniEFinal(int rotuloVerticeInicial, int rotuloVerticeFinal) {

		if (acheiVertice(rotuloVerticeInicial)) {

			while (filaNaoVazia() && filaDeVertices.peek().getRotulo() != rotuloVerticeFinal) {

				BFS(filaDeVertices.poll());
			}
		}
	}

	private boolean filaNaoVazia() {
		return !this.filaDeVertices.isEmpty();
	}
}
