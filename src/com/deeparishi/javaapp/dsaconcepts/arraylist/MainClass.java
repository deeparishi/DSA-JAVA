package com.deeparishi.javaapp.dsaconcepts.arraylist;


public class MainClass {

    public static void main(String[] args) {

//        ArrayList list = new ArrayList();
//        for (int i = 0; i < 12; i++) {
//            list.add(i);
//        }
//        list.print();
//        System.out.println();
//        System.out.println();
//        list.add(2, 456);
//        list.removeFirst();
//        list.removeFirst();
//        list.removeLast();
//        System.out.println();
//        list.print();

        ArrayList<String> my = new ArrayList<>();

        my.add("Deepa");
        my.add("swe");
        my.add("were");
        my.add("ede");
        my.add("ert");
        my.add("fvv");
        my.add("vfsv");
        my.add("Deevsvpa");
        my.add("vsfvs");

        for (int i = 0; i < my.size(); i++) {
            System.out.println(my.get(i));
        }
   for (String m : my)
       System.out.println(m);
    }
}
