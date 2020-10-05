import java.io.*;
import java.util.*;

public class LinkedList {

    node head;
    node sorted;

    /*
    Below is the class node to be used in the linked list class
     */
    class node {

        String val;
        node next;

        public node(String val) {
            this.val = val;
        }
    }

    /*
    The method below pushes and element into the beginning of a linked list
     */
    void push(String val) {

        node newnode = new node(val);

        newnode.next = head;

        head = newnode;
    }

    /*
    The two method below combine to make a sorted list the insertion sort takes
    the head node and sends it to the sortedInsert method which inserts a newnode
    but sorted. It modifys the head similar to the push method.
     */
    void insertionSort(node headref) {

        sorted = null;
        node current = headref;

        while (current != null) {

            node next = current.next;

            sortedInsert(current);

            current = next;
        }

        head = sorted;
    }

    void sortedInsert(node newnode) {

        if (sorted == null || sorted.val.compareToIgnoreCase(newnode.val) > 0) {
            newnode.next = sorted;
            sorted = newnode;
        } else {
            node current = sorted;

            while (current.next != null && current.next.val.compareToIgnoreCase(newnode.val) < 1) {
                current = current.next;
            }
            newnode.next = current.next;
            current.next = newnode;
        }
    }

    /* Method to print linked list below */
    void printlist(node head) throws FileNotFoundException {
        PrintStream ps = new PrintStream("ArtistsSorted-WeekOf08272020.txt");
        ps.print("Linked List: \n");
        while (head != null) {
            ps.println(head.val + " ");
            head = head.next;
        }
    }

    /*
    The main method below first creates a linked list to be filled with names
    it then reads a csv file and uses it to fill the list with names of artist.
    The main also uses the insertionSort method to sort the list and it also uses
    the print method to display the list.
     */
    public static void main(String[] args) throws FileNotFoundException {

        LinkedList TopStreamingArtist = new LinkedList();

        try {
            Scanner sc = new Scanner(new File("Viral50 - Week of 08272020.txt"));
            while (sc.hasNextLine()) {
                String line = sc.nextLine();
                String[] lineArray = line.split(",");
                TopStreamingArtist.push(lineArray[2]);

            }

        } catch (FileNotFoundException e) {
            System.out.println("File Read Error");
        }

        TopStreamingArtist.insertionSort(TopStreamingArtist.head);
        TopStreamingArtist.printlist(TopStreamingArtist.head);

    }

}
