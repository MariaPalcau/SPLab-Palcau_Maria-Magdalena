public class BookStatistics implements Visitor{
    private int sections = 0;
    private int paragraphs = 0;
    private int images = 0;
    private int tables = 0;
    public void printStatistics(){
        System.out.println("Book statistics:");
        System.out.println("*** Number of images: " + images);
        System.out.println("*** Number of paragraphs: " + paragraphs);
        System.out.println("*** Number of tables: " + tables);
    }

    @Override
    public void visit(Section s){
        sections++;
    }
    @Override
    public void visit(Paragraph p){
        paragraphs++;
    }
    @Override
    public void visit(ImageProxy ip){
        images++;
    }
    @Override
    public void visit(Image i){
        images++;
    }
    @Override
    public void visit(Table t){
        tables++;
    }
}
