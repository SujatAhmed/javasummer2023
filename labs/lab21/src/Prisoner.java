public abstract class Prisoner implements CrimeDetection{
    private String name;
    private String prisonerCode;
    Prisoner(){

    }
    Prisoner(String name , String prisonerCode){
        this.name = name;
        this.prisonerCode = prisonerCode;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public void setPrisonerCode(String prisonerCode) {
        this.prisonerCode = prisonerCode;
    }

    public String getPrisonerCode () {
        return prisonerCode;
    }
    public abstract void determineCrime();
}
