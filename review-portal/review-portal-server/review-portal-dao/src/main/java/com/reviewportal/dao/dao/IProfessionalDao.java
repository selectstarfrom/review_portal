package com.reviewportal.dao.dao;

import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.reviewportal.model.entities.Professional;

/**
 * @author imfroz
 *
 */
@Repository
public interface IProfessionalDao extends IMemberDao<Professional> {

    @Override
    @Query("SELECT u FROM Professional u WHERE u.user.id = :pUserId")
    Professional getByUserId(@Param("pUserId") Long pId);

    @Query("select new Professional(d.id, d.name, d.profession.title) from Professional d where LOWER(d.name) LIKE CONCAT('%',:pName,'%')")
    List<Professional> getByNameLike(@Param("pName") String pInput);

}
