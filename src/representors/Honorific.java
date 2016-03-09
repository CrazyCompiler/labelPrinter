package representors;

public enum Honorific {
    Male("Mr"), Female("Ms");
    private String gender;

    Honorific(String gender) {
        this.gender = gender;
    }

    public String toString(){
        return this.gender+"";
    };
}
