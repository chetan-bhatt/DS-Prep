package array;

public class MatrixMultiplication {

    public static void print(int n){
        int[][] arr = new int[12][12];

        for(int i = 0; i < n; i++){
            arr[i][0] = i + 1;
        }

        for(int i = 0; i < n; i++){
            if(i == 0){
                continue;
            }
            arr[0][i] = i + 1;
        }

        for(int i = 1; i < n; i++){
            for(int j = 1; j < n; j++){
                arr[i][j] = arr[i][0] * arr[0][j];
            }
        }

        display(arr);
    }

    private static void display(int[][] arr){
        for(int i = 0; i < arr.length; i++){
            for(int j = 0; j < arr[i].length; j++){
                System.out.print(arr[i][j] + " ");
            }
            System.out.println();

        }
    }

    public static void main(String[] args){
        print(12);
    }
}
