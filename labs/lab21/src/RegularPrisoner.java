public class RegularPrisoner extends Prisoner {
    private  String Crime;
    RegularPrisoner(){

    }

    RegularPrisoner(String name, String prisonerCode ){
        super(name, prisonerCode);
    }
    @Override
    public  void determineCrime(){
        if((getPrisonerCode().substring(getPrisonerCode().length()-2)).equals("OA")){
            this.Crime = "Arson";
        }
        else if((getPrisonerCode().substring(getPrisonerCode().length()-2)).equals("0B")){
            this.Crime = "Robbery";
        }
        else if ((getPrisonerCode().substring(getPrisonerCode().length()-2)).equals("1A")) {
            this.Crime = "CyberBullying";
        }
        else if((getPrisonerCode().substring(getPrisonerCode().length()-2)).equals("1B")){
            this.Crime = "Plagiarism";
        }
        else{
            this.Crime = "Undetermined";
        }

    }
    public void DisplayInfo(){
        System.out.println("Name " + this.getName());
        System.out.println("Prisoner Code" + this.getPrisonerCode());
        System.out.println("Crime " + this.Crime);
    }





}
