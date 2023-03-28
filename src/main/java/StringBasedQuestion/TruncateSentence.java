package StringBasedQuestion;

public class TruncateSentence {
    public static void main(String[] args) {
        String s = "Hello how are you Contestant";
        int k = 4;
        String str[] = s.split(" ");
        StringBuilder stringBuilder = new StringBuilder();
        for(int i=0; i< k; i++)
        {
            stringBuilder.append(str[i]+ " ");
        }
        System.out.println(stringBuilder.toString());
    }
}

