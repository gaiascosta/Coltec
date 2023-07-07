<?php 
    require "User.php";

    class Registro{
		private $arquivoJson = "Usuario/Usuarios.json";
	    private $usuarios;
	    private $newUsuario;
        private $login;
	    private $senhaCodigo;
		private $email;
        private $nome;

		
		private function adicionaNovoUsuario(){
			if($this->loginExiste() == FALSE)
			{
				$newUsuarioArray = $this->newUsuario->novoArray();
				$this->usuarios[] = $newUsuarioArray;
				file_put_contents($this->arquivoJson, json_encode($this->usuarios, JSON_PRETTY_PRINT | JSON_UNESCAPED_UNICODE));
				$_SESSION['logadoTrue'] = $newUsuarioArray;
			}
		}

		public function __construct($login, $senha, $email, $nome)
		{
			$this->login = htmlspecialchars($login);
			$this->senhaCodigo = password_hash(htmlspecialchars($senha), PASSWORD_DEFAULT);
			$this->email = htmlspecialchars($email);
			$this->nome = htmlspecialchars($nome);

			$this->newUsuario = new Usuario($login, $this->senhaCodigo, $nome, $email);
			$this->usuarios = json_decode(file_get_contents($this->arquivoJson), true);
			$this->adicionaNovoUsuario();
		}
	    private function loginExiste(){
		    for ($i=0; $i < count($this->usuarios); $i++) { 
			    if($this->login == $this->usuarios[$i]['login']){
				    header("location: Usuario/Registrar.php");
				    return true;
			    }
		    }
			
            for ($i=0; $i < count($this->usuarios); $i++) { 
			    if($this->email == $this->usuarios[$i]['email']){
					header("location: Usuario/Registrar.php");
				    return true;
			    }
		    }
		    return false;
	    }
		
}
?>