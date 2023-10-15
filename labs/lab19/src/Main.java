import java.util.ArrayList;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {

        ArrayList<Book> books= new ArrayList<Book>();
        books.add(new FictionBook("Mother of learning", "Nobody103", "Time loop"));
        books.add(new FictionBook("Lord of the rings ", "JRR Tolkien", "Fantasy"));
        books.add(new FictionBook("The God Father", "Mario Puzo", "Mob and Crime"));
        books.add(new NonFictionBook("12 Rules of Life ","Jordan Peterson","Self improvement"));
        books.add(new NonFictionBook("Sapiens: A Brief History of Humankind","Yuval Noah Harari","History/Anthropology"));
        books.add(new NonFictionBook("Becoming","Michelle Obama","Autobiography/Memoir"));

        for(Book b: books){
            b.displayInfo();
            if(b instanceof FictionBook){
                if(b.isRecommendedAge(16)){
                    System.out.println("This book is eligible for a 16 year old\n\n");

                }
                else{
                    System.out.println("This book is not eligible for a 16 year old\n\n");
                }
            }
            if(b instanceof NonFictionBook){
                if(b.isRecommendedAge(16)){
                    System.out.println("This book is eligible for a 16 year old\n\n");
                }
                else{

                    System.out.println("This book is not eligible for a 16 year old\n\n");
                }
            }
        }
    }
}
