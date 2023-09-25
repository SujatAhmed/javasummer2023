public class ContentWriter extends Employee{
    private int articleCount;
    ContentWriter(){

    }
    ContentWriter(String name, double salary, int articleCount){
        super(name, salary);
        this.articleCount = articleCount;

    }

    public int getArticleCount() {
        return articleCount;
    }

    public void setArticleCount(int articleCount) {
        this.articleCount = articleCount;
    }
    @Override
    public void displayInfo(){
        System.out.println("The name of the content writer is " + this.getName());
        System.out.println("The salary of the content writer is " + this.getSalary());
        System.out.println("The article count of the contentwriter is " + this.articleCount);
    }
    @Override
    public double calculateBonus(double bonus) {

        return (getSalary()*bonus/100)+ (100*(double)articleCount);
    }
}
