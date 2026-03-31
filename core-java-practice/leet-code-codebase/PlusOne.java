import java.util.Arrays;
public class PlusOne {
    public int[] plusOne(int[] digits) {
        int n = digits.length;
		for(int i = n-1; i>=0;i--){
            if(digits[i] != 9){
                digits[i]++;
                break;
            }else{
                digits[i] = 0;
            }
        }
        if(digits[0]== 0){
            int[] newArray = new int[n+1];
            newArray[0] = 1;
            return newArray;
        }
        return digits;
    }
    public static void main(String[] args) {
        PlusOne po = new PlusOne();
        int[] digits = {1,2,3};
        System.out.println(Arrays.toString(po.plusOne(digits)));
    }
}
