package com.ulrictodman.portfolioapi.repository;

import com.ulrictodman.portfolioapi.model.ContactInformation;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ContactInformationRepository extends JpaRepository<ContactInformation, Integer> {
}
