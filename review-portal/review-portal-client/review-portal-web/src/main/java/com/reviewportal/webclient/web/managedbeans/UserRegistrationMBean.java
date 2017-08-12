package com.reviewportal.webclient.web.managedbeans;

import java.awt.image.BufferedImage;
import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.File;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;
import javax.imageio.ImageIO;

import org.primefaces.model.DefaultStreamedContent;
import org.primefaces.model.StreamedContent;

import com.reviewportal.service.dto.OfficialDTO;
import com.reviewportal.service.dto.ProfessionDTO;
import com.reviewportal.service.dto.UserDTO;
import com.reviewportal.webclient.web.images.StyleImages;

@ManagedBean(name = "userRegistrationMBean")
@ViewScoped
public class UserRegistrationMBean extends AbstractMBean {

    private static final long serialVersionUID = -2350610396008037477L;

    private StreamedContent graphicText;

    private List<OfficialDTO> searchResult;

    @PostConstruct
    public void init() {
        try {
            mock();
        } catch (Exception e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
    }

    private void mock() throws Exception {

        ClassLoader lClassLoader = StyleImages.class.getClassLoader();
        URL lResource = lClassLoader.getResource("/profle_pic.png");
        File imgPath = new File(lResource.getPath());

        BufferedImage bufferedImage = ImageIO.read(imgPath);

        ByteArrayOutputStream os = new ByteArrayOutputStream();
        ImageIO.write(bufferedImage, "png", os);
        graphicText = new DefaultStreamedContent(new ByteArrayInputStream(os.toByteArray()), "image/png");

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

    public StreamedContent getGraphicText() {
        return graphicText;
    }

    public void setGraphicText(StreamedContent pGraphicText) {
        graphicText = pGraphicText;
    }

}