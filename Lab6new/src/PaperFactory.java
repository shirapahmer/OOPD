 

public class PaperFactory {
    public static Paper createPaper(String code){
        if(code == null){
            return null;
        }
        if(code.equals("ac")){
            return new AcademicPaper();
        }
        else if(code.equals("cn")){
            return new Contract();
        }
        else if(code.equals("jr")){
            return new JournalArticle();
        }
        else if(code.equals("bk")){
            return new Book();
        }
        throw new RuntimeException("wrong PaperType");
    }
}
