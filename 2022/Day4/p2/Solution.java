/**
 * --- Part Two ---
 * It seems like there is still quite a bit of duplicate work planned.
 * Instead, the Elves would like to know the number of pairs that overlap at all.
 * 
 * In the above example, the first two pairs (2-4,6-8 and 2-3,4-5) don't overlap,
 * while the remaining four pairs (5-7,7-9, 2-8,3-7, 6-6,4-6, and 2-6,4-8) do overlap:
 * 
 * 5-7,7-9 overlaps in a single section, 7.
 * 2-8,3-7 overlaps all of the sections 3 through 7.
 * 6-6,4-6 overlaps in a single section, 6.
 * 2-6,4-8 overlaps in sections 4, 5, and 6.
 * So, in this example, the number of overlapping assignment pairs is 4.
 * 
 * In how many assignment pairs do the ranges overlap?
 */

import java.util.*;

public class Solution {
  public static void main(String[] args) {
    Scanner input = new Scanner(System.in);
    int count = 0;
    while (input.hasNextLine()) {
      String line = input.nextLine();
      String[] pair = line.split(",");
      if (isOverlap(pair[0], pair[1])) {
        count++;
      }
    }
    input.close();
    System.out.print("Overlaping pair count = " + count);
  }

  public static boolean isOverlap(String s1, String s2) {
    String[] r1 = s1.split("-");
    String[] r2 = s2.split("-");
    int[] range1 = new int[] { Integer.parseInt(r1[0]), Integer.parseInt(r1[1]) };
    int[] range2 = new int[] { Integer.parseInt(r2[0]), Integer.parseInt(r2[1]) };

    int upperRangeStart = range1[0];
    int[] upperRange = range1;
    int[] lowerRange = range2;
    if (range2[0] > range1[0]) {
      upperRangeStart = range2[0];
      upperRange = range2;
      lowerRange = range1;
    }
    return lowerRange[0] <= upperRangeStart && upperRangeStart <= lowerRange[1];
  }
}
