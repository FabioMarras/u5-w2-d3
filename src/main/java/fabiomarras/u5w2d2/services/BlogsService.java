package fabiomarras.u5w2d2.services;

import fabiomarras.u5w2d2.NotFoundException;
import fabiomarras.u5w2d2.entities.Blog;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.ListIterator;
import java.util.Random;

@Service
public class BlogsService {
    //GET /blogPosts
    //GET /blogPosts/id
    //POST /blogPosts - crea
    //PUT /blogPosts/id - modifica
    //DELETE /blogPosts/id - cancella

    private List<Blog> blogs = new ArrayList<>();

    //GET /blogPosts
    public List<Blog> getUsers() {
        return this.blogs;
    }

    //GET /blogPosts/id
    public Blog findById(int id){
        Blog b = null;
        for (Blog blog: this.blogs) {
            if (blog.getId() == id) {
                b = blog;
            }
        }
        if(b == null ){
            throw new NotFoundException(id);
        } else {
            return b;
        }
    }

    //POST /blogPosts - crea
    public Blog save(Blog body){
        Random rndm = new Random();
        body.setId(rndm.nextInt(1, 1000));
        this.blogs.add(body);
        return body;
    }

    //PUT /blogPosts/id - modifica
    public Blog findByIdAndUpdate(int id, Blog body){
        Blog found = null;
        for (Blog blog:this.blogs) {
            if(blog.getId() == id){
                found = blog;
                found.setId(id);
                found.setCategoria(body.getCategoria());
                found.setTitolo(body.getTitolo());
                found.setCover(body.getCover());
                found.setContenuto(body.getContenuto());
                found.setTempoDiLettura(body.getTempoDiLettura());
            }
        }
        if(found == null ){
            throw new NotFoundException(id);
        } else {
            return found;
        }
    }

    //DELETE /blogPosts/id - cancella
    public void findByIdAndDelete(int id){
        ListIterator<Blog> iterator = this.blogs.listIterator();

        while (iterator.hasNext()){
            Blog current = iterator.next();
            if(current.getId() == id){
                iterator.remove();
            }
        }
    }
}
