package binarysearch;

/**
 * Searches for a target in a sorted array of unknown length
 *
 */
public class SearchInArrOfUnknownLength {

    private static int find(int[] arr, int k){

        int start = 0;
        int end = 1;
        end = getValidIndex(arr, end);

        while(start < end){
            int value = binarySearch(arr, start, end, k);
            if(value != -1){
                return value;
            }
            start = end;
            end = getValidIndex(arr, end * 2);
        }

        // this means start and end are equal, just check if it is pointing to the target.
        if(arr[start] == k){
            return start;
        }
        return -1;
    }

    private static int binarySearch(int[] arr, int start, int end, int k){
        while(start <= end){
            int mid = start + (end - start)/2;
            if(arr[mid] == k){
                return mid;
            } else if(arr[mid] < k){
                start = mid + 1;
            } else{
                end = mid - 1;
            }
        }
        return -1;
    }

    private static int getValidIndex(int[] arr, int index){
        try {
            int value = arr[index];
        }catch(ArrayIndexOutOfBoundsException e){
            // the passed index is not valid, hence decrement and try again.
            return getValidIndex(arr, index-1);
        }
        return index;
    }

    public static void main(String[] args){
        int[] arr = {1, 2, 3, 4, 5, 6, 7, 8};

        System.out.println(find(arr, 8));
    }
}
