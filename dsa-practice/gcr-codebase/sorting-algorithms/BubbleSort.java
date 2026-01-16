// Worst Case -	O(n²)	Occurs when the array is sorted in reverse order. 
// Average Case - O(n²)	Occurs when the elements are in a jumbled or random order. 
// Best Case - O(n)	Occurs when the array is already sorted.

import java.util.*;
public class BubbleSort {
    public static void sortStudentMarks(int[] student_marks){
        int len = student_marks.length;
        int temp = 0;
        for(int i=0; i<len; i++){
            for(int j=i+1; j<len; j++){
                if(student_marks[i] > student_marks[j]){
                    temp = student_marks[i];
                    student_marks[i] = student_marks[j];
                    student_marks[j]= temp;
                }
            }
        }
    }
    public static void main(String [] args){
        int[] student_marks = {33,90,45,92,45,80};
        sortStudentMarks(student_marks);
        System.out.println(Arrays.toString(student_marks));
    }
}
