# JADE-CHATBOT
_Grupo Gallium_

***

O projeto **Jade-Chatbot** é uma plataforma online de estudos, desenvolvido em JAVA EE e outras tecnologias descritas neste documento. Tem como foco demonstrar a implentação dos serviços(_API's_) da IBM Cloud para o funcionamento de um assistente virtual para auxilo de alunos nas matérias de nivelamento da FIAP

***

## Tecnologias
#### Camada de Apresentação

* HTML5;
* CSS3 com [SCSS](https://sass-lang.com/install);
* Bootstrap;
* Java Script;
* Jquery.

O desenvolvimento do _front-end_ tem como objetivo ser simples e com poucas dependências, se tem a utilização do SCSS para adminsitração das camadas de estilos para qualquer alterção no arquivos .scss, deve-se compilar novamente os estilos com os seguintes comandos no nível da pasta WebContent

**Compilção automática por alteração**

```
sass --watch node_modules/bootstrap/scss:css/compiler/bootstrap
```

**Compilção Estática**

```
sass node_modules/bootstrap/scss:css/compiler/bootstrap
```

#### Camada de Aplicação

* Java EE
* OJDBC

O _back-end_ desenvolvido em Java faz a parte de chamada das _API's_ e administração de usuários seguindo as regras de negócios requiridas pelo o sistema.

## Grupo

O grupo é composto pelos os seguintes integrantes, todos a par de todo o porjeto, entre tanto cada um tem um foco especifico no projeto.

| Nome        | RM           |
| ------------- | -------------:|
| Caio Vinicius Marques      | 83220 |
| Guilherme Romualdo Parussolo | 83227 |
| Helena Faganelo Garcia | 83211 |
| Julia Moreira |   83237 |
| Leonardo Machado | |
