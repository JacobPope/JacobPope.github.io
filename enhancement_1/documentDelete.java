package com.snhu.app;

import com.mongodb.BasicDBObject;
import com.mongodb.DBCollection;
import com.mongodb.WriteResult;


public class documentDelete {

    public static void deleteStock(String ticker, DBCollection coll) {
        BasicDBObject query = new BasicDBObject("Ticker", ticker);
        WriteResult result = coll.remove(query);

        System.out.println(result.toString());
    }

    /*
     *
     * Implement methods from original project 
     * 
     */

}
