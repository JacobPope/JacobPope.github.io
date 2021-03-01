## Code
```python
import json
from bson import json_util
from bson.json_util import loads
from pymongo import MongoClient

#Given the stock ticker, the desired updates, and the collection the document resides, this method will update or create the document for ticker
def documentUpdate(ticker, raw_json_input, collection):
  stock_id = {"Ticker": ticker}
  #Try to load raw json input
  try:
    update_data = loads(raw_json_input)
    update_data["Ticker"] = ticker
    update_data = {"$set" : update_data}
  except ValueError as ve:
    print(str(ve))
    return None
  
  try:
    update_results = collection.update_one(stock_id, update_data, upsert=True)
  except:
    #If update fails, return None
    return None

  #If updatedExisting == True, the document was updated; if false, a document was created for that ticker.
  if(update_results.raw_result["updatedExisting"] == True):
    return True
  else:
    return False
```

## Links
- [Return to Home](/index.md)
- [Return to Enhancement 2 Page](enhancement2.md)