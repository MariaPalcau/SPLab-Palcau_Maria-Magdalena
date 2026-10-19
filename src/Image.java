import java.util.concurrent.TimeUnit;

public class Image implements Element {
    private String url;

    public Image(String url){
        this.url = url;
        try {
            TimeUnit.SECONDS.sleep(5);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void render(){
        System.out.println(url);
    }

    @Override
    public void accept(Visitor v) {
        v.visit(this);
    }
}