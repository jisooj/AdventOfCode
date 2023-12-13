import java.util.*;
import java.lang.*;
import java.io.*;

public class Solution {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        problem2(input);
    }

    private static void problem2(Scanner input) {
        Map<String, Integer> map = new HashMap<String, Integer>();
        String[] numbers = new String[] {
            "zero",
            "one",
            "two",
            "three",
            "four",
            "five",
            "six",
            "seven",
            "eight",
            "nine"
        };
        for (int i = 0; i < numbers.length; i++) {
            map.put(numbers[i], i);
            map.put(i + "", i);
        }
        int sum = 0;
        while (input.hasNextLine()) {
            String line = input.nextLine();
            Pair p = getIndex(line, map);
            sum += (p.first * 10 + p.last);
            // System.out.println(p.first + "" + p.last + " -> " + sum);
        }
        System.out.println(sum);
    }

    private static Pair getIndex(String line, Map<String, Integer> map) {
        int firstIndex = Integer.MAX_VALUE;
        int lastIndex = -1;
        Pair p = new Pair(0, 0);
        for (String s : map.keySet()) {
            int idx = line.indexOf(s);
            // int lastIdx = getLastIndex(line, s);
            int lastIdx = line.lastIndexOf(s);
            if (idx >= 0) {
                // 8one2one3one -> 81
                if (idx < firstIndex) {
                    p.first = map.get(s);
                    firstIndex = idx;
                }
                if (lastIndex < lastIdx) {
                    p.last = map.get(s);
                    lastIndex = lastIdx;
                }
            }
        }
        return p;
    }

    static class Pair {
        int first;
        int last;
        public Pair(int first, int last) {
            this.first = first;
            this.last = last;
        }
    }
}