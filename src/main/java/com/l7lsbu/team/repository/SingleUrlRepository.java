package com.l7lsbu.team.repository;

import java.util.List;

import com.l7lsbu.team.io.entity.SingleUrlEntity;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface SingleUrlRepository extends CrudRepository<SingleUrlEntity, Long> {
    List<SingleUrlEntity> findAllByParentWebsite(String parentWebsite);

    SingleUrlEntity findByUrl(String url);
}
