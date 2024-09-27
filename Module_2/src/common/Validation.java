package common;

import java.util.regex.Pattern;

public class Validation {

    public final static String REG_YEAR = "^[12][0-9]{3}$";
    public final static String REG_DAY_ISO = "^(18[0-9]{2}|19[0-9]{2}|20[0-4][0-9]|2050)-(0[1-9]|1[0-2])-(0[1-9]|[12][0-9]|3[01])$";
    public static final String REG_EMAIL = "^[a-zA-Z0-9._%+-]+@[a-zA-Z0-9.-]+\\.[a-zA-Z]{2,}$";
    public static Boolean checkRegex(String Patten,String number){
        return Pattern.matches(Patten,number);
    }
}
