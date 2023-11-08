package fabiomarras.u5w2d2.controllers;

import fabiomarras.u5w2d2.entities.Blog;
import fabiomarras.u5w2d2.services.BlogsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/blogs")
public class BlogsController {

    @Autowired
    private BlogsService blogsService;

    //GET /blogPosts
    @GetMapping("")
    public List<Blog> getBlogs(){
        return blogsService.getUsers();
    }

    //GET /blogPosts/id
    @GetMapping("/{id}")
    public Blog findById(@PathVariable int id){
        return blogsService.findById(id);
    }

    //POST /blogPosts - crea
    @PostMapping("")
    public Blog saveNewBook(@RequestBody Blog body){
        return blogsService.save(body);
    }

    //PUT /blogPosts/id - modifica
    @PutMapping("/{id}")
    public Blog findByIdAndUpdate(@PathVariable int id, @RequestBody Blog body){
        return blogsService.findByIdAndUpdate(id, body);
    }

    //DELETE /blogPosts/id - cancella
    @DeleteMapping("/{id}")
    public void findByIdAndDelete(@PathVariable int id){
        blogsService.findByIdAndDelete(id);
    }
}
