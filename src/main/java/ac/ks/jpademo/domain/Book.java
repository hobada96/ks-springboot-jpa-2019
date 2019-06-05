package ac.ks.jpademo.domain;

import javax.persistence.*;
import java.io.Serializable;

@Entity
public class Book implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long idx;

    private String name;

    @ManyToOne
    private Category category;

    public Long getIdx() {
        return idx;
    }

    public void setIdx(Long idx) {
        this.idx = idx;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Category getCategory() {
        return category;
    }

    public void setCategory(Category category) {
        // 이미 카테고리가 있을 경우 관계를 제거한다.
        if( this.category != null ) {
            this.category.getBooks().remove(this);
        }

        this.category = category;

        if( category != null ) {
            category.getBooks().add(this);
        }
    }

    @Override
    public String toString() {
        return "Book{" +
                "idx=" + idx +
                ", name='" + name + '\'' +
                '}';
    }
}
