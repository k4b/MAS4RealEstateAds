package common;
/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */


import org.lightcouch.CouchDbClient;
import org.lightcouch.Response;

import common.ads.Ad;

/**
 * Couch DB helper using LightCouch library. 
 * @author "Karol Abramczyk"
 *
 */
public class CouchDBHelper {
    
	/**
	 * CouchDB client object
	 */
    CouchDbClient dbClient;
    
    /**
     * Starts client connection with CouchBD
     * @param name CouchDB database name
     */
    public CouchDBHelper(String name) {
        dbClient = new CouchDbClient(name, true, "http", "127.0.0.1", 5984, "", "");
    }
    
    /**
     * Tests CouchDB connection and data manipulation
     */
    public void test() {
        Ad a = new Ad();
        a.setTitle("First ad");
        a.setPrice(200000);
        Response response = dbClient.save(a);
        String id = response.getId();
        Ad b = dbClient.find(Ad.class, id);
        System.out.println(b.toString());
    }
    
    /**
     * Saves object to CouchDB
     * @param object Object to save
     * @return CouchDB response object
     */
    public Response save(Object object) {
        return dbClient.save(object);
    }
    
}
