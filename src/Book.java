import java.util.ArrayList;
import java.util.List;

public class Book {
    private String title;
    private List<Author> authors;
    private List<Element> elements;

    public Book(String title){
        this.title = title;
        this.authors = new ArrayList<>();
        this.elements = new ArrayList<>();
    }

    public void print(){
        System.out.println("Book: " + title);
        System.out.println("Authors: ");
        for (Author a: authors) {
            a.print();
        }
        for (Element e: elements) {
            e.print();
        }
    }

    public void addAuthor(Author a){
        authors.add(a);
    }

    public void addContent(Element e) {
        elements.add(e);
    }
}