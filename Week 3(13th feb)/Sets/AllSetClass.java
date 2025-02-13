import java.util.*;

public class AllSetClass {
    public static void main(String[] args) {
        HashSet<Integer> h = new HashSet<>();
        Setsample(h);

        LinkedHashSet<String> lh = new LinkedHashSet<>();
        Setsample(lh);

        TreeSet<Double> t = new TreeSet<>();
        Setsample(t);

    }

    //HASHSET METHOD
    public static void Setsample(HashSet<Integer> h) {
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

    //LINKED HASHSET METHOD
    public static void Setsample(LinkedHashSet<String> lh) {
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

    //TREE SET METHOD
    public static void Setsample(TreeSet<Double> t) {
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
