

import java.util.Random;
import java.util.Scanner;

public class Main {
    public static void main(String [] args){
        final int setSize = 10;

        // Clause 1:
        Set<Integer> set1 = new Set<>();
        Set<Integer> set2 = new Set<>();
        Set<Integer> set3 = new Set<>();
        Set<Person> setOfPersons = new Set<>();


        Random rand = new Random();

        for(int i=0;i<setSize;i++)
        {
            int rand1 = rand.nextInt(100);
            int rand2 = rand.nextInt(100);
            int rand3 = rand.nextInt(100);
            set1.insert(rand1);
            set2.insert(rand2);
            set3.insert(rand3);
        }



        System.out.println("Set 1: " + set1);
        System.out.println("Set 2: " + set2);
        System.out.println("Set 3: " + set3);

        //End of Clause 1;

        //Clause 2:

        set1.union(set2);
        System.out.println("Result of union between Set 1 and Set 2:" + set1);

        //End of Clause 2;


        //Clause 3 :
        set1.intersect(set3);
        System.out.println("Result of intersect between Set 1 and Set 3:" + set1);

        //End of Clause 3;

        // Clause 4:

        Scanner myObj = new Scanner(System.in);  // Create a Scanner object
        System.out.println("Please Enter 1st Number");
        int fNumber = myObj.nextInt();  // Read user input
        System.out.println("Please Enter 2nd Number");
        int sNumber = myObj.nextInt();  // Read user input
        Set<Integer> set4 = new Set<>();
        set4.insert(fNumber);
        set4.insert(sNumber);


        if(set4.isSubset(set1)){
            System.out.println("Set 4 is subSet of Set 1");
        }
        if(set4.isSubset(set2)){
            System.out.println("Set 4 is subSet of Set 2");
        }
        if(set4.isSubset(set3)){
            System.out.println("Set 4 is subSet of Set 3");
        }
            //End of Clause 4:

            //Clause 5:

            System.out.println("Please Enter Another Number");
            int tNumber = myObj.nextInt();  // Read user input

            if (!set1.isMember(tNumber)) {
                System.out.println("Your Number is not a member of Set 1");
            } else {
                System.out.println("Your Number is member of Set 1");
            }

            set2.insert(tNumber);
            System.out.println("Set 2: " + set2);
            set3.delete(tNumber);

            System.out.println("Set 3: " + set3);

            //End of Clause 5;

            Person p1 = new Person("Britney", "100000", 20);
            Person p2 = new Person("Dwayne", "100000", 26);
            Person p3 = new Person("Bruce", "222", 45);
            Person p4 = new Person("Johnny", "23", 62);
            Person p5 = new Person("Amber", "2423", 15);


            setOfPersons.insert(p1);
            setOfPersons.insert(p2);
            setOfPersons.insert(p3);
            setOfPersons.insert(p4);
            setOfPersons.insert(p5);

            System.out.println("The youngest person is: " + Generic.findMin(setOfPersons));




    }
}
