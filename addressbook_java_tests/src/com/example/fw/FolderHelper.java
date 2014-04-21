package com.example.fw;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.swing.JDialog;

import org.netbeans.jemmy.operators.JButtonOperator;
import org.netbeans.jemmy.operators.JDialogOperator;
import org.netbeans.jemmy.operators.JFrameOperator;
import org.netbeans.jemmy.operators.JLabelOperator;
import org.netbeans.jemmy.operators.JTextFieldOperator;
import org.netbeans.jemmy.operators.JTreeOperator;


public class FolderHelper extends HelperBase{
	
    //private JDialogOperator jDialogOperator;
	
	public FolderHelper(ApplicationManager applicationManager) {
		super (applicationManager);
	}

	public Folders getFolders() {
		List<String> list = new ArrayList<String>();
		JTreeOperator tree = new JTreeOperator(mainFrame);
		Object[] children = tree.getChildren(tree.getRoot());
		for (Object child:children){
			list.add("" + child);
		}
		return new Folders(list);
	}

	public String createFolder(String foldername) {
		manager.getMenuHelper().pushCreateFolder();
		JDialogOperator dialog = new JDialogOperator(mainFrame);
		new JTextFieldOperator(dialog).setText(foldername);
		new JButtonOperator(dialog, "OK").push();
		return  waitMessageDialog("Warning", 3000);
	}

	protected String  waitMessageDialog(String title, int timeout) {
	long start = System.currentTimeMillis();
	long currentTime = start;
	while (currentTime < start + timeout){
		JDialog dialog = JDialogOperator.findJDialog(mainFrame.getOwner(), title, false, false );
		if (dialog != null){
			JDialogOperator  dialogOp = new JDialogOperator(dialog);
			String message = new JLabelOperator(dialogOp).getText();
			dialogOp.requestClose();
			return message;
		}
		try{
			Thread.sleep(500);
		} catch(InterruptedException e) {
			e.printStackTrace();
		}
		currentTime = System.currentTimeMillis(); 
	}		
	return null;
}
	 	
	
}
