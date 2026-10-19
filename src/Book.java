import java.util.ArrayList;
import java.util.List;

public class Book extends Section{
    private List<Author> authors;

    public Book(String title){
        super(title);
        this.authors = new ArrayList<>();
    }

    public void render(){
        super.render();
        System.out.println("Authors: ");
        for (Author a: authors) {
            a.print();
        }
    }

    @Override
    public void accept(Visitor v) {
        v.visit(this);
        for (Element e: getElements()) {
            e.accept(v);
        }
    }

    public void addAuthor(Author a){
        authors.add(a);
    }

    public List<Author> getAuthors(){
        return authors;
    }
}