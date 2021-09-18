package co.com.poli.serviceuser.controller;

import co.com.poli.commonslibrary.libraries.FormatMessage;
import co.com.poli.commonslibrary.libraries.Response;
import co.com.poli.commonslibrary.libraries.ResponseBuilder;
import co.com.poli.serviceuser.entities.User;
import co.com.poli.serviceuser.services.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;


@RestController
@RequestMapping("/movie")
@RequiredArgsConstructor
public class UserController {

    private final UserService userService;
    private final ResponseBuilder builder = new ResponseBuilder();
    private final FormatMessage message = new FormatMessage();

    @PostMapping
    public Response save(@Valid @RequestBody User user, BindingResult result){
        if(result.hasErrors()){
            return builder.failed(message.formatMessage((result)));
        }
        userService.save(user);
        return builder.success(user);
    }

    @DeleteMapping("/{id}")
    public Response delete(@PathVariable("id") Long id, @RequestBody User user,  BindingResult result){
        User users = userService.findById(id);
        if(result.hasErrors()){
            return builder.failed(message.formatMessage((result)));
        }
        userService.delete(users);
        return builder.success(users);
    }

    @GetMapping
    public ResponseEntity<List<User>> findAll(){
        List<User> products = userService.findAll();
        if(products.isEmpty()){
            return ResponseEntity.noContent().build();
        }
        return ResponseEntity.ok(products);
    }

    @GetMapping("/users/{id}")
    public Response findById(@PathVariable("id") Long id){
        User user = userService.findById(id);
        if(user==null){
            return builder.success(null);
        }
        return builder.success(user);
    }

}
