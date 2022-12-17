/**
 * --- Part Two ---
 * Your device's communication system is correctly detecting packets, but still isn't working. It looks like it also needs to look for messages.
 * 
 * A start-of-message marker is just like a start-of-packet marker, except it consists of 14 distinct characters rather than 4.
 * 
 * Here are the first positions of start-of-message markers for all of the above examples:
 * 
 * mjqjpqmgbljsphdztnvjfqwrcgsmlb: first marker after character 19
 * bvwbjplbgvbhsrlpgdmjqwftvncz: first marker after character 23
 * nppdvjthqldpwncqszvftbrmjlhg: first marker after character 23
 * nznrnfrfntjfmvfwmzdfjlvtqnbhcprsg: first marker after character 29
 * zcfzfwzzqfrljwzlrfnpqdbhtmscgvjw: first marker after character 26
 * How many characters need to be processed before the first start-of-message marker is detected?
 */

import java.util.*;

public class Solution {
  public static final int MARKER = 14;

  public static void main(String[] args) {
    Scanner in = new Scanner(System.in);
    String line = in.nextLine();
    in.close();
    System.out.println(getOffset(line));
  }

  public static int getOffset(String s) {
    Map<Character, Integer> map = new HashMap<>();
    Queue<Character> q = new LinkedList<>();
    int offset = 0;
    for (char ch : s.toCharArray()) {
      if (q.size() == MARKER) {
        char key = q.remove();
        map.put(key, map.get(key) - 1);
        if (map.get(key) == 0) {
          map.remove(key);
        }
      }

      q.add(ch);
      offset++;
      if (!map.containsKey(ch)) {
        map.put(ch, 0);
      }
      map.put(ch, map.get(ch) + 1);

      if (map.size() == MARKER) {
        break;
      }
    }
    return offset;
  }
}
