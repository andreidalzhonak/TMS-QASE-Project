package models;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class CredentialsModel {
    private String email;
    private String password;
    private String token;
}