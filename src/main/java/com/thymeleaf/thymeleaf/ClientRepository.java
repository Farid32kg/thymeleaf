package com.thymeleaf.thymeleaf;

import org.springframework.data.jpa.repository.JpaRepository;

public interface ClientRepository extends JpaRepository<Clients,Long> {
}
