package binarysearch;

public class FirstElementLargerThan {
    /**
     * @param arr sorted integer array.
     * @param k
     * @return
     */
    private static int find(int[] arr, int k){

        int left = 0;
        int right = arr.length - 1;

        while(left <= right){
            int mid = left + (right - left)/2;

            if(arr[mid] == k + 1){
                return arr[mid];
            } else if(arr[mid] < k + 1){
                left = mid + 1;
            } else{
                right = mid - 1;
            }
        }
        if(left < arr.length)
            return arr[left];
        return -1;
    }

    public static void main(String[] args){
        System.out.println(find(new int[]{1, 2, 4, 5, 6}, 7));
    }
}
