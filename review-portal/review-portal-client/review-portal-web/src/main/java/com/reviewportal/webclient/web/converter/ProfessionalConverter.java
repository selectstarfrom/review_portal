package com.reviewportal.webclient.web.converter;

import java.util.List;
import java.util.stream.Collectors;

import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import javax.faces.convert.Converter;
import javax.faces.convert.FacesConverter;

import com.reviewportal.service.dto.ProfessionalDTO;

@FacesConverter("professionalConverter")
public class ProfessionalConverter implements Converter {

    public ProfessionalConverter() {
        super();
    }

    @SuppressWarnings({ "unchecked", "null" })
    public Object getAsObject(FacesContext fc, UIComponent uic, String pValue) {

        List<ProfessionalDTO> lProfessionals = (List<ProfessionalDTO>) uic.getAttributes().get("filteredProfessionals");
        if (lProfessionals != null && pValue != null && !"".equals(pValue)) {
            Long lLong = Long.parseLong(pValue);
            List<ProfessionalDTO> lCollect = lProfessionals.stream().filter(p -> p.getId().equals(lLong))
                    .collect(Collectors.toList());
            if (lCollect != null) {
                return lCollect.get(0);
            }
        }
        return null;
    }

    public String getAsString(FacesContext fc, UIComponent uic, Object object) {
        if (object != null) {
            if (object instanceof ProfessionalDTO) {
                return String.valueOf(((ProfessionalDTO) object).getId());
            }
            return String.valueOf(object);
        } else {
            return null;
        }
    }
}