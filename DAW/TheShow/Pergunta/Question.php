<?php
class Quiz{
    public $pergunta;
    public $opcoes;
    public $resposta;
    public function __construct($resposta, $pergunta, $opcoes){
        $this->resposta = $resposta;
        $this->pergunta = $pergunta;
        $this->opcoes = $opcoes;
    }
}
?>