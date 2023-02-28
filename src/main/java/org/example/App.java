package org.example;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * Hello world!
 *
 */
public class App 
{
    public static void main( String[] args ) {
        IDateSorterImpl sorter = new IDateSorterImpl();
        LocalDate dateIn1 = LocalDate.of(2005, 7,1);
        LocalDate dateIn2 = LocalDate.of(2005,1,2);
        LocalDate dateIn3 = LocalDate.of(2005,1,1);
        LocalDate dateIn4 = LocalDate.of(2005,5,3);
        // (2005-07-01, 2005-01-02, 2005-01-01, 2005-05-03)
        List<LocalDate> inputDateList = new ArrayList<>(Arrays.asList(dateIn1,dateIn2,dateIn3,dateIn4));
        // (2005-01-01, 2005-01-02, 2005-07-01, 2005-05-03)
        List<LocalDate> dateListExpected = new ArrayList<>(Arrays.asList(dateIn3,dateIn2,dateIn1,dateIn4));
        System.out.println("------------------------------------------------------------\nMain");
        System.out.println(sorter.sortDates(inputDateList).toString());
        System.out.println(dateListExpected);
        System.out.println( "Hello World!" );
    }
}
