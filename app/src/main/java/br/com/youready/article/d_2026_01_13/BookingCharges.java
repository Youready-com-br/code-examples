package br.com.youready.article.d_2026_01_13;

import java.util.List;

// Agent: 6 to 37
public class BookingCharges {
    private List<ServiceCharge> charges;

    int getAdditionalCharges() {
        int total = 0;
        for (ServiceCharge charge : charges) {
            total += charge.getAmount();
        }
        return total;
    }

    int getBaseCharge(int duration, int hourlyRate) {
        int baseMultiplier = 1;
        if (duration > 8) {
            int regularHours = 8;
            int overtimeHours = duration - 8;
            return (hourlyRate * baseMultiplier * regularHours) +
                    ((int)(hourlyRate * baseMultiplier * 1.5) * overtimeHours);
        }
        return hourlyRate * baseMultiplier * duration;
    }

    public int getTotalCharge(int duration, int hourlyRate) {
        return getBaseCharge(duration, hourlyRate) + getAdditionalCharges();
    }

    public double getHourlyRateWithCharges(int duration, int hourlyRate) {
        if (duration == 0) return 0;

        return (double) getTotalCharge(duration, hourlyRate) / duration;
    }
}
