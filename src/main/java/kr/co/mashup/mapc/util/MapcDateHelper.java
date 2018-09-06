package kr.co.mashup.mapc.util;

import java.sql.Timestamp;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;

public class MapcDateHelper {

    public static boolean compareTime(Date bookingDate) {
        SimpleDateFormat mSimpleDateFormat = new SimpleDateFormat("yyyy.MM.dd", Locale.KOREA);
        Date currentTime = new Date();
        String curTime = mSimpleDateFormat.format(currentTime);
        String strBookingDate = mSimpleDateFormat.format(bookingDate);
        return curTime.equals(strBookingDate);
    }
}
