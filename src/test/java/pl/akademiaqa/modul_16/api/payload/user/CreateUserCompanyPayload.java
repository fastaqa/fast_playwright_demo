package pl.akademiaqa.modul_16.api.payload.user;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@AllArgsConstructor
@Data
@Builder
public class CreateUserCompanyPayload {

    private String name;
    private String catchPhrase;
    private String bs;

    public static CreateUserCompanyPayload createDefaultUserCompanyPayload() {
        return CreateUserCompanyPayload.builder()
                .name("Romaguera-Crona")
                .catchPhrase("Multi-layered client-server neural-net")
                .bs("harness real-time e-markets")
                .build();
    }
}
