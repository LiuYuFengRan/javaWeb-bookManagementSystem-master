package util;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * @desc 日期工具
 **/
public class DateUtil {
    public static String DateToStr(Date date){
        if (date==null)return "";
        System.out.println("传来的日期："+date);
        SimpleDateFormat sdf=new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        String format = sdf.format(date);
        System.out.println("格式化后日期："+format);
        return format;
    }
    public static Date StrToDate(String dateStr){
       if (dateStr==null||"".equalsIgnoreCase(dateStr))return  null;
        SimpleDateFormat sdf=new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        try {
            Date parseDate = sdf.parse(dateStr);
            return parseDate;
        } catch (ParseException e) {
            e.printStackTrace();
        }
        return null;
    }
}
