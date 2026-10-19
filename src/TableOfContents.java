public class TableOfContents implements Element {
    private String content;

    public TableOfContents(String content){
        this.content = content;
    }
    @Override
    public void render(){
        System.out.println("Table of Contents: ");
        System.out.println(content);
    }
    @Override
    public void accept(Visitor v) {
        v.visit(this);
    }
}