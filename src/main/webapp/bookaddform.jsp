<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
    <head>
        <title>Formularz dodawania książki</title>
    </head>
    <body>
        <form action="/books/add" method="post">
            <div>
                <label>ISBN</label>
                <input type="text" name="isbn"/>
            </div>
            <div>
                <label>Tytuł:</label>
                <input type="text" name="title"/>
            </div>
            <div>
                <label>Autor</label>
                <input type="text" name="author"/>
            </div>
            <div>
                <label>Wydawnictwo</label>
                <input type="text" name="publisher"/>
            </div>
            <div>
                <label>Gatunek</label>
                <input type="text" name="type"/>
            </div>
            <div>
                <input type="submit" name="Send"/>
            </div>
        </form>
    </body>
</html>
