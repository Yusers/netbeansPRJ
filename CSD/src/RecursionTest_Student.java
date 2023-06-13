/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Project/Maven2/JavaApp/src/main/java/${packagePath}/${mainClassName}.java to edit this template
 */

package fptu.demo.recursiontest;

/**
 *
 * @author vinhvo
 */
public class RecursionTest_Student {
    
    public static long factorial_loop(int n) {
        long fact = ...;
        for (int i = 1; i <= ...; i++) {
            fact = ...;
        }
        return ...;
    }
  
    public static long factorial_recursion(int n) {
        if (n == 0)
          return ...;
        else
          return n * ...;
    }

     // Function to calculate N raised to the power P
    public static int power_recursion(int N, int P)
    {
        if (P == 0)
            return ...;
        else
            return ...;
    }
    
    public static int power_loop(int N, int P)
    {
        int pow = 1;
        for (int i = ...; i <= ...; i++)
            pow *= ...;
        return ...;
    }
 
    public static int binarySearch(int[] arr, int target)
    {
        // search space is nums[left…right]
        int left = 0, right = arr.length - 1;
 
        // loop till the search space is exhausted
        while (left <= right)
        {
            // find the mid-value in the search space and compare it with the target
            int mid = ... / 2;
 
            // target is found
            if (target == arr[...]) {
                return mid;
            }
 
            // discard all elements in the right search space, including the middle element
            else if (...) {
                right = mid - 1;
            }
 
            // discard all elements in the left search space, including the middle element
            else {
                left = mid + 1;
            }
        }
 
        // `target` doesn't exist in the array
        return ...;
    }
    
    public static int linearSearch(int arr[], int key, int size){
        int i;
        for(i = 0; i < size; i++)
            if(...)
                return i;
        
        return ...;
    }
          
    public static int recursivelybinarySearch(int arr[], int x, int low, int high) {
        if (low > high) 
            return -1;
        
        int mid = .../2;
        
        if (arr[..] == x) 
            return mid;
        else if (arr[mid] ... x) // go to the right
                return recursivelybinarySearch(arr, x, ..., ...);
             else // go to the left
                return recursivelybinarySearch(arr, x, ..., ...);
    }
  
    public static int recursivelylinearSearch(int arr[], int l, int r, int key)
    {
 
        // if r < l, it means that element is not present in
        // the array
        if (r < l)
            return -1;
 
        if (arr[l] == key)
            return ...;
 
        if (arr[r] == key)
            return ...;
 
        // Since element has not found on both left most and
        // rightmost boundary,ie at l and r, now recursive the
        // array to find position of x.
        return recursivelylinearSearch(arr, ..., ..., key);
    }
    
    public static int fibonacci_recursion(int n) 
    {
        if (n == 0 || n == 1)
            return ...; // base cases
        else
            return fibonacci_recursion(...) + fibonacci_recursion(...); // recursive step
    
    }
    
    public static int fibonacci_loop(int n)
    {
        /* Declare an array to store Fibonacci numbers. */
        int f[] = new int[n+2]; // 1 extra to handle case, n = 0
        int i;
      
        /* 0th and 1st number of the series are 0 and 1*/
        f[0] = ...;
        f[1] = ...;
     
        for (i = 2; i <= n; i++)
        {
            /* Compute the next number in the series and store it */
            f[i] = ...;
        }
      
        return ...;
    }
    
    public static boolean isOdd(int n) {
        if (n < 0) 
            throw new IllegalArgumentException("Can't accept negative arguments");
        
        return (n == 0) ? false : ...;
    }
     
    public static boolean isEven(int n) {
        if (n<0) 
            throw new IllegalArgumentException("Can't accept negative arguments");
        
        return (n == 0) ? true : ...;
    }
    
    // Driver code
    public static void main(String[] args)
    {
 
        //1. Write your code to test factorial numbers here
        
        System.out.println(factorial_loop(4));
        System.out.println(factorial_recursion(4));

        //2. Write your code to test power function here
        System.out.println(power_recursion(2, 3));
        System.out.println(power_loop(3, 2));
        
        
        //3. Write your code to test fibonacci here
        System.out.println(fibonacci_recursion(5));
        System.out.println(fibonacci_loop(5));
        
        //4. Write your code to test binarySearch here
        // Input array
        int arr[] = { 2, 3, 4, 10, 40 };
        // Length of array
        int n = arr.length;
        // Element to be checked if present or not
        int key = 10;
 
        // Calling the method binarySearch and
        // storing result
        int result = binarySearch(arr, key);
 
        // Element not present
        if (result == -1)
            // Print statement
            System.out.println("Element " + key + " not present");
 
        // Element present
        else
            // Print statement
            System.out.println("Element " + key + " found at index " + result);
        
        //5. Write your code to test recursivelylinearSearch here
        result = recursivelylinearSearch(arr, 0, n-1, 40);
        if (result == -1)
            // Print statement
            System.out.println("Element " + 40 + " not present");
 
        // Element not present
        else
            // Print statement
            System.out.println("Element " + 40 + " found at index " + result);
        
        //6. Write your code to test mutual recursion here
        int number = 4;
        if(isOdd(number))
            System.out.println(number + " is odd");
        else
            System.out.println(number + " is even");
    }
    
}//End Class Definition
