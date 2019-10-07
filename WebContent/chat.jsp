<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="pt-br">

<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <meta http-equiv="X-UA-Compatible" content="ie=edge">
    <title>LiaChatbot - Assistente Virtual</title>

    <!-- bootstrap core -->
    <link rel="stylesheet" href="css/compiler/bootstrap/bootstrap.css">

    <!-- FontAwesome -->
    <link rel="stylesheet" href="node_modules/@fortawesome/fontawesome-free/css/all.css">

    <!-- estilo proprio -->
    <link rel="stylesheet" href="css/compiler/bootstrap/style.css">
    <link rel="stylesheet" href="css/compiler/bootstrap/chat.css">


</head>

<body>
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
                        <!-- <li class="nav-item"><a class="nav-link" href=""></a></li> -->
                    </ul>
                    <!-- itens ao meio-->


                    <!-- cadastro e login -->
                    <ul class="navbar-nav d-none d-lg-flex ml-2 order-3">
                        <li class="nav-item"><a class="nav-link" href="#" id="btn-nav">(nome)</a></li>
                        <li class="nav-item"><a class="nav-link" href="" id="btn-nav" data-toggle="modal"
                                data-target=".bd-login">Configurações</a></li>
                    </ul>
                    <!-- cadastro e login -->


                    <!-- cadatro e login para mobile -->
                    <ul class="navbar-nav d-lg-none">
                        <li class="dropdown-divider"></li>
                        <li class="nav-item"><a class="nav-link" href="#" id="btn-nav">(nome)</a></li>
                        <li class="nav-item"><a class="nav-link" href="" id="btn-nav" data-toggle="modal"
                                data-target=".bd-login">Configurações</a></li>
                    </ul>
                    <!-- cadatro e login para mobile -->
                </div>
                <!-- itens menu -->


            </div>
        </nav>
    </header>
    <!-- Navgation -->



    <!-- Corpo do Site -->
    <main>

        <!-- divisao em sections -->
        <!-- Section de Conteudo -->
        <section id="conteudo">
            <!-- div do chat bot -->
            <div id="chat" class="vh-100 chat">
                <div class="row d-block">
                    <div class="col-12 fake-nav"></div>
                    <div id="corpo-msg" class="col-12 conversa d-flex">

                    </div>
                    <div class="col-12 barra d-flex">
                        <input type="text" class="form-control flex-grow-1" id="input-user"
                            placeholder="Faça sua pergunta">
                        <button id="btn-mic" class="btn btn-primary"><i id="mic"
                                class="fas fa-microphone-alt"></i></button>
                        <button id="btn-msg" class="btn btn-primary"><i id="msg"
                                class="fas fa-paper-plane"></i></button>
                    </div>
                </div>
            </div>
            <!-- div do chat bot -->
        </section>
        <!-- Section de Conteudo -->
        <!-- divisao em sections -->
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




<script src="https://cdn.rawgit.com/mattdiamond/Recorderjs/08e7abd9/dist/recorder.js"></script>
<script src="node_modules/jquery/dist/jquery.js"></script>
<script src="node_modules/jquery-mask-plugin/dist/jquery.mask.js"></script>
<script src="node_modules/popper.js/dist/umd/popper.js"></script>
<script src="node_modules/bootstrap/dist/js/bootstrap.js"></script>

<!-- import do js de animações proprias -->
<script src="js/index.js"></script>
<script src="js/chat.js"></script>
<script src="js/tts.js"></script>
<script src="js/stt.js"></script>

<!-- libras -->
<script src="https://vlibras.gov.br/app/vlibras-plugin.js"></script>
<script>
    new window.VLibras.Widget('https://vlibras.gov.br/app');
</script>

</html>