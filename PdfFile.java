package PdfReadWrite;

import org.apache.pdfbox.pdmodel.PDDocument;
import org.apache.pdfbox.pdmodel.PDPage;

import java.io.File;
import java.io.IOException;

public class PdfFile {
    public static void main(String[] args) throws IOException {
        PDDocument pdDocument = new PDDocument();
//        try{
//            pdDocument.addPage(new PDPage());
//            pdDocument.save("Pdf/test.pdf");
//        }catch (IOException e){
//            e.printStackTrace();
//        }
        pdDocument.addPage(new PDPage());
        pdDocument.save("Pdf/test.pdf");
        pdDocument.close();

        File file = new File("D:\\Java Practice\\Pdf\\old.pdf");
        PDDocument pddoc = PDDocument.load(file);
//        pddoc.addPage(new PDPage());
//        pddoc.save("Pdf/old_copy.pdf");
//        pddoc.close();

        int fromPage=20;
        int deletePage = 50;

        for(int i=fromPage;i<=deletePage;i++){
            pddoc.removePage(i);
        }
        pddoc.save("Pdf/old_After_delete.pdf");
        pddoc.close();


    }
}
