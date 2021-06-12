package br.com.sobrevida.vacinaSARSCoV2.controller;

import br.com.sobrevida.vacinaSARSCoV2.model.CidadaoModel;
import br.com.sobrevida.vacinaSARSCoV2.model.dao.RelatorioDao;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import com.lowagie.text.Document;
import com.lowagie.text.DocumentException;
import com.lowagie.text.Paragraph;
import com.lowagie.text.pdf.PdfPCell;
import com.lowagie.text.pdf.PdfPTable;
import com.lowagie.text.pdf.PdfWriter;
import java.awt.Desktop;
import java.io.File;
import java.io.IOException;
import java.util.List;
import java.util.Random;

/**
 *
 * @author WERIKE
 */
public class RelatorioController{
    
    RelatorioDao relatorioDao = new RelatorioDao();
    
    public void teste() throws IOException{
        
        Document relatorio = new Document();
        Random random = new Random();
        
        int result = 2;
            
        for (int i = 0; i < 3; i++) {  
            int rand = random.nextInt(99);
            result = result * rand;
        }
        
        String arquivoPDF = "Relatório_"+result+".pdf";
        
        try{
            //new FileOutputStream("src\\resources\\relatorios\\Relatorio2.pdf")
            PdfWriter.getInstance(relatorio, new FileOutputStream("C:\\Users\\WERIKE\\Desktop\\RELATÓRIO DE CONTROLE DE APLICAÇÕES\\"+arquivoPDF));

            relatorio.open();

            Paragraph paragrafo = new Paragraph("RELATÓRIO DE CONTROLE DE APLICAÇÕES");
            paragrafo.setAlignment(1);
            relatorio.add(paragrafo);
            
            paragrafo = new Paragraph(" ");
            relatorio.add(paragrafo);
            
            PdfPTable tabela = new PdfPTable(5);

            PdfPCell coluna1 = new PdfPCell(new Paragraph("Código"));
            PdfPCell coluna2 = new PdfPCell(new Paragraph("Nome"));
            PdfPCell coluna3 = new PdfPCell(new Paragraph("E-Mail"));
            PdfPCell coluna4 = new PdfPCell(new Paragraph("Celular"));
            PdfPCell coluna5 = new PdfPCell(new Paragraph("Data segunda dose"));
           
            tabela.addCell(coluna1);
            tabela.addCell(coluna2);
            tabela.addCell(coluna3);
            tabela.addCell(coluna4);
            tabela.addCell(coluna5);
           
            List<CidadaoModel> cidadao = relatorioDao.gerarPDF();
            
            for(CidadaoModel cidadaoModel : cidadao){
                coluna1 = new PdfPCell(new Paragraph(cidadaoModel.getIdCidadao()+""));
                coluna2 = new PdfPCell(new Paragraph(cidadaoModel.getNome()));
                coluna3 = new PdfPCell(new Paragraph(cidadaoModel.getEmail()));
                coluna4 = new PdfPCell(new Paragraph(cidadaoModel.getCelular()));
                //coluna5 = new PdfPCell(new Paragraph(cidadaoModel.getSegunda()));

                tabela.addCell(coluna1);
                tabela.addCell(coluna2);
                tabela.addCell(coluna3);
                tabela.addCell(coluna4);
                tabela.addCell(coluna5);
            }
            
            relatorio.add(tabela);
            relatorio.close();
            Desktop.getDesktop().open(new File("C:\\Users\\WERIKE\\Desktop\\RELATÓRIO DE CONTROLE DE APLICAÇÕES\\"+arquivoPDF));

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