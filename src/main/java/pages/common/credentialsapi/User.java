package pages.common.credentialsapi;

import lombok.Builder;
import lombok.extern.jackson.Jacksonized;

@Builder
@Jacksonized
public record User(
        String gender,
        String name,
        String email,
        String password,
        String dayOfBirth,
        String monthOfBirth,
        String yearOfBirth,
        boolean newsletter,
        boolean specialOffers,
        String firstName,
        String lastName,
        String company,
        String address,
        String country,
        String state,
        String city,
        String zipcode,
        String mobileNumber
) {
}
