package com.reviewportal.webapp.controller;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

import javax.annotation.PostConstruct;

import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.reviewportal.service.impl.services.MasterDataServices;
import com.reviewportal.service.impl.services.UserServicesImpl;
import com.reviewportal.webapp.core.SelectItem;

@Component
public class AppCoreUtils {

    @Autowired
    protected transient MasterDataServices masterDataService;

    @Autowired
    protected transient UserServicesImpl userServices;

    // private List<SelectItem> membershipTypes;
    // private List<SelectItem> genders;
    // private List<String> professionsTitles;
    private List<SelectItem> professions;

    @PostConstruct
    public void init() {
        professions = new ArrayList<>();
        List<String[]> lAllProfessions = masterDataService.getAllProfessions();
        for (Object[] lObjects : lAllProfessions) {
            professions.add(new SelectItem((String) lObjects[0], (String) lObjects[1]));
        }
    }

    // public List<String> autoCompleteProfessionTitle(String pInput) {
    //
    // List<SelectItem> lProfessions = getAppCacheBean().getProfessions();
    // List<SelectItem> lFiltered = lProfessions.stream()
    // .filter(p -> StringUtils.containsIgnoreCase(p.getLabel(),
    // pInput)).collect(Collectors.toList());
    //
    // List<String> lMapped = lFiltered.stream().map(sc ->
    // sc.getLabel()).collect(Collectors.toList());
    // return lMapped;
    // }
    //
    public List<SelectItem> autoCompleteProfession(String pInput) {

        List<SelectItem> lProfessions = getProfessions();
        List<SelectItem> lFiltered = lProfessions.stream()
                .filter(p -> StringUtils.containsIgnoreCase(p.getLabel(), pInput)).collect(Collectors.toList());

        return lFiltered;
    }

    public List<SelectItem> getProfessions() {
        return professions;
    }

}
