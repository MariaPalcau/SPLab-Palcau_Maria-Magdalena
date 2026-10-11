public class AlignRight implements AlignStrategy {
    @Override
    public void render(Paragraph p){
        System.out.println("            " + p.getText());
    }

}
