package service;

import java.io.File;
import java.util.Arrays;
import java.util.Scanner;

import datasr.MyArrayList;
import Model.*;
public class MainService {
    public static void main(String[] args)  {

        MyArrayList<Integer> myList = new MyArrayList(3);
        MyArrayList<Student> studentList = new MyArrayList<>();

        studentList.AddElement(new Student("Jakob", "rmomo"));
        studentList.AddElement(new Student("Dele", "dmomo"));
        studentList.AddElement(new Student("Hihi", "zmomo"));

        try{
        studentList.print();
        studentList.AddElementByIndex(2,new Student("hOO","jAKA"));
        studentList.print();
        studentList.DeleteElementByIndex(2);
            studentList.print();
            studentList.sort();
            studentList.print();

            MyArrayList<Integer> fromFile = readFromFile("resources/numbers (1) (1).txt");

            fromFile.print();


        } catch (Exception e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
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

    public static MyArrayList<Integer> readFromFile(String path)throws Exception {

        if (path == null || path.length() < 3) throw new Exception("Problem with file path");

        MyArrayList<Integer> listFromNumbers = new MyArrayList<Integer>();
        File file = new File(path);
        Scanner scanner = new Scanner(file);

        while(scanner.hasNextLine()) {

            String line = scanner.nextLine();
            Integer tempNumber = Integer.parseInt(line);
            listFromNumbers.AddElement(tempNumber);
        }

        scanner.close();
        return listFromNumbers;

    }

}
