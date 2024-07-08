 
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;
import java.util.function.Function;
import java.util.stream.Collectors;

import static java.util.stream.Collectors.toMap;

public class Main {

    public static void main(String[] args) throws IOException {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Choose from the following options:\n" +
                "a: Art\n" +
                "p: Papers");
        String choice = scanner.nextLine();
        if (choice.equals("a")){
            artMenu(scanner);
        }
        if (choice.equals("p")){
            paperMenu(scanner);
        }
    }
    public static Painting readElementDetails(String path) throws IOException {
        Painting painting = new Painting();
        Map<String, Element> files = new HashMap();

        Files.lines(Paths.get(path))
            .map(str -> ElementDetailsFactory.getPaintingElement(str))
            .forEach(e-> painting.addElement(e));
        return painting;
    }
    public static void artMenu(Scanner scanner) throws IOException {
        System.out.println("Enter the path of the painting description");
        String path=scanner.nextLine();
        Painting root= readElementDetails(path);
        System.out.println("Choose from the following options:\n" +
                "q: quit\n" +
                "c: count elements\n" +
                "lp: long print\n" +
                "sh: short print\n" +
                "ta: total area");
        String myString;
        while (!(myString = scanner.nextLine()).equals("q")) {
            switch (myString) {
                case "c":
                    CalcElementsVisitor calcElementsVisitor = new CalcElementsVisitor();
                    for(Element e : root.elementList){
                        e.accept(calcElementsVisitor);
                    }
                    System.out.println(calcElementsVisitor.getNumberElements());
                    break;
                case "sh":
                    ShortPrintVisitor shortPrintVisitor = new ShortPrintVisitor();
                    for(Element e : root.elementList){
                        e.accept(shortPrintVisitor);
                    }
                    break;
                case "ta":
                    calcAreaVisitor calcAreaVisitor = new calcAreaVisitor();
                    for(Element e : root.elementList){
                        e.accept(calcAreaVisitor);
                    }
                    System.out.println(calcAreaVisitor.getTotalArea());
                    break;
                case "lp":
                    LongPrintVisitor longPrintVisitor = new LongPrintVisitor();
                    for(Element e : root.elementList){
                        e.accept(longPrintVisitor);
                    }
                    break;


            }

        }
    }

    public static void paperMenu(Scanner scanner){
        System.out.println("Choose from the following paper:\n" +
                "ac: academic paper\n" +
                "cn: contract\n" +
                "jr: journal article\n" +
                "bk: book");
        Paper paper = null;
        String choice="";
        choice = scanner.nextLine();
        paper = PaperFactory.createPaper(choice);
        while (!choice.equals("s")) {
            System.out.println("Choose from the following options:\n" +
                    "a: add element\n" +
                    "s: submit");
            choice = scanner.nextLine();
            if (choice.equals("a")) {
                paper = paperElementMenu(scanner, paper);
            }
            if (choice.equals("s")) {
                System.out.println(paper.write());

            }
        }


    }
   public static Paper paperElementMenu(Scanner scanner, Paper paper){
        System.out.println("Choose from the following elements:\n" +
                "tb: table\n" +
                "eq: equation\n" +
                "d: diagram\n" +
                "nt: note");
        String choice = scanner.nextLine();
        if (choice.equals("tb")) {
            System.out.println(new TableDecorator(paper).write());
        }
        else if (choice.equals("eq")) {
            System.out.println(new EquationDecorator(paper).write());
        }
        else if (choice.equals("d")) {
            System.out.println(new DiagramDecorator(paper).write());
        }
        else if (choice.equals("nt")) {
            System.out.println(new NoteDecorator(paper).write());
        }
       return paper;
   }
}
