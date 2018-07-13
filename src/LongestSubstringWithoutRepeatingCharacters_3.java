

public class LongestSubstringWithoutRepeatingCharacters_3 {
    public int lengthOfLongestSubstring(String s) {
        String subStr;
        if (s.length() > 1) {
            subStr = getLongString(s);
        } else {
            subStr = s;
        }
        return subStr.length();
    }

    public String getLongString(String input) {
        String result = "";
        String tmp = "";
        for (int i = 0; i < input.length(); i++) {
            if (!tmp.contains(String.valueOf(input.charAt(i)))) {
                tmp += input.charAt(i);
            } else {
                if (tmp.length() > result.length()) {
                    result = tmp;
                }
                tmp = String.valueOf(input.charAt(i));
            }
        }
        return result.length() < tmp.length() ? tmp : result;
    }

    public static void main(String[] args) {
        LongestSubstringWithoutRepeatingCharacters_3 test = new LongestSubstringWithoutRepeatingCharacters_3();
//        int t = test.lengthOfLongestSubstring("aab");
        String tmp = test.getLongString("dvdf");
        System.out.println(tmp);
    }
}
