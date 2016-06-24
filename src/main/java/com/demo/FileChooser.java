package com.demo;

import java.io.IOException;

import javax.swing.event.HyperlinkEvent;

import org.eclipse.swt.SWT;
import org.eclipse.swt.events.SelectionAdapter;
import org.eclipse.swt.events.SelectionEvent;
import org.eclipse.swt.widgets.Button;
import org.eclipse.swt.widgets.Display;
import org.eclipse.swt.widgets.FileDialog;
import org.eclipse.swt.widgets.Label;
import org.eclipse.swt.widgets.Shell;
import org.eclipse.swt.widgets.Text;
import org.eclipse.ui.forms.events.HyperlinkAdapter;
import org.eclipse.ui.forms.widgets.FormToolkit;
import org.eclipse.ui.forms.widgets.Hyperlink;

public class FileChooser {
	protected Shell shell;
	private Text fileDirText;
	private Text fileNameText;
	private final FormToolkit formToolkit = new FormToolkit(Display.getDefault());

	/**
	 * Launch the application.
	 * 
	 * @param args
	 */
	public static void main(String[] args) {
		try {
			FileChooser window = new FileChooser();
			window.open();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	/**
	 * Open the window.
	 */
	public void open() {
		Display display = Display.getDefault();
		createContents();
		shell.open();
		shell.layout();
		while (!shell.isDisposed()) {
			if (!display.readAndDispatch()) {
				display.sleep();
			}
		}
	}

	/**
	 * Create contents of the window.
	 */
	protected void createContents() {
		shell = new Shell();
		shell.setSize(450, 300);
		shell.setText("开发异常网");

		Button button = new Button(shell, SWT.NONE);
		button.addSelectionListener(new SelectionAdapter() {
			@Override
			public void widgetSelected(SelectionEvent e) {
				FileDialog fileDialog = new FileDialog(shell);
				fileDialog.setText("chooser");
				fileDialog.open();
				fileDirText.setText(fileDialog.getFilterPath());
				fileNameText.setText(fileDialog.getFileName());
			}
		});
		button.setBounds(213, 77, 72, 22);
		button.setText("浏览");

		Label lblNewLabel = new Label(shell, SWT.NONE);
		lblNewLabel.setBounds(139, 127, 54, 18);
		lblNewLabel.setText("文件路径");

		fileDirText = new Text(shell, SWT.BORDER);
		fileDirText.setBounds(213, 127, 127, 18);

		Label lblNewLabel_1 = new Label(shell, SWT.NONE);
		lblNewLabel_1.setBounds(139, 171, 54, 18);
		lblNewLabel_1.setText("文件名");

		fileNameText = new Text(shell, SWT.BORDER);
		fileNameText.setBounds(215, 168, 127, 18);

		Hyperlink hprlnkNewHyperlink = formToolkit.createHyperlink(shell, "更多详情", SWT.NONE);
		hprlnkNewHyperlink.setBounds(139, 81, 63, 18);
		formToolkit.paintBordersFor(hprlnkNewHyperlink);
		hprlnkNewHyperlink.addHyperlinkListener(new HyperlinkAdapter() {
			public void linkActivated(HyperlinkEvent e) {
				try {
					Runtime.getRuntime()
							.exec("rundll32 url.dll,FileProtocolHandler http://www.devexception.com/j2se/554187.htm/");
				} catch (IOException e1) {
					e1.printStackTrace();
				}

			}

		});
	}
}
