import java.util.*;

public class Solution {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        // only 12 red cubes, 13 green cubes, and 14 blue cubes?

        int sum = 0;
        int id = 1;
        while (input.hasNextLine()) {
            String line = input.nextLine();
            String[] sets = line.split(":");
            sets = sets[1].split(";");
            boolean isValid = true;
            for (String set : sets) {
                if (!isValidSet(set)) {
                    isValid = false;
                    break;
                }
            }

            if (isValid) {
                sum += id;
            }
            id++;
        }
        input.close();
        System.out.println(sum);
    }

    private static boolean isValidSet(String set) {
        Map<String, Integer> maxMap = new HashMap<>();
        maxMap.put("red", 12);
        maxMap.put("green", 13);
        maxMap.put("blue", 14);
        // [2 green, 3 blue, 1 red]
        String[] colors = set.split(",");
        for (String c : colors) {
            // [2, green]
            String[] count = c.trim().split(" ");
            if (maxMap.get(count[1]) < Integer.parseInt(count[0])) {
                return false;
            }
        }
        return true;
    }
}
