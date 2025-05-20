package mx.edu.utez.servidor.autos;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class AutosDto {
    private Long id;
    private String marca;
    private String modelo;
    private String placas;
    private String provedor;
}
