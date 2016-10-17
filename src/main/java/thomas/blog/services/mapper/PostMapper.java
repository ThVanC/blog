package thomas.blog.services.mapper;

import org.springframework.stereotype.Component;
import thomas.blog.rest.model.PostResource;
import thomas.blog.services.model.Post;
import thomas.blog.services.repositories.PostRepository;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Thomas.VanCleemput on 15/10/2016.
 */
@Component
public class PostMapper {

    public PostMapper() {

    }

    public List<PostResource> map(List<Post> posts) {
        List<PostResource> output = new ArrayList<>();

        for(Post post:posts){
            PostResource pr = map(post);
            output.add(pr);
        }
        return output;
    }

    public PostResource map(Post post){
        PostResource output = new PostResource();
        output.setTitle( post.getTitle() );
        output.setBody( post.getBody() );
        return output;
    }
}
