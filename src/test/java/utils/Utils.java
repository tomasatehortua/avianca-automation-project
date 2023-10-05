package utils;

import java.text.DateFormat;
import java.time.LocalDate;
import java.time.OffsetDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Random;

public class Utils {

    public static int getRandomNumber(int max) {
        return new Random().nextInt(max);
    }

    public static OffsetDateTime getCurrentDate() {
        OffsetDateTime date = OffsetDateTime.now();
        return date;
    }

    public static OffsetDateTime getRandomFutureDate() {
        OffsetDateTime date = OffsetDateTime.now().plusDays(getRandomNumber(10));
        return date;
    }

    public static String formattedDate(OffsetDateTime date){
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy.M.d");
        return date.format(formatter);
    }

    public static String getRandomDate(){
        return "";
    }

}
