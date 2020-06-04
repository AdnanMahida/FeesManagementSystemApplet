/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package feesmanagment;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JOptionPane;
import java.text.SimpleDateFormat;
import javax.swing.Timer;
import javax.swing.table.DefaultTableModel;
import java.util.Date;
import java.util.Calendar;
import java.util.GregorianCalendar;
import javax.swing.ButtonGroup;
import java.io.*;
import javax.swing.*;
import javax.swing.table.TableRowSorter;

/**
 *
 * @author Adnan
 */
public class Cashier_home extends javax.swing.JFrame {

    int courseid;
    byte[] photo = null;
    String filename = null;
    int i = 1;
    double ffees = 0;
    Connect c = new Connect();
    public String name;
    double paid;

    public void label(String s) {
        label_name.setText("Role Played By:-" + s);
    }

    void showDateTime() {
        new Timer(0, new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                Date d = new Date();
                SimpleDateFormat s = new SimpleDateFormat("dd-MM-yyyy");
                SimpleDateFormat sd = new SimpleDateFormat("hh:mm:ss a");
                label_datetime.setText("Date :-" + s.format(d) + " Time :-" + sd.format(d));

            }
        }).start();

    }

    private void fill_gr() {
        i++;
        text_admissiongr1.setText(String.valueOf(i));

    }

    private void gr() {
        try {

            String q = "SELECT * FROM `student_details`";
            c.rs = c.st.executeQuery(q);
            c.rs.last();
            int gr = c.rs.getInt(1) + 1;
            text_admissiongr.setText(String.valueOf(gr));
        } catch (Exception e) {
        }
    }

    private void groupButton() {

        ButtonGroup bg1 = new ButtonGroup();

        bg1.add(radiobutton_male);
        bg1.add(radiobutton_female);
    }

    void combobox_course() {
        try {
            String q = "SELECT * FROM `course_details`";
            c.ps = c.cn.prepareStatement(q);
            c.rs = c.ps.executeQuery();
            while (c.rs.next()) {
                courseid = Integer.parseInt(c.rs.getString("course_id"));
                String course = c.rs.getString("course_name");
                combobox_course.addItem(course);
                combobox_managecourse.addItem(course);
                combobox_course1.addItem(course);
//                   combobox_course1.addItem(course);

            }
        } catch (Exception e) {
        }
    }

    public Cashier_home() {

        this.setUndecorated(true); //remove title bar
        // this.setAlwaysOnTop(true); //for top
        this.setResizable(false);
        initComponents();
        //mode of payment//////////////
        label_bankname.setVisible(false);
        label_paymentcompany.setVisible(false);
        combobox_paymentname.setVisible(false);
        combobox_paymentbankname.setVisible(false);
        label_chequeno.setVisible(false);
        text_chequeno.setVisible(false);
        panel_coursemanage.setVisible(false);
        panel_info.setVisible(false);
        panel_duefees.setVisible(true);
        // panel_home.setVisible(false);
        ///////////////////////////////////////
        showDateTime();
        combobox_course();
        groupButton();
        gr();
        fill_gr();
        autoaddmissiondate();
        table_duefees();
        panel_home.setVisible(true);
        panel_newadmission.setVisible(false);
        panel_managestudent.setVisible(false);
        panel_addnewfees.setVisible(false);
        panel_coursemanage.setVisible(false);
        panel_info.setVisible(false);
        panel_duefees.setVisible(false);
        table_student();

        table_all_student("active");
    }

    private void autoaddmissiondate() {
        try {
            Calendar ca = new GregorianCalendar();
            String day = ca.get(Calendar.DAY_OF_MONTH) + "";
            String month = ca.get(Calendar.MONTH) + 1 + "";
            String year = ca.get(Calendar.YEAR) + "";

            if (day.length() == 1) {
                day = "0" + day;
            }
            if (month.length() == 1) {
                month = "0" + month;
            }

            String dd = year + "-" + month + "-" + day;

            Date date = new SimpleDateFormat("yyyy-MM-dd").parse(dd);
            admission_date.setDate(date);
            addfees_date.setDate(date);
        } catch (Exception e) {
        }
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        panel_home = new javax.swing.JPanel();
        panel_addfees = new javax.swing.JPanel();
        label_newadmission = new javax.swing.JLabel();
        panel_new_admission = new javax.swing.JPanel();
        label_newadmission1 = new javax.swing.JLabel();
        panel_managestudemt = new javax.swing.JPanel();
        label_newadmission2 = new javax.swing.JLabel();
        panel_addfees1 = new javax.swing.JPanel();
        label_newadmission3 = new javax.swing.JLabel();
        panel_addfees2 = new javax.swing.JPanel();
        label_course_manage = new javax.swing.JLabel();
        panel_addfees3 = new javax.swing.JPanel();
        label_newadmission5 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        admin_slidepanel = new javax.swing.JPanel();
        label_name = new javax.swing.JLabel();
        label_titlebar = new javax.swing.JLabel();
        panel_cashierlogout = new javax.swing.JPanel();
        jLabel2 = new javax.swing.JLabel();
        panel_cashierhome = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        label_icon = new javax.swing.JLabel();
        jPanel1 = new javax.swing.JPanel();
        btn_close = new javax.swing.JButton();
        btn_minimize = new javax.swing.JButton();
        label_datetime = new javax.swing.JLabel();
        panel_newadmission = new javax.swing.JPanel();
        Label = new javax.swing.JLabel();
        text_admissiongr = new javax.swing.JTextField();
        text_admissionname = new javax.swing.JTextField();
        Label1 = new javax.swing.JLabel();
        Label2 = new javax.swing.JLabel();
        text_admissioncity = new javax.swing.JTextField();
        Label3 = new javax.swing.JLabel();
        Label4 = new javax.swing.JLabel();
        Label5 = new javax.swing.JLabel();
        Label6 = new javax.swing.JLabel();
        Label7 = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        text_admissionaddress = new javax.swing.JTextArea();
        jSeparator1 = new javax.swing.JSeparator();
        Label8 = new javax.swing.JLabel();
        text_admissionimage = new javax.swing.JTextField();
        combobox_course = new javax.swing.JComboBox<>();
        btn_admissionuploadimage = new javax.swing.JButton();
        btn_addadmission = new javax.swing.JButton();
        Label9 = new javax.swing.JLabel();
        admission_date = new com.toedter.calendar.JDateChooser();
        birth_date = new com.toedter.calendar.JDateChooser();
        radiobutton_female = new javax.swing.JRadioButton();
        radiobutton_male = new javax.swing.JRadioButton();
        text_admissioncontact = new javax.swing.JTextField();
        btn_addadmissionclear = new javax.swing.JButton();
        desktoppane_image = new javax.swing.JDesktopPane();
        label_image = new javax.swing.JLabel();
        panel_managestudent = new javax.swing.JPanel();
        Label10 = new javax.swing.JLabel();
        text_managegr = new javax.swing.JTextField();
        text_managename = new javax.swing.JTextField();
        Label11 = new javax.swing.JLabel();
        Label12 = new javax.swing.JLabel();
        text_managecity = new javax.swing.JTextField();
        Label13 = new javax.swing.JLabel();
        Label14 = new javax.swing.JLabel();
        Label15 = new javax.swing.JLabel();
        Label16 = new javax.swing.JLabel();
        jScrollPane2 = new javax.swing.JScrollPane();
        text_manageaddress = new javax.swing.JTextArea();
        jSeparator2 = new javax.swing.JSeparator();
        Label18 = new javax.swing.JLabel();
        combobox_managecourse = new javax.swing.JComboBox<>();
        btn_updatestudent = new javax.swing.JButton();
        Label19 = new javax.swing.JLabel();
        birth_managedate = new com.toedter.calendar.JDateChooser();
        radiobutton_female1 = new javax.swing.JRadioButton();
        radiobutton_male1 = new javax.swing.JRadioButton();
        text_managecontact = new javax.swing.JTextField();
        btn_cancelstudent = new javax.swing.JButton();
        jScrollPane3 = new javax.swing.JScrollPane();
        table_student = new javax.swing.JTable();
        btn_refrashstudent = new javax.swing.JButton();
        text_searchstudent = new javax.swing.JTextField();
        btn_updatestudent1 = new javax.swing.JButton();
        panel_addnewfees = new javax.swing.JPanel();
        Label17 = new javax.swing.JLabel();
        text_admissiongr1 = new javax.swing.JTextField();
        text_addfeesgrno = new javax.swing.JTextField();
        Label20 = new javax.swing.JLabel();
        text_addfeename = new javax.swing.JTextField();
        Label22 = new javax.swing.JLabel();
        Label23 = new javax.swing.JLabel();
        Label26 = new javax.swing.JLabel();
        jSeparator3 = new javax.swing.JSeparator();
        Label27 = new javax.swing.JLabel();
        btn_addadmission1 = new javax.swing.JButton();
        Label28 = new javax.swing.JLabel();
        addfees_date = new com.toedter.calendar.JDateChooser();
        text_addfeestakenfees = new javax.swing.JTextField();
        btn_addfeesloadrecord = new javax.swing.JButton();
        btn_addadmissionclear2 = new javax.swing.JButton();
        Label24 = new javax.swing.JLabel();
        Label29 = new javax.swing.JLabel();
        text_addfeescoursename = new javax.swing.JTextField();
        Label30 = new javax.swing.JLabel();
        Label31 = new javax.swing.JLabel();
        text_addfeeswords = new javax.swing.JTextField();
        text_addfeestotalfees = new javax.swing.JTextField();
        Label32 = new javax.swing.JLabel();
        btn_addadmissionclear3 = new javax.swing.JButton();
        jScrollPane4 = new javax.swing.JScrollPane();
        text_manageaddress1 = new javax.swing.JTextArea();
        Label21 = new javax.swing.JLabel();
        text_receivedfrom = new javax.swing.JTextField();
        label_paymentcompany = new javax.swing.JLabel();
        text_mobileno = new javax.swing.JTextField();
        label_chequeno = new javax.swing.JLabel();
        label_receivedfrom = new javax.swing.JLabel();
        combobox_modeofpayment1 = new javax.swing.JComboBox<>();
        label_bankname = new javax.swing.JLabel();
        combobox_paymentname = new javax.swing.JComboBox<>();
        combobox_paymentbankname = new javax.swing.JComboBox<>();
        label_mobileno = new javax.swing.JLabel();
        text_chequeno = new javax.swing.JTextField();
        text_addfeescoursename1 = new javax.swing.JTextField();
        panel_coursemanage = new javax.swing.JPanel();
        Label25 = new javax.swing.JLabel();
        Label36 = new javax.swing.JLabel();
        combobox_course1 = new javax.swing.JComboBox<>();
        btn_addadmission2 = new javax.swing.JButton();
        btn_addadmissionclear1 = new javax.swing.JButton();
        Label33 = new javax.swing.JLabel();
        jSeparator4 = new javax.swing.JSeparator();
        jScrollPane6 = new javax.swing.JScrollPane();
        table_all_student = new javax.swing.JTable();
        text_searchcashier = new javax.swing.JTextField();
        Label34 = new javax.swing.JLabel();
        btn_refrashmanagecashier = new javax.swing.JButton();
        conbo_all_student = new javax.swing.JComboBox<>();
        Label39 = new javax.swing.JLabel();
        panel_info = new javax.swing.JPanel();
        btn_addadmissionclear4 = new javax.swing.JButton();
        Label37 = new javax.swing.JLabel();
        Label38 = new javax.swing.JLabel();
        jLabel_inven = new javax.swing.JLabel();
        jLabel_SoftZyd = new javax.swing.JLabel();
        Label41 = new javax.swing.JLabel();
        panel_duefees = new javax.swing.JPanel();
        btn_addadmissionclear5 = new javax.swing.JButton();
        Label40 = new javax.swing.JLabel();
        jScrollPane5 = new javax.swing.JScrollPane();
        table_duefees = new javax.swing.JTable();
        text_searchduefees = new javax.swing.JTextField();
        btn_refrashmanagecashier1 = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setBackground(new java.awt.Color(255, 255, 255));
        setFont(new java.awt.Font("Segoe UI Light", 0, 20)); // NOI18N
        setModalExclusionType(java.awt.Dialog.ModalExclusionType.APPLICATION_EXCLUDE);
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        panel_home.setBackground(new java.awt.Color(255, 255, 255));
        panel_home.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        panel_home.setPreferredSize(new java.awt.Dimension(260, 768));
        panel_home.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        panel_addfees.setBackground(new java.awt.Color(0, 181, 204));
        panel_addfees.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        label_newadmission.setFont(new java.awt.Font("Segoe UI Light", 0, 20)); // NOI18N
        label_newadmission.setForeground(new java.awt.Color(255, 255, 255));
        label_newadmission.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/info.png"))); // NOI18N
        label_newadmission.setText("Info");
        label_newadmission.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                label_newadmissionMouseClicked(evt);
            }
        });
        panel_addfees.add(label_newadmission, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 10, 270, 130));

        panel_home.add(panel_addfees, new org.netbeans.lib.awtextra.AbsoluteConstraints(750, 340, 290, 150));

        panel_new_admission.setBackground(new java.awt.Color(0, 181, 204));
        panel_new_admission.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        label_newadmission1.setFont(new java.awt.Font("Segoe UI Light", 0, 20)); // NOI18N
        label_newadmission1.setForeground(new java.awt.Color(255, 255, 255));
        label_newadmission1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/student-registration.png"))); // NOI18N
        label_newadmission1.setText("New Admission");
        label_newadmission1.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                label_newadmission1MouseClicked(evt);
            }
        });
        panel_new_admission.add(label_newadmission1, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 10, 270, 130));

        panel_home.add(panel_new_admission, new org.netbeans.lib.awtextra.AbsoluteConstraints(400, 100, 290, 150));

        panel_managestudemt.setBackground(new java.awt.Color(0, 181, 204));
        panel_managestudemt.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        label_newadmission2.setFont(new java.awt.Font("Segoe UI Light", 0, 20)); // NOI18N
        label_newadmission2.setForeground(new java.awt.Color(255, 255, 255));
        label_newadmission2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/icons8-admin-settings-male-100 (1).png"))); // NOI18N
        label_newadmission2.setText("Manage Student");
        label_newadmission2.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                label_newadmission2MouseClicked(evt);
            }
        });
        panel_managestudemt.add(label_newadmission2, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 10, 270, 130));

        panel_home.add(panel_managestudemt, new org.netbeans.lib.awtextra.AbsoluteConstraints(750, 100, 290, 150));

        panel_addfees1.setBackground(new java.awt.Color(0, 181, 204));
        panel_addfees1.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        label_newadmission3.setFont(new java.awt.Font("Segoe UI Light", 0, 20)); // NOI18N
        label_newadmission3.setForeground(new java.awt.Color(255, 255, 255));
        label_newadmission3.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/addmoney.png"))); // NOI18N
        label_newadmission3.setText("Add fees");
        label_newadmission3.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                label_newadmission3MouseClicked(evt);
            }
        });
        panel_addfees1.add(label_newadmission3, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 10, 260, 130));

        panel_home.add(panel_addfees1, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 100, 290, 150));

        panel_addfees2.setBackground(new java.awt.Color(0, 181, 204));
        panel_addfees2.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        label_course_manage.setFont(new java.awt.Font("Segoe UI Light", 0, 20)); // NOI18N
        label_course_manage.setForeground(new java.awt.Color(255, 255, 255));
        label_course_manage.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/icons8-course-assign-100.png"))); // NOI18N
        label_course_manage.setText("Course Manage");
        label_course_manage.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                label_course_manageMouseClicked(evt);
            }
        });
        panel_addfees2.add(label_course_manage, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 10, 260, 130));

        panel_home.add(panel_addfees2, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 340, 290, 150));

        panel_addfees3.setBackground(new java.awt.Color(0, 181, 204));
        panel_addfees3.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        label_newadmission5.setFont(new java.awt.Font("Segoe UI Light", 0, 20)); // NOI18N
        label_newadmission5.setForeground(new java.awt.Color(255, 255, 255));
        label_newadmission5.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/receipt.png"))); // NOI18N
        label_newadmission5.setText("Due Fees");
        label_newadmission5.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                label_newadmission5MouseClicked(evt);
            }
        });
        panel_addfees3.add(label_newadmission5, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 10, 270, 130));

        panel_home.add(panel_addfees3, new org.netbeans.lib.awtextra.AbsoluteConstraints(400, 340, 290, 150));

        jLabel3.setFont(new java.awt.Font("Segoe UI Light", 0, 36)); // NOI18N
        jLabel3.setForeground(new java.awt.Color(0, 181, 204));
        jLabel3.setText("Home");
        panel_home.add(jLabel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(60, 30, -1, -1));

        getContentPane().add(panel_home, new org.netbeans.lib.awtextra.AbsoluteConstraints(280, 40, 1090, 770));

        admin_slidepanel.setBackground(new java.awt.Color(0, 181, 204));
        admin_slidepanel.setPreferredSize(new java.awt.Dimension(280, 768));
        admin_slidepanel.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        label_name.setBackground(new java.awt.Color(255, 255, 255));
        label_name.setFont(new java.awt.Font("Segoe UI Light", 0, 18)); // NOI18N
        label_name.setForeground(new java.awt.Color(255, 255, 255));
        label_name.setText("role padfdffsdffdfsdf");
        admin_slidepanel.add(label_name, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 60, 210, 40));

        label_titlebar.setBackground(new java.awt.Color(0, 181, 204));
        label_titlebar.setFont(new java.awt.Font("SansSerif", 1, 25)); // NOI18N
        label_titlebar.setForeground(new java.awt.Color(255, 255, 255));
        label_titlebar.setText("Cashier Dashboard");
        admin_slidepanel.add(label_titlebar, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 10, 240, 40));

        panel_cashierlogout.setBackground(java.awt.Color.red);
        panel_cashierlogout.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel2.setBackground(new java.awt.Color(255, 255, 255));
        jLabel2.setFont(new java.awt.Font("Segoe UI Light", 0, 30)); // NOI18N
        jLabel2.setForeground(new java.awt.Color(255, 255, 255));
        jLabel2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icons/icons8-logout-rounded-left-32.png"))); // NOI18N
        jLabel2.setText("Log Out");
        jLabel2.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jLabel2MouseClicked(evt);
            }
        });
        panel_cashierlogout.add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 0, 220, 70));

        admin_slidepanel.add(panel_cashierlogout, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 430, 240, 70));

        panel_cashierhome.setBackground(new java.awt.Color(255, 255, 255));
        panel_cashierhome.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel1.setBackground(new java.awt.Color(0, 181, 204));
        jLabel1.setFont(new java.awt.Font("Segoe UI Light", 0, 30)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(0, 181, 204));
        jLabel1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icons/icons8-home-32.png"))); // NOI18N
        jLabel1.setText("Home");
        jLabel1.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jLabel1MouseClicked(evt);
            }
        });
        panel_cashierhome.add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 0, 220, 70));

        admin_slidepanel.add(panel_cashierhome, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 320, 240, 70));

        label_icon.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/cashier_IMG.png"))); // NOI18N
        admin_slidepanel.add(label_icon, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 110, 200, 190));

        getContentPane().add(admin_slidepanel, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 40, 280, 790));

        jPanel1.setBackground(new java.awt.Color(81, 99, 191));
        jPanel1.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        btn_close.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/close_window.png"))); // NOI18N
        btn_close.setContentAreaFilled(false);
        btn_close.setPreferredSize(new java.awt.Dimension(60, 40));
        btn_close.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_closeActionPerformed(evt);
            }
        });
        jPanel1.add(btn_close, new org.netbeans.lib.awtextra.AbsoluteConstraints(1320, 0, 50, 40));

        btn_minimize.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/minimize_window.png"))); // NOI18N
        btn_minimize.setContentAreaFilled(false);
        btn_minimize.setPreferredSize(new java.awt.Dimension(60, 40));
        btn_minimize.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_minimizeActionPerformed(evt);
            }
        });
        jPanel1.add(btn_minimize, new org.netbeans.lib.awtextra.AbsoluteConstraints(1280, 0, 40, 40));

        label_datetime.setFont(new java.awt.Font("Segoe UI Light", 0, 15)); // NOI18N
        label_datetime.setForeground(new java.awt.Color(255, 255, 255));
        label_datetime.setText("Time:-");
        jPanel1.add(label_datetime, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 0, 560, 40));

        getContentPane().add(jPanel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 1370, 40));

        panel_newadmission.setBackground(new java.awt.Color(255, 255, 255));
        panel_newadmission.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        Label.setFont(new java.awt.Font("Segoe UI Light", 0, 30)); // NOI18N
        Label.setText("Add New Admission");
        panel_newadmission.add(Label, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 10, 380, -1));

        text_admissiongr.setFont(new java.awt.Font("Segoe UI Light", 0, 25)); // NOI18N
        text_admissiongr.setBorder(javax.swing.BorderFactory.createMatteBorder(0, 0, 1, 0, new java.awt.Color(0, 0, 0)));
        text_admissiongr.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                text_admissiongrActionPerformed(evt);
            }
        });
        panel_newadmission.add(text_admissiongr, new org.netbeans.lib.awtextra.AbsoluteConstraints(230, 90, 270, 40));

        text_admissionname.setFont(new java.awt.Font("Segoe UI Light", 0, 25)); // NOI18N
        text_admissionname.setBorder(javax.swing.BorderFactory.createMatteBorder(0, 0, 1, 0, new java.awt.Color(0, 0, 0)));
        panel_newadmission.add(text_admissionname, new org.netbeans.lib.awtextra.AbsoluteConstraints(230, 170, 270, 40));

        Label1.setFont(new java.awt.Font("Segoe UI Light", 0, 25)); // NOI18N
        Label1.setText("Name");
        panel_newadmission.add(Label1, new org.netbeans.lib.awtextra.AbsoluteConstraints(60, 170, 90, 30));

        Label2.setFont(new java.awt.Font("Segoe UI Light", 0, 25)); // NOI18N
        Label2.setText("Address");
        panel_newadmission.add(Label2, new org.netbeans.lib.awtextra.AbsoluteConstraints(70, 370, 90, 30));

        text_admissioncity.setFont(new java.awt.Font("Segoe UI Light", 0, 25)); // NOI18N
        text_admissioncity.setBorder(javax.swing.BorderFactory.createMatteBorder(0, 0, 1, 0, new java.awt.Color(0, 0, 0)));
        panel_newadmission.add(text_admissioncity, new org.netbeans.lib.awtextra.AbsoluteConstraints(240, 540, 270, 40));

        Label3.setFont(new java.awt.Font("Segoe UI Light", 0, 25)); // NOI18N
        Label3.setText("City");
        panel_newadmission.add(Label3, new org.netbeans.lib.awtextra.AbsoluteConstraints(70, 550, 120, 30));

        Label4.setFont(new java.awt.Font("Segoe UI Light", 0, 25)); // NOI18N
        Label4.setText("Select Course");
        panel_newadmission.add(Label4, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 260, 150, 30));

        Label5.setFont(new java.awt.Font("Segoe UI Light", 0, 25)); // NOI18N
        Label5.setText("Date Of Birth");
        panel_newadmission.add(Label5, new org.netbeans.lib.awtextra.AbsoluteConstraints(580, 330, 150, 30));

        Label6.setFont(new java.awt.Font("Segoe UI Light", 0, 25)); // NOI18N
        Label6.setText("Gender");
        panel_newadmission.add(Label6, new org.netbeans.lib.awtextra.AbsoluteConstraints(580, 380, 90, 30));

        Label7.setFont(new java.awt.Font("Segoe UI Light", 0, 25)); // NOI18N
        Label7.setText("Addmission Date");
        panel_newadmission.add(Label7, new org.netbeans.lib.awtextra.AbsoluteConstraints(580, 480, -1, 30));

        text_admissionaddress.setColumns(20);
        text_admissionaddress.setFont(new java.awt.Font("Segoe UI Light", 0, 15)); // NOI18N
        text_admissionaddress.setRows(5);
        text_admissionaddress.setBorder(javax.swing.BorderFactory.createMatteBorder(0, 0, 1, 0, new java.awt.Color(0, 0, 0)));
        jScrollPane1.setViewportView(text_admissionaddress);

        panel_newadmission.add(jScrollPane1, new org.netbeans.lib.awtextra.AbsoluteConstraints(240, 340, 270, 180));

        jSeparator1.setForeground(new java.awt.Color(0, 181, 204));
        jSeparator1.setOrientation(javax.swing.SwingConstants.VERTICAL);
        panel_newadmission.add(jSeparator1, new org.netbeans.lib.awtextra.AbsoluteConstraints(540, 100, -1, 470));

        Label8.setFont(new java.awt.Font("Segoe UI Light", 0, 25)); // NOI18N
        Label8.setText("Contact no");
        panel_newadmission.add(Label8, new org.netbeans.lib.awtextra.AbsoluteConstraints(580, 550, 120, 30));

        text_admissionimage.setFont(new java.awt.Font("Segoe UI Light", 0, 25)); // NOI18N
        text_admissionimage.setBorder(javax.swing.BorderFactory.createMatteBorder(0, 0, 1, 0, new java.awt.Color(0, 0, 0)));
        panel_newadmission.add(text_admissionimage, new org.netbeans.lib.awtextra.AbsoluteConstraints(560, 240, 270, 40));

        combobox_course.setFont(new java.awt.Font("Segoe UI Light", 0, 15)); // NOI18N
        combobox_course.setBorder(javax.swing.BorderFactory.createMatteBorder(0, 0, 1, 0, new java.awt.Color(0, 0, 0)));
        panel_newadmission.add(combobox_course, new org.netbeans.lib.awtextra.AbsoluteConstraints(220, 250, 290, 50));

        btn_admissionuploadimage.setBackground(new java.awt.Color(0, 181, 204));
        btn_admissionuploadimage.setFont(new java.awt.Font("Segoe UI Light", 0, 20)); // NOI18N
        btn_admissionuploadimage.setText("Select Image");
        btn_admissionuploadimage.setBorder(javax.swing.BorderFactory.createMatteBorder(1, 1, 1, 1, new java.awt.Color(0, 181, 204)));
        btn_admissionuploadimage.setContentAreaFilled(false);
        btn_admissionuploadimage.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_admissionuploadimageActionPerformed(evt);
            }
        });
        panel_newadmission.add(btn_admissionuploadimage, new org.netbeans.lib.awtextra.AbsoluteConstraints(880, 240, 150, 50));

        btn_addadmission.setBackground(new java.awt.Color(0, 181, 204));
        btn_addadmission.setFont(new java.awt.Font("Segoe UI Light", 0, 20)); // NOI18N
        btn_addadmission.setText("Add");
        btn_addadmission.setBorder(javax.swing.BorderFactory.createMatteBorder(1, 1, 1, 1, new java.awt.Color(0, 181, 204)));
        btn_addadmission.setContentAreaFilled(false);
        btn_addadmission.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_addadmissionActionPerformed(evt);
            }
        });
        panel_newadmission.add(btn_addadmission, new org.netbeans.lib.awtextra.AbsoluteConstraints(230, 630, 260, 60));

        Label9.setFont(new java.awt.Font("Segoe UI Light", 0, 25)); // NOI18N
        Label9.setText("G.R. No.");
        panel_newadmission.add(Label9, new org.netbeans.lib.awtextra.AbsoluteConstraints(60, 90, 90, 30));
        panel_newadmission.add(admission_date, new org.netbeans.lib.awtextra.AbsoluteConstraints(790, 480, 260, 30));

        birth_date.setMaxSelectableDate(new java.util.Date(253370748671000L));
        birth_date.setMinSelectableDate(new java.util.Date(631135871000L));
        panel_newadmission.add(birth_date, new org.netbeans.lib.awtextra.AbsoluteConstraints(790, 320, 270, 30));

        radiobutton_female.setBackground(new java.awt.Color(255, 255, 255));
        radiobutton_female.setFont(new java.awt.Font("Segoe UI Light", 0, 22)); // NOI18N
        radiobutton_female.setText("Female");
        panel_newadmission.add(radiobutton_female, new org.netbeans.lib.awtextra.AbsoluteConstraints(840, 420, 110, -1));

        radiobutton_male.setBackground(new java.awt.Color(255, 255, 255));
        radiobutton_male.setFont(new java.awt.Font("Segoe UI Light", 0, 22)); // NOI18N
        radiobutton_male.setSelected(true);
        radiobutton_male.setText("Male");
        panel_newadmission.add(radiobutton_male, new org.netbeans.lib.awtextra.AbsoluteConstraints(840, 360, 100, -1));

        text_admissioncontact.setFont(new java.awt.Font("Segoe UI Light", 0, 25)); // NOI18N
        text_admissioncontact.setBorder(javax.swing.BorderFactory.createMatteBorder(0, 0, 1, 0, new java.awt.Color(0, 0, 0)));
        text_admissioncontact.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                text_admissioncontactActionPerformed(evt);
            }
        });
        panel_newadmission.add(text_admissioncontact, new org.netbeans.lib.awtextra.AbsoluteConstraints(750, 550, 270, 40));

        btn_addadmissionclear.setBackground(new java.awt.Color(0, 181, 204));
        btn_addadmissionclear.setFont(new java.awt.Font("Segoe UI Light", 0, 20)); // NOI18N
        btn_addadmissionclear.setText("Clear");
        btn_addadmissionclear.setBorder(javax.swing.BorderFactory.createMatteBorder(1, 1, 1, 1, new java.awt.Color(0, 181, 204)));
        btn_addadmissionclear.setContentAreaFilled(false);
        btn_addadmissionclear.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_addadmissionclearActionPerformed(evt);
            }
        });
        panel_newadmission.add(btn_addadmissionclear, new org.netbeans.lib.awtextra.AbsoluteConstraints(570, 630, 260, 60));

        desktoppane_image.setBackground(new java.awt.Color(0, 181, 204));
        desktoppane_image.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());
        desktoppane_image.add(label_image, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 190, 190));

        panel_newadmission.add(desktoppane_image, new org.netbeans.lib.awtextra.AbsoluteConstraints(850, 20, 190, 190));

        getContentPane().add(panel_newadmission, new org.netbeans.lib.awtextra.AbsoluteConstraints(280, 40, 1090, 730));

        panel_managestudent.setBackground(new java.awt.Color(255, 255, 255));
        panel_managestudent.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        Label10.setFont(new java.awt.Font("Segoe UI Light", 0, 30)); // NOI18N
        Label10.setText("Manage Student");
        panel_managestudent.add(Label10, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 10, 380, -1));

        text_managegr.setFont(new java.awt.Font("Segoe UI Light", 0, 25)); // NOI18N
        text_managegr.setBorder(javax.swing.BorderFactory.createMatteBorder(0, 0, 1, 0, new java.awt.Color(0, 0, 0)));
        panel_managestudent.add(text_managegr, new org.netbeans.lib.awtextra.AbsoluteConstraints(110, 90, 270, 40));

        text_managename.setFont(new java.awt.Font("Segoe UI Light", 0, 25)); // NOI18N
        text_managename.setBorder(javax.swing.BorderFactory.createMatteBorder(0, 0, 1, 0, new java.awt.Color(0, 0, 0)));
        panel_managestudent.add(text_managename, new org.netbeans.lib.awtextra.AbsoluteConstraints(110, 150, 270, 40));

        Label11.setFont(new java.awt.Font("Segoe UI Light", 0, 20)); // NOI18N
        Label11.setText("Name");
        panel_managestudent.add(Label11, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 160, 90, 30));

        Label12.setFont(new java.awt.Font("Segoe UI Light", 0, 20)); // NOI18N
        Label12.setText("Address");
        panel_managestudent.add(Label12, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 280, 90, 30));

        text_managecity.setFont(new java.awt.Font("Segoe UI Light", 0, 25)); // NOI18N
        text_managecity.setBorder(javax.swing.BorderFactory.createMatteBorder(0, 0, 1, 0, new java.awt.Color(0, 0, 0)));
        panel_managestudent.add(text_managecity, new org.netbeans.lib.awtextra.AbsoluteConstraints(140, 440, 270, 40));

        Label13.setFont(new java.awt.Font("Segoe UI Light", 0, 20)); // NOI18N
        Label13.setText("City");
        panel_managestudent.add(Label13, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 450, 120, 30));

        Label14.setFont(new java.awt.Font("Segoe UI Light", 0, 20)); // NOI18N
        Label14.setText("Selected Course");
        panel_managestudent.add(Label14, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 220, 140, 30));

        Label15.setFont(new java.awt.Font("Segoe UI Light", 0, 20)); // NOI18N
        Label15.setText("Date Of Birth");
        panel_managestudent.add(Label15, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 560, 150, 30));

        Label16.setFont(new java.awt.Font("Segoe UI Light", 0, 20)); // NOI18N
        Label16.setText("Gender");
        panel_managestudent.add(Label16, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 600, 110, 40));

        text_manageaddress.setColumns(20);
        text_manageaddress.setFont(new java.awt.Font("Segoe UI Light", 0, 15)); // NOI18N
        text_manageaddress.setRows(5);
        text_manageaddress.setBorder(javax.swing.BorderFactory.createMatteBorder(0, 0, 1, 0, new java.awt.Color(0, 0, 0)));
        jScrollPane2.setViewportView(text_manageaddress);

        panel_managestudent.add(jScrollPane2, new org.netbeans.lib.awtextra.AbsoluteConstraints(140, 290, 270, 140));

        jSeparator2.setForeground(new java.awt.Color(0, 181, 204));
        jSeparator2.setOrientation(javax.swing.SwingConstants.VERTICAL);
        panel_managestudent.add(jSeparator2, new org.netbeans.lib.awtextra.AbsoluteConstraints(432, 100, -1, 470));

        Label18.setFont(new java.awt.Font("Segoe UI Light", 0, 20)); // NOI18N
        Label18.setText("Contact no");
        panel_managestudent.add(Label18, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 500, 100, 30));

        combobox_managecourse.setFont(new java.awt.Font("Segoe UI Light", 0, 15)); // NOI18N
        combobox_managecourse.setBorder(javax.swing.BorderFactory.createMatteBorder(0, 0, 1, 0, new java.awt.Color(0, 0, 0)));
        panel_managestudent.add(combobox_managecourse, new org.netbeans.lib.awtextra.AbsoluteConstraints(180, 220, 220, 40));

        btn_updatestudent.setBackground(new java.awt.Color(0, 181, 204));
        btn_updatestudent.setFont(new java.awt.Font("Segoe UI Light", 0, 20)); // NOI18N
        btn_updatestudent.setText("Update");
        btn_updatestudent.setBorder(javax.swing.BorderFactory.createMatteBorder(1, 1, 1, 1, new java.awt.Color(0, 181, 204)));
        btn_updatestudent.setContentAreaFilled(false);
        btn_updatestudent.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_updatestudentActionPerformed(evt);
            }
        });
        panel_managestudent.add(btn_updatestudent, new org.netbeans.lib.awtextra.AbsoluteConstraints(540, 620, 170, 40));

        Label19.setFont(new java.awt.Font("Segoe UI Light", 0, 20)); // NOI18N
        Label19.setText("G.R. No.");
        panel_managestudent.add(Label19, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 100, 90, 30));
        panel_managestudent.add(birth_managedate, new org.netbeans.lib.awtextra.AbsoluteConstraints(170, 560, 250, 30));

        radiobutton_female1.setBackground(new java.awt.Color(255, 255, 255));
        radiobutton_female1.setFont(new java.awt.Font("Segoe UI Light", 0, 20)); // NOI18N
        radiobutton_female1.setText("Female");
        panel_managestudent.add(radiobutton_female1, new org.netbeans.lib.awtextra.AbsoluteConstraints(260, 610, 120, 30));

        radiobutton_male1.setBackground(new java.awt.Color(255, 255, 255));
        radiobutton_male1.setFont(new java.awt.Font("Segoe UI Light", 0, 20)); // NOI18N
        radiobutton_male1.setSelected(true);
        radiobutton_male1.setText("Male");
        panel_managestudent.add(radiobutton_male1, new org.netbeans.lib.awtextra.AbsoluteConstraints(150, 610, 110, 30));

        text_managecontact.setFont(new java.awt.Font("Segoe UI Light", 0, 25)); // NOI18N
        text_managecontact.setBorder(javax.swing.BorderFactory.createMatteBorder(0, 0, 1, 0, new java.awt.Color(0, 0, 0)));
        panel_managestudent.add(text_managecontact, new org.netbeans.lib.awtextra.AbsoluteConstraints(140, 490, 270, 40));

        btn_cancelstudent.setBackground(new java.awt.Color(0, 181, 204));
        btn_cancelstudent.setFont(new java.awt.Font("Segoe UI Light", 0, 20)); // NOI18N
        btn_cancelstudent.setText("Cancel admission");
        btn_cancelstudent.setBorder(javax.swing.BorderFactory.createMatteBorder(1, 1, 1, 1, new java.awt.Color(0, 181, 204)));
        btn_cancelstudent.setContentAreaFilled(false);
        btn_cancelstudent.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_cancelstudentActionPerformed(evt);
            }
        });
        panel_managestudent.add(btn_cancelstudent, new org.netbeans.lib.awtextra.AbsoluteConstraints(900, 620, 170, 40));

        table_student.setAutoCreateRowSorter(true);
        table_student.setBackground(new java.awt.Color(0, 181, 204));
        table_student.setBorder(new javax.swing.border.MatteBorder(null));
        table_student.setFont(new java.awt.Font("Segoe UI Light", 0, 20)); // NOI18N
        table_student.setForeground(new java.awt.Color(255, 255, 255));
        table_student.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "GR no", "Name", "Selected Course", "Address", "City", "Contect no", "Date of Birth", "Gender"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false, false, false, false, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        table_student.setIntercellSpacing(new java.awt.Dimension(0, 0));
        table_student.setRowHeight(20);
        table_student.setSelectionBackground(new java.awt.Color(0, 181, 255));
        table_student.setShowVerticalLines(true
        );
        table_student.getTableHeader().setReorderingAllowed(false);
        table_student.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                table_studentMouseClicked(evt);
            }
        });
        jScrollPane3.setViewportView(table_student);
        if (table_student.getColumnModel().getColumnCount() > 0) {
            table_student.getColumnModel().getColumn(5).setHeaderValue("Contect no");
            table_student.getColumnModel().getColumn(6).setHeaderValue("Date of Birth");
            table_student.getColumnModel().getColumn(7).setHeaderValue("Gender");
        }

        panel_managestudent.add(jScrollPane3, new org.netbeans.lib.awtextra.AbsoluteConstraints(470, 120, 600, 470));

        btn_refrashstudent.setBackground(new java.awt.Color(0, 181, 204));
        btn_refrashstudent.setFont(new java.awt.Font("Segoe UI Light", 0, 20)); // NOI18N
        btn_refrashstudent.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/refresh.png"))); // NOI18N
        btn_refrashstudent.setContentAreaFilled(false);
        btn_refrashstudent.setName("Refrash"); // NOI18N
        btn_refrashstudent.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_refrashstudentActionPerformed(evt);
            }
        });
        panel_managestudent.add(btn_refrashstudent, new org.netbeans.lib.awtextra.AbsoluteConstraints(930, 60, 40, 30));

        text_searchstudent.setFont(new java.awt.Font("Segoe UI Light", 0, 20)); // NOI18N
        text_searchstudent.setText("Search Student");
        text_searchstudent.setBorder(javax.swing.BorderFactory.createMatteBorder(0, 0, 1, 0, new java.awt.Color(0, 0, 0)));
        text_searchstudent.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                text_searchstudentMouseClicked(evt);
            }
        });
        text_searchstudent.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                text_searchstudentKeyReleased(evt);
            }
        });
        panel_managestudent.add(text_searchstudent, new org.netbeans.lib.awtextra.AbsoluteConstraints(470, 50, 440, 50));

        btn_updatestudent1.setBackground(new java.awt.Color(0, 181, 204));
        btn_updatestudent1.setFont(new java.awt.Font("Segoe UI Light", 0, 20)); // NOI18N
        btn_updatestudent1.setText("Add Fees");
        btn_updatestudent1.setBorder(javax.swing.BorderFactory.createMatteBorder(1, 1, 1, 1, new java.awt.Color(0, 181, 204)));
        btn_updatestudent1.setContentAreaFilled(false);
        btn_updatestudent1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_updatestudent1ActionPerformed(evt);
            }
        });
        panel_managestudent.add(btn_updatestudent1, new org.netbeans.lib.awtextra.AbsoluteConstraints(720, 620, 170, 40));

        getContentPane().add(panel_managestudent, new org.netbeans.lib.awtextra.AbsoluteConstraints(280, 40, 1090, 730));

        panel_addnewfees.setBackground(new java.awt.Color(255, 255, 255));
        panel_addnewfees.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        Label17.setFont(new java.awt.Font("Segoe UI Light", 0, 30)); // NOI18N
        Label17.setText("Add Fees");
        panel_addnewfees.add(Label17, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 10, 380, -1));

        text_admissiongr1.setFont(new java.awt.Font("Segoe UI Light", 0, 25)); // NOI18N
        text_admissiongr1.setBorder(javax.swing.BorderFactory.createMatteBorder(0, 0, 1, 0, new java.awt.Color(0, 0, 0)));
        text_admissiongr1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                text_admissiongr1ActionPerformed(evt);
            }
        });
        panel_addnewfees.add(text_admissiongr1, new org.netbeans.lib.awtextra.AbsoluteConstraints(160, 80, 360, 40));

        text_addfeesgrno.setFont(new java.awt.Font("Segoe UI Light", 0, 25)); // NOI18N
        text_addfeesgrno.setBorder(javax.swing.BorderFactory.createMatteBorder(0, 0, 1, 0, new java.awt.Color(0, 0, 0)));
        panel_addnewfees.add(text_addfeesgrno, new org.netbeans.lib.awtextra.AbsoluteConstraints(160, 140, 210, 30));

        Label20.setFont(new java.awt.Font("Segoe UI Light", 0, 25)); // NOI18N
        Label20.setText("G.R. No.");
        panel_addnewfees.add(Label20, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 140, 100, 30));

        text_addfeename.setFont(new java.awt.Font("Segoe UI Light", 0, 25)); // NOI18N
        text_addfeename.setBorder(javax.swing.BorderFactory.createMatteBorder(0, 0, 1, 0, new java.awt.Color(0, 0, 0)));
        panel_addnewfees.add(text_addfeename, new org.netbeans.lib.awtextra.AbsoluteConstraints(160, 180, 360, 40));

        Label22.setFont(new java.awt.Font("Segoe UI Light", 0, 25)); // NOI18N
        Label22.setText("Name");
        panel_addnewfees.add(Label22, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 190, 120, 30));

        Label23.setFont(new java.awt.Font("Segoe UI Light", 0, 25)); // NOI18N
        Label23.setText("Selected Course");
        panel_addnewfees.add(Label23, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 240, 180, 30));

        Label26.setFont(new java.awt.Font("Segoe UI Light", 0, 25)); // NOI18N
        Label26.setText("Date");
        panel_addnewfees.add(Label26, new org.netbeans.lib.awtextra.AbsoluteConstraints(740, 20, -1, 30));

        jSeparator3.setForeground(new java.awt.Color(0, 181, 204));
        jSeparator3.setOrientation(javax.swing.SwingConstants.VERTICAL);
        panel_addnewfees.add(jSeparator3, new org.netbeans.lib.awtextra.AbsoluteConstraints(540, 100, -1, 370));

        Label27.setFont(new java.awt.Font("Segoe UI Light", 0, 25)); // NOI18N
        Label27.setText("Taken Fees");
        panel_addnewfees.add(Label27, new org.netbeans.lib.awtextra.AbsoluteConstraints(550, 190, 160, 30));

        btn_addadmission1.setBackground(new java.awt.Color(0, 181, 204));
        btn_addadmission1.setFont(new java.awt.Font("Segoe UI Light", 0, 20)); // NOI18N
        btn_addadmission1.setText("Add Fees");
        btn_addadmission1.setBorder(javax.swing.BorderFactory.createMatteBorder(1, 1, 1, 1, new java.awt.Color(0, 181, 204)));
        btn_addadmission1.setContentAreaFilled(false);
        btn_addadmission1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_addadmission1ActionPerformed(evt);
            }
        });
        panel_addnewfees.add(btn_addadmission1, new org.netbeans.lib.awtextra.AbsoluteConstraints(270, 510, 120, 40));

        Label28.setFont(new java.awt.Font("Segoe UI Light", 0, 25)); // NOI18N
        Label28.setText("Receipt no");
        panel_addnewfees.add(Label28, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 90, 120, 30));

        addfees_date.setBorder(javax.swing.BorderFactory.createMatteBorder(0, 0, 1, 0, new java.awt.Color(0, 0, 0)));
        addfees_date.setMinSelectableDate(new java.util.Date(-62135785729000L));
        panel_addnewfees.add(addfees_date, new org.netbeans.lib.awtextra.AbsoluteConstraints(810, 20, 260, 30));

        text_addfeestakenfees.setFont(new java.awt.Font("Segoe UI Light", 0, 25)); // NOI18N
        text_addfeestakenfees.setBorder(javax.swing.BorderFactory.createMatteBorder(0, 0, 1, 0, new java.awt.Color(0, 0, 0)));
        panel_addnewfees.add(text_addfeestakenfees, new org.netbeans.lib.awtextra.AbsoluteConstraints(740, 180, 330, 40));

        btn_addfeesloadrecord.setBackground(new java.awt.Color(0, 181, 204));
        btn_addfeesloadrecord.setFont(new java.awt.Font("Segoe UI Light", 0, 20)); // NOI18N
        btn_addfeesloadrecord.setText("Load Record");
        btn_addfeesloadrecord.setBorder(javax.swing.BorderFactory.createMatteBorder(1, 1, 1, 1, new java.awt.Color(0, 181, 204)));
        btn_addfeesloadrecord.setContentAreaFilled(false);
        btn_addfeesloadrecord.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_addfeesloadrecordActionPerformed(evt);
            }
        });
        panel_addnewfees.add(btn_addfeesloadrecord, new org.netbeans.lib.awtextra.AbsoluteConstraints(390, 130, 130, 40));

        btn_addadmissionclear2.setBackground(new java.awt.Color(0, 181, 204));
        btn_addadmissionclear2.setFont(new java.awt.Font("Segoe UI Light", 0, 20)); // NOI18N
        btn_addadmissionclear2.setText("Back");
        btn_addadmissionclear2.setBorder(javax.swing.BorderFactory.createMatteBorder(1, 1, 1, 1, new java.awt.Color(0, 181, 204)));
        btn_addadmissionclear2.setContentAreaFilled(false);
        btn_addadmissionclear2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_addadmissionclear2ActionPerformed(evt);
            }
        });
        panel_addnewfees.add(btn_addadmissionclear2, new org.netbeans.lib.awtextra.AbsoluteConstraints(730, 510, 120, 40));

        Label24.setFont(new java.awt.Font("Segoe UI Light", 0, 25)); // NOI18N
        Label24.setText("Mode of payment");
        panel_addnewfees.add(Label24, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 290, 190, 30));

        Label29.setFont(new java.awt.Font("Segoe UI Light", 0, 25)); // NOI18N
        Label29.setText("Amount Rs.");
        panel_addnewfees.add(Label29, new org.netbeans.lib.awtextra.AbsoluteConstraints(890, 90, 130, 30));

        text_addfeescoursename.setEditable(false);
        text_addfeescoursename.setFont(new java.awt.Font("Segoe UI Light", 0, 25)); // NOI18N
        text_addfeescoursename.setBorder(javax.swing.BorderFactory.createMatteBorder(0, 0, 1, 0, new java.awt.Color(0, 0, 0)));
        panel_addnewfees.add(text_addfeescoursename, new org.netbeans.lib.awtextra.AbsoluteConstraints(240, 240, 290, 40));

        Label30.setFont(new java.awt.Font("Segoe UI Light", 0, 25)); // NOI18N
        Label30.setText("Course Name");
        panel_addnewfees.add(Label30, new org.netbeans.lib.awtextra.AbsoluteConstraints(550, 140, 160, 30));

        Label31.setFont(new java.awt.Font("Segoe UI Light", 0, 25)); // NOI18N
        Label31.setText("Total In words");
        panel_addnewfees.add(Label31, new org.netbeans.lib.awtextra.AbsoluteConstraints(550, 290, 180, 30));

        text_addfeeswords.setFont(new java.awt.Font("Segoe UI Light", 0, 25)); // NOI18N
        text_addfeeswords.setBorder(javax.swing.BorderFactory.createMatteBorder(0, 0, 1, 0, new java.awt.Color(0, 0, 0)));
        panel_addnewfees.add(text_addfeeswords, new org.netbeans.lib.awtextra.AbsoluteConstraints(740, 280, 330, 40));

        text_addfeestotalfees.setEditable(false);
        text_addfeestotalfees.setFont(new java.awt.Font("Segoe UI Light", 0, 25)); // NOI18N
        text_addfeestotalfees.setBorder(javax.swing.BorderFactory.createMatteBorder(0, 0, 1, 0, new java.awt.Color(0, 0, 0)));
        text_addfeestotalfees.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusLost(java.awt.event.FocusEvent evt) {
                text_addfeestotalfeesFocusLost(evt);
            }
        });
        text_addfeestotalfees.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                text_addfeestotalfeesKeyReleased(evt);
            }
        });
        panel_addnewfees.add(text_addfeestotalfees, new org.netbeans.lib.awtextra.AbsoluteConstraints(740, 230, 330, 40));

        Label32.setFont(new java.awt.Font("Segoe UI Light", 0, 25)); // NOI18N
        Label32.setText("Total Fees");
        panel_addnewfees.add(Label32, new org.netbeans.lib.awtextra.AbsoluteConstraints(550, 240, 160, 30));

        btn_addadmissionclear3.setBackground(new java.awt.Color(0, 181, 204));
        btn_addadmissionclear3.setFont(new java.awt.Font("Segoe UI Light", 0, 20)); // NOI18N
        btn_addadmissionclear3.setText("Clear");
        btn_addadmissionclear3.setBorder(javax.swing.BorderFactory.createMatteBorder(1, 1, 1, 1, new java.awt.Color(0, 181, 204)));
        btn_addadmissionclear3.setContentAreaFilled(false);
        btn_addadmissionclear3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_addadmissionclear3ActionPerformed(evt);
            }
        });
        panel_addnewfees.add(btn_addadmissionclear3, new org.netbeans.lib.awtextra.AbsoluteConstraints(510, 510, 120, 40));

        text_manageaddress1.setColumns(20);
        text_manageaddress1.setFont(new java.awt.Font("Segoe UI Light", 0, 15)); // NOI18N
        text_manageaddress1.setRows(5);
        text_manageaddress1.setBorder(javax.swing.BorderFactory.createMatteBorder(0, 0, 1, 0, new java.awt.Color(0, 0, 0)));
        jScrollPane4.setViewportView(text_manageaddress1);

        panel_addnewfees.add(jScrollPane4, new org.netbeans.lib.awtextra.AbsoluteConstraints(740, 340, 330, 50));

        Label21.setFont(new java.awt.Font("Segoe UI Light", 0, 20)); // NOI18N
        Label21.setText("Remark");
        panel_addnewfees.add(Label21, new org.netbeans.lib.awtextra.AbsoluteConstraints(550, 340, 90, 30));

        text_receivedfrom.setFont(new java.awt.Font("Segoe UI Light", 0, 25)); // NOI18N
        text_receivedfrom.setBorder(javax.swing.BorderFactory.createMatteBorder(0, 0, 1, 0, new java.awt.Color(0, 0, 0)));
        panel_addnewfees.add(text_receivedfrom, new org.netbeans.lib.awtextra.AbsoluteConstraints(240, 340, 290, 40));

        label_paymentcompany.setFont(new java.awt.Font("Segoe UI Light", 0, 25)); // NOI18N
        label_paymentcompany.setText("Payment Company");
        panel_addnewfees.add(label_paymentcompany, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 340, 200, 30));

        text_mobileno.setFont(new java.awt.Font("Segoe UI Light", 0, 25)); // NOI18N
        text_mobileno.setBorder(javax.swing.BorderFactory.createMatteBorder(0, 0, 1, 0, new java.awt.Color(0, 0, 0)));
        panel_addnewfees.add(text_mobileno, new org.netbeans.lib.awtextra.AbsoluteConstraints(240, 390, 290, 40));

        label_chequeno.setFont(new java.awt.Font("Segoe UI Light", 0, 25)); // NOI18N
        label_chequeno.setText("Cheque no");
        panel_addnewfees.add(label_chequeno, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 400, 160, 30));

        label_receivedfrom.setFont(new java.awt.Font("Segoe UI Light", 0, 25)); // NOI18N
        label_receivedfrom.setText("Received from");
        panel_addnewfees.add(label_receivedfrom, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 340, 160, 30));

        combobox_modeofpayment1.setFont(new java.awt.Font("Segoe UI Light", 0, 15)); // NOI18N
        combobox_modeofpayment1.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "cash", "cheque", "online payment" }));
        combobox_modeofpayment1.setBorder(javax.swing.BorderFactory.createMatteBorder(0, 0, 1, 0, new java.awt.Color(0, 0, 0)));
        combobox_modeofpayment1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                combobox_modeofpayment1ActionPerformed(evt);
            }
        });
        panel_addnewfees.add(combobox_modeofpayment1, new org.netbeans.lib.awtextra.AbsoluteConstraints(240, 290, 290, 40));

        label_bankname.setFont(new java.awt.Font("Segoe UI Light", 0, 25)); // NOI18N
        label_bankname.setText("Bank name");
        panel_addnewfees.add(label_bankname, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 340, 160, 30));

        combobox_paymentname.setFont(new java.awt.Font("Segoe UI Light", 0, 15)); // NOI18N
        combobox_paymentname.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Paytm", "Google Pay", "PhonePe", "BHIM", "Paypal", "Amazon Pay" }));
        combobox_paymentname.setBorder(javax.swing.BorderFactory.createMatteBorder(0, 0, 1, 0, new java.awt.Color(0, 0, 0)));
        panel_addnewfees.add(combobox_paymentname, new org.netbeans.lib.awtextra.AbsoluteConstraints(240, 340, 290, 40));

        combobox_paymentbankname.setFont(new java.awt.Font("Segoe UI Light", 0, 15)); // NOI18N
        combobox_paymentbankname.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "STATE BANK OF INDIA", "PUNJAB NATIONAL BANK", "BANK OF INDIA", "IDBI BANK", "UNION BANK OF INDIA", "BANK OF BARODA", "INDIAN BANK", "CENTRAL BANK OF INDIA", "CANARA BANK" }));
        combobox_paymentbankname.setBorder(javax.swing.BorderFactory.createMatteBorder(0, 0, 1, 0, new java.awt.Color(0, 0, 0)));
        panel_addnewfees.add(combobox_paymentbankname, new org.netbeans.lib.awtextra.AbsoluteConstraints(240, 340, 290, 40));

        label_mobileno.setFont(new java.awt.Font("Segoe UI Light", 0, 25)); // NOI18N
        label_mobileno.setText("Mobile no");
        panel_addnewfees.add(label_mobileno, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 400, 160, 30));

        text_chequeno.setFont(new java.awt.Font("Segoe UI Light", 0, 25)); // NOI18N
        text_chequeno.setBorder(javax.swing.BorderFactory.createMatteBorder(0, 0, 1, 0, new java.awt.Color(0, 0, 0)));
        panel_addnewfees.add(text_chequeno, new org.netbeans.lib.awtextra.AbsoluteConstraints(240, 390, 290, 40));

        text_addfeescoursename1.setEditable(false);
        text_addfeescoursename1.setFont(new java.awt.Font("Segoe UI Light", 0, 25)); // NOI18N
        text_addfeescoursename1.setBorder(javax.swing.BorderFactory.createMatteBorder(0, 0, 1, 0, new java.awt.Color(0, 0, 0)));
        panel_addnewfees.add(text_addfeescoursename1, new org.netbeans.lib.awtextra.AbsoluteConstraints(740, 130, 330, 40));

        getContentPane().add(panel_addnewfees, new org.netbeans.lib.awtextra.AbsoluteConstraints(280, 40, 1090, 730));

        panel_coursemanage.setBackground(new java.awt.Color(255, 255, 255));
        panel_coursemanage.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        Label25.setFont(new java.awt.Font("Segoe UI Light", 0, 18)); // NOI18N
        Label25.setText("*click finish button to finish that course");
        panel_coursemanage.add(Label25, new org.netbeans.lib.awtextra.AbsoluteConstraints(150, 140, 300, -1));

        Label36.setFont(new java.awt.Font("Segoe UI Light", 0, 25)); // NOI18N
        Label36.setText("Select Course");
        panel_coursemanage.add(Label36, new org.netbeans.lib.awtextra.AbsoluteConstraints(150, 100, 150, 30));

        combobox_course1.setFont(new java.awt.Font("Segoe UI Light", 0, 15)); // NOI18N
        combobox_course1.setBorder(javax.swing.BorderFactory.createMatteBorder(0, 0, 1, 0, new java.awt.Color(0, 0, 0)));
        panel_coursemanage.add(combobox_course1, new org.netbeans.lib.awtextra.AbsoluteConstraints(350, 90, 300, 40));

        btn_addadmission2.setBackground(new java.awt.Color(0, 181, 204));
        btn_addadmission2.setFont(new java.awt.Font("Segoe UI Light", 0, 20)); // NOI18N
        btn_addadmission2.setText("Finish");
        btn_addadmission2.setBorder(javax.swing.BorderFactory.createMatteBorder(1, 1, 1, 1, new java.awt.Color(0, 181, 204)));
        btn_addadmission2.setContentAreaFilled(false);
        btn_addadmission2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_addadmission2ActionPerformed(evt);
            }
        });
        panel_coursemanage.add(btn_addadmission2, new org.netbeans.lib.awtextra.AbsoluteConstraints(680, 90, 210, 40));

        btn_addadmissionclear1.setBackground(new java.awt.Color(0, 181, 204));
        btn_addadmissionclear1.setFont(new java.awt.Font("Segoe UI Light", 0, 20)); // NOI18N
        btn_addadmissionclear1.setText("Back");
        btn_addadmissionclear1.setBorder(javax.swing.BorderFactory.createMatteBorder(1, 1, 1, 1, new java.awt.Color(0, 181, 204)));
        btn_addadmissionclear1.setContentAreaFilled(false);
        btn_addadmissionclear1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_addadmissionclear1ActionPerformed(evt);
            }
        });
        panel_coursemanage.add(btn_addadmissionclear1, new org.netbeans.lib.awtextra.AbsoluteConstraints(910, 90, 160, 40));

        Label33.setFont(new java.awt.Font("Segoe UI Light", 0, 30)); // NOI18N
        Label33.setText("All student Record");
        panel_coursemanage.add(Label33, new org.netbeans.lib.awtextra.AbsoluteConstraints(60, 180, 380, -1));

        jSeparator4.setForeground(new java.awt.Color(0, 181, 204));
        panel_coursemanage.add(jSeparator4, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 162, 1090, 10));

        table_all_student.setAutoCreateRowSorter(true);
        table_all_student.setBackground(new java.awt.Color(0, 181, 204));
        table_all_student.setBorder(new javax.swing.border.MatteBorder(null));
        table_all_student.setFont(new java.awt.Font("Segoe UI Light", 0, 20)); // NOI18N
        table_all_student.setForeground(new java.awt.Color(255, 255, 255));
        table_all_student.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "GR no", "Name", "Selected Course", "Address", "City", "Contect no", "Date of Birth", "Gender"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false, false, false, false, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        table_all_student.setIntercellSpacing(new java.awt.Dimension(0, 0));
        table_all_student.setRowHeight(20);
        table_all_student.setSelectionBackground(new java.awt.Color(0, 181, 255));
        table_all_student.setShowVerticalLines(true
        );
        table_all_student.getTableHeader().setReorderingAllowed(false);
        table_all_student.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                table_all_studentMouseClicked(evt);
            }
        });
        jScrollPane6.setViewportView(table_all_student);

        panel_coursemanage.add(jScrollPane6, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 310, 1010, 400));

        text_searchcashier.setFont(new java.awt.Font("Segoe UI Light", 0, 20)); // NOI18N
        text_searchcashier.setText("Search Student");
        text_searchcashier.setBorder(javax.swing.BorderFactory.createMatteBorder(0, 0, 1, 0, new java.awt.Color(0, 0, 0)));
        text_searchcashier.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                text_searchcashierMouseClicked(evt);
            }
        });
        text_searchcashier.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                text_searchcashierKeyReleased(evt);
            }
        });
        panel_coursemanage.add(text_searchcashier, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 250, 420, 50));

        Label34.setFont(new java.awt.Font("Segoe UI Light", 0, 24)); // NOI18N
        Label34.setText("Student status");
        panel_coursemanage.add(Label34, new org.netbeans.lib.awtextra.AbsoluteConstraints(600, 260, 270, 40));

        btn_refrashmanagecashier.setBackground(new java.awt.Color(0, 181, 204));
        btn_refrashmanagecashier.setFont(new java.awt.Font("Segoe UI Light", 0, 20)); // NOI18N
        btn_refrashmanagecashier.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/refresh.png"))); // NOI18N
        btn_refrashmanagecashier.setContentAreaFilled(false);
        btn_refrashmanagecashier.setFocusPainted(false);
        btn_refrashmanagecashier.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_refrashmanagecashierActionPerformed(evt);
            }
        });
        panel_coursemanage.add(btn_refrashmanagecashier, new org.netbeans.lib.awtextra.AbsoluteConstraints(480, 270, 40, 30));

        conbo_all_student.setFont(new java.awt.Font("Segoe UI Light", 0, 15)); // NOI18N
        conbo_all_student.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Active", "Cancel", "Finish" }));
        conbo_all_student.setBorder(javax.swing.BorderFactory.createMatteBorder(0, 0, 1, 0, new java.awt.Color(0, 0, 0)));
        conbo_all_student.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                conbo_all_studentActionPerformed(evt);
            }
        });
        panel_coursemanage.add(conbo_all_student, new org.netbeans.lib.awtextra.AbsoluteConstraints(790, 260, 270, 40));

        Label39.setFont(new java.awt.Font("Segoe UI Light", 0, 30)); // NOI18N
        Label39.setText("Manage Course");
        panel_coursemanage.add(Label39, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 30, 380, -1));

        getContentPane().add(panel_coursemanage, new org.netbeans.lib.awtextra.AbsoluteConstraints(280, 40, 1090, 730));

        panel_info.setBackground(new java.awt.Color(255, 255, 255));
        panel_info.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        btn_addadmissionclear4.setBackground(new java.awt.Color(0, 181, 204));
        btn_addadmissionclear4.setFont(new java.awt.Font("Segoe UI Light", 0, 20)); // NOI18N
        btn_addadmissionclear4.setText("Back");
        btn_addadmissionclear4.setBorder(javax.swing.BorderFactory.createMatteBorder(1, 1, 1, 1, new java.awt.Color(0, 181, 204)));
        btn_addadmissionclear4.setContentAreaFilled(false);
        btn_addadmissionclear4.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_addadmissionclear4ActionPerformed(evt);
            }
        });
        panel_info.add(btn_addadmissionclear4, new org.netbeans.lib.awtextra.AbsoluteConstraints(380, 570, 260, 60));

        Label37.setFont(new java.awt.Font("Segoe UI Light", 0, 48)); // NOI18N
        Label37.setText("INSTITUTE MANAGEMENT SYSTEM ");
        panel_info.add(Label37, new org.netbeans.lib.awtextra.AbsoluteConstraints(140, 70, 820, -1));

        Label38.setFont(new java.awt.Font("Segoe UI Light", 0, 24)); // NOI18N
        Label38.setText("BY");
        panel_info.add(Label38, new org.netbeans.lib.awtextra.AbsoluteConstraints(490, 210, 30, -1));

        jLabel_inven.setFont(new java.awt.Font("Segoe UI Light", 0, 16)); // NOI18N
        jLabel_inven.setForeground(new java.awt.Color(255, 255, 255));
        jLabel_inven.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icons/arenalogo.png"))); // NOI18N
        panel_info.add(jLabel_inven, new org.netbeans.lib.awtextra.AbsoluteConstraints(340, 250, 320, -1));

        jLabel_SoftZyd.setBackground(new java.awt.Color(0, 0, 0));
        jLabel_SoftZyd.setFont(new java.awt.Font("Trebuchet MS", 1, 36)); // NOI18N
        jLabel_SoftZyd.setText("Arena Institute Of Computer Consultancy");
        jLabel_SoftZyd.setToolTipText("");
        panel_info.add(jLabel_SoftZyd, new org.netbeans.lib.awtextra.AbsoluteConstraints(150, 500, 690, -1));

        Label41.setFont(new java.awt.Font("Segoe UI Light", 0, 24)); // NOI18N
        Label41.setText("DEVELOPED BY :- MAHIDA ADNAN ");
        panel_info.add(Label41, new org.netbeans.lib.awtextra.AbsoluteConstraints(340, 150, 380, -1));

        getContentPane().add(panel_info, new org.netbeans.lib.awtextra.AbsoluteConstraints(280, 40, 1090, 730));

        panel_duefees.setBackground(new java.awt.Color(255, 255, 255));
        panel_duefees.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        btn_addadmissionclear5.setBackground(new java.awt.Color(0, 181, 204));
        btn_addadmissionclear5.setFont(new java.awt.Font("Segoe UI Light", 0, 20)); // NOI18N
        btn_addadmissionclear5.setText("Back");
        btn_addadmissionclear5.setBorder(javax.swing.BorderFactory.createMatteBorder(1, 1, 1, 1, new java.awt.Color(0, 181, 204)));
        btn_addadmissionclear5.setContentAreaFilled(false);
        btn_addadmissionclear5.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_addadmissionclear5ActionPerformed(evt);
            }
        });
        panel_duefees.add(btn_addadmissionclear5, new org.netbeans.lib.awtextra.AbsoluteConstraints(460, 660, 210, 50));

        Label40.setFont(new java.awt.Font("Segoe UI Light", 0, 48)); // NOI18N
        Label40.setText("Due Fees");
        panel_duefees.add(Label40, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 20, 820, -1));

        table_duefees.setAutoCreateRowSorter(true);
        table_duefees.setBackground(java.awt.SystemColor.control);
        table_duefees.setBorder(new javax.swing.border.MatteBorder(null));
        table_duefees.setFont(new java.awt.Font("Segoe UI Light", 0, 20)); // NOI18N
        table_duefees.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "GR no", "Name", "Selected Course", "Paid fees", "Last paid date", "Due fees", "Total fees"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false, false, true, true, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        table_duefees.setIntercellSpacing(new java.awt.Dimension(0, 0));
        table_duefees.setRowHeight(20);
        table_duefees.setSelectionBackground(new java.awt.Color(0, 181, 255));
        table_duefees.setShowVerticalLines(true
        );
        table_duefees.getTableHeader().setReorderingAllowed(false);
        table_duefees.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                table_duefeesMouseClicked(evt);
            }
        });
        jScrollPane5.setViewportView(table_duefees);

        panel_duefees.add(jScrollPane5, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 170, 1010, 470));

        text_searchduefees.setFont(new java.awt.Font("Segoe UI Light", 0, 20)); // NOI18N
        text_searchduefees.setText("Search Student");
        text_searchduefees.setBorder(javax.swing.BorderFactory.createMatteBorder(0, 0, 1, 0, new java.awt.Color(0, 0, 0)));
        text_searchduefees.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                text_searchduefeesMouseClicked(evt);
            }
        });
        text_searchduefees.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                text_searchduefeesKeyReleased(evt);
            }
        });
        panel_duefees.add(text_searchduefees, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 120, 940, 40));

        btn_refrashmanagecashier1.setBackground(new java.awt.Color(0, 181, 204));
        btn_refrashmanagecashier1.setFont(new java.awt.Font("Segoe UI Light", 0, 20)); // NOI18N
        btn_refrashmanagecashier1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/refresh.png"))); // NOI18N
        btn_refrashmanagecashier1.setContentAreaFilled(false);
        btn_refrashmanagecashier1.setFocusPainted(false);
        btn_refrashmanagecashier1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_refrashmanagecashier1ActionPerformed(evt);
            }
        });
        panel_duefees.add(btn_refrashmanagecashier1, new org.netbeans.lib.awtextra.AbsoluteConstraints(1000, 130, 40, 30));

        getContentPane().add(panel_duefees, new org.netbeans.lib.awtextra.AbsoluteConstraints(280, 40, 1090, 730));

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btn_minimizeActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_minimizeActionPerformed
        this.setState(this.ICONIFIED);
        // TODO add your handling code here:
    }//GEN-LAST:event_btn_minimizeActionPerformed

    private void btn_closeActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_closeActionPerformed
        System.exit(0);
        // TODO add your handling code here:
    }//GEN-LAST:event_btn_closeActionPerformed

    private void jLabel2MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel2MouseClicked
        LoginForm lf = new LoginForm();
        lf.setVisible(true);
        this.setVisible(false);
        // TODO add your handling code here:
    }//GEN-LAST:event_jLabel2MouseClicked

    private void label_newadmission1MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_label_newadmission1MouseClicked
        panel_newadmission.setVisible(true);
        panel_home.setVisible(false);
    }//GEN-LAST:event_label_newadmission1MouseClicked

    private void jLabel1MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel1MouseClicked
        panel_home.setVisible(true);
        panel_newadmission.setVisible(false);
        panel_managestudent.setVisible(false);
        panel_addnewfees.setVisible(false);
        panel_coursemanage.setVisible(false);
        panel_info.setVisible(false);
        panel_duefees.setVisible(false);
        //  panel_home.setVisible(false);
        clear_addadmission();
    }//GEN-LAST:event_jLabel1MouseClicked

    private void btn_admissionuploadimageActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_admissionuploadimageActionPerformed
        JFileChooser chooser = new JFileChooser();
        chooser.showOpenDialog(null);
        File f = chooser.getSelectedFile();
        label_image.setIcon(new ImageIcon(f.toString()));
        filename = f.getAbsolutePath();
        text_admissionimage.setText(filename);
        try {
            File image = new File(filename);
            FileInputStream fis = new FileInputStream(image);
            ByteArrayOutputStream bos = new ByteArrayOutputStream();
            byte[] buf = new byte[1024];
            for (int i; (i = fis.read(buf)) != -1;) {
                bos.write(buf, 0, i);
            }
            photo = bos.toByteArray();
        } catch (Exception e) {
        }
    }//GEN-LAST:event_btn_admissionuploadimageActionPerformed

    private void btn_addadmissionActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_addadmissionActionPerformed

        //DateFormat df=new SimpleDateFormat("yyyy-MM-dd");
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
        String birthdate = sdf.format(birth_date.getDate());
        String admissiondate = sdf.format(admission_date.getDate());
        String gender;
        if (radiobutton_male.isSelected()) {
            gender = "Male";
        } else {
            gender = "Female";
        }
        try {
            String fees = "INSERT INTO `student_fees`(`receipt_no`, `gr_no`, `name`, `selected_course`) VALUES (null,'" + text_admissiongr.getText() + "','" + text_admissionname.getText() + "','" + combobox_course.getSelectedItem() + "')";
            String q1 = "INSERT INTO `student_details` VALUES ('" + text_admissiongr.getText() + "','" + text_admissionname.getText() + "','" + photo + "','" + gender + "','" + birthdate + "','" + text_admissionaddress.getText() + "','" + text_admissioncity.getText() + "','" + text_admissioncontact.getText() + "','" + combobox_course.getSelectedItem().toString() + "','" + courseid + "','" + admissiondate + "','active')";
            // String q="INSERT INTO `student_details` VALUES ('"+text_admissiongr.getText()+"','"+text_admissionname.getText()+"','"+photo+"','"+gender+"','"+birthdate+"','"+text_admissionaddress.getText()+"','"+text_admissioncity.getText()+"','"+text_admissioncontact.getText()+"','"+combobox_course.getSelectedItem().toString()+"','"+admissiondate+"','active')";

            int i = c.st.executeUpdate(q1);

            if (i > 0) {
                JOptionPane.showMessageDialog(this, "Admission Successfull !");
                i = c.st.executeUpdate(fees);
                if (i > 0) {
                    JOptionPane.showMessageDialog(this, "Add fees !");
                }
                DefaultTableModel model = (DefaultTableModel) table_student.getModel();
                while (model.getRowCount() > 0) {
                    model.setRowCount(0);

                }
                table_student();
                panel_managestudent.setVisible(true);
                panel_newadmission.setVisible(false);
            } else {
                JOptionPane.showMessageDialog(this, "Some thing is Problem !");
            }
        } catch (Exception e) {
            JOptionPane.showMessageDialog(this, "exeption" + e.getMessage());
        }
    }//GEN-LAST:event_btn_addadmissionActionPerformed
    private void clear_addadmission() {
        text_admissionname.setText("");
        text_admissionaddress.setText("");
        text_admissioncity.setText("");
        text_admissioncontact.setText("");
        birth_date.setCalendar(null);
        text_admissionimage.setText("");
    }

    private void btn_addadmissionclearActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_addadmissionclearActionPerformed
        clear_addadmission();

    }//GEN-LAST:event_btn_addadmissionclearActionPerformed

    private void btn_updatestudentActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_updatestudentActionPerformed
        try {
            //`grno`='" + text_managegr.getText() + "',
            String q = "UPDATE `student_details` SET `name`='" + text_managename.getText() + "',`address`='" + text_manageaddress.getText() + "',`city`='" + text_managecity.getText() + "',`contact`='" + text_managecontact.getText() + "',`coursename`='" + combobox_managecourse.getSelectedItem().toString() + "'  WHERE `grno`='" + text_managegr.getText() + "' ";
            int i = c.st.executeUpdate(q);
            if (i > 0) {
                JOptionPane.showMessageDialog(this, " Successfull Added !");
                DefaultTableModel model = (DefaultTableModel) table_student.getModel();
                while (model.getRowCount() > 0) {
                    model.setRowCount(0);
                }
                table_student();
            } else {
                JOptionPane.showMessageDialog(this, "Some thing is Problem !");
            }
        } catch (Exception e) {
            JOptionPane.showMessageDialog(this, e.getMessage());
        }
    }//GEN-LAST:event_btn_updatestudentActionPerformed

    private void btn_cancelstudentActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_cancelstudentActionPerformed
        try {
            String q = "UPDATE `student_details` SET status='cancel' where grno='" + text_managegr.getText() + "' ";
            int i = c.st.executeUpdate(q);
            if (i > 0) {
                JOptionPane.showMessageDialog(this, " Admission Canceled !");
                DefaultTableModel model = (DefaultTableModel) table_student.getModel();
                while (model.getRowCount() > 0) {
                    model.setRowCount(0);
                }
                table_student();
            } else {
                JOptionPane.showMessageDialog(this, "Some thing is Problem !");
            }
        } catch (Exception e) {
            JOptionPane.showMessageDialog(this, e.getMessage());
        }
    }//GEN-LAST:event_btn_cancelstudentActionPerformed
    void table_student() {
        String tot_fees;
        try {

            String q = "SELECT * FROM `student_details` where status='active' ";
            // String q1="SELECT * FROM `student_fees`";

            /* c.rs = c.st.executeQuery(q);
            while (c.rs.next()) {
                String gr = c.rs.getString(2);
                String name = c.rs.getString(3);
                String selectedcourse = c.rs.getString(4);
                String paid = c.rs.getString(12);

                // String tot=c.rs.getString(5);
                // String selectedscourse=c.rs.getString(4);
                Object[] content = {gr, name, selectedcourse, paid, ffees};
                DefaultTableModel m1 = (DefaultTableModel) table_student.getModel();
                m1.addRow(content);

            }/**/
            c.rs = c.st.executeQuery(q);
            while (c.rs.next()) {
                String gr = c.rs.getString(1);
                String name = c.rs.getString(2);
                String gender = c.rs.getString(4);
                String dob = c.rs.getString(5);
                String address = c.rs.getString(6);
                String city = c.rs.getString(7);
                String contect = c.rs.getString(8);
                String selectedcourse = c.rs.getString(9);

                Object[] content = {gr, name, selectedcourse, address, city, contect, dob, gender};
                DefaultTableModel m1 = (DefaultTableModel) table_student.getModel();
                m1.addRow(content);

            }

        } catch (Exception a) {
            JOptionPane.showMessageDialog(this, "Exception Is" + a.getMessage());
        }
    }

    private void label_newadmission2MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_label_newadmission2MouseClicked
        panel_managestudent.setVisible(true);
        panel_home.setVisible(false);
    }//GEN-LAST:event_label_newadmission2MouseClicked

    private void text_admissiongrActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_text_admissiongrActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_text_admissiongrActionPerformed

    private void table_studentMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_table_studentMouseClicked
        int i = table_student.getSelectedRow();
        //TableModel model =table_course.getModel();
        DefaultTableModel model = (DefaultTableModel) table_student.getModel();
        text_managegr.setText(model.getValueAt(i, 0).toString());
        text_managename.setText(model.getValueAt(i, 1).toString());
        // combobox_managecourse.setSelectedItem(model.getValueAt(i,8).toString());
        text_manageaddress.setText(model.getValueAt(i, 3).toString());
        text_managecity.setText(model.getValueAt(i, 4).toString());
        text_managecontact.setText(model.getValueAt(i, 5).toString());
        // birth_managedate.

    }//GEN-LAST:event_table_studentMouseClicked

    private void btn_refrashstudentActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_refrashstudentActionPerformed
        DefaultTableModel model = (DefaultTableModel) table_student.getModel();
        while (model.getRowCount() > 0) {
            model.setRowCount(0);
        }
        table_student();
    }//GEN-LAST:event_btn_refrashstudentActionPerformed

    private void text_searchstudentMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_text_searchstudentMouseClicked
        text_searchstudent.setText("");
    }//GEN-LAST:event_text_searchstudentMouseClicked

    private void text_searchstudentKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_text_searchstudentKeyReleased
        DefaultTableModel model = (DefaultTableModel) table_student.getModel();
        String search = text_searchstudent.getText().toLowerCase();
        TableRowSorter<DefaultTableModel> tr = new TableRowSorter<DefaultTableModel>(model);
        table_student.setRowSorter(tr);
        tr.setRowFilter(RowFilter.regexFilter(search)); // TODO add your handling code here:
    }//GEN-LAST:event_text_searchstudentKeyReleased

    private void text_admissiongr1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_text_admissiongr1ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_text_admissiongr1ActionPerformed

    private void btn_addadmission1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_addadmission1ActionPerformed

        //baki 6e
        // String lfees=
        //double lfees = Double.parseDouble(text_addfeestakenfees.getText());
//        double tot = ffees + lfees;
        try {
            double now = Double.valueOf(text_addfeestakenfees.getText());
            double tot_fees = paid + now;
            String q = "UPDATE `student_fees` SET `receipt_no`='" + text_admissiongr1.getText() + "',`gr_no`='" + text_addfeesgrno.getText() + "',`name`='" + text_addfeename.getText() + "',`selected_course`='" + text_addfeescoursename.getText() + "',`modeofpayment`='" + combobox_modeofpayment1.getSelectedItem() + "',`received_from`='" + text_receivedfrom.getText() + "',`mobileno`='" + text_mobileno.getText() + "',`bankname`='" + combobox_paymentbankname.getSelectedItem() + "',`chequeno`='" + text_chequeno.getText() + "',`payment_company`='" + combobox_paymentname.getSelectedItem() + "',`date`='" + addfees_date.getDate() + "',`takenfees`='" + tot_fees + "',`remark`='" + text_manageaddress1.getText() + "' WHERE gr_no='" + text_addfeesgrno.getText() + "'  ";
            i = c.st.executeUpdate(q);
            if (i > 0) {
                JOptionPane.showMessageDialog(this, "Fess Added Successfull !");
                panel_duefees.setVisible(true);
                panel_addnewfees.setVisible(false);

            } else {
                JOptionPane.showMessageDialog(this, "Can't added !");

            }
        } catch (Exception e) {
            JOptionPane.showMessageDialog(this, "exeption" + e.getMessage());
        }
    }//GEN-LAST:event_btn_addadmission1ActionPerformed
    private void filladdfeesdata(String i) {
        try {
            String q = "SELECT * FROM `student_details` WHERE grno= '" + i + "' ";
            //fees;

//            int i= c.st.executeUpdate(q);
            c.rs = c.st.executeQuery(q);
            while (c.rs.next()) {
                text_addfeename.setText(c.rs.getString("name"));
                String c_name = c.rs.getString("coursename");
                //  fees=c.rs.getString("");
//          combobox_course1.setSelectedItem(c_name);
                text_addfeescoursename.setText(c_name);
                text_addfeescoursename1.setText(c_name);
                text_addfeesgrno.setText(i);
                String q2 = "SELECT * FROM `course_details` WHERE `course_name`='" + c_name + "'";
                String t_fees;

                c.rs = c.st.executeQuery(q2);
                while (c.rs.next()) {
                    t_fees = c.rs.getString("course_fees");
                    text_addfeestotalfees.setText(t_fees.toString());
                    ffees = c.rs.getDouble("course_fees");
                }

                //
                // if (i > 0) {
            }

            // }    
        } catch (Exception e) {
            JOptionPane.showMessageDialog(this, "exeption" + e.getMessage());
        }
    }
    private void btn_addfeesloadrecordActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_addfeesloadrecordActionPerformed
        String i = text_addfeesgrno.getText();
        filladdfeesdata(i);
        //filladdfeesdata(i);
    }//GEN-LAST:event_btn_addfeesloadrecordActionPerformed

    private void label_newadmission3MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_label_newadmission3MouseClicked
        panel_addnewfees.setVisible(true);
        panel_home.setVisible(false);
    }//GEN-LAST:event_label_newadmission3MouseClicked

    private void btn_addadmissionclear2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_addadmissionclear2ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_btn_addadmissionclear2ActionPerformed

    private void btn_addadmissionclear3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_addadmissionclear3ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_btn_addadmissionclear3ActionPerformed

    private void combobox_modeofpayment1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_combobox_modeofpayment1ActionPerformed
        String mode = combobox_modeofpayment1.getSelectedItem().toString();
        switch (mode) {
            case "cash":
                text_receivedfrom.setVisible(true);
                label_receivedfrom.setVisible(true);
                label_bankname.setVisible(false);
                label_paymentcompany.setVisible(false);
                combobox_paymentname.setVisible(false);
                combobox_paymentbankname.setVisible(false);
                label_chequeno.setVisible(false);
                text_chequeno.setVisible(false);
                label_mobileno.setVisible(true);
                break;
            case "cheque":
                text_receivedfrom.setVisible(false);
                label_receivedfrom.setVisible(false);
                label_bankname.setVisible(true);
                label_paymentcompany.setVisible(false);
                combobox_paymentname.setVisible(false);
                combobox_paymentbankname.setVisible(true);
                label_chequeno.setVisible(true);
                text_chequeno.setVisible(true);
                label_mobileno.setVisible(false);
                break;

            case "online payment":
                text_receivedfrom.setVisible(false);
                label_receivedfrom.setVisible(false);
                label_bankname.setVisible(false);
                label_paymentcompany.setVisible(true);
                combobox_paymentname.setVisible(true);
                combobox_paymentbankname.setVisible(false);
                label_chequeno.setVisible(false);
                text_chequeno.setVisible(false);
                label_mobileno.setVisible(true);
                break;

            default:
                text_receivedfrom.setVisible(true);
                label_receivedfrom.setVisible(true);
                label_bankname.setVisible(false);
                label_paymentcompany.setVisible(false);
                combobox_paymentname.setVisible(false);
                combobox_paymentbankname.setVisible(false);
                label_chequeno.setVisible(false);
                text_chequeno.setVisible(false);
                break;
        }
    }//GEN-LAST:event_combobox_modeofpayment1ActionPerformed

    private void text_addfeestotalfeesKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_text_addfeestotalfeesKeyReleased

    }//GEN-LAST:event_text_addfeestotalfeesKeyReleased

    private void text_addfeestotalfeesFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_text_addfeestotalfeesFocusLost
        String n = text_addfeestotalfees.getText();
        convert(n.toCharArray());

    }//GEN-LAST:event_text_addfeestotalfeesFocusLost

    private void label_course_manageMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_label_course_manageMouseClicked
//       panel_addnewfees.setVisible(true);
        panel_coursemanage.setVisible(true);
        panel_home.setVisible(false);

    }//GEN-LAST:event_label_course_manageMouseClicked

    private void btn_addadmission2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_addadmission2ActionPerformed
        try {
            String q = "UPDATE `student_details` SET `status`='notactive' WHERE `coursename`='" + combobox_course1.getSelectedItem() + "' ";
            int i = c.st.executeUpdate(q);
            if (i > 0) {
                JOptionPane.showMessageDialog(this, " Update Succesful !");

            } else {
                JOptionPane.showMessageDialog(this, "Some thing is Problem !");
            }
        } catch (Exception e) {
            JOptionPane.showMessageDialog(this, e.getMessage());
        }

    }//GEN-LAST:event_btn_addadmission2ActionPerformed

    private void btn_addadmissionclear1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_addadmissionclear1ActionPerformed
        panel_home.setVisible(true);
        panel_coursemanage.setVisible(false);


    }//GEN-LAST:event_btn_addadmissionclear1ActionPerformed

    private void btn_addadmissionclear4ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_addadmissionclear4ActionPerformed
        panel_home.setVisible(true);
        panel_info.setVisible(false);

        // TODO add your handling code here:
    }//GEN-LAST:event_btn_addadmissionclear4ActionPerformed

    private void label_newadmissionMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_label_newadmissionMouseClicked
        panel_info.setVisible(true);
        panel_home.setVisible(false);

    }//GEN-LAST:event_label_newadmissionMouseClicked

    private void btn_addadmissionclear5ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_addadmissionclear5ActionPerformed
        panel_home.setVisible(true);
        panel_duefees.setVisible(false);
        // TODO add your handling code here:
    }//GEN-LAST:event_btn_addadmissionclear5ActionPerformed

    private void label_newadmission5MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_label_newadmission5MouseClicked
        panel_duefees.setVisible(true);
        panel_home.setVisible(false);

    }//GEN-LAST:event_label_newadmission5MouseClicked

    private void table_duefeesMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_table_duefeesMouseClicked

    }//GEN-LAST:event_table_duefeesMouseClicked

    private void btn_updatestudent1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_updatestudent1ActionPerformed
        if (text_managegr.getText().equals("")) {
            JOptionPane.showMessageDialog(this, "Please Select Student !");
        } else {

            panel_addnewfees.setVisible(true);
            String i = text_managegr.getText();
            filladdfeesdata(i);
            panel_managestudent.setVisible(false);
        }
    }//GEN-LAST:event_btn_updatestudent1ActionPerformed

    private void text_admissioncontactActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_text_admissioncontactActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_text_admissioncontactActionPerformed

    private void table_all_studentMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_table_all_studentMouseClicked
        // TODO add your handling code here:
    }//GEN-LAST:event_table_all_studentMouseClicked

    private void text_searchcashierMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_text_searchcashierMouseClicked
        text_searchcashier.setText("");
    }//GEN-LAST:event_text_searchcashierMouseClicked

    private void text_searchcashierKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_text_searchcashierKeyReleased
        DefaultTableModel model = (DefaultTableModel) table_all_student.getModel();
        String search = text_searchcashier.getText().toLowerCase();
        TableRowSorter<DefaultTableModel> tr = new TableRowSorter<DefaultTableModel>(model);
        table_all_student.setRowSorter(tr);
        tr.setRowFilter(RowFilter.regexFilter(search)); // TODO add your handling code here:
    }//GEN-LAST:event_text_searchcashierKeyReleased

    private void btn_refrashmanagecashierActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_refrashmanagecashierActionPerformed
           DefaultTableModel model = (DefaultTableModel) table_all_student.getModel();
           while (model.getRowCount() > 0) {
              model.setRowCount(0);
          }
           String a=conbo_all_student.getSelectedItem().toString();
         table_all_student(a);
    }//GEN-LAST:event_btn_refrashmanagecashierActionPerformed

    void table_all_student(String status) {
        
        String q="";
        if(status.equals("active")){
           q="";
            q=" SELECT * FROM `student_details` WHERE `status`='active' ";
            clr();
        }else if(status.equals("notactive")){
            q="";
            q=" SELECT * FROM `student_details` WHERE `status`='notactive' ";
           clr();
        }else if(status.equals("cancel")){
            q="";
            q=" SELECT * FROM `student_details` WHERE `status`='cancel' ";
           clr();
        }  try {
      
                    c.rs = c.st.executeQuery(q);
                    while (c.rs.next()) {
                        String gr = c.rs.getString(1);
                        String name = c.rs.getString(2);
                        String gender = c.rs.getString(4);
                        String dob = c.rs.getString(5);
                        String address = c.rs.getString(6);
                        String city = c.rs.getString(7);
                        String contect = c.rs.getString(8);
                        String selectedcourse = c.rs.getString(9);
                      
                        Object[] content = {gr, name, selectedcourse, address, city, contect, dob, gender};
                        DefaultTableModel m1 = (DefaultTableModel) table_all_student.getModel();
                        m1.addRow(content);

                    }

                } catch (Exception e) {
                    JOptionPane.showMessageDialog(this, "Errors");
                }
        }
void clr(){
   DefaultTableModel model = (DefaultTableModel) table_all_student.getModel();
while(model.getRowCount() > 0)
{
    model.removeRow(0);
}
}
    private void conbo_all_studentActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_conbo_all_studentActionPerformed
        String s = conbo_all_student.getSelectedItem().toString();
        if (s == "Active") {
            
            table_all_student("active");
            
        } else if (s == "Cancel") {
         
            table_all_student("cancel");
        } else if (s == "Finish") {
          
            table_all_student("notactive");
        }
    }//GEN-LAST:event_conbo_all_studentActionPerformed

    private void text_searchduefeesMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_text_searchduefeesMouseClicked
        text_searchduefees.setText("");
    }//GEN-LAST:event_text_searchduefeesMouseClicked

    private void text_searchduefeesKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_text_searchduefeesKeyReleased
        DefaultTableModel model = (DefaultTableModel) table_duefees.getModel();
        String search = text_searchduefees.getText().toLowerCase();
        TableRowSorter<DefaultTableModel> tr = new TableRowSorter<DefaultTableModel>(model);
        table_duefees.setRowSorter(tr);
        tr.setRowFilter(RowFilter.regexFilter(search));
    }//GEN-LAST:event_text_searchduefeesKeyReleased

    private void btn_refrashmanagecashier1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_refrashmanagecashier1ActionPerformed
        DefaultTableModel model = (DefaultTableModel) table_duefees.getModel();
        while (model.getRowCount() > 0) {
            model.setRowCount(0);
        }
        table_duefees();
    }//GEN-LAST:event_btn_refrashmanagecashier1ActionPerformed
    void convert(char[] num) {
        // Get number of digits 
        // in given number 
        int len = num.length;

        // Base cases 
        if (len == 0) {
            text_addfeeswords.setText("");
            return;
        }
        if (len > 4) {
            text_addfeeswords.setText(" ");
            return;
        }

        /* The first string is not used, it is to make 
		array indexing simple */
        String[] single_digits = new String[]{"zero", "one",
            "two", "three", "four",
            "five", "six", "seven",
            "eight", "nine"};

        /* The first string is not used, it is to make 
		array indexing simple */
        String[] two_digits = new String[]{"", "ten", "eleven", "twelve",
            "thirteen", "fourteen",
            "fifteen", "sixteen", "seventeen",
            "eighteen", "nineteen"};

        /* The first two string are not used, they are to make array indexing simple*/
        String[] tens_multiple = new String[]{"", "", "twenty", "thirty", "forty",
            "fifty", "sixty", "seventy",
            "eighty", "ninety"};

        String[] tens_power = new String[]{"hundred", "thousand"};

        /* Used for debugging purpose only */
        //  System.out.print(String.valueOf(num) + ": ");

        /* For single digit number */
        if (len == 1) {
            text_addfeeswords.setText(single_digits[num[0] - '0']);
            return;
        }

        /* Iterate while num 
		is not '\0' */
        int x = 0;
        while (x < num.length) {

            /* Code path for first 2 digits */
            if (len >= 3) {
                if (num[x] - '0' != 0) {
                    text_addfeeswords.setText(single_digits[num[x] - '0'] + " ");
                    text_addfeeswords.setText(tens_power[len - 3] + " ");
                    // here len can be 3 or 4 
                }
                --len;
            } /* Code path for last 2 digits */ else {
                /* Need to explicitly handle 
			10-19. Sum of the two digits 
			is used as index of "two_digits" 
			array of strings */
                if (num[x] - '0' == 1) {
                    int sum = num[x] - '0'
                            + num[x] - '0';
                    text_addfeeswords.setText(two_digits[sum]);
                    return;
                } /* Need to explicitely handle 20 */ else if (num[x] - '0' == 2
                        && num[x + 1] - '0' == 0) {
                    text_addfeeswords.setText("twenty");
                    return;
                } /* Rest of the two digit 
			numbers i.e., 21 to 99 */ else {
                    int i = (num[x] - '0');
                    if (i > 0) {
                        text_addfeeswords.setText(tens_multiple[i] + " ");
                    } else {
                        text_addfeeswords.setText(" ");
                    }
                    ++x;
                    if (num[x] - '0' != 0) {
                        text_addfeeswords.setText(single_digits[num[x] - '0']);
                    }
                }
            }
            ++x;
        }
    }

    public void table_duefees() {
        try {
            double totfees = 0;
            String q = "SELECT  student_fees.gr_no,student_fees.name,student_fees.selected_course,student_fees.takenfees,student_fees.date,course_details.course_fees FROM student_fees,course_details WHERE  student_fees.selected_course=course_details.course_name";
            c.rs = c.st.executeQuery(q);
            while (c.rs.next()) {
                String gr = c.rs.getString("gr_no");
                String name = c.rs.getString("name");
                String selectedcourse = c.rs.getString("selected_course");
                paid = c.rs.getDouble("takenfees");
                String lastdate = c.rs.getString("date");
                double tot = c.rs.getDouble("course_fees");
                double due = tot - paid;
                Object[] content = {gr, name, selectedcourse, paid, lastdate, due, tot};
                DefaultTableModel m1 = (DefaultTableModel) table_duefees.getModel();
                m1.addRow(content);
            }

        } catch (Exception a) {
            JOptionPane.showMessageDialog(this, "Exception Is" + a.getMessage());
        }
    }

    public void tickTock() {
        //  label_date_time.setText(DateFormat.getDateTimeInstance().format(new Date()));
    }

    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(Cashier_home.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Cashier_home.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Cashier_home.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Cashier_home.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Cashier_home().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel Label;
    private javax.swing.JLabel Label1;
    private javax.swing.JLabel Label10;
    private javax.swing.JLabel Label11;
    private javax.swing.JLabel Label12;
    private javax.swing.JLabel Label13;
    private javax.swing.JLabel Label14;
    private javax.swing.JLabel Label15;
    private javax.swing.JLabel Label16;
    private javax.swing.JLabel Label17;
    private javax.swing.JLabel Label18;
    private javax.swing.JLabel Label19;
    private javax.swing.JLabel Label2;
    private javax.swing.JLabel Label20;
    private javax.swing.JLabel Label21;
    private javax.swing.JLabel Label22;
    private javax.swing.JLabel Label23;
    private javax.swing.JLabel Label24;
    private javax.swing.JLabel Label25;
    private javax.swing.JLabel Label26;
    private javax.swing.JLabel Label27;
    private javax.swing.JLabel Label28;
    private javax.swing.JLabel Label29;
    private javax.swing.JLabel Label3;
    private javax.swing.JLabel Label30;
    private javax.swing.JLabel Label31;
    private javax.swing.JLabel Label32;
    private javax.swing.JLabel Label33;
    private javax.swing.JLabel Label34;
    private javax.swing.JLabel Label36;
    private javax.swing.JLabel Label37;
    private javax.swing.JLabel Label38;
    private javax.swing.JLabel Label39;
    private javax.swing.JLabel Label4;
    private javax.swing.JLabel Label40;
    private javax.swing.JLabel Label41;
    private javax.swing.JLabel Label5;
    private javax.swing.JLabel Label6;
    private javax.swing.JLabel Label7;
    private javax.swing.JLabel Label8;
    private javax.swing.JLabel Label9;
    private com.toedter.calendar.JDateChooser addfees_date;
    private javax.swing.JPanel admin_slidepanel;
    private com.toedter.calendar.JDateChooser admission_date;
    private com.toedter.calendar.JDateChooser birth_date;
    private com.toedter.calendar.JDateChooser birth_managedate;
    private javax.swing.JButton btn_addadmission;
    private javax.swing.JButton btn_addadmission1;
    private javax.swing.JButton btn_addadmission2;
    private javax.swing.JButton btn_addadmissionclear;
    private javax.swing.JButton btn_addadmissionclear1;
    private javax.swing.JButton btn_addadmissionclear2;
    private javax.swing.JButton btn_addadmissionclear3;
    private javax.swing.JButton btn_addadmissionclear4;
    private javax.swing.JButton btn_addadmissionclear5;
    private javax.swing.JButton btn_addfeesloadrecord;
    private javax.swing.JButton btn_admissionuploadimage;
    private javax.swing.JButton btn_cancelstudent;
    private javax.swing.JButton btn_close;
    private javax.swing.JButton btn_minimize;
    private javax.swing.JButton btn_refrashmanagecashier;
    private javax.swing.JButton btn_refrashmanagecashier1;
    private javax.swing.JButton btn_refrashstudent;
    private javax.swing.JButton btn_updatestudent;
    private javax.swing.JButton btn_updatestudent1;
    private javax.swing.JComboBox<String> combobox_course;
    private javax.swing.JComboBox<String> combobox_course1;
    private javax.swing.JComboBox<String> combobox_managecourse;
    private javax.swing.JComboBox<String> combobox_modeofpayment1;
    private javax.swing.JComboBox<String> combobox_paymentbankname;
    private javax.swing.JComboBox<String> combobox_paymentname;
    private javax.swing.JComboBox<String> conbo_all_student;
    private javax.swing.JDesktopPane desktoppane_image;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel_SoftZyd;
    private javax.swing.JLabel jLabel_inven;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JScrollPane jScrollPane3;
    private javax.swing.JScrollPane jScrollPane4;
    private javax.swing.JScrollPane jScrollPane5;
    private javax.swing.JScrollPane jScrollPane6;
    private javax.swing.JSeparator jSeparator1;
    private javax.swing.JSeparator jSeparator2;
    private javax.swing.JSeparator jSeparator3;
    private javax.swing.JSeparator jSeparator4;
    private javax.swing.JLabel label_bankname;
    private javax.swing.JLabel label_chequeno;
    private javax.swing.JLabel label_course_manage;
    private javax.swing.JLabel label_datetime;
    private javax.swing.JLabel label_icon;
    private javax.swing.JLabel label_image;
    private javax.swing.JLabel label_mobileno;
    public javax.swing.JLabel label_name;
    private javax.swing.JLabel label_newadmission;
    private javax.swing.JLabel label_newadmission1;
    private javax.swing.JLabel label_newadmission2;
    private javax.swing.JLabel label_newadmission3;
    private javax.swing.JLabel label_newadmission5;
    private javax.swing.JLabel label_paymentcompany;
    private javax.swing.JLabel label_receivedfrom;
    private javax.swing.JLabel label_titlebar;
    private javax.swing.JPanel panel_addfees;
    private javax.swing.JPanel panel_addfees1;
    private javax.swing.JPanel panel_addfees2;
    private javax.swing.JPanel panel_addfees3;
    private javax.swing.JPanel panel_addnewfees;
    private javax.swing.JPanel panel_cashierhome;
    private javax.swing.JPanel panel_cashierlogout;
    private javax.swing.JPanel panel_coursemanage;
    private javax.swing.JPanel panel_duefees;
    private javax.swing.JPanel panel_home;
    private javax.swing.JPanel panel_info;
    private javax.swing.JPanel panel_managestudemt;
    private javax.swing.JPanel panel_managestudent;
    private javax.swing.JPanel panel_new_admission;
    private javax.swing.JPanel panel_newadmission;
    private javax.swing.JRadioButton radiobutton_female;
    private javax.swing.JRadioButton radiobutton_female1;
    private javax.swing.JRadioButton radiobutton_male;
    private javax.swing.JRadioButton radiobutton_male1;
    private javax.swing.JTable table_all_student;
    private javax.swing.JTable table_duefees;
    private javax.swing.JTable table_student;
    private javax.swing.JTextField text_addfeename;
    private javax.swing.JTextField text_addfeescoursename;
    private javax.swing.JTextField text_addfeescoursename1;
    private javax.swing.JTextField text_addfeesgrno;
    private javax.swing.JTextField text_addfeestakenfees;
    private javax.swing.JTextField text_addfeestotalfees;
    private javax.swing.JTextField text_addfeeswords;
    private javax.swing.JTextArea text_admissionaddress;
    private javax.swing.JTextField text_admissioncity;
    private javax.swing.JTextField text_admissioncontact;
    private javax.swing.JTextField text_admissiongr;
    private javax.swing.JTextField text_admissiongr1;
    private javax.swing.JTextField text_admissionimage;
    private javax.swing.JTextField text_admissionname;
    private javax.swing.JTextField text_chequeno;
    private javax.swing.JTextArea text_manageaddress;
    private javax.swing.JTextArea text_manageaddress1;
    private javax.swing.JTextField text_managecity;
    private javax.swing.JTextField text_managecontact;
    private javax.swing.JTextField text_managegr;
    private javax.swing.JTextField text_managename;
    private javax.swing.JTextField text_mobileno;
    private javax.swing.JTextField text_receivedfrom;
    private javax.swing.JTextField text_searchcashier;
    private javax.swing.JTextField text_searchduefees;
    private javax.swing.JTextField text_searchstudent;
    // End of variables declaration//GEN-END:variables

}
