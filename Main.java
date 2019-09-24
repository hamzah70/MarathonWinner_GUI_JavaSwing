import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

class LinkedList{
    Node head;

    LinkedList(){
        head=null;
    }
}

class Node{
    Node nextlink;
    Runner student;
    Node(Runner s){
        student=s;
        nextlink=null;
    }
}

class Runner{
    String name;
    int time;
    int category;
    Runner(String n, int t, int c){
        name=n;
        time=t;
        category=c;
    }
}

public class Main {

    public static void main(String[] args) {
        JFrame frame = new JFrame();
        JPanel panel_Main = new JPanel();
        panel_Main.setLayout(new BoxLayout(panel_Main,BoxLayout.Y_AXIS));
        
        JPanel panel_name=new JPanel();
        panel_name.setLayout(new FlowLayout(FlowLayout.CENTER));
        JLabel panel_label_name=new JLabel("NAME");
        JTextField panel_text_name=new JTextField();
        panel_text_name.setPreferredSize(new Dimension(150, 50));
        panel_name.add(panel_label_name);
        panel_name.add(panel_text_name);
        panel_Main.add(panel_name);
        
        JPanel panel_time=new JPanel();
        panel_time.setLayout(new FlowLayout(FlowLayout.CENTER));
        JLabel panel_label_time=new JLabel("TIME");
        JTextField panel_text_time=new JTextField();
        panel_text_time.setPreferredSize(new Dimension(150, 50));
        panel_time.add(panel_label_time);
        panel_time.add(panel_text_time);
        panel_Main.add(panel_time);

        JPanel panel_winner1=new JPanel();
        panel_winner1.setLayout(new FlowLayout(FlowLayout.CENTER));
        JLabel panel_label_winner1=new JLabel("WINNER 1");
        JTextField panel_text_great1=new JTextField();
        JTextField panel_text_open1=new JTextField();
        JTextField panel_text_half1=new JTextField();
        panel_text_great1.setPreferredSize(new Dimension(150, 50));
        panel_text_open1.setPreferredSize(new Dimension(150, 50));
        panel_text_half1.setPreferredSize(new Dimension(150, 50));
        panel_winner1.add(panel_label_winner1);
        panel_winner1.add(panel_text_great1);
        panel_winner1.add(panel_text_open1);
        panel_winner1.add(panel_text_half1);
        panel_Main.add(panel_winner1);

        JPanel panel_winner2=new JPanel();
        panel_winner2.setLayout(new FlowLayout(FlowLayout.CENTER));
        JLabel panel_label_winner2=new JLabel("WINNER 2");
        JTextField panel_text_great2=new JTextField();
        JTextField panel_text_open2=new JTextField();
        JTextField panel_text_half2=new JTextField();
        panel_text_great2.setPreferredSize(new Dimension(150, 50));
        panel_text_open2.setPreferredSize(new Dimension(150, 50));
        panel_text_half2.setPreferredSize(new Dimension(150, 50));
        panel_winner2.add(panel_label_winner2);
        panel_winner2.add(panel_text_great2);
        panel_winner2.add(panel_text_open2);
        panel_winner2.add(panel_text_half2);
        panel_Main.add(panel_winner2);
        
        JPanel panel_category = new JPanel();
        panel_category.setLayout(new FlowLayout(FlowLayout.CENTER));
        JLabel panel_label=new JLabel("CATEGORY");
        JRadioButton rb_joined_great = new JRadioButton("Great Delhi Run");
        JRadioButton rb_joined_open = new JRadioButton("Open 10K Run");
        JRadioButton rb_joined_half = new JRadioButton("Half Marathon");
        panel_category.add(panel_label);
        panel_category.add(rb_joined_great);
        panel_category.add(rb_joined_open);
        panel_category.add(rb_joined_half);
        panel_Main.add(panel_category);

        JPanel panel_buttons = new JPanel();
        panel_buttons.setLayout(new FlowLayout(FlowLayout.CENTER));
        JButton SUBMIT = new JButton("SUBMIT");
        JButton WINNERS = new JButton("WINNERS");
        JButton EXIT = new JButton("EXIT");
        panel_buttons.add(SUBMIT);
        panel_buttons.add(WINNERS);
        panel_buttons.add(EXIT);
        panel_Main.add(panel_buttons);
        
        LinkedList participants = new LinkedList();

        SUBMIT.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String name = panel_text_name.getText();
                int time = Integer.valueOf(panel_text_time.getText());
                boolean a1 = rb_joined_great.isSelected();
                boolean a2 = rb_joined_open.isSelected();
                boolean a3 = rb_joined_half.isSelected();
                int category=0;
                if(a1==true)
                    category = 1;
                else if(a2==true)
                    category=2;
                else
                    category=3;
                Runner r=new Runner(name, time, category);

                Node next = new Node(r);
                if (participants.head==null){
                    participants.head=next;
                }
                else{
                    Node track=participants.head;
                    while(track.nextlink!=null){
                        track=track.nextlink;
                    }
                    track.nextlink=next;
                }
                panel_text_name.setText("");
                panel_text_time.setText("");
                rb_joined_great.setSelected(false);
                rb_joined_open.setSelected(false);
                rb_joined_half.setSelected(false);
            }
        });


        WINNERS.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                Node track = participants.head;

                int great=Integer.MIN_VALUE;
                String winner11="";
                int great2=Integer.MIN_VALUE;
                String winner12="";


                int open=Integer.MIN_VALUE;
                String winner21="";
                int open2=Integer.MIN_VALUE;
                String winner22="";


                int half=Integer.MIN_VALUE;
                String winner31="";
                int half2=Integer.MIN_VALUE;
                String winner32="";


                while(track!=null){
                    if (track.student.category==1){
                        if(track.student.time>great){
                            great=track.student.time;
                            winner11=track.student.name;
                        }
                    }
                    else if(track.student.category==2){
                        if(track.student.time>open){
                            open=track.student.time;
                            winner21=track.student.name;
                        }
                    }
                    else{
                        if(track.student.time>half){
                            half=track.student.time;
                            winner31=track.student.name;
                        }
                    }
                    track=track.nextlink;
                }

                Node tracking=participants.head;

                while(tracking!=null){
                    if (tracking.student.category==1){
                        if(tracking.student.time<great && tracking.student.time>great2){
                            great2=tracking.student.time;
                            winner12=tracking.student.name;
                        }
                    }
                    else if(tracking.student.category==2){
                        if(tracking.student.time<open && tracking.student.time>open2){
                            open=tracking.student.time;
                            winner22=tracking.student.name;
                        }
                    }
                    else{
                        if(tracking.student.time<half && tracking.student.time>half2){
                            half2=tracking.student.time;
                            winner32=tracking.student.name;
                        }
                    }
                    tracking=tracking.nextlink;
                }


                panel_text_great1.setText(winner11+" Rs 2,80,000/-");
                panel_text_open1.setText(winner21+" Rs 1,90,000/-");
                panel_text_half1.setText(winner31+" Rs 1,35,000/-");

                panel_text_great2.setText(winner12+" Rs 2,10,000/-");
                panel_text_open2.setText(winner22+" Rs 1,50,000/-");
                panel_text_half2.setText(winner32+" Rs 1,15,000/-");

                System.out.println(winner11+" Rs 2,80,000/-");
                System.out.println(winner21+" Rs 1,90,000/-");
                System.out.println(winner31+" Rs 1,35,000/-");
                System.out.println(winner12+" Rs 2,10,000/-");
                System.out.println(winner22+" Rs 1,50,000/-");
                System.out.println(winner32+" Rs 1,15,000/-");

            }
        });

        EXIT.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                frame.dispose();
            }
        });

        frame.add(panel_Main);
        frame.setSize(600, 600);
        frame.setVisible(true);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

    }
}
