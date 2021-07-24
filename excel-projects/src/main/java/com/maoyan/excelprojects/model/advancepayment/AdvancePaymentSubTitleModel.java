package com.maoyan.excelprojects.model.advancepayment;

import com.alibaba.excel.annotation.ExcelProperty;
import com.alibaba.excel.annotation.write.style.*;
import lombok.Data;
import org.apache.poi.ss.usermodel.FillPatternType;

/**
 * @author chenhua11
 * @date 2021/7/22  9:12 上午
 */
@Data
@HeadRowHeight(30)
@ColumnWidth(17)
@ContentRowHeight(13)
public class AdvancePaymentSubTitleModel {
    
    @ExcelProperty(" ")
    @HeadFontStyle(fontHeightInPoints = 13, fontName = "微軟正黑體")
    @ContentFontStyle(fontHeightInPoints = 11, fontName = "微軟正黑體", bold = true)
    @HeadStyle(fillPatternType = FillPatternType.NO_FILL) // 设置背景颜色
    @ContentLoopMerge(eachRow = 1, columnExtend = 2)
    private String title;
    
    @ExcelProperty(value = " ", index = 2)
    @ContentFontStyle(fontHeightInPoints = 8, fontName = "微軟正黑體")
    private String content;
}