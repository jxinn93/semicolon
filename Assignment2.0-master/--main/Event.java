package YoungStudents;

public class Event {
    private String title;
    private String description;
    private boolean registered;

    public String getTitle(){
        return this.title;
    }

    public String getDescription(){
        return this.description;
    }

    public boolean isRegistered(){
        return this.registered;
    }

    public void setTitle(String title){
        this.title=title;
    }

    public void setDescription(String description){
        this.description=description;
    }

    public void setRegistered(boolean registered){
        this.registered=registered;
    }
}
