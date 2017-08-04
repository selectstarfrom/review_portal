package com.reviewportal.service.impl.services.member;

import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.reviewportal.dao.dao.IReviewWriterDao;
import com.reviewportal.model.entities.ReviewWriter;
import com.reviewportal.service.dto.ReviewWriterDTO;
import com.reviewportal.service.dto.UserRoleDTO;
import com.reviewportal.service.impl.converter.ReviewWriterConverter;

@Service
public class ReviewWriterMemberServicesImpl extends AbstractMemberServicesImpl<ReviewWriter, ReviewWriterDTO> {

	@Autowired
	public ReviewWriterMemberServicesImpl(IReviewWriterDao pDao, ReviewWriterConverter pConverter) {
		super(pDao, pConverter);
	}

	public IReviewWriterDao getDao() {
		return (IReviewWriterDao) super.getDao();
	}

	public ReviewWriterConverter getConverter() {
		return (ReviewWriterConverter) super.getConverter();
	}

	protected Set<UserRoleDTO> getDefaultRolesBasedOnMemberType() {
		return getCommonServices().getDefaultUserRolesForReviewWriters();
	}
}
