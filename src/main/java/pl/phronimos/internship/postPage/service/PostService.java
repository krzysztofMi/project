package pl.phronimos.internship.postPage.service;

import org.springframework.stereotype.Service;
import pl.phronimos.internship.postPage.entity.CommentEntity;
import pl.phronimos.internship.postPage.entity.PostEntity;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.atomic.AtomicInteger;

@Service
public class PostService {

    private AtomicInteger postCounter = new AtomicInteger(1);
    private List<PostEntity> posts = new ArrayList<>();
    private CommentService commentService;

    public PostService(CommentService commentService) {
        this.commentService = commentService;
        posts.add(createPost("Java Coder","Hey, do you know if this service the one from internship task?"));
        posts.get(0)
                .addComment(commentService.getComment(1).get())
                .addComment(commentService.getComment(2).get());

        posts.add(createPost("Spring Master Wannabe", "Oh, man it's quite difficult"));
        posts.get(1)
                .addComment(commentService.getComment(3).get());
    }

    public PostEntity createPost(String author, String text){
        return new PostEntity(postCounter.getAndIncrement(), author, text);
    }

    public List<PostEntity> getAllPosts(){
        return posts;
    }

    public void addCommentToPost(int postId, CommentEntity comment) {
        PostEntity postToAddComment = posts.stream()
                .filter(post -> post.getId()==postId)
                .findFirst()
                .orElseThrow(() -> new RuntimeException("Post of id: " + postId + " not found"));
        CommentEntity commentToAdd = commentService.createComment(comment.getText());
        postToAddComment.addComment(commentToAdd);
    }
}
