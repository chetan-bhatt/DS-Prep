package graphs;

import java.util.LinkedList;

public class BFS {
	Vertex[] vertices;
	int[][] adjMatrix;
	int maxVertices;
	int vertexCount;
	LinkedList<Integer> queue = new LinkedList<>();
	
	public void bfs(Graph g) {
		vertices = g.vertices;
		adjMatrix = g.adjMatrix;
		maxVertices = g.maxVertices;
		vertexCount = g.vertexCount;
		
		bfsHelper(0);
		System.out.println();
	}
	
	private void bfsHelper(int v) {
		vertices[v].isVisited = true;
		display(v);
		queue.add(v);
		
		while(!queue.isEmpty()) {
			int vertex = queue.remove();
			while((v = getUnvisitedVertex(vertex)) != -1) {
				vertices[v].isVisited = true;
				display(v);
				queue.add(v);
			}
		}
		for(int i = 0; i < maxVertices; i++) {
			vertices[i].isVisited = false;
		}
	}
	
	
	private int getUnvisitedVertex(int v) {
		for(int j = 0; j < maxVertices; j++) {
			if(adjMatrix[v][j] == 1 && !vertices[j].isVisited) {
				return j;
			}
		}
		return -1;
	}
	
	private void display(int v) {
		System.out.print(vertices[v].label);
	}
	
	
	public static void main(String[] args) {
		Graph g = new Graph(8);
		g.addVertex('A');
		g.addVertex('B');
		g.addVertex('C');
		g.addVertex('D');
		g.addVertex('E');
		g.addVertex('F');
		g.addVertex('G');
		g.addVertex('H');
		
		g.addEdge(0, 1); //AB
		g.addEdge(1, 2); //BC
		g.addEdge(1,  7); //BH
		g.addEdge(2,  3); //CD
		g.addEdge(2,  4); //CE
		g.addEdge(7,  4); //HE
		g.addEdge(4,  5); //EF
		g.addEdge(4,  6); //EG
		
		new BFS().bfs(g);
	}
}
