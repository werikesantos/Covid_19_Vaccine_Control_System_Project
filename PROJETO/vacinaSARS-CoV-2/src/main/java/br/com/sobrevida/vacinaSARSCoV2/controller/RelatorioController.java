package br.com.sobrevida.vacinaSARSCoV2.controller;

import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import com.lowagie.text.Document;
import com.lowagie.text.DocumentException;
import com.lowagie.text.Paragraph;
import com.lowagie.text.pdf.PdfWriter;
import java.util.Random;

/**
 *
 * @author WERIKE
 */
public class RelatorioController {
    
    public void teste(){
        
        Document relatorio = new Document();
        Random random = new Random();
        
        String frase = "Olá, Mundo!";
        
        int result = 2;
        
        for (int i = 0; i < 3; i++) {  
            int rand = random.nextInt(99);
            result = result * rand;
        }
        
        try{
            //new FileOutputStream("src\\resources\\relatorios\\Relatorio2.pdf")

            PdfWriter.getInstance(relatorio, new FileOutputStream("C:\\Users\\WERIKE\\Desktop\\RELATÓRIO DE CONTROLE DE APLICAÇÕES\\Relatorio"+result+".pdf"));

            relatorio.open();

            Paragraph paragrafoTeste = new Paragraph(frase);

            relatorio.add(paragrafoTeste);

        }catch (DocumentException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }catch (FileNotFoundException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
        relatorio.close();
    }
}