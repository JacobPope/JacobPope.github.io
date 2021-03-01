package com.snhu.app;

import com.mongodb.BasicDBObject;
import com.mongodb.DBCollection;
import com.mongodb.WriteResult;
import com.mongodb.util.JSON;

public class documentUpdate {
    public static void updateDoc(String ticker, String updateQuery, DBCollection coll) {
        BasicDBObject query = new BasicDBObject("Ticker", ticker);
        BasicDBObject update = new BasicDBObject("$set", JSON.parse(updateQuery));

        WriteResult result = coll.update(query, update, true, false);
        System.out.println(result.toString());
    }

    /*
     *
     * Implement methods from original project 
     * 
     */
    
}
