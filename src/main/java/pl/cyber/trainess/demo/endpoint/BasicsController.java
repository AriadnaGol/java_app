package pl.cyber.trainess.demo.endpoint;

import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import pl.cyber.trainess.demo.dto.IntegerListRequest;
import pl.cyber.trainess.demo.dto.IntegerRequest;
import pl.cyber.trainess.demo.dto.OneStringRequest;
import pl.cyber.trainess.demo.dto.RownanieKwRequest;
import pl.cyber.trainess.demo.dto.StringRequest;
import pl.cyber.trainess.demo.service.BasicsService;
import pl.cyber.trainess.demo.service.KalkulatorService;
import pl.cyber.trainess.demo.service.ZnajdzService;

import java.util.List;

/**
 * @author Mariusz Tański
 */

@RestController
@RequestMapping("/v1/basics")
@RequiredArgsConstructor
public class BasicsController {

  private final KalkulatorService kalkulatorService;
  private final BasicsService basicsService;
  private final ZnajdzService znajdzService;


  //region Zadanie1
  /*
  Zadanie 1
  Napisać zapytania dla prostego kalkulatora, który będzie obsługiwać 5 operacji
  (każda z nich powinna być oddzielnym zapytaniem restowym)
  Operacje:
  - dodawanie
  - odejmowanie
  - mnożenie
  - dzielenie
  - obliczenie reszty z dzielenia liczb
  Zwrócenie wyniku naszych operacji.

  Np
  "/dodawanie/{a}"

  @PathVariable
   */

  @GetMapping("/dodawanie/{a}/{b}")
  public Integer getDodawanie(
      @PathVariable("a") final Integer liczbaA,
      @PathVariable("b") final Integer liczbaB
  ) {
    return kalkulatorService.getDodawanie(liczbaA, liczbaB);
  }

  @GetMapping("/dodawanieParams")
  public Integer getDodawanieParams(
      @RequestParam("a") final Integer liczbaA,
      @RequestParam("b") final Integer liczbaB
  ) {
    return kalkulatorService.getDodawanie(liczbaA, liczbaB);
  }

  @GetMapping("/odejmowanie/{a}/{b}")
  public Integer getOdejmowanie(
      @PathVariable("a") final Integer liczbaA,
      @PathVariable("b") final Integer liczbaB
  ) {
    return kalkulatorService.getOdejmowanie(liczbaA, liczbaB);
  }

  @GetMapping("/mnozenie/{a}/{b}")
  public Integer getMnozenie(
      @PathVariable("a") final Integer liczbaA,
      @PathVariable("b") final Integer liczbaB
  ) {
    return kalkulatorService.getMnozenie(liczbaA, liczbaB);
  }

  @GetMapping("/dzielenie/{a}/{b}")
  public Integer getDzielenie(
      @PathVariable("a") final Integer liczbaA,
      @PathVariable("b") final Integer liczbaB
  ) {
    return kalkulatorService.getDzielenie(liczbaA, liczbaB);
  }

  @GetMapping("/reszta/{a}/{b}")
//  @PostMapping
//  @PutMapping
//  @DeleteMapping
  public Integer getReszta(
      @PathVariable("a") final Integer liczbaA,
      @PathVariable("b") final Integer liczbaB
  ) {
    return kalkulatorService.getReszta(liczbaA, liczbaB);
  }

  //endregion

  //region Zadanie2
  /*
  Napisz zapytanie restowe (końcówka/ końcówka REST/ endpoint ...), którego zadaniem będzie wykonanie sprawdzenia
  czy przekazana liczba jest liczbą pierwszą.

  Instrukcji warunkowej sprawdzenia czy liczba < 2
  Pętla która będzie sprawdzała poszczególne dzielniki i jeżeli który kolwiek 'modulo'
   zwrócić 0 to nie jest to liczba pierwsza

   liczba != 0
   liczba != 1

   liczba%i == 0 >>> nasza liczba nie jest pierwsza

a = 121

for(int i=2; i<=a/2; i++)

for(int i=2; i<a; i++)
for(int i=2; i*i<a; i++)

i = 2 i<=60
  */

  @GetMapping("/liczba-pierwsza/{a}")
  public String czyLiczbaPierwsza(
      @PathVariable("a") final Integer liczbaA
  ) {
    return kalkulatorService.czyLiczbaPierwsza(liczbaA);
  }
//endregion

  //region Zadanie3
/*
Napisz zapytanie restowe, którego zadaniem będzie wykonanie sklejenia dwóch
Stringów (przekazanych jako RequestBody) a następnie zwróci wynik.
POST/PUT
*/

  @PostMapping("/sklejenie-stringow")
  public String getSklejenie(
      @RequestBody final StringRequest request
  ) {
    return basicsService.getSklejenie(request);
  }
//endregion

  //    region Zadanie4
/*Napisz zapytanie restowe, którego zadaniem będzie przyjęcie napisu  jako zdania
(przekazanych jako RequestBody)
 Program powinien policzyć ilość wystąpień poszczególnych liter zdania i zwrócić
 odpowiednio przygotowane dane.
Uwaga należy pominąć litery, których w zdaniu nie ma oraz wszystkie znaki puste.

Przykład.
Ala ma kota

a - 4
k - 1
l - 1
m - 1
o - 1
t - 1
*/
  /*
@POSTMapping
@RequestBody

List<LiteryDTO> wystapienia
Set<String> litery
List<String> wynik

pętla for przejście po każdym znaku zdania
if jeśli znak ze zdania jest literą to należy wykonać dodawanie lub akutalizację naszej listy

Object String posiada metodę matches(//reqexp//)  .matches("[a-zA-Z]+")

Object List posiada metodę sort(//Comparator//)   wynik.sort(String::compareTo)
   */

    @PostMapping("/zliczanie")
    public List<String> getWystapieniaLiterWZadaniu(
        @RequestBody final OneStringRequest request
    ) {
//      return basicsService.getWystapieniaLiterWZadaniu(request);
      return basicsService.getWystapieniaLiterWZdaniuMap(request);
    }

//endregion

  //region Zadanie5
/*
Napisz zapytanie restowe, którego zadaniem będzie przekazanie liczb a i b (całkowite),
następnie wykona sprawdzenie czy liczba a jest dzielnikiem liczby b i zwróci
informację true lub false
*/

  @GetMapping("/czy-jest-dzielnikiem/{a}/{b}")
  public boolean getCzyJestDzielnikiem(
      @PathVariable("a") final Integer a,
      @PathVariable("b") final Integer b
  ) {
    return kalkulatorService.getCzyJestDzielnikiem(a, b);
  }

  //endregion

  //  region Zadanie6
/*
Napisz program, który wygeneruje liczbę Random z przedziału od 10 - 1000.
Naszym zadaniem będzie odnalezienie wygenerowanej liczby.
W tym celu należy utworzyć zapytanie restowe, które będzie przyjmowało liczbę
i porównywało ją z wygenerowaną przez system.
Jeśli wprowadzona liczba będzie tą wygenerowaną zostanie zwrócony napis "Udało się!!"
Jeśli wprowadzona liczba będzie mniejsza od wygenerowanej zostanie zwrócony napis
"Wygenerowana liczba jest większa"
Jeśli wprowadzona liczba będzie większa od wygenerowanej zostanie zwrócony napis
"Wygenerowana liczba jest mniejsza"

Uwaga aby generowana liczba powinna być parametrem klasy aby przy każdym zapytaniu
restowym nie doszło do jej modyfikacji.
*/

  @GetMapping("/znajdz/{a}")
  public String znajdzLiczbe(
      @PathVariable("a") final Integer liczba
  ) {
    return znajdzService.znajdzLiczbe(liczba);
  }
  //endregion

  //region Zadanie7
  /*
  Napisz program, w którym zostaną przekazane liczby a i b (całkowite) następnie
  zostaną zsumowane wszystkie liczby pomiędzy od a do b
  (jako przedział zamknięty dwustronnie).
  Przykład podajemy: 1 do 10 czego wynikiem będzie 55
  */

  //GET PathVarialbe lub RequestParam w zależności jak pasuje
  //besicsService

  @GetMapping("/suma-liczb")
  public String sumaLiczbPomiedzy(
      @RequestParam("a") final Integer a,
      @RequestParam("b") final Integer b
  ) {
    return basicsService.sumaLiczbPomiedzy(a, b);
  }

  //endregion

  //region Zadanie8
  /*Napisz program, w krótym przekażemy listę elementów liczb całkowitych program
  powinien zwrócić listę elementów z wartościami ujemnymi oraz sumę liczb,
  które są dodatnie.
  Np. [1, 2, 3, 4, 5, -3, -2, -1]
  wynik:
  [-3, -2, -1] oraz suma liczb dodatnich wynosi: 15
  */

  //besicsService
  //POST RequsetBody
  //IntegerListRequest >>> List<Integer>
//  {
//   "lista": [1, 2, 3, 4, 5, 6, 7, 8]
//  }

  /*
  if do sprawdzenia czy liczba z listy jest ujemna czy dodatnia


  listaUjemnne + " opis " + sumInt
   */

  @PostMapping("/liczby")
  public String zadanie8(
      @RequestBody final IntegerListRequest request
  ) {
    return basicsService.zadanie8(request);
  }

  //endregion

  //region zadanie9
    /*
    Napisz zapytanie restowe, którego zadaniem będzie obliczał pierwiastek
    równania kwadratowego ax2 + bx + c = 0.
    (Do wykorzystania instrukcja if). Pamiętać należy, że zmienne a, b i c to
    liczby rzeczywiste.
    Zadanie powinno zwrócić Napis:
    a) To nie jest równanie kwadratowe
    b) Brak pierwiastków
    c) Jeden pierwiastek. Wynik: xxxx
    d) Dwa pierwiastki. Wynik -> x1: xxxx, x2: xxxx

    delta = b*b-4*a*c;

    Jeśli delta == 0
    x1 = -b/(2*a);

    Jeśli delta > 0
    x1 = (-b-Math.sqrt(delta))/(2*a);
    x2 = (-b+Math.sqrt(delta))/(2*a);

    Jeśli delta < 0
    Brak pierwiastków
     */

  //KalkulatorService
  /*
  można użyć jednej z 3 opcji:
  //GET PathVarialbe
  //GET RequestParam
  //POST RequsetBody    (z własnym obiektem DTO)
   */

  @GetMapping("/rownanie-kwadratowe/{a}/{b}/{c}")
  public String rownanieKwadratowe(
      @PathVariable("a") final Integer a,
      @PathVariable("b") final Integer b,
      @PathVariable("c") final Integer c
  ) {
    return kalkulatorService.rownanieKwadratowe(a, b, c);
  }
// 1, 2, 1
// 1, 1, -2
// 1, 1, 1


  @PostMapping("/rownanie-kwadratowe-b")
  public String rownanieKwadratowe(
      @RequestBody final RownanieKwRequest request
  ) {
    return kalkulatorService.rownanieKwadratowe(request);
  }

  @PostMapping("/rownanie-kwadratowe-b-2miejsca")
  public String rownanieKwadratowe2miejsca(
      @RequestBody final RownanieKwRequest request
  ) {
    return kalkulatorService.rownanieKwadratowe2miejsca(request);
  }

  //endregion

  //region Zadanie10
  /*
  * Za pomocą instrukcji pętli for dla danych wartości x zmieniających się od 0 do 10 obliczymy wartość funkcji y = 3x
  * */

  @GetMapping("/zadanie10a")
  public String zadanie10a() {
    return kalkulatorService.zadanie10a();
  }

  //endregion

  //region zadanie10b
  /*
   * Za pomocą instrukcji pętli do ... while dla danych wartości x zmieniających się od 0 do 10
   *  obliczymy wartość funkcji y = 3x
   * */

  @GetMapping("/zadanie10b")
  public String zadanie10b() {
    return kalkulatorService.zadanie10b();
  }
  //

  //region zadanie10c
  /*
   * Za pomocą instrukcji pętli while dla danych wartości x zmieniających się od 0 do 10
   *  obliczymy wartość funkcji y = 3x
   * */

  @GetMapping("/zadanie10c")
  public String zadanie10c() {
    return kalkulatorService.zadanie10c();
  }

  //endregion

  //region Zadanie11a
  /*
    Napisać program, który przy pomocy pętli for przekaże nam wyniki tabliczki mnożenia od 1 do 100
    Potrzebujemy 2 pętle for
    Parametr 1 - 10;
   */

/*
Program wyświetla tabliczkę mnożenia dla liczb od 1 do 100.
1   2 	3 	4	  5	  6	  7	  8	  9	  10
2	  4 	6 	8	  10	12	14	16	18	20
3	  6 	9 	12	15	18	21	24	27	30
4	  8 	12	16	20	24	28	32	36	40
5	  10	15	20	25	30	35	40	45	50
6	  12	18	24	30	36	42	48	54	60
7	  14	21	28	35	42	49	56	63	70
8	  16	24	32	40	48	56	64	72	80
9	  18	27	36	45	54	63	72	81	90
10	20	30	40	50	60	70	80	90	100
*/

  /*
  for(i){ //wiersze
    for(j) { //kolumny
      //obliczenie mnożenia oraz tab
    }
    new line
  }
   */

  @GetMapping("/zadanie11a")
  public String zadanie11a() {
    return kalkulatorService.zadanie11a();
  }

  //endregion

  //region Zadanie11a
  /*
    Napisać program, który przy pomocy pętli do ... while przekaże nam wyniki tabliczki mnożenia od 1 do 100

    2 pętle do while

    do {
      //ustawienie wartości parametru dla kolumny
      do {
        // mnozenie
        // inkrementacja dla kolumny
      } while()

      // new line
      // inkrementację dla wierszy

    } while()
   */

  @GetMapping("/zadanie11b")
  public String zadanie11b() {
    return kalkulatorService.zadanie11b();
  }

  //endregion
//region Zadanie11c
  /*
    Napisać program, który przy pomocy pętli while przekaże nam wyniki tabliczki mnożenia od 1 do 100

    2 pętle while

  while () { //wiersze
  //pierwotne ustawienie parametru dla kolumny
    while() { // kolumny
    //mnozenie
    //inkrementacja klumny
    }
  //new line
  //inkrementacja dla wierszy
  }
*/

  @GetMapping("/zadanie11c")
  public String zadanie11c() {
    return kalkulatorService.zadanie11c();
  }

  //endregion







  //region ZADANIE DOMOWE
  /*
zadanie
  Proszę zadanie 10 (a, b, c) przerobić tak, aby można było z zewnątrz podać parametr x oraz parametr do kiedy nasza
   pętla ma się wykonywać
  Proszę aby nie wzorować się na dostępnych metodach.


Zadania dla chętnych:
1)
Napisz program, który oblicza wartość x z równania ax+b = c. Wartości a, b i c
należy podać poprzez PathVariable,
 RequestParam lub RequestBody.
Należy zabezpieczyć program na wypadek sytuacji, kiedy wprowadzona wartość 'a'
będzie równa zero. Dla zmiennych
 a, b, c oraz x należy
przyjąć format wyświetlania ich na ekranie z dokładnością do dwóch miejsc
po przecinku

new DecimalFormat("#,##0.00")

2)
Napisz program, który za pomocą instrukcji (for, do ... while oraz while, tzn trzy różne
rozwiązania)
znajduje największą i najmniejszą liczbę ze zbioru 'n' wylosowanych liczb całkowitych
 od 0 do 100
oraz oblicza średnią ze wszystkich wylosowanych liczb
  */
  //endregion

  @PostMapping("/zadanie10d")
  public String zadanie10d(@RequestBody IntegerRequest request) {
    return kalkulatorService.zadanie10d(request);
  }

  @PostMapping("/zadanie10e")
  public String zadanie10e(@RequestBody IntegerRequest request) {
    return kalkulatorService.zadanie10e(request);
  }

  @PostMapping("/zadanie10f")
  public String zadanie10f(@RequestBody IntegerRequest request) {
    return kalkulatorService.zadanie10f(request);
  }

  @PostMapping("zadanie12for")
  public String zadanie12for(@RequestBody IntegerRequest request) {
    return kalkulatorService.zadanie12for(request);
  }
}
