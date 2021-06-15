package br.com.sobrevida.vacinaSARSCoV2.controller;

import br.com.sobrevida.vacinaSARSCoV2.model.CidadaoModel;
import br.com.sobrevida.vacinaSARSCoV2.model.dao.RelatorioDao;
import br.com.sobrevida.vacinaSARSCoV2.model.dao.UsuarioDao;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import com.lowagie.text.Document;
import com.lowagie.text.DocumentException;
import com.lowagie.text.Image;
import com.lowagie.text.Paragraph;
import com.lowagie.text.pdf.PdfPCell;
import com.lowagie.text.pdf.PdfPTable;
import com.lowagie.text.pdf.PdfWriter;
import java.awt.Desktop;
import java.io.File;
import java.sql.Date;
import java.io.IOException;
import java.sql.SQLException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.List;
import java.util.Random;
import javax.swing.JFormattedTextField;
import javax.swing.JLabel;

/**
 *
 * @author WERIKE
 */
public class RelatorioController{
    
    RelatorioDao relatorioDao = new RelatorioDao();
    
    public void gerarPDF(JFormattedTextField de, JFormattedTextField para, JLabel imprimirCarregar) throws IOException, SQLException, ParseException{
        
        String usuario = UsuarioDao.nome;
        
        String dePegar = de.getText(); 
        String paraPegar = para.getText();
        
        SimpleDateFormat format = new SimpleDateFormat("dd/MM/yyyy");
        Date deData = new Date(format.parse(dePegar).getTime());
        Date paraData = new Date(format.parse(paraPegar).getTime());

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
            
            Image logoTipo1 = Image.getInstance("src/main/resources/image/relatorioBranco.png");
            relatorio.add(logoTipo1);

            Paragraph paragrafo0 = new Paragraph("Cod. "+result);
            paragrafo0.setAlignment(2);
            relatorio.add(paragrafo0);
            
            Paragraph paragrafo1 = new Paragraph("De "+dePegar+" Para "+paraPegar);
            paragrafo1.setAlignment(2);
            relatorio.add(paragrafo1);
            
            Paragraph paragrafo2 = new Paragraph("Responsável: "+usuario);
            paragrafo2.setAlignment(2);
            relatorio.add(paragrafo2);
            
            Paragraph paragrafo3 = new Paragraph(" ");
            paragrafo3.setAlignment(2);
            relatorio.add(paragrafo3);
            
            Paragraph paragrafo4 = new Paragraph("RELATÓRIO DE CONTROLE DE APLICAÇÕES");
            paragrafo4.setAlignment(1);
            relatorio.add(paragrafo4);
            
            paragrafo4 = new Paragraph(" ");
            relatorio.add(paragrafo4);
            
            PdfPTable tabela = new PdfPTable(5);

            PdfPCell coluna1 = new PdfPCell(new Paragraph("CÓDIGO"));
            PdfPCell coluna2 = new PdfPCell(new Paragraph("NOME"));
            PdfPCell coluna3 = new PdfPCell(new Paragraph("E-MAIL"));
            PdfPCell coluna4 = new PdfPCell(new Paragraph("CELULAR"));
            PdfPCell coluna5 = new PdfPCell(new Paragraph("PREVISÃO"));
           
            tabela.addCell(coluna1);
            tabela.addCell(coluna2);
            tabela.addCell(coluna3);
            tabela.addCell(coluna4);
            tabela.addCell(coluna5);
           
            List<CidadaoModel> cidadao = relatorioDao.gerarPDF(deData, paraData);
            
            for(CidadaoModel cidadaoModel : cidadao){
                coluna1 = new PdfPCell(new Paragraph(cidadaoModel.getId()+""));
                coluna2 = new PdfPCell(new Paragraph(cidadaoModel.getNome()));
                coluna3 = new PdfPCell(new Paragraph(cidadaoModel.getEmail()));
                coluna4 = new PdfPCell(new Paragraph(cidadaoModel.getCelular()));
                coluna5 = new PdfPCell(new Paragraph(cidadaoModel.getPrevisao()));

                tabela.addCell(coluna1);
                tabela.addCell(coluna2);
                tabela.addCell(coluna3);
                tabela.addCell(coluna4);
                tabela.addCell(coluna5);
            }
            
            relatorio.add(tabela);   
            relatorio.close();
            imprimirCarregar.setVisible(false);
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