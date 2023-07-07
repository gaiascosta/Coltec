<?php
require "Usuario/User.php";
include("Pergunta/perguntas.inc");

session_start();

$id = $_GET['id'] - 1;

$numDePerguntas = count(json_decode(file_get_contents("Pergunta/Perguntas.json")));
$usuario = new Usuario($_SESSION['logadoTrue']['login'], $_SESSION['logadoTrue']['senha'], $_SESSION['logadoTrue']['nome'], $_SESSION['logadoTrue']['email']);

if ($numDePerguntas == $id) 
{
    $usuario->marcaPontuacao($id);

    header("Location: Resultado/vitoria.php");
}

if (isset($_POST['opcoes']) && isset($_POST['resposta'])) {
    $resposta = $_POST['resposta'];
    $escolha = $_POST['opcoes'];
    if ($escolha != $resposta) 
    {
        $usuario->marcaPontuacao($id - 1);

        header("Location: Resultado/derrota.php");
    }
}

$pergunta = CarregaPergunta($id, "Pergunta/Perguntas.json");

?>

<!DOCTYPE html>
<html lang="en">

<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0/dist/css/bootstrap.min.css" rel="stylesheet"
        integrity="sha384-9ndCyUaIbzAi2FUVXJi0CjmCapSmO7SnpJef0486qhLnuZ2cdeRhO02iuK6FUUVM" crossorigin="anonymous">
    <link rel="stylesheet" href="css/Quiz.css">
    <title>The Show</title>
</head>

<body>
    <div class="d-flex justify-content-center align-items-center containerQuiz" >
        <div class="d-flex flex-column">
            <h3 class="questionTitle">
                <?= $pergunta->pergunta ?>
            </h3>
            <form action="perguntas.php?id=<?= $_GET['id'] + 1 ?>" method="post">
                <input hidden name="resposta" value=<?= $pergunta->resposta ?>>
                <?php
                for ($i = 1; $i <= sizeof($pergunta->opcoes); $i++) {
                    echo "<input type='radio' name='opcoes' value='{$i}' required>
                        <label class='perguntinhas' for='{$i}'>{$pergunta->opcoes[$i - 1]}</label>";
                }
                ?>
                <input type="submit" value="Enviar">
            </form>
        </div>
    </div>
    <footer class="theFooter"><?php include("footer.inc")?></footer>
    <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0/dist/js/bootstrap.bundle.min.js"
        integrity="sha384-geWF76RCwLtnZ8qwWowPQNguL3RmwHVBC9FhGdlKrxdiJJigb/j/68SIy3Te4Bkz"
        crossorigin="anonymous"></script>
</body>

</html>