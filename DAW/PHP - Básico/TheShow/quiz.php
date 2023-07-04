<?php
    require "Pergunta/CarregaPergunta.php";
    session_start();

    //Pega a requisição para definir a pergunta atual
    $id = $_GET['id'] - 1;

    //Se o id for igual ao número de perguntas, a pessoa ganhou
    $numPerguntas = count(json_decode(file_get_contents("Pergunta/Perguntas.json")));
    if($numPerguntas == $id){
        //Cookie de último score
        setcookie($_SESSION["logado"]['login']."lastScore", $id, time() + 86400);
        header("Location: vitoria.php");
    }

    //Se a alternativa marcada na pergunta anterior for a errada,
    //a pessoa perde
    if (isset($_POST['alternativa']) && isset($_POST['resposta'])) {
        $resposta = $_POST['resposta'];
        $escolha = $_POST['alternativa'];
        if($escolha != $resposta){
            //Cookie de último score
            setcookie($_SESSION["logado"]['login']."lastScore", $id - 1, time() + 86400);
            header("Location: derrota.php");
        }
    }

    $questao = CarregaPergunta($id,"Pergunta/Perguntas.json");
?>

<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Document</title>
</head>
<body>
<h1>Show do Bilhão</h1>

<!--Carrega as perguntas-->
    <form action="quiz.php?id=<?= $_GET['id']+1?>" method="post">
                <input hidden name="resposta" value=<?=$questao->resposta?>>
                <?php
                for ($i=1; $i <= sizeof($questao->alternativas); $i++) {
                    echo "<input type='radio' name='alternativa' value='{$i}' required>
                    <label for='{$i}'>{$questao->alternativas[$i-1]}</label>";
                }
                ?>
                <input type="submit" value="Enviar">
    </form>

</body>
</html>