
public class NonFictionBook extends Book {
    private String subject;
    NonFictionBook(){

    }
    NonFictionBook(String name, String author, String subject){
        super(name,author);
        this.subject = subject;
    }

    public String getSubject() {
        return subject;
    }

    public void setSubject(String subject) {
        this.subject = subject;
    }
    @Override
    public void displayInfo(){
        super.displayInfo();
        System.out.println("Subject: " + this.subject);
    }
    public boolean isRecommendedAge(int age){
        if(age>=18){
            return true ;
        }
        else{
            return false;
        }
    }
}
