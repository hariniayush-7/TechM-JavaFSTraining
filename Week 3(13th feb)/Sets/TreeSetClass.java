import java.util.Iterator;
import java.util.Set;
import java.util.TreeSet;

public class TreeSetClass {
    public static void main(String[] args) {
        Set<Double> t = new TreeSet<>();
        TreeSetsample(t);
}
    public static void TreeSetsample(Set<Double> t) {
        t.add(35.36);
        t.add(19.18);
        t.add(17.7);
        t.add(7.8);
        t.add(30.1);
        t.add(21.9);
        t.add(14.16);
        t.add(2.0);

        System.out.println("TreeSet Size: " + t.size());
        System.out.println("Elements in TreeSet: " + t);


        //traversing methods

        //1.iterator
        System.out.print("Using iterator : ");
        Iterator<Double> iterator = t.iterator();
        while (iterator.hasNext())
            System.out.print(iterator.next() + " ");

        System.out.println();


        //2. enhanced fo loop
        System.out.print("Using enhanced for loop ---> ");
        System.out.print("Elements greater than 20 : ");

        for (Double element : t) {
            if(element>20.0)
                System.out.print(element + " ");
        }

        //3. java 8 version
        t.remove(2.0);
        System.out.println("\nTreeSet after removing element : " + t);
    }
}

