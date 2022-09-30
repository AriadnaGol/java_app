package pl.cyber.trainess.demo.endpoint;

import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RequestPart;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;
import pl.cyber.trainess.demo.dto.BankomatDTO;
import pl.cyber.trainess.demo.service.BankomatService;

import java.util.List;

/**
 * @author Mariusz Tański
 */

@RestController
@RequiredArgsConstructor
@RequestMapping("/v1/atms")
public class BankomatController {

  private final BankomatService bankomatService;

  @GetMapping
  public List<BankomatDTO> getAllAtms(){
    return bankomatService.getAllAtms();
  }

  @PutMapping
  public void create(@RequestBody final BankomatDTO bankomatDTO) {
    bankomatService.create(bankomatDTO);
  }

  @PostMapping("/name")
  public void updateName(
      @RequestParam("name") final String name,
      @RequestParam("id") final String id) {
    bankomatService.updateName(id, name);
  }

  //MultipartFile
  @PostMapping("/import-csv")
  public void createFromCSV(
      @RequestPart() MultipartFile file
  ) {
    bankomatService.create(file);
  }
}
