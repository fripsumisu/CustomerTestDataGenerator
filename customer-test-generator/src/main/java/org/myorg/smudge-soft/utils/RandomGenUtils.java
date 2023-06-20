package org.myorg.smudge-soft.utils;

import java.time.DateTimeException;
import java.time.LocalDate;
import java.time.Month;
import java.util.Random;
import java.util.concurrent.ThreadLocalRandom;

/**
 * Shamelessly but lovingly plaigirised from https://github.com/eugenp/tutorials/tree/master/core-java-modules/core-java-8-datetime-2
 * and https://www.baeldung.com/java-random-string
 */
public class RandomGenUtils {


    public static LocalDate getRandomHistoricDate(int startYear, int yearsBeforeToday) {

        if(startYear < 1880 || startYear > 2021) {
            throw new DateTimeException("Invalid startYear unsupported. Cannot process value: " + startYear);
        }

        if(startYear >= LocalDate.now().getYear()) {
            throw new DateTimeException("Invalid startYear unsupported. Cannot process value: " + startYear);
        }

        if(yearsBeforeToday < 0) {
            throw new DateTimeException("Invalid yearsBeforeToday. Cannot be less than zero: " + yearsBeforeToday);
        }

        Month randomMonth = Month.of(12);

        LocalDate start = LocalDate.of(startYear, randomMonth, 28);
        LocalDate end = LocalDate.now().minusYears(yearsBeforeToday);
        LocalDate randomDate = RandomGenUtils.getDateBetween(start, end);

        return randomDate;
    }

    public static LocalDate getDateBetween(LocalDate startInclusive, LocalDate endExclusive) {
        long startEpochDay = startInclusive.toEpochDay();
        long endEpochDay = endExclusive.toEpochDay();
        long randomDay = ThreadLocalRandom.current().nextLong(startEpochDay, endEpochDay);

        return LocalDate.ofEpochDay(randomDay);
    }

    public static LocalDate date() {
        int hundredYears = 100 * 365;
        return LocalDate.ofEpochDay(ThreadLocalRandom.current().nextInt(-hundredYears, hundredYears));
    }

    public static char getRandomChar() {

        int leftLimit = 97; // letter 'a'
        int rightLimit = 122; // letter 'z'
        int targetStringLength = 10;
        Random random = new Random();

        String generatedChar = random.ints(leftLimit, rightLimit + 1)
                .limit(1)
                .collect(StringBuilder::new, StringBuilder::appendCodePoint, StringBuilder::append)
                .toString();

        return generatedChar.toUpperCase().charAt(0);

    }

}