package graphs;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

class QueueItem{
	int row;
	int col;
	int distance;
	public QueueItem(int row, int col, int distance) {
		this.row = row;
		this.col = col;
		this.distance = distance;
	}
}

public class ShortestPathUndirected {
	
	static int isShortestPath(int[][] adjM, int size, int source, int dest) {
		int row = 0;
		int col = 0;
		boolean isFound = false;
		for(int i = 0; i < size; i++) {
			for(int j = 0; j < size; j++) {
				if(adjM[i][j] == source) {
					row = i;
					col = j;
					isFound = true;
					break;
				}
			}
			if(isFound) {
				break;
			}
		}
		
		return shortestPath(adjM, row, col, dest, size);
	}
	
	static int shortestPath(int[][] adjM, int row, int col, int dest, int size){
		QueueItem item = new QueueItem(row, col, 0);
		LinkedList<QueueItem> queue = new LinkedList<>();
		queue.add(item);
		while(!queue.isEmpty()) {
			item = queue.remove();
			if(adjM[item.row][item.col] == dest) {
				return item.distance;
			}
			List<QueueItem> adj = findAdjacent(adjM, item, size);
			for(QueueItem adjItem : adj) {
				queue.add(adjItem);
			}
		}
		return -1;
	}
	
	static List<QueueItem> findAdjacent(int[][] adjM, QueueItem item, int size){
		int row = item.row;
		int col = item.col;
		List<QueueItem> adj = new ArrayList<>();
		if(row - 1 >=0 && adjM[row-1][col] != 0) {
			adj.add(new QueueItem(row-1, col, item.distance + 1));
		}
		if(row + 1 < size && adjM[row+1][col] != 0) {
			adj.add(new QueueItem(row+1, col, item.distance + 1));
		}
		if(col - 1 >= 0 && adjM[row][col-1] != 0) {
			adj.add(new QueueItem(row, col-1, item.distance + 1));
		}
		if(col + 1 < size && adjM[row][col+1] != 0) {
			adj.add(new QueueItem(row, col+1, item.distance + 1));
		}
		return adj;
	}
	
	public static void main(String[] args) {
		int size = 3;
		int[][] adjM = new int [size][size];
		
		int[] nums = {1, 3, 3, 3, 0, 3, 3, 2, 3};
		int count = 0;
		
		for(int i = 0; i < size; i++) {
			for(int j = 0; j < size; j++) {
				adjM[i][j] = nums[count++];
			}
		}
		
		System.out.println(isShortestPath(adjM, size, 1, 2));
	}

}
