package mx.edu.utez.servidor.autos;

import lombok.extern.slf4j.Slf4j;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import static java.lang.System.out;

@Slf4j
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

    @PostMapping("/")
    public ResponseEntity<?> create(@RequestBody AutosDto autosDto) {
        return autosService.create(autosDto);
    }

    @DeleteMapping("/")
    public ResponseEntity<?> delete(@RequestBody AutosDto autosDto) {
        return autosService.delete(autosDto.getId());
    }
    @PutMapping("/")
    public ResponseEntity<?> update(@RequestBody AutosDto autosDto) {
        return autosService.update(autosDto);
    }

    @GetMapping("/{id}")
    public ResponseEntity<?> getbyId(@PathVariable Long id) {
        return autosService.getbyId(id);
    }


}
