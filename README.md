# SDP-1-Assignment

**Principle 1: Meaningful, Intention-Revealing Names**
Applied in: `TripBuilder.java`, `TripDirector.java`
Description: Class, method, and variable names clearly state their purpose and intent without needing additional comments.
Annotated Code Excerpt:
```java
// BEFORE:
public TripBuilder add(String e) { ... }
public TravelTrip makeT(TripBuilder b) { ... }

// AFTER:
public TripBuilder addExcursion(String excursion) { ... }
public TravelTrip makeLuxuryResortTrip(TripBuilder builder, String destination) { ... }
```



**Principle 2: Small Methods Doing One Thing**
Applied in: `TripBuilder.java`
Description: Each method performs exactly one clear task (adding an excursion, setting destination, or configuring trip parameters)
Annotated Code Excerpt:
```java
// BEFORE:
public TripBuilder addExcursionAndCalculate(String excursion) {
    if (excursion != null) {
        this.excursions.add(excursion.toLowerCase().trim());
        this.price += 50.0; // Multiple responsibilities!
    }
    return this;
}

// AFTER:
public TripBuilder addExcursion(String excursion) {
    if (excursion != null && !excursion.isBlank()) {
        this.excursions.add(excursion);
    }
    return this;
}
```



**Principle 3: Validated Construction**
Applied in: TripBuilder.java (build() method)
Description: The builder prevents the creation of invalid objects by checking required attributes before instantiation and throwing explicit exceptions with clear messages.
Annotated Code Excerpt:
```java
// BEFORE:
public TravelTrip build() {
    return new TravelTrip(destination, durationDays, transport, mealPlan, hasInsurance, excursions);
}

// AFTER:
public TravelTrip build() {
    if (destination == null || destination.isBlank()) {
        throw new IllegalStateException("Trip destination must be specified!");
    }
    if (durationDays <= 0) {
        throw new IllegalStateException("Trip duration must be at least 1 day!");
    }
    return new TravelTrip(destination, durationDays, transport, mealPlan, hasInsurance, new ArrayList<>(excursions));
}
```



**Principle 4: No Magic Numbers / Strings (Use of Enums)**
Applied in: `TransportType.java`, `MealPlan.java`
Description: Raw hardcoded strings and numbers are replaced with strongly-typed Java Enum constants to avoid typos and invalid inputs at compile time.
Annotated Code Excerpt:
```java
// BEFORE:
builder.setTransport("flite"); // Could accidentally pass typo strings

// AFTER:
builder.setTransport(TransportType.FLIGHT);
builder.setMealPlan(MealPlan.ALL_INCLUSIVE);
```



**Principle 5: Fluent Interface**
Applied in: `TripBuilder.java`
Description: Each builder setter returns 'this', enabling clean, readable, and concise method chaining during object assembly.
Annotated Code Excerpt:
```java
// BEFORE:
TripBuilder builder = new TripBuilder();
builder.setDestination("Italy");
builder.setDurationDays(5);
TravelTrip trip = builder.build();

// AFTER:
TravelTrip trip = new TripBuilder()
        .setDestination("Italy")
        .setDurationDays(5)
        .build();
```
