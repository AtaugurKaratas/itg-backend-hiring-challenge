package com.itg.supplychainmanagement.util;

import javax.servlet.http.Part;

public class ImageProcess {
    public String getFileName(Part part){
        String contentDisposition = part.getHeader("content-disposition");
        if(!contentDisposition.contains("filename="))
            return null;
        int beginIndex = contentDisposition.indexOf("filename=") + 10;
        int endIndex = contentDisposition.length() - 1;

        return contentDisposition.substring(beginIndex, endIndex);
    }
}
