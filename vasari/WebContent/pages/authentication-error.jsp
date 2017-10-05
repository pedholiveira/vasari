<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
        <h2>Erro na autenticação</h2>
        <form action="j_security_check" method="POST">
            Usuário:<input type="text" name="j_username" />
            Senha:<input type="password" name="j_password" />
            <input type="submit" value="Login" />
        </form>
    </body>
</html>