package pages.common.credentialsapi;

import lombok.Builder;
import lombok.extern.jackson.Jacksonized;

@Builder
@Jacksonized
public record Credentials(
        User user,
        Card card
) {
}
