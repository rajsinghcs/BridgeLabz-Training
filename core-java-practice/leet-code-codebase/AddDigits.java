import java.util.*;
public class AddDigits {
    public int addDigits(int num) {
        while(num > 9){
            int res =0;
            while(num > 0){
                res += num%10;
                num /= 10;
            }
            num = res;
        }

        return num;

    }
    public static void main(String[] args) {
        AddDigits ad = new AddDigits();
        int num = 38;
        System.out.println(ad.addDigits(num)); // Output: 2
    }
}