package cn.kind.fx.core;

import cn.kind.fx.demo.MyController;
import cn.kind.fx.ioc.ApplicationContext;
import cn.kind.fx.ioc.support.AnnotationApplicationContext;
import javafx.application.Application;
import javafx.application.Platform;
import javafx.scene.Scene;
import javafx.scene.paint.Color;
import javafx.scene.web.WebEngine;
import javafx.scene.web.WebView;
import javafx.stage.Stage;

import java.net.URL;
import java.util.Map;

/**
 * @Auther yiliang
 * @Date 2020/8/20 18:06
 * @Description $
 */
public class FxWeb extends Application {

	//ioc上下容器
	public static ApplicationContext context;

	public static Class initClass;

	public static Browers browers = new Browers();

	@Override
	public void start(Stage stage) {
		stage.setTitle(browers.getTitle());
		//浏览器大小和窗口一致
		browers.getWebView().setMaxHeight(browers.getWindowHeight());
		browers.getWebView().setMaxWidth(browers.getWindowWidth());

		URL url = FxWeb.initClass.getClassLoader().getResource(browers.getIndexHtml());


		browers.getWebEngine().load(url.toExternalForm());

		browers.setScene(new Scene(browers.getWebView(), browers.getWindowWidth(), browers.getWindowHeight()));


		Map<String, Object> beans = context.getBeans();

		//插入关于浏览器的几个实例
		beans.put(WebView.class.getName(),browers.getWebView());
		beans.put(WebEngine.class.getName(),browers.getWebEngine());
		beans.put(Scene.class.getName(),browers.getScene());

		context.start();
		//配置fxweb

		FxWebConfig fxWebConfig = new FxWebConfig(context,browers.getWebEngine());


		stage.setScene(browers.getScene());

		//监听关闭窗口事件,保证程序退出
		stage.setOnCloseRequest((e)->{
			Platform.exit();
			System.exit(0);
		});

		stage.show();
	}


	public static void createBrowser(String[] args,Class clazz){
		FxWeb.initClass = clazz;

		//初始化ioc
		FxWeb.context = new AnnotationApplicationContext(clazz);
		launch(args);
	}
}