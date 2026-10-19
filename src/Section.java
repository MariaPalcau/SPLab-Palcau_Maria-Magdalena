import java.util.ArrayList;
import java.util.List;

public class Section implements Element {
    private String title;
    private List<Element> elements;

    public Section(String title){
        this.title = title;
        this.elements = new ArrayList<>();
    }

    @Override
    public void render(){
        System.out.println(title);
    }

    @Override
    public void add(Element e){
        elements.add(e);
    }

    @Override
    public void remove(Element e){
        elements.remove(e);
    }

    @Override
    public Element get(int index){
        return elements.get(index);
    }

    public List<Element> getElements() {
        return elements;
    }

    public String getTitle(){
        return title;
    }

    @Override
    public void accept(Visitor v) {
        v.visit(this);
        for (Element e: elements) {
            e.accept(v);
        }
    }
}