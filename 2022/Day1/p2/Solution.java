/**
 * --- Part Two ---
 * By the time you calculate the answer to the Elves' question, 
 * they've already realized that the Elf carrying the most Calories of food 
 * might eventually run out of snacks.
 * 
 * To avoid this unacceptable situation, the Elves would instead like to know the 
 * total Calories carried by the top three Elves carrying the most Calories. 
 * That way, even if one of those Elves runs out of snacks, they still have two backups.
 * 
 * In the example above, the top three Elves are the fourth Elf (with 24000 Calories),
 * then the third Elf (with 11000 Calories), then the fifth Elf (with 10000 Calories).
 * The sum of the  * Calories carried by these three elves is 45000.
 * 
 * Find the top three Elves carrying the most Calories. How many Calories are those Elves carrying in total?
 */

import java.util.*;

public class Solution {
  public static void main(String[] args) {
    Scanner input = new Scanner(System.in);
    Queue<Integer> minHeap = new PriorityQueue<>(3, (a, b) -> a - b);
    while (input.hasNextLine()) {
      int total = getTotalCalories(input);
      minHeap.add(total);
      if (minHeap.size() > 3) {
        minHeap.remove();
      }
    }

    int totalTop3 = 0;
    while (!minHeap.isEmpty()) {
      int topN = minHeap.remove();
      totalTop3 += topN;
      System.out.println(topN);
    }
    System.out.println("Total calories of top 3 Elves = " + totalTop3);
  }

  public static int getTotalCalories(Scanner input) {
    int total = 0;
    while (input.hasNextLine()) {
      String line = input.nextLine();
      if (!line.isEmpty()) {
        total += Integer.parseInt(line);
      } else {
        break;
      }
    }
    return total;
  }
}
