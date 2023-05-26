<!DOCTYPE html>
<html lang="pt">
<head>
    <meta charset="UTF-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Document</title>
</head>
<body>
    <h1>
        <?php
            $now = date("d/m/y h:i:s", time());
            echo "$now";
        ?>
    </h1>
    <p>
        <?php
        $nome = "Gabi";
        echo "Eu sou \$nome, mais conhecida como $nome!";
        ?>
    </p>
    <p>
        <?php
        $vet[] = "É isso,";
        $vet[] = "tchau.";
        echo "$vet[0] $vet[1]"
        ?>
    </p>
    <br>
    <p>Cheguei!!!</p>
    <p>
        <?php 
            $nome = "Gabi Costa";
            function alterar_nome(){
                $GLOBALS["nome"] = "Izaaz";
            }

            alterar_nome();
            echo "$nome";
        ?>
    </p>
</body>
</html>