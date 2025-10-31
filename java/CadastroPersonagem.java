import java.awt.*;
import java.awt.event.*;
import java.io.File;
import java.util.ArrayList;
import javax.swing.*;
import javax.swing.filechooser.FileNameExtensionFilter;

public class CadastroPersonagem extends JFrame {

    private JTextField txtNome, txtForca, txtAgilidade, txtInteligencia;
    private JComboBox<String> cbClasse;
    private JLabel lblImagem;
    private JButton btnEscolherImagem, btnSalvar, btnListar;
    private String caminhoImagem = null;
    
    private ArrayList<Character> personagens = new ArrayList<>();

    public CadastroPersonagem() {
        setTitle("Cadastro de Personagem - RPG");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(600, 500);
        setLayout(null);
        getContentPane().setBackground(new Color(40, 40, 40));

        JLabel lblTitulo = new JLabel("Cadastro de Personagem");
        lblTitulo.setBounds(150, 20, 400, 30);
        lblTitulo.setFont(new Font("Segoe UI", Font.BOLD, 22));
        lblTitulo.setForeground(Color.WHITE);
        add(lblTitulo);

        JLabel lblNome = new JLabel("Nome:");
        lblNome.setBounds(50, 80, 80, 25);
        lblNome.setForeground(Color.WHITE);
        add(lblNome);
        txtNome = new JTextField();
        txtNome.setBounds(130, 80, 180, 25);
        add(txtNome);

        JLabel lblClasse = new JLabel("Classe:");
        lblClasse.setBounds(50, 120, 80, 25);
        lblClasse.setForeground(Color.WHITE);
        add(lblClasse);
        cbClasse = new JComboBox<>(new String[]{"Guerreiro", "Mago", "Arqueiro"});
        cbClasse.setBounds(130, 120, 180, 25);
        add(cbClasse);

        JLabel lblForca = new JLabel("Força:");
        lblForca.setBounds(50, 160, 80, 25);
        lblForca.setForeground(Color.WHITE);
        add(lblForca);
        txtForca = new JTextField();
        txtForca.setBounds(130, 160, 80, 25);
        add(txtForca);

        JLabel lblAgilidade = new JLabel("Agilidade:");
        lblAgilidade.setBounds(50, 200, 80, 25);
        lblAgilidade.setForeground(Color.WHITE);
        add(lblAgilidade);
        txtAgilidade = new JTextField();
        txtAgilidade.setBounds(130, 200, 80, 25);
        add(txtAgilidade);

        JLabel lblInteligencia = new JLabel("Inteligência:");
        lblInteligencia.setBounds(50, 240, 80, 25);
        lblInteligencia.setForeground(Color.WHITE);
        add(lblInteligencia);
        txtInteligencia = new JTextField();
        txtInteligencia.setBounds(130, 240, 80, 25);
        add(txtInteligencia);

        lblImagem = new JLabel("Imagem", SwingConstants.CENTER);
        lblImagem.setBounds(350, 80, 180, 180);
        lblImagem.setBorder(BorderFactory.createLineBorder(Color.WHITE));
        lblImagem.setForeground(Color.WHITE);
        add(lblImagem);

        btnEscolherImagem = new JButton("Escolher Imagem");
        btnEscolherImagem.setBounds(350, 270, 180, 25);
        add(btnEscolherImagem);

        btnSalvar = new JButton("Salvar Personagem");
        btnSalvar.setBounds(100, 320, 180, 30);
        add(btnSalvar);

        btnListar = new JButton("Listar Personagens");
        btnListar.setBounds(320, 320, 180, 30);
        add(btnListar);

        // Ações dos botões
        btnEscolherImagem.addActionListener(e -> escolherImagem());
        btnSalvar.addActionListener(e -> salvarPersonagem());
        btnListar.addActionListener(e -> listarPersonagens());
        
        setLocationRelativeTo(null);
        setVisible(true);
    }

    private void escolherImagem() {
        JFileChooser chooser = new JFileChooser();
        chooser.setFileFilter(new FileNameExtensionFilter("Imagens", "jpg", "png", "jpeg"));
        int res = chooser.showOpenDialog(this);
        if (res == JFileChooser.APPROVE_OPTION) {
            File arquivo = chooser.getSelectedFile();
            caminhoImagem = arquivo.getAbsolutePath();
            ImageIcon icon = new ImageIcon(new ImageIcon(caminhoImagem).getImage().getScaledInstance(180, 180, Image.SCALE_SMOOTH));
            lblImagem.setText("");
            lblImagem.setIcon(icon);
        }
    }

    private void salvarPersonagem() {
    try {
        String nome = txtNome.getText().trim();
        String classe = cbClasse.getSelectedItem().toString();
        int forca = Integer.parseInt(txtForca.getText());
        int agilidade = Integer.parseInt(txtAgilidade.getText());
        int inteligencia = Integer.parseInt(txtInteligencia.getText());
        
       
        if (nome.isEmpty()) {
            JOptionPane.showMessageDialog(this, "Digite o nome do personagem!", "Aviso", JOptionPane.WARNING_MESSAGE);
            return;
        }


        int totalPontos = forca + agilidade + inteligencia;
        if (totalPontos > 15) {
            JOptionPane.showMessageDialog(this,
                "Você distribuiu " + totalPontos + " pontos.\nO máximo permitido é 15!",
                "Limite de Pontos Excedido",
                JOptionPane.ERROR_MESSAGE);
            return;
        }

        Character personagem = null;

        switch (classe) {
            case "Guerreiro":
                personagem = new Warrior(nome, forca, agilidade, inteligencia);
                break;
            case "Mago":
                personagem = new Mage(nome, forca, agilidade, inteligencia);
                break;
            case "Arqueiro":
                personagem = new Archer(nome, forca, agilidade, inteligencia);
                break;
        }

        if (personagem != null) {
            personagem.setImagem(caminhoImagem);
            personagens.add(personagem);
            JOptionPane.showMessageDialog(this, "Personagem cadastrado com sucesso!");
            limparCampos();
        }

    } catch (NumberFormatException e) {
        JOptionPane.showMessageDialog(this, "Preencha todos os campos numéricos corretamente!", "Erro", JOptionPane.ERROR_MESSAGE);
    }
}


    private void limparCampos() {
        txtNome.setText("");
        txtForca.setText("");
        txtAgilidade.setText("");
        txtInteligencia.setText("");
        cbClasse.setSelectedIndex(0);
        lblImagem.setIcon(null);
        lblImagem.setText("Imagem");
        caminhoImagem = null;
    }

   private void listarPersonagens() {
    if (personagens.isEmpty()) {
        JOptionPane.showMessageDialog(this, "Nenhum personagem cadastrado ainda!");
        return;
    }

    JFrame frameLista = new JFrame("Personagens Cadastrados");
    frameLista.setSize(650, 450);
    frameLista.setLayout(new BorderLayout());
    frameLista.getContentPane().setBackground(new Color(25, 25, 25));

    JPanel panel = new JPanel();
    panel.setLayout(new BoxLayout(panel, BoxLayout.Y_AXIS));
    panel.setBackground(new Color(25, 25, 25));

    for (Character c : personagens) {
        JPanel card = new JPanel(new BorderLayout(15, 10));
        card.setBackground(new Color(45, 45, 45));
        card.setBorder(BorderFactory.createEmptyBorder(10, 10, 10, 10));

       
        JLabel imgLabel;
        if (c.getImagem() != null) {
            ImageIcon icon = new ImageIcon(
                new ImageIcon(c.getImagem()).getImage().getScaledInstance(120, 120, Image.SCALE_SMOOTH)
            );
            imgLabel = new JLabel(icon);
        } else {
            imgLabel = new JLabel("Sem Imagem", SwingConstants.CENTER);
            imgLabel.setForeground(Color.LIGHT_GRAY);
            imgLabel.setPreferredSize(new Dimension(120, 120));
        }
        card.add(imgLabel, BorderLayout.WEST);

       
        JPanel infoPanel = new JPanel();
        infoPanel.setLayout(new GridLayout(5, 1));
        infoPanel.setBackground(new Color(45, 45, 45));

        JLabel lblNome = new JLabel("Nome: " + c.getNome());
        JLabel lblClasse = new JLabel("Classe: " + c.getClass().getSimpleName());
        JLabel lblForca = new JLabel("Força: " + c.getForca());
        JLabel lblAgilidade = new JLabel("Agilidade: " + c.getAgilidade());
        JLabel lblInteligencia = new JLabel("Inteligência: " + c.getInteligencia());

        for (JLabel lbl : new JLabel[]{lblNome, lblClasse, lblForca, lblAgilidade, lblInteligencia}) {
            lbl.setForeground(Color.WHITE);
            lbl.setFont(new Font("Segoe UI", Font.PLAIN, 14));
            infoPanel.add(lbl);
        }

        card.add(infoPanel, BorderLayout.CENTER);

        // 🔹 Linha divisória entre os cards
        JPanel separador = new JPanel();
        separador.setPreferredSize(new Dimension(0, 1));
        separador.setBackground(new Color(70, 70, 70));

        panel.add(card);
        panel.add(separador);
    }

    JScrollPane scroll = new JScrollPane(panel);
    scroll.setBorder(null);
    scroll.getVerticalScrollBar().setUnitIncrement(16);
    frameLista.add(scroll, BorderLayout.CENTER);

    frameLista.setLocationRelativeTo(this);
    frameLista.setVisible(true);
}
}