package app.prog.controller.response;

import app.prog.model.Author;
import app.prog.model.Category;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;

import java.util.List;

@AllArgsConstructor
@Data
@Builder
public class CreateBookResponse {
    private Author author;
    private String title;
    private List<Category> category;
}
