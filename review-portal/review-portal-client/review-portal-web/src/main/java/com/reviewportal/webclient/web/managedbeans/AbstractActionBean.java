package com.reviewportal.webclient.web.managedbeans;

import java.util.List;
import java.util.stream.Collectors;

import javax.faces.model.SelectItem;

import org.apache.commons.lang3.StringUtils;

public abstract class AbstractActionBean extends AbstractMBean {

    private static final long serialVersionUID = 1564225107131672288L;

    protected AbstractViewBean parent;

    @SuppressWarnings("unchecked")
    public <T extends AbstractViewBean> T getParent() {
        return (T) parent;
    }

    public void setParent(AbstractViewBean parent) {
        this.parent = parent;
    }
    
    public List<String> autoCompleteProfession(String pInput) {

        List<SelectItem> lProfessions = getAppCacheBean().getProfessions();
        List<SelectItem> lFiltered = lProfessions.stream()
                .filter(p -> StringUtils.containsIgnoreCase(p.getLabel(), pInput)).collect(Collectors.toList());
        
        List<String> lMapped = lFiltered.stream().map(sc -> sc.getLabel()).collect(Collectors.toList());
        return lMapped;
    }
}
