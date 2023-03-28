package StringBasedQuestion;

import java.util.HashMap;
import java.util.Map;

public class MaximumNumberOfWords {

    public static void main(String[] args) {
        int[] arr = {1,4,5,4,5};
        int max= 0;
        Map<Integer, Boolean> exist= new HashMap<>();
        for (int i = 0; i<arr.length ; i++){
            if(max < arr[i]) {
                max = arr[i];
            }
        }
        max++;
        int sum = 0;
        for (int i = 0; i<arr.length ; i++){
            if(exist.get(arr[i]) != null && exist.get(arr[i])){
                exist.put(max, true);
                sum = sum + max;
                max = max+1;
            }else{
                sum = sum + arr[i];
                exist.put(arr[i], true);
            }
        }
        System.out.println(sum);
    }
}
