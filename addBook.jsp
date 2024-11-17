
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>to add book</title>
    </head>
    <body>
        <form action="addBook" method="post">
         Book ID: <input type="int" name="bookId"><br>
         Book Name: <input type="text" name="bookName"><br>
         Author Name: <input type="text" name="authorName"><br>
        Category: <input type="text" name="category"><br>
        <input type="submit" value="submit">
        </form>

    </body>
</html>
