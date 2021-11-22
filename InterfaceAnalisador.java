package Analisador;

    
    import java.awt.Color;
    import java.awt.EventQueue;
    import java.awt.SystemColor;
    import java.io.StringReader;
    import javax.swing.JFrame;
    import javax.swing.JLabel;
    import javax.swing.DefaultListModel;
    import javax.swing.JButton;
    import java.awt.event.ActionListener;
    import java.awt.event.ActionEvent;
    import javax.swing.JTextArea;
    import java.awt.Font;
    import javax.swing.JScrollPane;
    import javax.swing.JList;
    
    public class InterfaceAnalisador {
    
        private JFrame frame;
        public String expr ="";
        public static String [] tokens = new String[10000];
        public static int tamanho=0;
        public int contar = 0;
        AnalisadorLexico lexical = new AnalisadorLexico(new StringReader(expr));
    
        //contador para controle do analisadoLexico
        public int contador(int contador){
            //contador para definir saida do programa lexicojava
            if(contador >= tamanho){
            initialize();
                return -1;
            }else{
                return 0;
            }
        }
    
        //metodo main
        public static void main(String[] args) {
            tokens[0] = "";
            try {
                for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                    if ("Nimbus".equals(info.getName())) {
                        javax.swing.UIManager.setLookAndFeel(info.getClassName());
                        break;
                    }
                }
            } catch (ClassNotFoundException ex) {
                System.err.println(ex);
            } catch (InstantiationException ex) {
                System.err.println(ex);
            } catch (IllegalAccessException ex) {
                System.err.println(ex);
            } catch (javax.swing.UnsupportedLookAndFeelException ex) {
                System.err.println(ex);
            }
            EventQueue.invokeLater(new Runnable() {
                public void run() {
                    try {
                        InterfaceAnalisador window = new InterfaceAnalisador();
                        window.frame.setVisible(true);
                    } catch (Exception e) {
                        e.printStackTrace();
                    }
                }
            });
        }
    
    
        //criar inicializacao da classe
        public InterfaceAnalisador() {
            initialize();
        }
    
        // inicializacao do frame da classe
        private void initialize() {
            //estrutura do jframe
            frame = new JFrame();
            frame.setTitle("ANALISADOR LEXICO");
            frame.setBounds(100, 100, 740, 540);
            frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
            frame.getContentPane().setLayout(null);
            frame.getContentPane().setBackground( new Color(128, 128, 128));
            //estrutura do scrollpane da lista
            JScrollPane scrollPanelista = new JScrollPane();
            scrollPanelista.setBounds(357, 32, 330, 380);
            frame.getContentPane().add(scrollPanelista);
            //estrutura do scrollpane do texto
            JScrollPane scrollPanetext = new JScrollPane();
            scrollPanetext.setBounds(30, 33, 296, 379);
            frame.getContentPane().add(scrollPanetext);
            //estrutura do jlabel
            JLabel lblNome = new JLabel("CODE JAVA");
            lblNome.setBackground(new Color(0, 0, 0));
            lblNome.setFont(new Font("Tahoma", Font.BOLD, 13));
            lblNome.setBounds(30, 11, 117, 22);
            frame.getContentPane().add(lblNome);
            //estrutura do jlabel
            JLabel lblToken = new JLabel("TOKEN JAVA");
            lblToken.setForeground(new Color(0, 0, 0));
            lblToken.setBackground(SystemColor.window);
            lblToken.setFont(new Font("Tahoma", Font.BOLD, 13));
            lblToken.setBounds(359, 15, 78, 14);
            frame.getContentPane().add(lblToken);
            
            //metodo para adicionar itens a lista
            DefaultListModel lista = new DefaultListModel<>();
            JList list = new JList(lista);
            list.setFont(new Font("Tahoma", Font.PLAIN, 13));
            list.setBackground(new Color(0, 0, 0));
            list.setForeground(new Color(0, 255, 0));
            scrollPanelista.setViewportView(list);
            
            JTextArea textArea = new JTextArea();
            textArea.setForeground(new Color(0, 0, 0));
            textArea.setFont(new Font("Tahoma", Font.PLAIN, 14));
            textArea.setBackground(new Color(211, 211, 211));
            textArea.setBounds(30, 34, 259, 277);
            scrollPanetext.setViewportView(textArea);
            String inicio = "public class Hello { \n " +
                "public static void main(String[] args) { \n"+
                  "System.out.println('Hello, world!');\n"+
                "};\n"+
              "}";
                textArea.setText(inicio);
            //BOTAO SAIR
            JButton btnSair = new JButton("SAIR");
            btnSair.setBackground(new Color(128, 0, 0));
            btnSair.setForeground(new Color(0, 0, 0));
            btnSair.setFont(new Font("Tahoma", Font.BOLD, 13));
            btnSair.setBounds(570, 439, 89, 36);
            //EVENTO DE CLIQUE DO BOTAO
            btnSair.addActionListener(new ActionListener() {
                public void actionPerformed(ActionEvent arg0) {
                    frame.dispose();			}
            });
            frame.getContentPane().add(btnSair);
            //BOTAO LIMPAR
            JButton btnClear = new JButton("CLEAR");
            btnClear.setForeground(new Color(0, 0, 0));
            btnClear.setBackground(new Color(240, 248, 255));
            btnClear.setFont(new Font("Tahoma", Font.BOLD, 13));
            btnClear.setBounds(303, 439, 89, 36);
            //EVENTO DE CLIQUE DO BOTAO
            btnClear.addActionListener(new ActionListener() {
                public void actionPerformed(ActionEvent arg0) {
                    tokens[0] ="";
                    textArea.setText("");
                    lexical.contadorToken = 0;
                    lista.clear();
                }
            });
            frame.getContentPane().add(btnClear);
            //BOTAO ANALISADOR
            JButton btnAnalyse = new JButton("ANALYSE");
            btnAnalyse.setForeground(Color.BLACK);
            btnAnalyse.setBackground(new Color(0, 255, 0));
            btnAnalyse.setFont(new Font("Tahoma", Font.BOLD, 13));
            btnAnalyse.setBounds(58, 439, 89, 36);
            frame.getContentPane().add(btnAnalyse);
            //EVENTO DE CLIQUE DO BOTAO
            btnAnalyse.addActionListener(new ActionListener() {
                public void actionPerformed(ActionEvent arg0) {
                    try {
                        lista.clear();
                        expr = ""+textArea.getText();
                        tamanho = expr.length();
                        AnalisadorLexico lexical = new AnalisadorLexico(new StringReader(expr));	
                        lexical.yylex();
                        contar = lexical.contadorToken;
                        System.out.println(contar);
                        for(int i=0; i <= contar; i++){
                            tokens[i] = lexical.tokensLexema[i];
                            System.out.println(tokens[i]);
                            lista.addElement(tokens[i]);
                        }
                        //tokens[] = lexical.tokens;
                    }catch (Exception e) {
                        e.printStackTrace();
                    }
                }
            });
    
        }
        
    
    }
    