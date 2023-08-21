package pl.akademiaqa.modul_16.api.response.user;

import com.google.gson.annotations.SerializedName;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.ToString;

@Getter
@ToString
@AllArgsConstructor
public class CreateUpdateUserResponse {

    private int id;
    private String name;
    @SerializedName("username")
    private String userName;
    private String email;
    private String website;
}
