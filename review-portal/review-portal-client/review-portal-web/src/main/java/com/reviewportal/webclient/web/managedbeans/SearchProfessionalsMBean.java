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
        mock();
    }

    private void mock() {
        searchResult = new ArrayList<>();
        for (int lI = 0; lI < 15; lI++) {
            ProfessionalDTO lProfessionalDTO = new ProfessionalDTO();
            lProfessionalDTO.setName("Professional" + "-" + lI);
            lProfessionalDTO.setProfession(new ProfessionDTO());
            lProfessionalDTO.getProfession().setTitle("Lawyer");
            lProfessionalDTO.setUser(new UserDTO());
            lProfessionalDTO.getUser().setEmail("prof" + "-" + lI + "@gmail.com");
            lProfessionalDTO.getUser().setDisplayPicture("images/avatar" + lI % 5 + ".png");
            searchResult.add(lProfessionalDTO);

        }

    }

    public List<ProfessionalDTO> getSearchResult() {
        return searchResult;
    }

    public void setSearchResult(List<ProfessionalDTO> pSearchResult) {
        searchResult = pSearchResult;
    }

}