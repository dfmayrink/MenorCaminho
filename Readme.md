Projeto que acha o menor caminho
=======================

O projeto foi desenvolvido utilizando o spring-boot para facilitar o acesso a banco de dados e restful webservices para um projeto "pequeno".

O banco de dados utilizado foi mongodb.

Não é possível alterar as cidades base nesse exemplo, sendo que foram cadastradas as cidades: A, B, C, D e E

Instalando o projeto:

mvn clean install

Iniciar uma instância de mongodb, no windows seria o alvo "mongod.exe", que está dentro da <pasta_de_instalação_do_mongo>/bin.

Iniciando o projeto, executar o plugin "spring-boot" target run do maven:

mvn spring-boot:run

Utilização, colar o endereço de acesso em um browser, mudando os parâmetros:

http://localhost:8080/menorcaminho?origem=A&destino=E&autonomia=10&litro=2.5

É possível conferir as entidades no banco com o comando:

db.vertice.find();