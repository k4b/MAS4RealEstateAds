package common;
/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */


import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Collection;
import java.util.HashSet;
import java.util.List;
import ads.Ad;

/**
 * Custom utility functions required in this project
 * @author Karol Abramczyk
 */
public class Utils {
    
    public static String arrayToString( Collection<Object> col) {
        String s = "";
        for(Object o : col) {
            s += o.toString() + "\n";
        }
        return s;
    }
    
    public static ArrayList removeDuplicates(ArrayList list) {
        HashSet noDuplicates = new HashSet();
        noDuplicates.addAll(list);
        
        list.clear();
        list.addAll(noDuplicates);
        return list;
    }
    
    public static void saveToDB(String dbName, ArrayList<Ad> ads) {
        System.out.println("Writing to DB: " + dbName);
        CouchDBHelper dbHelper = new CouchDBHelper(dbName);
        for(Ad a : ads) {
            dbHelper.save(a);
        }
    }
}
