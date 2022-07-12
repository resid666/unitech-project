package az.fintech.unitechms.repository;

import az.fintech.unitechms.model.Transfer;
import org.springframework.data.jpa.repository.JpaRepository;

public interface TransferRepository extends JpaRepository<Transfer, Long> {
}
