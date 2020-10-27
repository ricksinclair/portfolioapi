package com.ulrictodman.portfolioapi.service;


import com.ulrictodman.portfolioapi.model.ContactInformation;
import com.ulrictodman.portfolioapi.repository.ContactInformationRepository;
import com.ulrictodman.portfolioapi.exception.*;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ContactInformationServiceImplV1 implements ContactInformationService {

    private final ContactInformationRepository contactInformationRepository;


    public ContactInformationServiceImplV1(ContactInformationRepository contactInformationRepository){
        this.contactInformationRepository = contactInformationRepository;
    }


    @Override
    public ContactInformation save(ContactInformation contactInformation){
        return contactInformationRepository.save(contactInformation);
    }

    @Override
    public void update(ContactInformation contactInformation) throws NotFoundException {
        Optional<ContactInformation> fromDb = contactInformationRepository.findById(contactInformation.getId());
        if(fromDb.isPresent())
            contactInformationRepository.save(contactInformation);
        else
            throw new NotFoundException(String.format("The resource with id %d was not found and therefore couldn't be updated.",contactInformation.getId()));
    }

    @Override
    public ContactInformation get(int id) throws NotFoundException {
        Optional<ContactInformation> fromDb = contactInformationRepository.findById(id);
        ContactInformation returnValue = new ContactInformation();

        if(fromDb.isPresent())
            returnValue = fromDb.get();

        else
            throw new NotFoundException(String.format("The resource with id %d was not found.", id));

        return returnValue;
    }


    @Override
    public List<ContactInformation> getAll(){
        return contactInformationRepository.findAll();
    }


    @Override
    public void delete(int id) throws NotFoundException {
        Optional<ContactInformation> fromDb = contactInformationRepository.findById(id);

        if(fromDb.isPresent())
        contactInformationRepository.deleteById(id);
        else
            throw new NotFoundException(String.format("The resource with id %d was not found and therefore couldn't be deleted.", id));

    }
}
