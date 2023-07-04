<?php
    class Usuario{
            private $login;
            private $senha;
            private $nome;
            private $email;
            private $recorde;
            private $arquivo = "Usuario/Usuarios.json";
            private $usuarios;

        public function __construct($login, $senha, $nome, $email){
            $this->login = $login;
            $this->senha = $senha;
            $this->nome = $nome;
            $this->email = $email;
            $this->recorde = 0;
            $this->usuarios = json_decode(file_get_contents($this->arquivo), true);
        }

        public function toArray(){
            return [
                'login' => $this->login,
                'senha' => $this->senha,
                'nome' => $this->nome,
                'email' => $this->email,
                'recorde' => $this->recorde
            ];
        }

    }
?>