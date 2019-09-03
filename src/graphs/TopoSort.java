package graphs;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Stack;

class TopoSort
{
	static int[] topoSort(List<List<Integer>> list, int N)
    {
       // add your code here
       boolean[] visited = new boolean[N];
       Stack<Integer> stack = new Stack<>();
       for(int i = 0; i < N; i++){
           if(!visited[i]){
                topoSort(i, list, visited, stack);    
           }
       }
       int[] result = new int[N];
       int count = 0;
       while(!stack.isEmpty()){
           result[count++] = stack.pop();
       }
       return result;
    }
	
    static void topoSort(int vertex, List<List<Integer>> adjList, boolean[] visited, Stack<Integer> stack){
        visited[vertex] = true;
        List<Integer> adjacents = adjList.get(vertex);
        for(Integer a : adjacents){
            if(!visited[a]){
                topoSort(a, adjList, visited, stack);
            }
        }
        stack.push(vertex);
    }
    
    public static void main(String[] args) {
    		List<List<Integer>> input = new ArrayList<>();
    		input.add(new ArrayList<>());	// vertex 0
    		List<Integer> list = new ArrayList<>();
    		list.add(3);
    		input.add(list);					// vertex 1
    		list = new ArrayList<>();
    		list.add(3);
    		input.add(list);					// vertex 2
    		list = new ArrayList<>();
    		list.add(1);
    		input.add(list);					// vertex 3
    		list = new ArrayList<>();
    		list.add(0); list.add(1);
    		input.add(list);					// vertex 4
    		list= new ArrayList<>();
    		list.add(1); list.add(2);
    		input.add(list);					// vertex 5
    		int[] result = topoSort(input, 6);
    		int count = 0;
    		for(List<Integer> e : input) {
    			System.out.println(" vertex: " + (count++) + " is directed to " + Arrays.toString(e.toArray()));
    		};
    		System.out.print(Arrays.toString(result));

    }
}
