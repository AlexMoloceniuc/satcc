package ro.jlg.academy.satcc.interfaces;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import ro.jlg.academy.satcc.application.CompanyService;
import ro.jlg.academy.satcc.domain.Company;
import ro.jlg.academy.satcc.interfaces.dto.CreateUpdateCompanyDTO;

import java.util.List;

@RestController
public class CompanyRestController {
    private CompanyService companyService;

    public CompanyRestController(CompanyService companyService) {
        this.companyService = companyService;
    }

    @PostMapping("/companies")
    public ResponseEntity<Void> create(final @RequestBody CreateUpdateCompanyDTO dto){

        this.companyService.create(dto);
        return ResponseEntity.ok().build();
    }

    @GetMapping("/companies")
    public ResponseEntity<List<Company>> getAll(){
        return ResponseEntity.ok(this.companyService.getAll());
    }

    @PatchMapping("/companies/{companyId}")
    public ResponseEntity<Void> update(final @PathVariable String companyId, final @RequestBody CreateUpdateCompanyDTO dto) {
        this.companyService.update(companyId, dto);

        return ResponseEntity.ok().build();
    }

    @DeleteMapping("/companies/{id}")
    public ResponseEntity<Void> delete(final @PathVariable String id) {
        this.companyService.delete(id);
        return ResponseEntity.ok().build();
    }

}
