package GenericSetClass;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

class GenericSet<T>{
    private java.util.ArrayList<T> list;

    GenericSet()
    {
        list= new java.util.ArrayList<>();
    }
    public void addElement(T element)
    {
        if (list.contains(element))
        {
            System.out.println("The element "+element+" already exists. I did not add this to the set!");
            return;
        }
        list.add(element);
    }
    public void removeElement(T element)
    {
        if (list.contains(element))
        {
            System.out.println("Removed element: "+element+" from the set");
            list.remove(element);
        }
        else
        {
            System.out.println("The element does not exist");
        }
    }
    public boolean peek(T element)
    {
        if (list.contains(element))
        {
            return true;
        }
        return false;
    }
    public int getSize()
    {
        return list.size() ;
    }

    @Override
    public boolean equals(Object list3) {
        ArrayList<T> list2=(ArrayList<T>) list3;
        if (list.size()!=list2.size())
            return false;

        List<T> templist=list.stream().sorted().toList();
        List<T> templist2= list2.stream().sorted().toList();
//        System.out.println(templist2+"\n"+templist);
        for (int i=0;i<templist.size();i++)
        {
            if (templist.get(i).equals(templist2.get(i))==false)
                return false;
        }
        return true;

    }
    public void display()
    {
        for (int i=0;i<list.size();i++)
        {
            System.out.print(list.get(i)+" ");
        }
        System.out.println();
    }
}
public class Main {
    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);

        System.out.println("Please enter what kind of object you want to create: \n1.Int\n2.String\n3.Double\n4.Char");
        char type=sc.nextLine().toLowerCase().charAt(0);
        int choice=0;

        if(type=='i')
        {
            GenericSet<Integer> gs=new GenericSet<>();
            do {
                System.out.println("Please chose from the following:\n1. Add elements\n2. Remove element\n" +
                        "3. Find if the element exists(Peek)" +
                        "\n4. Size of the set\n5. Check if two lists are equal\n6. Display elements in the set\n7. Exit");
                choice=Integer.parseInt(sc.nextLine());
                switch (choice)
                {
                    case 1->{
                        System.out.println("Please input the elements you want to enter");
                        String s=sc.nextLine();
                        for (int i=0;i<s.split(" ").length;i++)
                        {

                            gs.addElement(Integer.parseInt(s.split(" ")[i]));
                        }
                    }
                    case 2->{
                        System.out.println("Please enter the element that you want to remove");
                        String s=sc.nextLine();
                        gs.removeElement(Integer.parseInt(s));
                    }
                    case 3->{
                        System.out.println("Please enter the element that you want to search ");
                        String s=sc.nextLine();
                        if(gs.peek(Integer.parseInt(s))==true)
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
                        System.out.println("Enter the content of second list");
                        String s=sc.nextLine();
                        ArrayList<Integer> temp2=new ArrayList<>();
                        for (int i=0;i<s.split(" ").length;i++)
                        {
                            temp2.add(Integer.parseInt(s.split(" ")[i]));
                        }
                        if (gs.equals(temp2)) {
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
            }while (choice!=7);
        } else if (type=='s'|| type=='c') {
            GenericSet<String> gs=new GenericSet<>();
            do {
                System.out.println("Please chose from the following:\n1. Add elements\n2. Remove element\n" +
                        "3. Find if the element exists(Peek)" +
                        "\n4. Size of the set\n5. Check if two lists are equal\n6. Display elements in the set\n7. Exit");
                choice=Integer.parseInt(sc.nextLine());
                switch (choice)
                {
                    case 1->{
                        System.out.println("Please input the elements you want to enter");
                        String s=sc.nextLine();
                        for (int i=0;i<s.split(" ").length;i++)
                        {

                            gs.addElement(s.split(" ")[i]);
                        }
                    }
                    case 2->{
                        System.out.println("Please enter the element that you want to remove");
                        String s=sc.nextLine();
                        gs.removeElement(s);
                    }
                    case 3->{
                        System.out.println("Please enter the element that you want to search ");
                        String s=sc.nextLine();
                        if(gs.peek(s)==true)
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
                        System.out.println("Enter the content of second list");
                        String s=sc.nextLine();
                        ArrayList<String> temp2=new ArrayList<>();
                        for (int i=0;i<s.split(" ").length;i++)
                        {
                            temp2.add((s.split(" ")[i]));
                        }
                        if (gs.equals(temp2)) {
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
            }while (choice!=7);
        }
        else if (type=='d') {
            GenericSet<Double> gs=new GenericSet<>();
            do {
                System.out.println("Please chose from the following:\n1. Add elements\n2. Remove element\n" +
                        "3. Find if the element exists(Peek)" +
                        "\n4. Size of the set\n5. Check if two lists are equal\n6. Display elements in the set\n7. Exit");
                choice=Integer.parseInt(sc.nextLine());
                switch (choice)
                {
                    case 1->{
                        System.out.println("Please input the elements you want to enter");
                        String s=sc.nextLine();
                        for (int i=0;i<s.split(" ").length;i++)
                        {

                            gs.addElement(Double.parseDouble(s.split(" ")[i]));
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
                        if(gs.peek(Double.parseDouble(s))==true)
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
                        System.out.println("Enter the content of second list");
                        String s=sc.nextLine();
                        ArrayList<Double> temp2=new ArrayList<>();
                        for (int i=0;i<s.split(" ").length;i++)
                        {
                            temp2.add(Double.parseDouble(s.split(" ")[i]));
                        }
                        if (gs.equals(temp2)) {
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
            }while (choice!=7);
        }
        else
        {
            System.out.println("Please try again and chose a valid option");
            System.exit(0);

        }



    }
}