package graphs;

import java.util.ArrayList;
import java.util.Arrays;

public class CaptureRegion {

	public void solve(ArrayList<ArrayList<Character>> a) {
        Character[][] adjMat = new Character[a.size()][a.get(0).size()];
        for(int i = 0; i < a.size(); i++){
            for(int j = 0; j < a.get(i).size(); j++){
                adjMat[i][j] = a.get(i).get(j);
            }
        }
        
        for(int i = 0; i < adjMat.length; i++){
            for(int j = 0; j < adjMat[i].length; j++){
                if(adjMat[i][j] == 'O'){
                    adjMat[i][j] = '-';
                }
            }
        }
        
        for(int i = 0; i < adjMat.length; i++){
            if(adjMat[i][0] == '-')
                floodFill(adjMat, i, 0, '-', 'O');
            if(adjMat[i][adjMat[i].length-1] == '-')
                floodFill(adjMat, i, adjMat[i].length -1, '-', 'O');
        }
        
        for(int j = 0; j < adjMat[0].length; j++){
            if(adjMat[0][j] == '-')
                floodFill(adjMat, 0, j, '-', 'O');
            if(adjMat[adjMat.length-1][j] == '-')
                floodFill(adjMat, adjMat.length-1, j, '-', 'O');
        }
        
        a = new ArrayList<>();
        for(int i = 0; i < adjMat.length; i++){
            ArrayList<Character> list = new ArrayList<>();
            for(int j = 0; j < adjMat[i].length; j++){
                if(adjMat[i][j] == '-'){
                    adjMat[i][j] = 'X';
                }
                list.add(adjMat[i][j]);
            }
            a.add(list);
        }
        a.forEach(list ->{
        		System.out.println(Arrays.toString(list.toArray()));
        		System.out.println();
        });
	}
    
    private void floodFill(Character[][] adjMat, int x, int y, Character prev, Character curr){
        if(x < 0 || x >= adjMat.length){
            return;
        }
        if(y < 0 || y >= adjMat[x].length){
            return;
        }
        if(prev != curr){
            adjMat[x][y] = curr;
        }
        
        floodFill(adjMat, x-1, y, prev, curr);
        floodFill(adjMat, x+1, y, prev, curr);
        floodFill(adjMat, x, y-1, prev, curr);
        floodFill(adjMat, x, y+1, prev, curr);
    }
    
    public static void main(String[] args) {
		ArrayList<ArrayList<Character>> input = new ArrayList<>();
    		ArrayList<Character> list = new ArrayList<>();
		list.add('X'); list.add('X'); list.add('X');
		input.add(list);
		list = new ArrayList<>();
		list.add('X'); list.add('O'); list.add('X');
		input.add(list);
		list = new ArrayList<>();
		list.add('X'); list.add('X'); list.add('X');
		input.add(list);
		
		new CaptureRegion().solve(input);
	}
}
