- 
- ЗАДАНИЕ создание таблицы
- 
  CREATE TABLE book(

  book_id INT PRIMARY KEY AUTO_INCREMENT,  -- AUTO_INCREMENT  АВТО_ПРИРОСТ
  title VARCHAR(30)
  autor VARCHAR(30)

  price DECIMAL(8,2) -- DECIMAL(8,2) 8 знаков до ,  2 знака после  + и - и (,) не учитываются
  amount INT
  );