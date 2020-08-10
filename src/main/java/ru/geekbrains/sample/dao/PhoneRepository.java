package ru.geekbrains.sample.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import ru.geekbrains.sample.persistence.entity.Phone;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Repository
public interface PhoneRepository extends JpaRepository<Phone, UUID> {
    Optional<Phone> findById(UUID uuid);

    Phone save(Phone p);

    @Query("select p from Phone p where p.price =(select max (p.price) from Phone p)")
    List<Phone> findPhoneByMaxPrice();

    @Query("select p from Phone p where p.price =(select min (p.price) from Phone p)")
    List<Phone> findPhoneByMinPrice();

    @Query("select p from Phone p where (p.price =(select max (p.price) from Phone p) or p.price =(select min (p.price) from Phone p))")
    List<Phone> findPhoneByMaxAndMinPrice();



}


