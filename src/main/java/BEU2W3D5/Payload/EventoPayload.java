package BEU2W3D5.Payload;

import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.Size;

public record EventoPayload(
        @NotEmpty(message = "Il nome è obbligatorio")
        @Size(message = "Il nome deve avere almeno 3 caratteri",min = 3)
        String tipo
) {
    public String getDescrizione() {
        return null;
    }

    public String getLuogo() {
        return null;
    }

    public String getTitolo() {
        return null;
    }

    public int getPosti() {
        return 0;
    }
}
