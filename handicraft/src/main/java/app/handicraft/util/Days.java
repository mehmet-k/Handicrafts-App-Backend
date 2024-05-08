package app.handicraft.util;

import java.time.DayOfWeek;
import java.util.ArrayList;
import java.util.List;

public class Days {
    public static List<String> convertDaysEnumListToStringList(List<DayOfWeek> days){
        if(days.isEmpty()){
            return null;
        }
        List<String> daysString = new ArrayList<>();
        for(DayOfWeek d:days){
            daysString.add(d.name());
        }
        return daysString;
    }

    public static String convertDayEnumToString(DayOfWeek day){
        return day.name();
    }
}
