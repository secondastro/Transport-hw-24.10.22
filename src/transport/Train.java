package transport;

public class Train extends Transport {

    private int cost;
    private String time;
    private String startStation;
    private String finishStation;
    private int numbersOfWagons;

    public Train(String brand,
                 String model,
                 int productionYear,
                 String productionCountry,
                 String color,
                 int maxSpeed,
                 int cost,
                 String time,
                 String startStation,
                 String finishStation,
                 int numbersOfWagons) {
        super(brand, model, productionYear, productionCountry, color, maxSpeed);
        setCost(cost);
        setFinishStation(finishStation);
        setTime(time);
        setStartStation(startStation);
        setNumbersOfWagons(numbersOfWagons);
    }

    @Override
    public void refill(String fuel) {
        if (!fuel.contains("дизел")) {
            throw new RuntimeException("Ошибка! Некорректно указан способ заправки");
        } else {
            setFuel(fuel);
        }
    }

    public int getCost() {
        return cost;
    }

    public void setCost(int cost) {
        if (cost == 0) {
            this.cost = 1000;
        } else if (cost < 0) {
            this.cost = Math.abs(cost);
        } else {
            this.cost = cost;
        }
    }

    public String getTime() {
        return time;
    }

    public void setTime(String time) {
        if (time==null || time.isEmpty() || time.isBlank()) {
            this.time = "Время в пути не указано";
        } else {
            this.time = time;
        }
    }

    public String getStartStation() {
        return startStation;
    }

    public void setStartStation(String startStation) {
        if (startStation == null || startStation.isEmpty() || startStation.isBlank()) {
            this.startStation = "Не указано";
        } else {
            this.startStation = startStation;
        }
    }

    public String getFinishStation() {
        return finishStation;
    }

    public void setFinishStation(String finishStation) {
        if (finishStation == null || finishStation.isBlank() || finishStation.isEmpty()) {
            this.finishStation = "Не указано";
        } else {
            this.finishStation = finishStation;
        }
    }

    public int getNumbersOfWagons() {
        return numbersOfWagons;
    }

    public void setNumbersOfWagons(int numbersOfWagons) {
        if (numbersOfWagons == 0) {
            this.numbersOfWagons = 12;
        } else {
            this.numbersOfWagons = numbersOfWagons;
        }
    }

    @Override
    public String toString() {
        return "Поезд " + getBrand() + " "
                + getModel() +
                ", Год выпуска " + getProductionYear() + ", "
                + getProductionCountry() + '\n' +
                "Цена билета: " + cost +
                ", макс.скорость: " + getMaxSpeed() +
                ", время в пути: " + time +
                ", станция отправления: " + startStation +
                ", станция прибытия: " + finishStation +
                ", количество вагонов: " + numbersOfWagons +
                ", заправлять: " + getFuel();
    }
}
