public class Table implements Element {
    private String name;

    public Table(String name){
        this.name = name;
    }

    @Override
    public void render(){
        System.out.println(name);
    }

    @Override
    public void accept(Visitor v) {
        v.visit(this);
    }
}