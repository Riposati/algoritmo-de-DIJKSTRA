package main;

import modelo.Grafo;
import modelo.Vertice;

public class Main {

	public static void main(String[] args) {

		Grafo g = new Grafo();

		Vertice v = new Vertice(0);
		g.addVertice(v);
		v = new Vertice(1);
		g.addVertice(v);
		v = new Vertice(2);
		g.addVertice(v);
		v = new Vertice(3);
		g.addVertice(v);

		v = new Vertice(4);
		g.addVertice(v);

		g.addAresta(0, 1, 10);
		g.addAresta(1, 2, 1);
		g.addAresta(0, 4, 5);
		
		g.addAresta(2, 3, 4);
		g.addAresta(3, 2, 6);
		g.addAresta(3, 0, 7);
		
		g.addAresta(1, 4, 2);
		g.addAresta(4, 1, 3);
		g.addAresta(4, 2, 9);
		
		g.addAresta(4, 3, 2);
		

		g.dijkstra(0);
		
		g.mostraGrafo();
	}
}
