package fx.controller;


import cn.kind.fx.ioc.annotation.AutoWire;
import cn.kind.fx.ioc.annotation.JController;
import javafx.application.Platform;
import javafx.scene.web.WebEngine;

/**
 * @Auther yiliang
 * @Date 2020/8/21 09:40
 * @Description $
 */
@JController("J")
public class IndexController {

	@AutoWire
	private WebEngine webEngine;


	public void reloadHtml(){
		System.out.println("reload");
		webEngine.reload();

	}
	public void exit() {
		Platform.exit();
	}

	

}
