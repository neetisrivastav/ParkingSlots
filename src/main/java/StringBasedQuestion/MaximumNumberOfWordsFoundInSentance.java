package StringBasedQuestion;

public class MaximumNumberOfWordsFoundInSentance {
    public static void main(String[] args) {
        String[] sentences = {"alice and bob love leetcode", "i think so too", "this is great thanks very much"};
        int max = 0, m = 0;
        for(int i =0; i< sentences.length; i++)
        {
            m = sentences[i].split(" ").length;
            if(m>max)
            {
                max = m;
            }

        }
        //return max;
        System.out.println("maximum word:"+max);
    }
}
