/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package test;

import org.junit.*;
import static org.junit.Assert.*;
import services.DateTimeFunctions;

/**
 *
 * @author Vincent
 */
public class DaysInMonthTests {

    @Test
    public void UTCID01() {
       Byte expected = 0;
       Byte result = DateTimeFunctions.DaysInMonth(Short.parseShort("2000"), Byte.parseByte("-1"));
       assertEquals(expected, result);
    }
    
    @Test
    public void UTCID02() {
       Byte expected = 0;
       Byte result = DateTimeFunctions.DaysInMonth(Short.parseShort("-1"), Byte.parseByte("1"));
       assertEquals(expected, result);
    }
    
    @Test(expected = NullPointerException.class)
    public void UTCID03() {
       DateTimeFunctions.DaysInMonth(Short.parseShort("2000"), null);
    }
    
    @Test(expected = NullPointerException.class)
    public void UTCID04() {
       DateTimeFunctions.DaysInMonth(null, Byte.parseByte("3"));
    }
    
    @Test
    public void UTCID05() {
       Byte expected = 29;
       Byte result = DateTimeFunctions.DaysInMonth(Short.parseShort("2000"), Byte.parseByte("2"));
       assertEquals(expected, result);
    }
    
    @Test
    public void UTCID06() {
       Byte expected = 28;
       Byte result = DateTimeFunctions.DaysInMonth(Short.parseShort("2001"), Byte.parseByte("2"));
       assertEquals(expected, result);
    }
    
    @Test
    public void UTCID07() {
       Byte expected = 31;
       Byte result = DateTimeFunctions.DaysInMonth(Short.parseShort("2000"), Byte.parseByte("3"));
       assertEquals(expected, result);
    }
    
    @Test
    public void UTCID08() {
       Byte expected = 30;
       Byte result = DateTimeFunctions.DaysInMonth(Short.parseShort("2001"), Byte.parseByte("4"));
       assertEquals(expected, result);
    }
    
    @Test
    public void UTCID09() {
       Byte expected = 0;
       Byte result = DateTimeFunctions.DaysInMonth(Short.parseShort("2000"), Byte.parseByte("13"));
       assertEquals(expected, result);
    }
}
