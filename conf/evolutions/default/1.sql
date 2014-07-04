# --- Created by Ebean DDL
# To stop Ebean DDL generation, remove this comment and start using Evolutions

# --- !Ups

create table metas (
  id                        integer not null,
  semana_id                 integer not null,
  nome                      varchar(255),
  prioridade                integer,
  completa                  boolean,
  constraint pk_metas primary key (id))
;

create table semana (
  id                        integer not null,
  constraint pk_semana primary key (id))
;

create sequence metas_seq;

create sequence semana_seq;

alter table metas add constraint fk_metas_semana_1 foreign key (semana_id) references semana (id) on delete restrict on update restrict;
create index ix_metas_semana_1 on metas (semana_id);



# --- !Downs

SET REFERENTIAL_INTEGRITY FALSE;

drop table if exists metas;

drop table if exists semana;

SET REFERENTIAL_INTEGRITY TRUE;

drop sequence if exists metas_seq;

drop sequence if exists semana_seq;

