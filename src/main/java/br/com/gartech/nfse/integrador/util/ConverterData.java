/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.gartech.nfse.integrador.util;

import java.text.SimpleDateFormat;
import java.util.Calendar;

/**
 *
 * @author Gilson
 */
public class ConverterData extends org.jdesktop.beansbinding.Converter {

    SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
    
    @Override
    public Object convertForward(Object value) {
        Calendar c = (Calendar) value;
        return sdf.format(c.getTime());
    }

    @Override
    public Object convertReverse(Object value) {
        String str = (String)value;
        Calendar c = Calendar.getInstance();
        try {
            c.setTime(sdf.parse(str));
            return c;
        } catch(Exception e) {
            return null;
        }
    }
    
}
