package com.reviewportal.webclient.web.converter;

import java.util.List;
import java.util.stream.Collectors;

import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import javax.faces.convert.Converter;
import javax.faces.convert.FacesConverter;

import com.reviewportal.service.dto.OfficialDTO;

@FacesConverter("professionalConverter")
public class ProfessionalConverter implements Converter {

    public ProfessionalConverter() {
        super();
    }

    @SuppressWarnings({ "unchecked", "null" })
    public Object getAsObject(FacesContext fc, UIComponent uic, String pValue) {

        List<OfficialDTO> lOfficials = (List<OfficialDTO>) uic.getAttributes().get("filteredProfessionals");
        if (lOfficials != null && pValue != null && !"".equals(pValue)) {
            Long lLong = Long.parseLong(pValue);
            List<OfficialDTO> lCollect = lOfficials.stream().filter(p -> p.getId().equals(lLong))
                    .collect(Collectors.toList());
            if (lCollect != null) {
                return lCollect.get(0);
            }
        }
        return null;
    }

    public String getAsString(FacesContext fc, UIComponent uic, Object object) {
        if (object != null) {
            if (object instanceof OfficialDTO) {
                return String.valueOf(((OfficialDTO) object).getId());
            }
            return String.valueOf(object);
        } else {
            return null;
        }
    }
}