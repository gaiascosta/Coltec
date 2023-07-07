<?php
    require "Question.php";
    function CarregaPergunta($id, $arquivoJson){
        $arquivoJson = json_decode(file_get_contents($arquivoJson));
        return new Quiz($arquivoJson[$id]->resposta, $arquivoJson[$id]->enunciado, $arquivoJson[$id]->alternativas);
    }
?>