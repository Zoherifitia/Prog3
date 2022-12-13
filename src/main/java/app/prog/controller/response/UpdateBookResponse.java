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
public class UpdateBookResponse {
    private int id;
    private Author author;
    private List<Category> category;
    private String title;
}
