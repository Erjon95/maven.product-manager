package com.github.curriculeon.genericinventory;

import com.github.curriculeon.GenericInventory;
import org.junit.Assert;
import org.junit.Test;

/**
 * Created by leon on 12/16/2019.
 */
public class RemoveTest {
    // given
    private <SomeType> void test(SomeType[] expectedItems, SomeType[] objectsToBeAdded, int indexOfElement) {
        SomeType[] actualItems = objectsToBeAdded.clone();
        SomeType[] temp = (SomeType[]) new Object[actualItems.length - 1];
        GenericInventory<SomeType> genericInventory = new GenericInventory<>();
        for (SomeType someObject : objectsToBeAdded) {
            genericInventory.add(someObject);
            Boolean itemHasBeenAdded = genericInventory.contains(someObject);
            Assert.assertTrue(itemHasBeenAdded);
        }

        // when
        genericInventory.remove(indexOfElement);
        actualItems = genericInventory.toArray(actualItems);

        if (actualItems.length - 1 >= 0) System.arraycopy(actualItems, 0, temp, 0, actualItems.length - 1);

        // then
        Assert.assertArrayEquals(expectedItems, temp/*actualItems*/);
    }

    @Test
    public void test0() {
        String[] objectsToBeAdded = new String[]{"The", "Quicker", "Browner", "Foxer"};
        String[] expectedItems = new String[]{"Quicker", "Browner", "Foxer"};
        Integer indexToRemove = 0;

        test(expectedItems, objectsToBeAdded, indexToRemove);
    }

    @Test
    public void test1() {
        String[] objectsToBeAdded = new String[]{"The", "Quicker", "Browner", "Foxer"};
        String[] expectedItems = new String[]{"The", "Browner", "Foxer"};
        Integer indexToRemove = 1;
        test(expectedItems, objectsToBeAdded, indexToRemove);
    }

    @Test
    public void test2() {
        String[] objectsToBeAdded = new String[]{"The", "Quicker", "Browner", "Foxer"};
        String[] expectedItems = new String[]{"The", "Quicker", "Browner"};
        Integer indexToRemove = 3;
        test(expectedItems, objectsToBeAdded, indexToRemove);
    }
}