/**
 * --- Part Two ---
 * The Elf finishes helping with the tent and sneaks back over to you.
 * "Anyway, the second column says how the round needs to end: 
 * X means you need to lose, 
 * Y means you need to end the round in a draw, 
 * and Z means you need to win. Good luck!"
 * 
 * The total score is still calculated in the same way, 
 * but now you need to figure out what shape to choose so the round ends as indicated. 
 * The example above now goes like this:
 * 
 * In the first round, your opponent will choose Rock (A), 
 * and you need the round to end in a draw (Y), so you also choose Rock. This gives you a score of 1 + 3 = 4.
 * In the second round, your opponent will choose Paper (B), and you choose Rock so you lose (X) with a score of 1 + 0 = 1.
 * In the third round, you will defeat your opponent's Scissors with Rock for a score of 1 + 6 = 7.
 * Now that you're correctly decrypting the ultra top secret strategy guide, you would get a total score of 12.
 * 
 * Following the Elf's instructions for the second column, 
 * what would your total score be if everything goes exactly according to your strategy guide?
 */

import java.util.*;
 
public class Solution {
  public static void main(String[] args) {
    Scanner input = new Scanner(System.in);
    int totalScore = 0;
    while (input.hasNextLine()) {
      String line = input.nextLine();
      totalScore += getScore(line);
    }
    System.out.println("Total score = " + totalScore);
  }

  /**
   * Opponent:
   * - A: Rock
   * - B: Paper
   * - C: Scissor
   * Result:
   * - X: Lose
   * - Y: Draw
   * - Z: Win
   * 
   * Point logic:
   * - 1 for Rock
   * - 2 for Paper
   * - 3 for Scissors
   * 
   * - 0 for lost
   * - 3 for draw
   * - 6 for win
   * 
   * Rock: {
   *   Lose: Scissor
   *   Draw: Rock
   *   Win: Paper
   * }
   * Paper: {
   *   Lose: Rock
   *   Draw: Paper
   *   Win: Scissor
   * }
   * Scissor: {
   *   Lose: Paper
   *   Draw: Scissor
   *   Win: Rock
   * }
   * 
   * A: {
   *   X: 3
   *   Y: 1
   *   Z: 2
   * },
   * B: {
   *   X: 1
   *   Y: 2
   *   Z: 3
   * }
   * C: {
   *   X: 2
   *   Y: 3
   *   Z: 1
   * }
   */
  public static int getScore(String line) {
    Map<String, Map<String, Integer>> scoreMap = new HashMap<>();
    scoreMap.put("A", new HashMap<>());
    scoreMap.put("B", new HashMap<>());
    scoreMap.put("C", new HashMap<>());
    scoreMap.get("A").put("X", 3);
    scoreMap.get("A").put("Y", 1);
    scoreMap.get("A").put("Z", 2);
    scoreMap.get("B").put("X", 1);
    scoreMap.get("B").put("Y", 2);
    scoreMap.get("B").put("Z", 3);
    scoreMap.get("C").put("X", 2);
    scoreMap.get("C").put("Y", 3);
    scoreMap.get("C").put("Z", 1);

    Scanner lineScan = new Scanner(line);
    String opp = lineScan.next();
    String result = lineScan.next();
    lineScan.close();
    int myHandPoints = scoreMap.get(opp).get(result);
    if (result.equals("X")) {
      // Lose
      return myHandPoints;
    } else if (result.equals("Y")) {
      // Draw
      return myHandPoints + 3;
    } else {
      // Z: Win
      return myHandPoints + 6;
    }
  }
}