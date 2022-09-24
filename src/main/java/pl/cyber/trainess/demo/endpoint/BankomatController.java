package pl.cyber.trainess.demo.endpoint;

import lombok.AllArgsConstructor;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;
import pl.cyber.trainess.demo.dto.BankomatDTO;
import pl.cyber.trainess.demo.service.BankomatService;

import java.util.List;

@RestController
//@RequiredArgsConstructor
@AllArgsConstructor
@RequestMapping("/v1/atms")
public class BankomatController {
    private final BankomatService bankomatService;

    @GetMapping
    public List<BankomatDTO> getAllAtms() {
        return bankomatService.getAllAtms();
    }

    @PutMapping
    public void createAtm(@RequestBody final BankomatDTO bankomatDTO) {
        bankomatService.create(bankomatDTO);
    }
}
