public class ComedyMovie  extends Movie implements ComedyPrerequesties{
    private double humorRating;
    private double cringeRating;

    ComedyMovie(){

    }
    ComedyMovie(String name, String language, String leadActor){
        super(name,language,leadActor);
    }

    @Override
    public void setHumorRating(int rating) throws IllegalArgumentException {
        if(rating<0||rating>10){
            throw new IllegalArgumentException("Illegal rating " + rating);
        }
        else{
            humorRating = rating;
        }
    }

    @Override
    public void setCringRatiing(int rating) throws IllegalArgumentException {
        if(rating<0||rating>10){
            throw new IllegalArgumentException("Illegal rating " + rating);
        }
        else{
            cringeRating = rating;
        }
    }

    public double getAverageRating(){
        return (humorRating+cringeRating)/2;
    }
    public void displayInfo(){
        System.out.println("Name: " + this.getName());
        System.out.println("Language: " + this.getLanguage());
        System.out.println("Lead Actor: " + this.getLeadActor());
        System.out.println("Humor Rating " + this.cringeRating);
        System.out.println("Cringe Rating " + this.humorRating);
        System.out.println("Average Rating " + this.getAverageRating());
    }


}
