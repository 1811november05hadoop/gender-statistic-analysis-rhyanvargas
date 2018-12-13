package com.revature.helpers;

import java.text.DecimalFormat;
/**
 * FormatDecimal
 */
public class FormatDecimal {
    public static double formatDecimal(double decimal) {
        DecimalFormat df = new DecimalFormat(".###");
        decimal = Double.parseDouble(df.format(decimal));
        return decimal;
    }

}