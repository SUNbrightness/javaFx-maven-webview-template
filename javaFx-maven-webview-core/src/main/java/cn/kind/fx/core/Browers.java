package cn.kind.fx.core;

import javafx.scene.Scene;
import javafx.scene.web.WebEngine;
import javafx.scene.web.WebView;

/**
 * @Auther yiliang
 * @Date 2020/8/21 11:29
 * @Description $
 */
public class Browers {

	private Scene scene;

	private WebView webView = new WebView();

	private WebEngine webEngine = webView.getEngine();

	private String indexHtml = "html/index.html";

	private String title = "";

	private Integer windowWidth = 900;

	private Integer windowHeight = 600;



	public Scene getScene() {
		return scene;
	}

	public void setScene(Scene scene) {
		this.scene = scene;
	}

	public WebView getWebView() {
		return webView;
	}

	public void setWebView(WebView webView) {
		this.webView = webView;
	}

	public WebEngine getWebEngine() {
		return webEngine;
	}

	public void setWebEngine(WebEngine webEngine) {
		this.webEngine = webEngine;
	}

	public String getIndexHtml() {
		return indexHtml;
	}

	public void setIndexHtml(String indexHtml) {
		this.indexHtml = indexHtml;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public Integer getWindowWidth() {
		return windowWidth;
	}

	public void setWindowWidth(Integer windowWidth) {
		this.windowWidth = windowWidth;
	}

	public Integer getWindowHeight() {
		return windowHeight;
	}

	public void setWindowHeight(Integer windowHeight) {
		this.windowHeight = windowHeight;
	}
}
