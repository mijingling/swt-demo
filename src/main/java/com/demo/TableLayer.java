package com.demo;

import org.eclipse.swt.SWT;
import org.eclipse.swt.events.SelectionAdapter;
import org.eclipse.swt.events.SelectionEvent;
import org.eclipse.swt.layout.GridLayout;
import org.eclipse.swt.widgets.Button;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Display;
import org.eclipse.swt.widgets.FileDialog;
import org.eclipse.swt.widgets.Label;
import org.eclipse.swt.widgets.Shell;
import org.eclipse.swt.widgets.Table;
import org.eclipse.swt.widgets.TableColumn;
import org.eclipse.swt.widgets.TableItem;
import org.eclipse.swt.widgets.Text;

public class TableLayer {
	private static Text text;

	public static void main(String[] args) {
		Display display = Display.getDefault();
		final Shell shell = new Shell(display);
		shell.setSize(534, 388);
		shell.setLocation(Display.getCurrent().getClientArea().width / 2 - shell.getShell().getSize().x / 2,
				Display.getCurrent().getClientArea().height / 2 - shell.getSize().y / 2);
		shell.setText("批量添加菜单");
		shell.setLayout(new GridLayout());
		// 构造一个Composite组件作为文本框和按钮的容器
		Composite composite = new Composite(shell, SWT.NONE);

		// 创建表格，使用SWT.FULL_SELECTION样式，可同时选中一行
		Table table = new Table(composite, SWT.MULTI | SWT.FULL_SELECTION | SWT.CHECK);
		table.setBounds(0, 66, 507, 273);
		table.setHeaderVisible(true);// 设置显示表头
		table.setLinesVisible(true);// 设置显示表格线/*
		// 创建表头的字符串数组
		String[] tableHeader = { "姓名", "性别", "电话", "电子邮件" };
		for (int i = 0; i < tableHeader.length; i++) {
			TableColumn tableColumn = new TableColumn(table, SWT.CENTER);
			tableColumn.setText(tableHeader[i]);
			tableColumn.setWidth(70);
		}

		TableItem item = new TableItem(table, SWT.NONE);
		item.setText(new String[] { "aaa", "vvv", "ccc", "1@1.com" });
		item = new TableItem(table, SWT.NONE);
		item.setText(new String[] { "bbb", "111", "cc222", "1@1.com" });
		item = new TableItem(table, SWT.NONE);
		item.setText(new String[] { "周五", "女", "567", "1@1.com" });

		Button button = new Button(composite, SWT.NONE);
		button.addSelectionListener(new SelectionAdapter() {
			@Override
			public void widgetSelected(SelectionEvent e) {
				FileDialog fileDialog = new FileDialog(shell);
				fileDialog.setText("chooser");
				fileDialog.open();
				text.setText(fileDialog.getFilterPath() + "\\" + fileDialog.getFileName());
			}
		});
		button.setBounds(0, 0, 90, 27);
		button.setText("选择菜单Excel");

		Label label = new Label(composite, SWT.NONE);
		label.setBounds(108, 5, 61, 17);
		label.setText("文件路径：");

		text = new Text(composite, SWT.BORDER);
		text.setBounds(189, 2, 318, 23);

		Button btnNewButton = new Button(composite, SWT.NONE);
		btnNewButton.addSelectionListener(new SelectionAdapter() {
			@Override
			public void widgetSelected(SelectionEvent e) {
			}
		});
		btnNewButton.setBounds(0, 33, 90, 27);
		btnNewButton.setText("存入菜单入库");

		Button btnLocal = new Button(composite, SWT.RADIO);
		btnLocal.setBounds(134, 37, 53, 17);
		btnLocal.setText("local");

		Button button_1 = new Button(composite, SWT.RADIO);
		button_1.setText("rd");
		button_1.setBounds(189, 38, 53, 17);

		Button btnQa = new Button(composite, SWT.RADIO);
		btnQa.setText("qa");
		btnQa.setBounds(246, 38, 53, 17);

		Button btnOnline = new Button(composite, SWT.RADIO);
		btnOnline.setText("online");
		btnOnline.setBounds(305, 38, 53, 17);

		shell.open();
		shell.layout();
		while (!shell.isDisposed()) {
			if (!display.readAndDispatch()) {
				display.sleep();
			}
		}
	}
}
