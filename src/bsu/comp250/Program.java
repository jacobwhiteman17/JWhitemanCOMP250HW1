package bsu.comp250;

import java.util.Arrays;
import java.util.Scanner;

public class Program {
    private String[] array;//the array

    Program(){//constructor with array we will be using
        array = new String[0];//the array we will use
    }

    private void printMenu(){//prints main menu
        System.out.println("    [1] Read");
        System.out.println("    [2] Print");
        System.out.println("    [3] Sort");
        System.out.println("    [4] Search");
        System.out.println("    [0] Quit");
    }

    private void printSearchMenu(){//prints search menu
        System.out.println("    [1] Sequential Search");
        System.out.println("    [2] Binary Search");
        System.out.println("    [0] Quit");
    }

    private void printSortMenu(){//prints sort menu
        System.out.println("    [1] Quick Sort");
        System.out.println("    [2] Merge Sort");
        System.out.println("    [0] Quit");
    }

    public String[] add(String[] array, String letter){//method that allows us to add to our array by essentially turning it into a new array
        String[] newArray = new String[array.length+1];//the new array with a greater length
        System.arraycopy(array, 0, newArray, 0, array.length);
        newArray[array.length] = letter;
        return newArray;
    }
    public void runProgram(){//catalyst for our program
        var input = new Scanner(System.in);//scanner
        while(true){//creates our program until we quit out
            printMenu();
            var userResponse = input.nextInt();//response to menu
            input.nextLine();
            switch(userResponse){
                case 1:
                    System.out.println("Input a letter: ");
                    var addElement = input.next();//element added
                    array = add(array, addElement);//updates array
                    System.out.println("Element Added");
                    break;
                case 2:
                    System.out.println(Arrays.toString(array));
                    break;
                case 3:
                    Sorting sort = new Sorting(array);//sorting object
                    printSortMenu();
                    var sortResponse = input.nextInt();//response to sort menu
                    input.nextLine();
                    switch(sortResponse){
                        case 1:
                            sort.quickSort(0, array.length-1,array);
                            System.out.println(Arrays.toString(array));
                            break;
                        case 2:
                            sort.mergeSort(0, array.length-1, array);
                            System.out.println(Arrays.toString(array));
                            break;
                        case 0:
                            System.exit(0);
                        default:
                            System.out.println("Try again");
                    }
                case 4:
                    Searching search = new Searching(array);//searching object
                    printSearchMenu();
                    var searchResponse = input.nextInt();//response to search menu
                    input.nextLine();
                    switch(searchResponse){
                        case 1:
                            System.out.println("What letter are you searching for?");
                            var key = input.nextLine();//which letter is typed in
                            int seq = search.sequentialSearch(array, key);//sequential search on the array
                            if(seq==-1)
                                System.out.println("Its not here");
                            else
                                System.out.println("It is at index: "+seq);
                            break;
                        case 2:
                            System.out.println("What letter are you searching for?");
                            var key2 = input.nextLine();//input
                            int bin = search.binarySearch(array, key2);//binary search on array
                            if(bin==-1)
                                System.out.println("Its not here");
                            else
                                System.out.println("It is at index: "+bin);
                            break;
                        case 0:
                            System.exit(0);
                        default:
                            System.out.println("Try again");
                    }
                case 0:
                    System.exit(0);
                default:
                    System.out.println("Try again");
            }
        }
    }
}
