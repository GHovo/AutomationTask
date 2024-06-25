package dataprovider;

import com.fasterxml.jackson.databind.ObjectMapper;
import pages.common.credentialsapi.Card;
import pages.common.credentialsapi.Credentials;
import pages.common.credentialsapi.User;

import java.io.File;
import java.io.IOException;
import java.util.Optional;
import java.util.logging.Level;
import java.util.logging.Logger;

public class CredentialsDataProvider {
    private static final Logger LOGGER = Logger.getLogger(CredentialsDataProvider.class.getName());

    public Optional<Credentials> getCredentials() {
        ObjectMapper mapper = new ObjectMapper();
        try {
            File file = new File("src/main/resources/properties/credentials.json");
            Credentials credentials = mapper.readValue(file, Credentials.class);
            return Optional.of(credentials);
        } catch (IOException e) {
            LOGGER.log(Level.SEVERE, "Failed to load credentials data from JSON file", e);
            return Optional.empty();
        }
    }

    public Optional<User> getValidUser() {
        return getCredentials().map(Credentials::user);
    }

    public Optional<Card> getValidCard() {
        return getCredentials().map(Credentials::card);
    }

}
