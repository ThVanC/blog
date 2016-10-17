package thomas.blog.rest;

import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import java.util.ArrayList;
import java.util.List;

@Controller
@RequestMapping("/accounts")
public class AccountController {

    @RequestMapping(method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<List<String>> getAccount(){
        //TODO
        List<String> output = new ArrayList<>();
        output.add("My first controller");
        output.add("Second string in the controller");
        return ResponseEntity.ok(output);
    }

}
