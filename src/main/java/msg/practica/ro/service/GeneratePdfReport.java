package msg.practica.ro.service;

import com.itextpdf.text.*;
import com.itextpdf.text.pdf.PdfWriter;
import msg.practica.ro.model.Apartment;
import org.apache.tomcat.util.http.fileupload.ByteArrayOutputStream;
import org.springframework.stereotype.Service;

import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.net.URL;
import java.util.List;

@Service
public class GeneratePdfReport {

    public static ByteArrayInputStream generatePdf(List<Apartment> apartments) throws DocumentException, IOException {
        Font details = FontFactory.getFont(FontFactory.TIMES, 14, Font.BOLD, BaseColor.BLACK);
        Document document = new Document();
        ByteArrayOutputStream out = new ByteArrayOutputStream();
        PdfWriter.getInstance(document, out);

        Font font = FontFactory.getFont(FontFactory.COURIER, 12, BaseColor.BLACK);
        int current = 1;
        document.open();
        for (Apartment a : apartments) {

            if (current != 1) {
                Paragraph chunk = new Paragraph("........................................................................\n", font);
                document.add(chunk);
            }
            Paragraph paragraph0 = new Paragraph("Apartment " + current + " Details", details);
            Paragraph paragraph1 = new Paragraph(a.toString(), font);
            String imageUrl = a.getPictures().get(0).getUrl();
            Image image2 = Image.getInstance(new URL(imageUrl));
            image2.scaleAbsolute(256, 144);
            Paragraph paragraph3 = new Paragraph("Owner Details", details);
            Paragraph paragraph2 = new Paragraph(a.getOwner().toString(), font);
            current++;

            document.add(paragraph0);
            document.add(paragraph1);
            document.add(image2);
            document.add(paragraph3);
            document.add(paragraph2);
        }
        document.close();
        return new ByteArrayInputStream(out.toByteArray());
    }
}
