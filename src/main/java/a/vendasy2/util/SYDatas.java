/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package a.vendasy2.util;


import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;


public class SYDatas {
    
    /**
     * Converte uma data para o formato java.sql.Date no padrão dos Estados Unidos (yyyy/MM/dd).
     * @param pData A data a ser convertida.
     * @return java.sql.Date A data convertida para o formato do banco de dados.
     * @throws Exception Caso ocorra um erro durante a conversão.
     */
    public java.sql.Date converterDataParaDateUS(Date pData) throws Exception {
        SimpleDateFormat formatarDate = new SimpleDateFormat("yyyy/MM/dd");
        String dataString = formatarDate.format(pData);
        if (pData == null || pData.equals(""))
            return null;
        java.sql.Date date = null;
        try {
            DateFormat formatter = new SimpleDateFormat("yyyy/MM/dd");
            date = new java.sql.Date(((java.util.Date) formatter.parse(dataString)).getTime());
        } catch (ParseException e) {
            throw e;
        }
        return date;
    }
}
