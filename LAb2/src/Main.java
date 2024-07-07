import java.sql.Array;
import java.util.ArrayList;

public class Main {
    public static void main(String[] args) {
        // Create objects of BitArray and TwoDPoint
        BitArray b = new BitArray("True, False, False, True");
        TwoDPoint p = new TwoDPoint("3.5, 2");
        boolean[] a = {true, false, false ,true};
        BitArray b2 = new BitArray(a);
        // Print the objects
        System.out.println(b);
        System.out.println(p);
        System.out.println(b2);
    }
}
