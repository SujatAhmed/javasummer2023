public abstract class Movie {
    private String name;
    private String language;
    private String leadActor;

    Movie(){

    }
    Movie(String name, String language, String leadActor){
        this.name = name;
        this.language = language;
        this.leadActor = leadActor;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public void setLanguage(String language) {
        this.language = language;
    }

    public String getLanguage() {
        return language;
    }

    public void setLeadActor(String leadActor) {
        this.leadActor = leadActor;
    }

    public String getLeadActor() {
        return leadActor;
    }
}
