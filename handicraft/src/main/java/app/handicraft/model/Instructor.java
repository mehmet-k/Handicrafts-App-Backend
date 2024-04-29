package app.handicraft.model;

import jakarta.persistence.Entity;

@Entity
public class Instructor extends User{

    public Instructor(String userName, String name, String surname, String eMail, String phoneNumber) {
        super(userName, name, surname, eMail, phoneNumber);
    }
}
