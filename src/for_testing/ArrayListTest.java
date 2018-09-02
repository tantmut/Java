package for_testing;

import for_testing.ImitationArrayList;
import org.junit.Ignore;
import org.junit.Test;

import java.io.IOException;

import static junit.framework.TestCase.assertEquals;

/**
 * Created by nazar on 4/22/2017.
 */
public class ArrayListTest {
    ImitationArrayList arrayList = new ImitationArrayList();

    @Test
    public void shouldReturnResultAfterAddElement() throws IOException {
        arrayList.addElement(15);
        assertEquals("Should return 15", 15, arrayList.getArray()[0]);
    }

    @Test
    public void shouldReturnResultAfterIncreaseArray() throws IOException {
        arrayList.increaseSize(5);
        //System.out.println(arrayList.getArray().length);
        assertEquals("Should return 5", 5, arrayList.getArray().length);
    }

    @Test
    public void shouldReturnResultAfterDecreaseArray() throws IOException {
        arrayList.increaseSize(5);
        arrayList.decreaseSize(3);
        //System.out.println(arrayList.getArray().length);
        assertEquals("Should return 2", 2, arrayList.getArray().length);
    }

    // Question, How to equal to object
    @Test
    public void shouldReturnResultAfterDirectOutput() throws IOException {
        arrayList.addElement(1);
        arrayList.addElement(2);
        arrayList.outpurDirect();
        //System.out.println(arrayList.getArray().length);
        assertEquals("Should return 1,2", new int[]{1, 2}, arrayList.getArray());
    }

    @Test
    public void shouldReturnResultAfterInDirectOutput() throws IOException {
        arrayList.addElement(1);
        arrayList.addElement(2);
        arrayList.outpurInDirect();
        //System.out.println(arrayList.getArray().length);
        assertEquals("Should return 1,2", new int[]{1, 2}, arrayList.getArray());
    }

    @Test
    public void shouldReturnResultAfterBubbleSort() throws IOException {
        arrayList.addElement(1);
        arrayList.addElement(2);
        arrayList.outpurInDirect();
        //System.out.println(arrayList.getArray().length);
        assertEquals("Should return 1,2", new int[]{1, 2}, arrayList.getArray());
    }

    @Test
    public void shouldReturnResultAfterChangeElementByIndex() throws IOException {
        arrayList.addElement(1);
        arrayList.addElement(2);
        arrayList.changeElementByIndex(1,5);
        //System.out.println(arrayList.getArray().length);
        assertEquals("Should return 5", 5, arrayList.getArray()[1]);
    }

    @Test
    public void shouldReturnResultAfterDeleteElementByIndex() throws IOException {
        arrayList.addElement(1);
        arrayList.addElement(2);
        arrayList.deleteElementByIndex(1);
        //System.out.println(arrayList.getArray().length);
        assertEquals("Should return 5", 1, arrayList.getArray().length);
    }
}
