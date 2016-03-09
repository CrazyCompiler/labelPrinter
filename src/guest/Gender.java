package guest;

import representors.Honorific;

public class Gender {
    String gender;

    public Gender(String gender) {
        this.gender = gender;
    }

    public String getHonorific() {
        return Honorific.valueOf(this.gender).toString();
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Gender)) return false;

        Gender gender1 = (Gender) o;

        return gender.equals(gender1.gender);

    }
}