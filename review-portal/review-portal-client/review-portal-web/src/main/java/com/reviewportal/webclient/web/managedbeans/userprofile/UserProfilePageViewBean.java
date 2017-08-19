package com.reviewportal.webclient.web.managedbeans.userprofile;

import java.awt.image.BufferedImage;
import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.IOException;
import java.net.URL;

import javax.annotation.PostConstruct;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;
import javax.imageio.ImageIO;

import org.primefaces.model.DefaultStreamedContent;

import com.reviewportal.model.enums.MembershipType;
import com.reviewportal.service.dto.AbstractMemberDTO;
import com.reviewportal.service.dto.ProfessionalDTO;
import com.reviewportal.service.dto.ReviewWriterDTO;
import com.reviewportal.service.dto.UserDTO;
import com.reviewportal.webclient.web.core.PropertyAccessor;
import com.reviewportal.webclient.web.core.ViewAction;
import com.reviewportal.webclient.web.images.StyleImages;
import com.reviewportal.webclient.web.managedbeans.AbstractViewBean;

/**
 * @author imfroz
 *
 */
@ManagedBean(name = "userProfilePageViewBean")
@ViewScoped
@PropertyAccessor(className = UserProfilePageAccessor.class)
@ViewAction(className = UserProfileActionBean.class)
public class UserProfilePageViewBean extends AbstractViewBean {

    private static final long serialVersionUID = -5074205979854831291L;

    @PostConstruct
    public void init() {
        super.init();
        //mock();
        UserDTO lLoggedInUser = getLoggedInUser();

        Long lLoggedInUserId = lLoggedInUser.getId();
        String lUserTypeName = lLoggedInUser.getUserType().name();
        if (lUserTypeName.equals(MembershipType.PROFESSIONAL.name())) {
            ProfessionalDTO lProfessionalDTO = getAccessor().getEmployeeMemberService().getByUserId(lLoggedInUserId);
            getAccessor().setMember(lProfessionalDTO);
        } else if (lUserTypeName.equals(MembershipType.REVIEW_WRITER.name())) {
            ReviewWriterDTO lReviewWriterDTO = getAccessor().getReviewWriterMemberService()
                    .getByUserId(lLoggedInUserId);
            getAccessor().setMember(lReviewWriterDTO);
        }

        getAccessor().setEditProfileEnabled(false);

    }

    public AbstractMemberDTO getNewSignupReviewWriterInstance() {
        ReviewWriterDTO lInstance = new ReviewWriterDTO();
        return lInstance;
    }

    public UserDTO getNewSignInUserInstance() {
        UserDTO lInstance = new UserDTO();
        return lInstance;
    }

    public AbstractMemberDTO getNewSignupProfessionalInstance() {

        ProfessionalDTO lInstance = new ProfessionalDTO();

        return lInstance;
    }

    private void mock() {

        try {
            
            ClassLoader classLoader = getClass().getClassLoader();
            File imgPath = new File(classLoader.getResource("profile_pic.png").getFile());
            
            //URL lResource = StyleImages.class.getResource("profile_pic.png");
            //File imgPath = new File(lResource.getPath());

            BufferedImage bufferedImage;

            bufferedImage = ImageIO.read(imgPath);

            ByteArrayOutputStream os = new ByteArrayOutputStream();
            ImageIO.write(bufferedImage, "png", os);
            getAccessor().setGraphicText(
                    new DefaultStreamedContent(new ByteArrayInputStream(os.toByteArray()), "image/png"));
        } catch (Exception e) {
            logger.error("IMAGE NOT-FOUND: profile_pic.png");
            System.out.println("------------------IMAGE NOT-FOUND: profile_pic.png");
        }

    }

    @Override
    public UserProfilePageAccessor getAccessor() {
        return (UserProfilePageAccessor) this.accessor;
    }

    @Override
    public UserProfileActionBean getActions() {
        return (UserProfileActionBean) super.actions;
    }

}