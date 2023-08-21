package pl.akademiaqa.modul_16.api.payload.user;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@AllArgsConstructor
@Data
@Builder
public class CreateUserAddressGeoPayload {

    private String lat;
    private String lng;

    public static CreateUserAddressGeoPayload createDefaultUserAddressGeoPayload() {
        return CreateUserAddressGeoPayload.builder()
                .lat("-37.3159")
                .lng("81.1496")
                .build();
    }
}
