package models;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class FailedLoginData {
    private String email;
    private String password;
}