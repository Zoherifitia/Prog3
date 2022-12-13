package app.prog.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;
import java.util.List;

@Entity
@Table(name = "book")
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class BookEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    private String title;
    @ManyToOne
    @JoinColumn(name = "relation")
    private Author author;
    private Integer pageNumber;
    private LocalDate releaseDate;

    @ManyToMany//(fetch = FetchType.LAZY)
    private List<Category> category;

    public boolean hasAuthor() {
        return author != null;
    }

}
