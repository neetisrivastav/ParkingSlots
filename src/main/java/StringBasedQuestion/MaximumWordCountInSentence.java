package StringBasedQuestion;

public class MaximumWordCountInSentence {

    public static void main(String[] args) {
        String s = "hello I m neeti ? cup of cofeee .";
        int maxCount = 0;
        String str[] = s.split(" ");
        int max =0;
        for(int i =0; i<str.length; i++)
        {

            if(str[i].equals("?")|| str[i].equals("."))
            {
                maxCount = Math.max(maxCount,max);
                max=0;
               // break;
            }
            else
            {
                max++;
            }
        }
        System.out.println(maxCount);
    }
}
