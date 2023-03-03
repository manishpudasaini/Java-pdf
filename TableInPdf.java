package PdfReadWrite;

import org.apache.pdfbox.pdmodel.PDDocument;
import org.apache.pdfbox.pdmodel.PDPage;
import org.apache.pdfbox.pdmodel.PDPageContentStream;
import org.apache.pdfbox.pdmodel.font.PDType1Font;

import java.awt.*;
import java.io.IOException;

public class TableInPdf {
    public static void main(String[] args) throws IOException {
       try(PDDocument pdDocument = new PDDocument()){
           PDPage page = new PDPage();
           pdDocument.addPage(page);

           PDPageContentStream pcs  =new PDPageContentStream(pdDocument,page);

           //pcs.setStrokingColor(Color.blue); //color of line
           //pcs.setLineWidth(1f);  //it will increase the width of the line

           int pageHeight = (int) page.getTrimBox().getHeight();

           int rowCount = 7;
           int colCount = 5;

           int cellHeight = 50;
           int cellWidth = 100;

           int xcord = 10;
           int ycord = pageHeight-(xcord+cellHeight);

           for(int i=1;i<=rowCount;i++){
               for(int j=1;j<=colCount;j++){
                   pcs.addRect(xcord,ycord,cellWidth,cellHeight);

                   pcs.beginText();
                   pcs.setFont(PDType1Font.TIMES_ITALIC,18);
                   pcs.newLineAtOffset(xcord+10,ycord+10);
                   String text = "Ronaldo";
                   pcs.showText(text);
                   pcs.endText();

                   xcord += cellWidth;
               }
               xcord = 10;
               ycord -= cellHeight;
           }

//           pcs.addRect(10,pageHeight-200,200,140);
//           pcs.addRect(10,pageHeight-200,100,140);

           pcs.stroke();
           pcs.close();
           pdDocument.save("Pdf/Table1.pdf");
       }
       catch (IOException exception){
           exception.printStackTrace();
       }

    }
}
