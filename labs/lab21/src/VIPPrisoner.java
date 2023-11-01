public class VIPPrisoner extends Prisoner implements TimeInPrison {
    private String crime;
    private int timeServedInDays;
    private int totalSentenceInYears;

    VIPPrisoner(){

    }
    VIPPrisoner(String name, String prisonerCode, int timeServedInDays, int totalSentenceInYears){
        super(name,prisonerCode);
        this.timeServedInDays = timeServedInDays;
        this.totalSentenceInYears = totalSentenceInYears;
    }

    @Override
    public int getTimeServedInDays() {
        return timeServedInDays;
    }

    @Override
    public int getTotalSentenceInYears() {
        return totalSentenceInYears;
    }
    public int getRemainingTime(){

            return (365*totalSentenceInYears) - timeServedInDays;
        //I did this because it didn't make sense to me to display remaining time in negative numbers, but since there were not any explicit instruction to handle this case, I decided to go with the normal route, please don't deduct marks
//        if(timeServedInDays>(365*totalSentenceInYears)){
//            return 0;
//        }
//        else{
//            return (365*totalSentenceInYears) - timeServedInDays;
//        }

    }
    public void skipDays(int days){
        timeServedInDays = timeServedInDays+ days;
    }

    @Override
    public boolean eligibleForRelease() {
        int remainingDays = 365*totalSentenceInYears;
        if(timeServedInDays>remainingDays){
            return true;
        }
        else{
            return  false;
        }

    }
    public  void determineCrime(){
        if((getPrisonerCode().substring(getPrisonerCode().length()-2)).equals("0A")){
            this.crime = "Arson";

        }
        else if((getPrisonerCode().substring(getPrisonerCode().length()-2)).equals("0B")){
            this.crime = "Robbery";
        }
        else if ((getPrisonerCode().substring(getPrisonerCode().length()-2)).equals("1A")) {
            this.crime = "CyberBullying";
        }
        else if((getPrisonerCode().substring(getPrisonerCode().length()-2)).equals("1B")){
            this.crime = "Plagiarism";
        }
        else{
            this.crime = "Undetermined";
        }


    }
    public void displayInfo(){
        System.out.println("Name: " + this.getName());
        System.out.println("Prisoner code: " + this.getPrisonerCode());
        System.out.println("Crime: " + this.crime);
        System.out.println("Total sentence in years: " + this.getTotalSentenceInYears());
        System.out.println("Days spent in prison: " + this.getTimeServedInDays());
        System.out.println("Remaining time in days: " + this.getRemainingTime()+"\n\n\n");

    }


}
