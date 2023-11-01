public class ActionMovie extends Movie implements ActionPreRequesties{
    private double intensityRating;
    private double boringRating;
    ActionMovie(){
    }
    ActionMovie(String name, String language, String leadActor){
        super(name,language,leadActor);
    }

    @Override
    public void setIntensityRating(int rating) throws IllegalArgumentException {
        if(rating>10 || rating<0){
            throw new IllegalArgumentException("This is not a legal rating: "+ rating);
        }
        this.intensityRating = rating;
    }

    public double getAverageRating(){
        return (intensityRating+boringRating)/2;
    }

    public void setBoringRating(int rating) throws IllegalArgumentException {
        if(rating>10 || rating<0){
            throw new IllegalArgumentException("This is not a legal rating: "+ rating);
        }
        this.boringRating = rating;

    }

    public void displayInfo(){
        System.out.println("Name: " + this.getName());
        System.out.println("Language: " + this.getLanguage() );
        System.out.println("Lead Actor: " + this.getLeadActor());
        System.out.println("Intensity Rating: " + this.intensityRating );
        System.out.println("Boring Rating: " + this.boringRating);
        System.out.println("Average Rating: " + this.getAverageRating());


    }
}
