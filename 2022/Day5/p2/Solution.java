/**
 * --- Part Two ---
 * As you watch the crane operator expertly rearrange the crates, you notice the process isn't following your prediction.
 * Some mud was covering the writing on the side of the crane, and you quickly wipe it away. 
 * The crane isn't a CrateMover 9000 - it's a CrateMover 9001.
 * The CrateMover 9001 is notable for many new and exciting features: air conditioning, 
 * leather seats, an extra cup holder, and the ability to pick up and move multiple crates at once.
 * Again considering the example above, the crates begin in the same configuration:
 * 
 *     [D]    
 * [N] [C]    
 * [Z] [M] [P]
 *  1   2   3 
 * Moving a single crate from stack 2 to stack 1 behaves the same as before:
 * 
 * [D]        
 * [N] [C]    
 * [Z] [M] [P]
 *  1   2   3 
 * However, the action of moving three crates from stack 1 to stack 3 means that those 
 * three moved crates stay in the same order, resulting in this new configuration:
 * 
 *         [D]
 *         [N]
 *     [C] [Z]
 *     [M] [P]
 *  1   2   3
 * Next, as both crates are moved from stack 2 to stack 1, they retain their order as well:
 * 
 *         [D]
 *         [N]
 * [C]     [Z]
 * [M]     [P]
 *  1   2   3
 * Finally, a single crate is still moved from stack 1 to stack 2, but now it's crate C that gets moved:
 * 
 *         [D]
 *         [N]
 *         [Z]
 * [M] [C] [P]
 *  1   2   3
 * In this example, the CrateMover 9001 has put the crates in a totally different order: MCD.
 * 
 * Before the rearrangement process finishes, update your simulation so that the Elves know where 
 * they should stand to be ready to unload the final supplies. 
 * After the rearrangement procedure completes, what crate ends up on top of each stack?
 */

 import java.util.*;

public class Solution {
  /**
                    [B] [L]     [J]    
                [B] [Q] [R]     [D] [T]
                [G] [H] [H] [M] [N] [F]
            [J] [N] [D] [F] [J] [H] [B]
        [Q] [F] [W] [S] [V] [N] [F] [N]
    [W] [N] [H] [M] [L] [B] [R] [T] [Q]
    [L] [T] [C] [R] [R] [J] [W] [Z] [L]
    [S] [J] [S] [T] [T] [M] [D] [B] [H]
    1   2   3   4   5   6   7   8   9 
   */
  public static void main(String[] args) {
    List<Stack<Character>> stacks = new ArrayList<Stack<Character>>();
    String[] initialState = new String[] {
      "SLW",
      "JTNQ",
      "SCHFJ",
      "TRMWNGB",
      "TRLSDHQB",
      "MJBVFHRL",
      "DWRNJM",
      "BZTFHNDJ",
      "HLQNBFT"
    };

    for (int i = 0; i < 9; i++) {
      var stack = new Stack<Character>();
      for (char ch : initialState[i].toCharArray()) {
        stack.push(ch);
      }
      stacks.add(stack);
    }
    System.out.println(stacks);
    System.out.println("---------");
    
    Scanner in = new Scanner(System.in);
    while (in.hasNextLine()) {
      String line = in.nextLine();
      runCommand(line, stacks);
    }
    System.out.println(stacks);
    System.out.println("---------");
    StringBuilder sb = new StringBuilder();
    for (Stack<Character> stack : stacks) {
      if (!stack.isEmpty()) {
        sb.append(stack.pop());
      }
    }
    in.close();
    System.out.println("Message = " + sb.toString());
  }

  // move 5 from 4 to 5
  public static void runCommand(String command, List<Stack<Character>> stacks) {
    int fromIndex = command.indexOf("from");
    int toIndex = command.indexOf("to");

    int move = Integer.parseInt(command.substring(5, fromIndex).trim());
    int from = Integer.parseInt(command.substring(fromIndex + 5, toIndex).trim()) - 1; // 1 based indexing to 0 base
    int to = Integer.parseInt(command.substring(toIndex + 3).trim()) - 1;

    System.out.println("move " + move + " from " + from + " to " + to);

    Stack<Character> fromStack = stacks.get(from);
    Stack<Character> toStack = stacks.get(to);
    Stack<Character> temp = new Stack<>();
    for (int i = 0; i < move; i++) {
      if (!fromStack.isEmpty()) {
        temp.push(fromStack.pop());
      }
    }

    while (!temp.isEmpty()) {
      toStack.push(temp.pop());
    }
  }
}