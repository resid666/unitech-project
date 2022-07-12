package az.fintech.unitechms.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class LoginDto {

    @NotBlank
    @Size(min = 7, max = 7)
    private String pin;

    @NotBlank
    private String password;
}
