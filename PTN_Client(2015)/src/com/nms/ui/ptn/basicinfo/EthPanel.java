/*
 * EthPanel.java
 *
 * Created on __DATE__, __TIME__
 */

package com.nms.ui.ptn.basicinfo;


/**
 *
 * @author  __USER__
 */
@SuppressWarnings("serial")
public class EthPanel extends javax.swing.JPanel {

	/** Creates new form EthPanel */
	public EthPanel() {
		initComponents();
	}

	/** This method is called from within the constructor to
	 * initialize the form.
	 * WARNING: Do NOT modify this code. The content of this method is
	 * always regenerated by the Form Editor.
	 */
	//GEN-BEGIN:initComponents
	// <editor-fold defaultstate="collapsed" desc="Generated Code">
	private void initComponents() {

		jPanel4 = new javax.swing.JPanel();
		jPanel5 = new javax.swing.JPanel();
		jLabel1 = new javax.swing.JLabel();
		jScrollPane1 = new javax.swing.JScrollPane();
		jTable1 = new javax.swing.JTable();
		jButton1 = new javax.swing.JButton();
		jButton2 = new javax.swing.JButton();
		jTabbedPane1 = new javax.swing.JTabbedPane();
		jPanel8 = new javax.swing.JPanel();
		jLabel2 = new javax.swing.JLabel();
		jLabel3 = new javax.swing.JLabel();
		jLabel4 = new javax.swing.JLabel();
		jLabel5 = new javax.swing.JLabel();
		jTextField1 = new javax.swing.JTextField();
		jTextField2 = new javax.swing.JTextField();
		jTextField3 = new javax.swing.JTextField();
		jScrollPane2 = new javax.swing.JScrollPane();
		jTextArea1 = new javax.swing.JTextArea();
		jPanel2 = new javax.swing.JPanel();
		jPanel9 = new javax.swing.JPanel();
		jLabel6 = new javax.swing.JLabel();
		jRadioButton1 = new javax.swing.JRadioButton();
		jRadioButton2 = new javax.swing.JRadioButton();
		jTextField4 = new javax.swing.JTextField();
		jLabel7 = new javax.swing.JLabel();
		jLabel8 = new javax.swing.JLabel();
		jLabel9 = new javax.swing.JLabel();
		jLabel10 = new javax.swing.JLabel();
		jLabel11 = new javax.swing.JLabel();
		jCheckBox1 = new javax.swing.JCheckBox();
		jTextField5 = new javax.swing.JTextField();
		jTextField6 = new javax.swing.JTextField();
		jTextField7 = new javax.swing.JTextField();
		jTextField8 = new javax.swing.JTextField();
		jLabel14 = new javax.swing.JLabel();
		jPanel3 = new javax.swing.JPanel();
		jPanel6 = new javax.swing.JPanel();
		jPanel7 = new javax.swing.JPanel();
		jPanel1 = new javax.swing.JPanel();
		jLabel12 = new javax.swing.JLabel();
		jTextField9 = new javax.swing.JTextField();
		jLabel13 = new javax.swing.JLabel();
		jComboBox1 = new javax.swing.JComboBox();
		jScrollPane3 = new javax.swing.JScrollPane();
		jTable2 = new javax.swing.JTable();

		setPreferredSize(new java.awt.Dimension(1000, 570));

		jPanel4.setBorder(javax.swing.BorderFactory.createEtchedBorder());

		jPanel5.setBackground(new java.awt.Color(204, 255, 255));
		jPanel5.setBorder(javax.swing.BorderFactory.createEtchedBorder());

		jLabel1.setText("\u4ee5\u592a\u7f51AC\u7ba1\u7406");

		javax.swing.GroupLayout jPanel5Layout = new javax.swing.GroupLayout(
				jPanel5);
		jPanel5.setLayout(jPanel5Layout);
		jPanel5Layout.setHorizontalGroup(jPanel5Layout.createParallelGroup(
				javax.swing.GroupLayout.Alignment.LEADING).addGroup(
				jPanel5Layout.createSequentialGroup().addComponent(jLabel1,
						javax.swing.GroupLayout.PREFERRED_SIZE, 81,
						javax.swing.GroupLayout.PREFERRED_SIZE)
						.addContainerGap(911, Short.MAX_VALUE)));
		jPanel5Layout.setVerticalGroup(jPanel5Layout.createParallelGroup(
				javax.swing.GroupLayout.Alignment.LEADING).addComponent(
				jLabel1, javax.swing.GroupLayout.DEFAULT_SIZE, 23,
				Short.MAX_VALUE));

		jTable1.setModel(new javax.swing.table.DefaultTableModel(
				new Object[][] {
						{ "1", "fe.1.3/1", "使能", "传输层失效", "ETH", "端口模式", null,
								null, null, null, null, null, null },
						{ null, null, null, null, null, null, null, null, null,
								null, null, null, null },
						{ null, null, null, null, null, null, null, null, null,
								null, null, null, null },
						{ null, null, null, null, null, null, null, null, null,
								null, null, null, null },
						{ null, null, null, null, null, null, null, null, null,
								null, null, null, null },
						{ null, null, null, null, null, null, null, null, null,
								null, null, null, null },
						{ null, null, null, null, null, null, null, null, null,
								null, null, null, null },
						{ null, null, null, null, null, null, null, null, null,
								null, null, null, null },
						{ null, null, null, null, null, null, null, null, null,
								null, null, null, null },
						{ null, null, null, null, null, null, null, null, null,
								null, null, null, null },
						{ null, null, null, null, null, null, null, null, null,
								null, null, null, null },
						{ null, null, null, null, null, null, null, null, null,
								null, null, null, null },
						{ null, null, null, null, null, null, null, null, null,
								null, null, null, null },
						{ null, null, null, null, null, null, null, null, null,
								null, null, null, null },
						{ null, null, null, null, null, null, null, null, null,
								null, null, null, null },
						{ null, null, null, null, null, null, null, null, null,
								null, null, null, null },
						{ null, null, null, null, null, null, null, null, null,
								null, null, null, null },
						{ null, null, null, null, null, null, null, null, null,
								null, null, null, null },
						{ null, null, null, null, null, null, null, null, null,
								null, null, null, null },
						{ null, null, null, null, null, null, null, null, null,
								null, null, null, null },
						{ null, null, null, null, null, null, null, null, null,
								null, null, null, null },
						{ null, null, null, null, null, null, null, null, null,
								null, null, null, null } }, new String[] {
						"序号", "端口名称", "管理状态", "工作状态", "角色", "实际速率(mb/s)",
						"设置速率", "本地MAC", "最大帧长", "流控", "入口带宽限制", "出口带宽限制",
						"工作波长" }));
		jTable1.setShowHorizontalLines(false);
		jTable1.setShowVerticalLines(false);
		jScrollPane1.setViewportView(jTable1);

		jButton1.setIcon(new javax.swing.ImageIcon(getClass().getResource(
				"/com/nms/ui/images/newButton.jpg"))); // NOI18N
		jButton1.addActionListener(new java.awt.event.ActionListener() {
			@Override
			public void actionPerformed(java.awt.event.ActionEvent evt) {
				jButton1ActionPerformed(evt);
			}
		});

		jButton2.setIcon(new javax.swing.ImageIcon(getClass().getResource(
				"/com/nms/ui/images/list.jpg"))); // NOI18N
		jButton2.addActionListener(new java.awt.event.ActionListener() {
			@Override
			public void actionPerformed(java.awt.event.ActionEvent evt) {
				jButton2ActionPerformed(evt);
			}
		});

		javax.swing.GroupLayout jPanel4Layout = new javax.swing.GroupLayout(
				jPanel4);
		jPanel4.setLayout(jPanel4Layout);
		jPanel4Layout
				.setHorizontalGroup(jPanel4Layout
						.createParallelGroup(
								javax.swing.GroupLayout.Alignment.LEADING)
						.addComponent(jPanel5,
								javax.swing.GroupLayout.DEFAULT_SIZE,
								javax.swing.GroupLayout.DEFAULT_SIZE,
								Short.MAX_VALUE)
						.addGroup(
								jPanel4Layout
										.createSequentialGroup()
										.addComponent(
												jButton1,
												javax.swing.GroupLayout.PREFERRED_SIZE,
												212,
												javax.swing.GroupLayout.PREFERRED_SIZE)
										.addPreferredGap(
												javax.swing.LayoutStyle.ComponentPlacement.RELATED,
												471, Short.MAX_VALUE)
										.addComponent(
												jButton2,
												javax.swing.GroupLayout.PREFERRED_SIZE,
												313,
												javax.swing.GroupLayout.PREFERRED_SIZE))
						.addGroup(
								jPanel4Layout
										.createSequentialGroup()
										.addComponent(
												jScrollPane1,
												javax.swing.GroupLayout.DEFAULT_SIZE,
												986, Short.MAX_VALUE)
										.addContainerGap()));
		jPanel4Layout
				.setVerticalGroup(jPanel4Layout
						.createParallelGroup(
								javax.swing.GroupLayout.Alignment.LEADING)
						.addGroup(
								jPanel4Layout
										.createSequentialGroup()
										.addComponent(
												jPanel5,
												javax.swing.GroupLayout.PREFERRED_SIZE,
												javax.swing.GroupLayout.DEFAULT_SIZE,
												javax.swing.GroupLayout.PREFERRED_SIZE)
										.addPreferredGap(
												javax.swing.LayoutStyle.ComponentPlacement.RELATED)
										.addGroup(
												jPanel4Layout
														.createParallelGroup(
																javax.swing.GroupLayout.Alignment.LEADING)
														.addComponent(
																jButton1,
																javax.swing.GroupLayout.PREFERRED_SIZE,
																23,
																javax.swing.GroupLayout.PREFERRED_SIZE)
														.addComponent(
																jButton2,
																javax.swing.GroupLayout.PREFERRED_SIZE,
																23,
																javax.swing.GroupLayout.PREFERRED_SIZE))
										.addPreferredGap(
												javax.swing.LayoutStyle.ComponentPlacement.RELATED)
										.addComponent(
												jScrollPane1,
												javax.swing.GroupLayout.DEFAULT_SIZE,
												202, Short.MAX_VALUE)));

		jLabel2.setText("SFP\u671f\u671b\u7c7b\u578b");

		jLabel3.setText("SFP\u5b9e\u9645\u7c7b\u578b");

		jLabel4.setText("\u5de5\u4f5c\u6ce2\u957f(nm)");

		jLabel5.setText("SFP\u5382\u5bb6\u4fe1\u606f");

		jTextField1.setText("\u901f\u7387\u9002\u914d");
		jTextField1.addActionListener(new java.awt.event.ActionListener() {
			@Override
			public void actionPerformed(java.awt.event.ActionEvent evt) {
				jTextField1ActionPerformed(evt);
			}
		});

		jTextField2.setText("10GBASE_L");

		jTextField3.setText("1310");

		jTextArea1.setColumns(20);
		jTextArea1.setRows(5);
		jScrollPane2.setViewportView(jTextArea1);

		javax.swing.GroupLayout jPanel8Layout = new javax.swing.GroupLayout(
				jPanel8);
		jPanel8.setLayout(jPanel8Layout);
		jPanel8Layout
				.setHorizontalGroup(jPanel8Layout
						.createParallelGroup(
								javax.swing.GroupLayout.Alignment.LEADING)
						.addGroup(
								jPanel8Layout
										.createSequentialGroup()
										.addGap(39, 39, 39)
										.addGroup(
												jPanel8Layout
														.createParallelGroup(
																javax.swing.GroupLayout.Alignment.LEADING)
														.addComponent(jLabel2)
														.addComponent(jLabel3)
														.addComponent(jLabel4)
														.addComponent(jLabel5))
										.addGap(98, 98, 98)
										.addGroup(
												jPanel8Layout
														.createParallelGroup(
																javax.swing.GroupLayout.Alignment.LEADING,
																false)
														.addComponent(
																jTextField1,
																javax.swing.GroupLayout.DEFAULT_SIZE,
																305,
																Short.MAX_VALUE)
														.addComponent(
																jScrollPane2)
														.addComponent(
																jTextField2)
														.addComponent(
																jTextField3))
										.addContainerGap(481, Short.MAX_VALUE)));
		jPanel8Layout
				.setVerticalGroup(jPanel8Layout
						.createParallelGroup(
								javax.swing.GroupLayout.Alignment.LEADING)
						.addGroup(
								jPanel8Layout
										.createSequentialGroup()
										.addGap(21, 21, 21)
										.addGroup(
												jPanel8Layout
														.createParallelGroup(
																javax.swing.GroupLayout.Alignment.BASELINE)
														.addComponent(jLabel2)
														.addComponent(
																jTextField1,
																javax.swing.GroupLayout.PREFERRED_SIZE,
																javax.swing.GroupLayout.DEFAULT_SIZE,
																javax.swing.GroupLayout.PREFERRED_SIZE))
										.addGap(18, 18, 18)
										.addGroup(
												jPanel8Layout
														.createParallelGroup(
																javax.swing.GroupLayout.Alignment.BASELINE)
														.addComponent(jLabel3)
														.addComponent(
																jTextField2,
																javax.swing.GroupLayout.PREFERRED_SIZE,
																javax.swing.GroupLayout.DEFAULT_SIZE,
																javax.swing.GroupLayout.PREFERRED_SIZE))
										.addGap(18, 18, 18)
										.addGroup(
												jPanel8Layout
														.createParallelGroup(
																javax.swing.GroupLayout.Alignment.BASELINE)
														.addComponent(jLabel4)
														.addComponent(
																jTextField3,
																javax.swing.GroupLayout.PREFERRED_SIZE,
																javax.swing.GroupLayout.DEFAULT_SIZE,
																javax.swing.GroupLayout.PREFERRED_SIZE))
										.addGap(18, 18, 18)
										.addGroup(
												jPanel8Layout
														.createParallelGroup(
																javax.swing.GroupLayout.Alignment.LEADING)
														.addComponent(jLabel5)
														.addComponent(
																jScrollPane2,
																javax.swing.GroupLayout.PREFERRED_SIZE,
																javax.swing.GroupLayout.DEFAULT_SIZE,
																javax.swing.GroupLayout.PREFERRED_SIZE))
										.addContainerGap(11, Short.MAX_VALUE)));

		jTabbedPane1.addTab("SFP\u6a21\u5757\u4fe1\u606f", jPanel8);

		jPanel9.setBorder(javax.swing.BorderFactory.createEtchedBorder());

		jLabel6.setText("\u9759\u6001MAC\u5730\u5740");

		jRadioButton1.setText("\u9ed8\u8ba4MAC\u5730\u5740");

		jRadioButton2.setText("\u6307\u5b9aMAC\u5730\u5740");

		jLabel7.setText("\u90bb\u5c45\u7f51\u5143ID");

		jLabel8.setText("\u5bf9\u7aef\u63a5\u53e3MAC\u5730\u5740");

		jLabel9.setText("\u5bf9\u7aef\u63a5\u53e3ID");

		jLabel10.setText("\u90bb\u5c45\u53d1\u73b0\u72b6\u6001");

		jLabel11.setText("CCN\u627f\u8f7d\u4f7f\u80fd");

		jCheckBox1.addActionListener(new java.awt.event.ActionListener() {
			@Override
			public void actionPerformed(java.awt.event.ActionEvent evt) {
				jCheckBox1ActionPerformed(evt);
			}
		});

		jTextField6.setText("00-00-00-00");

		jTextField8.setText("\u81ea\u52a8\u53d1\u73b0\u4e2d");
		jTextField8.addActionListener(new java.awt.event.ActionListener() {
			@Override
			public void actionPerformed(java.awt.event.ActionEvent evt) {
				jTextField8ActionPerformed(evt);
			}
		});

		jLabel14.setText("\u90bb\u5c45\u4fe1\u606f");

		javax.swing.GroupLayout jPanel9Layout = new javax.swing.GroupLayout(
				jPanel9);
		jPanel9.setLayout(jPanel9Layout);
		jPanel9Layout
				.setHorizontalGroup(jPanel9Layout
						.createParallelGroup(
								javax.swing.GroupLayout.Alignment.LEADING)
						.addGroup(
								jPanel9Layout
										.createSequentialGroup()
										.addGap(28, 28, 28)
										.addGroup(
												jPanel9Layout
														.createParallelGroup(
																javax.swing.GroupLayout.Alignment.LEADING)
														.addGroup(
																jPanel9Layout
																		.createSequentialGroup()
																		.addGroup(
																				jPanel9Layout
																						.createParallelGroup(
																								javax.swing.GroupLayout.Alignment.TRAILING)
																						.addComponent(
																								jLabel10)
																						.addComponent(
																								jLabel7)
																						.addComponent(
																								jLabel6)
																						.addComponent(
																								jLabel9)
																						.addComponent(
																								jLabel11)
																						.addComponent(
																								jLabel8))
																		.addPreferredGap(
																				javax.swing.LayoutStyle.ComponentPlacement.RELATED)
																		.addGroup(
																				jPanel9Layout
																						.createParallelGroup(
																								javax.swing.GroupLayout.Alignment.LEADING)
																						.addGroup(
																								jPanel9Layout
																										.createSequentialGroup()
																										.addGap(
																												43,
																												43,
																												43)
																										.addGroup(
																												jPanel9Layout
																														.createParallelGroup(
																																javax.swing.GroupLayout.Alignment.LEADING)
																														.addComponent(
																																jRadioButton2)
																														.addComponent(
																																jRadioButton1)
																														.addComponent(
																																jCheckBox1)
																														.addGroup(
																																jPanel9Layout
																																		.createParallelGroup(
																																				javax.swing.GroupLayout.Alignment.TRAILING,
																																				false)
																																		.addComponent(
																																				jTextField7,
																																				javax.swing.GroupLayout.Alignment.LEADING)
																																		.addComponent(
																																				jTextField5,
																																				javax.swing.GroupLayout.Alignment.LEADING,
																																				javax.swing.GroupLayout.DEFAULT_SIZE,
																																				337,
																																				Short.MAX_VALUE)
																																		.addComponent(
																																				jTextField6,
																																				javax.swing.GroupLayout.Alignment.LEADING)
																																		.addComponent(
																																				jTextField8,
																																				javax.swing.GroupLayout.Alignment.LEADING,
																																				javax.swing.GroupLayout.DEFAULT_SIZE,
																																				337,
																																				Short.MAX_VALUE))))
																						.addGroup(
																								jPanel9Layout
																										.createSequentialGroup()
																										.addGap(
																												171,
																												171,
																												171)
																										.addComponent(
																												jTextField4,
																												javax.swing.GroupLayout.PREFERRED_SIZE,
																												95,
																												javax.swing.GroupLayout.PREFERRED_SIZE))))
														.addComponent(jLabel14))
										.addGap(473, 473, 473)));
		jPanel9Layout
				.setVerticalGroup(jPanel9Layout
						.createParallelGroup(
								javax.swing.GroupLayout.Alignment.LEADING)
						.addGroup(
								jPanel9Layout
										.createSequentialGroup()
										.addContainerGap()
										.addComponent(jLabel14)
										.addGap(6, 6, 6)
										.addGroup(
												jPanel9Layout
														.createParallelGroup(
																javax.swing.GroupLayout.Alignment.BASELINE)
														.addComponent(
																jRadioButton1)
														.addComponent(jLabel6))
										.addPreferredGap(
												javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
										.addGroup(
												jPanel9Layout
														.createParallelGroup(
																javax.swing.GroupLayout.Alignment.BASELINE)
														.addComponent(
																jTextField4,
																javax.swing.GroupLayout.PREFERRED_SIZE,
																javax.swing.GroupLayout.DEFAULT_SIZE,
																javax.swing.GroupLayout.PREFERRED_SIZE)
														.addComponent(
																jRadioButton2))
										.addPreferredGap(
												javax.swing.LayoutStyle.ComponentPlacement.RELATED)
										.addGroup(
												jPanel9Layout
														.createParallelGroup(
																javax.swing.GroupLayout.Alignment.LEADING)
														.addComponent(jLabel7)
														.addComponent(
																jTextField5,
																javax.swing.GroupLayout.PREFERRED_SIZE,
																javax.swing.GroupLayout.DEFAULT_SIZE,
																javax.swing.GroupLayout.PREFERRED_SIZE))
										.addPreferredGap(
												javax.swing.LayoutStyle.ComponentPlacement.RELATED)
										.addGroup(
												jPanel9Layout
														.createParallelGroup(
																javax.swing.GroupLayout.Alignment.LEADING)
														.addComponent(
																jTextField6,
																javax.swing.GroupLayout.PREFERRED_SIZE,
																javax.swing.GroupLayout.DEFAULT_SIZE,
																javax.swing.GroupLayout.PREFERRED_SIZE)
														.addComponent(jLabel8))
										.addPreferredGap(
												javax.swing.LayoutStyle.ComponentPlacement.RELATED)
										.addGroup(
												jPanel9Layout
														.createParallelGroup(
																javax.swing.GroupLayout.Alignment.BASELINE)
														.addComponent(jLabel9)
														.addComponent(
																jTextField7,
																javax.swing.GroupLayout.PREFERRED_SIZE,
																javax.swing.GroupLayout.DEFAULT_SIZE,
																javax.swing.GroupLayout.PREFERRED_SIZE))
										.addPreferredGap(
												javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
										.addGroup(
												jPanel9Layout
														.createParallelGroup(
																javax.swing.GroupLayout.Alignment.BASELINE)
														.addComponent(
																jTextField8,
																javax.swing.GroupLayout.PREFERRED_SIZE,
																javax.swing.GroupLayout.DEFAULT_SIZE,
																javax.swing.GroupLayout.PREFERRED_SIZE)
														.addComponent(jLabel10))
										.addGap(9, 9, 9)
										.addGroup(
												jPanel9Layout
														.createParallelGroup(
																javax.swing.GroupLayout.Alignment.LEADING)
														.addComponent(jLabel11)
														.addComponent(
																jCheckBox1))
										.addGap(17, 17, 17)));

		javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(
				jPanel2);
		jPanel2.setLayout(jPanel2Layout);
		jPanel2Layout.setHorizontalGroup(jPanel2Layout.createParallelGroup(
				javax.swing.GroupLayout.Alignment.LEADING).addGroup(
				jPanel2Layout.createSequentialGroup().addContainerGap()
						.addComponent(jPanel9,
								javax.swing.GroupLayout.DEFAULT_SIZE, 975,
								Short.MAX_VALUE).addContainerGap()));
		jPanel2Layout.setVerticalGroup(jPanel2Layout.createParallelGroup(
				javax.swing.GroupLayout.Alignment.LEADING).addGroup(
				jPanel2Layout.createSequentialGroup().addContainerGap()
						.addComponent(jPanel9,
								javax.swing.GroupLayout.DEFAULT_SIZE, 235,
								Short.MAX_VALUE).addContainerGap()));

		jTabbedPane1.addTab("NNI\u4fe1\u606f", jPanel2);

		javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(
				jPanel3);
		jPanel3.setLayout(jPanel3Layout);
		jPanel3Layout.setHorizontalGroup(jPanel3Layout.createParallelGroup(
				javax.swing.GroupLayout.Alignment.LEADING).addGap(0, 995,
				Short.MAX_VALUE));
		jPanel3Layout.setVerticalGroup(jPanel3Layout.createParallelGroup(
				javax.swing.GroupLayout.Alignment.LEADING).addGap(0, 255,
				Short.MAX_VALUE));

		jTabbedPane1.addTab("UNI\u89d2\u8272\u4fe1\u606f", jPanel3);

		javax.swing.GroupLayout jPanel6Layout = new javax.swing.GroupLayout(
				jPanel6);
		jPanel6.setLayout(jPanel6Layout);
		jPanel6Layout.setHorizontalGroup(jPanel6Layout.createParallelGroup(
				javax.swing.GroupLayout.Alignment.LEADING).addGap(0, 995,
				Short.MAX_VALUE));
		jPanel6Layout.setVerticalGroup(jPanel6Layout.createParallelGroup(
				javax.swing.GroupLayout.Alignment.LEADING).addGap(0, 255,
				Short.MAX_VALUE));

		jTabbedPane1.addTab("QoS", jPanel6);

		javax.swing.GroupLayout jPanel7Layout = new javax.swing.GroupLayout(
				jPanel7);
		jPanel7.setLayout(jPanel7Layout);
		jPanel7Layout.setHorizontalGroup(jPanel7Layout.createParallelGroup(
				javax.swing.GroupLayout.Alignment.LEADING).addGap(0, 995,
				Short.MAX_VALUE));
		jPanel7Layout.setVerticalGroup(jPanel7Layout.createParallelGroup(
				javax.swing.GroupLayout.Alignment.LEADING).addGap(0, 255,
				Short.MAX_VALUE));

		jTabbedPane1.addTab("Exp\u4e1a\u52a1\u6620\u5c04", jPanel7);

		jLabel12.setText("\u540d\u79f0");

		jLabel13.setText("\u961f\u5217\u8c03\u5ea6\u6a21\u5f0f");

		jComboBox1.setModel(new javax.swing.DefaultComboBoxModel(
				new String[] { "SP+DWRR" }));
		jComboBox1.addActionListener(new java.awt.event.ActionListener() {
			@Override
			public void actionPerformed(java.awt.event.ActionEvent evt) {
				jComboBox1ActionPerformed(evt);
			}
		});

		jTable2
				.setModel(new javax.swing.table.DefaultTableModel(
						new Object[][] { { "1", "BE", "0", "16", "100", "64" },
								{ "2", "AF1", "0", "16", "96", "128" },
								{ "3", "AF2", "0", "16", "96", "64" },
								{ "4", "AF3", "0", "16", "96", "64" },
								{ "5", "AF4", "0", "16", "96", "64" },
								{ "6", "EF", "0", "16", "96", "64" },
								{ "7", "CS6", "0", "16", "96", "64" },
								{ "8", "CS7", "0", "16", "96", "64" } },
						new String[] { "序号", "COS", "CIR(kbps)", "调度权重",
								"绿色报文丢弃", "黄色报文丢弃" }));
		jScrollPane3.setViewportView(jTable2);

		javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(
				jPanel1);
		jPanel1.setLayout(jPanel1Layout);
		jPanel1Layout.setHorizontalGroup(jPanel1Layout.createParallelGroup(
				javax.swing.GroupLayout.Alignment.LEADING).addGroup(
				jPanel1Layout.createSequentialGroup().addGap(30, 30, 30)
						.addComponent(jLabel12).addGap(80, 80, 80)
						.addComponent(jTextField9,
								javax.swing.GroupLayout.PREFERRED_SIZE, 184,
								javax.swing.GroupLayout.PREFERRED_SIZE).addGap(
								49, 49, 49).addComponent(jLabel13).addGap(91,
								91, 91).addComponent(jComboBox1,
								javax.swing.GroupLayout.PREFERRED_SIZE, 199,
								javax.swing.GroupLayout.PREFERRED_SIZE)
						.addContainerGap(266, Short.MAX_VALUE)).addComponent(
				jScrollPane3, javax.swing.GroupLayout.DEFAULT_SIZE, 995,
				Short.MAX_VALUE));
		jPanel1Layout
				.setVerticalGroup(jPanel1Layout
						.createParallelGroup(
								javax.swing.GroupLayout.Alignment.LEADING)
						.addGroup(
								jPanel1Layout
										.createSequentialGroup()
										.addContainerGap()
										.addGroup(
												jPanel1Layout
														.createParallelGroup(
																javax.swing.GroupLayout.Alignment.BASELINE)
														.addComponent(jLabel12)
														.addComponent(jLabel13)
														.addComponent(
																jTextField9,
																javax.swing.GroupLayout.PREFERRED_SIZE,
																javax.swing.GroupLayout.DEFAULT_SIZE,
																javax.swing.GroupLayout.PREFERRED_SIZE)
														.addComponent(
																jComboBox1,
																javax.swing.GroupLayout.PREFERRED_SIZE,
																javax.swing.GroupLayout.DEFAULT_SIZE,
																javax.swing.GroupLayout.PREFERRED_SIZE))
										.addGap(32, 32, 32)
										.addComponent(
												jScrollPane3,
												javax.swing.GroupLayout.DEFAULT_SIZE,
												192, Short.MAX_VALUE)));

		jTabbedPane1.addTab("QoS\u961f\u5217\u914d\u7f6e", jPanel1);

		javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
		this.setLayout(layout);
		layout.setHorizontalGroup(layout.createParallelGroup(
				javax.swing.GroupLayout.Alignment.LEADING).addComponent(
				jTabbedPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 1000,
				Short.MAX_VALUE).addComponent(jPanel4,
				javax.swing.GroupLayout.DEFAULT_SIZE,
				javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE));
		layout.setVerticalGroup(layout.createParallelGroup(
				javax.swing.GroupLayout.Alignment.LEADING).addGroup(
				javax.swing.GroupLayout.Alignment.TRAILING,
				layout.createSequentialGroup().addComponent(jPanel4,
						javax.swing.GroupLayout.DEFAULT_SIZE,
						javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
						.addGap(18, 18, 18).addComponent(jTabbedPane1,
								javax.swing.GroupLayout.PREFERRED_SIZE, 284,
								javax.swing.GroupLayout.PREFERRED_SIZE)));
	}// </editor-fold>
	//GEN-END:initComponents

	private void jComboBox1ActionPerformed(java.awt.event.ActionEvent evt) {

	}

	private void jTextField1ActionPerformed(java.awt.event.ActionEvent evt) {
	}

	private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {
	}

	private void jTextField8ActionPerformed(java.awt.event.ActionEvent evt) {
	}

	private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {
		//new AddACDialog(AcPanel, true).setVisible(true);
//		AddACDialog_old addACDialog = new AddACDialog_old(this, true);
		/*addACDialog.setLocation(UiUtil.getWindowWidth(addACDialog.getWidth()),
				UiUtil.getWindowHeight(addACDialog.getHeight()));
		addACDialog.setVisible(true);*/
	}

	private void jCheckBox1ActionPerformed(java.awt.event.ActionEvent evt) {
	}

	//GEN-BEGIN:variables
	// Variables declaration - do not modify
	private javax.swing.JButton jButton1;
	private javax.swing.JButton jButton2;
	private javax.swing.JCheckBox jCheckBox1;
	private javax.swing.JComboBox jComboBox1;
	private javax.swing.JLabel jLabel1;
	private javax.swing.JLabel jLabel10;
	private javax.swing.JLabel jLabel11;
	private javax.swing.JLabel jLabel12;
	private javax.swing.JLabel jLabel13;
	private javax.swing.JLabel jLabel14;
	private javax.swing.JLabel jLabel2;
	private javax.swing.JLabel jLabel3;
	private javax.swing.JLabel jLabel4;
	private javax.swing.JLabel jLabel5;
	private javax.swing.JLabel jLabel6;
	private javax.swing.JLabel jLabel7;
	private javax.swing.JLabel jLabel8;
	private javax.swing.JLabel jLabel9;
	private javax.swing.JPanel jPanel1;
	private javax.swing.JPanel jPanel2;
	private javax.swing.JPanel jPanel3;
	private javax.swing.JPanel jPanel4;
	private javax.swing.JPanel jPanel5;
	private javax.swing.JPanel jPanel6;
	private javax.swing.JPanel jPanel7;
	private javax.swing.JPanel jPanel8;
	private javax.swing.JPanel jPanel9;
	private javax.swing.JRadioButton jRadioButton1;
	private javax.swing.JRadioButton jRadioButton2;
	private javax.swing.JScrollPane jScrollPane1;
	private javax.swing.JScrollPane jScrollPane2;
	private javax.swing.JScrollPane jScrollPane3;
	private javax.swing.JTabbedPane jTabbedPane1;
	private javax.swing.JTable jTable1;
	private javax.swing.JTable jTable2;
	private javax.swing.JTextArea jTextArea1;
	private javax.swing.JTextField jTextField1;
	private javax.swing.JTextField jTextField2;
	private javax.swing.JTextField jTextField3;
	private javax.swing.JTextField jTextField4;
	private javax.swing.JTextField jTextField5;
	private javax.swing.JTextField jTextField6;
	private javax.swing.JTextField jTextField7;
	private javax.swing.JTextField jTextField8;
	private javax.swing.JTextField jTextField9;
	// End of variables declaration//GEN-END:variables

}