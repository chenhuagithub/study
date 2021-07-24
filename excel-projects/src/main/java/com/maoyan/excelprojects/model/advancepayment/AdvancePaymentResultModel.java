package com.maoyan.excelprojects.model.advancepayment;

import com.alibaba.excel.annotation.ExcelProperty;
import com.alibaba.excel.annotation.write.style.*;
import lombok.Data;
import org.apache.poi.ss.usermodel.BorderStyle;

/**
 * @author chenhua11
 * @date 2021/7/21  3:33 下午
 */

@Data
@HeadRowHeight(50)
@ColumnWidth(17)
@HeadStyle(borderLeft = BorderStyle.NONE, borderRight = BorderStyle.NONE, borderTop = BorderStyle.NONE, borderBottom = BorderStyle.NONE)
@ContentFontStyle(fontHeightInPoints = 8, fontName = "微軟正黑體")
@HeadFontStyle(fontHeightInPoints = 8, fontName = "微軟正黑體")
public class AdvancePaymentResultModel {
    
    @ExcelProperty("Event")
    private String eventNameEn;
    
    @ExcelProperty("Account Code")
    private String accountCode;
    
    @ExcelProperty("Venue")
    private String venueNameEn;
    
    @ExcelProperty("Venue Facility")
    private String venueFacilityNameEn;
    
    @ExcelProperty("Payment Type")
    private String paymentTypeCode;
    
    @ExcelProperty("Amount($)")
    private String amount;
    
    @ExcelProperty("Total %")
    private String total;
    
    @ExcelProperty("Commission Rate")
    private String commissionRate;
    
    @ExcelProperty("Commission($)")
    private String commission;
    
    @ExcelProperty("Net Amount for Payment Type($)")
    private String netAmountPayment;
    
}