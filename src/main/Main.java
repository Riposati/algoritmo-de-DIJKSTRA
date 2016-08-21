package main;

import modelo.Grafo;
import modelo.Vertice;

public class Main {

	public static void main(String[] args) {

		Grafo g = new Grafo();

		Vertice verticeZero = new Vertice(0);
		g.addVertice(verticeZero);
		
		Vertice verticeUm = new Vertice(1);
		g.addVertice(verticeUm);
		
		Vertice verticeDois = new Vertice(2);
		g.addVertice(verticeDois);
		
		Vertice verticeTres = new Vertice(3);
		g.addVertice(verticeTres);

		Vertice verticeQuatro = new Vertice(4);
		g.addVertice(verticeQuatro);

		g.addAresta(verticeZero, verticeUm, 10);
		g.addAresta(verticeUm, verticeDois, 1);
		g.addAresta(verticeZero, verticeQuatro, 5);
		
		g.addAresta(verticeDois, verticeTres, 4);
		g.addAresta(verticeTres, verticeDois, 6);
		g.addAresta(verticeTres, verticeZero, 7);
		
		g.addAresta(verticeUm,verticeQuatro, 2);
		g.addAresta(verticeQuatro, verticeUm, 3);
		g.addAresta(verticeQuatro, verticeDois, 9);
		
		g.addAresta(verticeQuatro, verticeTres, 2);
		

		g.dijkstra(0);
		
		g.mostraGrafo();
	}
}
