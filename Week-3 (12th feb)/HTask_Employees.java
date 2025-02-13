import java.io.*;

public class HTask_Employees {

    public static void main(String[] args) throws IOException
    {
        Serializiable();
        DeSerializiable();
    }
    public static void Serializiable()
    {
        try {
            //Creating the object
            Employees e1 = new Employees(138, "ayush","hariniayush@07");
            //Creating stream and writing the object
            FileOutputStream fout = new FileOutputStream("file.txt");
            ObjectOutputStream out = new ObjectOutputStream(fout);
            out.writeObject(e1);
            out.flush();
            //closing the stream
            out.close();
            System.out.println("success");
        } catch (Exception e) {
            System.out.println(e);
        }
    }

    public static void DeSerializiable()
    {
        try {
            //Creating stream to read the object
            ObjectInputStream in = new ObjectInputStream(new FileInputStream("file.txt"));
            Employees e1 = (Employees) in.readObject();
            //printing the data of the serialized object
            System.out.println(e1.eno + " " + e1.ename);
            //closing the stream
            in.close();
        } catch (Exception e) {
            System.out.println(e);
        }
    }
}

class Employees implements Serializable {
    Employees(int eno, String ename,String email) {
        this.eno = eno;
        this.ename = ename;
    }

    int eno;
    String ename;
}



