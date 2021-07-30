 create table video(
  id bigint not null auto_increment,
  titulo varchar(255) not null,
  descricao varchar(255) not null,
  url varchar(255) not null,

  primary key (id)
);
 
insert into video (titulo, descricao, url) values (
"Mapeando entidades JPA para geração de schema do banco de dados - JPA LiveClass #12",
 "Nessa aula você vai aprender a fazer o mapeamento de entidades JPA para gerar o script de criação do schema do banco de dados",
  "https://www.youtube.com/watch?v=biJSf_WpFB4&ab_channel=AlgaWorks");
