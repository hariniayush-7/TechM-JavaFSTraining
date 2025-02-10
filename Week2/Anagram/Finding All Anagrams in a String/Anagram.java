package basics;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class Anagram {

	public List<Integer> findAnagrams(String s, String p) {
        List<Integer> result = new ArrayList<>();
        if (s.length() < p.length()) {
            return result; 
        }

        HashMap<Character, Integer> pCount = new HashMap<>();
        HashMap<Character, Integer> sCount = new HashMap<>();

  
        for (char c : p.toCharArray()) {
            pCount.put(c, pCount.getOrDefault(c, 0) + 1);
        }

       
        for (int i = 0; i < p.length(); i++) {
            sCount.put(s.charAt(i), sCount.getOrDefault(s.charAt(i), 0) + 1);
        }

       
        if (pCount.equals(sCount)) {
            result.add(0);
        }

        
        for (int i = p.length(); i < s.length(); i++) {
          sCount.put(s.charAt(i), sCount.getOrDefault(s.charAt(i), 0) + 1);
           
            char outgoingChar = s.charAt(i - p.length());
            sCount.put(outgoingChar, sCount.get(outgoingChar) - 1);
            if (sCount.get(outgoingChar) == 0) {
                sCount.remove(outgoingChar);
            }
            if (pCount.equals(sCount)) {
                result.add(i - p.length() + 1);
            }
        }

        return result;
    }

    public static void main(String[] args) {
        Anagram finder = new Anagram();
        String s = "cbaebabacd";
        String p = "abc";
        List<Integer> indices = finder.findAnagrams(s, p);
        System.out.println("Anagram indices: " + indices);
    }
}
