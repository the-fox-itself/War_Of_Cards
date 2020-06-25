package Client.Mechanic.SwingPlus;

import Client.Objects.Cards.Card;
import Client.Objects.Cards.NaturalCards.*;
import Client.Objects.TechnicalObjects.Account;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionListener;
import java.io.*;
import java.net.Socket;
import java.time.LocalDateTime;

import static Client.Mechanic.MainGUIVariables.*;

public abstract class Methods {
    Methods() {
        printNote("Creating an object of class Methods", NOTE_TYPE_DONE);
    }

    private static String font = "AlundraText";
    public final static Font f90 = new Font(font, Font.BOLD, 90);
    public final static Font f80 = new Font(font, Font.BOLD, 80);
    public final static Font f70 = new Font(font, Font.BOLD, 70);
    public final static Font f60 = new Font(font, Font.BOLD, 60);
    public final static Font f50 = new Font(font, Font.BOLD, 50);
    public final static Font f45 = new Font(font, Font.BOLD, 45);
    public final static Font f40 = new Font(font, Font.BOLD, 40);
    public final static Font f35 = new Font(font, Font.BOLD, 35);
    public final static Font f32 = new Font(font, Font.BOLD, 32);
    public final static Font f30 = new Font(font, Font.BOLD, 30);
    public final static Font f25 = new Font(font, Font.BOLD, 25);
    public final static Font f20 = new Font(font, Font.BOLD, 20);
    public final static Font f17 = new Font(font, Font.BOLD, 17);
    public final static Font f15 = new Font(font, Font.BOLD, 15);

    public final static int NOTE_TYPE_DONE = 0;
    public final static int NOTE_TYPE_PROCESS = 1;
    public final static int NOTE_TYPE_WARNING = 2;
    public final static int NOTE_TYPE_ERROR = 3;
    public final static int NOTE_TYPE_INFO = 4;

    public static void printNote(String sender, String note, int type) {
        switch (type) {
            case 0:
                System.out.print("<" + sender + "> " + note + " has successfully done.\n");
                break;
            case 1:
                System.out.print("<" + sender + "> " + note + "...\n");
                break;
            case 2:
                System.out.print("<" + sender + "> " + note + "!\n");
                break;
            case 3:
                System.out.print("<" + sender + "> -ERROR- " + note + " has failed!\n");
                break;
            case 4:
                System.out.print("<" + sender + "> -info- " + note + ".\n");
                break;
        }
    }
    public static void printNote(String note, int type) {
        switch (type) {
            case 0:
                System.out.print("<War_Of_Cards> " + note + " has successfully done.\n");
                break;
            case 1:
                System.out.print("<War_Of_Cards> " + note + "...\n");
                break;
            case 2:
                System.out.print("<War_Of_Cards> " + note + "!\n");
                break;
            case 3:
                System.out.print("<War_Of_Cards> -ERROR- " + note + " has failed!\n");
                break;
            case 4:
                System.out.print("<War_Of_Cards> -info- " + note + ".\n");
                break;
        }
    }

    public static void lNull(JFrame frame) {
        frame.setLayout(null);
    }
    public static void lBord(JFrame frame) {
        frame.setLayout(new BorderLayout());
    }
    public static void visTrue(Component component) {
        component.setVisible(true);
        printNote("Displaying component [isVisible:true, component:"+component+"]", NOTE_TYPE_DONE);
    }
    public static void visFalse(Component component) {
        component.setVisible(false);
        printNote("Hiding component [isVisible:false, component:"+component+"]", NOTE_TYPE_DONE);
    }
    public static void setComponent(Container container, Component component, Font font, int x, int y, int width, int height) {
        container.add(component);
        component.setFont(font);
        component.setBounds(x, y, width, height);
        visFalse(component);
    }
    public static void setComponent(Container container, Component component, Font font, Color colorBackground, Color colorForeground, int x, int y, int width, int height) {
        container.add(component);
        component.setFont(font);
        component.setBackground(colorBackground);
        component.setForeground(colorForeground);
        component.setBounds(x, y, width, height);
        visFalse(component);
    }
    public static void setComponentByAvailablePlaceOnFrame(JFrame frame, Component component, Font font, int x, int y) {
        setComponentByAvailablePlaceOnFrame(frame, component, font, x, y, 0, 0);
    }
    public static void setComponentByAvailablePlaceOnFrame(JFrame frame, Component component, Font font, int x, int y, int widthPlus, int heightPlus) {
        component.setFont(font);

        JPanel panel = new JPanel();
        panel.setLayout(new FlowLayout());
        frame.add(panel);
        panel.setBounds(-frame.getWidth(), -frame.getHeight(), frame.getWidth(), frame.getHeight());
        panel.add(component);
        frame.setEnabled(false);
        visTrue(frame);

        frame.add(component);
//        System.out.println(x + " " + y + " " + component.getWidth() + " " + component.getHeight());
        component.setBounds(x, y, component.getWidth()+widthPlus, component.getHeight()+heightPlus);

        frame.remove(panel);

        visFalse(component);
        frame.setEnabled(true);
    }

    public static int[] getNeededBoundsForComponent(Component component) {
        int[] returnInt = new int[2];

        JFrame frame = new JFrame();
        frame.setSize(1000, 1000);
        frame.setLayout(new FlowLayout());
        frame.add(component);
        frame.setEnabled(false);
        visTrue(frame);
        returnInt[0] = component.getWidth();
        returnInt[1] = component.getHeight();
        visFalse(frame);

        return returnInt;
    }


    public static void makeRecentlySave() {
        if (accountCurrent != null) {
            try {
                printNote("Making recently save", NOTE_TYPE_PROCESS);
                FileOutputStream fileOutputStream = new FileOutputStream("saves"+SEPARATOR+"recentlySave.ser");
                ObjectOutputStream objectOutputStream = new ObjectOutputStream(fileOutputStream);
                String time = (LocalDateTime.now() + "").split("T")[0]; //2020-04-30T15:13:52.202096300
                objectOutputStream.writeObject(accountCurrent.nick + "\n" + time);
                System.out.println(accountCurrent.nick + "\n" + time);
                objectOutputStream.close();
                printNote("Making recently save", NOTE_TYPE_DONE);
            } catch (Exception ex) {
                printNote("Making recently save", NOTE_TYPE_ERROR);
                ex.printStackTrace();
            }
        }
    }
    public static void deleteRecentlySave() {
        try {
            printNote("Deleting recently save", NOTE_TYPE_PROCESS);
            FileOutputStream fileOutputStream = new FileOutputStream("saves"+SEPARATOR+"recentlySave.ser");
            ObjectOutputStream objectOutputStream = new ObjectOutputStream(fileOutputStream);
            objectOutputStream.close();
            printNote("Deleting recently save", NOTE_TYPE_DONE);
        } catch (Exception ex) {
            printNote("Deleting recently save", NOTE_TYPE_ERROR);
            ex.printStackTrace();
        }
    }
    public static boolean getRecentlySave() {
        try {
            printNote("Finding recently save", NOTE_TYPE_PROCESS);
            FileInputStream fileInputStream = new FileInputStream("saves"+SEPARATOR+"recentlySave.ser");
            ObjectInputStream objectInputStream = new ObjectInputStream(fileInputStream);
            String[] object = ((String) objectInputStream.readObject()).split("\n");
            String name = object[0];
            String time = object[1];
            int year = Integer.parseInt(time.split("-")[0]);
            int month = Integer.parseInt(time.split("-")[1]);
            int day = Integer.parseInt(time.split("-")[2]);
            int currentYear = Integer.parseInt((LocalDateTime.now()+"").split("T")[0].split("-")[0]);
            int currentMonth = Integer.parseInt((LocalDateTime.now()+"").split("T")[0].split("-")[1]);
            int currentDay = Integer.parseInt((LocalDateTime.now()+"").split("T")[0].split("-")[2]);
            objectInputStream.close();

            if ((currentDay - day < 5 && currentDay - day > -1 && currentYear == year && currentMonth == month) || (currentDay - day > -31 && currentDay - day < -25 && currentYear == year && currentMonth - month == 1)) {
                FileInputStream fileInputStreamAccount = new FileInputStream("saves"+SEPARATOR+name+".ser");
                ObjectInputStream objectInputStreamAccount = new ObjectInputStream(fileInputStreamAccount);
                accountCurrent = (Account) objectInputStreamAccount.readObject();
                objectInputStreamAccount.close();

                registered = true;
                printNote("Finding recently save [year:"+year+", month:"+month+", day:"+day+", nick:"+accountCurrent.nick+"]", NOTE_TYPE_DONE);
                return true;
            } else {
                printNote("Finding recently save [year:"+year+", month:"+month+", day:"+day+", nick:"+accountCurrent.nick+"]", NOTE_TYPE_DONE);
                printNote("Recently save has expired", NOTE_TYPE_INFO);
                return false;
            }
        } catch (Exception ex) {
            printNote("Finding recently save", NOTE_TYPE_ERROR);
            ex.printStackTrace();
        }
        return false;
    }

    public static JFrame getFrame(String name, int width, int height, LayoutManager layout, Component locationRelativeTo, boolean isResizable) {
        printNote("Making new JFrame", NOTE_TYPE_PROCESS);
        JFrame returnFrame = new JFrame(name);
        returnFrame.setSize(width, height);
        returnFrame.setLayout(layout);
        returnFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        returnFrame.setLocationRelativeTo(locationRelativeTo);
        returnFrame.setResizable(isResizable);
        printNote("Making new JFrame [name:" + name + ", width:" + width + ", height:" + height + ", layout:" + layout + ", locationRelativeTo:" + locationRelativeTo + ", isResizable:" + isResizable + "]", NOTE_TYPE_DONE);

        return returnFrame;
    }
    public static JButton getButtonNullLayout(String text, Font font, JFrame frameAdd, int x, int y, int width, int height, ActionListener actionListener, Color background, Color foreground) {
//        printNote("Making new JButton", NOTE_TYPE_PROCESS);
        JButton returnButton = new JButton(text);
        returnButton.setFont(font);
        frameAdd.add(returnButton);
        returnButton.setBounds(x, y, width, height);
        returnButton.addActionListener(actionListener);
        returnButton.setBackground(background);
        returnButton.setForeground(foreground);
        visFalse(returnButton);
//        printNote("Making new JButton [text:"+text+", font:"+font+", frameAdd:"+frameAdd+", x:"+x+", y:"+y+", width:"+ width+", height:"+height+", actionListener:"+actionListener+", background:"+background+", foreground:"+foreground+"]", NOTE_TYPE_DONE);

        return returnButton;
    }
    public static JLabel getLabelNullLayout(String text, Font font, JFrame frameAdd, int x, int y, int width, int height, Color foreground) {
//        printNote("Making new JLabel", NOTE_TYPE_PROCESS);
        JLabel returnLabel = new JLabel(text);
        returnLabel.setFont(font);
        frameAdd.add(returnLabel, 1, 0);
        returnLabel.setBounds(x, y, width, height);
        returnLabel.setForeground(foreground);
        visFalse(returnLabel);
//        printNote("Making new JLabel [text:"+text+", font:"+font+", frameAdd:"+frameAdd+", x:"+x+", y:"+y+", width:"+width+", height:"+height+", foreground"+foreground+"]", NOTE_TYPE_DONE);

        return returnLabel;
    }
    public static JTextField getTextFieldNullLayout(String text, Font font, JFrame frameAdd, int x, int y, int width, int height, Color background, Color foreground) {
//        printNote("Making new JTextField", NOTE_TYPE_PROCESS);
        JTextField returnText = new JTextField(text);
        returnText.setFont(font);
        frameAdd.add(returnText);
        returnText.setBounds(x, y, width, height);
        returnText.setBackground(background);
        returnText.setForeground(foreground);
//        printNote("Making new JTextField [text:"+text+", font:"+font+", frameAdd:"+frameAdd+", x:"+x+", y:"+y+", width:"+width+", height:"+height+", foreground"+foreground+"]", NOTE_TYPE_DONE);

        return returnText;
    }
    public static JTextArea getTextAreaNullLayout(String text, Font font, JFrame frameAdd, int x, int y, int width, int height, Color background, Color foreground) {
//        printNote("Making new JTextArea", NOTE_TYPE_PROCESS);
        JTextArea returnText = new JTextArea(text);
        returnText.setFont(font);
        frameAdd.add(returnText);
        returnText.setBounds(x, y, width, height);
        returnText.setBackground(background);
        returnText.setForeground(foreground);
//        printNote("Making new JTextArea [text:"+text+", font:"+font+", frameAdd:"+frameAdd+", x:"+x+", y:"+y+", width:"+width+", height:"+height+", foreground"+foreground+"]", NOTE_TYPE_DONE);

        return returnText;
    }


    public static Card returnTypeOfNearbyCardByName(Card card) {
        Card returnCard = null;
        switch (card.name) {
            case "Wood":
                returnCard = new CardWood();
                break;
            case "Stone":
                returnCard = new CardStone();
                break;
            case "SmallStone":
                returnCard = new CardSmallStone();
                break;
            case "Water":
                returnCard = new CardWater();
                break;
            case "Gold":
                returnCard = new CardGold();
                break;
            case "Diamond":
                returnCard = new CardDiamond();
                break;
        }
        return returnCard;
    }

    public static int GCD(int a,int b){
        return b == 0 ? a : GCD(b,a % b);
    }

    public static int LCM(int a,int b){
        return a / GCD(a,b) * b;
    }

    public static int LCM(int a, int b, int c) {
        return LCM(a,LCM(b,c));
    }



    public static Object getFromTheServer(String host, int port) {
        try {
            printNote("Getting object from the server", NOTE_TYPE_PROCESS);
            Socket socket = new Socket(host, port);

            InputStreamReader streamReader = new InputStreamReader(socket.getInputStream());
            BufferedReader bufferedReader = new BufferedReader(streamReader);

            String returnObject = bufferedReader.readLine();

            bufferedReader.close();
            printNote("Getting object [returnObject:"+returnObject+"] from the server [host:"+host+", port:"+port+"]", NOTE_TYPE_DONE);
            return returnObject;
        } catch (IOException ex) {
            printNote("Getting object [host:"+host+", port:"+port+"] from the server", NOTE_TYPE_ERROR);
            ex.printStackTrace();
        }
        return null;
    }

    public static void sendToTheServer(String host, int port, Object sendObject) {
        try {
            printNote("Sending object to the server", NOTE_TYPE_PROCESS);
            Socket socket = new Socket(host, port);
            PrintWriter writer = new PrintWriter(socket.getOutputStream());
            writer.println(sendObject);
            writer.close();

            printNote("Sending object [sendObject:"+sendObject+"] to the server [host:"+host+", port:"+port+"]", NOTE_TYPE_DONE);
        } catch (IOException ex) {
            printNote("Sending object [sendObject:"+sendObject+"] to the server [host:"+host+", port:"+port+"]", NOTE_TYPE_ERROR);
            ex.printStackTrace();
        }
    }
}
