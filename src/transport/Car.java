package transport;

import java.time.LocalDate;
import java.util.Objects;

public class Car {
    private final String brand;
    private final String model;
    private double engineVolume;
    private String color;
    private final int productionYear;
    private final String productionCountry;
    private String transmission;
    private final String bodyType;
    private String regNumber;
    private final int passCapacity;
    private String tiresType;
    private int month;

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



    public Car(String brand, String model, double engineVolume, String color, int productionYear, String productionCountry, String transmission, String bodyType, String regNumber, int passCapacity, int month, Key key, Insurance insurance) {
        this.brand = Objects.requireNonNullElse(brand, "default");
        this.model = Objects.requireNonNullElse(model, "default");
        this.color = Objects.requireNonNullElse(color, "белый");
        this.productionCountry = Objects.requireNonNullElse(productionCountry, "default");
        if (engineVolume == 0) {
            this.engineVolume = 1.5;
        } else {
            this.engineVolume = engineVolume;
        }
        if (productionYear == 0) {
            this.productionYear = 2000;
        } else {
            this.productionYear = productionYear;
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


    public String getBrand() {
        return brand;
    }


    public String getModel() {
        return model;
    }


    public double getEngineVolume() {
        return engineVolume;
    }

    public void setEngineVolume(double engineVolume) {
        if (engineVolume != 0.0) {
            this.engineVolume = engineVolume;
        }
    }

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        if (color != null) {
            this.color = color;
        }
    }

    public int getProductionYear() {
        return productionYear;
    }


    public String getProductionCountry() {
        return productionCountry;
    }

    public String getBodyType() {
        return bodyType;
    }

    public int getPassCapacity() {
        return passCapacity;
    }


    @Override
    public String toString() {
        return "Автомобиль: " + '\n' +
                "Марка: " + brand +
                ", Модель: " + model +
                ", Объем двигателя(в литрах): " + engineVolume +
                ", цвет: " + color +
                ", год производства: " + productionYear +
                ", страна: " + productionCountry+
                ", коробка передач: " + transmission+
                ", тип кузова: " + bodyType +
                ", регистрационный номер: "  + regNumber +
                ", вместимость: " + passCapacity +
                ", тип шин: " + tiresType;

    }

}
