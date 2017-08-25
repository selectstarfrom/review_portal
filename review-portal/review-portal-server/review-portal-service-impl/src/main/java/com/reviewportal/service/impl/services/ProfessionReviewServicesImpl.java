package com.reviewportal.service.impl.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Example;
import org.springframework.data.domain.ExampleMatcher;
import org.springframework.data.domain.ExampleMatcher.StringMatcher;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import com.reviewportal.dao.dao.IProfessionReviewDao;
import com.reviewportal.dao.dao.IProfessionalDao;
import com.reviewportal.dao.dao.IReviewWriterDao;
import com.reviewportal.model.entities.ProfessionReview;
import com.reviewportal.model.entities.Professional;
import com.reviewportal.model.entities.ReviewWriter;
import com.reviewportal.service.dto.ProfessionReviewDTO;
import com.reviewportal.service.dto.ProfessionalDTO;
import com.reviewportal.service.dto.ReviewWriterDTO;
import com.reviewportal.service.exceptions.SystemServiceException;
import com.reviewportal.service.impl.converter.EntityTOConverterFactory;
import com.reviewportal.service.impl.converter.ProfessionReviewConverter;
import com.reviewportal.service.impl.converter.ProfessionalConverter;
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
    private IProfessionalDao professionalDao;

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

        ProfessionalDTO lReviewAbout = pDto.getReviewAbout();
        Long lReviewAboutId = lReviewAbout.getId();
        Professional lReviewAboutEntity = getProfessionalDao().findOne(lReviewAboutId);

        ProfessionalConverter lProfessionalConverter = converterFactory.getMapper(ProfessionalConverter.class);
        lReviewAbout = lProfessionalConverter.getDto(lReviewAboutEntity);

        ReviewWriterDTO lReviewBy = pDto.getReviewBy();
        Long lReviewById = lReviewBy.getId();
        ReviewWriter lReviewByEntity = getReviewWriterDao().findOne(lReviewById);
        ReviewWriterConverter lReviewWriterConverter = converterFactory.getMapper(ReviewWriterConverter.class);
        lReviewBy = lReviewWriterConverter.getDto(lReviewByEntity);

        pDto.setReviewAbout(lReviewAbout);
        pDto.setReviewBy(lReviewBy);

        super.save(pDto);
    }

    @Override
    @Transactional(propagation = Propagation.REQUIRED, readOnly = false)
    public void updateAvgRatingOfProfessional(Long pId) {
        getDao().updateAvgRatingById(pId);
    }

    protected IReviewWriterDao getReviewWriterDao() {
        return reviewWriterDao;
    }

    protected IProfessionalDao getProfessionalDao() {
        return professionalDao;
    }

    public List<ProfessionReviewDTO> getByExample(ProfessionReviewDTO pProfessionReviewExample) {

        ProfessionReview lEnity = getConverter().getEnity(pProfessionReviewExample);

        ExampleMatcher lExampleMatcher = ExampleMatcher.matchingAll().withIgnoreCase().withIgnoreNullValues()
                .withStringMatcher(StringMatcher.CONTAINING);
        Example<ProfessionReview> lExample = Example.of(lEnity, lExampleMatcher);

        List<ProfessionReview> lFindAll = getDao().findAll(lExample);

        List<ProfessionReviewDTO> lDtos = getConverter().getDtos(lFindAll);

        return lDtos;
    }

}
