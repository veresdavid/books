package hu.lamsoft.books.persistence.book.dao;

import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import hu.lamsoft.books.persistence.book.entity.Book;

@Repository
public interface BookDao extends JpaRepository<Book, Integer> {

	List<Book> findByTitle(String title);
	
	Page<Book> findAll(Pageable pageable);
	
}
