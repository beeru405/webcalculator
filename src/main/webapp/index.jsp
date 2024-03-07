<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Calculator</title>
    <style>
        body {
            font-family: 'Segoe UI', Tahoma, Geneva, Verdana, sans-serif;
            background-color: #f7f7f7;
            margin: 0;
            display: flex;
            align-items: center;
            justify-content: center;
            height: 100vh;
        }

        h1 {
            text-align: center;
            color: #333;
        }

        form {
            width: 400px;
            background-color: #fff;
            padding: 20px;
            border-radius: 10px;
            box-shadow: 0 0 20px rgba(0, 0, 0, 0.1);
        }

        label {
            display: block;
            margin-bottom: 10px;
            color: #555;
            font-size: 14px;
        }

        input[type="text"], input[type="submit"], input[type="radio"] {
            width: 100%;
            padding: 12px;
            margin-bottom: 15px;
            box-sizing: border-box;
            border: 1px solid #ccc;
            border-radius: 6px;
            font-size: 16px;
        }

        input[type="submit"] {
            background-color: #4caf50;
            color: #fff;
            cursor: pointer;
            transition: background-color 0.3s ease;
        }

        input[type="radio"] {
            margin-right: 5px;
        }

        input[type="submit"]:hover {
            background-color: #45a049;
        }
    </style>
</head>
<body>
    <h1>Calculator</h1>
    <form action="firstHomePage" method="get">
        <label for="n1">First number:</label>
        <input type="text" name="n1" id="n1" required>
        
        <label for="n2">Second number:</label>
        <input type="text" name="n2" id="n2" required>

        <div>
            <label>
                <input type="radio" name="operation" value="add" checked> Addition
            </label>
            <label>
                <input type="radio" name="operation" value="sub"> Subtraction
            </label>
            <label>
                <input type="radio" name="operation" value="mul"> Multiplication
            </label>
        </div>

        <input type="submit" value="Calculate">
    </form>
</body>
</html>
