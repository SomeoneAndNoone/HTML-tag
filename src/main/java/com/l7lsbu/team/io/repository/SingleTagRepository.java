package com.l7lsbu.team.io.repository;

import java.util.List;

import com.l7lsbu.team.io.entity.SingleTagEntity;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface SingleTagRepository extends CrudRepository<SingleTagEntity, Long> {
    List<SingleTagEntity> findAllByParentUrl(String parentTag);

    SingleTagEntity findByTag(String tag);
}
