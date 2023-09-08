
import javax.swing.JOptionPane;

public class Principal {

    public static void main(String[] args) {
        // Variáveis:
            int[][] assentos = new int[5][10];
            int i = 0, linha = 0, coluna = 0, opcao = 1;
            int vazio = 50, reservado = 0;
            
        // Dados:
            for (linha = 0; linha < 5; linha++) {
                for (coluna = 0; coluna < 10; coluna++) {
                    assentos[linha][coluna] = 0;
                }
            }
        
        // Entrada de dados:
            do {
                opcao = Integer.parseInt(JOptionPane.showInputDialog("O que pretende fazer?"+
                                                                     "\n 1 - Reservar assento"+
                                                                     "\n 2 - Cancelar reserva"+
                                                                     "\n 3 - Exibir mapa de assentos"+
                                                                     "\n 4 - Exibir quantidade de assentos livres"+
                                                                     "\n 5 - Exibir quantidade de assentos ocupados"+
                                                                     "\n 0 - Sair"));
                
                switch (opcao) {
                    case 1: 
                        linha = Integer.parseInt(JOptionPane.showInputDialog("Qual fileira deseja reservar?"));
                        coluna = Integer.parseInt(JOptionPane.showInputDialog("Qual assento deseja reservar?"));
                        
                        if (assentos[linha - 1][coluna - 1] == 0) { 
                            assentos[linha - 1][coluna - 1] = 1; 
                            reservado++; vazio--;
                        }
                        else {
                            JOptionPane.showMessageDialog(null, "Esse assento já foi reservado, escolha outro.");
                            do {
                                linha = Integer.parseInt(JOptionPane.showInputDialog("Qual fileira deseja reservar?"));
                                coluna = Integer.parseInt(JOptionPane.showInputDialog("Qual assento deseja reservar?"));
                                if (assentos[linha - 1][coluna - 1] == 1) {
                                    JOptionPane.showMessageDialog(null, "Esse assento também já foi reservado, escolha outro.");
                                }
                                else { assentos[linha - 1][coluna - 1] = 0; }
                            } while (assentos[linha - 1][coluna - 1] == 1);
                            assentos[linha - 1][coluna - 1] = 1; 
                            reservado++; vazio--;
                        }
                    break;
                    
                    case 2: 
                        linha = Integer.parseInt(JOptionPane.showInputDialog("Em qual fileira está o seu assento?"));
                        coluna = Integer.parseInt(JOptionPane.showInputDialog("Qual o assento em que deseja cancelar a reserva?"));
                        
                        if (assentos[linha - 1][coluna - 1] == 1) {
                            assentos[linha - 1][coluna - 1] = 0; 
                            reservado--; vazio++;
                            JOptionPane.showMessageDialog(null, "Reserva cancelada com sucesso!");
                        }
                        else {
                            JOptionPane.showMessageDialog(null, "Esse assento está vazio, digite novamente.");
                            do {
                                linha = Integer.parseInt(JOptionPane.showInputDialog("Em qual fileira está o seu assento?"));
                                coluna = Integer.parseInt(JOptionPane.showInputDialog("Qual o assento em que deseja cancelar a reserva?"));
                                if (assentos[linha - 1][coluna - 1] == 0) {
                                    JOptionPane.showMessageDialog(null, "Esse assento também está vazio, digite novamente.");
                                }
                                else { assentos[linha - 1][coluna - 1] = 1; }
                            } while (assentos[linha - 1][coluna - 1] == 0);
                            assentos[linha - 1][coluna - 1] = 0; 
                            reservado--; vazio++;
                        }
                    break;
                    
                    case 3: 
                        for (linha = 0; linha < 5; linha++) {
                                for (coluna = 0; coluna < 10; coluna++) {
                                    System.out.print(assentos[linha][coluna]+ " ");
                                }
                                System.out.println("");
                        }
                    break;
                    
                    case 4: 
                        JOptionPane.showMessageDialog(null, "Há "+ vazio +" assentos livres.");
                    break;
                    
                    case 5: 
                        JOptionPane.showMessageDialog(null, "Há "+ reservado +" assentos reservados.");
                    break;
                    
                    case 0:
                        JOptionPane.showMessageDialog(null, "Muito obrigado pela confiança!");
                    break;
                    
                    default:
                        JOptionPane.showMessageDialog(null, "Você escolheu uma opção inválida, tente novamente.");
                    break;
                }
            } while (opcao != 0);
    }   
} 