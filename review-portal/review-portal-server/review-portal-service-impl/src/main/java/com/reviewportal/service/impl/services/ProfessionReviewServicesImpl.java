package com.reviewportal.service.impl.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import com.reviewportal.dao.dao.IOfficialsDao;
import com.reviewportal.dao.dao.IProfessionReviewDao;
import com.reviewportal.dao.dao.IReviewWriterDao;
import com.reviewportal.model.entities.Official;
import com.reviewportal.model.entities.ProfessionReview;
import com.reviewportal.model.entities.ReviewWriter;
import com.reviewportal.service.dto.OfficialDTO;
import com.reviewportal.service.dto.ProfessionReviewDTO;
import com.reviewportal.service.dto.ReviewWriterDTO;
import com.reviewportal.service.exceptions.SystemServiceException;
import com.reviewportal.service.impl.converter.EmployeeConverter;
import com.reviewportal.service.impl.converter.EntityTOConverterFactory;
import com.reviewportal.service.impl.converter.OfficialConverter;
import com.reviewportal.service.impl.converter.ProfessionReviewConverter;
import com.reviewportal.service.impl.converter.ReviewWriterConverter;
import com.reviewportal.service.services.IProfessionReviewServices;

@Service
public class ProfessionReviewServicesImpl extends AbstractCommonServiceImpl<ProfessionReview, ProfessionReviewDTO>
		implements IProfessionReviewServices {

	@Autowired
	private EntityTOConverterFactory converterFactory;

	@Autowired
	private IReviewWriterDao reviewWriterDao;

	@Autowired
	private IOfficialsDao officialsDao;

	@Autowired
	public ProfessionReviewServicesImpl(IProfessionReviewDao pDao, ProfessionReviewConverter pConverter) {
		super(pDao, pConverter);
	}

	public IProfessionReviewDao getDao() {
		return (IProfessionReviewDao) super.getDao();
	}

	public ProfessionReviewConverter getConverter() {
		return (ProfessionReviewConverter) super.getConverter();
	}

	@Override
	@Transactional(propagation = Propagation.REQUIRED, readOnly = false)
	public void save(ProfessionReviewDTO pDto) throws SystemServiceException {

		OfficialDTO lReviewAbout = pDto.getReviewAbout();
		Long lReviewAboutId = lReviewAbout.getId();
		Official lReviewAboutEntity = getOfficialsDao().findOne(lReviewAboutId);

		OfficialConverter lOfficialConverter = converterFactory.getMapper(OfficialConverter.class);
		lReviewAbout = lOfficialConverter.getDto(lReviewAboutEntity);

		ReviewWriterDTO lReviewBy = pDto.getReviewBy();
		Long lReviewById = lReviewBy.getId();
		ReviewWriter lReviewByEntity = getReviewWriterDao().findOne(lReviewById);
		ReviewWriterConverter lReviewWriterConverter = converterFactory.getMapper(ReviewWriterConverter.class);
		lReviewBy = lReviewWriterConverter.getDto(lReviewByEntity);

		pDto.setReviewAbout(lReviewAbout);
		pDto.setReviewBy(lReviewBy);

		super.save(pDto);
	}

	protected IReviewWriterDao getReviewWriterDao() {
		return reviewWriterDao;
	}

	protected IOfficialsDao getOfficialsDao() {
		return officialsDao;
	}

}
