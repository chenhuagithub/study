package com.maoyan.excelprojects.model.advancepayment;

import com.alibaba.excel.annotation.ExcelProperty;
import com.alibaba.excel.annotation.write.style.*;
import lombok.Data;
import org.apache.poi.ss.usermodel.BorderStyle;

/**
 * @author chenhua11
 * @date 2021/7/21  4:05 下午
 */
@Data
@HeadRowHeight(50)
@ColumnWidth(17)
@HeadStyle(borderLeft = BorderStyle.NONE, borderRight = BorderStyle.NONE, borderTop = BorderStyle.NONE, borderBottom = BorderStyle.NONE)
@ContentFontStyle(fontHeightInPoints = 8, fontName = "微軟正黑體")
@HeadFontStyle(fontHeightInPoints = 8, fontName = "微軟正黑體")
public class AdvancePaymentSummaryResultModel {
    
    @ExcelProperty("Event")
    private String eventNameEn;
    
    @ExcelProperty("No. of Performance")
    private Long performanceTotal;
    
    @ExcelProperty("Grand Total")
    private String grandTotal;
    
    @ExcelProperty("Total Commission")
    private String commissionsTotal;
    
    @ExcelProperty("Total Net")
    private String netTotal;
    
    @ExcelProperty("Total Commission (by perf breakdown)")
    private String commissionsTotalByPerf;
    
    @ExcelProperty("Total Net (by perf breakdown)")
    private String netTotalByPerf;
}