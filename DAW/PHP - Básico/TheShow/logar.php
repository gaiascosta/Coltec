<?php
    //Existe para evitar o acesso à página com uma sessão já ativa
    if(isset($_SESSION["logado"])){
        header("Location: index.php");
    }
?>

<!DOCTYPE html>
<html lang="pt-br">

<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Show do Milhão</title>
</head>

<body>
    <div class="page-wrapper">

        <main>
            <form action="index.php" method="post">
                Login <input type="text" name="login" id="" required><br><br>
                Senha <input type="password" name="senha" id="" required><br><br>
                <input type="hidden" name="log">
                <input type="submit" value="Login">
            </form>
        </main>

    </div>
</body>
</html>