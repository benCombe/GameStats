package Collections;/* SortableList Interface

 * @author          Ben Combe
 * @course          COSC 1P03
 * @assignment      #5 - Part B
 * @student ID      5819446
 * @version         1.0
 * @since           Mar 28th, 2022
 * @due date        Apr. 8th, 2022
 */

public interface SortableList<E extends Comparable<E>> extends List<E> {


    //This method applies bubble sort to the list
    //returns the number of swaps needed to complete
    public int Sort();
}
