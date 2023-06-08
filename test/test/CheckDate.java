/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package test;

import static org.junit.Assert.*;
import org.junit.Test;
import services.DateTimeFunctions;

/**
 *
 * @author Vincent
 */
public class CheckDate {
    
    @Test
    public void UTCID01() {
       boolean result = DateTimeFunctions.IsValidDate(Short.parseShort("2000")
               , Byte.parseByte("2"), Byte.parseByte("-1"));
       assertFalse(result);
    }
    
    @Test
    public void UTCID02() {
       boolean result = DateTimeFunctions.IsValidDate(Short.parseShort("2020")
               , Byte.parseByte("13"), Byte.parseByte("31"));
       assertFalse(result);
    }
    
    @Test
    public void UTCID03() {
       boolean result = DateTimeFunctions.IsValidDate(Short.parseShort("3001")
               , Byte.parseByte("3"), Byte.parseByte("30"));
       assertFalse(result);
    }
    
    @Test
    public void UTCID04() {
       boolean result = DateTimeFunctions.IsValidDate(Short.parseShort("2000")
               , Byte.parseByte("2"), Byte.parseByte("28"));
       assertTrue(result);
    }
    
    @Test
    public void UTCID05() {
       boolean result = DateTimeFunctions.IsValidDate(Short.parseShort("2020")
               , Byte.parseByte("2"), Byte.parseByte("29"));
       assertTrue(result);
    }
    
    @Test
    public void UTCID06() {
       boolean result = DateTimeFunctions.IsValidDate(Short.parseShort("2000")
               , Byte.parseByte("2"), Byte.parseByte("30"));
       assertFalse(result);
    }
    
    @Test
    public void UTCID07() {
       boolean result = DateTimeFunctions.IsValidDate(Short.parseShort("2009")
               , Byte.parseByte("2"), Byte.parseByte("28"));
       assertTrue(result);
    }
    
    @Test
    public void UTCID08() {
       boolean result = DateTimeFunctions.IsValidDate(Short.parseShort("2009")
               , Byte.parseByte("2"), Byte.parseByte("29"));
       assertFalse(result);
    }
    
    @Test
    public void UTCID09() {
       boolean result = DateTimeFunctions.IsValidDate(Short.parseShort("2009")
               , Byte.parseByte("2"), Byte.parseByte("30"));
       assertFalse(result);
    }
    
    @Test
    public void UTCID10() {
       boolean result = DateTimeFunctions.IsValidDate(Short.parseShort("2000")
               , Byte.parseByte("3"), Byte.parseByte("29"));
       assertTrue(result);
    }
    
    @Test
    public void UTCID11() {
       boolean result = DateTimeFunctions.IsValidDate(Short.parseShort("2009")
               , Byte.parseByte("3"), Byte.parseByte("30"));
       assertTrue(result);
    }
    
    @Test
    public void UTCID12() {
       boolean result = DateTimeFunctions.IsValidDate(Short.parseShort("2020")
               , Byte.parseByte("3"), Byte.parseByte("31"));
       assertTrue(result);
    }
    
    @Test
    public void UTCID13() {
       boolean result = DateTimeFunctions.IsValidDate(Short.parseShort("2000")
               , Byte.parseByte("4"), Byte.parseByte("29"));
       assertTrue(result);
    }
    
    @Test
    public void UTCID14() {
       boolean result = DateTimeFunctions.IsValidDate(Short.parseShort("2009")
               , Byte.parseByte("4"), Byte.parseByte("30"));
       assertTrue(result);
    }
    
    @Test
    public void UTCID15() {
       boolean result = DateTimeFunctions.IsValidDate(Short.parseShort("2020")
               , Byte.parseByte("4"), Byte.parseByte("31"));
       assertFalse(result);
    }
    
    @Test(expected = NullPointerException.class)
    public void UTCID16() {
        DateTimeFunctions.IsValidDate(Short.parseShort("2000"),
                Byte.parseByte("3"), null);
    }
    
    @Test(expected = NullPointerException.class)
    public void UTCID17() {
        DateTimeFunctions.IsValidDate(Short.parseShort("2009"),
                null, Byte.parseByte("29"));
    }
    
    @Test(expected = NullPointerException.class)
    public void UTCID18() {
        DateTimeFunctions.IsValidDate(null,
                Byte.parseByte("4"), Byte.parseByte("30"));
    }
}
