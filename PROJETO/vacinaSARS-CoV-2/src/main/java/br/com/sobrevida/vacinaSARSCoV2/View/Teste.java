/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.sobrevida.vacinaSARSCoV2.view;

import br.com.sobrevida.vacinaSARSCoV2.controller.PessoaController;
import br.com.sobrevida.vacinaSARSCoV2.model.PessoaModel;
import javax.swing.JOptionPane;

/**
 *
 * @author WERIKE
 */
public class Teste{
    public static void main(String []args){
        
        String menu = "1-Cadastrar\n2-Atualizar\n3-Apagar\n4-Listar\n0-Sair";

        int op;

        do{
            op = Integer.parseInt(JOptionPane.showInputDialog(menu));

            switch(op){
                case 1:
                {
                    String nome = JOptionPane.showInputDialog("Nome?");
                    String fone = JOptionPane.showInputDialog("Fone?");
                    String email = JOptionPane.showInputDialog("Email?");
                    
                    PessoaController pessoaController = new PessoaController();
                    
                    pessoaController.inserir(nome, fone, email);
                            
                    //PessoaModel pm = new PessoaModel();
                    //PessoaController pc = new PessoaController();
                    
                    //pm.setNome(nome);
                    //pm.setFone(fone);
                    //pm.setEmail(email);
                    
                    //pc.inserir(pm);
                    break;
                }
                case 2:
                {
                    String nome = JOptionPane.showInputDialog("Nome?");
                    String fone = JOptionPane.showInputDialog("Fone?");
                    String email = JOptionPane.showInputDialog("Email?");
                    int codigo = Integer.parseInt(JOptionPane.showInputDialog("Codigo?"));
                    PessoaModel p = new PessoaModel ();
                    p.setNome(nome);
                    p.setFone(fone);
                    p.setEmail(email);
                    p.setCodigo(codigo);
                    //p.atualizar();
                    break;
                }
                case 3:
                {
                    int codigo =
                    Integer.parseInt(JOptionPane.showInputDialog("Codigo?"));
                    PessoaModel p = new PessoaModel ();
                    p.setCodigo(codigo);
                    //p.apagar();
                    break;
                }
                case 4:{
                    PessoaModel p = new PessoaModel();
                    //p.listar();
                    break;
                }
                case 0:
                    break;
                default:
                    JOptionPane.showMessageDialog(null, "Opção inválida");
            }
        }while(op != 0);
    }
}
