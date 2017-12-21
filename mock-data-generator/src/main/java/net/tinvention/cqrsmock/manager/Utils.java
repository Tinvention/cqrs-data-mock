package net.tinvention.cqrsmock.manager;

import java.text.SimpleDateFormat;
import java.util.Date;

public class Utils {

  public static String format(long msDate, String simpleDateFormat) {
    SimpleDateFormat df = new SimpleDateFormat(simpleDateFormat);
    Date date = new Date(msDate);
    return df.format(date).toString();
  }

}
