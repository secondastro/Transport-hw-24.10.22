import transport.Car;

import java.time.LocalDate;

public class Main {
    public static void main(String[] args) {
        Car granta = new Car("Lada", null, 0, "жёлтый", 2015, "Россия", "механическая", "седан", "М442НУ159", 5, LocalDate.now().getMonthValue(), new Car.Key(false,false), new Car.Insurance(LocalDate.now().plusMonths(3),5200.5f,"123456789"));
        Car audi = new Car("Audi", "A8 50 L TDI quattro", 3.0, null, 2020, "Германия", "автоматическая", "хэтчбэк", null, 4, LocalDate.now().getMonthValue(), new Car.Key(false, false), new Car.Insurance(LocalDate.now().plusMonths(1), 5200.5f, "974561239"));
        Car bmw = new Car(null, "Z8", 3.0, "чёрный", 2021, null, "автоматическая", "лифтбэк", null, 4, LocalDate.now().getMonthValue(), new Car.Key(false, false), new Car.Insurance(LocalDate.now().plusMonths(3), 5200.5f, "125477889"));
        Car kia = new Car("Kia", "Sportage 4-го поколения", 2.4, "красный", 2018, "Южная Корея", "автоматическая", "хэтчбэк", null, 0, LocalDate.now().getMonthValue(), new Car.Key(false, false), new Car.Insurance(LocalDate.now().plusMonths(3), 5200.5f, "254455888"));
        Car hyundai = new Car("Hyundai", "Avante", 1.6, "оранжевый", 0, "Южная Корея", "автоматическая", "седан", null, 4, LocalDate.now().getMonthValue(), new Car.Key(false, false), new Car.Insurance(LocalDate.now().plusMonths(3), 5200.5f, "66666666"));

        System.out.println(granta);
        System.out.println(audi);
        System.out.println(bmw);
        System.out.println(kia);
        System.out.println(hyundai);
        System.out.println(bmw.isValidRegNumber());
    }
}