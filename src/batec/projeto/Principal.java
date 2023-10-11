package batec.projeto;

import batec.projeto.Principal.CadastroComArray.Livro;
import java.awt.Color;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;
import java.util.List;
import java.util.ArrayList;
import javax.swing.JButton;
import javax.swing.DefaultListModel;
import javax.swing.JComboBox;
import javax.swing.JList;
import javax.swing.JDialog;
import javax.swing.JFrame;
import javax.swing.ListSelectionModel;


public class Principal extends javax.swing.JFrame {
    private final CadastroComArray cadastro;
    private DefaultListModel<String> listModel;
    private final javax.swing.JPanel jPanelBotoes;
    private javax.swing.JList<String> jListLivros;


    public Principal() {
        initComponents();
        panPrincipal.setBackground(new Color(235,235,235));
        
        
        ImageIcon icone = new ImageIcon("src/imagens/1.png");
        icone.setImage(icone.getImage().getScaledInstance(lblAA.getWidth(), lblAA.getHeight(), 1));
        lblAA.setIcon(icone);

        ImageIcon livro = new ImageIcon("src/imagens/livro.jpg");
        livro.setImage(livro.getImage().getScaledInstance(jLabel3.getWidth(), jLabel3.getHeight(), 1));
        jLabel3.setIcon(livro);

        ImageIcon lupa = new ImageIcon("src/imagens/lupa.png");
        lupa.setImage(lupa.getImage().getScaledInstance(lblLupa.getWidth(), lblLupa.getHeight(), 1));
        lblLupa.setIcon(lupa);
 
        cadastro = new CadastroComArray();
        jListLivros = new JList<>();
        listModel = new DefaultListModel<>();
        jListLivros.setModel(listModel);
        jListLivros.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
        
        jPanelBotoes = new javax.swing.JPanel();
        
        
        setLocationRelativeTo( null );
        
    }
    private int selecionarLivro() {
        List<String> nomesLivros = new ArrayList<>();
        for (CadastroComArray.Livro livro : cadastro.getLivros()) {
            nomesLivros.add(livro.getNome());
        }

        String[] nomesArray = nomesLivros.toArray(String[]::new);

        JComboBox<String> comboBoxLivros = new JComboBox<>(nomesArray);

        int escolha = JOptionPane.showConfirmDialog(
            this, 
            comboBoxLivros, 
            "Selecione um livro", 
            JOptionPane.OK_CANCEL_OPTION, 
            JOptionPane.QUESTION_MESSAGE
        );

        if (escolha == JOptionPane.OK_OPTION) {
            int indiceSelecionado = comboBoxLivros.getSelectedIndex();
            if (indiceSelecionado != -1) {
                CadastroComArray.Livro livroSelecionado = cadastro.getLivros().get(indiceSelecionado);
                
                JOptionPane.showMessageDialog(null, "Livro Selecionado: " + livroSelecionado.getNome());
            } else {
                JOptionPane.showMessageDialog(null, "Por favor, selecione um livro válido.", "Erro", JOptionPane.ERROR_MESSAGE);
            }
        }
        return 0;
    }

    private void atualizarListaLivros() {
    DefaultListModel<String> listModel = new DefaultListModel<>();
    List<CadastroComArray.Livro> livros = cadastro.getLivros();

    for (CadastroComArray.Livro livro : livros) {
        listModel.addElement(livro.getNome());
    }

    jListLivros.setModel(listModel);
}
    
    public class JDialogEditarLivro extends JDialog {
    private JTextField nomeField;
    private JTextField autorField;
    private JTextField editoraField;
    private JTextField isbnField;

    public JDialogEditarLivro(JFrame parent, boolean modal, CadastroComArray.Livro livroParaEditar) {
        super(parent, modal);
        setTitle("Editar Livro");
        setSize(300, 200);
        setDefaultCloseOperation(DISPOSE_ON_CLOSE);
        
        nomeField = new JTextField(20);
        autorField = new JTextField(20);
        editoraField = new JTextField(20);
        isbnField = new JTextField(20);
        nomeField.setText(livroParaEditar.getNome());
        autorField.setText(livroParaEditar.getAutor());
        editoraField.setText(livroParaEditar.getEditora());
        isbnField.setText(livroParaEditar.getIsbn());

        JButton salvarButton = new JButton("Salvar");
        salvarButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                livroParaEditar.setNome(nomeField.getText());
                livroParaEditar.setAutor(autorField.getText());
                livroParaEditar.setEditora(editoraField.getText());
                
                dispose();
            }
        });

        JPanel panel = new JPanel(new GridLayout(5, 2));
        panel.add(new JLabel("Nome:"));
        panel.add(nomeField);
        panel.add(new JLabel("Autor:"));
        panel.add(autorField);
        panel.add(new JLabel("Editora:"));
        panel.add(editoraField);
        panel.add(new JLabel("ISBN:"));
        panel.add(isbnField);
        panel.add(new JLabel(""));
        panel.add(salvarButton);

        add(panel);
    }
}

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        panPrincipal = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jTextField1 = new javax.swing.JTextField();
        lblAA = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();
        lblLupa = new javax.swing.JLabel();
        jMenuBar1 = new javax.swing.JMenuBar();
        menuAcervo = new javax.swing.JMenu();
        jMenuItem3 = new javax.swing.JMenuItem();
        jMenuItem1 = new javax.swing.JMenuItem();
        jMenuItem4 = new javax.swing.JMenuItem();
        menuCadastro = new javax.swing.JMenu();
        jMenuItem2 = new javax.swing.JMenuItem();
        jMenuItem5 = new javax.swing.JMenuItem();
        menuTicket = new javax.swing.JMenu();
        menuRelatorio = new javax.swing.JMenuItem();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setResizable(false);

        jLabel1.setFont(new java.awt.Font("Verdana", 1, 14)); // NOI18N
        jLabel1.setText("LOGIN: Rafael Xavier");

        jTextField1.setFont(new java.awt.Font("Verdana", 0, 14)); // NOI18N

        lblAA.setFont(new java.awt.Font("Verdana", 1, 14)); // NOI18N

        jLabel3.setFont(new java.awt.Font("Verdana", 1, 14)); // NOI18N
        jLabel3.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagens/livro.jpg"))); // NOI18N

        jLabel4.setFont(new java.awt.Font("Verdana", 1, 10)); // NOI18N
        jLabel4.setForeground(new java.awt.Color(51, 51, 51));
        jLabel4.setText("Livro mais alugado da semana!");

        jLabel5.setFont(new java.awt.Font("Verdana", 1, 10)); // NOI18N
        jLabel5.setText("Isbn: 238-234-21-34-2");

        jLabel6.setFont(new java.awt.Font("Verdana", 1, 10)); // NOI18N
        jLabel6.setText("Nome: Torto Arado");

        jLabel7.setFont(new java.awt.Font("Verdana", 1, 10)); // NOI18N
        jLabel7.setText("Autor: Itamar Vieira Júnior");

        jLabel8.setFont(new java.awt.Font("Verdana", 1, 10)); // NOI18N
        jLabel8.setText("Editora: Todavia");

        lblLupa.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagens/lupa.png"))); // NOI18N

        javax.swing.GroupLayout panPrincipalLayout = new javax.swing.GroupLayout(panPrincipal);
        panPrincipal.setLayout(panPrincipalLayout);
        panPrincipalLayout.setHorizontalGroup(
            panPrincipalLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panPrincipalLayout.createSequentialGroup()
                .addGap(17, 17, 17)
                .addGroup(panPrincipalLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(panPrincipalLayout.createSequentialGroup()
                        .addGroup(panPrincipalLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel4)
                            .addGroup(panPrincipalLayout.createSequentialGroup()
                                .addComponent(jLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, 175, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addGroup(panPrincipalLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLabel5)
                                    .addComponent(jLabel7)
                                    .addComponent(jLabel8)
                                    .addComponent(jLabel6))))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 137, Short.MAX_VALUE)
                        .addComponent(lblAA, javax.swing.GroupLayout.PREFERRED_SIZE, 92, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(panPrincipalLayout.createSequentialGroup()
                        .addComponent(jLabel1)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jTextField1, javax.swing.GroupLayout.PREFERRED_SIZE, 223, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(lblLupa, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addContainerGap())))
        );
        panPrincipalLayout.setVerticalGroup(
            panPrincipalLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
            .addGroup(panPrincipalLayout.createSequentialGroup()
                .addContainerGap(73, Short.MAX_VALUE)
                .addComponent(jLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, 227, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel4)
                .addGap(20, 20, 20))
            .addGroup(panPrincipalLayout.createSequentialGroup()
                .addGap(11, 11, 11)
                .addGroup(panPrincipalLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(lblLupa, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(panPrincipalLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(jTextField1, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(jLabel1)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(panPrincipalLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, panPrincipalLayout.createSequentialGroup()
                        .addComponent(jLabel6)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jLabel7)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jLabel8)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jLabel5)
                        .addGap(40, 40, 40))
                    .addComponent(lblAA, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 92, javax.swing.GroupLayout.PREFERRED_SIZE)))
        );

        menuAcervo.setText("Acervo");
        menuAcervo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                menuAcervoActionPerformed(evt);
            }
        });

        jMenuItem3.setText("Gerenciamento de Acervo");
        menuAcervo.add(jMenuItem3);

        jMenuItem1.setText("Relatório de Acervo");
        jMenuItem1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem1ActionPerformed(evt);
            }
        });
        menuAcervo.add(jMenuItem1);

        jMenuItem4.setText("Registro de Movimentação");
        menuAcervo.add(jMenuItem4);

        jMenuBar1.add(menuAcervo);

        menuCadastro.setText("Cadastros");

        jMenuItem2.setText("Controle Bibliotecário");
        jMenuItem2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem2ActionPerformed(evt);
            }
        });
        menuCadastro.add(jMenuItem2);

        jMenuItem5.setText("Cadastrar livros");
        jMenuItem5.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem5ActionPerformed(evt);
            }
        });
        menuCadastro.add(jMenuItem5);

        jMenuBar1.add(menuCadastro);

        menuTicket.setText("Tickets");
        menuTicket.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                menuTicketActionPerformed(evt);
            }
        });

        menuRelatorio.setText("Gerar relatório");
        menuRelatorio.addChangeListener(new javax.swing.event.ChangeListener() {
            public void stateChanged(javax.swing.event.ChangeEvent evt) {
                menuRelatorioStateChanged(evt);
            }
        });
        menuRelatorio.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                menuRelatorioActionPerformed(evt);
            }
        });
        menuTicket.add(menuRelatorio);

        jMenuBar1.add(menuTicket);

        setJMenuBar(jMenuBar1);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(panPrincipal, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(panPrincipal, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void menuAcervoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_menuAcervoActionPerformed
        
    }//GEN-LAST:event_menuAcervoActionPerformed

    private void jMenuItem1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem1ActionPerformed
        
    }//GEN-LAST:event_jMenuItem1ActionPerformed

    private void menuTicketActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_menuTicketActionPerformed
        
    }//GEN-LAST:event_menuTicketActionPerformed

    private void menuRelatorioActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_menuRelatorioActionPerformed
        new RelatorioTicket().setVisible(true);
        this.setVisible(false);
    }//GEN-LAST:event_menuRelatorioActionPerformed

    private void menuRelatorioStateChanged(javax.swing.event.ChangeEvent evt) {//GEN-FIRST:event_menuRelatorioStateChanged
        
    }//GEN-LAST:event_menuRelatorioStateChanged

    private void jMenuItem5ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem5ActionPerformed
    JPanel panel = new JPanel(new GridLayout(4, 2));
        JTextField nomeField = new JTextField(10);
        JTextField autorField = new JTextField(10);
        JTextField editoraField = new JTextField(10);
        JTextField isbnField = new JTextField(10);

        panel.add(new JLabel("Nome:"));
        panel.add(nomeField);
        panel.add(new JLabel("Autor:"));
        panel.add(autorField);
        panel.add(new JLabel("Editora:"));
        panel.add(editoraField);
        panel.add(new JLabel("ISBN:"));
        panel.add(isbnField);

        int result = JOptionPane.showConfirmDialog(null, panel, "Cadastro de Livro", JOptionPane.OK_CANCEL_OPTION);

        if (result == JOptionPane.OK_OPTION) {
            String nome = nomeField.getText();
            String autor = autorField.getText();
            String editora = editoraField.getText();
            String isbn = isbnField.getText();

            CadastroComArray.Livro livro = new CadastroComArray.Livro(nome, autor, editora, isbn);
            cadastro.adicionarLivro(livro);

            JOptionPane.showMessageDialog(null, "Livro cadastrado:\nNome: " + nome + "\nAutor: " + autor + "\nEditora: " + editora + "\nISBN: " + isbn);
        }
    
    }//GEN-LAST:event_jMenuItem5ActionPerformed
    
    private void jMenuItem2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem2ActionPerformed
        StringBuilder relatorioLivros = new StringBuilder("Livros cadastrados:\nNome, Autor, Editora, ISBN\n\n");
    
    List<CadastroComArray.Livro> livros = cadastro.getLivros();
    
    for (CadastroComArray.Livro livro : livros) {
        relatorioLivros.append("").append(livro.getNome()).append(", ");
        relatorioLivros.append("").append(livro.getAutor()).append(", ");
        relatorioLivros.append("").append(livro.getEditora()).append(", ");
        relatorioLivros.append("").append(livro.getIsbn()).append(". \n\n");
    }

    JOptionPane.showMessageDialog(this, relatorioLivros.toString(), "Relatório de Livros", JOptionPane.INFORMATION_MESSAGE);
    
    atualizarListaLivros();
    
    JPanel jPanelBotoes = new JPanel();
    
    JButton botaoDeletar = new JButton("Deletar Livro");
    botaoDeletar.addActionListener(new ActionListener() {
        @Override
        public void actionPerformed(ActionEvent e) {
            int indiceSelecionado = selecionarLivro();
            if (indiceSelecionado != -1) {
                CadastroComArray.Livro livroSelecionado = cadastro.getLivros().get(indiceSelecionado);
            if (livroSelecionado != null) {
                int confirmacao = JOptionPane.showConfirmDialog(null, "Você deseja realmente deletar o livro:\n" +
                    "Nome: " + livroSelecionado.getNome() +
                    "\nAutor: " + livroSelecionado.getAutor() +
                    "\nEditora: " + livroSelecionado.getEditora() +
                    "\nISBN: " + livroSelecionado.getIsbn(), "Confirmar Deleção", JOptionPane.YES_NO_OPTION);
            if (confirmacao == JOptionPane.YES_OPTION) {
                cadastro.removerLivro(indiceSelecionado);
                atualizarListaLivros();
            }
        } else {
            JOptionPane.showMessageDialog(null, "O índice selecionado não corresponde a um livro válido.", "Erro", JOptionPane.ERROR_MESSAGE);
        }
    } else {
        JOptionPane.showMessageDialog(null, "Por favor, selecione um livro para deletar.", "Erro", JOptionPane.ERROR_MESSAGE);
    }
}
});

    JButton botaoAlterar = new JButton("Alterar Livro");
    botaoAlterar.addActionListener(new ActionListener() {
        @Override
        public void actionPerformed(ActionEvent e) {
            int indiceSelecionado = selecionarLivro();
            if (indiceSelecionado != -1) {
                CadastroComArray.Livro livroParaEditar = livros.get(indiceSelecionado);
                JDialogEditarLivro dialogEditar = new JDialogEditarLivro(null, true, livroParaEditar);
                dialogEditar.setVisible(true);
                atualizarListaLivros();
            } else {
                JOptionPane.showMessageDialog(null, "Por favor, selecione um livro para editar.", "Erro", JOptionPane.ERROR_MESSAGE);
            }
        }
    });
    
    jPanelBotoes.add(botaoDeletar);
    jPanelBotoes.add(botaoAlterar);
    
    JOptionPane.showMessageDialog(null, jPanelBotoes, "Opções", JOptionPane.PLAIN_MESSAGE);
    
    this.revalidate(); //notificar a hierarquia
    this.repaint(); //atualizar o visual
    }//GEN-LAST:event_jMenuItem2ActionPerformed

    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(Principal.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Principal.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Principal.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Principal.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Principal().setVisible(true);
            }
        });
    }
   
    public class CadastroComArray {
    private final List<Livro> livros;

    public CadastroComArray() {
        livros = new ArrayList<>();
    }
    

    public List<Livro> getLivros() {
        return livros;
    }

    public void adicionarLivro(Livro livro) {
        livros.add(livro);
    }
    private void initList() {
        listModel = new DefaultListModel<>();
        jListLivros.setModel(listModel);
}
    
    public void removerLivro(int indice) {
    if (indice >= 0 && indice < livros.size()) {
        livros.remove(indice);
    }
}
    

    public static class Livro {
    private String nome;
    private String autor;
    private String editora;
    private String isbn;

    public Livro(String nome, String autor, String editora, String isbn) {
        this.nome = nome;
        this.autor = autor;
        this.editora = editora;
        this.isbn = isbn;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getAutor() {
        return autor;
    }

    public void setAutor(String autor) {
        this.autor = autor;
    }

    public String getEditora() {
        return editora;
    }

    public void setEditora(String editora) {
        this.editora = editora;
    }

    public String getIsbn() {
        return isbn;
    }

    public void setIsbn(String isbn) {
        this.isbn = isbn;
    }
}
}
    
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JMenuBar jMenuBar1;
    private javax.swing.JMenuItem jMenuItem1;
    private javax.swing.JMenuItem jMenuItem2;
    private javax.swing.JMenuItem jMenuItem3;
    private javax.swing.JMenuItem jMenuItem4;
    private javax.swing.JMenuItem jMenuItem5;
    private javax.swing.JTextField jTextField1;
    private javax.swing.JLabel lblAA;
    private javax.swing.JLabel lblLupa;
    private javax.swing.JMenu menuAcervo;
    private javax.swing.JMenu menuCadastro;
    private javax.swing.JMenuItem menuRelatorio;
    private javax.swing.JMenu menuTicket;
    private javax.swing.JPanel panPrincipal;
    // End of variables declaration//GEN-END:variables
 }
