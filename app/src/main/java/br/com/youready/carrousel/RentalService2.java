package br.com.youready.carrousel;

import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.time.LocalDate;

// start
@Service
@Transactional
@AllArgsConstructor
public class RentalService2 {

    private final RentalRepository rentalRepository;

    @Transactional(readOnly = true)
    public Long calculateCharge(Long rentalCompanyId,
                                LocalDate rentalStart,
                                LocalDate rentalEnd,
                                int days) {
        RentalCompany rentalCompany =
                rentalRepository.findById(rentalCompanyId);

        // Mostrando a intenção do código para o leitor
        if (isHolidayPeriod(rentalCompany, rentalStart, rentalEnd)) {
            return holidayCharge(rentalCompany, days);
        }

        return standardCharge(rentalCompany, days);
    }

    // Métodos privados
// end

    private Long standardCharge(RentalCompany rentalCompany,
                                int days) {
        return days * rentalCompany.standardDailyRate - rentalCompany.weeklyDiscount;
    }

    private Long holidayCharge(RentalCompany rentalCompany,
                               int days) {
        return days * rentalCompany.holidayDailyRate;
    }

    private boolean isHolidayPeriod(RentalCompany rentalCompany,
                                    LocalDate rentalStart,
                                    LocalDate rentalEnd) {
        return !rentalStart.isBefore(rentalCompany.holidayPeriodStart) &&
                !rentalEnd.isAfter(rentalCompany.holidayPeriodEnd);
    }
}
