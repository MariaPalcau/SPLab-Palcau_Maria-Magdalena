public class ImageProxy implements Element {
    private String url;
    private Image realImage;

    public ImageProxy(String url){
        this.url = url;
        this.realImage = null;
    }

    private Image loadImage(){
        if(realImage == null){
            realImage = new Image(url);
        }
        return realImage;
    }

    @Override
    public void render(){
        loadImage().render();
    }

    @Override
    public void accept(Visitor v) {
        v.visit(this);
    }
}
