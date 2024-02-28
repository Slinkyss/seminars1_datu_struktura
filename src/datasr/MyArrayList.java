package datasr;

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


}





