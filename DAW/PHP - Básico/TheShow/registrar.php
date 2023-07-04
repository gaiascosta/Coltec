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
                Login <input type="text" name="novoLogin" id="" required><br><br>
                Senha <input type="password" name="novaSenha" id="" required><br><br>
                Email <input type="email" name="email" id="" required><br><br>
                Nome <input type="text" name="nome" id="" required><br><br>
                <input type="hidden" name="reg">
                <input type="submit" value="Registrar">
            </form>
        </main>

    </div>

</body>
</html>