package br.com.youready.carrousel;

import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.time.LocalDate;

// start
@Service
@Transactional
@AllArgsConstructor
public class RentalService {

    private final RentalRepository rentalRepository;

    @Transactional(readOnly = true)
    public Long calculateCharge(Long rentalCompanyId,
                                LocalDate rentalStart,
                                LocalDate rentalEnd,
                                int days) {
        RentalCompany rentalCompany =
                rentalRepository.findById(rentalCompanyId);

        if (!rentalStart.isBefore(rentalCompany.holidayPeriodStart) &&
                !rentalEnd.isAfter(rentalCompany.holidayPeriodEnd)) {
            return days * rentalCompany.holidayDailyRate;
        }

        return days * rentalCompany.standardDailyRate - rentalCompany.weeklyDiscount;
    }
}
// end