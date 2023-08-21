package pl.akademiaqa.modul_16.api.payload.user;

import com.google.gson.annotations.SerializedName;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@AllArgsConstructor
@Data
@Builder
public class CreateUserPayload {

    private String name;
    @SerializedName("username")
    private String userName;
    private String email;

    private CreateUserAddressPayload address;
    private String phone;
    private String website;
    private CreateUserCompanyPayload company;

    public static CreateUserPayload createDefaultPayload() {
        return CreateUserPayload.builder()
                .name("Json Dto")
                .userName("json.dto")
                .email("default@email.com")
                .address(CreateUserAddressPayload.createDefaultUserAddressPayload())
                .phone("1-770-736-8031 x56442")
                .website("hildegard.org")
                .company(CreateUserCompanyPayload.createDefaultUserCompanyPayload())
                .build();
    }
}
