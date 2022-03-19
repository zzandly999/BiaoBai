package com.atzz.mine.test;

import com.atzz.mine.utils.TimeUtils;
import org.junit.Test;

import java.sql.Time;
import java.sql.Timestamp;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * @author shkstart
 * @create 2022-03-18 9:24
 */
public class TimeTest {

    @Test
    public void timeTest(){
//        java.util.Date utilDate = new java.util.Date();
//        java.sql.Timestamp timestamp = new Timestamp(utilDate.getTime());
//        System.out.println(timestamp);
        Timestamp timestamp = TimeUtils.currentTime(new Date());
        System.out.println(timestamp);
    }

}
