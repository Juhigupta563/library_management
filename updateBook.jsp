
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>update the book</title>
    </head>
    <body>
        <form action="updateBook" method="post">
        Book ID: <input type="int" name="bookId"><br>
        New Book Name: <input type="text" name="bookName"><br>
        New Author Name: <input type="text" name="authorName"><br>
        New Category: <input type="text" name="category"><br>
        <input type="submit" value="submit">
        </form>

    </body>
</html>
