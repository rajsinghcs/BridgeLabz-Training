import java.util.*;
public class PenDistribution {
    public static void main(String args[]){
        int totalPens = 14;
        int totalstudents = 3;
        int penPerStudent = totalPens/totalstudents;
        int remainingPens = totalPens % totalstudents;
        System.out.println("The pen per student is " + penPerStudent + " and the remaining pens are not distributed is : " + remainingPens);
    }
}
