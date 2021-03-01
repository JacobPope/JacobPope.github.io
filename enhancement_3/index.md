## Code
```html
<!DOCTYPE html>
<html lang="en">
    <head>
        <meta charset="UTF-8">
        <meta name="viewport" content="width=device-width, initial-scale=1.0">
        <title>Home page</title>


    </head>
    <body>
        <script>
            function divChange(input) {
                var elementList = ['createForm', 'readForm', 'updateForm', 'deleteForm'];
                var i;
                for (i = 0; i < elementList.length; i++) {
                    if (input == i) {
                        document.getElementById(elementList[i]).style.display = "block";
                    }
                    else {
                        document.getElementById(elementList[i]).style.display = "none";
                    }
                }

            }

            function createActionUpdate() {
                document.getElementById("createF").action = "insertDocument/" + document.getElementById("cTicker").value;
            }

            function readActionUpdate() {
                window.location.href = "getStock/" + document.getElementById("rTicker").value;
            }

            function updateActionUpdate() {
                document.getElementById("updateF").action = "updateStock/" + document.getElementById("uTicker").value;
            }

            function deleteActionUpdate() {
                window.location.href = "deleteStock/" + document.getElementById("dTicker").value;
            }
        </script>

        <form>
            <input type="radio" name="choice" value="create" onClick="divChange(0);">Create
            <input type="radio" name="choice" value="read" onClick="divChange(1);">Read
            <input type="radio" name="choice" value="update" onClick="divChange(2);">Update
            <input type="radio" name="choice" value="delete" onClick="divChange(3);">Delete
        </form>

        <div id="body"></div>

        <div id = "createForm" style = "display:none">
            <form method="post" action="insertDocument" id = "createF">
                <div>
                    <label for="cTicker">Ticker:</label>
                    <input type="text" id="cTicker" name="cTicker">
                </div>
                <div>
                    <label for="rawDocJSON">Enter RAW JSON String for Stock:</label>
                    <input type="text" id="cRawDocJSON" name="rawDocJSON">
                </div>
                <button type="submit" onClick="createActionUpdate()">Submit</button>
            </form>
        </div>

        <div id = "readForm" style="display:none">
            <div>
                <label for="rTicker">Ticker:</label>
                <input type="text" id="rTicker" name="rTicker">
            </div>
            <button type="submit" onClick="readActionUpdate()">Submit</button>
        </div>

        <div id = "updateForm" style="display:none">
            <form method="post" action="" id = "updateF">
                <div>
                    <label for="uTicker">Ticker:</label>
                    <input type="text" id="uTicker" name="uTicker">
                </div>
                <div>
                    <label for="updateRawDocJSON">Enter RAW JSON String for Stock:</label>
                    <input type="text" id="updateRawDocJSON" name="updateRawDocJSON">
                </div>
                <button type="submit" onClick="updateActionUpdate()">Submit</button>
            </form>
        </div>

        <div id = "deleteForm" style="display:none">
            <div>
                <label for="dTicker">Ticker:</label>
                <input type="text" id="dTicker" name="dTicker">
            </div>
            <button type="submit" onClick="deleteActionUpdate()">Submit</button>
        </div>
    </body>
</html>
```

## Links
- [Return to Home](/index.md)
- [Return to Enhancement 3 Page](enhancement3.md)