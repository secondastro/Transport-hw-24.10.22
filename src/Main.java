import transport.Bus;
import transport.Car;
import transport.Train;

import java.time.LocalDate;

public class Main {
    public static void main(String[] args) {
        Car granta = new Car("Lada", null, 0, "жёлтый", 2015, "Россия", "механическая", "седан", "М442НУ159", 5, LocalDate.now().getMonthValue(), new Car.Key(false,false), new Car.Insurance(LocalDate.now().plusMonths(3),5200.5f,"123456789"), 175);
        Car audi = new Car("Audi", "A8 50 L TDI quattro", 3.0, null, 2020, "Германия", "автоматическая", "хэтчбэк", null, 4, LocalDate.now().getMonthValue(), new Car.Key(false, false), new Car.Insurance(LocalDate.now().plusMonths(1), 5200.5f, "974561239"),220);
        Car bmw = new Car(null, "Z8", 3.0, "чёрный", 2021, null, "автоматическая", "лифтбэк", null, 4, LocalDate.now().getMonthValue(), new Car.Key(false, false), new Car.Insurance(LocalDate.now().plusMonths(3), 5200.5f, "125477889"),250);
        Car kia = new Car("Kia", "Sportage 4-го поколения", 2.4, "красный", 2018, "Южная Корея", "автоматическая", "хэтчбэк", null, 0, LocalDate.now().getMonthValue(), new Car.Key(false, false), new Car.Insurance(LocalDate.now().plusMonths(3), 5200.5f, "254455888"),240);
        Car hyundai = new Car("Hyundai", "Avante", 1.6, "оранжевый", 0, "Южная Корея", "автоматическая", "седан", null, 4, LocalDate.now().getMonthValue(), new Car.Key(false, false), new Car.Insurance(LocalDate.now().plusMonths(3), 5200.5f, "66666666"),190);

        granta.refill("бензином на заправке");
        audi.refill("бензином на заправке");
        bmw.refill("бензином на заправке");
        kia.refill("на электропарковке");
        hyundai.refill("бензином на заправке");

        System.out.println(granta);
        System.out.println(audi);
        System.out.println(bmw);
        System.out.println(kia);
        System.out.println(hyundai);

        Train lastochka = new Train("Ласточка",
                "B-901",
                2011,
                "Россия",
                null,
                301,
                3500,
                null,
                "Белорусский вокзал",
                "Минск-Пасс",
                11);
        lastochka.refill("дизелем");
        Train leningrad = new Train("Ленинград",
                "D-125",
                2019,
                "Россия",
                null,
                270,
                1700,
                null,
                "Ленинградский вокзал",
                "Ленинград-Пасс",
                8);
        leningrad.refill("дизелем");
        System.out.println(lastochka);
        System.out.println(leningrad);
        Bus mercedes = new Bus("Mercedes",
                "Sprinter",
                2015,
                "Германия",
                "белый",
                190);
        Bus paz = new Bus("ПАЗ",
                "001",
                1986,
                "СССР",
                "коричневый",
                135);
        Bus fiat = new Bus("Fiat",
                "Buss",
                2002,
                "Франция",
                "бордовый",
                156);

        mercedes.refill("дизелем на заправке");
        paz.refill("бензином на заправке");
        fiat.refill("бензином на заправке");
        System.out.println(mercedes);
        System.out.println(paz);
        System.out.println(fiat);
    }
}