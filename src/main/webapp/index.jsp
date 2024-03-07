<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Calculator</title>
    <style>
        body {
            font-family: 'Arial', sans-serif;
            background-color: #f8f8f8;
            margin: 0;
            padding: 0;
            display: flex;
            justify-content: center;
            align-items: center;
            height: 100vh;
        }

        form {
            max-width: 400px;
            background-color: #fff;
            padding: 20px;
            border-radius: 8px;
            box-shadow: 0 0 20px rgba(0, 0, 0, 0.1);
        }

        h1 {
            text-align: center;
            color: #333;
        }

        label {
            display: block;
            margin-bottom: 8px;
            color: #555;
        }

        input[type="text"], input[type="submit"], input[type="radio"] {
            width: 100%;
            padding: 10px;
            margin-bottom: 15px;
            box-sizing: border-box;
            border: 1px solid #ccc;
            border-radius: 4px;
            background-color: #f8f8f8;
            color: #333;
        }

        input[type="radio"] {
            margin-right: 5px;
        }

        input[type="submit"] {
            background-color: #4caf50;
            color: #fff;
            cursor: pointer;
            transition: background-color 0.3s ease;
        }

        input[type="submit"]:hover {
            background-color: #45a049;
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
