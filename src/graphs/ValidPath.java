package graphs;

public class ValidPath {
	
	static void validPath(int[][] adjMatrix, int size) {
		 int row = 0;
         int col = 0;
         boolean isFound = false;
         for(int k = 0; k < size; k++){
             for(int l = 0; l < size; l++){
                 if(adjMatrix[k][l] == 1){
                     row = k;
                     col = l;
                     isFound = true;
                     break;
                 }
             }
             if(isFound)
            	 	break;
         }
         if(isPath(adjMatrix, row, col, size)){
             System.out.println("1");
         } else{
             System.out.println("0");
         }
	}
	static boolean isPath(int[][] adjMatrix, int row, int col, int size){
	    if(row < 0 || row >= size){
	        return false;
	    }
	    if(col < 0 || col >= size){
	        return false;
	    }
	    if(adjMatrix[row][col] == 0){
	        return false;
	    }
	    if(adjMatrix[row][col] == 2){
	        return true;
	    }
	    adjMatrix[row][col] = 0;
	    
	    return isPath(adjMatrix, row - 1, col, size) ||
	    isPath(adjMatrix, row + 1, col, size) ||
	    isPath(adjMatrix, row, col - 1, size) ||
	    isPath(adjMatrix, row, col + 1, size);
	}
	
	static void printMat(int[][] adjMatrix, int size) {
		for(int i = 0; i < size; i++) {
			for(int j = 0; j < size; j++) {
				System.out.print(adjMatrix[i][j] + " ");
			}
			System.out.println();
		}
		
	}
	
	public static void main(String[] args) {
		String s = "3 0 0 3 3 0 0 3 0 3 0 3 0 0 3 3 0 3 0 3 3 3 0 0 3 3 0 0 0 3 0 0 3 3 3 3 0 0 3 3 0 3 3 3 0 0 3 3 0 0 3 3 0 0 0 0 0 0 3 3 0 3 3 0 3 3 0 3 0 3 3 3 3 0 3 0 3 0 0 0 3 0 0 3 3 0 0 0 3 3 0 0 3 0 0 3 0 3 3 3 3 0 1 2 3 0 0 3 3 3 0 3 0 0 3 0 3 3 3 3 3 3 0 3 0 3 3 0 0 0 0 0 3 3 3 3 0 0 3 0 3 0 0 0 3 3 0 3 3 0 3 3 0 3 3 0 3 3 3 0 0 0 0 0 0 0 0 3 3 0 0 3 0 0 3 0 0 0 3 0 3 3 0 3 3 0 0 0 0 0 3 0 3 0 3 3 3 3 3 0 0 3 0 3 0 0 3 3 3 3 0 0 3 3 0 0 0 3 3 3 0 3 0 0 3"; 
		String[] arr = s.split(" ");
		int size = 15;
		int[][] adjMatrix = new int[size][size];
		int count = 0;
		for(int i = 0; i < size; i++) {
			for(int j = 0; j < size; j++) {
				adjMatrix[i][j] = Integer.parseInt(arr[count++]);
			}
		}
		printMat(adjMatrix, size);
		validPath(adjMatrix, size);
	}

}
