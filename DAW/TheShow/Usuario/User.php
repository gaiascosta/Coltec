<?php
    class Usuario{
        private $usuarios;
        private $arquivoJson = "Usuario/Usuarios.json";
        private $recorde;
        private $login;
        private $senha;
        private $email;
        private $nome;

        
        public function novoArray(){
            return ['login' => $this->login,'senha' => $this->senha,'nome' => $this->nome,'email' => $this->email,'recorde' => $this->recorde];
        }
        
        public function __construct($login, $senha, $nome, $email)
        {
            $this->recorde = 0;

            $this->usuarios = json_decode(file_get_contents($this->arquivoJson), true);

            $this->login = $login;
            $this->senha = $senha;
            $this->email = $email;
            $this->nome = $nome;
        }
        
        public function marcaPontuacao($pontuacao){
            for ($aux=0; $aux < count($this->usuarios); $aux++) 
            {
                if($this->usuarios[$aux]['login'] == $this->login)
                {
                    setcookie($_SESSION['logadoTrue']['login']."ultimaPontuacao", $pontuacao, time() + 86400, '/');

                    if($pontuacao >= $this->usuarios[$aux]['recorde'])
                    {
                        session_start();
                        $this->usuarios[$aux]['recorde'] = $pontuacao;
                        $_SESSION['logadoTrue'] = $this->usuarios[$aux];
                        file_put_contents($this->arquivoJson, json_encode($this->usuarios, JSON_PRETTY_PRINT | JSON_UNESCAPED_UNICODE));
                    }
                }
            }
        }
        
        
    }
?>