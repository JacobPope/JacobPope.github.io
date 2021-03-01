package com.snhu.app;

import com.mongodb.MongoClient;
import com.mongodb.DB;
import com.mongodb.DBCollection;

/*
 * This file serves to test the functionality of the 4 document programs
 */
public class FunctionalityTestApp 
{
   public static void main( String[] args ) {
      MongoClient mongo;
      DB db;
      DBCollection coll;

      try {
         mongo = new MongoClient("localhost", 27017);
         db = mongo.getDB("newDB");
         coll = db.getCollection("newColl");
 
      } catch (Exception e) {
         System.out.println(e.toString());
         return;
      }

     //documentCreate.loadFile("src/main/test.json", coll);
     //documentDelete.deleteStock("TEST", coll);
     //documentRead.getStock("ZZZY", coll);
     documentUpdate.updateDoc("TEST", "{\"Value\" : 6}", coll);
   }

}
