package pl.cyber.trainess.demo.domain;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.hibernate.annotations.GenericGenerator;
import pl.cyber.trainess.demo.dto.BankomatDTO;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import java.math.BigDecimal;

/**
 * @author Mariusz Tański
 */

@Getter
@Builder
@AllArgsConstructor
@NoArgsConstructor
@Entity(name = "BANKOMAT")
public class BankomatEntry {

  @Id
  @GeneratedValue(generator = "UUID") //5e4bb5c2-21d1-4732-b5ab-1328236ddbe8
  @GenericGenerator(name = "UUID", strategy = "org.hibernate.id.UUIDGenerator")
  @Column(name = "ID", updatable = false, nullable = false)
  private String id;

  @Setter
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
