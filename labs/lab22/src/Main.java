
import java.util.HashMap;

public class Main {

    public static void main(String[] args) {

        HashMap<String,Movie> movieLog = new HashMap<>();

        movieLog.put("Mission Impossibe", new ActionMovie("Mission Impossible", "English" ,"Tom Cruise"));
        movieLog.put("Die Hard" , new ActionMovie("Die Hard" , "English", "Bruice Willis"));
        movieLog.put("The Matrix" , new ActionMovie("The Matrix", "English", "Keanu Reeves"));
        movieLog.put("Superbad", new ComedyMovie("Superbad", "English", "Jonah Hill"));
        movieLog.put("Dumb and Dumber", new ComedyMovie("Dumb and Dumber", "English", "Jim Carrey"));
        movieLog.put("Anchorman", new ComedyMovie("Anchorman", "English", "Will Ferrell"));


        for(Movie movie : movieLog.values()){

            if(movie instanceof ActionMovie){

                ActionMovie newMovie = (ActionMovie)movie;

                int random = (int)(Math.random()*10);
                int random2 = (int)(Math.random()*10);

                try {
                    newMovie.setIntensityRating(random);
                }catch (IllegalArgumentException ex){
                    System.out.println(ex.getMessage());
                }

                try {
                    newMovie.setBoringRating(random2);
                }catch (IllegalArgumentException ex){
                    System.out.println(ex.getMessage());
                }

                newMovie.displayInfo();
                System.out.println("\n");

            }

            else if(movie instanceof ComedyMovie){
                ComedyMovie newMovie = (ComedyMovie)movie;


                int random = (int)(Math.random()*10);
                int random2 = (int)(Math.random()*10);


                try {
                    newMovie.setHumorRating(random);
                }catch (IllegalArgumentException ex){
                    System.out.println(ex.getMessage());
                }

                try {
                    newMovie.setCringRatiing(random2);
                }catch (IllegalArgumentException ex){
                    System.out.println(ex.getMessage());
                }

                newMovie.displayInfo();
                System.out.println("\n");
            }

        }

    }
}
