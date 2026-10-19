public class Main {

    public static void main (String[] args) throws Exception {
        Book b = new Book("Carte");
        Section cap1 = new Section("Capitolul 1");
        Section cap2 = new Section("Capitolul 2");
        Paragraph p1 = new Paragraph("Paragraph 1");
        cap1.add(p1);
        Paragraph p2 = new Paragraph("Paragraph 2");
        cap1.add(p2);
        Paragraph p3 = new Paragraph("Paragraph 3");
        cap1.add(p3);
        Paragraph p4 = new Paragraph("Paragraph 4");
        cap1.add(p4);
        b.add(cap1);
        b.add(cap2);
        cap1.add(new ImageProxy("ImageOne"));
        cap1.add(new Image("ImageTwo"));
        cap1.add(new Paragraph("Some text"));
        cap1.add(new Table("Table 1"));
        BookStatistics stats = new BookStatistics();
        b.accept(stats);
        b.accept(new RenderContentVisitor());
        stats.printStatistics();
        GenerateToC generator = new GenerateToC();
        b.accept(generator);
        TableOfContents toc = generator.getToC();
        toc.render();
    }
}