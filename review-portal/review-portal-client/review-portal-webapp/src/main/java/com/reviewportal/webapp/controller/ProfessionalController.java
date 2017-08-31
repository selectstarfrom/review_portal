package com.reviewportal.webapp.controller;

import java.security.Principal;
import java.util.Base64;
import java.util.List;

import javax.validation.Valid;

import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import com.reviewportal.model.enums.Gender;
import com.reviewportal.service.dto.ProfessionalDTO;
import com.reviewportal.service.dto.UserDTO;
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