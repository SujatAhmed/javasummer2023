public class FictionBook extends Book {
    private String Genre;
    FictionBook(){

    }
    FictionBook(String name, String author, String genre){
        super(name, author);
        this.Genre = genre;
    }

    public void setGenre(String genre) {
        Genre = genre;
    }

    public String getGenre() {
        return Genre;
    }
    @Override
    public void displayInfo(){
        super.displayInfo();
        System.out.println("Genre: " +this.Genre);
    }
    public boolean isRecommendedAge(int age){
        if(age>=14){
            return true ;
        }
        else{
            return false;
        }
    }
}
