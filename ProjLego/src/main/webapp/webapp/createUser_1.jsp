<!DOCTYPE html>
<link href="//netdna.bootstrapcdn.com/bootstrap/3.0.0/css/bootstrap.min.css" rel="stylesheet">
<link href="Styling.css" rel="stylesheet" type="text/css"/>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body> 
        <main class="container-fluid">
            <img class="header_pic" src="IMG/Cup_!.png" alt=""/>
            <section class="row index col-md-3">
                <h1>Create Customer</h1>
                <form action="Controller?origin=makeUser" method="post" class="text-center login" style="color: #757575;">
                    <div class="col-md-12"> 
                        <input type="text" class="form-control" name="email" placeholder="Email" required="">
                    </div>

                    <div class="col-md-12">
                        <input type="password" class="form-control" name="password" placeholder="Password">
                    </div>
                    <button class="btn btn-outline-info btn-rounded btn-block my-4 waves-effect z-depth-0" type="submit">CREATE</button>
                    <a href="CupcakeShop/"><button class="btn btn-outline-info btn-rounded btn-block my-4 waves-effect z-depth-0" type="submit">login page</button></a>
                    <br>
                    
                </form>
            </section>
        </main>
    </body>
</html>