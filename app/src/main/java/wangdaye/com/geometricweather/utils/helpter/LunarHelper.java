package wangdaye.com.geometricweather.utils.helpter;

import androidx.annotation.Size;

import com.tencent.bugly.crashreport.CrashReport;
import com.xhinliang.lunarcalendar.LunarCalendar;

import java.util.Calendar;

/**
 * Lunar helper.
 * */

public class LunarHelper {

    public static String getLunarDate(@Size(3) String[] dates) {
        return getLunarDate(
                Integer.parseInt(dates[0]),
                Integer.parseInt(dates[1]),
                Integer.parseInt(dates[2]));
    }

    public static String getLunarDate(Calendar calendar) {
        return getLunarDate(
                calendar.get(Calendar.YEAR),
                calendar.get(Calendar.MONTH) + 1,
                calendar.get(Calendar.DAY_OF_MONTH));
    }

    private static String getLunarDate(int year, int month, int day) {
        try {
            LunarCalendar lunarCalendar = LunarCalendar.obtainCalendar(year, month, day);
            return lunarCalendar.getFullLunarStr().split("年")[1];
        } catch (Exception e) {
            e.printStackTrace();
            CrashReport.postCatchedException(e);
            return "";
        }
    }
}
