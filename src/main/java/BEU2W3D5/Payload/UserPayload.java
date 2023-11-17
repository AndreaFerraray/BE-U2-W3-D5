package BEU2W3D5.Payload;

import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Pattern;
import jakarta.validation.constraints.Size;

public record UserPayload(
        @NotEmpty(message = "Il nome è obbliatorio")
        @Size(message = "Il nome deve avere almeno 3 caratteri",min = 3)
        String nome,


        @NotNull(message = "La password è un campo obbligatorio!")
        String password,
        @NotEmpty(message = "Il cognome è obbligatorio")
        @Size(message = "Il cognome deve avere almeno 3 caratteri",min = 3)
        String cognome,
        @NotEmpty(message = "La mail è obbligatoria")
        @Pattern(regexp = "^[\\w-\\.]+@([\\w-]+\\.)+[\\w-]{2,4}$", message = "L'email inserita non è valida")
        String email
) {}