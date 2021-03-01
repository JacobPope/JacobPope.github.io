## Code
```java
package com.snhu.app;

import com.mongodb.BasicDBObject;
import com.mongodb.DB;
import com.mongodb.DBCollection;
import com.mongodb.DBObject;
import com.mongodb.MongoClient;
import com.mongodb.WriteResult;
import com.mongodb.util.JSON;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class RESTController {
	//Returns the MongoDB collection to be used
	private DBCollection connectionSetup() {
		MongoClient mongo;
		DB db;
		DBCollection coll;
		
		try {
			mongo = new MongoClient("localhost", 27017);
			db = mongo.getDB("newDB");
			coll = db.getCollection("newColl");
			return coll;
		 } catch (Exception e) {
			System.out.println(e.toString());
			return null;
		 }
	}

	/**
	 * 
	 * Called when a stock is created through the below URI
	 * 
	 */
	@PostMapping("/stocks/api/v1.0/createStock/{ticker}")
	public String createStock(@RequestBody String input, @PathVariable String ticker) {
		//Establishes DB connection
		DBCollection coll = connectionSetup();
		if(coll == null) {
			String returnString = "Database Connection Error";
			return returnString;
		}

		//Parses the JSON data and creates the document.
		try {
			BasicDBObject payload = (BasicDBObject) JSON.parse(input);
			coll.insert(payload);
			String returnString = "Document Inserted";
			return returnString;
		} catch (Exception e) {
			System.err.println(e.getMessage());
			return e.getMessage();
		}
		
	}

	@GetMapping("/stocks/api/v1.0/getStock/{ticker}")
	public String getStock(@PathVariable String ticker) {
		//Establishes connection to MongoDB Server
		DBCollection coll = connectionSetup();
		if(coll == null) {
			String returnString = "Database Connection Error";
			return returnString;
		}

		try {
			BasicDBObject query = new BasicDBObject("Ticker", ticker);
			DBObject result = coll.findOne(query);
			return result.toString();
		} catch (Exception e) {
			System.err.println(e.getMessage() + "\n");
			return e.getMessage();
		}
	}

	@PutMapping("/stocks/api/v1.0/updateStock/{ticker}")
	public String updateStock(@RequestBody String updateQuery, @PathVariable String ticker) {

		//Establishes DB connection
		DBCollection coll = connectionSetup();
		if(coll == null) {
			String returnString = "Database Connection Error";
			return returnString;
		}

		try {
			BasicDBObject query = new BasicDBObject("Ticker", ticker);
        	BasicDBObject update = new BasicDBObject("$set", JSON.parse(updateQuery));
        	WriteResult result = coll.update(query, update, true, false);
        	return result.toString();
		} catch (Exception e) {
			System.err.println(e.getMessage());
			return e.getMessage();
		}
		
	}
	/**
	 * 
	 * Deletes stock connected to the provided ticker
	 * 
	 */
	@RequestMapping("/stocks/api/v1.0/deleteStock/{ticker}")
	public String deleteStock(@PathVariable String ticker) {
		//Establishes DB connection
		DBCollection coll = connectionSetup();
		if(coll == null) {
			String returnString = "Database Connection Error";
			return returnString;
		}
		//Deletes stock or returns error message if unable to delete stock.
		try {
			BasicDBObject query = new BasicDBObject("Ticker", ticker);
			WriteResult result = coll.remove(query);
			return result.toString();
		} catch (Exception e) {
			System.err.println(e.getMessage() + "\n");
			return e.getMessage();
		}
	}
}
```

## Links
- [Return to Home](../../../index.md)
- [Return to Enhancement 1 Page](../../enhancement1.md)