package ru.geekbrains.sample.dao;

import org.springframework.stereotype.Repository;
import ru.geekbrains.sample.persistence.entity.Tutor;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Predicate;
import javax.persistence.criteria.Root;
import java.util.ArrayList;
import java.util.List;

@Repository
public class TutorRepository {

    @PersistenceContext
    private EntityManager entityManager;

    public List<Tutor> findAllTutors() {
        CriteriaBuilder criteriaBuilder = entityManager.getCriteriaBuilder();
        CriteriaQuery<Tutor> criteriaQuery = criteriaBuilder.createQuery(Tutor.class);
        Root<Tutor> root = criteriaQuery.from(Tutor.class);
        List<Predicate> predicates = new ArrayList<>();
        predicates.add(criteriaBuilder.equal(root.get("isWorking"), true));
        criteriaQuery.select(root);
        criteriaQuery.where(criteriaBuilder.and(predicates.toArray(new Predicate[]{})));
        return entityManager.createQuery(criteriaQuery).getResultList();
    }
}
