package fabiomarras.u5w2d2.services;

import fabiomarras.u5w2d2.NotFoundException;
import fabiomarras.u5w2d2.entities.Blog;
import fabiomarras.u5w2d2.repositories.BlogsRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class BlogsService {
    //GET /blogPosts
    //GET /blogPosts/id
    //POST /blogPosts - crea
    //PUT /blogPosts/id - modifica
    //DELETE /blogPosts/id - cancella

    @Autowired
    private BlogsRepository blogsRepository;

    //GET /blogPosts
    public List<Blog> getBlogs() {
        return blogsRepository.findAll();
    }

    //GET /blogPosts/id
    public Blog findById(int id){
      return blogsRepository.findById(id).orElseThrow(() -> new NotFoundException(id));
    }

    //POST /blogPosts - crea
    public Blog save(Blog body){
        return blogsRepository.save(body);
    }

    //PUT /blogPosts/id - modifica
    public Blog findByIdAndUpdate(int id, Blog body){
        Blog blog = this.findById(id);
        blog.setTitolo(body.getTitolo());
        blog.setContenuto(body.getContenuto());
        blog.setTempoDiLettura(body.getTempoDiLettura());
        return blogsRepository.save(blog);
    }

    //DELETE /blogPosts/id - cancella
    public void findByIdAndDelete(int id) {
    Blog blog = this.findById(id);
    blogsRepository.delete(blog);
    }
}
