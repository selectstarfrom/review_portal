package com.reviewportal.webapp.controller;

import java.util.List;

import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import com.reviewportal.model.enums.Gender;
import com.reviewportal.service.dto.ProfessionReviewDTO;
import com.reviewportal.service.dto.ProfessionalDTO;
import com.reviewportal.service.impl.services.member.ProfessionalMemberServicesImpl;
import com.reviewportal.webapp.core.ImageGenerator;
import com.reviewportal.webapp.core.PublicModelAndView;
import com.reviewportal.webapp.core.SelectItem;
import com.reviewportal.webapp.dto.CriteriaSearchProfessionalDTO;

@Controller
public class ProfessionalController {
    @Value("${spring.application.name}")
    String appName;

    @Autowired
    private AppCoreUtils appCoreUtils;

    @Autowired
    private ProfessionalMemberServicesImpl professionalMemberService;

    @RequestMapping(value = "/getSelectItemProfessions", method = RequestMethod.GET)
    public @ResponseBody List<SelectItem> getProfessions(@RequestParam("pInput") String pInput) {
        return appCoreUtils.autoCompleteProfession(pInput);
    }

    @RequestMapping(value = "/profDetail/{pProfessionalId}", method = RequestMethod.GET)
    public ModelAndView profDetail(@PathVariable("pProfessionalId") String pProfessionalId) {
        long lProfessionalId = Long.parseLong(pProfessionalId);
        ProfessionalDTO lById = professionalMemberService.getById(lProfessionalId);
        PublicModelAndView modelAndView = new PublicModelAndView();
        modelAndView.setViewName("professional/professional-details");
        modelAndView.addObject("prof", lById);
        modelAndView.addObject("imageGen", new ImageGenerator());

        return modelAndView;
    }

    @RequestMapping(value = "/writeReview", method = RequestMethod.POST)
    public String writeReview(@ModelAttribute ProfessionReviewDTO pProfessionReviewDTO, BindingResult errors,
            Model model) {
        // logic to process input data
        return "result";
    }

    @RequestMapping(value = "/saveRevissew", method = RequestMethod.POST)
    public ModelAndView writeReview(ModelAndView pModelAndView) {
        ProfessionReviewDTO lProfessionReviewDTO = (ProfessionReviewDTO) pModelAndView.getModelMap().get("review");
        // long lProfessionalId = Long.parseLong(pProfessionalId);
        // ProfessionalDTO lById =
        // professionalMemberService.getById(lProfessionalId);
        // PublicModelAndView modelAndView = new PublicModelAndView();
        // modelAndView.setViewName("professional/write-review");
        // ProfessionReviewDTO lProfessionReviewDTO = new ProfessionReviewDTO();
        // lProfessionReviewDTO.setReviewAbout(lById);
        // modelAndView.addObject("review", lProfessionReviewDTO);
        // modelAndView.addObject("imageGen", new ImageGenerator());

        return pModelAndView;
    }

    @RequestMapping(value = "/writeReview/{pProfessionalId}", method = RequestMethod.GET)
    public ModelAndView writeReview(@PathVariable("pProfessionalId") String pProfessionalId) {
        long lProfessionalId = Long.parseLong(pProfessionalId);
        ProfessionalDTO lById = professionalMemberService.getById(lProfessionalId);
        PublicModelAndView modelAndView = new PublicModelAndView();
        modelAndView.setViewName("professional/write-review");
        ProfessionReviewDTO lProfessionReviewDTO = new ProfessionReviewDTO();
        lProfessionReviewDTO.setReviewAbout(lById);
        modelAndView.addObject("review", lProfessionReviewDTO);
        modelAndView.addObject("imageGen", new ImageGenerator());

        return modelAndView;
    }

    @RequestMapping(value = { "/searchByProfession" }, method = RequestMethod.GET)
    public ModelAndView searchByProfession(
            @RequestParam(value = "pSearchProfessionTitle", required = false) String pSearchProfessionTitle,
            Model model) {

        CriteriaSearchProfessionalDTO lSearchCriteria = new CriteriaSearchProfessionalDTO();
        lSearchCriteria.setSearchProfessionTitle(pSearchProfessionTitle);

        ProfessionalMemberServicesImpl lServices = professionalMemberService;
        ProfessionalDTO lProfessionalExample = new ProfessionalDTO();

        String lSearchGender = lSearchCriteria.getSearchGender();
        String lSearchName = lSearchCriteria.getSearchName();
        String lSearchProfession = lSearchCriteria.getSearchProfessionTitle();

        String lSearchRatingMax = lSearchCriteria.getSearchRatingMax();
        String lSearchRatingMin = lSearchCriteria.getSearchRatingMin();

        String lSearchCity = lSearchCriteria.getSearchCity();
        String lSearchState = lSearchCriteria.getSearchState();
        String lSearchZip = lSearchCriteria.getSearchZip();

        String lName = StringUtils.isEmpty(lSearchName) ? null : lSearchName;
        lProfessionalExample.setName(lName);

        String lTitle = StringUtils.isEmpty(lSearchProfession) ? null : lSearchProfession;
        lProfessionalExample.getProfession().setTitle(lTitle);

        Gender lGender = StringUtils.isEmpty(lSearchGender) ? null : Gender.valueOf(lSearchGender);
        lProfessionalExample.setGender(lGender);

        String lCity = StringUtils.isEmpty(lSearchCity) ? null : lSearchCity;
        lProfessionalExample.getAddress().setCity(lCity);

        String lState = StringUtils.isEmpty(lSearchState) ? null : lSearchState;
        lProfessionalExample.getAddress().setState(lState);

        String lZip = StringUtils.isEmpty(lSearchZip) ? null : lSearchZip;
        lProfessionalExample.getAddress().setZip(lZip);

        List<ProfessionalDTO> lProfessionReviews = lServices.getByExample(lProfessionalExample);

        PublicModelAndView modelAndView = new PublicModelAndView();
        modelAndView.setViewName("professional/search-result");
        modelAndView.addObject("professionals", lProfessionReviews);
        modelAndView.addObject("imageGen", new ImageGenerator());

        return modelAndView;
    }

}