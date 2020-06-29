/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package view;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.time.DayOfWeek;
import java.time.LocalDate;
import java.time.YearMonth;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;
import javax.swing.JCheckBox;
import model.BookedField;
import model.BookedFieldSingle;
import model.Client;
import model.Field;
import model.dao.BookedFieldDAO;

/**
 *
 * @author lamit
 */
public class BookedFieldFrm extends javax.swing.JFrame {

    /**
     * Creates new form BookedFieldFrm
     */
    BookedFieldDAO dao;
    ArrayList<JCheckBox> listCheckBox = new ArrayList<>();
    Field f;
    Client c;
    int idBooking = 0;
    int idBookedField = 0;
    ArrayList<LocalDate> listDate = new ArrayList<>();
    public BookedFieldFrm() {
        setTitle("BookedField Frm");
        setLocationRelativeTo(null);
        initComponents();
        dao = new BookedFieldDAO();
        init();
        cbMultiDay.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent ae) {
                setVisibleMulti(cbMultiDay.isSelected());
            }
        });
        btnConfirm.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent ae) {
                DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd");
                String startDate = txtStartDate.getText();
                String endDate = txtEndDate.getText();
                LocalDate localDate = LocalDate.parse(startDate, formatter);
                LocalDate localDate1 = LocalDate.parse(endDate, formatter);
                ArrayList<Integer> listChoose =  new ArrayList<>();
                listChoose = getSelectedDate();
                listChoose.forEach(
                    (it) ->{
                        getAllDate(it, localDate, localDate1);
                    }
                );
                String type = "single";
                if(cbMultiDay.isSelected()){
                    type = "multi";
                }
                BookedField bf = new BookedField(txtStartTimeP.getText(), txtEndTimeP.getText(),
                        localDate,localDate1, f.getPrice(), 0, f,type , f.getName());
                dao.updateBookedField(bf);
                listDate.forEach(
                        (it) -> {
                            dao.updateBookedFieldSingle(it);
                        }
                );
            }
        });
    }
    
    public void getAllDate(int day,LocalDate start,LocalDate end){
        DayOfWeek dowOfStart = start.getDayOfWeek();
        int difference = 0;
        switch(day){
            case 2:{
                difference = DayOfWeek.MONDAY.getValue() - dowOfStart.getValue();
                break;
            }
            case 3:{
                difference = DayOfWeek.TUESDAY.getValue() - dowOfStart.getValue();
                break;
            }
            case 4:{
                difference = DayOfWeek.WEDNESDAY.getValue() - dowOfStart.getValue();
                break;
            }
            case 5:{
                difference = DayOfWeek.THURSDAY.getValue() - dowOfStart.getValue();
                break;
            }
            case 6:{
                difference = DayOfWeek.FRIDAY.getValue() - dowOfStart.getValue();
                break;
            }
            case 7:{
                difference = DayOfWeek.SATURDAY.getValue() - dowOfStart.getValue();
                break;
            }
            case 8:{
                difference = DayOfWeek.SUNDAY.getValue() - dowOfStart.getValue();
                break;
            }
        }
        if (difference < 0) difference += 7;

//        ArrayList<LocalDate> fridaysInRange = new ArrayList<LocalDate>();

        LocalDate currentFriday = start.plusDays(difference);
        do {
            listDate.add(currentFriday);
            currentFriday = currentFriday.plusDays(7);
        } while (currentFriday.isBefore(end));
    }
   
    
    
    public ArrayList<Integer> getSelectedDate(){
        ArrayList<Integer> list = new  ArrayList<>();
        for(int i = 2; i <= 8; i++){
            if(listCheckBox.get(i-2).isSelected()){
                list.add(i);
            }
        }
        return list;
    }
    public void init(){
        listCheckBox.add(cb2);
        listCheckBox.add(cb3);
        listCheckBox.add(cb4);
        listCheckBox.add(cb5);
        listCheckBox.add(cb6);
        listCheckBox.add(cb7);
        listCheckBox.add(cb8);
        setVisibleMulti(false);
    }
    public void setVisibleMulti(boolean visible){
        listCheckBox.forEach(
                (it) -> it.setVisible(visible)
        );
    }
    public void setFieldClient(Field f, Client c){
        this.f = f;
        this.c = c;
        lbField.setText(f.getName());
        lbName.setText(c.getName());
        dao.updateBooking(c,f);
        System.out.println("a"+idBooking);
    }
    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        cbMultiDay = new javax.swing.JCheckBox();
        cb2 = new javax.swing.JCheckBox();
        cb3 = new javax.swing.JCheckBox();
        cb4 = new javax.swing.JCheckBox();
        cb5 = new javax.swing.JCheckBox();
        cb6 = new javax.swing.JCheckBox();
        cb7 = new javax.swing.JCheckBox();
        cb8 = new javax.swing.JCheckBox();
        btnConfirm = new javax.swing.JButton();
        txtStartTimeP = new javax.swing.JTextField();
        txtStartDate = new javax.swing.JTextField();
        txtEndTimeP = new javax.swing.JTextField();
        txtEndDate = new javax.swing.JTextField();
        lbName = new javax.swing.JLabel();
        lbField = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jLabel1.setText("Tên Khách");

        jLabel2.setText("Sân");

        jLabel3.setText("Đặt từ ngày");

        jLabel4.setText("Đến ngày");

        jLabel5.setText("Từ giờ");

        jLabel6.setText("Đến giờ");

        cbMultiDay.setText("Đặt nhiều ngày trong tuần(cố định)");

        cb2.setText("Thu 2");

        cb3.setText("Thu 3");

        cb4.setText("Thu 4");

        cb5.setText("Thu 5");

        cb6.setText("Thu 6");

        cb7.setText("Thu 7");

        cb8.setText("Chu Nhat");

        btnConfirm.setText("Xác nhận");

        txtStartTimeP.setText("20:00:00");

        txtStartDate.setText("2020-07-01");

        txtEndTimeP.setText("20:00:00");

        txtEndDate.setText("2020-07-01");

        lbName.setText("jLabel7");

        lbField.setText("jLabel7");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addGap(31, 31, 31)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(cbMultiDay)
                                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                                        .addGroup(javax.swing.GroupLayout.Alignment.LEADING, layout.createSequentialGroup()
                                            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                                .addComponent(jLabel3)
                                                .addComponent(jLabel5))
                                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                                .addComponent(txtStartDate, javax.swing.GroupLayout.PREFERRED_SIZE, 79, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                .addComponent(txtStartTimeP, javax.swing.GroupLayout.PREFERRED_SIZE, 79, javax.swing.GroupLayout.PREFERRED_SIZE))
                                            .addGap(45, 45, 45)
                                            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                                .addGroup(layout.createSequentialGroup()
                                                    .addComponent(jLabel6)
                                                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                                    .addComponent(txtEndTimeP, javax.swing.GroupLayout.PREFERRED_SIZE, 79, javax.swing.GroupLayout.PREFERRED_SIZE))
                                                .addGroup(layout.createSequentialGroup()
                                                    .addComponent(jLabel4)
                                                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                                    .addComponent(txtEndDate, javax.swing.GroupLayout.PREFERRED_SIZE, 79, javax.swing.GroupLayout.PREFERRED_SIZE))))
                                        .addGroup(javax.swing.GroupLayout.Alignment.LEADING, layout.createSequentialGroup()
                                            .addGap(34, 34, 34)
                                            .addComponent(cb3)
                                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                            .addComponent(cb4)
                                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                            .addComponent(cb5)
                                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                            .addComponent(cb6)
                                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                            .addComponent(cb7)))
                                    .addGroup(layout.createSequentialGroup()
                                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                            .addComponent(jLabel1)
                                            .addComponent(jLabel2))
                                        .addGap(59, 59, 59)
                                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                            .addComponent(lbField)
                                            .addComponent(lbName)))))
                            .addComponent(cb2))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(cb8))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(180, 180, 180)
                        .addComponent(btnConfirm)))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(23, 23, 23)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel1)
                    .addComponent(lbName))
                .addGap(30, 30, 30)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel2)
                    .addComponent(lbField))
                .addGap(30, 30, 30)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel3)
                    .addComponent(jLabel4)
                    .addComponent(txtEndDate, javax.swing.GroupLayout.PREFERRED_SIZE, 33, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txtStartDate, javax.swing.GroupLayout.PREFERRED_SIZE, 33, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(21, 21, 21)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel5)
                    .addComponent(jLabel6)
                    .addComponent(txtEndTimeP, javax.swing.GroupLayout.PREFERRED_SIZE, 33, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txtStartTimeP, javax.swing.GroupLayout.PREFERRED_SIZE, 33, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(30, 30, 30)
                .addComponent(cbMultiDay)
                .addGap(36, 36, 36)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(cb2)
                    .addComponent(cb7)
                    .addComponent(cb6)
                    .addComponent(cb5)
                    .addComponent(cb4)
                    .addComponent(cb3)
                    .addComponent(cb8))
                .addGap(78, 78, 78)
                .addComponent(btnConfirm)
                .addContainerGap(95, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    /**
     * @param args the command line arguments
     */
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
            java.util.logging.Logger.getLogger(BookedFieldFrm.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(BookedFieldFrm.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(BookedFieldFrm.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(BookedFieldFrm.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new BookedFieldFrm().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnConfirm;
    private javax.swing.JCheckBox cb2;
    private javax.swing.JCheckBox cb3;
    private javax.swing.JCheckBox cb4;
    private javax.swing.JCheckBox cb5;
    private javax.swing.JCheckBox cb6;
    private javax.swing.JCheckBox cb7;
    private javax.swing.JCheckBox cb8;
    private javax.swing.JCheckBox cbMultiDay;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel lbField;
    private javax.swing.JLabel lbName;
    private javax.swing.JTextField txtEndDate;
    private javax.swing.JTextField txtEndTimeP;
    private javax.swing.JTextField txtStartDate;
    private javax.swing.JTextField txtStartTimeP;
    // End of variables declaration//GEN-END:variables
}
