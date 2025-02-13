import java.util.Iterator;
import java.util.Set;
import java.util.TreeSet;

public class SetClass {
    public static void main(String[] args) {
        Set<String> s = new TreeSet<>();
        s.add("A");
        s.add("B");
        s.add("ABCD");
        s.add("SP");
        s.add("AIA");
        s.add("MDA");
        s.add("B");
        System.out.println("Set Size: " + s.size());
        System.out.println("Elements in Set: " + s);


        //traversing methods

        //1.iterator
        System.out.print("Using iterator : ");
        Iterator<String> iterator = s.iterator();
        while (iterator.hasNext())
            System.out.print(iterator.next() + " ");

        System.out.println();

        //2. enhanced fo loop
        System.out.print("Using enhanced for loop : ");
        for (String element : s)
            System.out.print(element + " ");

        //3. java 8 version
        s.remove("B");
        System.out.println("\nSet after removing element : " + s);


    }
}