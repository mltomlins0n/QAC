package com.qa.Streams;

public class App 
{	
    public static void main(String[] args) {
    	Streams stream = new Streams();
    	
    	stream.printList1();
    	stream.printList2();
    	stream.multiplyListItems(Streams.numList2); // Access the list in Streams class
    }
}
