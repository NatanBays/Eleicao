import java.awt.GridBagLayout;
import java.awt.GridBagConstraints;
import java.awt.FlowLayout;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.event.ComponentAdapter;
import java.awt.event.ComponentEvent;

import javax.swing.JButton;
import javax.swing.JComponent;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;

public class CandidatoFormPanel extends JPanel {
    private AppFrame frame;

    private Candidato candidato;

    private GridBagLayout layout;
    private GridBagConstraints constraints;

    private JTextField txtIdCandidato;
    private JTextField txtNome;
    private JTextField txtNomePartido;
    private JTextField txtNumeroPartido;
    private JButton btnSalvar;
    private JButton btnCancelar;

    public CandidatoFormPanel(AppFrame frame) {
        this.frame = frame;

        layout = new GridBagLayout();
        constraints = new GridBagConstraints();

        setLayout(layout);
        addComponentListener(new ComponentAdapter() {
            @Override
            public void componentShown(ComponentEvent e) {
                if (candidato == null) {
                    txtIdCandidato.setText("");
                    txtNome.setText("");
                    txtNomePartido.setText("");
                    txtNumeroPartido.setText("");
                } else {
                    txtIdCandidato.setText(Integer.toString(candidato.getIdCandidato()));
                    txtNome.setText(candidato.getNome());
                    txtNomePartido.setText(candidato.getNomePartido());
                    txtNumeroPartido.setText(Integer.toString(candidato.getNumeroPartido()));
                }
            }
        });

        criarForm();
    }

    public void setCandidato(Candidato candidato) {
        this.candidato = candidato;
    }

    private void criarForm() {
        JLabel label;

        label = new JLabel("Id");
        adicionarComponente(label, 0, 0);
        txtIdCandidato = new JTextField(5);
        txtIdCandidato.setEditable(false);
        adicionarComponente(txtIdCandidato, 0, 1);

        label = new JLabel("Nome");
        adicionarComponente(label, 1, 0);
        txtNome = new JTextField(30);
        adicionarComponente(txtNome, 1, 1);

        label = new JLabel("Nome Partido");
        adicionarComponente(label, 2, 0);
        txtNomePartido = new JTextField(5);
        adicionarComponente(txtNomePartido, 2, 1);

        label = new JLabel("Numero Partido");
        adicionarComponente(label, 3, 0);
        txtNumeroPartido = new JTextField(30);
        adicionarComponente(txtNumeroPartido, 3, 1);

        criarBotoes();
    }

    private void criarBotoes() {
        JPanel btnPanel = new JPanel();
        FlowLayout flowLayout = (FlowLayout) btnPanel.getLayout();
        flowLayout.setAlignment(FlowLayout.LEFT);

        criarBtnSalvar(btnPanel);
        criarBtnCancelar(btnPanel);

        adicionarComponente(btnPanel, 7, 1, 2, 1);
    }

    private void criarBtnSalvar(JPanel btnPanel) {
        btnSalvar = new JButton("Salvar");
        btnSalvar.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if (CandidatoFormPanel.this.candidato == null) {
                    Candidato novoCandidato = new Candidato();
                    novoCandidato.setNome(txtNome.getText());
                    novoCandidato.setNomePartido(txtNomePartido.getText());
                    novoCandidato.setNumeroPartido((Integer.parseInt(txtNumeroPartido.getText())));

                    CandidatoStorage.inserir(novoCandidato);
                    JOptionPane.showMessageDialog(CandidatoFormPanel.this, 
                                                  "Candidato incluido com sucesso", 
                                                  "Eleicao", 
                                                  JOptionPane.INFORMATION_MESSAGE);
                } else {
                    candidato.setNome(txtNome.getText());
                    candidato.setNomePartido(txtNomePartido.getText());
                    candidato.setNumeroPartido((Integer.parseInt(txtNumeroPartido.getText())));
                    CandidatoStorage.atualizar(CandidatoFormPanel.this.candidato);
                    JOptionPane.showMessageDialog(CandidatoFormPanel.this, 
                                                  "Candidato atualizado com sucesso", 
                                                  "Eleicao", 
                                                  JOptionPane.INFORMATION_MESSAGE);
                }

                    
                frame.mostrarListPanel();
            }
        });
        btnPanel.add(btnSalvar);
    }

    private void criarBtnCancelar(JPanel btnPanel) {
        btnCancelar = new JButton("Cancelar");
        btnCancelar.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                frame.mostrarListPanel();
            }
        });
        btnPanel.add(btnCancelar);
    }

    private void adicionarComponente(JComponent componente, 
                                    int linha, int coluna) {
        adicionarComponente(componente, linha, coluna, 1, 1);
    }                                    

    private void adicionarComponente(JComponent componente, 
                                    int linha, int coluna, 
                                    int largura, int altura) {
        constraints.gridx = coluna;
        constraints.gridy = linha;
        constraints.gridwidth = largura;
        constraints.gridheight = altura;

        constraints.fill = GridBagConstraints.HORIZONTAL;

        layout.setConstraints(componente, constraints);
        add(componente);
    }
}
