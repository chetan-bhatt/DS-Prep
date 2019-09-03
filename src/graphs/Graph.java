package graphs;

class Vertex{
	public char label;
	public boolean isVisited = false;
	
	public Vertex(char label) {
		this.label = label;
	}
}


public class Graph {
	public int maxVertices;
	public Vertex[] vertices;
	public int[][] adjMatrix;
	public int vertexCount;
	
	public Graph(int maxVertices) {
		this.maxVertices = maxVertices;
		vertices = new Vertex[maxVertices];
		adjMatrix = new int[maxVertices][maxVertices];
		for(int i = 0; i < maxVertices; i++) {
			for(int j = 0; j < maxVertices; j++) {
				adjMatrix[i][j] = 0;
			}
		}
	}
	
	public void addVertex(char label) {
		vertices[vertexCount++] = new Vertex(label);
	}
	
	public void addEdge(int start, int end) {
		if(start < maxVertices && end < maxVertices) {
			adjMatrix[start][end] = 1;
			adjMatrix[end][start] = 1;
		}
	}
}
