package com.smbms.util;

import java.text.SimpleDateFormat;
import java.util.Date;

public class DateUtil {
    private static   SimpleDateFormat s=new SimpleDateFormat("yyyy-MM-dd");
    public static String date(Date date){
        return s.format(date);
    }
}
