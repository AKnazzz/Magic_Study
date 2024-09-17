package org.workwork.g_spring.homework_g4.ContactsManager.src.main.java.com.example.demo;

import org.springframework.data.jpa.repository.JpaRepository;

public interface ContactRepository extends JpaRepository<Contact, Long> {
}
