/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package services;

/**
 *
 * @author Vincent
 */
public class DateTimeFunctions {
    
    public static final Byte DaysInMonth(Short year, Byte month) {
        switch (month) {
            case 1:
            case 3:
            case 5:
            case 7:
            case 8:
            case 10:
            case 12:
                return 31;
                
            case 4:
            case 6:
            case 9:
            case 11:
                return 30;
                
            case 2:
                if ((year % 400) == 0) {
                    return 29;
                } else if ((year % 100) == 0) {
                    return 28;
                } else if ((year % 4) == 0) {
                    return 29;
                }
                return 28;
                
            default:
                return 0;
        }
    }
    
    public static final Boolean IsValidDate(Short year, Byte month, Byte day) {
        if (month < 1 || month > 12) {
            return false;
        }
        if (day < 1) {
            return false;
        }
        return day <= DaysInMonth(year, month);
    }
}
