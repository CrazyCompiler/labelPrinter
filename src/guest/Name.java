package guest;

import representors.NamingConventionGenerator;

public class Name {
    private String firstName;
    private String lastName;


    public Name(String firstName, String lastName) {
        this.firstName = firstName;
        this.lastName = lastName;
    }

    public String getRepresentation(NamingConventionGenerator convention) {
        return convention.getRepresentation(this.firstName, this.lastName);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Name)) return false;

        Name name = (Name) o;

        return firstName.equals(name.firstName) && lastName.equals(name.lastName);

    }
}
