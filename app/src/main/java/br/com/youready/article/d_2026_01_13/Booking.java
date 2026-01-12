package br.com.youready.article.d_2026_01_13;


import java.util.List;

// AGENT: 7 to 65
public class Booking {
    private int duration;
    private int hourlyRate;
    private Client client;
    private List<ServiceCharge> charges;

    public void extend(int additionalHours) {
        if (additionalHours > 0) {
            this.duration += additionalHours;
        }
    }

    public void extendForDay() {
        this.extend(24);
    }

    int getAdditionalCharges() {
        int total = 0;
        for (ServiceCharge charge : charges) {
            total += charge.getAmount();
        }
        return total;
    }

    int getBaseCharge() {
        int baseMultiplier = 1;
        if (duration > 8) {
            int regularHours = 8;
            int overtimeHours = duration - 8;
            return (hourlyRate * baseMultiplier * regularHours) +
                    ((int)(hourlyRate * baseMultiplier * 1.5) * overtimeHours);
        }
        return hourlyRate * baseMultiplier * duration;
    }

    public int getTotalCharge() {
        return getBaseCharge() + getAdditionalCharges();
    }

    public double getHourlyRateWithCharges() {
        if (duration == 0) return 0;
        return (double) getTotalCharge() / duration;
    }

    public boolean isLongBooking() {
        return duration > 40;
    }

    public String summary() {
        return String.format("Booking for %s: %d hours at $%d/hour. Total: $%d",
                client.getName(), duration, hourlyRate, getTotalCharge());
    }

    public void applyDiscount(int discountPercentage) {
        if (discountPercentage > 0 && discountPercentage <= 100) {
            hourlyRate = hourlyRate - (hourlyRate * discountPercentage / 100);
        }
    }
}