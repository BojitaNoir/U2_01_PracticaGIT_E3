package mx.edu.utez.servidor.autos;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/autos")
@CrossOrigin(origins = {"*"})
public class AutosController {
    private final AutosService autosService;

    public AutosController(AutosService autosService) {
        this.autosService = autosService;
    }

    @GetMapping("/")
    public ResponseEntity<?> getAll() {
        return autosService.getAll();
    }

    @GetMapping("/create")
    public ResponseEntity<?> create(Long id) {
        return autosService.create(id);
    }
    @GetMapping("/delete")
    public ResponseEntity<?> delete(Long id) {
        return autosService.delete(id);
    }
    @GetMapping("/update")
    public ResponseEntity<?> update(Long id, Autos autos) {
        return autosService.update(id, autos);
    }
    @GetMapping("/get")
    public ResponseEntity<?> get(Long id) {
        return autosService.getbyId(id);
    }


}
