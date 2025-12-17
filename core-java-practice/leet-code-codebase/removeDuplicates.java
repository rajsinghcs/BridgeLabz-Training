import java.util.*;

class removeDuplicates {
    public int RemoveDuplicates(int[] arr) {
        // Use a LinkedHashSet to store only unique values
        Set<Integer> uniqueElements = new LinkedHashSet<>();
        
        // Traverse the array and add elements to the set
        for (int num : arr) {
            uniqueElements.add(num);
        }

        // Write the unique elements back into the original array
        int index = 0;
        for (int value : uniqueElements) {
            arr[index++] = value;
        }

        // Return the number of unique elements
        return uniqueElements.size();
    }

    // Main method to test the removeDuplicates function
    public static void main(String[] args) {
        removeDuplicates v = new removeDuplicates();
        
        int[] testArray = {1, 1, 2, 3, 3, 4, 5, 5, 5};
        
        int newLength = v.RemoveDuplicates(testArray);
        
        System.out.println("Number of unique elements: " + newLength);
        System.out.print("Array after removing duplicates: ");
        for (int i = 0; i < newLength; i++) {
            System.out.print(testArray[i] + " ");
        }
    }
}
