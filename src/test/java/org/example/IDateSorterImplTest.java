package org.example;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import junit.framework.TestCase;

/*
 * thus: (2005-07-01, 2005-01-02, 2005-01-01, 2005-05-03)
 * would sort to
 * (2005-01-01, 2005-01-02, 2005-07-01, 2005-05-03)
 */

/*
 * Months with letter R     | Months without letter R
 * January      (1)         | May       (5)
 * February     (2)         | June      (6)
 * March        (3)         | July      (7)
 * April        (4)         | August    (8)
 * September    (9)         |
 * October      (10)        |
 * November     (11)        |
 * December     (12)        |
 */
public class IDateSorterImplTest extends TestCase {
    private final IDateSorter sorter = new IDateSorterImpl();

    public void testAllMonthsWithRAlreadySorted() {
        LocalDate dateIn1 = LocalDate.of(2005, 1, 1);
        LocalDate dateIn2 = LocalDate.of(2005, 2, 2);
        LocalDate dateIn3 = LocalDate.of(2005, 3, 1);
        LocalDate dateIn4 = LocalDate.of(2005, 4, 3);
        LocalDate dateIn5 = LocalDate.of(2005, 9, 1);
        LocalDate dateIn6 = LocalDate.of(2005, 10, 2);
        LocalDate dateIn7 = LocalDate.of(2005, 11, 1);
        LocalDate dateIn8 = LocalDate.of(2005, 12, 3);

        List<LocalDate> inputDateList = new ArrayList<>(Arrays.asList(dateIn1, dateIn2, dateIn3, dateIn4,
            dateIn5, dateIn6, dateIn7, dateIn8));
        List<LocalDate> dateListExpected = new ArrayList<>(Arrays.asList(dateIn1, dateIn2, dateIn3, dateIn4,
            dateIn5, dateIn6, dateIn7, dateIn8));

        List<LocalDate> actual = (List<LocalDate>) sorter.sortDates(inputDateList);

        assertEquals(actual, dateListExpected);

    }

    public void testAllMonthsWithRReverseSorted() {
        LocalDate dateIn1 = LocalDate.of(2005, 12, 3);
        LocalDate dateIn2 = LocalDate.of(2005, 11, 1);
        LocalDate dateIn3 = LocalDate.of(2005, 10, 2);
        LocalDate dateIn4 = LocalDate.of(2005, 9, 1);
        LocalDate dateIn5 = LocalDate.of(2005, 4, 3);
        LocalDate dateIn6 = LocalDate.of(2005, 3, 1);
        LocalDate dateIn7 = LocalDate.of(2005, 2, 2);
        LocalDate dateIn8 = LocalDate.of(2005, 1, 1);


        List<LocalDate> inputDateList = new ArrayList<>(Arrays.asList(dateIn1, dateIn2, dateIn3, dateIn4,
            dateIn5, dateIn6, dateIn7, dateIn8));
        List<LocalDate> dateListExpected = new ArrayList<>(Arrays.asList(dateIn8, dateIn7, dateIn6, dateIn5,
            dateIn4, dateIn3, dateIn2, dateIn1));

        List<LocalDate> actual = (List<LocalDate>) sorter.sortDates(inputDateList);

        assertEquals(actual, dateListExpected);

    }

    public void testAllMonthsWithRRandom() {
        LocalDate dateIn1 = LocalDate.of(2005, 12, 3);
        LocalDate dateIn2 = LocalDate.of(2005, 3, 1);
        LocalDate dateIn3 = LocalDate.of(2005, 9, 2);
        LocalDate dateIn4 = LocalDate.of(2005, 10, 1);
        LocalDate dateIn5 = LocalDate.of(2005, 4, 3);
        LocalDate dateIn6 = LocalDate.of(2005, 11, 1);
        LocalDate dateIn7 = LocalDate.of(2005, 2, 2);
        LocalDate dateIn8 = LocalDate.of(2005, 1, 1);


        List<LocalDate> inputDateList = new ArrayList<>(Arrays.asList(dateIn1, dateIn2, dateIn3, dateIn4,
            dateIn5, dateIn6, dateIn7, dateIn8));
        List<LocalDate> dateListExpected = new ArrayList<>(Arrays.asList(dateIn8, dateIn7, dateIn2, dateIn5,
            dateIn3, dateIn4, dateIn6, dateIn1));

        List<LocalDate> actual = (List<LocalDate>) sorter.sortDates(inputDateList);

        assertEquals(actual, dateListExpected);

    }

    public void testAllMonthsWithoutRSorted() {
        LocalDate dateIn1 = LocalDate.of(2005, 5, 1);
        LocalDate dateIn2 = LocalDate.of(2005, 6, 2);
        LocalDate dateIn3 = LocalDate.of(2005, 7, 1);
        LocalDate dateIn4 = LocalDate.of(2005, 8, 3);

        List<LocalDate> inputDateList = new ArrayList<>(Arrays.asList(dateIn1, dateIn2, dateIn3, dateIn4));
        List<LocalDate> dateListExpected = new ArrayList<>(Arrays.asList(dateIn4, dateIn3, dateIn2, dateIn1));

        List<LocalDate> actual = (List<LocalDate>) sorter.sortDates(inputDateList);

        assertEquals(actual, dateListExpected);

    }

    public void testAllMonthsWithoutRReverseSorted() {
        LocalDate dateIn1 = LocalDate.of(2005, 5, 1);
        LocalDate dateIn2 = LocalDate.of(2005, 6, 2);
        LocalDate dateIn3 = LocalDate.of(2005, 7, 1);
        LocalDate dateIn4 = LocalDate.of(2005, 8, 3);

        List<LocalDate> inputDateList = new ArrayList<>(Arrays.asList(dateIn1, dateIn2, dateIn3, dateIn4));
        List<LocalDate> dateListExpected = new ArrayList<>(Arrays.asList(dateIn4, dateIn3, dateIn2, dateIn1));

        List<LocalDate> actual = (List<LocalDate>) sorter.sortDates(inputDateList);

        assertEquals(actual, dateListExpected);

    }

    public void testAllMonthsWithoutRRandom() {
        LocalDate dateIn1 = LocalDate.of(2005, 7, 1);
        LocalDate dateIn2 = LocalDate.of(2005, 6, 2);
        LocalDate dateIn3 = LocalDate.of(2005, 5, 1);
        LocalDate dateIn4 = LocalDate.of(2005, 8, 3);

        List<LocalDate> inputDateList = new ArrayList<>(Arrays.asList(dateIn1, dateIn2, dateIn3, dateIn4));
        List<LocalDate> dateListExpected = new ArrayList<>(Arrays.asList(dateIn4, dateIn1, dateIn2, dateIn3));

        List<LocalDate> actual = (List<LocalDate>) sorter.sortDates(inputDateList);

        assertEquals(actual, dateListExpected);

    }


    public void testSortDatesGivenData() {
        LocalDate dateIn1 = LocalDate.of(2005, 7, 1);
        LocalDate dateIn2 = LocalDate.of(2005, 1, 2);
        LocalDate dateIn3 = LocalDate.of(2005, 1, 1);
        LocalDate dateIn4 = LocalDate.of(2005, 5, 3);
        // (2005-07-01, 2005-01-02, 2005-01-01, 2005-05-03)
        List<LocalDate> inputDateList = new ArrayList<>(Arrays.asList(dateIn1, dateIn2, dateIn3, dateIn4));
        // (2005-01-01, 2005-01-02, 2005-07-01, 2005-05-03)
        List<LocalDate> dateListExpected = new ArrayList<>(Arrays.asList(dateIn3, dateIn2, dateIn1, dateIn4));

        List<LocalDate> actual = (List<LocalDate>) sorter.sortDates(inputDateList);

        assertEquals(actual, dateListExpected);
    }
}