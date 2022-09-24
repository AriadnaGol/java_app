package pl.cyber.trainess.demo.domain;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.GenericGenerator;
import pl.cyber.trainess.demo.dto.BankomatDTO;

import javax.persistence.*;
import java.math.BigDecimal;

@Getter
@Builder
@AllArgsConstructor
@Entity(name = "BANKOMAT")
@NoArgsConstructor
public class BankomatEntry {
    @Id
    @GeneratedValue(generator = "UUID")
    @GenericGenerator(name = "UUID", strategy = "org.hibernate.id.UUIDGenerator")
    @Column(name = "ID", updatable = false, nullable = false)
    private String id;

    @Column(name = "NAME")
    private String name;

    @Column(name = "SALDO")
    private BigDecimal saldo;

    @Column(name = "MIASTO")
    private String miasto;

    @Column(name = "ULICA")
    private String ulica;

    @Column(name = "CZY_AKTYWNY")
    private Boolean czyAktywny;

    public BankomatDTO convertToDTO() {
        return BankomatDTO.builder()
                .id(this.id)
                .name(this.name)
                .saldo(this.saldo)
                .miasto(this.miasto)
                .ulica(this.ulica)
                .czyAktywny(this.czyAktywny)
                .build();
    }
}
