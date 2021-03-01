## Code
```python
import json
from bson import json_util
from bson.json_util import loads
from pymongo import MongoClient


# Deletes the stock related to the inputted ticker
def deleteDocument(ticker, collection):
  query = {"Ticker" : ticker} 
  result = collection.delete_one(query)
  
  if result.deleted_count is 0:
    return False
  else:
    return True
```

## Links
- [Return to Home](/index.md)
- [Return to Enhancement 2 Page](enhancement2.md)