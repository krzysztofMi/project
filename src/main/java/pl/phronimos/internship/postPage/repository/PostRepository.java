package pl.phronimos.internship.postPage.repository;


import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import pl.phronimos.internship.postPage.entity.PostEntity;

@Repository
public interface PostRepository extends CrudRepository<PostEntity, Integer> {
}
