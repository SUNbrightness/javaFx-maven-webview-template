package fx.util;

import cn.kind.fx.ioc.ApplicationContext;
import cn.kind.fx.ioc.annotation.AutoWire;
import cn.kind.fx.ioc.annotation.Component;
import javafx.application.Platform;
import javafx.scene.web.WebEngine;

/**
 * @Auther yiliang
 * @Date 2020/9/1 12:03
 * @Description $
 */
@Component
public class JavaScriptExe {

	public final String JL = "JL";

	@AutoWire
	private WebEngine webEngine;

	public  void exe(String methodName,String... param){
		StringBuilder exeMethod = new StringBuilder();
		exeMethod.append("window.");
		exeMethod.append(JL);
		exeMethod.append(".");
		exeMethod.append(methodName+"(");
		for (String s : param) {
			exeMethod.append("'");
			exeMethod.append(s);
			exeMethod.append("'");
		}
		exeMethod.append(")");
		System.out.println(exeMethod.toString());


		//想在其他线程中改变 页面 必须使用这种方式
		Platform.runLater(new Runnable() {
			@Override
			public void run() {
				//更新JavaFX的主线程的代码放在此处
				webEngine.executeScript(exeMethod.toString());
			}
		});
	}




}
