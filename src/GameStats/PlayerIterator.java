package GameStats;

import Collections.LnkList;

import java.util.Iterator;
import java.util.NoSuchElementException;

public class PlayerIterator implements Iterator<Player> {

    LnkList<Player> list;
    public PlayerIterator(LnkList<Player> s){
        list = s;
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
    public Player next() {
        Player  p;

        if (hasNext()) {
            p = list.get();
            list.advance();
            return p;
        }
        else {
            //list.toFront();
            throw new NoSuchElementException();
        }
    }

}
