package com.reviewportal.webclient.web.managedbeans.review.me;

import java.lang.reflect.Field;

import javax.annotation.PostConstruct;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;

import com.reviewportal.service.dto.ProfessionReviewDTO;
import com.reviewportal.service.dto.ProfessionalDTO;
import com.reviewportal.service.dto.ReviewWriterDTO;
import com.reviewportal.webclient.web.core.PropertyAccessor;
import com.reviewportal.webclient.web.core.ViewAction;
import com.reviewportal.webclient.web.dto.CriteriaSearchReviewDTO;
import com.reviewportal.webclient.web.managedbeans.AbstractViewBean;

/**
 * @author imfroz
 *
 */
@ManagedBean(name = "searchReviewByMePageViewBean")
@ViewScoped
@PropertyAccessor(className = SearchReviewByMePageAccessor.class)
@ViewAction(className = SearchReviewByMePageActionBean.class)
public class SearchReviewByMePageViewBean extends AbstractViewBean {

    private static final long serialVersionUID = -2482892101460091365L;

    @PostConstruct
    public void init() {
        super.init();
        getAccessor().setSearchCriteria(getNewSearchCriteriaInstance());
    }

    public CriteriaSearchReviewDTO getNewSearchCriteriaInstance() {
        CriteriaSearchReviewDTO lInstance = new CriteriaSearchReviewDTO();
        return lInstance;
    }

    public ProfessionReviewDTO getNewReviewInstance() {
        ProfessionReviewDTO lInstance = new ProfessionReviewDTO();
        ProfessionalDTO lReviewAbout = new ProfessionalDTO();
        lInstance.setReviewAbout(lReviewAbout);
        ReviewWriterDTO lReviewBy = new ReviewWriterDTO();
        lInstance.setReviewBy(lReviewBy);

        return lInstance;
    }

    @Override
    public SearchReviewByMePageAccessor getAccessor() {
        return (SearchReviewByMePageAccessor) this.accessor;
    }

    @Override
    public SearchReviewByMePageActionBean getActions() {
        return (SearchReviewByMePageActionBean) super.actions;
    }

    public static void nullifyStrings(Object o) {

        for (Field f : o.getClass().getDeclaredFields()) {
            f.setAccessible(true);
            try {
                if (f.getType().equals(String.class)) {
                    String value = (String) f.get(o);
                    if (value != null && value.trim().isEmpty()) {
                        f.set(o, null);
                    }
                }
            } catch (Exception e) {
                throw new RuntimeException(e);
            }
        }

    }

}