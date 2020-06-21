DROP TABLE IF EXISTS lib_category;
 
CREATE TABLE lib_category (
  category_id  INT AUTO_INCREMENT  PRIMARY KEY,
  category_name VARCHAR(250) NOT NULL
);

insert into lib_category(category_id,category_name) values (1,'Science');
insert into lib_category(category_id,category_name) values (2,'Literature');

DROP TABLE IF EXISTS books;
 
CREATE TABLE books (
  book_id INT AUTO_INCREMENT  PRIMARY KEY,
  category_id int,
  book_name VARCHAR(250) NOT NULL,
  author_name VARCHAR(250) NOT NULL,
  FOREIGN KEY (category_id) REFERENCES lib_category(category_id)
);

insert into books(book_id,category_id,book_name,author_name) values (1,1,'Science Book 1','Ashok');
insert into books(book_id,category_id,book_name,author_name) values (2,1,'Science Book 2','Bala');
insert into books(book_id,category_id,book_name,author_name) values (3,1,'Science Book 3','Bala Ashok');
insert into books(book_id,category_id,book_name,author_name) values (4,2,'Literature Book 1','Ashok');
insert into books(book_id,category_id,book_name,author_name) values (5,2,'Literature Book 2','Bala');
insert into books(book_id,category_id,book_name,author_name) values (6,2,'Literature Book 3','Bala Ashok');