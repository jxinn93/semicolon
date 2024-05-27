package YoungStudents;

public class Quiz {
    private String title;
    private String theme;
    private boolean completed;

    public Quiz(String title,String theme){
        this.title=title;
        this.theme=theme;
        this.completed=false;
    }

    public String getTitle(){
        return this.title;
    }

    public String getTheme(){
        return this.theme;
    }

    public boolean isCompleted(){
        return completed;
    }

    public void setTitle(String title){
        this.title=title;
    }

    public void setTheme(String theme){
        this.theme=theme;
    }

    public void setCompleted(boolean completed){
        this.completed=completed;
    }

}
