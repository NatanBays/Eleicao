import java.awt.CardLayout;

import javax.swing.JFrame;
import javax.swing.JPanel;

public class AppFrame extends JFrame {
    private CardLayout cardLayout;
    private JPanel cardPanel;

    private CandidatoListPanel listPanel;
    private CandidatoFormPanel formPanel;

    private PesquisaListPanel listPanelpesquisa;
    private PesquisaFormPanel formPanelpesquisa;

    public AppFrame() {
        super("Eleicao");

        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        
        cardLayout = new CardLayout();
        cardPanel = new JPanel();
        cardPanel.setLayout(cardLayout);
        add(cardPanel);

        criarCards();
    }

    public void mostrar() {
        pack();
		setLocationRelativeTo(null);
		setVisible(true);
    }

    private void criarCards() {
        listPanel = new CandidatoListPanel(this);
        cardPanel.add(listPanel, CandidatoListPanel.class.getName());

        formPanel = new CandidatoFormPanel(this);
        cardPanel.add(formPanel, CandidatoFormPanel.class.getName());

        listPanelpesquisa = new PesquisaListPanel(this);
        cardPanel.add(listPanelpesquisa, PesquisaListPanel.class.getName());

        formPanelpesquisa = new PesquisaFormPanel(this);
        cardPanel.add(formPanelpesquisa, PesquisaFormPanel.class.getName());
    }

    public void mostrarFormPanel(Candidato candidato) {
        formPanel.setCandidato(candidato);
        cardLayout.show(cardPanel, CandidatoFormPanel.class.getName());
    }

    public void mostrarListPanel() {
        listPanel.recarregar();
        cardLayout.show(cardPanel, CandidatoListPanel.class.getName());
    }

    public void mostrarFormPanelPesquisa(Pesquisa pesquisa) {
        formPanelpesquisa.setPesquisa(pesquisa);
        cardLayout.show(cardPanel, PesquisaFormPanel.class.getName());
    }

    public void mostrarListPanelPesquisa() {
        listPanelpesquisa.recarregar();
        cardLayout.show(cardPanel, PesquisaListPanel.class.getName());
    }
}
