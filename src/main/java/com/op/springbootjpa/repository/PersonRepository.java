package com.op.springbootjpa.repository;

import com.op.springbootjpa.entity.Person;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface PersonRepository extends JpaRepository<Person, Long> {

    Page<Person> findPersonByFirstNameContaining(String firstName, Pageable pageable);

    List<Person> findAllPersonByFirstNameIgnoreCase(String firstName);

    List<Person> findAllPersonByLastNameIgnoreCase(String lastName);

    @Query(value = "select p from Person p where upper(p.firstName) = upper(?1) and upper(p.lastName)=upper(?2) ")
    List<Person> findAllPersonByFullNameIgnoreCase(String firstName, String lastName);
}
