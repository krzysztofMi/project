package pl.phronimos.internship.postPage.entity;


import java.util.LinkedList;
import java.util.List;

public class PostEntity {
    private int id;
    private String author;
    private String text;
    private List<CommentEntity> comments = new LinkedList<>();

    public PostEntity addComment(CommentEntity comment){
        comments.add(comment);
        return this;
    }

    public PostEntity() {
    }

    public PostEntity(int id, String author, String text) {
        this.id = id;
        this.author = author;
        this.text = text;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }

    public List<CommentEntity> getComments() {
        return comments;
    }

    public void setComments(List<CommentEntity> comments) {
        this.comments = comments;
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }
}
