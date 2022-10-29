package transport;

public class Bus extends Transport {

    public Bus(String brand,
               String model,
               int productionYear,
               String productionCountry,
               String color,
               int maxSpeed) {
        super(brand, model, productionYear, productionCountry, color, maxSpeed);
    }

    @Override
    public void refill(String fuel) {
        boolean b = fuel.contains("бензин") || fuel.contains("дизел");
        if (b == false) {
            throw new RuntimeException("Ошибка! Некорректно указан способ заправки");
        } else {
            setFuel(fuel);
        }
    }

    public String toString () {
        return getBrand() + " " + getModel() + ":" + '\n' +
                "Цвет: " + getColor() +
                ", Год производства: " + getProductionYear() +
                ", Страна: " + getProductionCountry()
                + ", Максимальная скорость: " + getMaxSpeed() +
                ", Заправлять: " + getFuel();
    }
    }


