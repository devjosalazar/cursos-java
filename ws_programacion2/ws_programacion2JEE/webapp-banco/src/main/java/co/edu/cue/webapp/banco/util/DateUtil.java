package co.edu.cue.webapp.banco.util;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class DateUtil {


    public static Date formatearFecha(String fecha){
        Date fechaDate = null;
        SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
        try {
            fechaDate = dateFormat.parse(fecha);
        } catch (ParseException e) {
            e.printStackTrace();
        }
        return  fechaDate;
    }
}
