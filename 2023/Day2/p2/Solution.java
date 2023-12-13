import java.util.*;

public class Solution {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        // only 12 red cubes, 13 green cubes, and 14 blue cubes?

        int sum = 0;
        while (input.hasNextLine()) {
            String line = input.nextLine();
            String[] sets = line.split(":");
            sets = sets[1].split(";");
            sum += getPower(sets);
        }
        input.close();
        System.out.println(sum);
    }

    private static int getPower(String[] sets) {
        Map<String, Integer> minMap = new HashMap<>();
        minMap.put("red", 0);
        minMap.put("green", 0);
        minMap.put("blue", 0);

        for (String set : sets) {
            // [2 green, 3 blue, 1 red]
            String[] colors = set.split(",");
            for (String c : colors) {
                // [2, green]
                String[] count = c.trim().split(" ");
                minMap.put(count[1], Math.max(minMap.get(count[1]), Integer.parseInt(count[0])));
            }
        }
        
        int result = 1;
        for (String s : minMap.keySet()) {
            result *= minMap.get(s);
        }
        System.out.println(Arrays.toString(sets) + ", " + minMap + " = " + result);
        return result;
    }
}
