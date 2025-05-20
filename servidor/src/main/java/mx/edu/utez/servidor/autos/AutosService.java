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
    public ResponseEntity<ApiResponse> create (AutosDto autosDto) {
        Autos autos = new Autos();
        autos.setMarca(autosDto.getMarca());
        autos.setModelo(autosDto.getModelo());
        autos.setPlacas(autosDto.getPlacas());
        autos.setProvedor(autosDto.getProvedor());
        autosRepository.save(autos);
        return ResponseEntity.ok(new ApiResponse(autos, "OK"));
    }
    public ResponseEntity<ApiResponse> delete(Long id) {
        autosRepository.deleteById(id);
        return ResponseEntity.ok(new ApiResponse(null,"OK"));
    }
    public ResponseEntity<ApiResponse> update(AutosDto autosDto) {
        Autos existingAutos = autosRepository.findById(autosDto.getId()).orElse(null);
        if (existingAutos == null) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(new ApiResponse(null, "Autos not found"));
        }
        existingAutos.setMarca(autosDto.getMarca());
        existingAutos.setModelo(autosDto.getModelo());
        existingAutos.setPlacas(autosDto.getPlacas());
        existingAutos.setProvedor(autosDto.getProvedor());
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
