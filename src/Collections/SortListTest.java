package Collections;

import BasicIO.ASCIIDisplayer;

/* SortListTest

 * @author          Ben Combe
 * @course          COSC 1P03
 * @assignment      #5 - Part B
 * @student ID      5819446
 * @version         1.0
 * @since           Mar 28th, 2022
 * @due date        Apr. 8th, 2022
 */


// Test class for the SortableListImpl class
public class SortListTest {
    ASCIIDisplayer              out;        //display
    SortableList<Integer> iList;      //SortableList
    int                         numComp;    //number of comparisons that result in a swap


    public SortListTest(){
        iList = new SortableListImpl<>();
        out = new ASCIIDisplayer();

        out.writeString("=== TESTING INTEGERS ===");
        out.newLine();

        loadIntList();

        out.writeString("= UNSORTED LIST =\n");
        printIntList();

        out.writeString("\n= SORTED LIST =\n");
        numComp = iList.Sort();
        printIntList();

        out.newLine();
        out.writeString("Number of Comparisons: ");
        out.writeInt(numComp);
    } //constructor

    //adds 100 random integers to list
    private void loadIntList(){
        for (int i = 0; i < 100; i++){
            iList.add(randomInt(0,100));
        }
    }

    //prints out entire contents of list using the iterator
    private void printIntList(){
        out.writeString("[");
        for (int i : iList){
            out.writeString(i + ", ");
        }
        out.writeString("]");
    }


    private int randomInt(int min, int max){
        return (int)((max-min)*Math.random())+min;
    }

    public static void main(String[] args) {
        new SortListTest();
    }
}
