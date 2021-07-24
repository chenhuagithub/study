package com.maoyan.excelprojects;

import com.alibaba.excel.EasyExcel;
import com.alibaba.excel.ExcelWriter;
import com.alibaba.excel.write.metadata.WriteSheet;
import com.alibaba.excel.write.metadata.WriteTable;
import com.maoyan.excelprojects.model.advancepayment.AdvancePaymentResultModel;
import com.maoyan.excelprojects.model.advancepayment.AdvancePaymentSubTitleModel;
import com.maoyan.excelprojects.model.advancepayment.AdvancePaymentSummaryResultModel;
import com.maoyan.excelprojects.model.advancepayment.AdvancePaymentTitleModel;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @author chenhua11
 * @date 2021/7/21  2:35 下午
 */
public class AdvancePaymentExcelTest extends ExcelProjectsApplicationTests {
    
    private static final String prefixPath = "/Users/user/ideaproject/study-project/excel-projects/src/main/resources/advancepayment/";
    
    @Test
    public void test1() {
        List<String> res = Arrays.asList("1", "2", "3", "4");
        String join = String.join(",", res);
        System.out.println(join);
    }
    
    @Test
    public void writeTest() {
        String fileName = prefixPath + System.currentTimeMillis() + ".xlsx";
        ExcelWriter excelWriter = null;
        try {
            excelWriter = EasyExcel.write(fileName).build();
            // 把sheet设置为不需要头 不然会输出sheet的头 这样看起来第一个table 就有2个头了
            WriteSheet advancePaymentSheet = EasyExcel.writerSheet("Advance Payment").needHead(Boolean.FALSE).build();
            WriteSheet advancePaymentSummarySheet = EasyExcel.writerSheet("Summary").needHead(Boolean.FALSE).build();
            
            // 这里必须指定需要头，table 会继承sheet的配置，sheet配置了不需要，table 默认也是不需要
            WriteTable advancePaymentTitleTable0 = EasyExcel.writerTable(0).head(AdvancePaymentTitleModel.class).needHead(Boolean.TRUE).build();
            WriteTable advancePaymentSubTitleTable0 = EasyExcel.writerTable(1).head(AdvancePaymentSubTitleModel.class).needHead(Boolean.FALSE).build();
            WriteTable advancePaymentTable0 = EasyExcel.writerTable(2).head(AdvancePaymentResultModel.class).needHead(Boolean.TRUE).build();
            WriteTable advancePaymentSummaryTable0 = EasyExcel.writerTable(3).head(AdvancePaymentSummaryResultModel.class).needHead(Boolean.TRUE).build();
            // 第一次写入会创建头
            List<AdvancePaymentSubTitleModel> advancePaymentModelList = new ArrayList<>();
            AdvancePaymentSubTitleModel advancePaymentModel1 = new AdvancePaymentSubTitleModel();
            advancePaymentModel1.setTitle("Searching Criteria:");
            advancePaymentModel1.setContent("Event Synonym = LC19MRN1, ");
            AdvancePaymentSubTitleModel advancePaymentModel2 = new AdvancePaymentSubTitleModel();
            advancePaymentModel2.setTitle("Print Date:");
            advancePaymentModel2.setContent("2020/10/23 14:11");
            AdvancePaymentSubTitleModel advancePaymentModel3 = new AdvancePaymentSubTitleModel();
            advancePaymentModel3.setTitle("");
            advancePaymentModel3.setContent("");
            advancePaymentModelList.add(advancePaymentModel1);
            advancePaymentModelList.add(advancePaymentModel2);
            advancePaymentModelList.add(advancePaymentModel3);
            
            excelWriter.write(null, advancePaymentSheet, advancePaymentTitleTable0);
            excelWriter.write(null, advancePaymentSummarySheet, advancePaymentTitleTable0);
            
            excelWriter.write(advancePaymentModelList, advancePaymentSheet, advancePaymentSubTitleTable0);
            excelWriter.write(advancePaymentModelList, advancePaymentSummarySheet, advancePaymentSubTitleTable0);
            
//            // 第二次写如也会创建头，然后在第一次的后面写入数据
            List<AdvancePaymentResultModel> advancePaymentDataModels = getAdvancePaymentDataModelData();
            excelWriter.write(advancePaymentDataModels, advancePaymentSheet, advancePaymentTable0);
            
            List<AdvancePaymentSummaryResultModel> advancePaymentSummaryResultModelData = getAdvancePaymentSummaryResultModelData();
            excelWriter.write(advancePaymentSummaryResultModelData, advancePaymentSummarySheet, advancePaymentSummaryTable0);
        } finally {
            // 千万别忘记finish 会帮忙关闭流
            if (excelWriter != null) {
                excelWriter.finish();
            }
        }
    }
    
    private List<AdvancePaymentResultModel> getAdvancePaymentDataModelData() {
        List<AdvancePaymentResultModel> res = new ArrayList<>();
        for (int i = 0; i < 30; i++) {
            AdvancePaymentResultModel model = new AdvancePaymentResultModel();
            model.setEventNameEn("eventName" + i);
            model.setAccountCode("accountCode" + i);
            model.setVenueNameEn("venue" + i);
            model.setVenueFacilityNameEn("venueFacility" + i);
            model.setPaymentTypeCode("paymentTypeCode" + i);
            model.setAmount("amount" + i);
            model.setTotal("total" + i);
            model.setCommissionRate("commissionRate" + i);
            model.setCommission("commission" + i);
            model.setNetAmountPayment("netAmount" + i);
            res.add(model);
        }
        return res;
    }
    
    
    private List<AdvancePaymentSummaryResultModel> getAdvancePaymentSummaryResultModelData() {
        List<AdvancePaymentSummaryResultModel> res = new ArrayList<>();
        for (int i = 0; i < 20; i++) {
            AdvancePaymentSummaryResultModel model = new AdvancePaymentSummaryResultModel();
            model.setEventNameEn("event" + i);
            model.setPerformanceTotal((long)(1000 * i));
            model.setGrandTotal("grandTotal" + i);
            model.setCommissionsTotal("totalCommission" + i);
            model.setNetTotal("totalNet" + i);
            model.setCommissionsTotalByPerf("byPerf" + i);
            model.setNetTotalByPerf("byPerf" + i);
            res.add(model);
        }
        return res;
    }
    
    
}