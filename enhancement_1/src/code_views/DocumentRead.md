## Code
```java
package com.snhu.app;

import com.mongodb.BasicDBObject;
import com.mongodb.DBCollection;
import com.mongodb.DBObject;

public class DocumentRead {
    public static void getStock(String ticker, DBCollection coll){
        BasicDBObject query = new BasicDBObject("Ticker", ticker);
        DBObject result = coll.findOne(query);

        System.out.println(result.toString());
    }
}
```

## Links
- [Return to Home](../../../index.md)
- [Return to Enhancement 1 Page](../../enhancement1.md)