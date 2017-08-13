package com.reviewportal.webclient.web.managedbeans;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.faces.bean.ManagedBean;

import com.reviewportal.service.dto.OfficialDTO;
import com.reviewportal.service.dto.ProfessionDTO;
import com.reviewportal.service.dto.ProfessionReviewDTO;
import com.reviewportal.service.dto.ReviewWriterDTO;
import com.reviewportal.service.dto.UserDTO;

@ManagedBean(name = "searchReviewsByMeMBean")
public class SearchReviewsByMeMBean extends AbstractMBean {

    private static final long serialVersionUID = -2350610396008037477L;

    private List<ProfessionReviewDTO> searchResult;

    @PostConstruct
    public void init() {
        mock();
    }

    private void mock() {
        searchResult = new ArrayList<>();
        for (int lI = 0; lI < 15; lI++) {

            OfficialDTO lOfficialDTO = new OfficialDTO();
            lOfficialDTO.setName("Professional" + "-" + lI+1);
            lOfficialDTO.setProfession(new ProfessionDTO());
            lOfficialDTO.getProfession().setTitle("Lawyer");
            lOfficialDTO.setUser(new UserDTO());
            lOfficialDTO.getUser().setEmail("prof" + "-" + lI + "@gmail.com");
            lOfficialDTO.getUser().setDisplayPicture("images/avatar" + lI % 5 + ".png");

            ProfessionReviewDTO lProfessionReviewDTO = new ProfessionReviewDTO();
            lProfessionReviewDTO.setCreatedDate(new Date());

            lProfessionReviewDTO.setReview("ghsd fsdkfhsd fsdkfhsd sd fsdf sdfs"
                    + "df sdfsdfsdf s"
                    + "df sdfsdf"
                    + "sd fsdaf sdfsdfjhsdf"
                    + " sfkjhjsdfjsdf"
                    + " ikhds hkjhfkdshklsd"
                    + "fsd gsdj gjfksk gkjhgdfghd"
                    + " sdgkhgdh lkndf "
                    + "df ghjhdkfglk dfh g"
                    + " oig sdh ls"
                    + "sd gjkds fgkd fg ...");

            lProfessionReviewDTO.setReviewAbout(lOfficialDTO);

            ReviewWriterDTO lReviewBy = new ReviewWriterDTO();
            lReviewBy.setName("Reviewer" + "-" + lI+1);
            lReviewBy.setUser(new UserDTO());
            lReviewBy.getUser().setEmail("rev" + "-" + lI + "@gmail.com");
            lReviewBy.getUser().setDisplayPicture("images/avatar" + lI % 5 + ".png");
            lProfessionReviewDTO.setReviewBy(lReviewBy);

            searchResult.add(lProfessionReviewDTO);

        }

    }

    public List<ProfessionReviewDTO> getSearchResult() {
        return searchResult;
    }

    public void setSearchResult(List<ProfessionReviewDTO> pSearchResult) {
        searchResult = pSearchResult;
    }

}