package dataStructures;

public class Link {

    public int Data;
    public String strData;
    public Link next;

    // constructor
    public Link(int myData, String myStr){
        this.Data = myData;
        this.strData = myStr;
        // next is set to null by default
        this.next = null;
    }

    public void displayLink(){
        System.out.print("Data: " + Data + ", String Data: "
                + strData);
    }
}
