package ac.ks.jpademo.repository;

import ac.ks.jpademo.domain.Book;
import org.springframework.data.jpa.repository.JpaRepository;

public interface BookRepository extends JpaRepository<Book, Long> {
}
