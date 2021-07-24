package com.maoyan.itextproject;

import com.itextpdf.io.font.FontConstants;
import com.itextpdf.io.image.ImageDataFactory;
import com.itextpdf.kernel.color.Color;
import com.itextpdf.kernel.color.DeviceCmyk;
import com.itextpdf.kernel.font.PdfFont;
import com.itextpdf.kernel.font.PdfFontFactory;
import com.itextpdf.kernel.geom.PageSize;
import com.itextpdf.kernel.pdf.PdfDocument;
import com.itextpdf.kernel.pdf.PdfPage;
import com.itextpdf.kernel.pdf.PdfWriter;
import com.itextpdf.kernel.pdf.canvas.PdfCanvas;
import com.itextpdf.kernel.pdf.canvas.PdfCanvasConstants;
import com.itextpdf.layout.Document;
import com.itextpdf.layout.element.*;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

@SpringBootTest
class ItextProjectApplicationTests {
    
    private final  static String PATH = "/Users/user/ideaproject/study-project/itext-project/src/main/resources/pdf/" + System.currentTimeMillis() + ".pdf";
    
    
    public void test6() throws Exception {
        java.util.List<String> text = new ArrayList<>();
        text.add("         Episode V         ");
        text.add("  THE EMPIRE STRIKES BACK  ");
        text.add("It is a dark time for the");
        text.add("Rebellion. Although the Death");
        text.add("Star has been destroyed,");
        text.add("Imperial troops have driven the");
        text.add("Rebel forces from their hidden");
        text.add("base and pursued them across");
        text.add("the galaxy.");
        text.add("Evading the dreaded Imperial");
        text.add("Starfleet, a group of freedom");
        text.add("fighters led by Luke Skywalker");
        text.add("has established a new secret");
        text.add("base on the remote ice world");
        text.add("of Hoth...");
        File dest = new File(PATH);
        PdfWriter writer = new PdfWriter(dest);
        PdfDocument pdf = new PdfDocument(writer);
        PageSize ps = PageSize.A4.rotate();
        PdfPage page = pdf.addNewPage(ps);
        PdfCanvas canvas = new PdfCanvas(page);
        // 坐标原点设置
        canvas.concatMatrix(1, 0, 0, 1, 0, ps.getHeight());
        // 设置背景颜色
        canvas.rectangle(0, 0, ps.getWidth(), ps.getHeight())
                .setColor(Color.BLACK, true)
                .fill(); // 填充
    
        for (String s : text) {
            //Add text and move to the next line
            canvas.newlineShowText(s);
        }
        canvas.endText();
        pdf.close();
        
    }
    
    @Test
    public void test5() throws Exception {
        java.util.List<String> text = new ArrayList<>();
        text.add("         Episode V         ");
        text.add("  THE EMPIRE STRIKES BACK  ");
        text.add("It is a dark time for the");
        text.add("Rebellion. Although the Death");
        text.add("Star has been destroyed,");
        text.add("Imperial troops have driven the");
        text.add("Rebel forces from their hidden");
        text.add("base and pursued them across");
        text.add("the galaxy.");
        text.add("Evading the dreaded Imperial");
        text.add("Starfleet, a group of freedom");
        text.add("fighters led by Luke Skywalker");
        text.add("has established a new secret");
        text.add("base on the remote ice world");
        text.add("of Hoth...");
        File dest = new File(PATH);
        PdfWriter writer = new PdfWriter(dest);
        PdfDocument pdf = new PdfDocument(writer);
        PageSize ps = PageSize.A4.rotate();
        PdfPage page = pdf.addNewPage(ps);
        PdfCanvas canvas = new PdfCanvas(page);
        canvas.concatMatrix(1, 0, 0, 1, 0, ps.getHeight());
        canvas.beginText()
                .setFontAndSize(PdfFontFactory.createFont(FontConstants.COURIER_BOLD), 14)
                .setLeading(14 * 2f)// 行距
                .moveText(70, -40);// 左边距
        for (String s : text) {
            //Add text and move to the next line
            canvas.newlineShowText(s);
        }
        canvas.endText();
        pdf.close();
        
    }
    
    @Test
    public void test4() throws Exception {
        Color grayColor = new DeviceCmyk(0.f, 0.f, 0.f, 0.875f);
        Color greenColor = new DeviceCmyk(1.f, 0.f, 1.f, 0.176f);
        Color blueColor = new DeviceCmyk(1.f, 0.156f, 0.f, 0.118f);
        File dest = new File(PATH);
        PdfWriter writer = new PdfWriter(dest);
        PdfDocument pdf = new PdfDocument(writer);
        PageSize ps = PageSize.A4.rotate();
        PdfPage page = pdf.addNewPage(ps);
        PdfCanvas canvas = new PdfCanvas(page);
        canvas.setLineWidth(2).setStrokeColor(greenColor).setLineDash(10,10,8);
        // 行
        for (int i = 0; i < ps.getHeight(); i += 40) {
            // 画行
            canvas.moveTo(0, i)
                    .lineTo(ps.getWidth(), i);
        }
        // 列
        for (int j = 0; j < ps.getWidth(); j += 40) {
            canvas.moveTo(j, 0)
                    .lineTo(j, ps.getHeight());
        }
        canvas.stroke();
        pdf.close();
    }
    
    /**
     * 画坐标
     */
    @Test
    public void test3() throws Exception {
        File dest = new File(PATH);
        PdfWriter writer = new PdfWriter(dest);
        PdfDocument pdf = new PdfDocument(writer);
        PageSize ps = PageSize.A4.rotate();
        PdfPage page = pdf.addNewPage(ps);
        PdfCanvas canvas = new PdfCanvas(page);
        Color grayColor = new DeviceCmyk(0.f, 0.f, 0.f, 0.875f);
        Color greenColor = new DeviceCmyk(1.f, 0.f, 1.f, 0.176f);
        Color blueColor = new DeviceCmyk(1.f, 0.156f, 0.f, 0.118f);
        //Draw axes
        drawAxes(canvas, ps);
//                canvas.moveTo(-406, 0)
//                .lineTo(406, 0)
//                .stroke();
        pdf.close();
    }
    
    public static void drawAxes(PdfCanvas canvas, PageSize ps) {
        //Draw X axis
        System.out.println(ps.getWidth());
        System.out.println(ps.getHeight());
        canvas.moveTo(ps.getWidth() / 2, ps.getHeight() / 2)
                .lineTo(ps.getWidth() - 40, ps.getHeight() / 2)
                .stroke();
//        //Draw X axis arrow
        canvas.setLineJoinStyle(PdfCanvasConstants.LineJoinStyle.ROUND)
                .moveTo(ps.getWidth() - 40 - 15, ps.getHeight() / 2 + 15 )
                .lineTo(ps.getWidth() - 40 , ps.getHeight() / 2)
                .lineTo(ps.getWidth() - 40 - 15, ps.getHeight() / 2 - 15)
//                .lineTo(ps.getWidth() / 2, ps.getHeight() - 25)
                .stroke()
                .setLineJoinStyle(PdfCanvasConstants.LineJoinStyle.MITER);
        //Draw Y axis
//        canvas.moveTo(0, -(ps.getHeight() / 2 - 15))
//                .lineTo(0, ps.getHeight() / 2 - 15)
//                .stroke();
        //Draw Y axis arrow
//        canvas.saveState()
//                .setLineJoinStyle(PdfCanvasConstants.LineJoinStyle.ROUND)
//                .moveTo(-10, ps.getHeight() / 2 - 25)
//                .lineTo(0, ps.getHeight() / 2 - 15)
//                .lineTo(10, ps.getHeight() / 2 - 25).stroke()
//                .restoreState();
        //Draw X serif
        for (int i = (int)(ps.getWidth() / 2); i < ps.getWidth() - 40 ; i += 40) {
            canvas.moveTo(i, ps.getHeight() / 2 + 5).lineTo(i, ps.getHeight() / 2 - 5);
        }
//        //Draw Y serif
//        for (int j = -((int) ps.getHeight() / 2 - 57);
//             j < ((int) ps.getHeight() / 2 - 56); j += 40) {
//            canvas.moveTo(5, j).lineTo(-5, j);
//        }
        canvas.stroke();

    }

    
    @Test
    public void test2() throws Exception {
        File dest = new File(PATH);
        PdfWriter writer = new PdfWriter(dest);
        PdfDocument pdf = new PdfDocument(writer);
        Document document = new Document(pdf, PageSize.A4.rotate());
        document.setMargins(20, 20, 20, 20);
        PdfFont font = PdfFontFactory.createFont(FontConstants.HELVETICA);
        PdfFont bold = PdfFontFactory.createFont(FontConstants.HELVETICA_BOLD); //helvetica
        Table table = new Table(new float[]{4, 1, 3, 4, 3, 3, 3, 3, 1});
        table.setWidthPercent(100);
        BufferedReader br = new BufferedReader(new FileReader("/Users/user/ideaproject/study-project/itext-project/src/main/resources/img/united_states.cvs"));
        String line = br.readLine();
        process(table, line, bold, true);
        while ((line = br.readLine()) != null) {
            process(table, line, font, false);
        }
        br.close();
        document.add(table);
        document.close();
    }
    
    private void process(Table table, String line, PdfFont font, boolean isHeader) {
        StringTokenizer tokenizer = new StringTokenizer(line, ";");
        while (tokenizer.hasMoreTokens()) {
            if (isHeader) {
                table.addHeaderCell(
                        new Cell().add(
                                new Paragraph(tokenizer.nextToken()).setFont(font)));
            } else {
                table.addCell(
                        new Cell().add(
                                new Paragraph(tokenizer.nextToken()).setFont(font)));
            }
        }
    }
    
    
    
    @Test
    public void test() throws Exception {
        File dest = new File(PATH);
        PdfWriter pdfWriter = new PdfWriter(dest);
        PdfDocument pdf = new PdfDocument(pdfWriter);
        Document document = new Document(pdf);
        Image fox = new Image(ImageDataFactory.create("/Users/user/Pictures/71622374313_.pic.jpg"));
        Image dog = new Image(ImageDataFactory.create("/Users/user/Pictures/1491622438491_.pic_hd.jpg"));
        Paragraph p = new Paragraph("The quick brown ")
                .add(fox)
                .add(" jumps over the lazy ")
                .add(dog);
        document.add(p);
        document.close();
    }
    
    
    @Test
    public void rickaStleyTest() throws Exception {
        File dest = new File(PATH);
        PdfWriter pdfWriter = new PdfWriter(dest);
        PdfDocument pdf = new PdfDocument(pdfWriter);
        Document document = new Document(pdf);
        PdfFont font = PdfFontFactory.createFont(FontConstants.TIMES_ROMAN);
        document.add(new Paragraph("iText is:").setFont(font));
        // create a list
        List list = new List()
                .setSymbolIndent(12)
                .setListSymbol("\u2022")
                .setFont(font);
        // Add ListItem objects
        list.add(new ListItem("Never gonna give you up"))
                .add(new ListItem("Never gonna let you down"))
                .add(new ListItem("Never gonna run around and desert you"))
                .add(new ListItem("Never gonna make you cry"))
                .add(new ListItem("Never gonna say goodbye"))
                .add(new ListItem("Never gonna tell a lie and hurt you"));
        document.add(list);
        document.close();
    }
    
    @Test
    void contextLoads() throws FileNotFoundException {
        File dest = new File(PATH);
        PdfWriter writer = new PdfWriter(dest);
        PdfDocument pdf = new PdfDocument(writer);
        Document document = new Document(pdf);
        document.add(new Paragraph("Hello World!"));
        document.close();
    
    }
    
    
}
