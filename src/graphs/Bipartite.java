package graphs;

public class Bipartite {
    public boolean isBipartite(int[][] graph) {
        int nodes = graph.length;
        int[] colors = new int[nodes];
        
        for(int i = 0; i < nodes; i++){
            if(colors[i] == 0 && !dfs(graph, colors, i, 1)){
                return false;
            }
        }
        return true;
    }
    
    private boolean dfs(int[][] graph, int[] colors, int current, int color){
        colors[current] = color;
        
        int[] neighbours = graph[current];
        for(int neighbour : neighbours){
            if(colors[neighbour] == colors[current]){
                return false;
            }
            
            if(colors[neighbour] == 0 && !dfs(graph, colors, neighbour, -color)){
                return false;
            }
        }
        return true;
    }
    
    public static void main(String[] args) {
    		int[][] graph = {{1,3}, {0,2}, {1,3}, {0,2}};
    		System.out.println(new Bipartite().isBipartite(graph));
    }
}