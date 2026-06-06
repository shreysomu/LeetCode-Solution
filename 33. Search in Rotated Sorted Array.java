class Solution {
    static int pivotIndex(int[] arr) {

    int s = 0;
    int e = arr.length - 1;

    if (arr[s] <= arr[e]) {
        return -1; // not rotated
    }

    while (s < e) {

        int mid = s + (e - s) / 2;

        if (arr[mid] >= arr[0]) {
            s = mid + 1;
        } else {
            e = mid;
        }
    }

    return s - 1;
}

    static int binarySearch(int[] arr, int target, int start, int end){

        while(start <= end){

            int mid = start + (end - start)/2;

            if(arr[mid] == target){
                return mid;
            }

            if(target > arr[mid]){
                start = mid + 1;
            }
            else{
                end = mid - 1;
            }
        }

        return -1;
    }

    static int search(int[] arr, int target){

        int pivot = pivotIndex(arr);
        int n = arr.length;

        if(pivot == -1){
            return binarySearch(arr, target, 0, n - 1);
        }

        if(target >= arr[0] && target <= arr[pivot]){
            return binarySearch(arr, target, 0, pivot);
        }

        return binarySearch(arr, target, pivot + 1, n - 1);
    }
}
