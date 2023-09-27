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
        System.out.println("The average salary per each article is" + this.getSalary()/(double) articleCount);
        System.out.println("The bonus is " + this.calculateBonus(50));
    }
    @Override
    public double calculateBonus(double bonus) {

        if(articleCount>15) {
            return (getSalary() * bonus / 100) + (300 * (double) articleCount);
        }
        else{

            return (getSalary() * bonus / 100) + (100 * (double) articleCount);
        }
    }
}
