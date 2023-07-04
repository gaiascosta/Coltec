<?php
class Pergunta{
    public $enunciado;
    public $alternativas;
    public $resposta;

    public function __construct($enunciado, $alternativas, $resposta){
        $this->enunciado = $enunciado;
        $this->alternativas = $alternativas;
        $this->resposta = $resposta;
    }
}
?>