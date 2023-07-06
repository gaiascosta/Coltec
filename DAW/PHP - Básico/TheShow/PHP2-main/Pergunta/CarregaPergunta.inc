<?php
    require "Pergunta.php";

    function CarregaPergunta($id, $arquivo){
        $arquivo = json_decode(file_get_contents($arquivo));
        return new Pergunta($arquivo[$id]->enunciado, $arquivo[$id]->alternativas, $arquivo[$id]->resposta);
    }

?>