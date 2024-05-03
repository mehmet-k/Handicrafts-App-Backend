package app.handicraft.model.relation;

import app.handicraft.model.user.User;

public class InstructorProvides extends User {
    public InstructorProvides(String userName, String name, String surname, String eMail, String phoneNumber, String address) {
        super(userName, name, surname, eMail, phoneNumber, address);
    }
}
