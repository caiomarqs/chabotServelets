<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

    <!DOCTYPE html>
<html lang="pt-br">

<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <meta http-equiv="X-UA-Compatible" content="ie=edge">
    <title>JadeChatbot - Assistente Virtual</title>

    <link rel="shortcut icon" href="images/jade_logo_x32.png" sizes="16x16 32x32" type="image/png"> 

    <!-- bootstrap core -->
    <link rel="stylesheet" href="css/compiler/bootstrap/bootstrap.css">

    <!-- FontAwesome -->
    <link rel="stylesheet" href="node_modules/@fortawesome/fontawesome-free/css/all.css">

    <!-- estilo proprio -->
    <link rel="stylesheet" href="css/compiler/bootstrap/style.css">
    <link rel="stylesheet" href="css/compiler/bootstrap/dificuldades.css">


</head>

<body data-spy="scroll" data-target="#navbar" data-offset="0">
    <!-- Navgation -->
    <header>
        <nav id="navbar" class="navbar fixed-top navbar-expand-lg navbar-dark bg-dark">
            <div class="container">

                <!-- logo -->
                <a href="index.jsp" class="navbar-brand">
                    <img src="images/logoBold-SfV.png" alt="Logo Fiap">
                </a>
                <!-- logo -->

                <!-- botão hambuger -->
                <div class="d-flex ml-auto">
                    <button class="navbar-toggler collapsed" type="button" data-toggle="collapse"
                        data-target="#navbarItens" aria-controls="navbarItens" aria-expanded="false"
                        aria-label="Toggle navigation">
                        <span class="navbar-toggler-icon"></span>
                    </button>
                </div>
                <!-- botão hambuger -->


                <!-- itens menu -->
                <div class="navbar-collapse collapse" id="navbarItens">

                    <!-- itens ao meio-->
                    <ul class="navbar-nav mx-auto order-1">
                        <li class="nav-item"><a class="nav-link" href="#sobre">Sobre</a></li>
                        <li class="nav-item"><a class="nav-link" href="#como">Como Funciona</a></li>
                        <li class="nav-item"><a class="nav-link" href="#quem">Quem Pode Usar</a></li>
                        <li class="nav-item"><a class="nav-link" href="#contato">Contato</a></li>
                    </ul>
                    <!-- itens ao meio-->


                    <!-- cadastro e login -->
                    <ul class="navbar-nav d-none d-lg-flex ml-2 order-3">
                        <li class="nav-item"><a class="nav-link" href="cadastro.jsp" id="btn-nav">Cadastro</a></li>
                        <li class="nav-item"><a class="nav-link" href="" id="btn-nav" data-toggle="modal"
                                data-target=".bd-login">Login</a></li>
                    </ul>
                    <!-- cadastro e login -->


                    <!-- cadatro e login para mobile -->
                    <ul class="navbar-nav d-lg-none">
                        <li class="dropdown-divider"></li>
                        <li class="nav-item"><a class="nav-link" href="cadastro.jsp" id="btn-nav">Cadastro</a></li>
                        <li class="nav-item"><a class="nav-link" href="" id="btn-nav" data-toggle="modal"
                                data-target=".bd-login">Login</a></li>
                    </ul>
                    <!-- cadatro e login para mobile -->



                    <!-- modais de login e esqueceu senha -->
                    <!-- modal login -->
                    <div class="modal fade bd-login" tabindex="-1" role="dialog" aria-labelledby="myLargeModalLabel"
                        aria-hidden="true">
                        <div class="modal-dialog modal-lg bg-dark">
                            <div class="modal-content">
                                <div class="modal-header">
                                    <h5 class="modal-title" id="exampleModalLabel">login</h5>
                                    <button type="button" class="close" data-dismiss="modal" aria-label="Close">
                                        <span aria-hidden="true">&times;</span>
                                    </button>
                                </div>
                                <div class="modal-body">
                                    <form class="px-4 py-3">
                                        <div class="form-group">
                                            <label for="exampleDropdownFormEmail1">Email</label>
                                            <input type="email" class="form-control email-modal" id="email-modal"
                                                placeholder="email@example.com" maxlength="60">
                                        </div>
                                        <div class="form-group">
                                            <label for="exampleDropdownFormPassword1">Senha</label>
                                            <input type="password" class="form-control email-modal" id="senha-modal"
                                                placeholder="Senha" maxlength="16">
                                            <div class="custom-control custom-checkbox mb-3">
                                                <input type="checkbox" class="custom-control-input" id="customCheck">
                                                <label class="custom-control-label" for="customCheck">Lembrar de
                                                    mim</label>
                                            </div>
                                        </div>
                                        <button type="submit" id="btn-entrar"
                                            class="btn btn-primary container">Entrar</button>
                                    </form>
                                </div>
                                <!-- <div class="dropdown-divider"></div> -->
                                <div id="links-login">
                                    <a class="page-item" href="cadastro.jsp">Não tem cadastro? Cadastre-se!</a>
                                    <a class="page-item" href="#" data-dismiss="modal" data-toggle="modal"
                                        data-target=".bd-esqueceusenha">Esqueçeu a
                                        Senha?</a>
                                </div>
                                <!-- <div class="dropdown-divider"></div> -->
                            </div>
                        </div>
                    </div>
                    <!-- modal login -->

                    <!-- modal esqueceu senha -->
                    <div class="modal fade bd-esqueceusenha" tabindex="-1" role="dialog"
                        aria-labelledby="myLargeModalLabel" aria-hidden="true">
                        <div class="modal-dialog modal-lg bg-dark">
                            <div class="modal-content">
                                <div class="modal-header">
                                    <h5 class="modal-title" id="exampleModalLabel">esqueceu sua senha?</h5>
                                    <button type="button" class="close" data-dismiss="modal" aria-label="Close">
                                        <span aria-hidden="true">&times;</span>
                                    </button>
                                </div>
                                <div class="modal-body">
                                    <form class="px-4 py-3">
                                        <h4>Informe seu email, para que eu possa mandar uma nova senha.</h4>
                                        <div class="form-group">
                                            <label for="exampleDropdownFormEmail1">Email</label>
                                            <input type="email" class="form-control email-modal" id="email-modal2"
                                                placeholder="email@example.com" maxlength="60">
                                        </div>
                                        <button type="submit" class="btn btn-primary container">Enviar nova
                                            Senha</button>
                                    </form>
                                </div>
                                <!-- <div class="dropdown-divider"></div> -->
                                <!-- <div class="dropdown-divider"></div> -->
                            </div>
                        </div>
                    </div>
                    <!-- modal esqueceu senha -->
                    <!-- modais de login e esqueceu senha -->


                </div>
                <!-- itens menu -->


            </div>
        </nav>
    </header>
    <!-- Navgation -->



    <!-- Corpo do Site -->
    <main>

        <!-- divisao em sections -->
        <section id="dificuldades" class="vh-100">
            <div class="row">
            </div>
        </section>
    </main>
    <!-- Corpo do Site -->

    <!-- footer -->
    <footer>
            <div vw class="enabled">
                    <div vw-access-button class="active"></div>
                    <div vw-plugin-wrapper>
                        <div class="vw-plugin-top-wrapper"></div>
                    </div>
                </div>
    </footer>
    <!-- footer -->
</body>



<script
	src="https://cdn.rawgit.com/mattdiamond/Recorderjs/08e7abd9/dist/recorder.js"></script>

<script src="node_modules/jquery/dist/jquery.js"></script>
<script src="node_modules/jquery-mask-plugin/dist/jquery.mask.js"></script>
<script src="node_modules/popper.js/dist/umd/popper.js"></script>
<script src="node_modules/bootstrap/dist/js/bootstrap.js"></script>

<!-- import do js proprios -->
<script src="js/index.js"></script>
<script src="js/modais.js"></script>
<script src="js/dificuldades.js"></script>

<!-- libras -->
<script src="https://vlibras.gov.br/app/vlibras-plugin.js"></script>
  <script>
    new window.VLibras.Widget('https://vlibras.gov.br/app');
  </script>

</html>