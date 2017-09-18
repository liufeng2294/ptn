package com.nms.ui.ptn.oam.Node.view;

import java.awt.Color;
import java.awt.FlowLayout;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

import javax.swing.DefaultComboBoxModel;
import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

import com.nms.db.bean.equipment.port.PortInst;
import com.nms.db.bean.ptn.oam.OamInfo;
import com.nms.db.bean.ptn.oam.OamMepInfo;
import com.nms.db.enums.EOperationLogType;
import com.nms.db.enums.OamTypeEnum;
import com.nms.drive.service.impl.CoderUtils;
import com.nms.model.equipment.port.PortService_MB;
import com.nms.model.ptn.oam.OamInfoService_MB;
import com.nms.model.util.Services;
import com.nms.rmi.ui.util.RmiKeys;
import com.nms.ui.manager.AddOperateLog;
import com.nms.ui.manager.ConstantUtil;
import com.nms.ui.manager.ControlKeyValue;
import com.nms.ui.manager.DialogBoxUtil;
import com.nms.ui.manager.DispatchUtil;
import com.nms.ui.manager.ExceptionManage;
import com.nms.ui.manager.MyActionListener;
import com.nms.ui.manager.ResourceUtil;
import com.nms.ui.manager.UiUtil;
import com.nms.ui.manager.control.PtnButton;
import com.nms.ui.manager.control.PtnDialog;
import com.nms.ui.manager.keys.StringKeysBtn;
import com.nms.ui.manager.keys.StringKeysLbl;
import com.nms.ui.manager.keys.StringKeysObj;
import com.nms.ui.manager.keys.StringKeysTip;
import com.nms.ui.ptn.oam.Node.controller.SectionOamNodeController;

public class SectionOamNodeDialog extends PtnDialog {
	private SectionOamNodeController controller;
	private static final long serialVersionUID = 1L;
	private JLabel portLabel;
	private JComboBox portCombox;//端口
//	private JLabel megIccLabel;
//	private JTextField megIccField;//meg icc
//	private JLabel megUmcLabel;
//	private JTextField megUmcField;// meg umc
	private JLabel localLabel;
	private JTextField localField;//本端维护点ID
	private JLabel remoteLabel;
	private JTextField remoteField;//远端维护点ID
	// private JLabel lpOutTimeLabel;// 连通性测试
	// private JTextField lpOutTimeField;
	private JLabel megGradeLabel;
	private JTextField megGradeField;//meg等级
	private JLabel cycleEnableLabel;
	private JCheckBox cyclyeEnableCheckBox;//环回帧发送使能
	private JLabel cyclePeriodLabel;
	private JComboBox cyclePeriodComboBox;//环回帧测试周期
	private JLabel cycleTestWayLabel;
	private JComboBox cycleTestWayCombox;//环回测试方式
	private JLabel offLineTestTLVLabel;
	private JComboBox offLineTestTLVCombox;//离线测试TLV
	private JLabel cycleTlvLengthLabel;
	private JTextField cycleTlvLengthField;//TLV长度
	private JLabel cycleTLVInfo;
	private JTextField cycleTLVField;//TLV测试内容

	private JLabel tstEnableLabel;
	private JCheckBox tstEnableCheckBox;//TST发送使能
	private JLabel tstPeriodLabel;
	private JComboBox tstPeriodComboBox;//TST帧发送周期
	private JLabel tlvTypeLabel;
	private JComboBox tlvTypeComboBox;//TLV类型
	private JLabel tstTLCLengthLabel;
	private JTextField tstTLVLengthField;//TLV长度
	private JLabel lckLabel;
	private JCheckBox lckCheckBox;//是否锁定
	private JLabel lmEnableLabel;
	private JCheckBox lmCheckBox;//LM发送使能
	private JLabel lmCycleLabel;
	private JComboBox lmCycleComboBox;//LM发送周期
	private JLabel dmEnableLabel;
	private JCheckBox dmCheckBox;//DM发送使能
	private JLabel dmCycleLabel;
	private JComboBox dmCycleComboBox;//DM发送周期
	private JComboBox tcComboBox;//TC
	private JLabel lbTTlLabel;//lbTTL 
	private JTextField lbTTLField;//lb生命周期
	
	private JPanel componentPanel;

	private JPanel buttonPanel;
	private PtnButton confirm;
	private JButton cancel;

	private JLabel vertifyLabel;//提示信息

	private OamInfo oamInfo;
	private JLabel tcLabel;
	private OamMepInfo oammepInfoBefore;//记录修改前的数据，便于日志记录
	
	public SectionOamNodeDialog(OamInfo oamInfo, String str) {
		setModal(true);
		initComponent();
		setComponentLayout();
		intalCombox();
		addListener();
		controller = new SectionOamNodeController(this);
		this.setTitle(str);
		if (oamInfo != null) {
			this.oamInfo = oamInfo;
			oammepInfoBefore = new OamMepInfo();
			CoderUtils.copy(this.oamInfo.getOamMep(), oammepInfoBefore);
			try {
				//给界面赋值
				setValue();
			} catch (Exception e) {
				ExceptionManage.dispose(e,this.getClass());
			}
		} else {
			try {
				//端口名称赋值
				initPortCombox();
				//初始化赋值
				initValue();
			} catch (Exception e) {
				ExceptionManage.dispose(e,this.getClass());
			}
		}

	}

	private void initPortCombox() {
		portCombox.removeAllItems();
		OamInfoService_MB oamInfoService = null;
		List<OamInfo> oamList = null;
		List<OamInfo> oamList_temp = null;
		OamInfo oamInfo = null;
		List<PortInst> portInstList = null;
		PortService_MB portService = null;
		PortInst portInst = null;
		OamMepInfo oamMepInfo = null;
		try {
			portService = (PortService_MB) ConstantUtil.serviceFactory.newService_MB(Services.PORT);
			oamInfoService = (OamInfoService_MB) ConstantUtil.serviceFactory.newService_MB(Services.OamInfo);
			oamInfo = new OamInfo();
			oamMepInfo = new OamMepInfo();
			oamMepInfo.setSiteId(ConstantUtil.siteId);
			oamMepInfo.setObjType("SECTION_TEST");
			oamInfo.setOamMep(oamMepInfo);
			oamList = oamInfoService.queryBySiteId(oamInfo, OamTypeEnum.AMEP);
			oamInfo.getOamMep().setObjType("SECTION");
			oamList_temp = oamInfoService.queryBySiteId(oamInfo, OamTypeEnum.AMEP);
			portInst = new PortInst();
			portInst.setPortType("NNI");
			portInst.setSiteId(ConstantUtil.siteId);
			portInstList = portService.select(portInst);
			boolean b = false;
			DefaultComboBoxModel boxModel = (DefaultComboBoxModel) portCombox.getModel();
			for (PortInst inst : portInstList) {
				for (OamInfo info : oamList) {
					if (info.getOamMep().getObjId() == inst.getPortId()) {
						b = true;
					}
				}
				if (!b) {
					for (OamInfo info_temp : oamList_temp) {
						//如果此条段上没有主动OAM,就不允许配按需OAM,就把这条段过滤掉
						if (info_temp.getOamMep().getObjId() == inst.getPortId()) {
							//把主动OAM的MEG等级,本端维护点Id,远端维护点Id赋给按需OAM对应的属性
//							this.megGradeField.setText(info_temp.getOamMep().getMel()+"");
							this.localField.setText(info_temp.getOamMep().getLocalMepId()+"");
							this.remoteField.setText(info_temp.getOamMep().getRemoteMepId()+"");
							boxModel.addElement(new ControlKeyValue(inst.getPortId() + "", inst.getPortName(), inst));
						}
					}
				}
				b = false;
			}
		} catch (Exception e) {
			ExceptionManage.dispose(e,this.getClass());
		} finally {
			UiUtil.closeService_MB(oamInfoService);
			oamList = null;
			oamList_temp = null;
			oamInfo = null;
			portInstList = null;
			UiUtil.closeService_MB(portService);
			portInst = null;
		}
		
	}

	private void initValue() {
		if(megGradeField.getText() == null || megGradeField.getText().equals("")){
			megGradeField.setText("7");
		}
//		megIccField.setText("123456");
//		megUmcField.setText("789ABC");
		localField.setText("1");
		remoteField.setText("1");
		comboBoxSelect(tcComboBox, "7");
//		cyclyeEnableCheckBox.setSelected(false);
		comboBoxSelect(cyclePeriodComboBox, "1");
		comboBoxSelect(cycleTestWayCombox,  "0");
		comboBoxSelect(offLineTestTLVCombox, "11");
		cycleTlvLengthField.setText("1");
		cycleTLVField.setText("0");

		cyclePeriodComboBox.setEnabled(false);
		cycleTestWayCombox.setEnabled(false);
		offLineTestTLVCombox.setEnabled(false);
//		cycleTlvLengthField.setEnabled(true);
//		cycleTLVField.setEnabled(true);
		
//		tstEnableCheckBox.setSelected(false);
		comboBoxSelect(tstPeriodComboBox, "1");
		comboBoxSelect(tlvTypeComboBox, "11");
		tstTLVLengthField.setText("29");

		tstPeriodComboBox.setEnabled(false);
		tlvTypeComboBox.setEnabled(false);
		tstTLVLengthField.setEnabled(false);
		
//		lmCheckBox.setSelected(false);
		comboBoxSelect(lmCycleComboBox, "0");
		lmCycleComboBox.setEnabled(false);
//		dmCheckBox.setSelected(false);
		comboBoxSelect(dmCycleComboBox, "0");
		dmCycleComboBox.setEnabled(false);
		lbTTLField.setText("64");
	}

	private void initComponent() {
		vertifyLabel = new JLabel();
		vertifyLabel.setForeground(Color.red);

		componentPanel = new JPanel();
		portLabel = new JLabel(ResourceUtil.srcStr(StringKeysLbl.LBL_PORT));
		portCombox = new JComboBox();
//		megIccLabel = new JLabel(ResourceUtil.srcStr(StringKeysLbl.LBL_OAM_MEG_ICC));
//		megIccField = new JTextField();
//		megIccField.setEditable(false);
//		megUmcLabel = new JLabel(ResourceUtil.srcStr(StringKeysLbl.LBL_OAM_MEG_UMC));
//		megUmcField = new JTextField();
//		megUmcField.setEditable(false);
		localLabel = new JLabel(ResourceUtil.srcStr(StringKeysLbl.LBL_OAM_LOCAL_POINT_ID));
		localField = new JTextField();
		remoteLabel = new JLabel(ResourceUtil.srcStr(StringKeysLbl.LBL_OAM_FAR_POINT_ID));
		remoteField = new JTextField();
		// lpOutTimeLabel = new JLabel("环回超时时间(50ms)");
		// lpOutTimeField = new JTextField();
		megGradeLabel = new JLabel(ResourceUtil.srcStr(StringKeysLbl.LBL_OAM_MEG_LEVLE));
		megGradeField = new JTextField();
		cycleEnableLabel = new JLabel(ResourceUtil.srcStr(StringKeysLbl.LBL_OAM_LOOP_FRAME_SEND_ENABLED));
		cyclyeEnableCheckBox = new JCheckBox();
		cyclePeriodLabel = new JLabel(ResourceUtil.srcStr(StringKeysLbl.LBL_OAM_LOOP_FRAME_TEST_PERIOD));
		cyclePeriodComboBox = new JComboBox();
		cycleTestWayLabel = new JLabel(ResourceUtil.srcStr(StringKeysLbl.LBL_OAM_LOOP_TEST_TYPE));
		cycleTestWayCombox = new JComboBox();
		offLineTestTLVLabel = new JLabel(ResourceUtil.srcStr(StringKeysLbl.LBL_OAM_OUTLINE_TEST_TLV));
		offLineTestTLVCombox = new JComboBox();
		cycleTlvLengthLabel = new JLabel(ResourceUtil.srcStr(StringKeysLbl.LBL_OAM_TLV_LENGTH));
		cycleTlvLengthField = new JTextField();
		cycleTLVInfo = new JLabel(ResourceUtil.srcStr(StringKeysLbl.LBL_OAM_TLV_TEST_CONTENT));
		cycleTLVField = new JTextField();

		tstEnableLabel = new JLabel(ResourceUtil.srcStr(StringKeysLbl.LBL_OAM_TST_SEND_ENABLED));
		tstEnableCheckBox = new JCheckBox();
		tstPeriodLabel = new JLabel(ResourceUtil.srcStr(StringKeysLbl.LBL_OAM_TST_FRAME_SEND_PERIOD));
		tstPeriodComboBox = new JComboBox();
		tlvTypeLabel = new JLabel(ResourceUtil.srcStr(StringKeysLbl.LBL_OAM_TLV_TYPE));
		tlvTypeComboBox = new JComboBox();
		tstTLCLengthLabel = new JLabel(ResourceUtil.srcStr(StringKeysLbl.LBL_OAM_TLV_LENGTH));
		tstTLVLengthField = new JTextField();
		lckLabel = new JLabel(ResourceUtil.srcStr(StringKeysLbl.LBL_OAM_LOCK_YESORNO));
		lckCheckBox = new JCheckBox();

		lmEnableLabel = new JLabel(ResourceUtil.srcStr(StringKeysLbl.LBL_OAM_LM_SEND_ENABLED));
		lmCheckBox = new JCheckBox();
		lmCycleLabel = new JLabel(ResourceUtil.srcStr(StringKeysLbl.LBL_OAM_LM_SEND_PERIOD));
		lmCycleComboBox = new JComboBox();
		dmEnableLabel = new JLabel(ResourceUtil.srcStr(StringKeysLbl.LBL_OAM_DM_SEND_ENABLED));
		dmCheckBox = new JCheckBox();
		dmCycleLabel = new JLabel(ResourceUtil.srcStr(StringKeysLbl.LBL_OAM_DM_SEND_PERIOD));
		dmCycleComboBox = new JComboBox();
		lbTTlLabel = new JLabel(ResourceUtil.srcStr(StringKeysLbl.LBL_LBTTL));
		lbTTLField = new JTextField();
		
		tcLabel = new JLabel("TC");
		tcComboBox = new JComboBox();
		
		buttonPanel = new JPanel();
		confirm = new PtnButton(ResourceUtil.srcStr(StringKeysBtn.BTN_CONFIRM),true);
		cancel = new JButton(ResourceUtil.srcStr(StringKeysBtn.BTN_CANEL));

//		try {
//			oamInfoService = (OamInfoService) ConstantUtil.serviceFactory
//					.newService(Services.OamInfo);
//			String megId = oamInfoService.generateMegId();
//			megIccField.setText(megId.substring(0, megId.toString()
//					.indexOf("*")));
//			megUmcField.setText(megId.substring(megId.lastIndexOf("*") + 1,
//					megId.length()));
//		} catch (Exception e) {
//			ExceptionManage.dispose(e,this.getClass());
//		}

//		megIccField.setEditable(false);
//		megUmcField.setEditable(false);
//		if (cyclyeEnableCheckBox.isSelected()) {
//			cyclePeriodComboBox.setEnabled(true);
//			cycleTestWayCombox.setEnabled(true);
//			offLineTestTLVCombox.setEnabled(true);
//			cycleTlvLengthField.setEnabled(true);
//			cycleTLVField.setEnabled(true);
//
//		} else {
//			cyclePeriodComboBox.setEnabled(false);
//			cycleTestWayCombox.setEnabled(false);
//			offLineTestTLVCombox.setEnabled(false);
//			cycleTlvLengthField.setEnabled(false);
//			cycleTLVField.setEnabled(false);
//		}
//		if (tstEnableCheckBox.isSelected()) {
//			tstPeriodComboBox.setEnabled(true);
//			tlvTypeComboBox.setEnabled(true);
//			tstTLVLengthField.setEnabled(true);
//		} else {
//			tstPeriodComboBox.setEnabled(false);
//			tlvTypeComboBox.setEnabled(false);
//			tstTLVLengthField.setEnabled(false);
//		}

	}

	private void setComponentLayout() {
		setOamInfoLayout();
		setButtonLayout();
		GridBagLayout layout = new GridBagLayout();
		layout.rowHeights = new int[] { 180, 20 };
		layout.rowWeights = new double[] { 1.0, 0.0 };
		this.setLayout(layout);
		GridBagConstraints c = new GridBagConstraints();
		c.fill = GridBagConstraints.BOTH;
		c.gridx = 0;
		c.gridy = 0;
		c.gridheight = 1;
		c.gridwidth = 1;
		c.insets = new Insets(0, 0, 0, 0);
		layout.setConstraints(componentPanel, c);
		this.add(componentPanel);
		c.gridy = 1;
		c.fill = GridBagConstraints.EAST;
		c.anchor = GridBagConstraints.EAST;
		layout.setConstraints(buttonPanel, c);
		this.add(buttonPanel);
	}

	private void setOamInfoLayout() {
		GridBagLayout componentLayout = new GridBagLayout();
		componentLayout.columnWidths = new int[] { 60, 100, 60, 100 };
		componentLayout.columnWeights = new double[] { 1.0, 1.0 };
		componentLayout.rowHeights = new int[] { 10, 10, 10, 10, 10, 10, 10,
				10, 10, 10, 10};
		componentLayout.rowWeights = new double[] { 0.0, 0.0, 0.0, 0.0, 0.0,
				0.0, 0.0, 0.0, 0.0, 0.0,  };
		componentPanel.setLayout(componentLayout);
		GridBagConstraints c = new GridBagConstraints();
		c.fill = GridBagConstraints.BOTH;
		c.gridx = 0;
		c.gridy = 0;
		c.gridheight = 1;
		c.gridwidth = 1;
		c.insets = new Insets(5, 5, 5, 5);
		componentLayout.setConstraints(portLabel, c);
		componentPanel.add(portLabel);
		c.gridx = 1;
		c.gridy = 0;
		c.gridheight = 1;
		c.gridwidth = 1;
		c.insets = new Insets(5, 5, 5, 5);
		componentLayout.setConstraints(portCombox, c);
		componentPanel.add(portCombox);
		c.fill = GridBagConstraints.BOTH;

		c.gridx = 2;
		c.gridy = 0;
		c.gridheight = 1;
		c.gridwidth = 1;
		c.insets = new Insets(5, 30, 5, 5);
		componentLayout.setConstraints(megGradeLabel, c);
		componentPanel.add(megGradeLabel);
		c.gridx = 3;
		c.gridy = 0;
		c.gridheight = 1;
		c.gridwidth = 1;
		c.insets = new Insets(5, 5, 5, 5);
		componentLayout.setConstraints(megGradeField, c);
		componentPanel.add(megGradeField);

//		c.gridx = 0;
//		c.gridy = 1;
//		c.gridheight = 1;
//		c.gridwidth = 1;
//		c.insets = new Insets(5, 5, 5, 5);
//		componentLayout.setConstraints(megIccLabel, c);
//		componentPanel.add(megIccLabel);
//		c.gridx = 1;
//		c.gridy = 1;
//		c.gridheight = 1;
//		c.gridwidth = 1;
//		c.insets = new Insets(5, 5, 5, 5);
//		componentLayout.setConstraints(megIccField, c);
//		componentPanel.add(megIccField);
//
//		c.gridx = 2;
//		c.gridy = 1;
//		c.gridheight = 1;
//		c.gridwidth = 1;
//		c.insets = new Insets(5, 30, 5, 5);
//		componentLayout.setConstraints(megUmcLabel, c);
//		componentPanel.add(megUmcLabel);
//		c.gridx = 3;
//		c.gridy = 1;
//		c.gridheight = 1;
//		c.gridwidth = 1;
//		c.insets = new Insets(5, 5, 5, 5);
//		componentLayout.setConstraints(megUmcField, c);
//		componentPanel.add(megUmcField);
//
		c.gridx = 0;
		c.gridy = 1;
		c.gridheight = 1;
		c.gridwidth = 1;
		c.insets = new Insets(5, 5, 5, 5);
		componentLayout.setConstraints(localLabel, c);
		componentPanel.add(localLabel);
		c.gridx = 1;
		c.gridy = 1;
		c.gridheight = 1;
		c.gridwidth = 1;
		c.insets = new Insets(5, 5, 5, 5);
		componentLayout.setConstraints(localField, c);
		componentPanel.add(localField);

		c.gridx = 2;
		c.gridy = 1;
		c.gridheight = 1;
		c.gridwidth = 1;
		c.insets = new Insets(5, 30, 5, 5);
		componentLayout.setConstraints(remoteLabel, c);
		componentPanel.add(remoteLabel);
		c.gridx = 3;
		c.gridy = 1;
		c.gridheight = 1;
		c.gridwidth = 1;
		c.insets = new Insets(5, 5, 5, 5);
		componentLayout.setConstraints(remoteField, c);
		componentPanel.add(remoteField);

		c.gridx = 0;
		c.gridy = 2;
		c.gridheight = 1;
		c.gridwidth = 1;
		c.insets = new Insets(5, 5, 5, 5);
		componentLayout.setConstraints(cycleEnableLabel, c);
		componentPanel.add(cycleEnableLabel);
		c.gridx = 1;
		c.gridy = 2;
		c.gridheight = 1;
		c.gridwidth = 1;
		c.insets = new Insets(5, 5, 5, 5);
		componentLayout.setConstraints(cyclyeEnableCheckBox, c);
		componentPanel.add(cyclyeEnableCheckBox);

		c.gridx = 2;
		c.gridy = 2;
		c.gridheight = 1;
		c.gridwidth = 1;
		c.insets = new Insets(5, 30, 5, 5);
		componentLayout.setConstraints(cyclePeriodLabel, c);
		componentPanel.add(cyclePeriodLabel);
		c.gridx = 3;
		c.gridy = 2;
		c.gridheight = 1;
		c.gridwidth = 1;
		c.insets = new Insets(5, 5, 5, 5);
		componentLayout.setConstraints(cyclePeriodComboBox, c);
		componentPanel.add(cyclePeriodComboBox);

		c.gridx = 0;
		c.gridy = 3;
		c.gridheight = 1;
		c.gridwidth = 1;
		c.insets = new Insets(5, 5, 5, 5);
		componentLayout.setConstraints(cycleTestWayLabel, c);
		componentPanel.add(cycleTestWayLabel);
		c.gridx = 1;
		c.gridy = 3;
		c.gridheight = 1;
		c.gridwidth = 1;
		c.insets = new Insets(5, 5, 5, 5);
		componentLayout.setConstraints(cycleTestWayCombox, c);
		componentPanel.add(cycleTestWayCombox);

		c.gridx = 2;
		c.gridy = 3;
		c.gridheight = 1;
		c.gridwidth = 1;
		c.insets = new Insets(5, 30, 5, 5);
		componentLayout.setConstraints(offLineTestTLVLabel, c);
		componentPanel.add(offLineTestTLVLabel);
		c.gridx = 3;
		c.gridy = 3;
		c.gridheight = 1;
		c.gridwidth = 1;
		c.insets = new Insets(5, 5, 5, 5);
		componentLayout.setConstraints(offLineTestTLVCombox, c);
		componentPanel.add(offLineTestTLVCombox);

		c.gridx = 0;
		c.gridy = 4;
		c.gridheight = 1;
		c.gridwidth = 1;
		c.insets = new Insets(5, 5, 5, 5);
		componentLayout.setConstraints(cycleTlvLengthLabel, c);
		componentPanel.add(cycleTlvLengthLabel);
		c.gridx = 1;
		c.gridy = 4;
		c.gridheight = 1;
		c.gridwidth = 1;
		c.insets = new Insets(5, 5, 5, 5);
		componentLayout.setConstraints(cycleTlvLengthField, c);
		componentPanel.add(cycleTlvLengthField);

		c.gridx = 2;
		c.gridy = 4;
		c.gridheight = 1;
		c.gridwidth = 1;
		c.insets = new Insets(5, 30, 5, 5);
		componentLayout.setConstraints(cycleTLVInfo, c);
		componentPanel.add(cycleTLVInfo);
		c.gridx = 3;
		c.gridy = 4;
		c.gridheight = 1;
		c.gridwidth = 1;
		c.insets = new Insets(5, 5, 5, 5);
		componentLayout.setConstraints(cycleTLVField, c);
		componentPanel.add(cycleTLVField);

		c.gridx = 0;
		c.gridy = 5;
		c.gridheight = 1;
		c.gridwidth = 1;
		c.insets = new Insets(5, 5, 5, 5);
		componentLayout.setConstraints(tstEnableLabel, c);
		componentPanel.add(tstEnableLabel);
		c.gridx = 1;
		c.gridy = 5;
		c.gridheight = 1;
		c.gridwidth = 1;
		c.insets = new Insets(5, 5, 5, 5);
		componentLayout.setConstraints(tstEnableCheckBox, c);
		componentPanel.add(tstEnableCheckBox);

		c.gridx = 2;
		c.gridy = 5;
		c.gridheight = 1;
		c.gridwidth = 1;
		c.insets = new Insets(5, 30, 5, 5);
		componentLayout.setConstraints(tstPeriodLabel, c);
		componentPanel.add(tstPeriodLabel);
		c.gridx = 3;
		c.gridy = 5;
		c.gridheight = 1;
		c.gridwidth = 1;
		c.insets = new Insets(5, 5, 5, 5);
		componentLayout.setConstraints(tstPeriodComboBox, c);
		componentPanel.add(tstPeriodComboBox);

		c.gridx = 0;
		c.gridy = 6;
		c.gridheight = 1;
		c.gridwidth = 1;
		c.insets = new Insets(5, 5, 5, 5);
		componentLayout.setConstraints(tlvTypeLabel, c);
		componentPanel.add(tlvTypeLabel);
		c.gridx = 1;
		c.gridy = 6;
		c.gridheight = 1;
		c.gridwidth = 1;
		c.insets = new Insets(5, 5, 5, 5);
		componentLayout.setConstraints(tlvTypeComboBox, c);
		componentPanel.add(tlvTypeComboBox);

		c.gridx = 2;
		c.gridy = 6;
		c.gridheight = 1;
		c.gridwidth = 1;
		c.insets = new Insets(5, 30, 5, 5);
		componentLayout.setConstraints(tstTLCLengthLabel, c);
		componentPanel.add(tstTLCLengthLabel);
		c.gridx = 3;
		c.gridy = 6;
		c.gridheight = 1;
		c.gridwidth = 1;
		c.insets = new Insets(5, 5, 5, 5);
		componentLayout.setConstraints(tstTLVLengthField, c);
		componentPanel.add(tstTLVLengthField);

		c.gridx = 0;
		c.gridy = 7;
		c.gridheight = 1;
		c.gridwidth = 1;
		c.insets = new Insets(5, 5, 5, 5);
		componentLayout.setConstraints(lmEnableLabel, c);
		componentPanel.add(lmEnableLabel);
		c.gridx = 1;
		c.gridy = 7;
		c.gridheight = 1;
		c.gridwidth = 1;
		c.insets = new Insets(5, 5, 5, 5);
		componentLayout.setConstraints(lmCheckBox, c);
		componentPanel.add(lmCheckBox);

		c.gridx = 2;
		c.gridy = 7;
		c.gridheight = 1;
		c.gridwidth = 1;
		c.insets = new Insets(5, 30, 5, 5);
		componentLayout.setConstraints(lmCycleLabel, c);
		componentPanel.add(lmCycleLabel);
		c.gridx = 3;
		c.gridy = 7;
		c.gridheight = 1;
		c.gridwidth = 1;
		c.insets = new Insets(5, 5, 5, 5);
		componentLayout.setConstraints(lmCycleComboBox, c);
		componentPanel.add(lmCycleComboBox);
		
		c.gridx = 0;
		c.gridy = 8;
		c.gridheight = 1;
		c.gridwidth = 1;
		c.insets = new Insets(5, 5, 5, 5);
		componentLayout.setConstraints(dmEnableLabel, c);
		componentPanel.add(dmEnableLabel);
		c.gridx = 1;
		c.gridy = 8;
		c.gridheight = 1;
		c.gridwidth = 1;
		c.insets = new Insets(5, 5, 5, 5);
		componentLayout.setConstraints(dmCheckBox, c);
		componentPanel.add(dmCheckBox);

		c.gridx = 2;
		c.gridy = 8;
		c.gridheight = 1;
		c.gridwidth = 1;
		c.insets = new Insets(5, 30, 5, 5);
		componentLayout.setConstraints(dmCycleLabel, c);
		componentPanel.add(dmCycleLabel);
		c.gridx = 3;
		c.gridy = 8;
		c.gridheight = 1;
		c.gridwidth = 1;
		c.insets = new Insets(5, 5, 5, 5);
		componentLayout.setConstraints(dmCycleComboBox, c);
		componentPanel.add(dmCycleComboBox);
		
		c.gridx = 0;
		c.gridy = 9;
		c.gridheight = 1;
		c.gridwidth = 1;
		c.insets = new Insets(5, 5, 5, 5);
		componentLayout.setConstraints(lckLabel, c);
		componentPanel.add(lckLabel);
		c.gridx = 1;
		c.gridy = 9;
		c.gridheight = 1;
		c.gridwidth = 1;
		c.insets = new Insets(5, 5, 5, 5);
		componentLayout.setConstraints(lckCheckBox, c);
		componentPanel.add(lckCheckBox);
		
		c.gridx = 2;
		c.gridy = 9;
		c.gridheight = 1;
		c.gridwidth = 1;
		c.insets = new Insets(5, 30, 5, 5);
		componentLayout.setConstraints(tcLabel, c);
		componentPanel.add(tcLabel);
		c.gridx = 3;
		c.gridy = 9;
		c.gridheight = 1;
		c.gridwidth = 1;
		c.insets = new Insets(5, 5, 5, 5);
		componentLayout.setConstraints(tcComboBox, c);
		componentPanel.add(tcComboBox);
		
		c.gridx = 0;
		c.gridy = 10;
		c.gridheight = 1;
		c.gridwidth = 1;
		c.insets = new Insets(5, 5, 5, 5);
		componentLayout.setConstraints(lbTTlLabel, c);
		componentPanel.add(lbTTlLabel);
		c.gridx = 1;
		c.gridy = 10;
		c.gridheight = 1;
		c.gridwidth = 1;
		c.insets = new Insets(5, 5, 5, 5);
		componentLayout.setConstraints(lbTTLField, c);
		componentPanel.add(lbTTLField);

	}

	private void setButtonLayout() {
		FlowLayout flowLayout = new FlowLayout();
		flowLayout.setAlignment(FlowLayout.RIGHT);
		buttonPanel.setLayout(flowLayout);
		buttonPanel.add(vertifyLabel);
		buttonPanel.add(confirm);
		buttonPanel.add(cancel);
	}

	private void addListener() {
		cyclyeEnableCheckBox.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent arg0) {
				if (cyclyeEnableCheckBox.isSelected()) {
					cyclePeriodComboBox.setEnabled(true);
					cycleTestWayCombox.setEnabled(true);
					offLineTestTLVCombox.setEnabled(true);
					cycleTlvLengthField.setEnabled(true);
					cycleTLVField.setEnabled(true);

				} else {
					cyclePeriodComboBox.setEnabled(false);
					cycleTestWayCombox.setEnabled(false);
					offLineTestTLVCombox.setEnabled(false);
					cycleTlvLengthField.setEnabled(false);
					cycleTLVField.setEnabled(false);
				}

			}
		});
		tstEnableCheckBox.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent arg0) {
				if (tstEnableCheckBox.isSelected()) {
					tstPeriodComboBox.setEnabled(true);
					tlvTypeComboBox.setEnabled(true);
					tstTLVLengthField.setEnabled(true);
				} else {
					tstPeriodComboBox.setEnabled(false);
					tlvTypeComboBox.setEnabled(false);
					tstTLVLengthField.setEnabled(false);
				}

			}
		});
		lmCheckBox.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent arg0) {
				if (lmCheckBox.isSelected()) {
					lmCycleComboBox.setEnabled(true);
				} else {
					lmCycleComboBox.setEnabled(false);
				}
			}
		});
		dmCheckBox.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent arg0) {
				if (dmCheckBox.isSelected()) {
					dmCycleComboBox.setEnabled(true);
				} else {
					dmCycleComboBox.setEnabled(false);
				}
			}
		});
		confirm.addActionListener(new MyActionListener() {

			@Override
			public void actionPerformed(ActionEvent arg0) {
				if(portCombox.getSelectedItem() == null){
					tip();
				}else{
					if (megGradeField.getText().length() == 0
//							|| localField.getText().length() == 0
//							|| remoteField.getText().length() == 0
							) {
						vertifyLabel.setText(ResourceUtil.srcStr(StringKeysTip.TIP_FULL_DATA));
						return;
					}
					if ((cyclyeEnableCheckBox.isSelected() == true)
							&& (cycleTlvLengthField.getText().length() == 0|| cycleTLVField.getText().length() == 0)) {
						vertifyLabel.setText(ResourceUtil.srcStr(StringKeysTip.TIP_FULL_DATA));
						return;
					}
					if ((tstEnableCheckBox.isSelected() == true)
							&& (tstTLVLengthField.getText().length() == 0)) {
						vertifyLabel.setText(ResourceUtil.srcStr(StringKeysTip.TIP_FULL_DATA));
						return;
					}
					if(checkData()){
						return;
					}
					try {
						collectData();
						String result = null;
//						List<OamInfo> oamInfoList = new ArrayList<OamInfo>();
//						oamInfoList.add(oamInfo);
						DispatchUtil dispath = new DispatchUtil(RmiKeys.RMI_TMSOAMCONFIG);
						int operationValue = 0;
						if(oamInfo.getOamMep().getId() > 0){
							result = dispath.excuteUpdate(oamInfo);
							operationValue = EOperationLogType.SEGMENTOAMTESTSUP.getValue();
							oammepInfoBefore.setObjNameLog(oamInfo.getOamMep().getObjNameLog());
							oammepInfoBefore.setLmCycle(oammepInfoBefore.getLmCycle()==0?100:11);
							oammepInfoBefore.setDmCycle(oammepInfoBefore.getDmCycle()==0?100:11);
							oammepInfoBefore.setOffLineTestTLV(oammepInfoBefore.getOffLineTestTLV()==1?0:1);
							oammepInfoBefore.setTstTLVType(oammepInfoBefore.getTstTLVType()==1?0:1);
						}else{
							result = dispath.excuteInsert(oamInfo);
							operationValue = EOperationLogType.SEGMENTOAMTESTSINGINSERT.getValue();
						}
						oamInfo.getOamMep().setLmCycle(oamInfo.getOamMep().getLmCycle()==0?100:11);
						oamInfo.getOamMep().setDmCycle(oamInfo.getOamMep().getDmCycle()==0?100:11);
						oamInfo.getOamMep().setOffLineTestTLV(oamInfo.getOamMep().getOffLineTestTLV()==1?0:1);
						oamInfo.getOamMep().setTstTLVType(oamInfo.getOamMep().getTstTLVType()==1?0:1);
						AddOperateLog.insertOperLog(confirm, operationValue, result, 
								oammepInfoBefore, oamInfo.getOamMep(), ConstantUtil.siteId, oamInfo.getOamMep().getObjNameLog(), "testSegmentOAM");
						DialogBoxUtil.succeedDialog(null, result);
						dispose();
					} catch (Exception e) {
						ExceptionManage.dispose(e,this.getClass());
						dispose();
					}

				}
			}

			@Override
			public boolean checking() {
				return true;
			}
		});
		cancel.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent arg0) {
				dispose();
			}
		});

	}
	
	/**
	 * true/false = 验证不通过/验证通过
	 */
	private boolean checkData() {
		if(this.controller.checkLbTTL()){
			return true;
		}
		if(this.controller.checkCycleTLV()){
			return true;
		}
		if(this.controller.checkCycleTlvLength()){
			return true;
		}
		if(this.controller.checkLocalId()){
			return true;
		}
		if(this.controller.checkremoteId()){
			return true;
		}
		if(this.controller.checkMEL()){
			return true;
		}
		if(this.controller.checkTVLLength()){
			return true;
		}
		if(this.controller.checkTVLData()){
			return true;
		}
		if(this.controller.checkTSTTLVLength()){
			return true;
		}
		return false;
	}

	protected void tip() {
		DialogBoxUtil.errorDialog(this, ResourceUtil.srcStr(StringKeysTip.LBL_NO_PORT));
		return;
		
	}

	private PortInst getPortInst() throws Exception {
		PortInst portInst = null;
		PortService_MB portService = null;
		try {
			portInst = new PortInst();
			portInst.setPortId(oamInfo.getOamMep().getObjId());
			portInst.setSiteId(ConstantUtil.siteId);
			portService = (PortService_MB) ConstantUtil.serviceFactory.newService_MB(Services.PORT);
			portInst = portService.select(portInst).get(0);

		} catch (Exception e) {
			throw e;
		} finally {
			UiUtil.closeService_MB(portService);
		}
		return portInst;
	}

	private void setValue() throws Exception {
		OamMepInfo mepInfo = oamInfo.getOamMep();
		PortInst portInst = getPortInst();
//		comboBoxSelect(portCombox, portInst.getPortId() + "");
		DefaultComboBoxModel boxModel = (DefaultComboBoxModel) portCombox.getModel();
		boxModel.addElement(new ControlKeyValue(portInst.getPortId() + "", portInst.getPortName(), portInst));
		portCombox.setModel(boxModel);
//		portCombox.setSelectedItem(portInst.getPortName());
		portCombox.setEnabled(false);
		this.megGradeField.setText(mepInfo.getMel()+"");
//		this.initValueToId();
//		megIccField.setText(mepInfo.getMegIcc());
//		megUmcField.setText(mepInfo.getMegUmc());
		comboBoxSelect(tcComboBox, mepInfo.getLspTc() + "");
		localField.setText(mepInfo.getLocalMepId() + "");
		remoteField.setText(mepInfo.getRemoteMepId() + "");
		cyclyeEnableCheckBox.setSelected(mepInfo.isRingEnable());
		comboBoxSelect(cyclePeriodComboBox, mepInfo.getRingCycle() + "");
		comboBoxSelect(cycleTestWayCombox, mepInfo.getRingTestWay() + "");
		comboBoxSelect(offLineTestTLVCombox, mepInfo.getOffLineTestTLV()
				+ "");
		cycleTlvLengthField.setText(mepInfo.getRingTLVLength() + "");
		cycleTLVField.setText(mepInfo.getRingTLVInfo() + "");
		if (mepInfo.isRingEnable()) {
			cyclePeriodComboBox.setEnabled(true);
			cycleTestWayCombox.setEnabled(true);
			offLineTestTLVCombox.setEnabled(true);
			cycleTlvLengthField.setEnabled(true);
			cycleTLVField.setEnabled(true);

		}else{
			cyclePeriodComboBox.setEnabled(false);
			cycleTestWayCombox.setEnabled(false);
			offLineTestTLVCombox.setEnabled(false);
			cycleTlvLengthField.setEnabled(false);
			cycleTLVField.setEnabled(false);
		}
		
		tstEnableCheckBox.setSelected(mepInfo.isTstEnable());
		comboBoxSelect(tstPeriodComboBox, mepInfo.getTstCycle() + "");
		comboBoxSelect(tlvTypeComboBox, mepInfo.getTstTLVType() + "");
		tstTLVLengthField.setText(mepInfo.getTstTLVLength() + "");

		if (mepInfo.isTstEnable()) {
			tstPeriodComboBox.setEnabled(true);
			tlvTypeComboBox.setEnabled(true);
			tstTLVLengthField.setEnabled(true);
		}else{
			tstPeriodComboBox.setEnabled(false);
			tlvTypeComboBox.setEnabled(false);
			tstTLVLengthField.setEnabled(false);
		}
		lckCheckBox.setSelected(mepInfo.isLck());
		
		lmCheckBox.setSelected(mepInfo.isLm());
		comboBoxSelect(lmCycleComboBox, mepInfo.getLmCycle() + "");
		if (mepInfo.isLm()) {
			lmCycleComboBox.setEnabled(true);
		}else{
			lmCycleComboBox.setEnabled(false);
		}
		
		dmCheckBox.setSelected(mepInfo.isDm());
		comboBoxSelect(dmCycleComboBox, mepInfo.getDmCycle() + "");
		if (mepInfo.isDm()) {
			dmCycleComboBox.setEnabled(true);
		}else{
			dmCycleComboBox.setEnabled(false);
		}
		
		lbTTLField.setText(mepInfo.getLbTTL()+"");
	}

	private void initValueToId() {
		OamInfoService_MB oamInfoService = null;
		OamInfo oamInfo = null;
		OamMepInfo oamMepInfo = null;
		try {
			oamInfoService = (OamInfoService_MB) ConstantUtil.serviceFactory.newService_MB(Services.OamInfo);
			oamInfo = new OamInfo();
			oamMepInfo = new OamMepInfo();
			oamMepInfo.setSiteId(ConstantUtil.siteId);
			oamMepInfo.setObjId(Integer.parseInt(((ControlKeyValue)this.portCombox.getSelectedItem()).getId()));
			oamMepInfo.setObjType("SECTION");
			oamInfo.setOamMep(oamMepInfo);
			oamInfo = oamInfoService.queryByCondition(oamInfo, OamTypeEnum.AMEP);
			if(oamInfo != null && oamInfo.getOamMep() != null){
				megGradeField.setText(oamInfo.getOamMep().getMel() + "");
			}
		} catch (Exception e) {
			ExceptionManage.dispose(e, this.getClass());
		} finally {
			UiUtil.closeService_MB(oamInfoService);
		}
	}

	private void intalCombox() {
		intalCycleTestWayCombox(cycleTestWayCombox);
		intalOffWayCombox(offLineTestTLVCombox);
		intalTVLCombox(tlvTypeComboBox);
		intalCycleCombox(cyclePeriodComboBox);
		intalCycleCombox(tstPeriodComboBox);
		intalLmAndDmCombox(lmCycleComboBox);
		intalLmAndDmCombox(dmCycleComboBox);
		intalTcAndMel(tcComboBox);
	}

	private void intalCycleTestWayCombox(JComboBox combox) {
		Map<Integer, String> map = new LinkedHashMap<Integer, String>();
		map.put(0, ResourceUtil.srcStr(StringKeysObj.STRING_ONLINE));
		map.put(1, ResourceUtil.srcStr(StringKeysObj.STRING_OFFLINE));
		DefaultComboBoxModel boxModel = (DefaultComboBoxModel) combox
				.getModel();
		for (Integer key : map.keySet()) {
			boxModel.addElement((new ControlKeyValue(key.toString(), map
					.get(key))));
		}
	}

	private void intalLmAndDmCombox(JComboBox combox) {

		Map<Integer, String> map = new LinkedHashMap<Integer, String>();
		map.put(0, "1s");
		map.put(1, "100ms");
		DefaultComboBoxModel boxModel = (DefaultComboBoxModel) combox.getModel();
		for (Integer key : map.keySet()) {
			boxModel.addElement((new ControlKeyValue(key.toString(), map.get(key))));
		}

	}
	
	private void intalCycleCombox(JComboBox combox) {

		Map<Integer, String> map = new LinkedHashMap<Integer, String>();
		map.put(1, "3.33ms");
		map.put(10, "10ms");
		map.put(11, "100ms");
		map.put(100, "1s");
		DefaultComboBoxModel boxModel = (DefaultComboBoxModel) combox
				.getModel();
		for (Integer key : map.keySet()) {
			boxModel.addElement((new ControlKeyValue(key.toString(), map
					.get(key))));
		}

	}
	
	private void intalTcAndMel(JComboBox combox) {
		DefaultComboBoxModel boxModel = (DefaultComboBoxModel) combox.getModel();
		Map<Integer, String> map = new LinkedHashMap<Integer, String>();
		for (int i = 0; i < 8; i++) {
			map.put(i, i + "");
		}

		for (Integer key : map.keySet()) {
			boxModel.addElement((new ControlKeyValue(key.toString(), map.get(key))));
		}

	}
	
	private void intalOffWayCombox(JComboBox combox) {
		Map<Integer, String> map = new LinkedHashMap<Integer, String>();
		map.put(01, ResourceUtil.srcStr(StringKeysObj.STRING_ALL_0));
		map.put(11, ResourceUtil.srcStr(StringKeysObj.STRING_RANDOM));
		DefaultComboBoxModel boxModel = (DefaultComboBoxModel) combox
				.getModel();
		for (Integer key : map.keySet()) {
			boxModel.addElement((new ControlKeyValue(key.toString(), map
					.get(key))));
		}
	}

	private void intalTVLCombox(JComboBox combox) {

		Map<Integer, String> map = new LinkedHashMap<Integer, String>();
		map.put(01, ResourceUtil.srcStr(StringKeysObj.STRING_ALL_0));
		map.put(11, ResourceUtil.srcStr(StringKeysObj.STRING_RANDOM));
		DefaultComboBoxModel boxModel = (DefaultComboBoxModel) combox
				.getModel();
		for (Integer key : map.keySet()) {
			boxModel.addElement((new ControlKeyValue(key.toString(), map
					.get(key))));
		}

	}

	private void collectData() throws Exception {

		OamMepInfo oamMep = null;
//		OamMipInfo oamMip = null;
		if (oamInfo == null) {
			oamInfo = new OamInfo();
			oamInfo.setOamType(OamTypeEnum.AMEP);
			oamMep = new OamMepInfo();
//			oamMip = new OamMipInfo();
			oamInfo.setOamMep(oamMep);
//			oamInfo.setOamMip(oamMip);
		} else {
			oamMep = oamInfo.getOamMep();
//			oamMip = oamInfo.getOamMip();
		}
		
		oamMep.setObjId((Integer.parseInt(((ControlKeyValue) (portCombox.getSelectedItem())).getId())));
		oamMep.setObjNameLog(((ControlKeyValue) (portCombox.getSelectedItem())).getName());
		oamMep.setObjType("SECTION_TEST");
//		if (megIccField.getText().trim() != null)
//			oamMep.setMegIcc(megIccField.getText().trim());
//		if (megUmcField.getText().trim() != null)
//			oamMep.setMegUmc(megUmcField.getText().trim());

		oamMep.setLbTTL(Integer.parseInt(lbTTLField.getText().trim()));
		oamMep.setLocalMepId(Integer.parseInt(localField.getText().trim()));
		oamMep.setRemoteMepId(Integer.parseInt(remoteField.getText().trim()));
		oamMep.setMel(Integer.parseInt(megGradeField.getText().trim()));
		oamMep.setRingEnable(cyclyeEnableCheckBox.isSelected() ? true : false);
		oamMep.setLspTc(Integer.parseInt(((ControlKeyValue) (tcComboBox.getSelectedItem())).getId()));
		if (cyclyeEnableCheckBox.isSelected() || oamInfo.getId()>0) {
			oamMep.setRingCycle((Integer
					.parseInt(((ControlKeyValue) (cyclePeriodComboBox
							.getSelectedItem())).getId())));
			oamMep.setRingTestWay(Integer
					.parseInt(((ControlKeyValue) (cycleTestWayCombox
							.getSelectedItem())).getId()));
			oamMep.setOffLineTestTLV(Integer
					.parseInt(((ControlKeyValue) (offLineTestTLVCombox
							.getSelectedItem())).getId()));
			oamMep.setRingTLVLength(Integer.parseInt(cycleTlvLengthField
					.getText().trim()));
			oamMep.setRingTLVInfo((Integer.parseInt(cycleTLVField.getText()
					.trim())));
		}else{
			//赋默认值
			oamMep.setRingCycle(1);
			oamMep.setRingTestWay(0);
			oamMep.setOffLineTestTLV(11);
			oamMep.setRingTLVLength(1);
			oamMep.setRingTLVInfo(0);
		}

		oamMep.setTstEnable(tstEnableCheckBox.isSelected() ? true : false);
		if (tstEnableCheckBox.isSelected() || oamInfo.getId()>0) {
			oamMep.setTstCycle((Integer
					.parseInt(((ControlKeyValue) (tstPeriodComboBox
							.getSelectedItem())).getId())));
			oamMep.setTstTLVType((Integer
					.parseInt(((ControlKeyValue) (tlvTypeComboBox
							.getSelectedItem())).getId())));
			oamMep.setTstTLVLength(Integer.parseInt(tstTLVLengthField.getText()
					.trim()));
		}else{
			//赋默认值
			oamMep.setTstCycle(1);
			oamMep.setTstTLVType(11);
			oamMep.setTstTLVLength(29);
		}
		
		oamMep.setLck(lckCheckBox.isSelected() ? true : false);
		oamMep.setLm(lmCheckBox.isSelected() ? true : false);
		if (lmCheckBox.isSelected() || oamInfo.getId()>0) {
			oamMep.setLmCycle(Integer.parseInt(((ControlKeyValue) (lmCycleComboBox.getSelectedItem())).getId()));
		}else{
			//赋默认值
			oamMep.setLmCycle(0);
		}
		
		oamMep.setDm(dmCheckBox.isSelected() ? true : false);
		if (dmCheckBox.isSelected() || oamInfo.getId()>0){
			oamMep.setDmCycle(Integer.parseInt(((ControlKeyValue) (dmCycleComboBox.getSelectedItem())).getId()));
		}else{
			//赋默认值
			oamMep.setDmCycle(0);
		}
		oamInfo.getOamMep().setSiteId(ConstantUtil.siteId);

	}

	public void comboBoxSelect(JComboBox jComboBox, String selectId) {
		for (int i = 0; i < jComboBox.getItemCount(); i++) {
			if (((ControlKeyValue) jComboBox.getItemAt(i)).getId().equals(
					selectId)) {
				jComboBox.setSelectedIndex(i);
				return;
			}
		}
	}

	public JTextField getMegGradeField() {
		return megGradeField;
	}

	public void setMegGradeField(JTextField megGradeField) {
		this.megGradeField = megGradeField;
	}

	public JLabel getVertifyLabel() {
		return vertifyLabel;
	}

	public void setVertifyLabel(JLabel vertifyLabel) {
		this.vertifyLabel = vertifyLabel;
	}

	public PtnButton getConfirm() {
		return confirm;
	}

	public void setConfirm(PtnButton confirm) {
		this.confirm = confirm;
	}

	public JButton getCancel() {
		return cancel;
	}

	public void setCancel(JButton cancel) {
		this.cancel = cancel;
	}

	public JTextField getCycleTlvLengthField() {
		return cycleTlvLengthField;
	}

	public void setCycleTlvLengthField(JTextField cycleTlvLengthField) {
		this.cycleTlvLengthField = cycleTlvLengthField;
	}

	public JTextField getCycleTLVField() {
		return cycleTLVField;
	}

	public void setCycleTLVField(JTextField cycleTLVField) {
		this.cycleTLVField = cycleTLVField;
	}

	public JTextField getTstTLVLengthField() {
		return tstTLVLengthField;
	}

	public void setTstTLVLengthField(JTextField tstTLVLengthField) {
		this.tstTLVLengthField = tstTLVLengthField;
	}

	public SectionOamNodeController getController() {
		return controller;
	}

	public void setController(SectionOamNodeController controller) {
		this.controller = controller;
	}

	public JCheckBox getCyclyeEnableCheckBox() {
		return cyclyeEnableCheckBox;
	}

	public void setCyclyeEnableCheckBox(JCheckBox cyclyeEnableCheckBox) {
		this.cyclyeEnableCheckBox = cyclyeEnableCheckBox;
	}

	public JCheckBox getTstEnableCheckBox() {
		return tstEnableCheckBox;
	}

	public void setTstEnableCheckBox(JCheckBox tstEnableCheckBox) {
		this.tstEnableCheckBox = tstEnableCheckBox;
	}

	public JTextField getLbTTLField() {
		return lbTTLField;
	}

	public void setLbTTLField(JTextField lbTTLField) {
		this.lbTTLField = lbTTLField;
	}

	public JTextField getLocalField() {
		return localField;
	}

	public void setLocalField(JTextField localField) {
		this.localField = localField;
	}

	public JTextField getRemoteField() {
		return remoteField;
	}

	public void setRemoteField(JTextField remoteField) {
		this.remoteField = remoteField;
	}
}