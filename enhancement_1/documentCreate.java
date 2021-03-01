/*
 * This program serves to manually upload documents into a MongoDB from a json file.
 */

package com.snhu.app;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.List;
import com.mongodb.BasicDBObject;
import com.mongodb.util.JSON;
import com.mongodb.DBCollection;


public class documentCreate 
{
    /**
     * 
     * This method serves to load raw stock data from a provided json file.
     * Inputs: fileName is the name of the file to load the data.
     *         coll is the MongoDB collection
     * 
     * Returns nothing.
     */
    public static void loadFile(String fileName, DBCollection coll) {
        try {
            //Reads all lines from specified file, and stores the information in an array.
            String[] fileContentsArray;
            File tempFile = new File(fileName);
            if(tempFile.exists() == true) {
                List<String> fileContents = Files.readAllLines(Paths.get(fileName));
                fileContentsArray = new String[fileContents.size()];
                fileContents.toArray(fileContentsArray);
            } else {
                return;
            }

            //Inserts document into the provided MongoDB collection.
            int totalInsertCount = 0;
            for (String document : fileContentsArray) {
                try {
                    BasicDBObject payload = (BasicDBObject) JSON.parse(document);
                    coll.insert(payload);
                    totalInsertCount++;
                } catch (Exception e) {
                    System.err.println(e.getMessage() + "\n");
                }
            }

            //Outputs number of documents inserted and number of documents that failed to insert.
            int failedInsertCount = fileContentsArray.length - totalInsertCount;
            System.out.println(totalInsertCount + " document(s) inserted.");

            if(failedInsertCount > 0) {
                System.out.println(failedInsertCount + " document(s) failed to insert, please view error messages.");
            } else {
                System.out.println("0 documents failed to insert.");
            }
        } catch (IOException e) {
            e.printStackTrace();
        }


    }


}
