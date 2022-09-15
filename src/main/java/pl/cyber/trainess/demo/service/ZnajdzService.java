package pl.cyber.trainess.demo.service;

import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.Objects;
import java.util.Random;

/**
 * @author Mariusz Tański
 */

@Slf4j
@Service
public class ZnajdzService {

  private Integer losowaLiczba = 0;

  public ZnajdzService() {
    //użycie funkcji randomowej
    Random r = new Random();
//  r.nextInt(liczbyMaksymalnej-liczbaMinimalna)+liczbaPrzesunięcia
    this.losowaLiczba = r.nextInt(990) + 10;

    log.info("Wylosowana liczba to: " + this.losowaLiczba.toString());
  }

  public String znajdzLiczbe(final Integer liczba) {
    if (Objects.equals(liczba, losowaLiczba)) {
      return "Udało się!!!!";
    } else if (liczba < losowaLiczba) {
      return "Wygenerowana liczba jest większa";
    } else {
      return "Wygenerowana liczba jest mniejsza";
    }

//    boolean czyZnaleziona = false;
//
//    if (Objects.equals(liczba, losowaLiczba)) {
//      czyZnaleziona = true;
//    } else {
//      czyZnaleziona = false;
//    }
//
//    if (czyZnaleziona) {
//      return "Udało się!!";
//    } else {
//      return "Próbuj dalej";
//    }
  }
}
