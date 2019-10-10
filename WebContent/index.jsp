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


</head>

<body data-spy="scroll" data-target="#navbar" data-offset="0">

    <!-- Navgation -->
    <header>
        <nav id="navbar" class="navbar fixed-top navbar-expand-lg navbar-dark bg-dark">
            <div class="container">

                <!-- logo -->
                <a href="#" class="navbar-brand">
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
        <!-- Section 1 -- Sobre -->

        <section id="sobre" class="vh-100">

            <div id="texto-apresentaçao" class="position-relative">

                <h1>Olá, eu sou a Jade!</h1>
                <p>Fui criada para ajudar os alunos da Fiap com suas dúvidas. Comigo você poderá tirar suas dúvidas
                    sobre as matérias de nivelamento, além de bater um papo super legal...
                    <br>
                    <a href="">Que tal embarcar no Futuro?</a>
                </p>
            </div>
            <canvas id="earth"></canvas>
        </section>


        <section id="como" class="vh-100">
            <div id="texto-como" class="position-relative">
                <div class="topo">
                    <div class="titulo">
                        <p>Como</p>
                        <p>Funciona</p>
                    </div>
                    <img src="images/comofunciona.png" class="col-xl-6 col-12">
                </div>

                <div class="corpo row">
                    <p class="col-xl-6 col-12 destaque">A Jade foi pensada para auxílio das dúvidas dos universitários da
                        Fiap.</p>
                    <div class="divider"></div>
                    <p class="col-xl-6 col-12 descricao"> Quando os alunos ingressam faculdade enfrentam dificuldades
                        para realizar as matéria de nivelamento que a faculdade
                        oferece. Ao realizar as atividades dos cursos, você contará com a ajuda da Jade, um chatbot que
                        responderá a suas dúvidas facilitando o estudo, a cada dia mais perto do foco.</p>
                </div>
            </div>
        </section>


        <section id="quem" class="vh-100">
            <div id="texto-quem" class="position-relative">
                <div class="topo">
                    <div class="titulo">
                        <p>Quem</p>
                        <p>Pode Usar</p>
                    </div>
                </div>

                <div class="corpo row">
                    <div class="col-12 destaque">
                        <img src="images/quem.png" alt="">
                        <!-- <p>Quebre suas barreiras</p> -->
                    </div>
                    <p class="col-12 descricao"> A Jade foi criada pensando em aproximar o estudante e o
                            conteúdo oferecido pela a universidade, sendo assim foi feita para qualquer aluno que enfrentar
                            seus obstáculos.</p>
                </div>

            </div>
        </section>


        <section id="contato" class="vh-100">
            <div class="row">
                <div class="col-12 col-lg-4 texto">
                    <h1>Entre em contato conosco.</h1>
                    <p>Se interresou pelo o projeto? Mande uma menssagem para nós, adorariamos saber o que tem para
                        dizer.</p>
                </div>
                <div class="col-12 col-lg-8 formulario">
                    <div class="form-group">
                        <input type="text" class="form-control" maxlength="20" id="nome" placeholder="Nome">
                        <input type="text" class="form-control" maxlength="150" id="assunto" placeholder="Assunto">
                        <input type="email" class="form-control" maxlength="60" id="email" placeholder="Email">
                        <textarea id="textarea" rows="8">Escreva sua menssagem.</textarea>
                        <button type="submit" class="btn btn-primary" id="btn-enviar">Enviar</button>
                    </div>

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


<script src="js/Recorderjs-master/dist/recorder.js"></script> 
<script src="node_modules/jquery/dist/jquery.js"></script>
<script src="node_modules/jquery-mask-plugin/dist/jquery.mask.js"></script>
<script src="node_modules/popper.js/dist/umd/popper.js"></script>
<script src="node_modules/bootstrap/dist/js/bootstrap.js"></script>
<script src="node_modules/three/build/three.js"></script>

<!-- import do js proprios -->
<script src="js/index.js"></script>
<script src="js/modais.js"></script>
<script src="js/home.js"></script>
<script src="js/anima.js"></script>

<!-- libras -->
<script src="https://vlibras.gov.br/app/vlibras-plugin.js"></script>
<script>
    new window.VLibras.Widget('https://vlibras.gov.br/app');
</script>


</html>