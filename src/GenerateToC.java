import java.util.ArrayList;
import java.util.List;

public class GenerateToC implements Visitor {
    private List<String> chapters = new ArrayList<>();
    public TableOfContents getToC(){
        return new TableOfContents(String.join("\n", chapters));
    }

    @Override
    public void visit(Section s){
        chapters.add("-" + s.getTitle());
    }
}
