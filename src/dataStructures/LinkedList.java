package dataStructures;

public class LinkedList {

    // reference to first link in list
    private Link first;

    // constructor
    public void LinkList(){
        first = null;
    }


    public boolean isEmpty(){
        // only have to check first link
        return (first == null);
    }


    public void insertFirst(int myData, String myStr){
        Link newLink = new Link(myData, myStr);
        // make newLink.next point to first & make newLink first
        newLink.next = first;
        first = newLink;
    }


   public Link deleteFirst(){
        Link tempy = first;
        // have first point to second element
        first = first.next;
        return tempy;
   }


   public void displayList(){
        System.out.println("LinkedList contents: ");
        Link current = first;

        while (current != null) {
            current.displayLink();
            current = current.next;
            System.out.println("");
        }
   }


   public Link find(int key){
       // assumes non-empty
       Link current = first;

       while (current.Data != key){
           // if key not found, move to next Link
           // if next link is null, return null
           if (current.next == null){
               return null;
           } else {
               current = current.next;
           }
       }
       return current;
   }


   public Link delete(int key){
       // assumes non-empty
       Link current = first;
       Link previous = first;

       while (current.Data != key){
           if (current.next == null){
               return null;
           } else {
               previous = current;
               current = current.next;
           }
       }
       if (current == first){
           first = first.next;
       } else {
           previous.next = current.next;
       }
       return current;
   }
   //
}
