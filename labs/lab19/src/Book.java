public abstract  class Book {
    private String name;
    private String author;

    Book(){

    }
    Book(String name , String author){
        this.author = author;
        this.name = name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public String getAuthor() {
        return author;
    }
    public void displayInfo(){
        System.out.println("Name: " + this.name);
        System.out.println("Author: " + this.author);
    }
    public abstract boolean isRecommendedAge(int age);

}
