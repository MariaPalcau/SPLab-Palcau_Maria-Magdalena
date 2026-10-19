interface Element {
    void render();
    default void add(Element e){
        throw new UnsupportedOperationException();
    }
    default void remove(Element e){
        throw new UnsupportedOperationException();
    }
    default Element get(int i){
        throw new UnsupportedOperationException();
    }
    void accept(Visitor v);
}