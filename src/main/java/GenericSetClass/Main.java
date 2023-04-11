package GenericSetClass;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        System.out.println("Please enter what kind of object you want to create: \n1.Int\n2.String\n3.Double\n4.Char");
        char type=sc.nextLine().toLowerCase().charAt(0);
        int choice=0;

        if(type=='i'||type=='1')
        {
            GenericSet<Integer> gs=new GenericSet<>();
            do {
                System.out.println("""
                        Please chose from the following:
                        1. Add element
                        2. Remove element
                        3. Find if the element exists(Peek)
                        4. Size of the set
                        5. Check if two lists are equal
                        6. Display elements in the set
                        7. Exit""");
                choice=Integer.parseInt(sc.nextLine());
                switch (choice)
                {
                    case 1->{

                            System.out.println("Enter Integer");
                            gs.addElement(Integer.parseInt(sc.nextLine()));
                    }
                    case 2->{
                        System.out.println("Please enter the element that you want to remove");
                        String s=sc.nextLine();
                        gs.removeElement(Integer.parseInt(s));
                    }
                    case 3->{
                        System.out.println("Please enter the element that you want to search ");
                        String s=sc.nextLine();
                        if(gs.peek(Integer.parseInt(s)))
                        {
                            System.out.println("The element exists!");
                        }
                        else
                        {
                            System.out.println("The element does not exist");
                        }
                    }
                    case 4->{
                        System.out.println("Size of the set is "+gs.getSize());
                    }
                    case 5->{
                        System.out.println("Enter the content of second set");
                        String s=sc.nextLine();
                        GenericSet<Integer> gs2=new GenericSet<>();
                        for (int i=0;i<s.split(" ").length;i++)
                        {
                            gs2.addElement(Integer.parseInt(s.split(" ")[i]));
                        }
                        if (gs.equals(gs2)) {
                            System.out.println("The two sets are equal");
                        }
                        else
                        {
                            System.out.println("the sets are not equal");
                        }
                    }
                    case 6->
                    {
                        System.out.println("Displaying elements in the set");
                        gs.display();
                    }
                    case 7->{
                        System.out.println("Exitting the program! Bye!");
                        System.exit(0);
                    }
                }
            }while (true);
        } else if (type=='s'||type=='2') {
            GenericSet<String> gs=new GenericSet<>();
            do {
                System.out.println("""
                        Please chose from the following:
                        1. Add elements
                        2. Remove element
                        3. Find if the element exists(Peek)
                        4. Size of the set
                        5. Check if two lists are equal
                        6. Display elements in the set
                        7. Exit""");
                choice=Integer.parseInt(sc.nextLine());
                switch (choice)
                {
                    case 1->{
                            System.out.println("Enter string");
                            gs.addElement(sc.nextLine());
                    }
                    case 2->{
                        System.out.println("Please enter the element that you want to remove");
                        String s=sc.nextLine();
                        gs.removeElement(s);
                    }
                    case 3->{
                        System.out.println("Please enter the element that you want to search ");
                        String s=sc.nextLine();
                        if(gs.peek(s))
                        {
                            System.out.println("The element exists!");
                        }
                        else
                        {
                            System.out.println("The element does not exist");
                        }
                    }
                    case 4->{
                        System.out.println("Size of the set is "+gs.getSize());
                    }
                    case 5->{
                        System.out.println("Enter the content of second set");
                        String s=sc.nextLine();
                        GenericSet<String> gs2=new GenericSet<>();
                        for (int i=0;i<s.split(" ").length;i++)
                        {
                            gs2.addElement((s.split(" ")[i]));
                        }
                        if (gs.equals(gs2)) {
                            System.out.println("The two lists are equal");
                        }
                        else
                        {
                            System.out.println("the lists are not equal");
                        }
                    }
                    case 6->
                    {
                        System.out.println("Displaying elements in the set");
                        gs.display();
                    }
                    case 7->{
                        System.out.println("Exitting the program! Bye!");
                        System.exit(0);
                    }
                }
            }while (true);
        }
        else if (type=='c'||type=='4') {
            GenericSet<Character> gs=new GenericSet<>();
            do {
                System.out.println("""
                        Please chose from the following:
                        1. Add elements
                        2. Remove element
                        3. Find if the element exists(Peek)
                        4. Size of the set
                        5. Check if two lists are equal
                        6. Display elements in the set
                        7. Exit""");
                choice=Integer.parseInt(sc.nextLine());
                switch (choice)
                {
                    case 1->{
                            System.out.println("Enter Character");
                            gs.addElement(sc.nextLine().charAt(0));
                    }
                    case 2->{
                        System.out.println("Please enter the element that you want to remove");
                        Character s=sc.nextLine().charAt(0);
                        gs.removeElement(s);
                    }
                    case 3->{
                        System.out.println("Please enter the element that you want to search ");
                        Character s=sc.nextLine().charAt(0);
                        if(gs.peek(s))
                        {
                            System.out.println("The element exists!");
                        }
                        else
                        {
                            System.out.println("The element does not exist");
                        }
                    }
                    case 4->{
                        System.out.println("Size of the set is "+gs.getSize());
                    }
                    case 5->{
                        System.out.println("Enter the content of second set");
                        String s=sc.nextLine();
                        GenericSet<Character> gs2=new GenericSet<>();
                        for (String s1 : s.split(" "))
                        {
                            gs2.addElement(s1.charAt(0));
                        }
                        if (gs.equals(gs2)) {
                            System.out.println("The two lists are equal");
                        }
                        else
                        {
                            System.out.println("the lists are not equal");
                        }
                    }
                    case 6->
                    {
                        System.out.println("Displaying elements in the set");
                        gs.display();
                    }
                    case 7->{
                        System.out.println("Exitting the program! Bye!");
                        System.exit(0);
                    }
                }
            }while (true);
        }
        else if (type=='d'||type=='3') {
            GenericSet<Double> gs=new GenericSet<>();
            do {
                System.out.println("""
                        Please chose from the following:
                        1. Add elements
                        2. Remove element
                        3. Find if the element exists(Peek)
                        4. Size of the set
                        5. Check if two lists are equal
                        6. Display elements in the set
                        7. Exit""");
                choice=Integer.parseInt(sc.nextLine());
                switch (choice)
                {
                    case 1->{
                        System.out.println("Please enter the number of input doubles you want to enter");
                        int numInt=Integer.parseInt(sc.nextLine());
                        for (int i=0;i<numInt;i++)
                        {
                            System.out.println("Enter Double");
                            gs.addElement(Double.parseDouble(sc.nextLine()));
                        }
                    }
                    case 2->{
                        System.out.println("Please enter the element that you want to remove");
                        String s=sc.nextLine();
                        gs.removeElement(Double.parseDouble(s));
                    }
                    case 3->{
                        System.out.println("Please enter the element that you want to search ");
                        String s=sc.nextLine();
                        if(gs.peek(Double.parseDouble(s)))
                        {
                            System.out.println("The element exists!");
                        }
                        else
                        {
                            System.out.println("The element does not exist");
                        }
                    }
                    case 4->{
                        System.out.println("Size of the set is "+gs.getSize());
                    }
                    case 5->{
                        System.out.println("Enter the content of second set");
                        String s=sc.nextLine();
                        GenericSet<Double> gs2=new GenericSet<>();
                        for (int i=0;i<s.split(" ").length;i++)
                        {
                            gs2.addElement(Double.parseDouble(s.split(" ")[i]));
                        }
                        if (gs.equals(gs2)) {
                            System.out.println("The two lists are equal");
                        }
                        else
                        {
                            System.out.println("the lists are not equal");
                        }
                    }
                    case 6->
                    {
                        System.out.println("Displaying elements in the set");
                        gs.display();
                    }
                    case 7->{
                        System.out.println("Exitting the program! Bye!");
                        System.exit(0);
                    }
                }
            }while (true);
        }
        else
        {
            System.out.println("Please try again and chose a valid option");
            System.exit(0);

        }
    }
}