package basics;

final class Finalclass {
	  public void showMessage() {
	        System.out.println("This is a final class and cannot be extended.");
	    }
	}

	class FinalDemo {
	    private final int finalVariable = 100;

	    public final void finalMethod() {
	        System.out.println("This is a final method and cannot be overridden.");
	    }

	    public void showFinalVariable() {
	        System.out.println("Final Variable Value: " + finalVariable);
	    }
	}




