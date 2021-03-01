package com.snhu.app;

import com.mongodb.BasicDBObject;
import com.mongodb.DBCollection;
import com.mongodb.DBObject;

public class documentRead {
    public static void getStock(String ticker, DBCollection coll){
        BasicDBObject query = new BasicDBObject("Ticker", ticker);
        DBObject result = coll.findOne(query);

        System.out.println(result.toString());
    }

    /*
     *
     * Implement methods from original project 
     * 
     */
}
