create database my_cat default character set utf8mb4;

use my_cat;

create table board_basic(
	b_no int primary key auto_increment,
    b_title char(50) not null,
    b_writerID char(50) not null,
    b_datetime datetime not null,
    b_cont text
);

