package pl.akademiaqa.modul_8.dto;

import lombok.Builder;
import lombok.Getter;

@Builder
@Getter
public class ContactUsDTO {

    private String subjectHeading;
    private String emailAddress;
    private String orderReference;
    private String fileToUpload;
    private String message;

    public static ContactUsDTO getDefaultContactUsDTO() {
        return ContactUsDTO.builder()
                .subjectHeading("Webmaster")
                .emailAddress("demo@demo.com")
                .orderReference("123456")
                .fileToUpload("uploads/upload-file.txt")
                .message("This is sampel message")
                .build();
    }
}
