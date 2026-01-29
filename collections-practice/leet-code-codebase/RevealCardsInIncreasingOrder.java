import java.util.*;
class RevealCardsInIncreasingOrder {
    public static int[] revealCardsInIncreasingOrder(int [] arr){
        int [] revealCard = new int[arr.length];
        Arrays.sort(arr);
        Deque<Integer> dq = new LinkedList<>();
        for(int i=arr.length-1; i>=0; i--){
            if(!dq.isEmpty()){
                dq.addFirst(dq.removeLast());
            }
            dq.addFirst(arr[i]);
        }
        int idx = 0;
        for(int i: dq){
            revealCard[idx++] = i;
        }
        return revealCard;
    }
    public static void main(String[] args) {
        int [] arr = {17,13,11,2,3,5,7};
        System.out.println(Arrays.toString(revealCardsInIncreasingOrder(arr)));
    }
}