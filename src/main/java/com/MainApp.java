package com;

import org.eclipse.swt.SWT;
import org.eclipse.swt.graphics.Image;
import org.eclipse.swt.widgets.Button;
import org.eclipse.swt.widgets.Display;
import org.eclipse.swt.widgets.Shell;
import org.eclipse.swt.widgets.Text;

public class MainApp {

	public static void main(String[] args) {
		Display display = new Display();
		// 主界面
		Shell shell = new Shell(display);
		shell.setText("权限管理-菜单批量添加");
		shell.setBounds(0, 0, 600, 400);
		shell.setImage(new Image(display, "icons//tools.ico"));
		shell.setLocation(Display.getCurrent().getClientArea().width / 2 - shell.getShell().getSize().x / 2,
				Display.getCurrent().getClientArea().height / 2 - shell.getSize().y / 2);
		// 按钮
		Button button = new Button(shell, SWT.NULL);
		button.setText("测试1");
		button.setBounds(10, 10, 75, 30);
		Text text1 = new Text(shell, SWT.NONE | SWT.BORDER);// 带边框
		text1.setBounds(10, 50, 70, 25);

		shell.open();
		while (!shell.isDisposed()) {
			if (!display.readAndDispatch())
				display.sleep();
		}
		// red.dispose();
		display.dispose();
	}
}
