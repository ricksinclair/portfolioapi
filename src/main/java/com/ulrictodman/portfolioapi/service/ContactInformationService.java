package com.ulrictodman.portfolioapi.service;

import com.ulrictodman.portfolioapi.model.ContactInformation;
import com.ulrictodman.portfolioapi.exception.*;

import java.util.List;

public interface ContactInformationService {
    ContactInformation save(ContactInformation contactInformation);

    void update(ContactInformation contactInformation) throws NotFoundException;

    ContactInformation get(int id) throws NotFoundException;

    List<ContactInformation> getAll();

    void delete(int id) throws NotFoundException;
}
