package com.maoyan.excelprojects.service;

import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public interface AdvancePaymentService {
    
    void downloadExcel(HttpServletResponse response) throws IOException;
}
