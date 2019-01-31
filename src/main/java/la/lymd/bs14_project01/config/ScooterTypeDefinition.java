package la.lymd.bs14_project01.config;

import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
public class ScooterTypeDefinition {

    private String name;

    private int firstYearOfProduction;
    private int lastYearOfProduction;

    private int firstAddedToFleet;
    private int lastAddedToFleet;

    private int totalAmount;
    private int deployedPercent;

    private float price;
    private float halfDayDiscount;
    private float fullDayDiscount;
    private float threeDayDiscount;
    private float weekDiscount;

    private List<String> options;
    private List<String> parts;
}
