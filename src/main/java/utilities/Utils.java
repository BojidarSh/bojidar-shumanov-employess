package utilities;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.concurrent.TimeUnit;

/**
 * Utils containing static methods about some basic operations.
 */
public class Utils {

    public static final String DATA_FILE = "/data.txt";

    //the format of the date
    public static final String format = "yyyy-MM-dd";

    /**
     * Parses String to int. If exception occurs it logs the event and returns -1.
     * That way we know that the id of employee or of project is not a number.
     *
     * @param text the text
     * @return int
     */
    public static int parseInt(String text) {

        int empId = -1;
        try {
            empId = Integer.valueOf(text);
        } catch (NumberFormatException nfe) {
            System.err.println("The string [" + text + "] provided is not integer.");
        }

        return empId;
    }

    /**
     * Converts a date from string.
     * If the string equals to "null" it initiates the date to be today.
     *
     * @param date
     * @return
     */
    public static Date convert(String format, String date) {
        SimpleDateFormat sdf = new SimpleDateFormat(format);

        if (date.equalsIgnoreCase("NULL")) {
            return new Date();
        }

        Date firstDate = null;
        try {
            firstDate = sdf.parse(date);
        } catch (ParseException e) {
            System.err.println("The string [" + date + "] provided is not valid date format.");
        }
        return firstDate;
    }

    /**
     * By two strings which represent dates parsed both dates and calculates the interval between the two dates.
     * The interval is returned in days.
     *
     * @param first
     * @param second
     * @return
     */
    public static long calculateInterval(String first, String second) {

        Date firstDate = convert(format, first);
        Date secondDate = convert(format, second);

        long diffInMillies = Math.abs(secondDate.getTime() - firstDate.getTime());
        return TimeUnit.DAYS.convert(diffInMillies, TimeUnit.MILLISECONDS);
    }
}
