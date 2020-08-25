package fx;

import cn.kind.fx.core.FxWeb;

/**
 * @Auther yiliang
 * @Date 2020/8/21 10:26
 * @Description $
 */
public class Main extends FxWeb{

	public static void main(String[] args) {
		browers.setWindowWidth(375);
		browers.setWindowHeight(667);
		createBrowser(args, Main.class);
	}
}
