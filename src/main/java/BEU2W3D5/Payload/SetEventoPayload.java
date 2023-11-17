package BEU2W3D5.Payload;

import jakarta.validation.constraints.NotNull;

public record SetEventoPayload(
        String stato,
        String descrizione ,
        String luogo,
        String titolo,
        @NotNull(message = "collega un utente")
        int posti,
        @NotNull(message = "collega un utente")
        int user_id
) {
}
