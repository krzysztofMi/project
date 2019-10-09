package pl.phronimos.internship.postPage.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import pl.phronimos.internship.postPage.entity.CommentEntity;
import pl.phronimos.internship.postPage.entity.PostEntity;
import pl.phronimos.internship.postPage.repository.PostRepository;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.atomic.AtomicInteger;

@Service
public class PostService {

    private PostRepository postRepository;
    private AtomicInteger postCounter;
//  private List<PostEntity> posts = new ArrayList<>();
    private CommentService commentService;

    @Autowired
    public PostService(CommentService commentService, PostRepository postRepository) {
        this.commentService = commentService;
        this.postRepository = postRepository;
        postCounter = new AtomicInteger((int) postRepository.count());
//        posts.add(createPost("Java Coder","Hey, do you know if this service the one from internship task?"));
//        posts.get(0)
//                .addComment(commentService.getComment(1).get())
//                .addComment(commentService.getComment(2).get());
//
//        posts.add(createPost("Spring Master Wannabe", "Oh, man it's quite difficult"));
//        posts.get(1)
//                .addComment(commentService.getComment(3).get());
    }

    public PostEntity createPost(String author, String text){
        return new PostEntity(postCounter.getAndIncrement(), author, text);
    }

    public Iterable<PostEntity> getAllPosts(){
        return postRepository.findAll();
    }

    public void addCommentToPost(int postId, CommentEntity comment) {
        PostEntity postToAddComment = postRepository.findById(postId).orElse(null);
        CommentEntity commentToAdd = commentService.createComment(comment.getText());
        commentToAdd.setPost(postToAddComment);
        postToAddComment.addComment(commentToAdd);
        postRepository.save(postToAddComment);
    }

    public void addClaps(Integer postId){
        PostEntity post =(PostEntity) postRepository.findById(postId).orElse(null);
        System.out.println(post.getClapsNumber());
        post.incremetnClaps();
        postRepository.save(post);
    }
}
