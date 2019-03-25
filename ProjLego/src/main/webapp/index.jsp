
<!DOCTYPE html>

<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body> 
        <main class="container-fluid">
                <form action="Controller?origin=checkLogin" method="post">
                        <input type="text" class="form-control" name="email">
                        <input type="password" class="form-control" name="password">
                        <br>
                        <input type="submit" value="login"/>
                        <br>
                        <a href="Controller?origin=createUser" >click here if you're not already a user</a>
                </form>
        </main>
    </body>
</html>