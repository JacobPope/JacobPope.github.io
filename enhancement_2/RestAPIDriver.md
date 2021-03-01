## Code
```python
import json
from re import error
from bson import json_util
from bson.json_util import loads
from bottle import Bottle, HTTPResponse, route, run, request, abort
from pymongo import MongoClient
import pymongo

import DocumentCreate
import DocumentRead
import DocumentUpdate
import DocumentDelete

connection = MongoClient('localhost', 27017)
db = connection['market']
collection = db['stocks']

# Creates a new stock with provided ticker/json data
@route('/stocks/api/v1.0/createStock/<ticker>', method='POST')
def create_stock(ticker):
  raw_json_data = request.body.read()
  createResult = DocumentCreate.insert_document(ticker, raw_json_data, collection)
  
  if type(createResult) != json.decoder.JSONDecodeError:
    return HTTPResponse(status=400, body=("Invalid POST Input - Verify JSON Formatting"))
  elif createResult == True:
    return HTTPResponse(status=201, body=("Stock " + ticker + " created\n"))
  elif type(createResult) == pymongo.errors.DuplicateKeyError:
    return HTTPResponse(status=409, body=("Stock " + ticker + " already exists.\n"))
  else:
    return HTTPResponse(status=404, body=str(type(createResult)))
  
  
# Retrieves document using ticker as the index
@route('/stocks/api/v1.0/getStock/<ticker>', method='GET')
def get_stock(ticker):
  stock = DocumentRead.find_one_stock(ticker, collection)

  if stock is None:
    return HTTPResponse(status=400, body='Stock does not exist')
  else:
    return HTTPResponse(status=200, body=str(stock))

# Updates stock with given ticker and JSON data
@route('/stocks/api/v1.0/updateStock/<ticker>', method="PUT")
def update_stock(ticker):
  raw_json_data = request.body.readline()
  update_result = DocumentUpdate.documentUpdate(ticker, raw_json_data, collection)
  
  if(update_result == True):
    return HTTPResponse(status=200, body=str(ticker + ' has been updated'))
  elif(update_result == False):
    return HTTPResponse(status=200, body=str(ticker + ' has been created.'))
  elif(update_result == None):
    return HTTPResponse(status=400, body=str('Update request for ' + ticker + ' has failed.'))
  
# Deletes stock with provided ticker
@route('/stocks/api/v1.0/deleteStock/<ticker>')
def delete_stock(ticker):
  delete_result = DocumentDelete.deleteDocument(ticker, collection)
  
  if delete_result:
    return HTTPResponse(status=200, body='Stock deletion completed.')
  else:
    return HTTPResponse(status=200, body='Stock deletion failed.')
  
if __name__ == '__main__':
  run(host='localhost', port=8080)  
```

## Links
- [Return to Home](/index.md)
- [Return to Enhancement 2 Page](enhancement2.md)