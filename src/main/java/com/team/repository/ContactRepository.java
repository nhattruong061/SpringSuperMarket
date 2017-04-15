package com.team.repository;

import java.util.List;

import org.springframework.data.repository.CrudRepository;

import com.team.domain.Contact;

public interface ContactRepository extends CrudRepository<Contact, Integer> {

    List<Contact> findByNameContaining(String q);

}