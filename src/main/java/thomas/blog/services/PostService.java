package thomas.blog.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import thomas.blog.rest.model.CreatePostCommand;
import thomas.blog.rest.model.PostResource;
import thomas.blog.rest.model.UpdatePostCommand;
import thomas.blog.services.mapper.PostMapper;
import thomas.blog.services.model.Post;
import thomas.blog.services.repositories.PostRepository;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Thomas.VanCleemput on 15/10/2016.
 */
@Service
@Transactional(readOnly = false)
public class PostService {

    @Autowired
    private PostRepository postRepository;

    @Autowired
    private PostMapper postMapper;

    public PostService() {

    }

    public List<PostResource> getPosts(){
        List<Post> result = this.postRepository.getAllPosts();
        return this.postMapper.map(result);
    }

    public PostResource getPost(String id){
        Post result = this.postRepository.getPostById( id );
        return this.postMapper.map(result);
    }

    public String createPost(CreatePostCommand command){
        Post post = new Post();
        post.setTitle( command.getTitle() );
        post.setBody( command.getBody() );
        this.postRepository.save(post);
        return post.getId();
    }

    public String updatePost(String id, CreatePostCommand command){
        Post post = new Post();
        post.setId( id );
        post.setTitle( command.getTitle() );
        post.setBody( command.getBody() );
        this.postRepository.save( post );
        return post.getId();
    }

    public void deletePost(String id){
        Post post = this.postRepository.getPostById( id );
        this.postRepository.deletePost( post );
    }

}
