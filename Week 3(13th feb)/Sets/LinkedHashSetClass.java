import java.util.Iterator;
import java.util.LinkedHashSet;
import java.util.Set;


public class LinkedHashSetClass {
    public static void main(String[] args) {
        Set<String> lh = new LinkedHashSet<>();
        LinkedHashSetsample(lh);

    }
    public static void LinkedHashSetsample(Set<String> lh) {
        lh.add("Hi");
        lh.add("This");
        lh.add("is");
        lh.add("Montoya");
        lh.add("Por");
        lh.add("Favor");
        lh.add("from");
        lh.add("Espanol");
        System.out.println("Set Size: " + lh.size());
        System.out.println("Elements in LinkedHashSet: " + lh);

        //traversing methods

        //1.iterator
        System.out.print("Using iterator : ");
        Iterator<String> iterator =lh.iterator();
        while (iterator.hasNext())
            System.out.print(iterator.next() + " ");

        System.out.println();

        //2. enhanced fo loop
        System.out.print("Using enhanced for loop : ");
        System.out.println("Sting greater than 5 characters");
        for (String element : lh){
            if(element.length()>5)
              System.out.print(element + " ");
        }


        //3. java 8 version
        lh.remove("from");
        System.out.println("\nLinkedHashSet after removing element : " + lh);

    }

}
