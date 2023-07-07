<?php

    class login{
        private $usuario;
        private $login;
        private $senha;
        private $usuarios;
        private $arquivoJson = "Usuario/Usuarios.json";

        
        private function Logar(){
            $a = 0;
            for ($i=0; $i < count($this->usuarios); $i++) {
                if($this->login == $this->usuarios[$i]['login']){
                    if (password_verify($this->senha, $this->usuarios[$i]['senha'])) {
                        $this->usuario = $this->usuarios[$i];
                        $_SESSION['logadoTrue'] = $this->usuario;
                        $a++;
                    } else{
                        header("location: Usuario/Logar.php");
                    }
			    }
		    }
            if($a == 0){
                header("location: Usuario/Logar.php");
            }
        }
        
        public function __construct($password, $login){
            $this->login = $login;
            $this->senha = $password;
            $this->usuarios = json_decode(file_get_contents($this->arquivoJson), true);
            $this->Logar();
        }
    }
?>