package bsu.comp250;

public class Sorting {
    String[] letters;//our array

    Sorting(String[]a){
        letters = a;
    }//constructor class

    public void swap(int x, int y){//the swap method that allows two characters to swap
        String temp = this.letters[x];//the temporary var that allows the swap
        this.letters[x] = this.letters[y];
        this.letters[y] = temp;
    }

    public void quickSort(int left, int right, String[] array){//this is the quicksort method that will be called, using the 2 cursors and comparing them to the pivot
        int L = left;//the left cursor
        int R = right;//the right cursor
        String P = array[L+(R-L)/2];
        while(L<=R){//left should always be smaller or equal to right
            while(array[L].compareTo(P)<0)//when left is smaller, increase
                L++;
            while(array[R].compareTo(P)>0)//when right is bigger, decrease
                R--;
            if(L<=R){//when left is less than or equal to right, swap them, make left bigger and right smaller
                swap(L,R);
                L++;
                R--;
            }
            if(left<R)//calling quickSort recursively on left
                quickSort(left,R, array);
            if(L<right)//calling quickSort recursively on right
                quickSort(L,right, array);
        }
    }

    public void merge(int left, int middle, int right, String[] array){
        int range = right-left+1;//size of halves
        String[] newArray = new String[range];//will need a new array list for the merged halves to go into
        int x = left;//first element in the left half
        int y = middle+1;//first element in the right half
        int z = 0;//open pos in our new array
        while(x<=middle && y<=right){//while left and right halves are smaller than or equal to, append the old arrays to our new array in different circumstances
            if(array[x].compareTo(array[y])<0){
                newArray[z]=array[x];
                x++;
            }
            else{
                newArray[z] = array[y];
                y++;
            }
            z++;
        }
        while(x<=middle){
            newArray[z] = array[x];
            x++;
            z++;
        }
        while(y<=right){
            newArray[z]=array[y];
            y++;
            z++;
        }
        for(z = 0; z < range; z++)
            array[left+z] = newArray[z];
    }

    public void mergeSort(int left, int right, String[] array){//merge sort method that will be called. recursively called twice to sort the two halves, then merge is used to sort the two halves into one
        if(left == right)
            return;
        int middle = (left+right)/2;//mid point that divides the array
        mergeSort(left, middle, array);
        mergeSort(middle+1, right, array);
        merge(left, middle, right, array);
    }

}
