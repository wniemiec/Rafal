package com.tictactoe;


import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class TicTacToe extends JFrame
{
    private Container panel;
    private JLabel title;
    private boolean hasWinner;
  //  private JButton [][] board;
    private JButton [] board;
    private String user;

    static ArrayList<Integer> playerPosition = new ArrayList<>();
    static ArrayList<Integer> cpuPosition = new ArrayList<>();

    public TicTacToe()
    {
        super("Tic Tac Toe");
		super("Tic Tac Toe");
        title = new JLabel("TIC TAC TOE");
        title.setForeground(Color.WHITE);
        title.setBounds(220,500,700,300);
        title.setFont(new Font("Veranda", Font.PLAIN, 30));


        panel = getContentPane();
        panel.setLayout(new GridLayout(4, 3));
      //  this.getContentPane().setBackground(Color.darkGray);
        panel.setBackground(Color.darkGray);
        setTitle("Tic Tac Toe");
        setSize(700, 800);
        setResizable(false);
        setDefaultCloseOperation(DISPOSE_ON_CLOSE);
        setVisible(true);
       // this.add(title);
        user = "X";
        board = new JButton[9];
        hasWinner = false;
        printBoard();
    }

    public void printBoard()
    {
        int position = 0;

                for(int i=0; i<9; i++)
                {
                    JButton btn = new JButton();
                    btn.setFont(new Font("Veranda", Font.PLAIN, 70));
                    btn.setBackground(Color.DARK_GRAY);
                    btn.setForeground(Color.PINK);
                    board[i] = btn;
                    int fina = i;
                    btn.addActionListener(new ActionListener() {
                        @Override
                        public void actionPerformed(ActionEvent e) {
                            //tutaj dzieki temu mozemy okreslic akcje dzialania po kliknieciu konkretnego buttona
                            if(((JButton)e.getSource()).getText().equals("") && hasWinner == false)
                            {
                                btn.setText(user);
                                if(board[fina].getText().equals("X"))
                                {
                                     playerPosition.add(fina+1);
                                 }
                                else if(board[fina].getText().equals("O"))
                                {
                                    cpuPosition.add(fina+1);
                                }
                                checkWinner();
                                placePiece();
                            }
                        }
                    });
                    panel.add(btn);
                }

        panel.add(title);
    }

    public void placePiece()
    {
         if(user.equals("X"))
         {
             user = "O";
         }
         else
         {
             user = "X";
         }
    }

    public int checkWinner()
    {

        java.util.List topRow = Arrays.asList(1,2,3);
        java.util.List midRow = Arrays.asList(4,5,6);
        java.util.List botRow = Arrays.asList(7,8,9);
        java.util.List leftCol = Arrays.asList(1,4,7);
        java.util.List midCol = Arrays.asList(2,5,8);
        java.util.List rightCol = Arrays.asList(3,6,9)
        java.util.List cross1 = Arrays.asList(1,5,9);
        java.util.List cross2 = Arrays.asList(3,5,7);

        System.out.println("lol");

        java.util.List<java.util.List> winning = new ArrayList<java.util.List>();

        winning.add(topRow);
        winning.add(midRow);
        winning.add(botRow);
        winning.add(leftCol);
        winning.add(midCol);
        winning.add(rightCol);
        winning.add(cross1);
        winning.add(cross2);


        for(List key : winning)
        {
            if(playerPosition.containsAll(key))
            {
                JOptionPane.showMessageDialog(null,"Player " + user + " has won");
                hasWinner = true;
            }
            else if(cpuPosition.containsAll(key))
            {
                JOptionPane.showMessageDialog(null,"Player " + user + " has won");
                hasWinner = true;
            }
        }
        return 1;
    }

}
