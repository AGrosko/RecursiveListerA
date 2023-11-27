import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.util.Objects;
import java.util.Scanner;
public class ListerFrame extends JFrame {

    JPanel mainPnl;

    JPanel dispPnl;
    JTextArea outTA;
    JScrollPane outScroll;
    JPanel controlPnl;
    JFileChooser chooser;
    JButton runBtn;
    JButton quitBtn;

    ListerFrame(){

        mainPnl = new JPanel(new GridLayout(2,1));

        createDispPnl();

        mainPnl.add(dispPnl);
        createControlPnl();
        mainPnl.add(controlPnl);

        this.add(mainPnl);
    }

    private void createDispPnl(){
        dispPnl = new JPanel();
        outTA =  new JTextArea(20,30);
        outScroll = new JScrollPane(outTA);

        dispPnl.add(outScroll);


    }

    private void createControlPnl(){

        controlPnl = new JPanel();
        chooser = new JFileChooser();

        runBtn = new JButton("Run");

        quitBtn = new JButton("Quit");
        controlPnl.add(chooser);
        controlPnl.add(runBtn);
        controlPnl.add(quitBtn);


        runBtn.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                listFiles(chooser.getCurrentDirectory());
            }
        });

        quitBtn.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                int choice =JOptionPane.showConfirmDialog(null,"Do you want to quit?");
                if (choice == 0){
                    System.exit(0);
                }
            }
        });

    }


public void listFiles(File toList){
        File[] list = toList.listFiles();
        outTA.append(toList.getName() + "\n");
    for (File x:
            Objects.requireNonNull(toList.listFiles())) {

        if(x.isDirectory()){listFiles(x);}
        else {outTA.append(x.getName() + "\n");}
    }

}



}
