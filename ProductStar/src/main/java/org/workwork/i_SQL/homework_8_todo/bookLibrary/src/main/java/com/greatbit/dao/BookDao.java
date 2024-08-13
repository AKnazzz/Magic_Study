package org.workwork.i_SQL.homework_8_todo.bookLibrary.src.main.java.com.greatbit.dao;

import com.greatbit.models.Book;

import java.util.List;

public interface BookDao {
    List<Book> findAll();
    Book save(Book book);
    Book getById(long id);
    Book update(Book book);
    void delete(long id);
    void deleteAll();
}
