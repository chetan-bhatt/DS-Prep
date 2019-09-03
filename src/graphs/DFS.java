package graphs;

import java.util.Stack;

public class DFS {
	Vertex[] vertices;
	int[][] adjMatrix;
	int vertexCount;
	Stack<Integer> stack;
	
	public void dfs(Graph g) {
		vertices = g.vertices;
		adjMatrix = g.adjMatrix;
		vertexCount = g.vertexCount;
		
		stack = new Stack<>();
		dfsHelper();
		System.out.println();
		dfsRecursive(0);
	}
	
	private void dfsHelper() {
		vertices[0].isVisited = true;
		displayVertex(0);
		stack.push(0);
		
		while(!stack.isEmpty()) {
			int v = getUnvisitedVertex(stack.peek());
			if(v != -1) {
				vertices[v].isVisited = true;
				displayVertex(v);
				stack.push(v);
			} else {
				stack.pop();
			}
		}
		for(int i = 0; i < vertexCount; i++) {
			vertices[i].isVisited = false;
		}
	}
	
	private void dfsRecursive(int v) {
		if(v == vertexCount || v == -1) {
			return;
		}
		vertices[v].isVisited = true;
		displayVertex(v);
		
		for(int j = 0; j < vertexCount; j++) {
			if(adjMatrix[v][j] == 1 && vertices[j].isVisited == false) {
				dfsRecursive(j);		
			}
		}
	}
	
	private int getUnvisitedVertex(int v) {
		for(int j = 0; j < vertexCount; j++) {
			if(adjMatrix[v][j] == 1 && vertices[j].isVisited == false) {
				return j;
			}
		}
		return -1;
	}
	
	private void displayVertex(int v) {
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
		
		new DFS().dfs(g);
	}
}
