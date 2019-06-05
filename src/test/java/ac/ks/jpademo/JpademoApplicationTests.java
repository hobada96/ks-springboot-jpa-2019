package ac.ks.jpademo;

import ac.ks.jpademo.domain.Book;
import ac.ks.jpademo.domain.Category;
import ac.ks.jpademo.repository.BookRepository;
import ac.ks.jpademo.repository.CategoryRepository;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.test.context.junit4.SpringRunner;

import static org.assertj.core.api.Assertions.assertThat;

@RunWith(SpringRunner.class)
@DataJpaTest
public class JpademoApplicationTests {

    Logger logger = LoggerFactory.getLogger(JpademoApplicationTests.class.getName());

    @Autowired
    private BookRepository bookRepository;

    @Autowired
    private CategoryRepository categoryRepository;

//    @Test
//    public void testRelationshipCase1() {
//        Book book = new Book();
//        book.setName("운영체제");
//        bookRepository.save(book);
//
//        Category category = new Category();
//        category.setGenre("IT");
//        categoryRepository.save(category);
//
//        logger.info(book.toString());
//        logger.info(category.toString());
//
//        assertThat(book.getName()).isEqualTo(bookRepository.findById(book.getIdx()).orElse(new Book()).getName());
//        assertThat(category.getGenre()).isEqualTo(categoryRepository.findById(category.getIdx()).orElse(new Category()).getGenre());
//
//    }

//    @Test
//    public void testRelationshipCase2() {
//        // @Entity에 OneToOne을 설정 후 테스트하세요.
//
//        Book book = new Book();
//        book.setName("운영체제");
//        bookRepository.save(book);
//
//        Category category = new Category();
//        category.setGenre("IT");
//        categoryRepository.save(category);
//
//        book.setCategory(category);
//        bookRepository.save(book);
//
//        category.setBook(book);
//        categoryRepository.save(category);
//
//        logger.info(book.getCategory().getGenre());
//        logger.info(category.getBook().getName());
//
//        assertThat(book.getName()).isEqualTo(bookRepository.findById(book.getIdx()).orElse(new Book()).getName());
//        assertThat(category.getGenre()).isEqualTo(categoryRepository.findById(category.getIdx()).orElse(new Category()).getGenre());
//
//    }

//    @Test
//    public void testRelationshipCase3() {
//        // @Entity에 OneToMany / ManyToOne을 설정 후 테스트하세요.
//
//        Category category = new Category();
//        category.setGenre("IT");
//        categoryRepository.save(category);
//
//        Book book = new Book();
//        book.setName("운영체제");
//        book.setCategory(category);
//        book.getCategory().getBooks().add(book);
//        bookRepository.save(book);
//
//        logger.info(book.getCategory().getGenre());
//
//        assertThat(book.getName()).isEqualTo(bookRepository.findById(book.getIdx()).orElse(new Book()).getName());
//        assertThat(category.getGenre()).isEqualTo(categoryRepository.findById(category.getIdx()).orElse(new Category()).getGenre());
//
//    }

    @Test
    public void testRelationshipCase4() {
        // @Entity에 OneToMany / ManyToOne을 설정 후 테스트하세요.

        Category category = new Category();
        category.setGenre("IT");
        categoryRepository.save(category);

        Category newCategory = new Category();
        newCategory.setGenre("IT/OS");
        categoryRepository.save(newCategory);

        Book book = new Book();
        book.setName("운영체제");
        book.setCategory(category);
        bookRepository.save(book);

        book.setCategory(newCategory);
        bookRepository.save(book);

        for (Category c : categoryRepository.findAll()) {
            logger.info(c.getGenre());
            c.getBooks().forEach(b -> logger.info(b.getName()));
            logger.info("-------");
        }

        assertThat(book.getName()).isEqualTo(bookRepository.findById(book.getIdx()).orElse(new Book()).getName());
        assertThat(newCategory.getGenre()).isEqualTo(categoryRepository.findById(newCategory.getIdx()).orElse(new Category()).getGenre());

    }

}
