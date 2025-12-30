<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
    <title>Student Form</title>
</head>
<body>

<center>
    <h2>Student Details</h2>

    <form action="saveStudent" method="post">
        ID: <input type="number" name="id" required><br><br>
        Name: <input type="text" name="name" required><br><br>
        Email: <input type="email" name="email" required><br><br>
        Course: <input type="text" name="course" required><br><br>
        Marks: <input type="number" step="0.01" name="marks" required><br><br>
        <input type="submit" value="Save">
    </form>
</center>

</body>
</html>