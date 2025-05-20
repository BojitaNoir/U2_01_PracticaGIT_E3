package mx.edu.utez.servidor;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
public class ApiResponse {
    private Object data;
    private String status;
    private boolean error;
    private String message;

    public ApiResponse(Object data, String status) {
        this.data = data;
        this.status = status;
    }

    public ApiResponse(String status, boolean error, String message) {
        this.status = status;
        this.error = error;
        this.message = message;
    }
}
