package br.com.youready.carrousel;

import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.time.LocalDate;

// start
@Service
@Transactional
@AllArgsConstructor
public class RentalService4 {

    private final RentalRepository rentalRepository;

    @Transactional(readOnly = true)
    public Long calculateCharge(Long rentalCompanyId,
                                LocalDate rentalStart,
                                LocalDate rentalEnd,
                                int days) {
        RentalCompany rentalCompany =
                rentalRepository.findById(rentalCompanyId);

        // Mais fácil de testar a lógica do cálculo, pois:
        //   - Não dependemos do rentalRepository e rentalCompanyId
        //   - Código mais coeso e bem localizado no rentalCompany
        //   - Os dados para a lógica ficam mais explícitos
        return rentalCompany.calculateCharge(rentalStart, rentalEnd, days);
    }
}
// end

