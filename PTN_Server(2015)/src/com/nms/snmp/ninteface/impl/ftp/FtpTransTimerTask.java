package com.nms.snmp.ninteface.impl.ftp;

import java.io.File;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.List;
import java.util.TimerTask;

import com.nms.snmp.ninteface.impl.config.EMSConvertXml;
import com.nms.snmp.ninteface.impl.config.EquipmentConvertXml;
import com.nms.snmp.ninteface.impl.config.EquipmentHolderConvertXml;
import com.nms.snmp.ninteface.impl.config.FDFrConvertXml;
import com.nms.snmp.ninteface.impl.config.ManagedElementConvertXml;
import com.nms.snmp.ninteface.impl.config.PTPConvertXml;
import com.nms.snmp.ninteface.impl.config.ProtectionGroupConvertXml;
import com.nms.snmp.ninteface.impl.config.SNCConvertXml;
import com.nms.snmp.ninteface.impl.config.TNPConvertXml;
import com.nms.snmp.ninteface.impl.config.TopologicalLinkConvertXml;
import com.nms.ui.manager.ExceptionManage;

/**
 * 每隔24小时上传当天的文件,并且删除7天前的数据
 */
public class FtpTransTimerTask extends TimerTask {
	String[] filePathArr = new String[]{"snmpData\\NRM"};
	String[] fileDeletePathArr = new String[]{"snmpData\\NRM", "snmpData\\PM", "snmpData\\FM"};
	private String collectTime = "";//如: 20140821
//	public FtpTransTimerTask(String time) {
//		this.collectTime = time;
//	}
	
	public FtpTransTimerTask(){
		
	}

	private void getCollectTime() {
		SimpleDateFormat format = new SimpleDateFormat("yyyyMMddHHmmss");
		try {
			this.collectTime = format.format(System.currentTimeMillis()).substring(0, 8);
		} catch (Exception e) {
			ExceptionManage.dispose(e,this.getClass());
		}
	}

	@Override
	public void run() {
		try {
			this.getCollectTime();
			//生成配置文件
			this.createNRMFile();
			//上传当天的文件
			this.transferFile();
			//删除7天前的数据
			this.deleteFile();
		} catch (Exception e) {
			ExceptionManage.dispose(e,this.getClass());
		}
	}

	/**
	 * 生成配置文件
	 */
	private void createNRMFile() {
		new EMSConvertXml().getEMSXml();
		new EquipmentConvertXml().getEquipmentXml();
		new FDFrConvertXml().getFDFrXml();
		new ManagedElementConvertXml().getManagedEquipmentXml();
		new ProtectionGroupConvertXml().getProtectionGroupXml();
		new PTPConvertXml().getPTPxml();
		new SNCConvertXml().getSNCXml();
		new TopologicalLinkConvertXml().getTopologicalLinkXml();
		new EquipmentHolderConvertXml().getEquipmentHolderXml();
		new TNPConvertXml().getTNPXml();
	}

	/**
	 * 上传当天的文件
	 * @throws Exception 
	 */
	private void transferFile() throws Exception {
		List<String> fileList = new ArrayList<String>();
		List<String> transFileList = new ArrayList<String>();
		//获取所有zip文件名
		for (String path : filePathArr) {
			this.getCmFileList(path, fileList, true);	
		}
		//筛选出符合条件的文件上传
		for (String fileName : fileList) {
			if(fileName.contains(this.collectTime)){
				if(!transFileList.contains(fileName)){
					transFileList.add(fileName);
				}
			}
		}
		//调用工具上传文件
		if(transFileList.size() > 0){
			FtpTransFile4SNMP ftp = new FtpTransFile4SNMP(transFileList);
			try {
				ftp.FileTranfer();
			} catch (Exception e) {
				ExceptionManage.dispose(e,this.getClass());
			}
		}else{
			throw new Exception("the NRM File is null");
		}
	}

	/**
	 * 删除7天前的数据
	 */
	private void deleteFile() {
		SimpleDateFormat format = new SimpleDateFormat("yyyyMMdd");
		try {
			long currTimeL = format.parse(this.collectTime).getTime();
			String deleteTimeL = format.format(currTimeL - 7*24*60*60*1000);
			List<String> fileList = new ArrayList<String>();
			//获取所有文件名
			for (String path : fileDeletePathArr) {
				this.getCmFileList(path, fileList, false);	
			}
			//筛选出符合条件的文件并删除
			for (String fileName : fileList) {
				if(fileName.contains(deleteTimeL)){
					File file = new File(fileName);
					if(file.exists()){
						file.delete();
					}
				}
			}
		} catch (ParseException e) {
			ExceptionManage.dispose(e,this.getClass());
		}
	}
	
	private void getCmFileList(String filePath, List<String> fileList, boolean isZip) {
		File dir = new File(filePath);
		File[] fileArr = dir.listFiles();
		if(fileArr != null){
			for (File file : fileArr) {
				String fileName = file.getPath();
				if(!fileList.contains(fileName)){
					if(isZip){
						if(fileName.contains(".zip")){
							fileList.add(fileName);
						}
					}else{
						fileList.add(fileName);
					}
				}
			}
		}
	}
}
