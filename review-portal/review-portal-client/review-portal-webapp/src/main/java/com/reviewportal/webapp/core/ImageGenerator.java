package com.reviewportal.webapp.core;

import java.io.IOException;
import java.util.Base64;

//@Component
public class ImageGenerator {

    public String getProfileImage(byte[] pBytes) throws IOException {
        
        if(pBytes!=null){
            String lEncodeBase64URLSafeString = Base64.getEncoder().encodeToString(pBytes);
            return "data:image/png;base64,"+lEncodeBase64URLSafeString;
        }

        return null;

        
    }

    public long getDate() {
        return System.currentTimeMillis();
    }
}