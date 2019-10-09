package pl.phronimos.internship.postPage.entity;


import org.springframework.data.repository.cdi.Eager;

import javax.persistence.*;
import java.util.LinkedList;
import java.util.List;

@Entity
@Table(name = "post")
public class PostEntity {

    @Id
    private int id;
    private String author;
    private String text;
    private int clapsNumber;

    @OneToMany(mappedBy = "post")
    private List<CommentEntity> comments = new LinkedList<>();

    public PostEntity() {
    }

    public PostEntity addComment(CommentEntity comment){
        comments.add(comment);
        return this;
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

    public int getClapsNumber() { return clapsNumber; }

    public void setClapsNumber(int clapsNumber) { this.clapsNumber = clapsNumber; }

    public void incremetnClaps(){this.clapsNumber++;}
}
