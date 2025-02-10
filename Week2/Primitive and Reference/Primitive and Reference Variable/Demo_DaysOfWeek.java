package basics;

public class Demo_DaysOfWeek {
	
	    public static void main(String[] args) {
	        for (DaysOfWeek day : DaysOfWeek.values()) {
	            if (day == DaysOfWeek.SATURDAY || day == DaysOfWeek.SUNDAY) {
	                System.out.println(day + ": Holiday");
	            } else {
	                System.out.println(day + ": Not Holiday");
	            }
	        }
	    }
	}


