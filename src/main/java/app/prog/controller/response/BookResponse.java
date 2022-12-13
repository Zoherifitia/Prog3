package app.prog.controller.response;

import app.prog.model.Author;
import app.prog.model.Category;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@NoArgsConstructor
@AllArgsConstructor
@Data
@Builder
public class BookResponse {
    private int id;
    private Author author;
    private String title;
    private List<Category> category;
    private boolean hasAuthor;
}
