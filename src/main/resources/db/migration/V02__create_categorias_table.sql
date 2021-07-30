 create table categorias(
  id bigint not null auto_increment,
  cor varchar(255) not null,
  titulo varchar(255) not null ,

  primary key (id)
);
 
ALTER TABLE videos
ADD categoria_id bigint not null
