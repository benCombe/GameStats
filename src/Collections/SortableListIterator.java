package Collections;

import java.util.Iterator;
import java.util.NoSuchElementException;

/* SortableListIterator

 * @author          Ben Combe
 * @course          COSC 1P03
 * @assignment      #5 - Part B
 * @student ID      5819446
 * @version         1.0
 * @since           Mar 28th, 2022
 * @due date        Apr. 8th, 2022
 */

public class SortableListIterator< E extends Comparable<E> > implements Iterator<E> {

    SortableListImpl list;

    SortableListIterator(SortableListImpl<E> S){
        list = S;
        list.toFront();
    }

    @Override
    public boolean hasNext() {
        if (!list.offEnd()) return true;
        else { //if the end of list has been reached, iteration ends and cursor is moved to front of list
            list.toFront();
            return false;
        }
    }

    @Override
    public E next() {

        E i;

        if (hasNext()) {
            i = (E)list.get();
            list.advance();
            return i;
        }
        else throw new NoSuchElementException();

    }
}
