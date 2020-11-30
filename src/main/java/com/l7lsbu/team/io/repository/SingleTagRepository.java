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

    @Transactional
    @Modifying
    @Query(value = "delete from tags t where t.parent_url = :mParentUrl", nativeQuery = true)
    void deleteTagsByUrl(@Param("mParentUrl") String mParentUrl);

    @Transactional
    @Modifying
    @Query(value = "delete from tags t where t.parent_website = :mParentWebsite", nativeQuery = true)
    void deleteTagsByWebsite(@Param("mParentWebsite") String mParentWebsite);

    @Transactional
	@Modifying
	@Query(value="update tags t set t.tag=:mTag where t.tag_id=:tagId", nativeQuery=true)
	void updateTag(@Param("mTag") String mTag, 
			@Param("tagId") long tagId);
}
