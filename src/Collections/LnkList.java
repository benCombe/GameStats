package Collections;

import java.util.Iterator;

/* LnkList

 * @author          Ben Combe
 * @course          COSC 1P03
 * @assignment      #5 - Part A
 * @student ID      5819446
 * @version         1.0
 * @since           Mar 28th, 2022
 * @due date        Apr. 8th, 2022
 */

public class LnkList<E extends Comparable<E>> implements List<E> {
    private Node<E> head, tail; //front and end Nodes of the list
    private Node<E> cursorA; //main cursor, points to Node for get() & remove() methods
    private Node<E> cursorB; //points to Node before cursorA, cursorB.next == cursorA
    private int     length; //length of list

    public LnkList(){
        tail = new Node<>(null,null);
        head = new Node<>(null,tail);

        cursorA = head;
        cursorB = null;
        length = 0;

    }

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
            throw new NoItemException();
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
    @Override
    public void toFront() {
        cursorA = head.next;
        cursorB = head;
    }

    //advances both cursors to their next nodes
    @Override
    public void advance() {
        if (!offEnd()){
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

    @Override
    public Iterator<E> iterator() {
        return new LnkListIterator<>(this);
    }
}
