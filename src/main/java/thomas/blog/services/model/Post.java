package thomas.blog.services.model;

import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;

/**
 * Created by Thomas.VanCleemput on 17/10/2016.
 */
@Entity
@NamedQueries({
        @NamedQuery(
                name = Post.FIND_ALL,
                query = "select post from Post post"
        )
})
public class Post {

    public static final String FIND_ALL = "Post.findAll";

    @Id
    @GeneratedValue(generator="system-uuid")
    @GenericGenerator(name="system-uuid", strategy = "uuid")
    private String id;

    private String title;
    private String body;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getBody() {
        return body;
    }

    public void setBody(String body) {
        this.body = body;
    }
}
