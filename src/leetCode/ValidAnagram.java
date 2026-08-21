package leetCode;

public class ValidAnagram {

  public static void main(String[] args) {
    String s = "love";
    String t = "pain";
    System.out.println(
        "The words " + s + " and " + t + (isAnagram(s, t) ? " are " : " are not ") + "anagrams.");
  }

  public static boolean isAnagram(String s, String t) {
    String s1 = s.replaceAll("\\s+", "").toLowerCase();
    String s2 = t.replaceAll("\\s+", "").toLowerCase();

    if (s1.length() != s2.length()) {
      return false;
    }

    int[] counts = new int[256];

    for (int i = 0; i < s1.length(); i++) {
      counts[s1.charAt(i)]++;
      counts[s2.charAt(i)]--;
    }

    for (int count : counts) {
      if (count != 0) {
        return false;
      }
    }

    return true;
  }

}
