package PdfReadWrite;

import org.apache.pdfbox.pdmodel.PDDocument;
import org.apache.pdfbox.pdmodel.PDPage;
import org.apache.pdfbox.pdmodel.PDPageContentStream;
import org.apache.pdfbox.pdmodel.graphics.image.PDImageXObject;

import java.io.IOException;

public class ImageInPdf {
    public static void main(String[] args)  {
       try ( PDDocument pdDocument = new PDDocument()){
           PDPage page = new PDPage();

           pdDocument.addPage(page);

           PDPageContentStream pcs  =new PDPageContentStream(pdDocument,page);
           PDImageXObject image = PDImageXObject.createFromFile("Pdf/1.png",pdDocument);

           int pageHeight = (int)page.getTrimBox().getHeight();

           pcs.drawImage(image,0,30);

           //to write the text over image
//           pcs.beginText();
//           pcs.newLineAtOffset(20,40);
//           pcs.showText("Manish");
//           pcs.endText();

           pcs.close();

           pdDocument.save("Pdf/Image.pdf");
           System.out.println("Pdf name image.pdf was made");

       }
       catch (IOException exception){
           exception.printStackTrace();
       }


    }
}
