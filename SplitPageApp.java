package PdfReadWrite;

import org.apache.pdfbox.multipdf.Splitter;
import org.apache.pdfbox.pdmodel.PDDocument;

import java.io.File;
import java.io.IOException;
import java.util.List;

public class SplitPageApp {
    public static void main(String[] args) {
        File file = new File("D:\\Java Practice\\Pdf\\old.pdf");
        try (PDDocument pdDocument = PDDocument.load(file)){
            Splitter split = new Splitter();
            split.setStartPage(10);
            split.setEndPage(20);

            List<PDDocument> pages = split.split(pdDocument);

            int num=1;
           PDDocument pdDocument1 = new PDDocument();
            for(PDDocument docs:pages){
                docs.save("Pdf/out/split_"+ num++ +".pdf");
                pdDocument1.addPage(docs.getPage(0));
            }
            pdDocument1.save("Pdf/out/combineFile.pdf");

        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
