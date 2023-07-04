<?php
    //Verifica se a senha e usuário batem, se sim, cria uma sessão
    //com os dados do usuário armazenado no JSON
    class login{
        private $login;
        private $senha;
        private $arquivo = "Usuario/Usuarios.json";
        private $usuarios;
        private $usuario;

        public function __construct($login, $senha){
            $this->login = $login;
            $this->senha = $senha;
            $this->usuarios = json_decode(file_get_contents($this->arquivo), true);
            $this->logar();
        }

        private function logar(){
            $a = 0;
            for ($i=0; $i < count($this->usuarios); $i++) {
			    if($this->login == $this->usuarios[$i]['login']){
                    $a++;
                    if (password_verify($this->senha, $this->usuarios[$i]['senha'])) {
                        $this->usuario = $this->usuarios[$i];
                        //Salvando todo o objeto user do JSON na SESSION
                        $_SESSION['logado'] = $this->usuario;
                    } else{
                        header("location: logar.php");
                    }
			    }
            }
            //Se não existir esse login, retorna à página
            if($a == 0){
                header("location: logar.php");
            }
		}

    }
?>