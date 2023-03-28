package StringBasedQuestion;

public class SentenceSorting {
    public static void main(String[] args) {
      String s = "is2 sentence4 This1 a3";
      String str[] = s.split(" ");
      int index = 0;
        String arr1[] = new String[str.length];
      StringBuilder stb = new StringBuilder();
      for(int i =0; i< str.length ; i++)
      {
          index  = str[i].charAt(str[i].length()-1)-'0';
          arr1[index-1] = str[i].substring(0,str[i].length()-1);

      }
        for(String s1 : arr1)
        {
            stb.append(s1+" ");
        }

        System.out.println(stb.toString().substring(0,stb.length()-1));
      //"This is a sentence"
    }

}
