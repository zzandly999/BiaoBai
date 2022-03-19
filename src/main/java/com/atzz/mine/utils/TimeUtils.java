package com.atzz.mine.utils;

import java.sql.Timestamp;
import java.text.DateFormat;
import java.text.SimpleDateFormat;

/**
 * @author shkstart
 * @create 2022-03-18 9:52
 */
public abstract class TimeUtils {

    public static java.sql.Timestamp currentTime(java.util.Date date){
        java.sql.Timestamp timestamp = new Timestamp(date.getTime());
        return timestamp;
    }


}
