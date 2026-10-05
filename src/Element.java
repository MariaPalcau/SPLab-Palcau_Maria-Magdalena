interface Element {
    void print();
    default void add(Element e){
        throw new UnsupportedOperationException();
    }
    default void remove(Element e){
        throw new UnsupportedOperationException();
    }
    default Element get(int i){
        throw new UnsupportedOperationException();
    }
}