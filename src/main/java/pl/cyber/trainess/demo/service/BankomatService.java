package pl.cyber.trainess.demo.service;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import pl.cyber.trainess.demo.domain.BankomatEntry;
import pl.cyber.trainess.demo.dto.BankomatDTO;
import pl.cyber.trainess.demo.repository.BankomatRepository;

import java.util.ArrayList;
import java.util.List;

@RequiredArgsConstructor
@Service
@Slf4j
public class BankomatService {
    private final BankomatRepository bankomatRepository;

    public List<BankomatDTO> getAllAtms() {
        log.info("wyszukanie wszystkich bankomatow");
        log.warn("cos poszlo nie tak");
        log.error("rest communication failed");

        var allAtms = bankomatRepository.findAll();
        List<BankomatDTO> result = new ArrayList<>();

        for (BankomatEntry bankomatEntry : allAtms) {
            result.add(bankomatEntry.convertToDTO());
        }

        return result;
    }

    public void create(final BankomatDTO bankomatDTO) {
        bankomatRepository.save(BankomatEntry.builder()
                        .miasto(bankomatDTO.getMiasto())
                        .name(bankomatDTO.getName())
                        .saldo(bankomatDTO.getSaldo())
                        .ulica(bankomatDTO.getUlica())
                        .czyAktywny(bankomatDTO.getCzyAktywny())
                .build());
    }
}
