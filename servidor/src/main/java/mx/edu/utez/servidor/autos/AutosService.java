package mx.edu.utez.servidor.autos;

import jakarta.transaction.Transactional;
import mx.edu.utez.servidor.ApiResponse;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import mx.edu.utez.servidor.autos.AutosRepository;

@Service
@Transactional

public class AutosService {
    private final AutosRepository autosRepository;


    public AutosService(AutosRepository autosRepository) {
        this.autosRepository = autosRepository;
    }
    public ResponseEntity<ApiResponse> getAll() {
        return ResponseEntity.ok(new ApiResponse(autosRepository.findAll(), "OK"));
    }
    public ResponseEntity<ApiResponse> create (Long id) {
        Autos autos = new Autos();
        autos.setId(id);
        autosRepository.save(autos);
        return ResponseEntity.ok(new ApiResponse(autos, "OK"));
    }
    public ResponseEntity<ApiResponse> delete(Long id) {
        autosRepository.deleteById(id);
        return ResponseEntity.ok(new ApiResponse(null,"OK"));
    }
    public ResponseEntity<ApiResponse> update(Long id, Autos autos) {
        Autos existingAutos = autosRepository.findById(id).orElse(null);
        if (existingAutos == null) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(new ApiResponse(null, "Autos not found"));
        }
        existingAutos.setMarca(autos.getMarca());
        existingAutos.setModelo(autos.getModelo());
        existingAutos.setPlacas(autos.getPlacas());
        existingAutos.setProveedor(autos.getProveedor());
        autosRepository.save(existingAutos);
        return ResponseEntity.ok(new ApiResponse(existingAutos, "OK"));
    }
    public ResponseEntity<ApiResponse> getbyId(Long id) {
        Autos autos = autosRepository.findById(id).orElse(null);
        if (autos == null) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(new ApiResponse(null, "Autos not found"));
        }
        return ResponseEntity.ok(new ApiResponse(autos, "OK"));
    }


}
