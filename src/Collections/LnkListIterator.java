package Collections;

import java.util.Iterator;
import java.util.NoSuchElementException;

/* LnkListIterator

 * @author          Ben Combe
 * @course          COSC 1P03
 * @assignment      #5 - Part A
 * @student ID      5819446
 * @version         1.0
 * @since           Mar 28th, 2022
 * @due date        Apr. 8th, 2022
 */

public class LnkListIterator< E extends Comparable<E> > implements Iterator<E> {

    LnkList<E> list;

    /** This constructor constructs an iterator on the specified ConList.
     *
     * @param  l  the list to be iterated over.                                 */

    LnkListIterator(LnkList<E> l ) {
        list = l;
        list.toFront();
    };  // constructor


    /** This method returns true if there are more items in the list.
     *
     * @return  boolean  more items on the list.                                */
    @Override
    public boolean hasNext ( ) {  // from Iterator

        if (!list.offEnd()) return true;
        else { //if the end of list has been reached, iteration ends and cursor is moved to front of list
            list.toFront();
            return false;
        }
        //return (!list.offEnd());

    }  // hasNext


    /** This method returns the next item in the list.
     *
     * @retuen  E  the next item on the list.                                   */
    @Override
    public E next ( ) {  // from Iterator
        E  i;

        if (hasNext()) {
            i = list.get();
            list.advance();
            return i;
        }
        else {
            //list.toFront();
            throw new NoSuchElementException();
        }

    }  // next


    /** Removal is not supported so this method throws an
     * UnsupportedOperationException.
     *
     * @exception  UnsupportedOperationException  remove is not supported.      */

    public void remove ( ) {  // from Iterator

        throw new UnsupportedOperationException();

    }  // remove

}
