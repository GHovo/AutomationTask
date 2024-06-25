package pages.common.credentialsapi;

import lombok.Builder;
import lombok.extern.jackson.Jacksonized;

@Builder
@Jacksonized
public record Card(
        String name,
        String number,
        String cvc,
        String expiryMonth,
        String expiryYear
) {
}
