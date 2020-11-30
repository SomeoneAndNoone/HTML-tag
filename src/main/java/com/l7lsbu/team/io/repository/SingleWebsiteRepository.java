package com.l7lsbu.team.io.repository;

import com.l7lsbu.team.io.entity.SingleWebsiteEntity;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface SingleWebsiteRepository extends CrudRepository<SingleWebsiteEntity, Long> {
    SingleWebsiteEntity findByWebsite(String website);
}
