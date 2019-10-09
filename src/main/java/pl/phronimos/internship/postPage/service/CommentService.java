package pl.phronimos.internship.postPage.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import pl.phronimos.internship.postPage.entity.CommentEntity;
import pl.phronimos.internship.postPage.repository.CommentRepository;

import java.util.Optional;
import java.util.concurrent.atomic.AtomicInteger;

@Service
public class CommentService {

    private CommentRepository commentRepository;
    private AtomicInteger commentCounter;

    @Autowired
    CommentService(CommentRepository commentRepository) {
        this.commentRepository = commentRepository;
        commentCounter = new AtomicInteger((int) commentRepository.count()+1);
    }
    public CommentEntity createComment(String text) {
        return commentRepository.save(new CommentEntity(commentCounter.getAndIncrement(), text));
    }
    public Optional<CommentEntity> getComment(int commentId){
        return commentRepository.findById(commentId);
    }

}
