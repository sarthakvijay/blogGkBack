package repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import modal.GkModal;

@Repository
public interface GkRepository extends JpaRepository<GkModal, Long>{

}
