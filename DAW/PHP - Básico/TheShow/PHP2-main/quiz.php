<?php
include("Pergunta/CarregaPergunta.inc");
require "Usuario/Usuario.php";

session_start();

//Pega a requisição para definir a pergunta atual
$id = $_GET['id'] - 1;

$user = new Usuario($_SESSION['logado']['login'], $_SESSION['logado']['senha'], $_SESSION['logado']['nome'], $_SESSION['logado']['email']);

//Se o id for igual ao número de perguntas, a pessoa ganhou
$numPerguntas = count(json_decode(file_get_contents("Pergunta/Perguntas.json")));
if ($numPerguntas == $id) {
    $user->setRecorde($id);
    header("Location: Resultado/vitoria.php");
}

//Se a alternativa marcada na pergunta anterior for a errada,
//a pessoa perde
if (isset($_POST['alternativa']) && isset($_POST['resposta'])) {
    $resposta = $_POST['resposta'];
    $escolha = $_POST['alternativa'];
    if ($escolha != $resposta) {
        $user->setRecorde($id - 1);
        header("Location: Resultado/derrota.php");
    }
}

$questao = CarregaPergunta($id, "Pergunta/Perguntas.json");
?>

<!DOCTYPE html>
<html lang="en">

<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0/dist/css/bootstrap.min.css" rel="stylesheet"
        integrity="sha384-9ndCyUaIbzAi2FUVXJi0CjmCapSmO7SnpJef0486qhLnuZ2cdeRhO02iuK6FUUVM" crossorigin="anonymous">
    <link rel="stylesheet" href="css/Quiz.css">
    <title>Document</title>
</head>

<body>
    <!--Carrega as perguntas-->
    <div class="d-flex justify-content-center align-items-center containerQuiz" >
        <div class="d-flex flex-column">
            <h3 class="questionTitle">
                <?= $questao->enunciado ?>
            </h3>
            <form action="quiz.php?id=<?= $_GET['id'] + 1 ?>" method="post">
                <input hidden name="resposta" value=<?= $questao->resposta ?>>
                <?php
                for ($i = 1; $i <= sizeof($questao->alternativas); $i++) {
                    echo "<input type='radio' name='alternativa' value='{$i}' required>
                        <label class='perguntinhas' for='{$i}'>{$questao->alternativas[$i - 1]}</label>";
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