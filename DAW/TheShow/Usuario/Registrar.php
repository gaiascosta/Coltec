<!DOCTYPE html>
<html lang="pt-br">

<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0/dist/css/bootstrap.min.css" rel="stylesheet"
        integrity="sha384-9ndCyUaIbzAi2FUVXJi0CjmCapSmO7SnpJef0486qhLnuZ2cdeRhO02iuK6FUUVM" crossorigin="anonymous">
    <link rel="stylesheet" href="../css/Login.css">
    <title>The Show</title>
</head>

<body>
    <div class="page-wrapper">

        <main>
            <div class="d-flex justify-content-center align-items-center LogarContainer">
                <div class="loginBox">
                    <form action="../nextIndex.php" method="post">
                        Login <input type="text" name="novoLogin" class="mx-3 formPage" required><br><br>
                        Senha <input type="password" name="novaSenha" class="mx-3 formPage" required><br><br>
                        Email <input type="email" name="email" class="mx-3 formPage" required><br><br>
                        Nome <input type="text" name="nome" class="mx-3 formPage" required><br><br>
                        <input type="hidden" name="reg">
                        <div class="d-flex justify-content-center align-items-center">
                            <input type="submit" value="Registrar">
                        </div>
                    </form>
                </div>
            </div>
        </main>

    </div>
    <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0/dist/js/bootstrap.bundle.min.js"
        integrity="sha384-geWF76RCwLtnZ8qwWowPQNguL3RmwHVBC9FhGdlKrxdiJJigb/j/68SIy3Te4Bkz"
        crossorigin="anonymous"></script>
</body>

</html>