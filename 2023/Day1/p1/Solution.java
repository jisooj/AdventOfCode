import java.util.*;
import java.lang.*;
import java.io.*;

public class Solution {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        problem1(input);
    }
    
    private static void problem1(Scanner input) {
        int sum = 0;
        while (input.hasNextLine()) {
            String line = input.nextLine();
            int first = -1;
            int last = -1;
            for (char ch : line.toCharArray()) {
                if (Character.isDigit(ch)) {
                    if (first < 0) {
                        first = ch - '0';
                    }
                    last = ch - '0';
                }
            }
            sum += (first * 10 + last);
        }
        System.out.println(sum);
    }
}