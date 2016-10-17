package thomas.blog.rest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import thomas.blog.rest.model.CreatePostCommand;
import thomas.blog.rest.model.PostResource;
import thomas.blog.services.PostService;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Thomas.VanCleemput on 15/10/2016.
 */
@Controller
@RequestMapping("/post")
public class PostController {

    @Autowired
    private PostService postService;

    @RequestMapping(method = RequestMethod.POST,consumes = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<?> createPost(@RequestBody CreatePostCommand postCommand){
        String id = postService.createPost(postCommand);
        return ResponseEntity.ok(id);
    }

    @RequestMapping(value = "/{id}", method = RequestMethod.POST, consumes = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<?> updatePost(@PathVariable String id, @RequestBody CreatePostCommand postCommand){
        String output = postService.updatePost(id, postCommand);
        return ResponseEntity.ok(id);
    }

    @RequestMapping(method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<List<PostResource>> getPosts(){
        List<PostResource> output = postService.getPosts();
        return ResponseEntity.ok(output);
    }

    @RequestMapping(value = "/{id}", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<PostResource> getPost(@PathVariable String id){
        PostResource output = postService.getPost(id);
        return ResponseEntity.ok(output);
    }

    @RequestMapping(value = "/{id}", method = RequestMethod.DELETE)
    public ResponseEntity<?> deletePost(@PathVariable String id){
        postService.deletePost(id);
        return ResponseEntity.ok(null);
    }
}
