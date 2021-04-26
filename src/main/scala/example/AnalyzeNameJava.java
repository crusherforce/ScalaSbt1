package example;

import java.util.Arrays;
import java.util.Scanner;

public class AnalyzeNameJava {
    public static void main (String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter your name : ");
        String line = sc.nextLine();
        String[] alphabets = new String[26];
        Arrays.fill(alphabets, "");
        line = line.toLowerCase();
        for (int i=0; i<line.length(); i++) {
            int index = line.charAt(i)-'a';
            alphabets[index] += (alphabets[index].isEmpty() ? "" : ",") + i;
        }
        for (int i=0; i<alphabets.length; i++) {
            if (!alphabets[i].isEmpty()) {
                System.out.print("'" + (char)(i +'a') + "' in places (");
                String[] indices = alphabets[i].split(",");
                System.out.print(indices.length + " occurrences ) : ");
                for (String index : indices) System.out.print(index + ' ');
                System.out.print('\n');
            }
        }
    }
}