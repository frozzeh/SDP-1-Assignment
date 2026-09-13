package travel;

import java.util.List;

public class TravelTrip {
    private final String destination;
    private final int durationDays;
    private final TransportType transport;
    private final MealPlan mealPlan;
    private final boolean hasInsurance;
    private final List<String> excursions;

    TravelTrip(String destination, int durationDays, TransportType transport,
               MealPlan mealPlan, boolean hasInsurance, List<String> excursions) {
        this.destination = destination;
        this.durationDays = durationDays;
        this.transport = transport;
        this.mealPlan = mealPlan;
        this.hasInsurance = hasInsurance;
        this.excursions = excursions;
    }

    @Override
    public String toString() {
        return "TravelTrip {" +
                "destination='" + destination + '\'' +
                ", durationDays=" + durationDays +
                ", transport=" + transport +
                ", mealPlan=" + mealPlan +
                ", hasInsurance=" + hasInsurance +
                ", excursions=" + excursions +
                '}';
    }
}