<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Calculator</title>
    <style>
        body {
            font-family: 'Arial', sans-serif;
            background-color: #f0f0f0;
            margin: 0;
            padding: 0;
            display: flex;
            justify-content: center;
            align-items: center;
            height: 100vh;
        }

        form {
            background-color: #fff;
            padding: 30px;
            border-radius: 8px;
            box-shadow: 0 0 10px rgba(0, 0, 0, 0.1);
            text-align: center;
        }

        h1 {
            color: #333;
        }

        label {
            display: block;
            margin: 20px 0 10px;
            color: #555;
            font-size: 16px;
        }

        input[type="text"], input[type="submit"], input[type="radio"] {
            width: 100%;
            padding: 10px;
            margin-bottom: 15px;
            box-sizing: border-box;
            border: 1px solid #ccc;
            border-radius: 4px;
            font-size: 16px;
        }

        input[type="submit"] {
            background-color: #4caf50;
            color: #fff;
            cursor: pointer;
            transition: background-color 0.3s;
        }

        input[type="submit"]:hover {
            background-color: #45a049;
        }

        input[type="radio"] {
            margin-right: 5px;
        }
    </style>
</head>
<body>
    <form action="firstHomePage" method="get">
        <h1>Calculator</h1>
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
