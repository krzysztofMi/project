package pl.phronimos.internship.postPage.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import pl.phronimos.internship.postPage.entity.CommentEntity;

@Repository
public interface CommentRepository extends CrudRepository<CommentEntity, Integer> {
}
