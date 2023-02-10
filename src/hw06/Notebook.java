package hw06;

public class Notebook {

    // Поля класса
    private String brand;
    private String model;
    private Float displaySize;
    private String displayType;
    private String cpuType;
    private Integer hddSize;
    private Integer ramSize;
    private String bodyType;
    private String bodyColor;
    private Float weight;
    private Integer price;

    // Конструктор класса
    public Notebook(String brand, String model, Float displaySize, String displayType,
                    String cpuType, Integer hddSize, Integer ramSize,
                    String bodyType, String bodyColor, Float weight, Integer price) {
        setBrand(brand);
        setModel(model);
        setDisplaySize(displaySize);
        setDisplayType(displayType);
        setDisplaySize(displaySize);
        setCpuType(cpuType);
        setHddSize(hddSize);
        setRamSize(ramSize);
        setBodyType(bodyType);
        setBodyColor(bodyColor);
        setWeight(weight);
        setPrice(price);
    }

    public Float getDisplaySize() {
        return displaySize;
    }

    public Integer getHddSize() {
        return hddSize;
    }


    public Integer getRamSize() {
        return ramSize;
    }

    public Integer getPrice() {
        return price;
    }

    public void setModel(String model) {
        this.model = model;
    }

    public void setBrand(String brand) {
        this.brand = brand;
    }

    public void setDisplaySize(Float displaySize) {
        this.displaySize = displaySize;
    }

    public void setDisplayType(String displayType) {
        this.displayType = displayType;
    }

    public void setCpuType(String cpuType) {
        this.cpuType = cpuType;
    }

    public void setHddSize(Integer hddSize) {
        this.hddSize = hddSize;
    }

    public void setRamSize(Integer ramSize) {
        this.ramSize = ramSize;
    }

    public void setBodyType(String bodyType) {
        this.bodyType = bodyType;
    }

    public void setBodyColor(String bodyColor) {
        this.bodyColor = bodyColor;
    }

    public void setWeight(Float weight) {
        this.weight = weight;
    }

    public void setPrice(Integer price) {
        this.price = price;
    }

    @Override
    public String toString() {
        return brand + " " + model + " " + displaySize + " " +
                displayType + ", " +
                cpuType + ", " +
                hddSize + "Gb SSD, " +
                "ОЗУ " + ramSize + "Gb. " +
                "Корпус " + bodyColor + " " +
                bodyType +  ". " +
                "Вес " + weight + " кг. " +
                "Цена " + price + " руб.";
    }
}

