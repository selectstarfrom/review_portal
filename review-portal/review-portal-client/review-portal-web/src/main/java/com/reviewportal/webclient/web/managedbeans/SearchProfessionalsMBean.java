package com.reviewportal.webclient.web.managedbeans;

import java.util.ArrayList;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.faces.bean.ManagedBean;

import com.reviewportal.service.dto.ProfessionalDTO;
import com.reviewportal.service.dto.ProfessionDTO;
import com.reviewportal.service.dto.UserDTO;

@ManagedBean(name = "searchProfessionalsMBean")
public class SearchProfessionalsMBean extends AbstractMBean {

    private static final long serialVersionUID = -2350610396008037477L;

    private List<ProfessionalDTO> searchResult;

    @PostConstruct
    public void init() {
        
    }

    public List<ProfessionalDTO> getSearchResult() {
        return searchResult;
    }

    public void setSearchResult(List<ProfessionalDTO> pSearchResult) {
        searchResult = pSearchResult;
    }

}