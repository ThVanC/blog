package thomas.blog.services.repositories;

import org.springframework.stereotype.Repository;
import thomas.blog.services.model.Post;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by Thomas.VanCleemput on 15/10/2016.
 */
@Repository
public class PostRepository {

    @PersistenceContext
    private EntityManager em;

    public List<Post> getAllPosts() {
        return em.createNamedQuery(Post.FIND_ALL).getResultList();
    }

    public Post getPostById(String id) {
        Post post = em.find(Post.class, id);
        return post;
    }

    public void save(Post toCreate) {
        em.persist(toCreate);
    }

    public void deletePost(Post toDelete) {
        em.remove(toDelete);
    }
}
