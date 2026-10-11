public class Paragraph implements Element {
    private String text;
    private AlignStrategy alignment;

    public Paragraph(String text){
        this.text = text;
        this.alignment = new AlignLeft();
    }

    @Override
    public void print(){
        alignment.render(this);
    }

    public String getText(){
        return text;
    }

    public void setAlignStrategy(AlignStrategy as){
        this.alignment = as;
    }
}