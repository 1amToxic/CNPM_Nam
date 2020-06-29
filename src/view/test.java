/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package view;

import java.time.DayOfWeek;
import java.time.LocalDate;
import java.time.YearMonth;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;
import org.joda.time.DateTimeConstants;
import org.joda.time.format.DateTimeFormat;

/**
 *
 * @author lamit
 */
public class test {
    public static void main(String[] args) {
         LocalDate start = LocalDate.of(2013, 5, 10);
    LocalDate end = LocalDate.of(2013, 8,30);

    DayOfWeek dowOfStart = start.getDayOfWeek();
    int difference = DayOfWeek.FRIDAY.getValue() - dowOfStart.getValue();
    if (difference < 0) difference += 7;

    List<LocalDate> fridaysInRange = new ArrayList<LocalDate>();

    LocalDate currentFriday = start.plusDays(difference);
    do {
        fridaysInRange.add(currentFriday);
        currentFriday = currentFriday.plusDays(7);
    } while (currentFriday.isBefore(end));

    System.out.println("Fridays in range: " + fridaysInRange);
    }
}
