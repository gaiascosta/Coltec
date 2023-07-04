<?php
require "Usuario/Login.php";
require "Usuario/Registro.php";
require "Pergunta/CarregaPergunta.php";

//Cada uma recebe os dados de uma página específica para poder
//chamar as funções de criação de sessão
session_start();
if (isset($_POST['log'])) {
    $login = new Login($_POST['login'], $_POST['senha']);
}

if (isset($_POST['reg'])) {
    $registro = new Registro($_POST['novoLogin'], $_POST['email'], $_POST['nome'], $_POST['novaSenha']);
}
?>

<!DOCTYPE html>
<html lang="en">

<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0/dist/css/bootstrap.min.css" rel="stylesheet"
        integrity="sha384-9ndCyUaIbzAi2FUVXJi0CjmCapSmO7SnpJef0486qhLnuZ2cdeRhO02iuK6FUUVM" crossorigin="anonymous">
    <link rel="stylesheet" href="css/Style.css">
    <title>Document</title>
</head>

<body>
    <div class="mainPageContainer d-flex justify-content-center align-items-center">
        <div class="divTitulo text-center">
            <h1 class="mx-5" id="tituloShow">Show do Bilhão</h1>
        </div>
        <div class="theMiddle"></div>
        <div class="divLogin d-flex flex-column">
            <?php if (!isset($_SESSION['logado'])): ?>
                <a class="firstLogin my-3" href="logar.php">Login</a>
                <a class="firstLogin my-3" href="registrar.php">Cadastro</a>
            <?php else: ?>
                <form action="quiz.php" method="get">
                    <input class="firstLoginJogar my-3" type="submit" value="Jogar">
                    <input type="hidden" name="id" value="1">
                </form>

                <a class="firstLogin my-3" href="Usuario/Logout.php">Sair</a>
            <?php endif; ?>
        </div>
    </div>

    <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0/dist/js/bootstrap.bundle.min.js"
        integrity="sha384-geWF76RCwLtnZ8qwWowPQNguL3RmwHVBC9FhGdlKrxdiJJigb/j/68SIy3Te4Bkz"
        crossorigin="anonymous"></script>
</body>

</html>