package transport;

import java.time.LocalDate;
import java.util.Objects;

public class Car extends Transport {

    private double engineVolume;

    private String transmission;
    private final String bodyType;
    private String regNumber;
    private final int passCapacity;
    private String tiresType;
    private int month;

    @Override
    public void refill(String fuel) {
        boolean b = (fuel.contains("бензин") || fuel.contains("дизел") || fuel.contains("электро"));
        if (b==false) {
            throw new RuntimeException("Ошибка, некорректно указан способ заправки");
        } else {
            setFuel(fuel);
        }

    }

    public static class Key {
        private final boolean remoteEngineStart;
        private final boolean keyLessAccess;

        public Key(boolean remoteEngineStart, boolean keyLessAccess) {
            this.remoteEngineStart = remoteEngineStart;
            this.keyLessAccess = keyLessAccess;
        }
        public boolean isRemoteEngineStart(){
            return remoteEngineStart;
        }
        public boolean isKeyLessAccess() {
            return keyLessAccess;
        }
    }
    public static class Insurance {
        private final LocalDate insuranceEnd;
        private final float cost;
        private final String number;

        public Insurance(LocalDate insuranceEnd, float cost, String number) {
            this.insuranceEnd = Objects.requireNonNullElseGet(insuranceEnd, () -> LocalDate.now().plusDays(30));
            if (cost == 0) {
                this.cost = 1f;
            } else {
                this.cost = cost;
            }
            if (number == null || number.isBlank()) {
                this.number = "default";
            } else {
                this.number = number;
            }

        }

        public LocalDate getInsuranceEnd() {
            return insuranceEnd;
        }

        public float getCost() {
            return cost;
        }

        public String getNumber() {
            return number;
        }

        public boolean isValidDateOfEnd() {
            return LocalDate.now().isAfter(this.insuranceEnd);
        }

        public boolean isValidNumber() {
            return number.length() != 9;
        }
    }



    public Car(String brand, String model, double engineVolume, String color, int productionYear, String productionCountry, String transmission, String bodyType, String regNumber, int passCapacity, int month, Key key, Insurance insurance, int maxSpeed) {
        super(brand, model, productionYear, productionCountry, color, maxSpeed);
        if (engineVolume == 0) {
            this.engineVolume = 1.5;
        } else {
            this.engineVolume = engineVolume;
        }
        this.transmission = Objects.requireNonNullElse(transmission, "механическая");
        this.bodyType = Objects.requireNonNullElse(bodyType, "седан");
        this.regNumber = Objects.requireNonNullElse(regNumber, "А000АА777");
        if (passCapacity == 0) {
            this.passCapacity = 5;
        } else {
            this.passCapacity = passCapacity;
        }
        setTiresType(month);
    }
    public boolean isValidRegNumber(){
        if (this.regNumber.length() != 9) {
            return false;
        }
        char [] regNumberChar = this.regNumber.toCharArray();
        return isLetter(regNumberChar[0])
                && isNumber(regNumberChar[1])
                && isNumber(regNumberChar[2])
                && isNumber(regNumberChar[3])
                && isLetter(regNumberChar[4])
                && isLetter(regNumberChar[5])
                && isNumber(regNumberChar[6])
                && isNumber(regNumberChar[7])
                && isNumber(regNumberChar[8]);
    }
    public boolean isLetter(char symbol){
        String symbols = "АВЕКМНОРСТУХ";
        return symbols.contains("" + symbol);
    }

    public boolean isNumber(char symbol) {
        return Character.isDigit(symbol);
    }
    private void setTiresType(int month) {
        if (month <= 4 || month >= 11) {
            this.tiresType = "зимние шины";
        } else {
            this.tiresType = "летние шины";
        }
    }



    public double getEngineVolume() {
        return engineVolume;
    }

    public void setEngineVolume(double engineVolume) {
        if (engineVolume != 0.0) {
            this.engineVolume = engineVolume;
        }
    }

    public String getBodyType() {
        return bodyType;
    }

    public int getPassCapacity() {
        return passCapacity;
    }



    @Override
    public String toString() {
        return getBrand() + " " + getModel() + ":"  + '\n' +
                "Цвет: " + getColor() +
                ", Год производства: " + getProductionYear() +
                ", Страна: " + getProductionCountry()+
                ", Объём двигателя: " + engineVolume
              + ", Максимальная скорость: " + getMaxSpeed() +
                ", Коробка передач: " + transmission +
                ", Тип кузова: " + bodyType +
                ", Рег.номер: " + regNumber +
                ", Вместимость: " + passCapacity +
                ", Тип шин: " + tiresType +
                ", Заправлять/заряжать: " + getFuel();
    }
}

