package com.l7lsbu.team.io.repository;

import java.util.List;

import javax.transaction.Transactional;

import com.l7lsbu.team.io.entity.SingleTagEntity;

import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface SingleTagRepository extends CrudRepository<SingleTagEntity, Long> {
    List<SingleTagEntity> findAllByParentUrl(String parentTag);

    SingleTagEntity findByTag(String tag);

    @Query(value = "delete * from Tags t where t.parent_url = :parentUrl", nativeQuery = true)
    void deleteTagsByUrl(@Param("parentUrl") String parentUrl);

    @Query(value = "delete * from Tags t where t.parent_website = :parentWebsite", nativeQuery = true)
    void deleteTagsByWebsite(@Param("parentWebsite") String parentWebsite);

    @Transactional
	@Modifying
	@Query(value="update tags t set t.tag=:mTag where t.tag_id=:tagId", nativeQuery=true)
	void updateTag(@Param("tag") String mTag, 
			@Param("tagId") long tagId);
}
