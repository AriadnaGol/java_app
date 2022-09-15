package pl.cyber.trainess.demo.service;

import org.springframework.stereotype.Service;
import pl.cyber.trainess.demo.dto.RownanieKwRequest;

import java.text.DecimalFormat;
import java.util.Locale;

/**
 * @author Mariusz Tański
 */

@Service
public class KalkulatorService {
//metoda dodawania

  public Integer getDodawanie(final Integer a, final Integer b) {
    return a+b;
  }

  public Integer getOdejmowanie(final Integer liczbaA, final Integer liczbaB) {
    return liczbaA-liczbaB;
  }

  public Integer getMnozenie(final Integer liczbaA, final Integer liczbaB) {
    return liczbaA*liczbaB;
  }

  public Integer getDzielenie(final Integer liczbaA, final Integer liczbaB) {

//    if(liczbaB!=0) {
//      return liczbaA/liczbaB;
//    } else {
//      throw new RuntimeException("Nie dziel przez 0!!!");
//    }

    if (liczbaB == 0) {
      throw new RuntimeException("Nie dziel przez 0!!!");
    }

    return liczbaA/liczbaB;
  }

  public Integer getReszta(final Integer liczbaA, final Integer liczbaB) {
    if (liczbaB == 0) {
      throw new RuntimeException("Nie dziel przez 0!!!");
    }

    return liczbaA%liczbaB;
  }

  public String czyLiczbaPierwsza(final Integer a) {

     if(a<2) {
       return "To nie jest liczba pierwsza!";
     }

//     for(int i=2; i<=a/2; i++) {
    for(int i=2; i*i<a; i++) {
      System.out.println(i*i);
       if(a%i==0) {
         return  "To nie jest liczba pierwsza!";
       }
     }
     return  "To jest liczba pierwsza!";
  }

  public boolean getCzyJestDzielnikiem(final Integer a, final Integer b) {
    if (b == 0) {
      throw new RuntimeException("Nie wolno dzielić przez 0!!");
    }

//    return a%b == 0;

    return a % b == 0;
  }

  public String rownanieKwadratowe(final Integer a, final Integer b, final Integer c) {

    Double delta = 0.0;
    Double x1 = 0.0;
    Double x2 = 0.0;

    if(a == 0) {
      return "To nie jest równanie kwadratowe";
    }

    delta = Double.valueOf(b*b-4*a*c);

    if (delta < 0) {
      return "Brak pierwiastków";
    } else {
      if (delta == 0) {
        x1 = Double.valueOf(-b/(2*a));
        return "Jeden pierwiastek. Wynik: " + x1;
      } else {
        x1 = (-b-Math.sqrt(delta))/(2*a);
        x2 = (-b+Math.sqrt(delta))/(2*a);
        return "Dwa pierwiasteki. Wynik x1: " + x1 + " x2: " + x2;
      }
    }
  }

  public String rownanieKwadratowe(final RownanieKwRequest request) {

    Double delta = 0.0;
    Double x1 = 0.0;
    Double x2 = 0.0;

    Double a = request.getA();
    Double b = request.getB();
    Double c = request.getC();

    delta = b*b-4*a*c;

    if(delta == 0) {
      x1 = -b/(2*a);
      return "Jeden pierwiastek. Wynik: " + x1;
    } else if(delta < 0) {
      return "Brak pierwiastków.";
    } else {
      x1 = (-b-Math.sqrt(delta))/(2*a);
      x2 = (-b+Math.sqrt(delta))/(2*a);
      return "Dwa pierwiastki. Wynik x1: " + x1 + " x2: " + x2;
    }
  }

  public String rownanieKwadratowe2miejsca(final RownanieKwRequest request) {
    Locale englishLocale = Locale.ENGLISH;
    Locale polishLocale = Locale.forLanguageTag("pl-PL");

    Locale.setDefault(polishLocale);

    DecimalFormat df = new DecimalFormat("#,##0.00");
    /*
    1.10
    #,###.00 >  1,10

    1101.10
    #,###.00 >  1 101,10

    1.10
    #,###.0# >  1,10
    1.1
    #,###.0# >  1,1

    1.1131421125
    #,###.0# >  1,11

    1.1161421125
    #,###.0# >  1,12

    1.1161421125
    #,###.0## >  1,116

    1101.10
    #.# > 1101,1


    1101.1
    #.0000 > 1101,1000
     */

    Double delta = 0.0;
    Double x1 = 0.0;
    Double x2 = 0.0;

    Double a = request.getA();
    Double b = request.getB();
    Double c = request.getC();

    delta = b*b-4*a*c;

    if(delta == 0) {
      x1 = -b/(2*a);
      return "Jeden pierwiastek. Wynik: " + df.format(x1);
    } else if(delta < 0) {
      return "Brak pierwiastków.";
    } else {
      x1 = (-b-Math.sqrt(delta))/(2*a);
      x2 = (-b+Math.sqrt(delta))/(2*a);
      return "Dwa pierwiastki. Wynik x1: " + df.format(x1) + " x2: " + df.format(x2);
    }
  }
}
