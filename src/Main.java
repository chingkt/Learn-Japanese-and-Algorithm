import java.util.ArrayList;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
	    NiHonGo jap = new NiHonGo(new In("list.txt"));
        EEAalgorithm algo = new EEAalgorithm();
        Scanner scan = new Scanner(System.in);
        System.out.println("enter 1 to learn gojuon, 2 to use EEA Algorithm");
        String in = scan.nextLine();
        int a,b;
        if (in.equals("1")) jap.interact();
        else if(in.equals("2")){
            System.out.println("enter the value a: ");
            a = scan.nextInt();
            System.out.println("enter the value b: ");
            b = scan.nextInt();
            algo.eea(a,b);
        }
        else System.out.println("wrong value");
    }
}
