package com.sort;

import org.json.simple.*;

public class InsertionSort {

private static int count = 0;

  public static void main(String[] args) {
    String fileName =
      "/Users/akarshshetty/Documents/GitHub/Lovelace_Cupcake/lovelace_cupcakes/src/main/java/com/sort/cupcake_3906.json";
    // String fileName =
    //   "/Users/jerom/Documents/GitHub/class-java/sort/demo/src/main/java/com/sort/cupcake_10.json";
    // String fileName =
    //   "/Users/jerom/Documents/GitHub/class-java/sort/demo/src/main/java/com/sort/cupcake_test.json";

    // read cupcake names
    JSONArray cupcakeArray = JSONFile.readArray(fileName);
    String[] cupcakeNameArray = nameArray(cupcakeArray);
    System.out.println(cupcakeNameArray);

    // print unsorted list
    System.out.println("----- Unsorted array -----");
    print(cupcakeNameArray);

    // sort
    InsertionSort(cupcakeNameArray);

    // print sorted list
    System.out.println("----- Sorted array----- ");
    print(cupcakeNameArray);

    System.out.println("----- Statistics -----");
    System.out.printf("Size of array = %d\n", cupcakeNameArray.length);
    System.out.printf("Count = %d\n", count);
  }

  // print array
  public static void print(String[] arr) {
    System.out.printf("Number\tName\n");
    System.out.printf("------\t---------------\n");
    for (int i = 0; i < arr.length; i++) {
      System.out.printf("%04d\t%s\n", i, arr[i]);
    }
  }

  // print array
  public static void print(String[] arr, int left, int right) {
    System.out.printf("Number\tName\n");
    System.out.printf("------\t---------------\n");
    for (int i = left; i < right; i++) {
      System.out.printf("%04d\t%s\n", i, arr[i]);
    }
  }

  // get array of cupcake names
  public static String[] nameArray(JSONArray cupcakeArray) {
    String[] arr = new String[cupcakeArray.size()];

    // get names from json object
    for (int i = 0; i < cupcakeArray.size(); i++) {
      JSONObject o = (JSONObject) cupcakeArray.get(i);
      String name = (String) o.get("name");
      arr[i] = name;
    }
    return arr;
  }
//peepoo

  public static void InsertionSort(String[] arr) {
    // make i =1, not 0 as the first value (0), wont't hav anything before it
   for (int i =1; i < arr.length; i++){
    // create value j, to be the pointer to the values before
    int j = i - 1;
    String value = arr[i];

    // make sure we aren't comparing with our current value with a -j index as it would go to the end
     while (j > 0 && arr[j].compareTo(value) >  0) {
      // we can't replace with i 
      arr[j+1] =arr[j];
      j -= 1;
     }
     //then put the value in the right place, which will be 1 higher j, due to the j -= 1, syntax at the end of the while loop
     arr[j+1] = value;
   }
  }
}

