package datasr;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class MyArrayList {

    private int[] list;
    private final int LIST_DEF_SIZE = 10;
    private int size = LIST_DEF_SIZE;
    private int counter = 0;
    public MyArrayList() {
        list = new int[size];
    }

    public MyArrayList(int inputSize){

        if(inputSize > 0){
            size = inputSize;
        }

        list = new int[size];
    }

    public boolean isEmpty(){
        return (counter==0);
    }

    public boolean isFull(){
        return(counter==size);
    }

    public int howManyElements(){
        return counter;
    }

    private void reSize(){

        int newSize = (counter <= 100)? size *2 :(int) (size * 1.5);

        int[] newList = new int [newSize];

        for (int i = 0; i < size; i++){
            newList[i] = list[i];
        }

        list = newList;

        System.gc();

        size = newSize;

    }

    public void AddElement(int element){
        if(isFull()) reSize();

        list[counter] = element;

        counter++;

    }

    public void AddElementByIndex(int index, int element) throws Exception{
        if(index < 0 || index > counter){
            throw new Exception("Index error");
        }
        if(isFull()) reSize();

        if(index == counter) AddElement(element);
        else{
            for(int i = counter; i > index; i--) {
                list[i] = list[i - 1];
            }
                list[index] = element;
                counter++;
            }
    }

    public void DeleteElementByIndex(int index)throws Exception{
        if(isEmpty()) throw new Exception("Empty list");
        if(index < 0 || index > counter){
            throw new Exception("Index error");
        }

        for(int i = index; i < counter -1; i++){

            list[i] = list[i+1];
        }
        counter--;
    }

    public int takeout(int index)throws Exception{
        if(isEmpty()) throw new Exception("Empty list");
        if(index < 0 || index > counter){
            throw new Exception("Index error");
        }
        return list[index];
    }

    public ArrayList findElement(int element)throws Exception{
        if(isEmpty()) throw new Exception("Empty list");

        ArrayList indexes = new ArrayList();
        for(int i = 0; i < counter; i++ ){
            if(list[i] == element){
                indexes.add(i);
            }
        }

        if(indexes.size() == 0) throw new Exception("Element is not found");

        return indexes;
    }

    public int[] findNeighbours(int element)throws Exception{
        ArrayList indexes = findElement(element);

        int neigboursSize = indexes.size();

        if((Integer)indexes.get(indexes.size()-1) == (counter-1))
            neigboursSize--;

        int[] neigbours = new int[neigboursSize];

        for(int i = 0; i < neigboursSize; i++){
            neigbours[i] = list[(int)indexes.get(i)+1];
        }

        return neigbours;

    }

    public void print() throws Exception {
        if(isEmpty()) throw new Exception("Empty list");

        for(int i = 0; i < counter; i ++){
            System.out.println(list[i] + " ");
        }
        System.out.println();
    }

    public void makeEmpty() throws Exception {
        if(isEmpty()) throw new Exception("Empty list");
        size = LIST_DEF_SIZE;
        counter = 0;
        list = new int [size];
        System.gc();
    }


    public void sort()throws Exception {
        if (isEmpty()) throw new Exception("Empty list");

        int n = counter;
        int temp = 0;
        for (int i = 0; i < n; i++) {
            for (int j = 1; j < (n - i); j++) {
                if (list[j - 1] > list[j]) {
                    //swap elements
                    temp = list[j - 1];
                    list[j - 1] = list[j];
                    list[j] = temp;
                }

            }
        }
    }
}





