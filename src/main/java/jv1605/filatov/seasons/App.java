/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jv1605.filatov.seasons;


import java.text.ParseException;
import java.util.ResourceBundle;
import java.util.Date;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Locale;
/**
 *
 * @author Front-End
 */
public class App {
    
    static ResourceBundle bundle;
    static Locale ru = new Locale("ru", "RU");
    static Locale us = new Locale("en", "US");
    
    public static void main(String[] args) {
        
       printLocalizedDate();
       
       ResourceBundle usBundle = ResourceBundle.getBundle("seasons", us);
       ResourceBundle ruBundle = ResourceBundle.getBundle("seasons", ru);
       
       getSeasonName(getDate(usBundle.getString("seasons.date")), usBundle);
       getSeasonName(getDate(ruBundle.getString("seasons.date")), ruBundle);
        
    }
    
    public static void printLocalizedDate(){
        Date date = new Date(System.currentTimeMillis());
        String pattern = "E yyyy - MM - dd";
        SimpleDateFormat ruFormatter = new SimpleDateFormat(pattern, ru);
        SimpleDateFormat usFormatter = new SimpleDateFormat(pattern, us);
        System.out.println(ruFormatter.format(date));
        System.out.println(usFormatter.format(date));
    }
    
    static Date getDate(String s){
        SimpleDateFormat dateFormat = new SimpleDateFormat("dd.mm.yyyy");
        Date parsedDate = null; 
        try{
            parsedDate = dateFormat.parse(s);
        }catch(ParseException ex){
            System.out.println("cannot parse date");
        }    
        return parsedDate;
    }
    
    static void getSeasonName(Date date, ResourceBundle b){
        Calendar c = Calendar.getInstance();
        c.setTime(date);
        int month = c.get(Calendar.MONTH);
        month++;
        switch (month){
            case 12:
            case 1:
            case 2:{
                System.out.println(b.getString("seasons.winter"));
            }break;
            case 3:
            case 4:
            case 5:{
                System.out.println(b.getString("seasons.spring"));
            }break;
            case 6:
            case 7:
            case 8:{
                System.out.println(b.getString("seasons.summer"));
            }break;
            case 9:
            case 10:
            case 11:{
                System.out.println(b.getString("seasons.autumn"));
            }break;
        }
    }
    
}
