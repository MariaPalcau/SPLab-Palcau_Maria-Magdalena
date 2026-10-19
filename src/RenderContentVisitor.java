public class RenderContentVisitor implements Visitor{
    @Override
    public void visit(Book b){
        b.render();
    }
    @Override
    public void visit(Section s){
        s.render();
    }
    @Override
    public void visit(TableOfContents toc){
        toc.render();
    }
    @Override
    public void visit(Paragraph p){
        p.render();
    }
    @Override
    public void visit(ImageProxy ip){
        ip.render();
    }
    @Override
    public void visit(Image i){
        i.render();
    }
    @Override
    public void visit(Table t){
        t.render();
    }
}
