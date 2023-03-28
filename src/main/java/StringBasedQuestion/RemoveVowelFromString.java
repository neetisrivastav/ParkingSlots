package StringBasedQuestion;

import java.util.HashSet;
import java.util.Scanner;
import java.util.Set;

public class RemoveVowelFromString {

    public static void main(String[] args)
    {
        Scanner sc = new Scanner(System.in);
        String s = sc.nextLine();
        for (int i = 0; i < s.length(); i++) {
            if (s.charAt(i) == 'a' || s.charAt(i) == 'e'
                    || s.charAt(i) == 'i' || s.charAt(i) == 'o'
                    || s.charAt(i) == 'u' || s.charAt(i) == 'A'
                    || s.charAt(i) == 'E' || s.charAt(i) == 'I'
                    || s.charAt(i) == 'O'
                    || s.charAt(i) == 'U') {
                continue;
            }
            else {
                System.out.print(s.charAt(i));
            }
        }
    }

    public int numJewelsInStones(String jewels, String stones) {
        int res = 0;
        Set setf = new HashSet();
        for(char j: jewels.toCharArray())
        {
            setf.add(j);
        }
        for (char s : stones.toCharArray())
        {
            if(setf.contains(s))
                res++;
        }

        return res;
    }

}
