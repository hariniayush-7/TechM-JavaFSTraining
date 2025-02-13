import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;

public class HashSetClass {
    public static void main(String[] args) {
        Set<Integer> h = new HashSet<>();
        HashSetsample(h);

    }

    public static void HashSetsample(Set<Integer> h) {

        h.add(35);
        h.add(19);
        h.add(17);
        h.add(7);
        h.add(30);
        h.add(21);
        h.add(14);
        h.add(2);

        System.out.println("HashSet Size: " + h.size());
        System.out.println("Elements in HashSet: " + h);


        //traversing methods

        //1.iterator
        System.out.print("Using iterator : ");
        Iterator<Integer> iterator = h.iterator();
        while (iterator.hasNext())
            System.out.print(iterator.next() + " ");

        System.out.println();


        //2. enhanced fo loop
        System.out.print("Using enhanced for loop ---> ");
        System.out.print("Elements divisible by 7 : ");

        for (Integer element : h) {
            if(element%7==0)
                System.out.print(element + " ");
        }

        //3. java 8 version
        h.remove(2);
        System.out.println("\nHashSet after removing element : " + h);


    }
}
