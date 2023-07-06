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

        public function getLogin(){
            return $this->login;
        }

        public function setRecorde($score){
            for ($i=0; $i < count($this->usuarios); $i++) {
                if($this->usuarios[$i]['login'] == $this->login){
                    setcookie($_SESSION["logado"]['login']."lastScore", $score, time() + 86400, '/');
                    if($score >= $this->usuarios[$i]['recorde']){
                        session_start();
                        $this->usuarios[$i]['recorde'] = $score;
                        $_SESSION['logado'] = $this->usuarios[$i];
                        file_put_contents($this->arquivo, json_encode($this->usuarios, JSON_PRETTY_PRINT | JSON_UNESCAPED_UNICODE));
                    }
                }
            }
        }


    }
?>