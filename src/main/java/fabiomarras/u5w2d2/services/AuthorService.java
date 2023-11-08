package fabiomarras.u5w2d2.services;

import fabiomarras.u5w2d2.NotFoundException;
import fabiomarras.u5w2d2.entities.Author;
import fabiomarras.u5w2d2.entities.Blog;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.ListIterator;
import java.util.Random;

@Service
public class AuthorService {
    //GET /authors
    //GET /authors/id
    //POST /authors - crea
    //PUT /authors/id - modifica
    //DELETE /authors/id - cancella


    private List<Author> authors = new ArrayList<>();

    //GET /authorPosts
    public List<Author> getAuthors() {
        return this.authors;
    }

    //GET /authorPosts/id
    public Author findById(int id){
        Author a = null;
        for (Author author: this.authors) {
            if (author.getId() == id) {
                a = author;
            }
        }
        if(a == null ){
            throw new NotFoundException(id);
        } else {
            return a;
        }
    }

    //POST /authorPosts - crea
    public Author save(Author body){
        Random rndm = new Random();
        body.setId(rndm.nextInt(1, 1000));
        body.setAvatar("https://ui-avatars.com/api/?name=" + body.getNome() + "+" + body.getCognome());
        this.authors.add(body);
        return body;
    }


    //PUT /authorPosts/id - modifica
    public Author findByIdAndUpdate(int id, Author body){
        Author found = null;
        for (Author author:this.authors) {
            if(author.getId() == id){
                found = author;
                found.setId(id);
                found.setNome(body.getNome());
                found.setCognome(body.getCognome());
                found.setEmail(body.getEmail());
                found.setDataDiNascita(body.getDataDiNascita());
            }
        }
        if(found == null ){
            throw new NotFoundException(id);
        } else {
            return found;
        }
    }

    //DELETE /authorPosts/id - cancella
    public void findByIdAndDelete(int id){
        ListIterator<Author> iterator = this.authors.listIterator();
        while (iterator.hasNext()){
            Author current = iterator.next();
            if(current.getId() == id){
                iterator.remove();
            }
        }
    }
}
