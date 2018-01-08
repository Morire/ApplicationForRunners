package pl.coderslab.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import pl.coderslab.entity.Contact;

public interface ContactRepository extends JpaRepository<Contact, Long> {

}
