package bsu.comp250;

public class Searching {
    String[] letters;//our array

    Searching(String[] a){//constructor
        letters = a;
    }

    public int sequentialSearch(String[] array, String x){//searches through one by one
        for(int i = 0; i <array.length;i++){
            if(array[i].equals(x)){
                return i;
            }
        }
        return -1;
    }

    public int binarySearch(String[] array, String key){//searches using the binary search method
        int L = 0;
        int R = array.length-1;
        while(L <= R){
            int mid = L+(R-L)/2;
            int half = key.compareTo(array[mid]);
            if(half==0)
                return mid;
            if(half>0)
                L = mid+1;
            else
                R = mid-1;
            }
        return -1;
        }
    }

