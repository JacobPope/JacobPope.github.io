## Code - This is an HTML template that is returned when the user requests a stock.
```html
<!DOCTYPE html>
<html lang="en">

<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Home page</title>
    <script>
        function prettyJson() {
            var input = "<tr><td>" + '{{d}}';
            input = input.slice(0,-2);
            input = input + "</td></tr>";
            input = input.replace("{", "")
            input = input.replaceAll(",", "</td></tr><tr><td>");
            input = input.replaceAll("}", "}</td></tr>");

            document.getElementById("stockTable").innerHTML = input;
        }
    </script>
    
</head>

<body onLoad="prettyJson()">

    <table id = "stockTable">
    </table>

</body>

</html>
```

## Links
- [Return to Home](/index.md)
- [Return to Enhancement 2 Page](enhancement2.md)