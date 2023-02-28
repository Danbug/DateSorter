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
public class IDateSorterImplTest extends TestCase {
    private final IDateSorter sorter = new IDateSorterImpl();

    public void testSortDatesGivenData() {
        LocalDate dateIn1 = LocalDate.of(2005, 7,1);
        LocalDate dateIn2 = LocalDate.of(2005,1,2);
        LocalDate dateIn3 = LocalDate.of(2005,1,1);
        LocalDate dateIn4 = LocalDate.of(2005,5,3);
        // (2005-07-01, 2005-01-02, 2005-01-01, 2005-05-03)
        List<LocalDate> inputDateList = new ArrayList<>(Arrays.asList(dateIn1,dateIn2,dateIn3,dateIn4));
        // (2005-01-01, 2005-01-02, 2005-07-01, 2005-05-03)
        List<LocalDate> dateListExpected = new ArrayList<>(Arrays.asList(dateIn3,dateIn2,dateIn1,dateIn4));

        List<LocalDate> actual = (List<LocalDate>) sorter.sortDates(inputDateList);

        assertEquals(actual,dateListExpected);
    }
}