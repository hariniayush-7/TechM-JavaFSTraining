package basics;

public class String_Handling {
	
        public String reverseString(String str) {
	        return new StringBuilder(str).reverse().toString();
	    }

	    public int countOccurrences(String text, String sub) {
	        int count = 0;
	        int index = 0;
	        while ((index = text.indexOf(sub, index)) != -1) {
	            count++;
	            index += sub.length();
	        }
	        return count;
	    }

	    public String splitAndCapitalize(String str) {
	        String[] words = str.split(" ");
	        StringBuilder capitalized = new StringBuilder();
	        for (String word : words) {
	            if (word.length() > 0) {
	                capitalized.append(Character.toUpperCase(word.charAt(0)))
	                           .append(word.substring(1)).append(" ");
	            }
	        }
	        return capitalized.toString().trim();
	    }
	}



