package basics;
abstract class Animal {
	    abstract void makeSound();
	}

	class Dog extends Animal {
	    @Override
	    void makeSound() {
	        System.out.println("The dog is barking.");
	    }
	}


