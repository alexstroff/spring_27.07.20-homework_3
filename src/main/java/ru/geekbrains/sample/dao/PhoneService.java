package ru.geekbrains.sample.dao;


import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import ru.geekbrains.sample.dto.PhoneDTO;
import ru.geekbrains.sample.persistence.entity.Phone;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Predicate;
import javax.persistence.criteria.Root;
import java.util.ArrayList;
import java.util.List;

@Service
@RequiredArgsConstructor
public class PhoneService{

    @PersistenceContext
    private EntityManager entityManager;

    private final PhoneRepository phoneRepository;

//    @Transactional
//    public void save(PhoneDTO phoneDTO) {
//        phoneRepository.save(Phone.builder()
//                .model(phoneDTO.getModel())
//                .price(phoneDTO.getPrice())
//                .build());
//    }

    @Transactional
    public void save(Phone phone){
        phoneRepository.save(phone);
    }

    @Transactional
    public List<Phone> findAllPhones1(){
        return phoneRepository.findAll();
    }

    public List<Phone> findAllPhones() {
        CriteriaBuilder criteriaBuilder = entityManager.getCriteriaBuilder();
        CriteriaQuery<Phone> criteriaQuery = criteriaBuilder.createQuery(Phone.class);
        Root<Phone> root = criteriaQuery.from(Phone.class);
        List<Predicate> predicates = new ArrayList<>();
        predicates.add(criteriaBuilder.equal(root.get("price"), 10));
        criteriaQuery.select(root);
        criteriaQuery.where(criteriaBuilder.and(predicates.toArray(new Predicate[]{})));
        return entityManager.createQuery(criteriaQuery).getResultList();
    }

    @Transactional
    public List<Phone> findPhoneByMaxPrice(){
        return phoneRepository.findPhoneByMaxPrice();
    }

    @Transactional
    public List<Phone> findPhoneByMinPrice(){
        return phoneRepository.findPhoneByMinPrice();
    }

    @Transactional
    public List<Phone> findPhoneByMaxAndMinPrice(){
        return phoneRepository.findPhoneByMaxAndMinPrice();
    }
}
