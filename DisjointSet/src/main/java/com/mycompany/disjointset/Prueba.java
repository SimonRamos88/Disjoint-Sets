
package com.mycompany.disjointset;

import java.util.Scanner;
public class Prueba {
    
    public static void main(String[] args) {

        Scanner scanner;
        scanner = new Scanner(System.in);
        int number;
        DisjointSet set = new DisjointSet();
        System.out.println( "size "+set.getParents().size()+" cap " + set.getParents().getCapacity() );
        set.getParents().get(0);
        System.out.println();
        System.out.print("Enter a positive integer to makeset ");
        System.out.print("or a negative integer to stop: ");
        number = scanner.nextInt();
        while(number >= 0) {
            System.out.println( "size "+set.getParents().size()+" cap " + set.getParents().getCapacity() );
            set.makeSet(number);
            System.out.println("PARENTS:");
            set.getParents().stringTo();
            System.out.println("RANKS");
            set.getRank().stringTo();
            System.out.println();
            System.out.print("Enter a positive integer to insert ");
            System.out.print("or a negative integer to stop: ");
            number = scanner.nextInt();
        }
        System.out.println();
        System.out.print("Enter two positive integer to union ");
        System.out.println("or a negative integer to quit: ");
        System.out.print("number 1: ");
        int number1 = scanner.nextInt();
        System.out.print("number 2: ");
        int number2 = scanner.nextInt();
        while(number1 >= 0 && number2 >= 0) {
            System.out.println( "size "+set.getParents().size()+" cap " + set.getParents().getCapacity() );
            set.union(number1, number2);
            System.out.println("PARENTS:");
            set.getParents().stringTo();
            System.out.println("RANKS");
            set.getRank().stringTo();
            System.out.print("Enter two positive integer to union ");
            System.out.println("or a negative integer to quit: ");
            System.out.print("number 1: ");
            number1 = scanner.nextInt();
            System.out.print("number 2: ");
            number2 = scanner.nextInt();
        }
        System.out.println();
        System.out.print("Enter a positive integer to find");
        System.out.println("or a negative integer to quit: ");
        System.out.print("number: ");
        number = scanner.nextInt();
        while(number >= 0) {
            System.out.println(set.find(number));
            System.out.println();
            System.out.print("Enter a positive integer to find");
            System.out.println("or a negative integer to quit: ");
            System.out.print("number: ");
            number = scanner.nextInt();
        }

    
        System.out.println();
        System.out.println("End of Program");
        System.out.println();
    }
    
}
