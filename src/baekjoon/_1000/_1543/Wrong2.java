package baekjoon._1000._1543;

    import java.io.*;

public class Wrong2 {

    public static int count = 0;
    public static int nextIndex = 0;

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        String paragraph = br.readLine();
        String word = br.readLine();

        String[] words = paragraph.split("");
        String[] oneLetterByOneLetter = word.split("");


        for (nextIndex = 0; nextIndex < words.length; nextIndex++) {

            if(words[nextIndex].equals(oneLetterByOneLetter[0])){
                if(words.length-nextIndex>=oneLetterByOneLetter.length){
                    for(int j = 1; j < oneLetterByOneLetter.length; j++){
                        if(!oneLetterByOneLetter[j].equals(words[nextIndex+j])){
                            break;
                        }
                        if(j==oneLetterByOneLetter.length-1){
                            count++;
                            nextIndex = nextIndex + oneLetterByOneLetter.length-1;
                        }
                    }
                }
            }

        }

        String s = String.valueOf(count);

        bw.write(s + "\n");
        bw.flush();
        bw.close();
        br.close();
    }

}