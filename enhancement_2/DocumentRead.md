## Code
```python
import json
from bson import json_util
from bson.json_util import loads
from pymongo import MongoClient

def find_one_stock(ticker, collection):
  query = {"Ticker" : ticker}
  stock = collection.find_one(query)

  return stock

# Returns count of stocks that have the 50 day average between the low and high inputs
def stocks_find_50_day_average(low, high, collection):
  query = {"50-Day Simple Moving Average" : { "$gt" :  low, "$lt" : high}}
  stock_total = collection.find(query).count()
  
  return stock_total

#Find all stocks in supplied industry
def find_stocks_in_industry(industry, collection):
  filter_parameters = {"Ticker": 1, "_id": 0}
  industry = {"Industry" : industry}
  
  stocks = list(collection.find(industry, filter_parameters))
  
  return stocks
 ```

## Links
- [Return to Home](/index.md)
- [Return to Enhancement 2 Page](enhancement2.md)