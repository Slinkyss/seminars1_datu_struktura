package service;

import java.util.Arrays;

import datasr.MyArrayList;
public class MainService {
    public static void main(String[] args) {

        MyArrayList myList = new MyArrayList(3);

        myList.AddElement(100);
        myList.AddElement(200);
        myList.AddElement(-100);
        try {
            myList.print();//100 200 -100
            myList.AddElementByIndex(1,1000);
            myList.print();//100 1000 200 -100
            myList.DeleteElementByIndex(2);
            myList.print();//1000 200 -100
            myList.AddElement(200);
            myList.AddElement(200);
            myList.print();//1000 200 -100 200 200
            System.out.println(myList.findElement(200));//1 3 4
            System.out.println(Arrays.toString(myList.findNeighbours(200)));//-100 200
            myList.print();//1000 200 -100 200 200
            myList.sort();
            myList.print();

            myList.makeEmpty();
            myList.AddElement(10000);
            myList.print();//100000

        } catch (Exception e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }


    }
}
