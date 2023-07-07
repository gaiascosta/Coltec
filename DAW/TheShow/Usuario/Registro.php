<?php 
    //Adiciona o usuário no arquivo e já inicia a sessão
    require "User.php";
    class Registro{
        private $login;
	    private $email;
        private $nome;
	    private $senhaHash;
	    private $arquivo = "Usuario/Usuarios.json";
	    private $usuarios;
	    private $novoUsuario;

	    public function __construct($login, $email, $nome, $senha){
		    $this->login = htmlspecialchars($login);
		    $this->email = htmlspecialchars($email);
            $this->nome = htmlspecialchars($nome);
		    $this->senhaHash = password_hash(htmlspecialchars($senha), PASSWORD_DEFAULT);
            $this->novoUsuario = new Usuario($login, $this->senhaHash, $nome, $email);
		    $this->usuarios = json_decode(file_get_contents($this->arquivo), true);

		    $this->addUsuario();
	    }

        //Verifica a existência de um login já existente
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

	    private function addUsuario(){
		    if($this->loginExiste() == FALSE){
                $novoUsuarioArray = $this->novoUsuario->toArray();
                $this->usuarios[] = $novoUsuarioArray;
			    file_put_contents($this->arquivo, json_encode($this->usuarios, JSON_PRETTY_PRINT | JSON_UNESCAPED_UNICODE));
				$_SESSION['logado'] = $novoUsuarioArray;
		    }
	    }
}
?>