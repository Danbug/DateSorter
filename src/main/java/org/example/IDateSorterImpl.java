package org.example;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

public class IDateSorterImpl implements IDateSorter {
    private final Comparator<LocalDate> comparator = (firstDate, secondDate) -> {
        // compare years
        if (firstDate.getYear() > secondDate.getYear()) {
            return 1;
        } else if (firstDate.getYear() < secondDate.getYear()) {
            return -1;
        }

        // compare months
        if (firstDate.getMonthValue() > secondDate.getMonthValue()) {
            return 1;
        } else if (firstDate.getMonthValue() < secondDate.getMonthValue()) {
            return -1;
        }

        // compare days
        if (firstDate.getDayOfMonth() > secondDate.getDayOfMonth()) {
            return 1;
        } else if (firstDate.getDayOfMonth() < secondDate.getDayOfMonth()) {
            return -1;
        }

        // if nothing is bigger or less, then they are equal dates
        return 0;
    };

    /**
     * This method returns sorted dates.
     * Dates with an 'r' in the month,
     * sorted ascending (first to last),
     * then dates without an 'r' in the month,
     * sorted descending (last to first).
     * For example, October dates would come before May dates,
     * because October has an 'r' in it.
     * thus: (2005-07-01, 2005-01-02, 2005-01-01, 2005-05-03)
     * would sort to
     * (2005-01-01, 2005-01-02, 2005-07-01, 2005-05-03)
     *
     * @param unsortedDates - an unsorted list of dates
     * @return the collection of dates now sorted as per the spec
     */
    @Override
    public Collection<LocalDate> sortDates(List<LocalDate> unsortedDates) {
        List<LocalDate> dateListWithLetterR = new ArrayList<>();
        List<LocalDate> dateListWithoutLetterR = new ArrayList<>();

        // separate LocalDates that contain letter r and those who don't
        for (LocalDate localDate : unsortedDates
        ) {
            if (localDate.getMonth().toString().toLowerCase().contains("r")) {
                dateListWithLetterR.add(localDate);
            } else {
                dateListWithoutLetterR.add(localDate);
            }
        }

        // list where we will store all Sorted dates
        List<LocalDate> sortedDates = new ArrayList<>();
        sortedDates.addAll(sortAscending(dateListWithLetterR));
        sortedDates.addAll(sortDescending(dateListWithoutLetterR));
        return sortedDates;
    }

    private Collection<LocalDate> sortAscending(List<LocalDate> unsortedDates) {
        return unsortedDates.stream().sorted(comparator).collect(Collectors.toList());
    }

    private Collection<LocalDate> sortDescending(List<LocalDate> unsortedDates) {
        return unsortedDates.stream().sorted(comparator.reversed()).collect(Collectors.toList());
    }
}
