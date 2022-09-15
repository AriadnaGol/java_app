package pl.cyber.trainess.demo.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

/**
 * @author Mariusz Tański
 */

@Getter
@Setter
@Builder //To jest adnotacja do zbudowania obiektu w oparciu o construktor klasy
/*
new LiteryDTO("a", 1);

LiteryDTO.builder()
.litera("a")
.ilosc(1)
.build()

litra -> a, jej ilosc -> 1
-----------------------------------
new LiteryDTO("a", null);

LiteryDTO.builder()
.litera("a")
.build()

litra -> a, jej ilosc -> null
 */
@AllArgsConstructor  //Adnotacja dzięki której w naszej klasie pojawi się konstruktor
    //ze wszystkimi dostępnymi parametrami
public class LiteryDTO {

  private String litera;
  private Integer ilosc;

}
