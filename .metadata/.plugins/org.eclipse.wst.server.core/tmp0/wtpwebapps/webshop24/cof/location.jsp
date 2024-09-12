<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Grid Selection</title>
    <style>
        .grid {
            display: grid;
            grid-template-columns: repeat(10, 1fr);
            grid-template-rows: repeat(10, 1fr);
            width: 500px;
            height: 500px;
            border: 1px solid black;
        }
        .cell {
            border: 1px solid black;
            text-align: center;
            line-height: 50px;
        }
        .selected {
            background-color: yellow;
        }
    </style>
</head>
<body>
    <h1>Select a Point</h1>
    <div class="grid">
        <% for (int i = 0; i < 10; i++) { %>
            <% for (int j = 0; j < 10; j++) { %>
                <div class="cell" onclick="selectPoint(<%= i %>, <%= j %>)"><%= i %>, <%= j %></div>
            <% } %>
        <% } %>
    </div>
    <p id="selectedPoint"></p>

    <script>
        function selectPoint(x, y) {
            document.getElementById("selectedPoint").innerText = "Selected Point: (" + x + ", " + y + ")";
        }
    </script>
</body>
</html>