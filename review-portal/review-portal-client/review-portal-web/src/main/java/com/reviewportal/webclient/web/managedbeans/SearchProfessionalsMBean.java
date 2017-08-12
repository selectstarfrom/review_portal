package com.reviewportal.webclient.web.managedbeans;

import java.util.ArrayList;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.faces.bean.ManagedBean;

import com.reviewportal.service.dto.OfficialDTO;
import com.reviewportal.service.dto.ProfessionDTO;
import com.reviewportal.service.dto.UserDTO;

@ManagedBean(name = "searchProfessionalsMBean")
public class SearchProfessionalsMBean extends AbstractMBean {

    private static final long serialVersionUID = -2350610396008037477L;

    private List<OfficialDTO> searchResult;

    @PostConstruct
    public void init() {
        mock();
    }

    private void mock() {
        searchResult = new ArrayList<>();
        for (int lI = 0; lI < 15; lI++) {
            OfficialDTO lOfficialDTO = new OfficialDTO();
            lOfficialDTO.setName("Professional" + "-" + lI);
            lOfficialDTO.setProfession(new ProfessionDTO());
            lOfficialDTO.getProfession().setTitle("Lawyer");
            lOfficialDTO.setUser(new UserDTO());
            lOfficialDTO.getUser().setEmail("prof" + "-" + lI + "@gmail.com");
            lOfficialDTO.getUser().setDisplayPicture("images/avatar" + lI % 5 + ".png");
            searchResult.add(lOfficialDTO);

        }

    }

    public List<OfficialDTO> getSearchResult() {
        return searchResult;
    }

    public void setSearchResult(List<OfficialDTO> pSearchResult) {
        searchResult = pSearchResult;
    }

}