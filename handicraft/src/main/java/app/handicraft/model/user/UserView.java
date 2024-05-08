package app.handicraft.model.user;

import java.util.UUID;

public record UserView(UUID id, String userName, String name, String surname, String eMail, String phoneNumber,
                       String address) {
}
