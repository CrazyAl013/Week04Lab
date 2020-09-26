<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Hello World</title>
    </head>
    <body>
        <h1>Simple Note Keeper</h1>
        <h2>View Note</h2>
        
        <form method="post" action="note">
            <h3>Title: </h3>
            <input type="text" name="title" value="${note.title}">

            <h3>Contents: </h3>
            <textarea name="content">${note.content}</textarea>
            

                <input type="submit" value="Save" />

            
        </form>
    </body>
</html>
