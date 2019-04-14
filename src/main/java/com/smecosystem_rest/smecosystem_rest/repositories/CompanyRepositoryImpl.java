package com.smecosystem_rest.smecosystem_rest.repositories;

import com.smecosystem_rest.smecosystem_rest.model.Company;
import org.springframework.data.domain.Example;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.transaction.Transactional;
import java.util.List;
import java.util.Optional;

@Repository
public class CompanyRepositoryImpl implements CompanyRepository {

    @PersistenceContext
    protected EntityManager entityManager;

    @Override
    public Company getCompanyByKvkNummer(String kvkNummer) {
        return null;
    }

    @Override
    public List<Company> findAll() {
        return entityManager.createQuery("Select t from Company t").getResultList();
    }

    @Override
    public List<Company> findAll(Sort sort) {
        return null;
    }

    @Override
    public Page<Company> findAll(Pageable pageable) {
        return null;
    }

    @Override
    public List<Company> findAllById(Iterable<Long> longs) {
        return null;
    }

    @Override
    public long count() {
        return 0;
    }

    @Override
    public void deleteById(Long aLong) {

    }

    @Override
    public void delete(Company entity) {

    }

    @Override
    public void deleteAll(Iterable<? extends Company> entities) {

    }

    @Override
    public void deleteAll() {

    }

    @Transactional
    @Override
    public <S extends Company> S save(S entity) {
        return entityManager.merge(entity);
    }

    @Override
    public <S extends Company> List<S> saveAll(Iterable<S> entities) {
        return null;
    }

    @Override
    public Optional<Company> findById(Long id) {
        Company company = entityManager.find(Company.class, id);
        if(company == null) {
            return Optional.empty();
        } else {
            return  Optional.of(company);
        }
    }

    @Override
    public boolean existsById(Long aLong) {
        return false;
    }

    @Override
    public void flush() {

    }

    @Override
    public <S extends Company> S saveAndFlush(S entity) {
        return null;
    }

    @Override
    public void deleteInBatch(Iterable<Company> entities) {

    }

    @Override
    public void deleteAllInBatch() {

    }

    @Override
    public Company getOne(Long aLong) {
        return null;
    }

    @Override
    public <S extends Company> Optional<S> findOne(Example<S> example) {
        return Optional.empty();
    }

    @Override
    public <S extends Company> List<S> findAll(Example<S> example) {
        return null;
    }

    @Override
    public <S extends Company> List<S> findAll(Example<S> example, Sort sort) {
        return null;
    }

    @Override
    public <S extends Company> Page<S> findAll(Example<S> example, Pageable pageable) {
        return null;
    }

    @Override
    public <S extends Company> long count(Example<S> example) {
        return 0;
    }

    @Override
    public <S extends Company> boolean exists(Example<S> example) {
        return false;
    }
}
