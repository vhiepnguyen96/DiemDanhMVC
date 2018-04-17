/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package sukien.view;

import sukien.model.SuKien_Model;
import static administrator.settings.Config.bg_Color1;
import static administrator.settings.Config.bg_Color2;
import static administrator.settings.Config.color_Action;
import static administrator.settings.Config.fg_Color1;
import static administrator.settings.Config.fg_Color2;
import app.view.App_View;
import other.custom.GradientButton;
import other.custom.RoundedBorder;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Date;
import java.sql.Time;
import java.util.ArrayList;
import java.util.Arrays;
import javax.swing.JDialog;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.border.CompoundBorder;
import javax.swing.border.EmptyBorder;
import javax.swing.table.DefaultTableModel;
import other.custom.Alert;
import other.custom.TransitionPane;
import other.table.CustomTable;
import static resources.Resources.huy_Icon;
import static resources.Resources.luu_Icon;
import static resources.Resources.reimport_Icon;
import sukien.controller.SuKien_Controller;

/**
 *
 * @author chuna
 */
public class SuKien_ImportSK extends javax.swing.JFrame implements ActionListener {

    private CustomTable tb_SuKien;
    private String[] columnNames = {"Tất cả", "Mã Sự Kiện", "Tên sự kiện", "Ngày diễn ra", "Thời gian bắt đầu", "Thời gian kết thúc"};
    private String[] columnNames2 = {"Mã Sự Kiện", "Tên sự kiện", "Ngày diễn ra", "Thời gian bắt đầu", "Thời gian kết thúc"};
    private Object[][] data;
    private static SuKien_View VIEW = SuKien_View.getView();
    private JDialog dialog = new JDialog();
    private ArrayList<SuKien_Model> suKien_List = new ArrayList<>();
    private ArrayList<SuKien_Model> tonTais = new ArrayList<>();
    private String thatBai;

    /**
     * Creates new form Import_DSCB
     *
     * @param data
     */
    public SuKien_ImportSK(Object[][] data) {
        initComponents();
        this.data = data;
        createUI();
        loadData();
    }

    public JPanel getPnl_Path() {
        return pnl_Path;
    }

    private void createUI() {
        btn_Huy = new GradientButton(bg_Color1, bg_Color2, fg_Color1, fg_Color2, "Huỷ bỏ", huy_Icon);
        btn_Huy.addActionListener(this);

        btn_Luu = new GradientButton(bg_Color1, bg_Color2, fg_Color1, fg_Color2, "Lưu lại", luu_Icon);
        btn_Luu.addActionListener(this);

        btn_ReImport = new GradientButton(bg_Color1, bg_Color2, fg_Color1, fg_Color2, "Chọn tập tin khác", reimport_Icon);
        btn_ReImport.addActionListener(this);

        pnl_Action.add(btn_ReImport);
        pnl_Action.add(btn_Luu);
        pnl_Action.add(btn_Huy);
        pnl_Action.setBackground(color_Action);
        dialog.setSize(new Dimension(507, 175));
        pnl_Duplicate.setVisible(false);
        dialog.getContentPane().add(pnl_Confirm);
        dialog.pack();
        dialog.setResizable(false);
        dialog.setAlwaysOnTop(true);
        dialog.setLocationRelativeTo(this);
        setResizable(false);
    }

    public void setLabel(JLabel c) {
        c.setFont(new Font("Arial", 0, 14));
        c.setSize(new Dimension(c.getWidth(), 40));
        CompoundBorder border = new CompoundBorder(new RoundedBorder(), new EmptyBorder(5, 2, 5, 2));
        c.setBorder(border);
    }

    private void loadData() {
        tb_SuKien = new CustomTable(data, columnNames);
        tb_SuKien.setModel(new DefaultTableModel(data, columnNames) {
            @Override
            public boolean isCellEditable(int row, int column) {
                return false;
            }
        });
        pnl_Table.add(tb_SuKien.getScrollPane());
        tb_SuKien.hideColumn(0);
        pack();
        setAlwaysOnTop(true);
        setLocationRelativeTo(App_View.getContainer());
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        pnl_Confirm = new javax.swing.JPanel();
        lblWarning = new javax.swing.JLabel();
        btnCancel = new javax.swing.JButton();
        lblTitle = new javax.swing.JLabel();
        btnSkip = new javax.swing.JButton();
        btnReplace = new javax.swing.JButton();
        btnDetails = new javax.swing.JButton();
        pnl_Duplicate = new javax.swing.JPanel();
        jScrollPane2 = new javax.swing.JScrollPane();
        tblTonTai = new javax.swing.JTable();
        lbl_Title = new javax.swing.JLabel();
        pnl_Table = new javax.swing.JPanel();
        pnl_Path = new javax.swing.JPanel();
        pnl_Action = new javax.swing.JPanel();

        pnl_Confirm.setBackground(new java.awt.Color(255, 255, 255));

        lblWarning.setFont(new java.awt.Font("Arial", 0, 14)); // NOI18N
        lblWarning.setText("Có 1 cán bộ đã tồn tại trong hệ thống, bạn có muốn ghi đè lên dữ liệu cũ?");
        lblWarning.setBorder(javax.swing.BorderFactory.createEmptyBorder(1, 10, 1, 10));

        btnCancel.setFont(new java.awt.Font("Arial", 0, 14)); // NOI18N
        btnCancel.setText("Cancel");
        btnCancel.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnCancelActionPerformed(evt);
            }
        });

        lblTitle.setFont(new java.awt.Font("Arial", 0, 14)); // NOI18N
        lblTitle.setText("Import 14 cán bộ từ file excel");
        lblTitle.setBorder(javax.swing.BorderFactory.createEmptyBorder(1, 10, 1, 10));

        btnSkip.setFont(new java.awt.Font("Arial", 0, 14)); // NOI18N
        btnSkip.setText("Bỏ qua");
        btnSkip.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnSkipActionPerformed(evt);
            }
        });

        btnReplace.setFont(new java.awt.Font("Arial", 0, 14)); // NOI18N
        btnReplace.setText("Ghi đè");
        btnReplace.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnReplaceActionPerformed(evt);
            }
        });

        btnDetails.setText("Chi tiết");
        btnDetails.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnDetailsActionPerformed(evt);
            }
        });

        tblTonTai.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        tblTonTai.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "Title 1", "Title 2", "Title 3", "Title 4"
            }
        ));
        tblTonTai.setAutoResizeMode(javax.swing.JTable.AUTO_RESIZE_NEXT_COLUMN);
        tblTonTai.setFillsViewportHeight(true);
        tblTonTai.setFocusable(false);
        tblTonTai.setRequestFocusEnabled(false);
        tblTonTai.setRowHeight(20);
        tblTonTai.setSelectionMode(javax.swing.ListSelectionModel.SINGLE_SELECTION);
        jScrollPane2.setViewportView(tblTonTai);

        javax.swing.GroupLayout pnl_DuplicateLayout = new javax.swing.GroupLayout(pnl_Duplicate);
        pnl_Duplicate.setLayout(pnl_DuplicateLayout);
        pnl_DuplicateLayout.setHorizontalGroup(
            pnl_DuplicateLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnl_DuplicateLayout.createSequentialGroup()
                .addGap(0, 0, 0)
                .addComponent(jScrollPane2)
                .addGap(0, 0, 0))
        );
        pnl_DuplicateLayout.setVerticalGroup(
            pnl_DuplicateLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jScrollPane2, javax.swing.GroupLayout.DEFAULT_SIZE, 128, Short.MAX_VALUE)
        );

        javax.swing.GroupLayout pnl_ConfirmLayout = new javax.swing.GroupLayout(pnl_Confirm);
        pnl_Confirm.setLayout(pnl_ConfirmLayout);
        pnl_ConfirmLayout.setHorizontalGroup(
            pnl_ConfirmLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnl_ConfirmLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(pnl_ConfirmLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(pnl_ConfirmLayout.createSequentialGroup()
                        .addGroup(pnl_ConfirmLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(lblWarning, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(lblTitle, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                        .addContainerGap())
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, pnl_ConfirmLayout.createSequentialGroup()
                        .addGap(10, 10, 10)
                        .addGroup(pnl_ConfirmLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(pnl_ConfirmLayout.createSequentialGroup()
                                .addComponent(btnDetails, javax.swing.GroupLayout.PREFERRED_SIZE, 90, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(btnReplace)
                                .addGap(18, 18, 18)
                                .addComponent(btnSkip)
                                .addGap(18, 18, 18)
                                .addComponent(btnCancel))
                            .addComponent(pnl_Duplicate, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                        .addGap(25, 25, 25))))
        );
        pnl_ConfirmLayout.setVerticalGroup(
            pnl_ConfirmLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnl_ConfirmLayout.createSequentialGroup()
                .addGap(8, 8, 8)
                .addComponent(lblTitle, javax.swing.GroupLayout.PREFERRED_SIZE, 27, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(lblWarning, javax.swing.GroupLayout.PREFERRED_SIZE, 27, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(pnl_Duplicate, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 24, Short.MAX_VALUE)
                .addGroup(pnl_ConfirmLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(btnDetails)
                    .addComponent(btnReplace)
                    .addComponent(btnSkip)
                    .addComponent(btnCancel))
                .addContainerGap())
        );

        setAlwaysOnTop(true);
        setMaximumSize(new java.awt.Dimension(1000, 700));
        setPreferredSize(new java.awt.Dimension(1000, 700));
        addComponentListener(new java.awt.event.ComponentAdapter() {
            public void componentShown(java.awt.event.ComponentEvent evt) {
                formComponentShown(evt);
            }
        });

        lbl_Title.setBackground(new java.awt.Color(255, 255, 255));
        lbl_Title.setFont(new java.awt.Font("Arial", 0, 24)); // NOI18N
        lbl_Title.setForeground(new java.awt.Color(102, 102, 102));
        lbl_Title.setText("Nhập danh sách sự kiện");
        lbl_Title.setBorder(javax.swing.BorderFactory.createEmptyBorder(10, 10, 15, 10));
        lbl_Title.setOpaque(true);

        pnl_Table.setBorder(javax.swing.BorderFactory.createEmptyBorder(5, 15, 5, 15));
        pnl_Table.setOpaque(false);
        pnl_Table.setLayout(new java.awt.GridLayout(1, 0));

        pnl_Path.setBorder(javax.swing.BorderFactory.createEmptyBorder(5, 15, 15, 15));
        pnl_Path.setOpaque(false);
        pnl_Path.setLayout(new java.awt.FlowLayout(java.awt.FlowLayout.LEFT, 5, 2));

        pnl_Action.setBackground(new java.awt.Color(204, 204, 255));
        pnl_Action.setMinimumSize(new java.awt.Dimension(0, 45));
        pnl_Action.setPreferredSize(new java.awt.Dimension(0, 45));
        pnl_Action.setLayout(new java.awt.FlowLayout(java.awt.FlowLayout.CENTER, 10, 2));

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(lbl_Title, javax.swing.GroupLayout.DEFAULT_SIZE, 1058, Short.MAX_VALUE)
            .addComponent(pnl_Table, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(pnl_Action, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(pnl_Path, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(lbl_Title)
                .addGap(0, 0, 0)
                .addComponent(pnl_Table, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGap(0, 0, 0)
                .addComponent(pnl_Path, javax.swing.GroupLayout.DEFAULT_SIZE, 44, Short.MAX_VALUE)
                .addGap(0, 0, 0)
                .addComponent(pnl_Action, javax.swing.GroupLayout.PREFERRED_SIZE, 45, javax.swing.GroupLayout.PREFERRED_SIZE))
        );
    }// </editor-fold>//GEN-END:initComponents

    private void formComponentShown(java.awt.event.ComponentEvent evt) {//GEN-FIRST:event_formComponentShown
     }//GEN-LAST:event_formComponentShown

    private void btnCancelActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnCancelActionPerformed
        dialog.dispose();
        dispose();
    }//GEN-LAST:event_btnCancelActionPerformed

    private void btnSkipActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSkipActionPerformed
        SuKien_ListSK.getController().add_SuKien(suKien_List);
        updateTable();
        if (!SuKien_Controller.getAdd_Failed().isEmpty()) {
            thatBai = "";
            SuKien_Controller.getAdd_Failed().forEach((t) -> {
                thatBai += "Thêm sự kiện có mã " + t.getMaSK() + " thất bại.\n";
            });
            Alert.showMessageDialog(VIEW, thatBai);
        }
        if (suKien_List.size() - SuKien_Controller.getAdd_Failed().size() > 0) {
            Alert.showMessageDialog(VIEW, "Đã import thành công " + (suKien_List.size() - SuKien_Controller.getAdd_Failed().size()) + " sự kiện.", "Thông báo");
        }
    }//GEN-LAST:event_btnSkipActionPerformed

    private void btnReplaceActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnReplaceActionPerformed
        SuKien_ListSK.getController().add_SuKien(suKien_List);
        SuKien_ListSK.getController().update_SuKien(tonTais);
        updateTable();
        int countSuccess = 0;
        if (!SuKien_Controller.getAdd_Failed().isEmpty()) {
            thatBai = "";
            SuKien_Controller.getAdd_Failed().forEach((t) -> {
                thatBai += "Thêm sự kiện có mã " + t.getMaSK() + " thất bại.\n";
            });
            Alert.showMessageDialog(VIEW, thatBai);
            countSuccess += suKien_List.size() - SuKien_Controller.getAdd_Failed().size();
        }
        if (!SuKien_Controller.getUpdate_Failed().isEmpty()) {
            thatBai = "";
            SuKien_Controller.getUpdate_Failed().forEach((t) -> {
                thatBai += "Ghi đè sự kiện có mã " + t.getMaSK() + " thất bại.\n";
            });
            Alert.showMessageDialog(VIEW, thatBai);
            countSuccess += tonTais.size() - SuKien_Controller.getUpdate_Failed().size();
        }
        if (countSuccess > 0) {
            Alert.showMessageDialog(VIEW, "Đã import thành công " + countSuccess + " sự kiện.", "Thông báo");
        }
    }//GEN-LAST:event_btnReplaceActionPerformed

    private void btnDetailsActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnDetailsActionPerformed
        if (pnl_Duplicate.isVisible()) {
            pnl_Duplicate.setVisible(false);
            dialog.setSize(new Dimension(507, 175));
            dialog.validate();
            dialog.repaint();
            dialog.setLocationRelativeTo(this);
        } else {
            pnl_Duplicate.setVisible(true);
            dialog.setSize(new Dimension(507, 300));
            dialog.validate();
            dialog.repaint();
            dialog.setLocationRelativeTo(this);
        }
    }//GEN-LAST:event_btnDetailsActionPerformed
    private GradientButton btn_ReImport;
    private GradientButton btn_Huy;
    private GradientButton btn_Luu;
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnCancel;
    private javax.swing.JButton btnDetails;
    private javax.swing.JButton btnReplace;
    private javax.swing.JButton btnSkip;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JLabel lblTitle;
    private javax.swing.JLabel lblWarning;
    private javax.swing.JLabel lbl_Title;
    private javax.swing.JPanel pnl_Action;
    private javax.swing.JPanel pnl_Confirm;
    private javax.swing.JPanel pnl_Duplicate;
    private javax.swing.JPanel pnl_Path;
    private javax.swing.JPanel pnl_Table;
    private javax.swing.JTable tblTonTai;
    // End of variables declaration//GEN-END:variables

    public void setBtnLuu(boolean f) {
        btn_Luu.setVisible(f);
    }

    public JPanel getPath() {
        return pnl_Path;
    }

    public void setPnl_Path(JPanel pnl_Path) {
        this.pnl_Path = pnl_Path;
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        Object ob = e.getSource();
        if (ob.equals(btn_ReImport)) {
            dispose();
            VIEW.import_SK();
        }
        if (ob.equals(btn_Luu)) {
            checkDuplicate();
            import2Table();
        }
        if (ob.equals(btn_Huy)) {
            TransitionPane.closeDialogBox();
        }

    }

    private void checkDuplicate() {
        Object[][] current_Data = tb_SuKien.getTableData();
        Object[][] old_Data = SuKien_Controller.array2Object(SuKien_ListSK.getController().load_SuKien());
        suKien_List = new ArrayList<>();
        tonTais = new ArrayList<>();
        if (current_Data.length != 0) {
            for (Object[] data_1 : current_Data) {
                for (Object[] old_Data1 : old_Data) {
                    if (data_1[1].equals(old_Data1[1])) {
                        tonTais.add(new SuKien_Model(
                                String.valueOf(data_1[1]),
                                String.valueOf(data_1[2]),
                                Date.valueOf(String.valueOf(data_1[3])),
                                Time.valueOf(String.valueOf(data_1[4])),
                                Time.valueOf(String.valueOf(data_1[5]))
                        ));
                        Arrays.fill(data_1, "");
                    }
                }
            }
            for (Object[] data_1 : current_Data) {
                if (!data_1[1].equals("")) {
                    suKien_List.add(new SuKien_Model(
                            String.valueOf(data_1[1]),
                            String.valueOf(data_1[2]),
                            Date.valueOf(String.valueOf(data_1[3])),
                            Time.valueOf(String.valueOf(data_1[4])),
                            Time.valueOf(String.valueOf(data_1[5]))
                    ));
                }
            }
        }

    }

    private void import2Table() {
        DefaultTableModel listModel = new DefaultTableModel();
        listModel.setColumnIdentifiers(columnNames2);
        if (!tonTais.isEmpty()) {
            TransitionPane.setAlwaysOnTop(false);
            tonTais.forEach((t) -> {
                Object[] obj = {t.getMaSK(), t.getTenSK(), t.getNgayDienRa(), t.getGioVao(), t.getGioRa()};
                listModel.addRow(obj);
            });
            tblTonTai.setModel(listModel);
            lblTitle.setText("Import " + data.length + " sự kiện từ tập tin.");
            lblWarning.setText("Có " + listModel.getRowCount() + " sự kiện đã có trong hệ thống."
                    + " Bạn có muốn ghi đè lên dữ liệu cũ?");
            dialog.setTitle("Xác nhận import danh sách sự kiện");
            dialog.setLocationRelativeTo(this);
            pnl_Duplicate.setVisible(false);
            dialog.show();
        } else {
            int select = Alert.showQuestionDialog(this, "Bạn muốn import " + suKien_List.size() + " sự kiện này?", "Xác nhận thêm");
            if (select == Alert.OK) {
                int countSuccess = 0;
                SuKien_ListSK.getController().add_SuKien(suKien_List);
                updateTable();
                if (!SuKien_Controller.getAdd_Failed().isEmpty()) {
                    thatBai = "";
                    SuKien_Controller.getAdd_Failed().forEach((t) -> {
                        thatBai += "Thêm sự kiện có mã " + t.getMaSK() + " thất bại.\n";
                    });
                    Alert.showMessageDialog(VIEW, thatBai);
                    countSuccess += suKien_List.size() + SuKien_Controller.getAdd_Failed().size();
                }
                if (countSuccess > 0) {
                    Alert.showMessageDialog(VIEW, "Đã import thành công " + countSuccess + " sự kiện.", "Thông báo");
                }
            }
        }
    }

    private void updateTable() {
        dialog.setVisible(false);
        VIEW.setTitle("Danh sách cán bộ", true);
        TransitionPane.replacePane(VIEW.getPnl_Pane(), VIEW.getjPanel4());
        VIEW.getCollapse().setCollapsed(false);
        VIEW.getSuKienList().getPaneTable().getComboBoxItem().setSelectedIndex(0);
        VIEW.getSuKienList().getPaneTable().initFilterAndButtons();
        VIEW.showPanel();
        VIEW.refresh();
        dispose();
    }

}
