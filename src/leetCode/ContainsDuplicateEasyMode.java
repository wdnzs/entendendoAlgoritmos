package leetCode;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class ContainsDuplicateEasyMode {

  public static void main(String[] args) {
    ArrayList<Integer> nums = new ArrayList<>(List.of(1, 2, 3, 1));
    containsDuplicate(nums);
  }

  public static boolean containsDuplicate(ArrayList<Integer> nums) {
    HashMap<Integer, Integer> readValues = new HashMap<>();

    for (int i = 0; i < nums.size(); i++) {
      int selectedNumber = nums.get(i);
      if (readValues.containsKey(selectedNumber)) {
        System.out.println("The element " + selectedNumber + " occurs at the indices " + i + " and "
            + readValues.get(selectedNumber));
        return true;
      } else {
        readValues.put(selectedNumber, i);
      }
    }
    return false;
  }
}
