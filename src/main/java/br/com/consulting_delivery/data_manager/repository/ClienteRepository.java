package br.com.consulting_delivery.data_manager.repository;

import br.com.consulting_delivery.data_manager.domain.Cliente;
import java.util.Optional;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ClienteRepository extends JpaRepository<Cliente, Long> {
    Page<Cliente> findAllByAtivoTrue(Pageable paginacao);

    Optional<Cliente> findByIdAndAtivoTrue(Long id);
}