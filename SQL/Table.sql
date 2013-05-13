drop table if exists user;

/*==============================================================*/
/* Table: user                                                  */
/*==============================================================*/
create table user
(
   userid               int not null auto_increment,
   account              varchar(256),
   password             varchar(256),
   type                 int,
   status               int,
   permissions          int,
   ekey                 varchar(256),
   primary key (userid)
);


drop table if exists student;

/*==============================================================*/
/* Table: student                                               */
/*==============================================================*/
create table student
(
   stuid                int not null ,
   stuname              varchar(256),
   sex                  varchar(4),
   birdata              date,
   department           varchar(256),
   major                varchar(256),
   stuclass             varchar(256),
   national             varchar(256),
   adtime               date,
   primary key (stuid)
);



drop table if exists teacher;

/*==============================================================*/
/* Table: teacher                                               */
/*==============================================================*/
create table teacher
(
   teaid                int not null ,
   teaname              varchar(256),
   sex                  varchar(4),
   birdata              date,
   department           varchar(256),
   primary key (teaid)
);

drop table if exists course;

/*==============================================================*/
/* Table: course                                                */
/*==============================================================*/
create table course
(
   couid                int not null auto_increment,
   teaid                int,
   couname              varchar(256),
   primary key (couid)
);

alter table course add constraint FK_Reference_2 foreign key (teaid)
      references teacher (teaid) on delete restrict on update restrict;

      
      drop table if exists score;

/*==============================================================*/
/* Table: score                                                 */
/*==============================================================*/
create table score
(
   stuid                int not null,
   couid                int not null,
   usuallyscore         int,
   paperscore           int,
   sumscore             int,
   primary key (stuid, couid)
);

alter table score add constraint FK_Reference_1 foreign key (stuid)
      references student (stuid) on delete restrict on update restrict;

alter table score add constraint FK_Reference_3 foreign key (couid)
      references course (couid) on delete restrict on update restrict;
      
      
drop table if exists News;

/*==============================================================*/
/* Table: News                                                  */
/*==============================================================*/
create table News
(
   newsid               int not null auto_increment,
   userid               int,
   newstitle            varchar(120),
   newscontent          varchar(10000),
   newsdate             date,
   primary key (newsid)
);

alter table News add constraint FK_Reference_4 foreign key (userid)
      references user (userid) on delete restrict on update restrict;
      