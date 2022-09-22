package Collections;

import java.util.Iterator;

/* SortableListImpl

 * @author          Ben Combe
 * @course          COSC 1P03
 * @assignment      #5 - Part B
 * @student ID      5819446
 * @version         1.0
 * @since           Mar 28th, 2022
 * @due date        Apr. 8th, 2022
 */

public class SortableListImpl<E extends Comparable<E>> implements SortableList<E> {

    private Node<E> head, tail; //front and end Nodes of the list
    private Node<E> cursorA;    //main cursor, points to Node for get() & remove() methods
    private Node<E> cursorB;    //points to Node before cursorA, cursorB.next == cursorA
    private Node<E> cursorC;    //points to Node before cursorB, cursorC.next == cursorB
    private int         length;     //length of list

    public SortableListImpl(){
        tail = new Node<>(null,null);
        head = new Node<>(null,tail);

        cursorA = head;
        cursorB = null;
        cursorC = null;
        length = 0;
    } //constructor

    //if cursor is at head, add after head and advance to new Node
    //else, adds new Node after cursorB, and moves cursorA to new Node
    @Override
    public void add(E item) {
        if (cursorA == head) {
            cursorA.next = new Node<>(item, cursorA.next);
            advance();
        }
        else{
            cursorB.next = new Node<>(item, cursorB.next);
            cursorA = cursorB.next;
        }
        length++;
    }

    //returns item in Node at cursorA, then removes that Node
    //returns null if cursorA is at tail, does not remove tail
    @Override
    public E remove() {
        E item;
        if(cursorA == tail) return null;

        else{
            item = cursorA.item;
            cursorB.next = cursorA.next;
            cursorA = cursorA.next;
            length--;
        }
        return item;
    }

    //returns item at cursorA
    //throws NoItemException when offEnd()
    @Override
    public E get() {
        if (!offEnd())
            return cursorA.item;
        else
            return null;
    }

    @Override
    public boolean empty() {
        return length <= 0;
    }

    @Override
    public int length() {
        return length;
    }

    //Moves cursorA to Node after head
    //Moves cursorB to head
    //cursorC = null;
    @Override
    public void toFront() {
        cursorA = head.next;
        cursorB = head;
        cursorC = null;
    }

    //advances all cursors to their next nodes
    @Override
    public void advance() {
        if (!offEnd()){
            cursorC = cursorB;
            cursorB = cursorA;
            cursorA = cursorA.next;
        }
    }

    //advances through each Node (starting from original cursor position)
    //breaks loop when passed element is found
    @Override
    public void find(E element) {

        while (!offEnd()){
            if (element.compareTo(get()) == 0) break;
            advance();
        }
    }

    //returns true if cursorA is null or at tail
    @Override
    public boolean offEnd() {
        return (cursorA == tail || cursorA == null);
    }

    //This method uses Bubble Sort and goes through the list in several passes
    //Nodes are swapped when the item at cursorB is greater than the item at cursorA
    //numSwapInPass increases for every swap, then resets to 0 after each pass
    //sorting ends when a pass is completed with no swaps
    //numSwapInPass is then added to compCount after each pass
    //method then returns compCount at end of sort.
    @Override
    public int Sort() {
        int compCount = 0, numSwapInPass = 1;
        int compResult;
        Node<E> temp;

        while (numSwapInPass > 0){
            numSwapInPass = 0;
            toFront();
            advance();
            while (!offEnd()){
                compResult = cursorA.item.compareTo(cursorB.item);

                if (compResult < 0){ //swap needed
                    numSwapInPass++;

                    //swap 'next' pointers
                    cursorC.next = cursorA;
                    cursorB.next = cursorA.next;
                    cursorA.next = cursorB;

                    //swap cursors A & B
                    temp = cursorA;
                    cursorA = cursorB;
                    cursorB = temp;
                }
                advance();
            }
            compCount += numSwapInPass; //adds to total number of swaps
        }
        return compCount;
    }


    @Override
    public Iterator<E> iterator() {
        return new SortableListIterator<>(this);
    }
}
