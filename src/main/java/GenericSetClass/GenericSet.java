package GenericSetClass;

import java.util.List;

class GenericSet<T> {
    private java.util.ArrayList<T> list;

    GenericSet() {
        list = new java.util.ArrayList<>();
    }

    public void addElement(T element) {
        if (list.contains(element)) {
            System.out.println("The element " + element + " already exists. I did not add this to the set!");
            return;
        }
        list.add(element);
    }

    public void removeElement(T element) {
        if (list.contains(element)) {
            System.out.println("Removed element: " + element + " from the set");
            list.remove(element);
        } else {
            System.out.println("The element does not exist");
        }
    }

    public boolean peek(T element) {
        return list.contains(element);
    }

    public int getSize() {
        return list.size();
    }

    @Override
    public boolean equals(Object list3) {
        if(list3.getClass().equals(list.getClass()))
            return false;
        GenericSet<T> list2 = (GenericSet<T>) list3;
        if (list.size() != list2.getSize())
            return false;

        List<T> templist = list.stream().sorted().toList();

        for (T item : templist) {
            if (!list2.contains(item))
                return false;
        }
        return true;

    }

    public void display() {
        for (T t : list) {
            System.out.print(t + " ");
        }
        System.out.println();
    }
    public Boolean contains(Object item)
    {
        return list.contains(item);
    }
}
