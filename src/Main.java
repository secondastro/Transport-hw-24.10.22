public class Main {
    public static void main(String[] args) {
        Car granta = new Car("Lada", null, 0, "жёлтый", 2015, "Россия");
        Car audi = new Car("Audi", "A8 50 L TDI quattro", 3.0, null, 2020, "Германия");
        Car bmw = new Car(null, "Z8", 3.0, "чёрный", 2021, null);
        Car kia = new Car("Kia", "Sportage 4-го поколения", 2.4, "красный", 2018, "Южная Корея");
        Car hyundai = new Car("Hyundai", "Avante", 1.6, "оранжевый", 0, "Южная Корея");

        System.out.println(granta);
        System.out.println(audi);
        System.out.println(bmw);
        System.out.println(kia);
        System.out.println(hyundai);
    }
}