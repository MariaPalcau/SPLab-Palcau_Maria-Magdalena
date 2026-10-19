interface Visitor {
    default void visit(Book b){}
    default void visit(Section s){}
    default void visit(TableOfContents toc){}
    default void visit(Paragraph p){}
    default void visit(ImageProxy ip){}
    default void visit(Image i){}
    default void visit(Table t){}
}
