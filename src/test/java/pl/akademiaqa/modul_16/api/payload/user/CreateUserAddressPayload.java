package pl.akademiaqa.modul_16.api.payload.user;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@AllArgsConstructor
@Data
@Builder
public class CreateUserAddressPayload {

    private String street;
    private String suite;
    private String city;
    private String zipcode;

    private CreateUserAddressGeoPayload geo;

    public static CreateUserAddressPayload createDefaultUserAddressPayload() {
        return CreateUserAddressPayload.builder()
                .street("Kulas Light")
                .suite("Apt. 556")
                .city("Gwenborough")
                .zipcode("92998-3874")
                .geo(CreateUserAddressGeoPayload.createDefaultUserAddressGeoPayload())
                .build();
    }
}
