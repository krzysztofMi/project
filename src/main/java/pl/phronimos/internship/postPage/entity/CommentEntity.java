package pl.phronimos.internship.postPage.entity;

import javax.persistence.*;

@Entity
@Table(name = "comment")
public class CommentEntity {
    @Id
    private int id;
    private String text;
    @ManyToOne
    private PostEntity post;


    public CommentEntity() {
    }

    public CommentEntity(int id, String text) {
        this.id = id;
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

    public PostEntity getPost() { return post;}

    public void setPost(PostEntity post) { this.post = post;}
}
