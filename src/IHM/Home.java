package IHM;
import javax.swing.*;
import javax.swing.filechooser.FileSystemView;
import java.awt.*;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.io.*;
import java.sql.*;

public class Home extends MyPanel {

    //declarations
    private Color Dracula = new Color(45, 52, 54);
    private Color backColor = new Color(230, 145, 56);

    private Label lessonsL = new Label("Tahoma", Font.PLAIN, 14, backColor, "Lessons");
    private Label lessonsSeeAll = new Label("Tahoma", Font.PLAIN, 14, backColor, "See All        ");
    private Label importantL = new Label("Tahoma", Font.PLAIN, 14, backColor, "Important");
    private Label importantSeeAll = new Label("Tahoma", Font.PLAIN, 14, backColor, "See All          ");
    private Label videosL = new Label("Tahoma", Font.PLAIN, 14, backColor, "Videos");
    private Label videosSeeAll = new Label("Tahoma", Font.PLAIN, 14, backColor, "See All           ");
    private Label addLesson = new Label();
    private Label addNews = new Label();
    private Label addVideo = new Label();

    private MyPanel lessonsP = new MyPanel(Dracula);
    private MyPanel lessonsPC = new MyPanel(Dracula);
    private MyPanel importantP = new MyPanel(Dracula);
    private MyPanel importantPC = new MyPanel(Dracula);
    private MyPanel videosP = new MyPanel(Dracula);
    private MyPanel videosPC = new MyPanel(Dracula);
    private MyPanel quoteP = new MyPanel(Dracula);
    private MyPanel empty1 = new MyPanel(Dracula);
    private MyPanel empty2 = new MyPanel(Dracula);
    private MyPanel empty3 = new MyPanel(Dracula);
    private MyPanel empty4 = new MyPanel(Dracula);
    private MyPanel empty5 = new MyPanel(Dracula);
    private MyPanel empty6 = new MyPanel(Dracula);

    private SeeAll lessonsSA = new SeeAll("lesson");
    private SeeAll importantSA = new SeeAll("news");
    private SeeAll videosSA = new SeeAll("video");

    private JScrollPane lessonJP = new JScrollPane();
    private JScrollPane importantJP = new JScrollPane();
    private JScrollPane videoJP = new JScrollPane();

    private ImageIcon addIcon;

    public Home(ResultSet rsu) throws SQLException, ClassNotFoundException {

        lessonJP.setViewportView(lessonsSA);
        importantJP.setViewportView(importantSA);
        videoJP.setViewportView(videosSA);

        lessonJP.setBackground(Dracula);
        importantJP.setBackground(Dracula);
        videoJP.setBackground(Dracula);

        //lessonPC
        lessonsPC.setLayout(new GridLayout());
        String query = "select * from lesson";
        Connection con = dbConnection.getConnection() ;
        PreparedStatement ps = con.prepareStatement(query);
        ResultSet rs = ps.executeQuery();
        for(int i=0; rs.next() && i<4; i++)
        {
           lessonsPC.add(new dataField(rs,"lesson"));
        }

        //add a lesson function
        addIcon = new ImageIcon("icons8-add-file-400.png");
        addLesson.setIcon(addIcon);
        addLesson.setText("Add a lesson");
        addLesson.setForeground(backColor);
        addLesson.setHorizontalTextPosition(JLabel.CENTER);
        addLesson.setVerticalTextPosition(JLabel.BOTTOM);
        lessonsPC.add(addLesson);

        //newsPC
        importantPC.setLayout(new GridLayout());
        String queryN = "select * from news";
        PreparedStatement psn = con.prepareStatement(queryN);
        ResultSet rsn = psn.executeQuery();
        for(int i=0; rsn.next() && i<4; i++)
        {
            importantPC.add(new dataField(rsn,"news"));
        }

        //add a news function
        addIcon = new ImageIcon("icons8-add-image-100.png");
        addNews.setIcon(addIcon);
        addNews.setText("Add news");
        addNews.setForeground(backColor);
        addNews.setHorizontalTextPosition(JLabel.CENTER);
        addNews.setVerticalTextPosition(JLabel.BOTTOM);
        importantPC.add(addNews);

        //videoPC
        videosPC.setLayout(new GridLayout());
        String queryV = "select * from video";
        PreparedStatement psv = con.prepareStatement(queryV);
        ResultSet rsv = psv.executeQuery();
        for(int i=0; rsv.next() && i<4; i++)
        {
            videosPC.add(new dataField(rsv,"video"));
        }

        //add a video function
        //addIcon = new ImageIcon("IHMer.png");
        addVideo.setIcon(addIcon);
        addVideo.setText("Add video");
        addVideo.setForeground(backColor);
        addVideo.setHorizontalTextPosition(JLabel.CENTER);
        addVideo.setVerticalTextPosition(JLabel.BOTTOM);
        videosPC.add(addVideo);

        //lessonsP
        empty1.setPreferredSize(new Dimension(10,20));
        empty2.setPreferredSize(new Dimension(10,20));
        //init
        lessonsP.setLayout(new GridBagLayout());
        GridBagConstraints lessGBC = new GridBagConstraints();
        lessGBC.weightx = 1;
        lessGBC.fill = GridBagConstraints.NONE;
        lessGBC.gridx = 0;
        lessGBC.gridy = 0;
        lessGBC.anchor = GridBagConstraints.FIRST_LINE_START;
        //empty space
        lessonsP.add(empty1, lessGBC);
        //adding lessons label

        lessGBC.gridx = 1;

        lessonsP.add(lessonsL, lessGBC);
        //adding see all label
        lessGBC.weightx = 1;
        lessGBC.gridy = 1;
        lessonsP.add(lessonsSeeAll, lessGBC);

        //adding squares field
        lessGBC.gridx=2;
        lessGBC.gridy=1;
        lessonsP.add(lessonsPC, lessGBC);
        lessGBC.weightx = 200;
        lessGBC.gridx=3;
        lessonsP.add(empty2, lessGBC);

        //importantP
        empty3.setPreferredSize(new Dimension(10,20));
        empty4.setPreferredSize(new Dimension(10,20));
        //init
        importantP.setLayout(new GridBagLayout());
        GridBagConstraints impGBC = new GridBagConstraints();
        impGBC.weightx = 1;
        impGBC.fill = GridBagConstraints.NONE;
        impGBC.gridx = 0;
        impGBC.gridy = 0;
        impGBC.anchor = GridBagConstraints.FIRST_LINE_START;
        //empty space
        importantP.add(empty3, impGBC);
        //adding important label

        impGBC.gridx = 1;

        importantP.add(importantL, impGBC);
        //adding see all label
        impGBC.weightx = 1;
        impGBC.gridy = 1;
        importantP.add(importantSeeAll, impGBC);

        //adding squares field
        impGBC.gridx=2;
        impGBC.gridy=1;
        importantP.add(importantPC, impGBC);
        impGBC.weightx = 200;
        impGBC.gridx=3;
        importantP.add(empty4, impGBC);

        //videosP
        empty5.setPreferredSize(new Dimension(10,20));
        empty6.setPreferredSize(new Dimension(10,20));
        //init
        videosP.setLayout(new GridBagLayout());
        GridBagConstraints vidGBC = new GridBagConstraints();
        vidGBC.weightx = 1;
        vidGBC.fill = GridBagConstraints.NONE;
        vidGBC.gridx = 0;
        vidGBC.gridy = 0;
        vidGBC.anchor = GridBagConstraints.FIRST_LINE_START;
        //empty space
        videosP.add(empty5, vidGBC);
        //adding important label

        vidGBC.gridx = 1;

        videosP.add(videosL, vidGBC);
        //adding see all label
        vidGBC.weightx = 1;
        vidGBC.gridy = 1;
        videosP.add(videosSeeAll, vidGBC);

        //adding squares field
        vidGBC.gridx=2;
        vidGBC.gridy=1;
        videosP.add(videosPC, vidGBC);
        vidGBC.weightx = 200;
        vidGBC.gridx=3;
        videosP.add(empty6, vidGBC);

        //quoteP


        this.setLayout(new GridLayout(0,1));
        this.add(lessonsP);
        this.add(importantP);
        this.add(videosP);
        //this.add(quoteP);

        addLesson.addMouseListener(new MouseListener() {
            @Override
            public void mouseClicked(MouseEvent e)
            {
                try {
                    addLessonMouseClicked(rsu);
                } catch (SQLException | ClassNotFoundException | FileNotFoundException ex) {
                    ex.printStackTrace();
                }
            }

            @Override
            public void mousePressed(MouseEvent e) {

            }

            @Override
            public void mouseReleased(MouseEvent e) {

            }

            @Override
            public void mouseEntered(MouseEvent e) {

            }

            @Override
            public void mouseExited(MouseEvent e) {

            }
        });

        addNews.addMouseListener(new MouseListener() {
            @Override
            public void mouseClicked(MouseEvent e) {
                try {
                    addNewsMouseClicked(rsu);
                } catch (FileNotFoundException | ClassNotFoundException | SQLException ex) {
                    ex.printStackTrace();
                }
            }

            @Override
            public void mousePressed(MouseEvent e) {

            }

            @Override
            public void mouseReleased(MouseEvent e) {

            }

            @Override
            public void mouseEntered(MouseEvent e) {

            }

            @Override
            public void mouseExited(MouseEvent e) {

            }
        });

        addVideo.addMouseListener(new MouseListener() {
            @Override
            public void mouseClicked(MouseEvent e) {
                try {
                    addVideoMouseClicked(rsu);
                } catch (FileNotFoundException | SQLException | ClassNotFoundException ex) {
                    ex.printStackTrace();
                }
            }

            @Override
            public void mousePressed(MouseEvent e) {

            }

            @Override
            public void mouseReleased(MouseEvent e) {

            }

            @Override
            public void mouseEntered(MouseEvent e) {

            }

            @Override
            public void mouseExited(MouseEvent e) {

            }
        });

        lessonsSeeAll.addMouseListener(new MouseListener() {
            @Override
            public void mouseClicked(MouseEvent e) {
                lessonsSeeAllMouseClicked();
            }

            @Override
            public void mousePressed(MouseEvent e) {

            }

            @Override
            public void mouseReleased(MouseEvent e) {

            }

            @Override
            public void mouseEntered(MouseEvent e) {

            }

            @Override
            public void mouseExited(MouseEvent e) {

            }
        });

        importantSeeAll.addMouseListener(new MouseListener() {
            @Override
            public void mouseClicked(MouseEvent e) {
                importantSeeAllMouseClicked();
            }

            @Override
            public void mousePressed(MouseEvent e) {

            }

            @Override
            public void mouseReleased(MouseEvent e) {

            }

            @Override
            public void mouseEntered(MouseEvent e) {

            }

            @Override
            public void mouseExited(MouseEvent e) {

            }
        });

        videosSeeAll.addMouseListener(new MouseListener() {
            @Override
            public void mouseClicked(MouseEvent e) {
                videosSeeAllMouseClicked();
            }

            @Override
            public void mousePressed(MouseEvent e) {

            }

            @Override
            public void mouseReleased(MouseEvent e) {

            }

            @Override
            public void mouseEntered(MouseEvent e) {

            }

            @Override
            public void mouseExited(MouseEvent e) {

            }
        });
    }

    private void addLessonMouseClicked(ResultSet rsu) throws SQLException, ClassNotFoundException, FileNotFoundException {
        this.add(rsu,"lesson");
    }

    private void addNewsMouseClicked(ResultSet rsu) throws FileNotFoundException, SQLException, ClassNotFoundException {
        this.add(rsu,"news");
    }

    private void addVideoMouseClicked(ResultSet rsu) throws FileNotFoundException, SQLException, ClassNotFoundException {
        this.add(rsu,"video");
    }

    private void add(ResultSet rsu,String type) throws FileNotFoundException, SQLException, ClassNotFoundException {

        JLabel l = new JLabel();
        JFileChooser j = new JFileChooser(FileSystemView.getFileSystemView().getHomeDirectory());

        // invoke the showsOpenDialog function to show the save dialog
        int r = j.showOpenDialog(null);

        // if the user selects a file
        if (r == JFileChooser.APPROVE_OPTION)

        {
            // set the label to the path of the selected file
            l.setText(j.getSelectedFile().getAbsolutePath());
        }

        File file = new File(l.getText());
        FileInputStream input = new FileInputStream(file);
        JOptionPane.showMessageDialog( null, l.getText());

        String queryS = "SELECT idt FROM teacher WHERE idus = ?";
        String queryI = "insert into "+type+" (idt, "+type+", name)"+"VALUES (?,?,?)";

//        JOptionPane.showMessageDialog( null, rsu.getInt("idus"));

        Connection con = dbConnection.getConnection();
        PreparedStatement ps = con.prepareStatement(queryS, Statement.RETURN_GENERATED_KEYS);
        ps.setInt(1, rsu.getInt("idus"));
        JOptionPane.showMessageDialog( null, "connection established and statement created");


        JOptionPane.showMessageDialog( null, "statement ready");
        System.out.print(ps);
        ResultSet rsS= ps.executeQuery();
        rsS.next();
        JOptionPane.showMessageDialog( null, "executed");

        PreparedStatement ps1 = con.prepareStatement(queryI);

        JOptionPane.showMessageDialog( null, rsS.getInt("idt"));
        ps1.setInt(1, rsS.getInt("idt"));
        ps1.setBlob(2, input);
        ps1.setString(3, file.getName());
        ps1.execute();
        this.repaint();
    }

    private void videosSeeAllMouseClicked()
    {
        this.removeAll();
        this.add(videoJP);
        this.repaint();
    }

    private void importantSeeAllMouseClicked()
    {
        this.removeAll();
        this.add(importantJP);
        this.repaint();
    }

    private void lessonsSeeAllMouseClicked()
    {
        this.removeAll();
        this.add(lessonJP);
        this.repaint();
    }


    public void reShow()
    {
        this.removeAll();
        this.add(lessonsP);
        this.add(importantP);
        this.add(videosP);
        this.add(quoteP);
        this.repaint();
    }

}